package avlTree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskData {
    public static void saveTaskToFile(List<Task> tasks, String fileName){
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(fileName))){

            for (Task task: tasks){
                pw.println(task.toString());
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static List<Task> loadTaskIntoFile(String fileName){
        List<Task> tasks = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = br.readLine()) != null){
                String[] parts = line.split("\\|");
                tasks.add(
                    new Task(
                            Integer.parseInt(parts[0].trim()),
                            parts[1].trim(),
                            parts[2].trim()
                    )
                );
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return tasks;
    }

    public static void main(String[] args) {

        int[] sizes = {100, 500, 1000, 5000, 10_000, 15_000, 20_000,
                               25_000,  50_000, 100_000, 200_000, 500_000, 1_000_000};

//
//        String fileName = "task_100.txt";
//        List<Task> tasks = loadTaskIntoFile(fileName);
//
//        for (Task task: tasks){
//            System.out.println(
//                    "priority : " + task.getPriority() + " | " +
//                    "title : "  + task.getTitle() + " | " +
//                    "description : " + task.getDescription()
//            );
//        }

        for (int size: sizes){
            List<Task> tasks = TaskGenerator.generateTasks(size);
            String fileName = String.format("task_%s.txt", size);
            saveTaskToFile(tasks, fileName);
        }
    }

}
