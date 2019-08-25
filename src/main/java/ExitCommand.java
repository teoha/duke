import java.io.IOException;

public class ExitCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws IOException {
        storage.close();
        ui.showClosingMessage();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
