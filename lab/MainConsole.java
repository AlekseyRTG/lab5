package lab;

import lab.worker.Response;
import lab.worker.Task;
import lab.worker.TaskManager;
import lab.worker.TaskWorker;

import java.util.Scanner;

/**
 * Main-класс
 */
public class MainConsole {
    /**
     * Стартовая точка программы. Считывает путь к файлу из переменной окружения и запускает обработчик команд.
     *
     * @param args Аргументы командной строки (не спользуются)
     */
    public static void main(String[] args) {
        System.out.println("Проверка переменой окружения LabFile");
        String file = System.getenv("LabFile");
        System.out.println("Путь, заданный в переменной окружения LabFile: " + file);
        if (file == null) {
            System.out.println("Переменная окружения LabFile не была задана.");
            return;
        }
        System.out.println("Загрузка коллекции из файла: " + file);
        CollectionControl collectionControl = new CollectionControl();
        if (collectionControl.loadCollection(file)) {
            System.out.println("Запуск программы");
            TaskWorker taskWorker = new TaskWorker(collectionControl);
            TaskManager taskManager = new TaskManager();
            Scanner scanner = new Scanner(System.in);
            System.out.print("->>");
            while (scanner.hasNext()) {

                String stringTask = scanner.nextLine();
                Task task = taskManager.getTask(stringTask, false);
                if (task != null) {
                    Response response = taskWorker.executeTask(task);
                    if (response != null)
                        System.out.println(response.getMsg());
                }
                System.out.print("->>");
            }
            System.out.println("Работа программы завершена");
        }
    }
}
