package lab.commands;

import lab.CollectionControl;
import lab.worker.Response;
import lab.worker.Task;

public class CommandRemoveKey implements Command {
    @Override
    public Response executeTask(CollectionControl collectionControl, Task task) {
        String msg;
        int startSize = collectionControl.getCollection().size();
        collectionControl.getCollection().remove(task.getFirstArgument());
        if (startSize == collectionControl.getCollection().size())
            msg = "Элемент коллекции не был удалён.Возможно, он не существует.";
        else msg = "Элемент коллекции был удалён.";
        return new Response(msg);
    }
}
