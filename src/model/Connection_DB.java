package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import configuration.Configure;

/**
 * Created by user on 03.07.2016.
 */
public class Connection_DB {
    private Configure configure=Configure.getConfigure();

    private Connection dbConnection;


    public Connection_DB() {
        try {
            Class.forName(configure.getDatabase_driver());
        } catch (ClassNotFoundException e) {
            System.out.println("Don't connection to com.mysql.jdbc.Driver");
        }

        try {
            dbConnection = DriverManager.getConnection(configure.getDatabase_url(), configure.getUser_name(), configure.getPassword());
        } catch (SQLException e) {
            System.out.println("Don't connection to jdbc:mysql://localhost:3306/moda_db");
        }
    }

    public Connection getDbConnection() {
        return dbConnection;
    }

    public Configure getConfigure() {
        return configure;
    }
}
