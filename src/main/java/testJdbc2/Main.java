package testJdbc2;

import java.sql.*;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "newlife11";

    public static void main(String[] args) throws SQLException {
        DBProcessor dbProcessor = new DBProcessor();
        Connection connection = dbProcessor.getConnection(URL, USERNAME, PASSWORD);
//        String query = "select * from mydbtest.testtable";
        Statement statement = connection.createStatement();
        statement.executeUpdate("insert into mydbtest.developers (developer, skills, companies, salary) value (\"Petya Petrovich\",\"python\",\"another\",1600)");
//        ResultSet resultSet = statement.executeQuery(query);

//        while (resultSet.next()) {
//            int id;
//            String name;
//            double price;
//            int shopId;
//            id = resultSet.getInt("product_id");
//            name = resultSet.getString("product_name");
//            price = resultSet.getDouble("price");
//            shopId = resultSet.getInt("shop_id");
//            Product product = new Product(id, name, price, shopId);
//            System.out.println(product);
//        }
//
//        statement.close();
//        connection.close();

    }
}