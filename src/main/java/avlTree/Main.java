package avlTree;

public class Main {
    public static void main(String[] args) {

        TaskManager tm = new TaskManager();

        Task task1 = new Task(1, "homework", "do homework");
        Task task2 = new Task(2, "ead", "cooking eat");
        Task task3 = new Task(3, "shop", "go to shop");

        tm.addTask(task1);
        tm.addTask(task2);
        tm.addTask(task3);

        tm.printTasks();

        System.out.println(tm.searchTask(1));

    }
}
