package lab.commands;

import lab.CollectionControl;
import lab.worker.Task;
import lab.worker.Response;

/**
 * Интерфейс обработчика команды.
 */
public interface Command {
    Response executeTask(CollectionControl collectionControl, Task task);

}
