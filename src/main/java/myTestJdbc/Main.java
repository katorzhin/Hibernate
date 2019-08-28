package myTestJdbc;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Main {
    private static String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static String USERNAME = "root";
    private static String USERPASSWORD = "newlife11";

    public static void main(String[] args) throws SQLException {
        Driver driver = new FabricMySQLDriver();
        DriverManager.registerDriver(driver);
        Connection connection = DriverManager.getConnection(URL, USERNAME, USERPASSWORD);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM developers");
        while (resultSet.next()) {

            int id = resultSet.getInt("id");
            String developer = resultSet.getString("developer");
            String skills = resultSet.getString("skills");
            String companies = resultSet.getString("companies");
            int salary = resultSet.getInt("salary");

            Developer developer1 = new Developer(id, developer, skills, companies, salary);
            System.out.println(developer1);
        }
        statement.close();
        connection.close();
    }
}
