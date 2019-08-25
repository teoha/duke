import java.io.IOException;

public class DoneCommand extends Command {
    int index;

    public DoneCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws IOException {
        Task task = tasks.getByIndex(index);
        task.setDone(true);
        ui.showDoneMessage(task);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
