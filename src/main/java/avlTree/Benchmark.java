package avlTree;

import java.io.*;
import java.util.List;
import java.util.Random;

public class Benchmark {

    public static void benchmark(String fileName){

        List<Task> tasks = TaskData.loadTaskIntoFile(fileName);
        TaskManager taskManager = new TaskManager();
        Task lastTask = tasks.get(tasks.size() - 1);
        Task randomTask = tasks.get(new Random().nextInt(tasks.size()));

        try (FileWriter fw = new FileWriter("result.txt", true)) {

            for (int i = 0; i < tasks.size() - 1; ++i) {
                taskManager.addTask(tasks.get(i));
            }



            // делаем прогрев компилятора
            for (int i = 0; i < 3; i++) {
                taskManager.addTask(new Task(lastTask.getPriority(), lastTask.getTitle(),lastTask.getDescription())); // вставка копии
                taskManager.searchTask(lastTask.getPriority());
                taskManager.deleteTask(lastTask); // удалить оригинал
            }

            long addTime = execute(() -> {
                taskManager.addTask(lastTask);
            });

            long searchTime = execute(() -> {
                taskManager.searchTask(randomTask.getPriority());
            });

            long deleteTime = execute(() -> {
                taskManager.deleteTask(lastTask);
            });

            fw.write(tasks.size()  + " " + addTime + " " + searchTime + " " + deleteTime + "\n");



        System.out.println("Time of add : " + addTime + " | " + "time of search : "
                             + searchTime + " | " + "time of delete: " + deleteTime);

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    // ToDo сделать замер добавления, поиска и удаления из дерева

    public static long execute(Runnable process){
        long time = System.nanoTime();
        process.run();
        return System.nanoTime() - time;
    }

    public static void main(String[] args) {


        for (int i = 1; i < 100; i++){
            String fileName = String.format("task_%d.txt", i);
            benchmark(fileName);
        }
    }
}
