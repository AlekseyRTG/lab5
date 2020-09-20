package lab.commands;

import lab.CollectionControl;
import lab.collection.SpaceMarine;
import lab.worker.Response;
import lab.worker.Task;

public class CommandInsert implements Command {
    @Override
    public Response executeTask(CollectionControl collectionControl, Task task) {
        String msg;
        SpaceMarine spaceMarine = (SpaceMarine) task.getFirstArgument();
        Long key = (spaceMarine.getId());
        int startSize = collectionControl.getCollection().size();
        collectionControl.getCollection().put(key, spaceMarine);
        if (startSize == collectionControl.getCollection().size())
            msg = "Ошибка добавления элемента, Возможно, элемент с таким id ("+key+") уже существует. ";
        else msg = "Элемент успешно добавлен";
        return new Response(msg);
    }
}
