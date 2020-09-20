package lab.commands;

import lab.CollectionControl;
import lab.worker.Response;
import lab.worker.Task;
import lab.worker.TaskWorker;

import java.util.ArrayList;

public class CommandExecuteScript implements Command {
    TaskWorker taskWorker;

    public CommandExecuteScript(TaskWorker taskWorker) {
        this.taskWorker = taskWorker;
    }

    @Override
    public Response executeTask(CollectionControl collectionControl, Task task) {
        String msg = "";
        ArrayList<Task> taskList = (ArrayList<Task>) task.getFirstArgument();
        for (Task littleTask : taskList) {
            msg = msg + taskWorker.executeTask(littleTask).getMsg();
        }
        return new Response(msg);
    }
}
