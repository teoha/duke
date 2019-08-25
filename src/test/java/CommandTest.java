import duke.command.AddDeadlineCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommandTest {
    @Test
    public void AddDeadLineCommandTest(){
        Assertions.assertEquals(false,new AddDeadlineCommand("description","date").isExit());
    }
}
