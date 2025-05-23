package avlTree;

import java.util.List;

public class Benchmark {

    public static void benchmark(String fileName){

        List<Task> tasks = TaskData.loadTaskIntoFile(fileName);
        TaskManager taskManager = new TaskManager();


        long addTime = execute(() -> {

            for (Task task: tasks){
                taskManager.addTask(task);
            };
        }) / 1_000_000;

        long searchTime = execute(() -> {
            for (Task task: tasks){
                taskManager.searchTask(task.getPriority());
            }
        }) / 1_000_000;

        long deleteTime = execute(() -> {
            for (Task task: tasks) {
                taskManager.deleteTask(task);
            }
        }) / 1_000_000;

        System.out.println("Time of add : " + addTime + " | " + "time of search : "
                             + searchTime + " | " + "time of delete: " + deleteTime);


    }

    // ToDo сделать замер добавления, поиска и удаления из дерева
    //

    public static long execute(Runnable process){
        long time = System.nanoTime();
        process.run();
        return System.nanoTime() - time;
    }

    public static void main(String[] args) {

        int[] sizes = {100, 500, 1000, 5000, 10000};

        for (int size: sizes){
            String fileName = String.format("task_%d.txt", size);
            benchmark(fileName);
        }
    }
}
