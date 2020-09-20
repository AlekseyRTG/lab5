package lab.worker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Класс для работы со скриптами из фалов.
 */
public class ScriptReader {
    private final TaskManager taskManager = new TaskManager();
    private final Stack<String> scripStack = new Stack();
    private File currentFile;

    /**
     * Проверяет файл на пригодность к использвоанию.
     *
     * @param filePath Путь к файлу.
     * @return Файл.
     */
    private File checkFile(String filePath) {
        File script = new File(filePath);

        if (!script.exists() || !script.isFile()) {
            System.out.println(("Файл по  пути " + script.getAbsolutePath() + " не существует."));
            return null;
        }
        if (!script.canRead()) {
            System.out.println("Файл защищён от чтения.");
            return null;
        }
        if (script.length() == 0) {
            System.out.println("Скрипт не содержит команд.");
            return null;
        }
        return script;
    }

    /**
     * Считывает команды из файла.
     *
     * @param filePath Путь к файлу.
     * @return Коллекция команд.
     */
    public ArrayList<Task> read(String filePath) {
        ArrayList<Task> taskList = new ArrayList<>();
        File script = checkFile(filePath);
        try (BufferedReader scriptReader = new BufferedReader(new FileReader(script))) {
            System.out.println("Анализ файла " + script.getAbsolutePath());
            String scriptCommand = scriptReader.readLine();
            while (scriptCommand != null) {
                currentFile = script;
                if (commandCheck(scriptCommand)) {
                    if (scripStack.search(script.getAbsolutePath()) != -1) {
                        System.out.println("Обнаружена рекурсия вызова скриптов:");
                        for (String file : scripStack) System.out.println("---> " + file);
                        System.out.println("---> " + script.getAbsolutePath());
                        scripStack.clear();
                        return null;
                    }
                    scripStack.add(script.getAbsolutePath());
                    ArrayList add = read(getAddressScript(relativeToAbsolutePath(scriptCommand)));
                    if (add != null) taskList.addAll(add);
                    else return null;
                    scripStack.remove(script);
                } else {
                    Task task = taskManager.getTask(scriptCommand,true);
                    if (task != null) taskList.add(task);
                }
                scriptCommand = scriptReader.readLine();
            }
        } catch (IOException e) {
            return null;
        }
        return taskList;
    }

    /**
     * Выделяет путь к скрипту из команды в случае вызова скрипта из скрипта.
     *
     * @param command Команда.
     * @return путь к скрипту.
     */
    private String getAddressScript(String command) {
        String[] trimScriptCommand;
        trimScriptCommand = command.trim().split(" ", 2);
        return trimScriptCommand[1];
    }

    /**
     * Проперяет команду из скрипта на вызов нового скрипта.
     *
     * @param command Команда.
     * @return Результат проверки.
     */
    private boolean commandCheck(String command) {
        if (command != null) {
            String[] trimScriptCommand;
            trimScriptCommand = command.trim().split(" ", 2);
            return trimScriptCommand[0].equals("execute_script");
        }
        return false;
    }

    /**
     * определяет абсолютный путь к скрипту из команды в случае вызова скрипта из скрипта.
     * @param nextExecute Адрес нового скрипта.
     * @return Абсолютыный путь.
     */
    private String relativeToAbsolutePath(String nextExecute) {
        String nextFilePath = nextExecute.trim().split(" ", 2)[1];
        if (nextFilePath != null) {
            File nextFile = new File(nextFilePath);
            if (!nextFile.isAbsolute()) {
                String newExecute = "execute_script " + currentFile.getAbsolutePath().replace(currentFile.getName(), nextFile.getPath());
                return newExecute;
            }
        }
        return nextExecute;
    }
}
