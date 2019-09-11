package duke.command;

import duke.task.Task;
import duke.util.Storage;
import duke.util.TaskList;
import duke.util.Ui;

import java.util.ArrayList;
import java.util.List;

public class ListByPriorityCommand extends Command {

    /**
     * Executes command to list all {@link Task} in {@link TaskList}
     * by order of priority. Priorities with the smallest integer
     * value are placed on the top.
     *
     * @param tasks Current list of tasks
     * @param ui UI currently in use
     * @param storage Current storage in use
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        List<Task> sortedList = new ArrayList<>();
        for (Task task : tasks.getTasks()) {
            if (task.getPriority() > 0) {
                sortedList.add(task);
            }
        }
        sortedList.sort((t1,t2) -> t1.getPriority() - t2.getPriority());
        ui.showListHeader();
        for (int i = 0; i < sortedList.size(); i++) {
            ui.showPriorityListElement(sortedList.get(i), i);
        }
    }

    /**
     * Checks if {@link Command} is {@link ExitCommand}.
     *
     * @return true if {@link Command} is {@link ExitCommand}
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
