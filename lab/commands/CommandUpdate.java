package lab.commands;

import lab.CollectionControl;
import lab.collection.Product;
import lab.worker.Response;
import lab.worker.Task;

public class CommandUpdate implements Command {
    @Override
    public Response executeTask(CollectionControl collectionControl, Task task) {
        String msg;
        Product product = (Product) task.getFirstArgument();
        int id = (product.getId());
        Command comr = new CommandRemoveById();
        int startSize = collectionControl.getCollection().size();
        comr.executeTask(collectionControl,new Task(CommandType.REMOVE_BY_ID,id));
        if (startSize == collectionControl.getCollection().size()) msg = "Элемента с id " + id + " не существует";
        else {
            collectionControl.getCollection().add(product);
            msg = "Элемент изменён";
        }
        return new Response(msg);
    }

}
