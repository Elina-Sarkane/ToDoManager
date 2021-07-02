package tasks;

import java.sql.SQLException;
import java.util.ArrayList;

public class TaskController {
    public  static TaskRepository taskRepository = new TaskRepository();

    public String createTask(Task task){
        try {
            taskRepository.addTask(task);
        }catch (SQLException e){
            e.printStackTrace();
            return "Error with creating task";
        }
        return "Task created successfully";
    }

    public Task findTask(Integer taskId){
        Task task = null;

        try {
            task = taskRepository.getTask(taskId);
        }catch (SQLException e){
            System.out.println(e);
        }
        return task;
    }

    public ArrayList<Task> findTaskByProgress(String taskProgress){
        ArrayList<Task> tasks = new ArrayList<>();

        try {
            tasks = taskRepository.getTaskByProgress(taskProgress);
        }catch (SQLException e){
            System.out.println(e);
        }
        return tasks;
    }

    public ArrayList<Task> getAllTasks(){
        ArrayList<Task> tasks = new ArrayList<Task>();

        try {
            tasks = taskRepository.getAll();
        }catch (SQLException e){
            System.out.println(e);
        }
        return tasks;
    }

    public Task removeTask(){
        Task task = new Task();

        try {
            task = taskRepository.getTask(task.taskId);
            taskRepository.delete(task.taskId);
        }catch (SQLException e){
            System.out.println(e);
        }
        return task;
    }

    public Task updateTask(){
        Task task = new Task();
        try {
            task = taskRepository.getTask(task.taskId);
            taskRepository.update(task.taskId);
        }catch (SQLException e){
            System.out.println(e);
        }
        return task;
    }
}
