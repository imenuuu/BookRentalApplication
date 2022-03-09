package book.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    public static Connection getConnection() throws SQLException {
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bookrental",
                "root","gus990413");
        return con;
    }
}
