package tasks;

import database.DBHandler;

import java.sql.*;
import java.util.ArrayList;

public class TaskRepository {
    private static DBHandler dbHandler = new DBHandler();

    public void addTask(Task task) throws SQLException{
        Connection connection = dbHandler.getConnection();
        PreparedStatement preparedStatement = dbHandler.getConnection().prepareStatement("INSERT INTO todolist(taskDescription, taskProgress) VALUES(?,?)");
        preparedStatement.setString(1, task.taskDescription);
        preparedStatement.setString(2, task.taskProgress);
        preparedStatement.execute();
        preparedStatement.close();
    }

    public Task getTask(Integer taskId) throws SQLException{
        Task task;
        Statement statement = dbHandler.getConnection().createStatement();

        ResultSet resultSet = statement.executeQuery( "SELECT * FROM todolist WHERE taskId =" + taskId + " LIMIT 1");

        resultSet.next();
        task = new Task(
                resultSet.getInt("taskId"),
                resultSet.getString("taskDescription"),
                resultSet.getString("taskProgress")
        );

        statement.close();
        return task;
    }

    public ArrayList<Task> getTaskByProgress(String taskProgress) throws SQLException{
        Statement statement = dbHandler.getConnection().createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM todolist WHERE taskProgress LIKE '%" + taskProgress + "%'");

        ArrayList<Task> tasks = new ArrayList<Task>();

        while (resultSet.next()){
            tasks.add(new Task(
                    resultSet.getInt("taskId"),
                    resultSet.getString("taskDescription"),
                    resultSet.getString("taskProgress")
            ));
        }
        statement.close();
        return tasks;
    }

    public static ArrayList<Task> getAll() throws SQLException {
        Statement statement = dbHandler.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM todolist");

        ArrayList<Task> tasks = new ArrayList<Task>();

        while (resultSet.next()){
            int taskId = resultSet.getInt("taskId");
            String taskDescription = resultSet.getString("taskDescription");
            String taskProgress = resultSet.getString("taskProgress");

            tasks.add((Task) new Task(taskId, taskDescription, taskProgress));
        }
        statement.close();
        return tasks;
    }

    public static void delete(Integer taskId) throws SQLException{
        PreparedStatement preparedStatement = dbHandler.getConnection().prepareStatement("DELETE FROM todolist WHERE taskId " + taskId + "=?");
        preparedStatement.setInt(1, taskId);
        int update = preparedStatement.executeUpdate();
        if (update == 1){
            System.out.println("Task successfully deleted");
        }else if (update == 0){
            System.out.println("Can't delete task. Wrong task ID number");
        }
        preparedStatement.execute();
        preparedStatement.close();
    }

    public static void update(Integer taskId) throws SQLException{
        PreparedStatement preparedStatement = dbHandler.getConnection().prepareStatement("UPDATE todolist SET status = ? WHERE taskID =?");
        preparedStatement.setString(1, "Done");
        preparedStatement.setInt(2, taskId);
        int update = preparedStatement.executeUpdate();
        if(update == 1){
            System.out.println("Task successfully done");
        }else if (update == 0){
            System.out.println("Can't update task. Wrong ID number");
        }
        preparedStatement.execute();
        preparedStatement.close();
    }




}
