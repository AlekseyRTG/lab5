package lab.commands;

import lab.CollectionControl;
import lab.collection.Product;
import lab.worker.Response;
import lab.worker.Task;

import java.util.ArrayList;
import java.util.Comparator;

public class CommandPrintDescending implements Command {
    @Override
    public Response executeTask(CollectionControl collectionControl, Task task) {
        StringBuilder msg;
        if (collectionControl.getCollection().size() == 0) {
            msg = new StringBuilder("Коллекция пуста");
        } else {
            msg = new StringBuilder("Сортировка по убыванию:\n");
            msg.append("id --- поле Price (цена) --- имя\n");
            ArrayList<Product> collection = new ArrayList(collectionControl.getCollection());
            collection.sort(Product::compareTo);
            for (Product product : collection) {
                msg.append(product.getId()).append(" --- ").append(product.getCreationDate()).append(" --- ").append(product.getName()).append("\n");
            }
        }
        return new Response(msg.toString());
    }
}
