package dao;

import java.sql.Connection;
import java.sql.SQLException;

public class BaseDAO {
    public Connection con() throws SQLException {
        return ConnectionDB.getInstance().getConnection();
    }
}
