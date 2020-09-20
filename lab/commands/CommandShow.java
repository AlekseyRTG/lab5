package lab.commands;

import lab.CollectionControl;
import lab.collection.SpaceMarine;
import lab.worker.Response;
import lab.worker.Task;

public class CommandShow implements Command {
    @Override
    public Response executeTask(CollectionControl collectionControl, Task task) {
        StringBuilder msg;
        if (collectionControl.getCollection().size() == 0) {
            msg = new StringBuilder("Коллекция пуста");
        } else {
            msg = new StringBuilder("Список коллекции:\n");
            for (SpaceMarine spaceMarine : collectionControl.getCollection().values()) {
                msg.append(spaceMarine.toString()).append("\n");
            }
        }
        return new Response(msg.toString());
    }
}
