package tasks;

public class Task {
    public Integer taskId;
    public String taskDescription;
    public String taskProgress;

    public Task(Integer taskId, String taskDescription, String taskProgress){
        this.taskId = taskId;
        this.taskDescription = taskDescription;
        this.taskProgress = taskProgress;
    }

    public Task(){}
}
