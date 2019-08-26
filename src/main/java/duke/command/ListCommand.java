package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

import java.io.IOException;

public class ListCommand extends Command{
    /**
     * Executes command to list all tasks in tasklist.
     * @param tasks Current list of tasks
     * @param ui UI being used
     * @param storage Current storage in use
     * @throws IOException Error with accessing file or file writer
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws IOException {
        ui.showListHeader();
        for (int i = 0; i < tasks.listSize(); i++) {
            ui.showListElement(tasks.getByIndex(i), i);
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
