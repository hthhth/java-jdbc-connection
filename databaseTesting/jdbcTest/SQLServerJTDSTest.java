package jdbcTest;


import jdbcConnection.SQLServerJTDSConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLServerJTDSTest {
    public static void main(String[] args) throws SQLException {
        Connection conn = SQLServerJTDSConnection.getSQLServerConnection();
        System.out.println("Opened connection: " + conn);

        Statement statement = conn.createStatement();
        String sql = "select emp_id, first_name, last_name, dept_id from [automationfc].[dbo].[employee]";
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int empID = resultSet.getInt(1);
            String empFirstName = resultSet.getString("first_name");
            String empLastName = resultSet.getString("last_name");
            int deptID = resultSet.getInt(4);

            System.out.println("-----------------------------");
            System.out.println("Employee ID: " + empID);
            System.out.println("Employee first name: " + empFirstName);
            System.out.println("Employee last name: " + empLastName);
            System.out.println("Dept ID: " + deptID);

        }
        conn.close();
    }
}
