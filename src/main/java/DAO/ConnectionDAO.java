package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDAO {
    public static final String COM_MYSQL_JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/demo";
    public static Connection getConnection(){
        try {
            Class.forName(COM_MYSQL_JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(URL, "root", "tuong2001");
            return connection;

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
