import duke.task.Deadline;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class TaskTest {
    @Test
    public void deadlineTest() {
        Deadline deadline = new Deadline("description", new Date(2019, 8, 26, 18, 0));
        Assertions.assertEquals("26/08/2019 1800", deadline.getDateString());
    }
}
