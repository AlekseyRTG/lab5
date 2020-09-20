package lab.commands;

import lab.CollectionControl;
import lab.collection.SpaceMarine;
import lab.worker.Response;
import lab.worker.Task;

public class CommandReplaceIfLowe implements Command {
    Command update = new CommandUpdate();
    Command add = new CommandInsert();

    @Override
    public Response executeTask(CollectionControl collectionControl, Task task) {
        String msg;
        SpaceMarine spaceMarine = (SpaceMarine) task.getFirstArgument();
        Long key = (spaceMarine.getId());
        SpaceMarine old = collectionControl.getCollection().get(key);
        if (old == null) {
            add.executeTask(collectionControl, task);
            msg = "Объект добавлен, так как объекта с таким ключом не существовало.";
        } else {
            if (spaceMarine.compareTo(old) < 0)
                msg = update.executeTask(collectionControl, task).getMsg();
            else msg = "Замена не удалась. Предыдущее значение больше нового или равно";
        }
        return new Response(msg);

    }
}
