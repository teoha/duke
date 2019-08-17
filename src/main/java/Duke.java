import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Duke\nWhat can I do for you?");
        Scanner scanner = new Scanner(System.in);
        List<Task> list = new ArrayList<>();
        while(scanner.hasNext()) {
            String s = scanner.nextLine();
            switch(s.split(" ")[0]){
                case("bye"):
                    System.out.println("Bye. Hope to see you again soon!");
                    System.exit(0);
                case("list"):
                    for(int i=0;i<list.size(); i++){
                        System.out.println((i+1)+". "+list.get(i));
                    }
                    break;
                case("done"):
                    int index = Integer.parseInt(s.split(" ")[1])-1;
                    Task task = list.get(index);
                    task.setDone(true);
                    break;
                default:
                    System.out.println("added: "+s);
                    list.add(new Task(s));
            }
        }
    }
}
