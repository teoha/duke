package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;
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
     * Deletes a singular task from current task list.
     *
     * @param tasks Current list of tasks
     * @param ui UI being used
     * @param storage Current storage in use
     * @throws IOException Error with accessing file or file writer
     * @throws EmptyDescriptionException Error when no description is provided
     * @throws ParseException Error when incorrect format for date is used
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage)
            throws IOException, EmptyDescriptionException, ParseException {
        Task task = tasks.getByIndex(index);
        tasks.delete(index);
        ui.showDeleteMessage(task, tasks);
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
