package duke.command;

import duke.util.Storage;
import duke.util.TaskList;
import duke.util.Ui;
import duke.exception.EmptyDescriptionException;
import duke.task.Task;
import java.io.IOException;
import java.text.ParseException;

public class DeleteCommand extends Command {
    private int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    /**
     * Deletes a singular task from current task list and updates the task
     * list in the external file.
     *
     * @param tasks Current list of tasks
     * @param ui UI being used
     * @param storage Current storage in use
     * @throws IOException Error with accessing file or file writer
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage)
            throws IOException {
        ui.showDeleteMessage(tasks.delete(index), tasks);
        storage.saveTaskList(tasks);
    }

    /**
     * Tests Exit Command.
     *
     * @return Whether command is an Exit Command.
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
