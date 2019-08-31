import duke.task.Deadline;
import duke.task.Event;
import duke.task.ToDo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class TaskTest {
    @Test
    public void deadlineTest() {
        Deadline deadline = new Deadline("description", new Date(2019 - 1900, 8, 26, 18, 0));
        Assertions.assertEquals("26/08/2019 1800", deadline.getDateString());
        //Assertions.assertEquals("[D][\u2718] description (by: 26/08/2019 1800)", deadline.toString());
    }

    @Test
    public void eventTest() {
        Event event = new Event("description", new Date(2019 - 1900, 8, 26, 18, 0),
                new Date(2019 - 1900, 8, 26, 19, 0));
        Assertions.assertEquals("26/08/2019 1800 - 26/08/2019 1900", event.getDurationString());
        //Assertions.assertEquals("[E][\u2718] description (at: 26/08/2019 1800 - 26/08/2019 1900)", event.toString());
    }

    @Test
    public void todoTest() {
        ToDo todo = new ToDo("description");
        //Assertions.assertEquals("[T][\u2718] description", todo.toString());
    }

}
