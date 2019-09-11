package duke.command;

import duke.util.Storage;
import duke.util.TaskList;
import duke.util.Ui;
import java.io.IOException;

/**
 * Executes command to list all tasks in tasklist.
 *
 * @param tasks Current list of tasks
 * @param ui UI being used
 * @param storage Current storage in use
 * @throws IOException Error with accessing file or file writer
 */
public class ListCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws IOException {
        ui.showListHeader();
        for (int i = 0; i < tasks.listSize(); i++) {
            ui.showListElement(tasks.getByIndex(i), i);
        }
    }

    /**
     * Tests if command is exit command.
     *
     * @return Returns true if command is exif command
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
