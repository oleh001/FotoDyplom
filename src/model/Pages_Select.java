package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by user on 03.07.2016.
 */
public class Pages_Select {
    private Statement statement;

    private ResultSet resultSet;

    public Pages_Select(Connection connection, String selectSQL) {
//       String selectSQL = "SELECT page_id, title from pages";
        try {
            setStatement(connection.createStatement());

            // вибираємо дані з БД
            setResultSet(getStatement().executeQuery(selectSQL));
        } catch (SQLException e) {
            System.out.println("Don't Select from Pages");
        }
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }
}
