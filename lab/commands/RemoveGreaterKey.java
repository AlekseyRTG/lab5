package lab.commands;

import lab.CollectionControl;
import lab.worker.Response;
import lab.worker.Task;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class RemoveGreaterKey implements Command {
    @Override
    public Response executeTask(CollectionControl collectionControl, Task task) {
        long key = (long) task.getFirstArgument();
        int startSize = collectionControl.getCollection().size();
        ArrayList<Long> keys = collectionControl.getCollection().keySet().stream().filter(o -> o > key).collect(Collectors.toCollection(ArrayList::new));
        for (Long keyy : keys) collectionControl.getCollection().remove(keyy);
        return new Response("Было удалено " + (startSize - collectionControl.getCollection().size()) + " элементов.");
    }
}
