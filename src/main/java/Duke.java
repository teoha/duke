import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.util.regex.Pattern;

public class Duke {
    public static void main(String[] args) throws InvalidCommandException,EmptyDescriptionException, IOException {
        System.out.println("Hello! I'm Duke\nWhat can I do for you?");

        Scanner scanner = new Scanner(System.in);
        List<Task> list = new ArrayList<>();
        Task task;
        FileWriter fileWriter=null;

        try {
            File file = new File("./data/duke.txt");
            fileWriter = new FileWriter("./data/duke.txt",true);
            Scanner fileScanner = new Scanner(file);
            while(fileScanner.hasNextLine()){
                String info = fileScanner.nextLine();
                String[] infoArr = info.split(Pattern.quote("|"));
                Task newTask;
                if(infoArr[0].trim().equals("T")){
                    newTask = new ToDo(infoArr[2].trim());
                    if(infoArr[1].trim().equals("1"))newTask.setDone(true);
                    list.add(newTask);
                } else if(infoArr[0].trim().equals("D")){
                    newTask = new Deadline(infoArr[2].trim(), infoArr[3].trim());
                    if(infoArr[1].trim().equals("1"))newTask.setDone(true);
                    list.add(newTask);
                } else if(infoArr[0].trim().equals("E")){
                    newTask = new Event(infoArr[2].trim(), infoArr[3].trim());
                    if(infoArr[1].trim().equals("1"))newTask.setDone(true);
                    list.add(newTask);
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }

        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            String[] strArr = s.split(" ");
            String description = "";
            try {
                switch (strArr[0]) {
                    case ("bye"):
                        System.out.println("Bye. Hope to see you again soon!");
                        fileWriter.close();
                        System.exit(0);
                    case ("list"):
                        System.out.println("Here are the tasks in your list:");
                        for (int i = 0; i < list.size(); i++) {
                            System.out.println((i + 1) + ". " + list.get(i));
                        }
                        break;
                    case ("done"):
                        int index = Integer.parseInt(s.split(" ")[1]) - 1;
                        task = list.get(index);
                        task.setDone(true);

                        System.out.println("Nice! I've marked this task as done: \n" + task);
                        break;
                    case ("todo"):
                        for (int i = 1; i < strArr.length; i++) {
                            description += strArr[i];
                            if (i != strArr.length - 1) {
                                description += " ";
                            }
                        }
                        if(description.equals(""))throw new EmptyDescriptionException("☹ OOPS!!! The description of a todo cannot be empty.");
                        task = new ToDo(description);
                        list.add(task);
                        System.out.println("Got it. I've added this task: \n" + task);
                        System.out.println(String.format("Now you have %d tasks in the list.", list.size()));
                        if(fileWriter!=null){
                            fileWriter.write(String.format("\nT | 0 | %s", description));
                        }
                        break;
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
                        task = new Deadline(description, date);
                        list.add(task);
                        System.out.println("Got it. I've added this task: \n" + task);
                        System.out.println(String.format("Now you have %d tasks in the list.", list.size()));
                        if(fileWriter!=null){
                            fileWriter.write(String.format("\nD | 0 | %s | $s", description, date));
                        }

                        break;
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
                        task = new Event(description, duration);
                        list.add(task);
                        System.out.println("Got it. I've added this task: \n" + task);
                        System.out.println(String.format("Now you have %d tasks in the list.", list.size()));
                        if(fileWriter!=null){
                            fileWriter.write(String.format("\nE | 0 | %s | $s", description, duration));
                        }
                        break;
                    case("delete"):
                        int i = Integer.parseInt(s.split(" ")[1]) - 1;
                        task = list.get(i);
                        list.remove(i);
                        System.out.println("Noted. I've removed this task: \n" + task+"\nNow you have "+list.size()+" tasks in the list.");
                        break;
                    default:
                        throw new InvalidCommandException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            } catch (InvalidCommandException e) {
                System.out.println(e.getMessage());
            } catch (EmptyDescriptionException e){
                System.out.println(e.getMessage());
            } catch (IOException e){
                System.out.println("Task was not saved");
            }
        }
    }
}
