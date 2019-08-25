import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Storage{
    String filePath;
    File file;
    FileWriter fileWriter;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public List<Task> load() throws IOException, ParseException {
        List<Task> tempTaskList = new ArrayList<>();
        file = new File(filePath);
        fileWriter = new FileWriter(filePath,true);
        Scanner fileScanner = new Scanner(file);

        while(fileScanner.hasNextLine()){
            String info = fileScanner.nextLine();
            String[] infoArr = info.split(Pattern.quote("|"));
            Task newTask;
            if(infoArr[0].trim().equals("T")){
                newTask = new ToDo(infoArr[2].trim());
                if(infoArr[1].trim().equals("1"))newTask.setDone(true);
                tempTaskList.add(newTask);
            } else if(infoArr[0].trim().equals("D")){
                newTask = new Deadline(infoArr[2].trim(), new SimpleDateFormat("dd/MM/yyyy hhmm").parse(infoArr[3].trim()));
                if(infoArr[1].trim().equals("1"))newTask.setDone(true);
                tempTaskList.add(newTask);
            } else if(infoArr[0].trim().equals("E")){
                String startDate = infoArr[3].split("-")[0].trim();
                String endDate = infoArr[3].split("-")[1].trim();
                newTask = new Event(infoArr[2].trim(), new SimpleDateFormat("dd/MM/yyyy hhmm").parse(startDate),new SimpleDateFormat("dd/MM/yyyy").parse(endDate));
                if(infoArr[1].trim().equals("1"))newTask.setDone(true);
                tempTaskList.add(newTask);
            }
        }
        return tempTaskList;
    }
    public void saveTodo(String description) throws IOException{
        if(fileWriter!=null){
            fileWriter.write(String.format("\nT | 0 | %s", description));
        }
    }
    public void saveDeadLine(String description, String date) throws IOException{
        if(fileWriter!=null){
            fileWriter.write(String.format("\nD | 0 | %s | %s", description, date));
        }
    }
    public void saveEvent(String description, String duration) throws IOException{
        if(fileWriter!=null){
            fileWriter.write(String.format("\nE | 0 | %s | %s", description, duration));
        }
    }
    public void close() throws IOException{
        fileWriter.close();
    }
}
