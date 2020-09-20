package lab.commands;

import lab.CollectionControl;
import lab.worker.Response;
import lab.worker.Task;

public class CommandClear implements Command {
    @Override
    public Response executeTask(CollectionControl collectionControl, Task task) {
        String msg;
        if (collectionControl.getCollection().size() == 0) {
            msg = "Коллекция пуста";
        } else {
            collectionControl.getCollection().clear();
            msg = "Коллекция очищена";
        }
        return new Response(msg);
    }
}
