package lab.worker;

//import com.google.gson.Gson;

import lab.collection.Product;
import lab.collection.ProductGenerator;
import lab.collection.ReadCSV;
import lab.commands.CommandType;

import java.util.ArrayList;

/**
 * Класс, работающий с командами из консоли.
 */
public class TaskManager {
    private static final int HISTORY_SIZE = 7;
    private final String[] taskHistory = new String[HISTORY_SIZE];

    /**
     * Обновляет исхорию команд пользователя.
     *
     * @param newElement Команда, которую нужно добавить в историю.
     */

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
                case "max_by_id":
                    task = new Task(CommandType.MAX_BY_ID);
                    break;
                case "history":
                    getHistory();
                    break;
                case "exit":
                    System.exit(0);
                    break;
                case "print_descending":
                    task = new Task(CommandType.PRINT_DESCENDING);
                    break;
                case "add":
                    if (!isScriptCommand) {
                        Product product = ProductGenerator.generate();
                        if (product != null) {
                            task = new Task(CommandType.ADD, product);
                        }
                    } else {
                         Product productA = ReadCSV.toCSV(stringTask.trim().split(" ", 2)[1].trim().split(" ")[0]);
                            if (ProductGenerator.checkProduct(productA)) {
                                task = new Task(CommandType.ADD, productA);
                            }
                    }
                    break;
                case "update":
                    Integer updateId = null;
                    try {
                        updateId = Integer.parseInt(stringTask.trim().split(" ", 2)[1].trim().split(" ")[0]);
                        if (!isScriptCommand) {
                            Product updateProduct = ProductGenerator.generate();
                            if (updateId != null && updateProduct != null) {
                                updateProduct.setId(updateId);
                                task = new Task(CommandType.UPDATE, updateProduct);
                            }
                        } else {
                            Product productU = ReadCSV.toCSV(stringTask.trim().split(" ", 2)[1].trim().split(" ")[1]);
                            if (ProductGenerator.checkProduct(productU)) {
                                productU.setId(updateId);
                                task = new Task(CommandType.UPDATE, productU);
                            }
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка ввода числа (id)");
                    }
                    break;
                case "remove_by_id":
                    Long removeId = null;
                    try {
                        removeId = Long.parseLong(stringTask.trim().split(" ", 2)[1].trim().split(" ")[0]);
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка ввода числа (id)");
                    }
                    if (removeId != null) {
                        task = new Task(CommandType.REMOVE_BY_ID, removeId);
                    }
                    break;
                case "add_if_min":
                    if (!isScriptCommand) {
                        Product product = ProductGenerator.generate();
                        if (product != null) {
                            task = new Task(CommandType.ADD_IF_MIN, product);
                        }
                    } else {
                        Product product = ReadCSV.toCSV(stringTask.trim().split(" ", 2)[1].trim().split(" ")[0]);
                        if (ProductGenerator.checkProduct(product))
                            task = new Task(CommandType.ADD, product);
                    }
                    break;
                case "remove_lower":
                    if (!isScriptCommand) {
                        Product product = ProductGenerator.generate();
                        if (product != null) {
                            task = new Task(CommandType.REMOVE_LOWER, product);
                        }
                    } else {
                        Product product = ReadCSV.toCSV(stringTask.trim().split(" ", 2)[1].trim().split(" ")[0]);
                        if (ProductGenerator.checkProduct(product))
                            task = new Task(CommandType.REMOVE_LOWER, product);
                    }

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
        } catch (Exception e) {
            System.out.println("Произошла ошибка");
        }
        return task;
    }
}
