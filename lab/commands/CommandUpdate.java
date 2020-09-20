package lab.commands;

import lab.CollectionControl;
import lab.collection.SpaceMarine;
import lab.worker.Response;
import lab.worker.Task;

public class CommandUpdate implements Command {
    @Override
    public Response executeTask(CollectionControl collectionControl, Task task) {

        String msg;
        SpaceMarine spaceMarine = (SpaceMarine) task.getFirstArgument();
        Long key = (spaceMarine.getId());
        if (collectionControl.getCollection().get(key) == null) msg = "Элемента с id " + key + " не существует";
        else {
            msg = "Элемент изменён";
            collectionControl.getCollection().replace(key, spaceMarine);
        }
        return new Response(msg);
    }

}
