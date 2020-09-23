package lab.worker;

import lab.CollectionControl;
import lab.commands.*;

import java.util.HashMap;

/**
 * Класс обработки заданий.
 */
public class TaskWorker {
    CollectionControl collectionControl;
    HashMap<CommandType, Command> commandList = new HashMap<>();

    {
        commandList.put(CommandType.CLEAR, new CommandClear());
        commandList.put(CommandType.EXECUTE_SCRIPT, new CommandExecuteScript(this));
        commandList.put(CommandType.HELP, new CommandHelp());
        commandList.put(CommandType.ADD, new CommandAdd());
        commandList.put(CommandType.PRINT_DESCENDING, new CommandPrintDescending());
        commandList.put(CommandType.REMOVE_BY_ID, new CommandRemoveById());
        commandList.put(CommandType.SAVE, new CommandSave());
        commandList.put(CommandType.UPDATE, new CommandUpdate());
        commandList.put(CommandType.SHOW, new CommandShow());
        commandList.put(CommandType.REMOVE_LOWER, new RemoveLower());
        commandList.put(CommandType.INFO, new CommandInfo());
        commandList.put(CommandType.ADD_IF_MIN, new CommandAddIfMin());
        commandList.put(CommandType.MAX_BY_ID, new CommandMaxById());
    }

    public TaskWorker(CollectionControl collectionControl) {
        this.collectionControl = collectionControl;
    }

    /**
     * Выполняет задание.
     *
     * @param task Задание, сформированное из команды.
     * @return Ответ, результат выполнения.
     */
    public Response executeTask(Task task) {
        CommandType commandType = task.getType();
        Command command = commandList.get(commandType);
        Response response = command.executeTask(collectionControl, task);
        return response;
    }
}
