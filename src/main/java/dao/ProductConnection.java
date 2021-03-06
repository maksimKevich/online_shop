package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
  Created by Maksim on 7/27/2017.
 */
public class ProductConnection {
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/online_shop";
    private static final String ID = "root";
    private static final String PASS = "root";
    protected PreparedStatement preparedStatement;

    public void init() {

    }

    protected Connection getConnection() {
        try {
            Class.forName(DRIVER_NAME);
            return DriverManager.getConnection(DB_URL, ID, PASS);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected PreparedStatement getPrepareStatement(String query) throws SQLException {
        return getConnection().prepareStatement(query);
    }
}
