package duke.command;

import duke.util.Storage;
import duke.util.TaskList;
import duke.util.Ui;
import duke.exception.EmptyDescriptionException;
import duke.task.Task;
import duke.task.ToDo;
import java.io.IOException;

public class AddTodoCommand extends AddCommand {
    private String description;

    public AddTodoCommand(String description) {
        this.description = description;
    }

    /**
     * Adds a to do task into task list.
     *
     * @param tasks Current list of tasks
     * @param ui UI being used
     * @param storage Current storage in use
     * @throws IOException Error with accessing file or file writer
     * @throws EmptyDescriptionException Error when no description is provided
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage)
            throws IOException, EmptyDescriptionException {
        if (description.equals("")) {
            throw new EmptyDescriptionException(
                    "☹ OOPS!!! The description of a todo cannot be empty.");
        }
        Task task = new ToDo(description);
        tasks.add(task);
        ui.showTaskAddedMessage(task, tasks);
        storage.saveTodo(description);
    }

    /**
     * Tests Exit Command.
     *
     * @return Whether command is an Exit Command
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
