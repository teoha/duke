package duke;

import duke.command.*;
import duke.exception.EmptyDescriptionException;
import duke.exception.InvalidCommandException;

public class Parser {
    public static Command parse(String fullCommand) throws EmptyDescriptionException, InvalidCommandException {
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
            case("find"):
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
                        if (!strArr[i + 1].equals("/by")) description += " ";
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
                return new AddDeadlineCommand(description,date);
            case ("event"):
                String duration = "";
                int y = 0;
                for (int i = 1; i < strArr.length; i++) {
                    if (!strArr[i].equals("/at")) {
                        description += strArr[i];
                        if (!strArr[i + 1].equals("/at")) description += " ";
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
                return new AddEventCommand(description,duration);
            case ("delete"):
                int i = Integer.parseInt(fullCommand.split(" ")[1]) - 1;
                return new DeleteCommand(i);
            default:
                throw new InvalidCommandException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        }

    }
}
