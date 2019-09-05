package duke.command;

import duke.util.Storage;
import duke.util.TaskList;
import duke.util.Ui;
import java.io.IOException;

public class ExitCommand extends Command {
    /**
     * Exits the program and saves list into current storage.
     *
     * @param tasks Current list of tasks
     * @param ui UI being used
     * @param storage Current storage in use
     * @throws IOException Error with accessing file or file writer
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws IOException {
        storage.close();
        ui.showClosingMessage();
    }

    /**
     * Tests if command is exit command.
     *
     * @return Whether command is an exit command.
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
