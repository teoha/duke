package duke.command;

import duke.util.Storage;
import duke.util.TaskList;
import duke.util.Ui;
import duke.exception.EmptyDescriptionException;
import duke.task.Task;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class FindCommand extends Command {
    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Finds a {@link Task} using an input string among descriptions
     * of the tasks in the current {@link TaskList}.
     *
     * @param tasks Current list of tasks
     * @param ui UI being used
     * @param storage Current storage in use
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        List<Task> relevantList = new ArrayList<>();
        for (int i = 0; i < tasks.listSize(); i++) {
            if (tasks.getByIndex(i).getDescription().contains(keyword)) {
                relevantList.add(tasks.getByIndex(i));
            }
        }

        if (relevantList.isEmpty()) {
            ui.showFindFailedMessage();
            return;
        }

        ui.showFindMessage();
        for (int i = 0; i < relevantList.size(); i++) {
            ui.showListElement(relevantList.get(i), i);
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
