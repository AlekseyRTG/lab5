package lab.commands;

import lab.CollectionControl;
import lab.collection.Product;
import lab.worker.Response;
import lab.worker.Task;

import java.util.ArrayList;

public class CommandMaxById implements Command {
    @Override
    public Response executeTask(CollectionControl collectionControl, Task task) {
        String msg;
        if (collectionControl.getCollection().size() == 0) {
            msg = "Коллекция пуста";
        } else {
            ArrayList<Product> collection = new ArrayList(collectionControl.getCollection());
            Product maxP = collection.get(0);
            for (Product product : collection) {
                if (product.getId() > maxP.getId()) maxP = product;

            }
            msg = "Элемент с минимальным id:\n"+maxP.toString();
        }
        return new Response(msg.toString());
    }
}
