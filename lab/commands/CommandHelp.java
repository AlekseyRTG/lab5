package lab.commands;

import lab.CollectionControl;
import lab.worker.Response;
import lab.worker.Task;

public class CommandHelp implements Command {
    @Override
    public Response executeTask(CollectionControl collectionControl, Task task) {
        String msg = "Доступные команды:\n";
        for (CommandType commandType : CommandType.values()) {
            msg = msg + commandType.getHelp() + "\n";
        }
        return new Response(msg);
    }
}
