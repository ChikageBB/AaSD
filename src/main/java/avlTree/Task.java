package avlTree;

public class Task implements Comparable<Task> {

    private int priority;
    private String title;
    private String description;

    public Task(int priority, String title, String description){
        this.priority = priority;
        this.title = title;
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        return priority + " | " + title + " | "
                 + description;

    }

    @Override
    public int compareTo(Task o){
        return this.priority - o.priority;
    }
}
