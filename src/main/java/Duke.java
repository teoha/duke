import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Duke\nWhat can I do for you?");
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while(scanner.hasNext()) {
            String s = scanner.nextLine();
            switch (s){
                case("bye"):
                    System.out.println("Bye. Hope to see you again soon!");
                    System.exit(0);
                case("list"):
                    for(int i=0;i<list.size(); i++){
                        System.out.println((i+1)+". "+list.get(i));
                    }
                    break;
                default:
                    System.out.println("added: "+s);
                    list.add(s);
            }
        }
    }
}
