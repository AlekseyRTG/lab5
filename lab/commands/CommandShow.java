package lab.commands;

import lab.CollectionControl;
import lab.collection.Product;
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
            for (Product product : collectionControl.getCollection()) {
                msg.append(product.toString()).append("\n");
            }
        }
        return new Response(msg.toString());
    }
}
