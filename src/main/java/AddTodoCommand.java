import java.io.IOException;

public class AddTodoCommand extends AddCommand {
    private String description;

    public AddTodoCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws IOException, EmptyDescriptionException{
        if (description.equals(""))
            throw new EmptyDescriptionException("☹ OOPS!!! The description of a todo cannot be empty.");
        Task task = new ToDo(description);
        tasks.add(task);
        ui.showTaskAddedMessage(task, tasks);
        storage.saveTodo(description);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
