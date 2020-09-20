package lab.commands;

import lab.CollectionControl;
import lab.worker.Response;
import lab.worker.Task;

public class CommandGroup implements Command {
    @Override
    public Response executeTask(CollectionControl collectionControl, Task task) {
        String msg;
        if (collectionControl.getCollection().size() == 0) {
            msg = "Коллекция пуста";
        } else {
            msg = "";
        }
        return new Response(msg);
    }
}

