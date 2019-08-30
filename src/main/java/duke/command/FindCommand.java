package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;
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

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage)
            throws IOException, EmptyDescriptionException, ParseException {
        List<Task> relevantList = new ArrayList<>();
        for (int i = 0; i < tasks.listSize(); i++) {
            if (tasks.getByIndex(i).getDescription().contains(keyword)) {
                relevantList.add(tasks.getByIndex(i));
            }
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
