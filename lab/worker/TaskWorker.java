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
        commandList.put(CommandType.GROUP_COUNTING_BY_CREATION_DATE, new CommandGroup());
        commandList.put(CommandType.HELP, new CommandHelp());
        commandList.put(CommandType.INSERT, new CommandInsert());
        commandList.put(CommandType.PRINT_ASCENDING, new CommandPrintAscending());
        commandList.put(CommandType.PRINT_FIELD_DESCENDING_MELEE_WEAPON, new CommandPrintWeapon());
        commandList.put(CommandType.REMOVE_KEY, new CommandRemoveKey());
        commandList.put(CommandType.REPLACE_IF_LOWE, new CommandReplaceIfLowe());
        commandList.put(CommandType.SAVE, new CommandSave());
        commandList.put(CommandType.UPDATE, new CommandUpdate());
        commandList.put(CommandType.SHOW, new CommandShow());
        commandList.put(CommandType.REMOVE_GREATER_KEY, new RemoveGreaterKey());
        commandList.put(CommandType.INFO, new CommandInfo());
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
