package database;

import java.sql.*;

public class DBHandler {
    String connectionUrl = "jdbc:mysql://127.0.0.1:3306/?user=java_18";
    String user = "java_18";
    String password = "java18";

    private Connection connection;

    public DBHandler(){
        try {
            connection = DriverManager.getConnection(connectionUrl, user, password);
        }catch (SQLException e){
            System.out.println("Unable to connect to To Do manager database");
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return connection;
    }
}
