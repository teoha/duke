package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

import java.io.IOException;

public class ListCommand extends Command{
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
