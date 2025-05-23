package avlTree;

// Todo операция добавления
// Todo операция удаления
// Todo операция поиска

public class TaskManager {
    private AVLTree<Task> tasks;

    public TaskManager(){
        tasks = new AVLTree<>();
    }

    public void addTask(Task task){
        tasks.insert(task);
    }

    public void deleteTask(Task task){
        tasks.delete(task);
    }

    public Task searchTask(int priority){
        Node<Task> node = tasks.search(new Task(priority, "", ""));
        return node.getValue() != null ? node.getValue() : null;
    }

    public void printTasks(){
        tasks.traverse();
    }

    public Task getMostUnimportantTask(){
        return tasks.getMin();
    }

    public Task getMostImportantTask(){
        return tasks.getMax();
    }

}
