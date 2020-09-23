package lab.commands;

import lab.CollectionControl;
import lab.collection.Product;
import lab.worker.Response;
import lab.worker.Task;

import java.util.LinkedList;

public class CommandAddIfMin implements Command {
    @Override
    public Response executeTask(CollectionControl collectionControl, Task task) {

            LinkedList<Product> products = collectionControl.getCollection();
                if (products.size() != 0) {
                    Product addProduct = (Product) task.getFirstArgument();
                    Product minElem = products.stream().min(Product::compareTo).get();
                    if (addProduct.compareTo(minElem) < 0) {
                        Command add = new CommandAdd();
                        return  add.executeTask(collectionControl,new Task(CommandType.ADD, addProduct));
                    } else return new Response("Элемент не минимальный!");
                } else return new Response("Коллекция пуста, минимальный элемент отсутствует.");

    }

}
