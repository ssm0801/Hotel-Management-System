package hotel.management.system;

import java.sql.*;

public class DatabaseConnection {

    // all objects declared globally in class to use in methods
    Connection connection;
    Statement statement;

    public DatabaseConnection(){
        try {

            // jdbc driver
            Class.forName("com.mysql.jdbc.Driver");
            // connection URL
            connection = DriverManager.getConnection("jdbc:mysql:///hms", "root", "toor");
            statement = connection.createStatement();

        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new DatabaseConnection();
    }

}
