package lyssn_homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    public static final String dbURL = System.getenv("URL");
    public static final String dbUN = System.getenv("UN");
    public static final String dbPW = System.getenv("PW");
    public static Connection connect() throws SQLException {
        try {
            return DriverManager.getConnection(dbURL, dbUN, dbPW);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
