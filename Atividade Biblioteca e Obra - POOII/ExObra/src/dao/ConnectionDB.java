package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static ConnectionDB instance;
    public ConnectionDB() {

    }

    public synchronized final static ConnectionDB getInstance() {
        if(instance == null) {
            instance = new ConnectionDB();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:my_db.db";
        Connection con = DriverManager.getConnection(url);
        return con;
    }
}
