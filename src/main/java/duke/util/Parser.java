package duke.util;

import duke.command.AddDeadlineCommand;
import duke.command.AddEventCommand;
import duke.command.AddTodoCommand;
import duke.command.Command;
import duke.command.DeleteCommand;
import duke.command.DoneCommand;
import duke.command.ExitCommand;
import duke.command.FindCommand;
import duke.command.ListCommand;
import duke.exception.EmptyDescriptionException;
import duke.exception.InvalidCommandException;
import duke.exception.UnknownStorageEntryException;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

/**
 * Parser contains the parseUserInput method which reads a command string and makes sense of its contents.
 */
public class Parser {
    /**
     * Reads the user input, makes sense of the input and return the corresponding Command which the
     * user intended.
     *
     * @param fullCommand String representation of the user input
     * @return Command derived from understanding the user input
     * @throws EmptyDescriptionException Thrown when does not include a description
     * @throws InvalidCommandException   Thrown when input string cannot be parsed
     */
    public static Command parseUserInput(String fullCommand)
            throws EmptyDescriptionException, InvalidCommandException {
        String[] strArr = fullCommand.split(" ");
        String description = "";
        switch (strArr[0]) {
        case ("bye"):
            return new ExitCommand();
        case ("list"):
            return new ListCommand();
        case ("done"):
            int index = Integer.parseInt(fullCommand.split(" ")[1]) - 1;
            return new DoneCommand(index);
        case ("find"):
            String keyword = strArr[1].trim();
            return new FindCommand(keyword);
        case ("todo"):
            for (int i = 1; i < strArr.length; i++) {
                description += strArr[i];
                if (i != strArr.length - 1) {
                    description += " ";
                }
            }
            return new AddTodoCommand(description);
        case ("deadline"):
            String date = "";
            int x = 0;
            for (int i = 1; i < strArr.length; i++) {
                if (!strArr[i].equals("/by")) {
                    description += strArr[i];
                    if (!strArr[i + 1].equals("/by")) {
                        description += " ";
                    }
                } else {
                    x = i;
                    break;
                }
            }
            for (int i = x + 1; i < strArr.length; i++) {
                date += strArr[i];
                if (i != strArr.length - 1) {
                    date += " ";
                }
            }
            return new AddDeadlineCommand(description, date);
        case ("event"):
            String duration = "";
            int y = 0;
            for (int i = 1; i < strArr.length; i++) {
                if (!strArr[i].equals("/at")) {
                    description += strArr[i];
                    if (!strArr[i + 1].equals("/at")) {
                        description += " ";
                    }
                } else {
                    y = i;
                    break;
                }
            }
            for (int i = y + 1; i < strArr.length; i++) {
                duration += strArr[i];
                if (i != strArr.length - 1) {
                    duration += " ";
                }
            }
            return new AddEventCommand(description, duration);
        case ("delete"):
            int i = Integer.parseInt(fullCommand.split(" ")[1]) - 1;
            return new DeleteCommand(i);
        default:
            throw new InvalidCommandException(
                    "☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
    }

    /**
     * Reads and makes sense of storage input. Returns a task to be placed in
     * task list.
     *
     * @param info Information string provided by storage.
     * @return Task parsed
     */
    public static Task parseStorage(String info) throws ParseException, UnknownStorageEntryException {
        String[] infoArr = info.split(Pattern.quote("|"));
        Task newTask;
        if (infoArr[0].trim().equals("T")) {
            newTask = new ToDo(infoArr[2].trim());
            if (infoArr[1].trim().equals("1")) {
                newTask.setDone(true);
            }
            return newTask;
        } else if (infoArr[0].trim().equals("D")) {
            newTask =
                    new Deadline(
                            infoArr[2].trim(),
                            new SimpleDateFormat("dd/MM/yyyy HHmm").parse(infoArr[3].trim()));
            if (infoArr[1].trim().equals("1")) {
                newTask.setDone(true);
            }
            return newTask;
        } else if (infoArr[0].trim().equals("E")) {
            String startDate = infoArr[3].split("-")[0].trim();
            String endDate = infoArr[3].split("-")[1].trim();
            newTask =
                    new Event(
                            infoArr[2].trim(),
                            new SimpleDateFormat("dd/MM/yyyy HHmm").parse(startDate),
                            new SimpleDateFormat("dd/MM/yyyy HHmm").parse(endDate));
            if (infoArr[1].trim().equals("1")) {
                newTask.setDone(true);
            }
            return newTask;
        } else {
            throw new UnknownStorageEntryException();
        }
    }
}
