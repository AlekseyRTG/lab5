package lab.worker;

import com.google.gson.Gson;
import lab.collection.SpaceMarine;
import lab.collection.SpaceMarineGenerator;
import lab.commands.CommandType;

import java.util.ArrayList;

/**
 * Класс, работающий с командами из консоли.
 */
public class TaskManager {
    private static final int HISTORY_SIZE = 7;
    private final String[] taskHistory = new String[HISTORY_SIZE];
    Gson gson = new Gson();

    /**
     * Обновляет исхорию команд пользователя.
     *
     * @param newElement Команда, которую нужно добавить в историю.
     */
    private void updateHistory(String newElement) {
        for (int i = HISTORY_SIZE - 1; i >= 1; i--) {
            taskHistory[i] = taskHistory[i - 1];
        }
        taskHistory[0] = newElement;
    }

    /**
     * Выводит историю команд пользователя.
     */
    private void getHistory() {
        System.out.println("История запросов:");
        for (String element : taskHistory) {
            if (element != null)
                System.out.println(element);
        }
    }

    /**
     * Расшифровыывет команду пользователя и формирует задание.
     *
     * @param stringTask Команда пользователя в строковом представлениию
     * @return Задание программе.
     */
    public Task getTask(String stringTask, boolean isScriptCommand) {
        Task task = null;
        String command = stringTask.trim().split(" ", 2)[0];
        updateHistory(command);
        try {
            switch (command) {
                case "help":
                    task = new Task(CommandType.HELP);
                    break;
                case "info":
                    task = new Task(CommandType.INFO);
                    break;
                case "show":
                    task = new Task(CommandType.SHOW);
                    break;
                case "clear":
                    task = new Task(CommandType.CLEAR);
                    break;
                case "save":
                    task = new Task(CommandType.SAVE);
                    break;
                case "history":
                    getHistory();
                    break;
                case "exit":
                    System.exit(0);
                    break;
                case "group_counting_by_creation_date":
                    task = new Task(CommandType.GROUP_COUNTING_BY_CREATION_DATE);
                    break;
                case "print_ascending":
                    task = new Task(CommandType.PRINT_ASCENDING);
                    break;
                case "print_field_descending_melee_weapon":
                    task = new Task(CommandType.PRINT_FIELD_DESCENDING_MELEE_WEAPON);
                    break;
                case "insert":
                    Long id = null;
                    try {
                        id = Long.parseLong(stringTask.trim().split(" ", 2)[1].trim().split(" ")[0]);

                        if (!isScriptCommand) {
                            SpaceMarine spaceMarine = SpaceMarineGenerator.generate();
                            if (id != null && spaceMarine != null) {
                                spaceMarine.setId(id);
                                task = new Task(CommandType.INSERT, spaceMarine);
                            }
                        } else {
                            SpaceMarine spaceMarine = gson.fromJson(stringTask.trim().split(" ", 2)[1].trim().split(" ")[1], SpaceMarine.class);
                            if (SpaceMarineGenerator.checkSpaceMarine(spaceMarine))
                                task = new Task(CommandType.INSERT, spaceMarine);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка ввода числа (id)");
                    }
                    break;
                case "update":
                    Long updateId = null;
                    try {
                        updateId = Long.parseLong(stringTask.trim().split(" ", 2)[1].trim().split(" ")[0]);
                        if (!isScriptCommand) {
                            SpaceMarine updateSpaceMarine = SpaceMarineGenerator.generate();
                            if (updateId != null && updateSpaceMarine != null) {
                                updateSpaceMarine.setId(updateId);
                                task = new Task(CommandType.UPDATE, updateSpaceMarine);
                            }
                        } else {
                            SpaceMarine spaceMarine = gson.fromJson(stringTask.trim().split(" ", 2)[1].trim().split(" ")[1], SpaceMarine.class);
                            if (SpaceMarineGenerator.checkSpaceMarine(spaceMarine))
                                spaceMarine.setId(updateId);
                            task = new Task(CommandType.UPDATE, spaceMarine);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка ввода числа (id)");
                    }
                    break;
                case "remove_key":
                    Long removeId = null;
                    try {
                        removeId = Long.parseLong(stringTask.trim().split(" ", 2)[1].trim().split(" ")[0]);
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка ввода числа (id)");
                    }
                    if (removeId != null) {
                        task = new Task(CommandType.REMOVE_KEY, removeId);
                    }
                    break;
                case "remove_greater_key":
                    Long gRemoveId = null;
                    try {
                        gRemoveId = Long.parseLong(stringTask.trim().split(" ", 2)[1]);
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка ввода числа (id)");
                    }
                    if (gRemoveId != null) {
                        task = new Task(CommandType.REMOVE_GREATER_KEY, gRemoveId);
                    }
                    break;
                case "replace_if_lowe":
                    Long replaceId = null;
                    try {
                        replaceId = Long.parseLong(stringTask.trim().split(" ", 2)[1].trim().split(" ")[0]);

                        if (!isScriptCommand) {
                            SpaceMarine replaceSpaceMarine = SpaceMarineGenerator.generate();
                            if (replaceId != null && replaceSpaceMarine != null) {
                                replaceSpaceMarine.setId(replaceId);
                                task = new Task(CommandType.REPLACE_IF_LOWE, replaceSpaceMarine);
                            }
                        } else {
                            SpaceMarine spaceMarine = gson.fromJson(stringTask.trim().split(" ", 2)[1].trim().split(" ")[1], SpaceMarine.class);
                            if (SpaceMarineGenerator.checkSpaceMarine(spaceMarine))
                                spaceMarine.setId(replaceId);
                            task = new Task(CommandType.REPLACE_IF_LOWE, spaceMarine);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка ввода числа (id)");
                    }
                    break;
                case "execute_script":
                    String file = stringTask.trim().split(" ", 2)[1];
                    ScriptReader scriptReader = new ScriptReader();
                    ArrayList<Task> taskList = scriptReader.read(file);
                    if (taskList != null) {
                        task = new Task(CommandType.EXECUTE_SCRIPT, taskList);
                    }
                    break;
                default:
                    System.out.println("Команда " + command + " неопознана. Введите 'help' для получения списка команд");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Команда " + command + " требует аргумент");
        }
        return task;
    }
}
