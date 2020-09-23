package lab.commands;

import lab.CollectionControl;
import lab.collection.Product;
import lab.worker.Response;
import lab.worker.Task;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class RemoveLower implements Command {
    @Override
    public Response executeTask(CollectionControl collectionControl, Task task) {
        LinkedList<Product> products = collectionControl.getCollection();
        int startSize = products.size();
        if (startSize != 0) {
            products.removeAll((products.parallelStream().filter(product -> 0 < product.compareTo((Product)task.getFirstArgument()))).collect(Collectors.toCollection(LinkedList::new)));
            return new Response("Удалено " + (startSize - products.size()) + " элементов");
        } else return new Response("Коллекция пуста"); }
}
