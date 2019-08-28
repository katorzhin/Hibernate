package project1;

import project1.entity.User;

import java.sql.*;

public class JdbcStorage {
    private String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private String SERVER_PATH = "localhost:3306";
    private String DB_NAME = "mydbtest";
    private String DB_LOGIN = "root";
    private String DB_PASSWORD = "newlife11";

    private Connection connection;

    private static Statement st;

    private JdbcStorage() {
        initDBDriver();
        initConnection();
    }

    private void initDBDriver() {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public User getUserById(long userId) {
        String selectSql =
                "SELECT *FROM users";

        ResultSet resultSet = null;
        try {
            st.executeQuery(selectSql);

            if (resultSet.first()) {
                User user = new User();

                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
                user.setEmail(resultSet.getString("email"));
                return user;
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            closeResultSet(resultSet);

        }
    }


    private void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void initConnection() {
        String connectionUrl = "jdbc:mysql://" + SERVER_PATH + "/" + DB_NAME;
        connectionUrl += "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        try {
            connection = DriverManager.getConnection(connectionUrl, DB_LOGIN, DB_PASSWORD);
            st = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        JdbcStorage storage = new JdbcStorage();
//        User user = storage.getUserById(7);
        ResultSet resultSet = st.executeQuery("SELECT *FROM users");
        System.out.println(resultSet);
    }
}
