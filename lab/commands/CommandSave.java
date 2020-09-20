package lab.commands;

import lab.CollectionControl;
import lab.worker.Response;
import lab.worker.Task;

public class CommandSave implements Command {
    @Override
    public Response executeTask(CollectionControl collectionControl, Task task) {
        if (collectionControl.saveCollection())
            return new Response("Коррекция успешно сохранена");
        else return new Response("Ошибка сохранения коллекции");
    }
}
