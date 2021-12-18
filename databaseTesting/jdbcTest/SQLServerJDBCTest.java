package jdbcTest;

import jdbcConnection.SQLServerJDBSConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLServerJDBCTest {
    public static void main(String[] args) throws SQLException {
        Connection conn = SQLServerJDBSConnection.getSQLServerConnection();
        System.out.println("Opened connection: " + conn);

        Statement statement = conn.createStatement();
        String url = "select emp_id, first_name, last_name, dept_id from [automationfc].[dbo].[employee]";
        ResultSet resultSet = statement.executeQuery(url);
        while (resultSet.next()) {
            int empID = resultSet.getInt(1);
            String empFirstName = resultSet.getString(2);
            String empLastName = resultSet.getString(3);
            String deptID = resultSet.getString(4);

            System.out.println("------------------------");
            System.out.println("Employee ID: " + empID);
            System.out.println("Employee First Name: " + empFirstName);
            System.out.println("Employee Last Name: " + empLastName);
            System.out.println("Dept ID: " + deptID);
        }
        conn.close();
    }
}
