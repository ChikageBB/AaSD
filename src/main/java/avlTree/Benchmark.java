package avlTree;

import java.io.*;
import java.util.List;

public class Benchmark {

    public static void benchmark(String fileName){

        List<Task> tasks = TaskData.loadTaskIntoFile(fileName);
        TaskManager taskManager = new TaskManager();

        try (FileWriter fw = new FileWriter("result.txt", true)) {

            for (int i = 0; i < tasks.size() - 1; ++i) {
                taskManager.addTask(tasks.get(i));
            }

            Task lastTask = tasks.get(tasks.size() - 1);

            long addTime = execute(() -> {
                taskManager.addTask(lastTask);
            });

            long searchTime = execute(() -> {
                taskManager.searchTask(lastTask.getPriority());
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

        int[] sizes = {100, 500, 1000, 5000, 10_000, 15_000, 20_000,
                               25_000,  50_000, 100_000, 200_000, 500_000, 1_000_000};

        for (int size: sizes){
            String fileName = String.format("task_%d.txt", size);
            benchmark(fileName);
        }
    }
}
