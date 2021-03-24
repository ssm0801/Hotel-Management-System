package hotel.management.system;

import java.sql.*;

public class DatabaseConnection {

    // all objects declared globally in class to use in methods
    Connection connection;
    Statement statement;

    public DatabaseConnection(){
        try {

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///hms", "root", "toor");
            statement = connection.createStatement();

        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

    }

}
