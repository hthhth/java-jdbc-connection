package jdbcTest;

import jdbcConnection.MySQLConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLTest {
    public static void main(String[] args) throws SQLException {
        Connection conn = MySQLConnection.getMySQLConnection();
        System.out.println("Opened connection: " + conn);

        Statement statement = conn.createStatement();
        String sql = "select emp.EMP_ID, emp.FIRST_NAME, emp.LAST_NAME, emp.DEPT_ID from employee as emp";
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int empID = resultSet.getInt(1);
            String empFirstName = resultSet.getString(2);
            String empLastName = resultSet.getString("Last_name");
            int deptID = resultSet.getInt("dept_id");

            System.out.println("-----------------");
            System.out.println("Emp ID: " + empID);
            System.out.println("Emp First Name: " + empFirstName);
            System.out.println("Emp Last Name: " + empLastName);
            System.out.println("Dept ID: " + deptID);
        }

        conn.close();

    }
}
