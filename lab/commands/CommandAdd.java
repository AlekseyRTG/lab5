package lab.commands;

import lab.CollectionControl;
import lab.collection.Product;
import lab.worker.Response;
import lab.worker.Task;

public class CommandAdd implements Command {
    @Override
    public Response executeTask(CollectionControl collectionControl, Task task) {
        String msg;
        Product product = (Product) task.getFirstArgument();
        product.setId(collectionControl.idGenerate());
        int startSize = collectionControl.getCollection().size();
        collectionControl.getCollection().add(product);
        if (startSize == collectionControl.getCollection().size())
            msg = "Ошибка добавления элемента. ";
        else msg = "Элемент успешно добавлен";
        return new Response(msg);
    }
}
