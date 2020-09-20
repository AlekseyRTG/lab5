package lab.commands;

import lab.CollectionControl;
import lab.collection.SpaceMarine;
import lab.worker.Response;
import lab.worker.Task;

import java.util.ArrayList;
import java.util.Comparator;

public class CommandPrintWeapon implements Command {
    @Override
    public Response executeTask(CollectionControl collectionControl, Task task) {
        StringBuilder msg;
        if (collectionControl.getCollection().size() == 0) {
            msg = new StringBuilder("Коллекция пуста");
        } else {
            msg = new StringBuilder("Сортировка по Melee Weapon:\n");
            msg.append("id --- Melee Weapon --- имя\n");
            ArrayList<SpaceMarine> collection = new ArrayList(collectionControl.getCollection().values());
            collection.sort(Comparator.comparing(SpaceMarine::getMeleeWeapon));
            for (SpaceMarine spaceMarine : collection) {
                msg.append(spaceMarine.getId()).append(" --- ").append(spaceMarine.getMeleeWeapon()).append(" --- ").append(spaceMarine.getName()).append("\n");
            }
        }
        return new Response(msg.toString());
    }
}
