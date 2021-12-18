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

        String insertValue = "insert into [dbo].[BRANCH] ([ADDRESS], [CITY], [NAME], [STATE], [ZIP_CODE]) values ('100 Winter Road', 'NY', 'Main', 'MS', '08719')";
        int rowCount = statement.executeUpdate(insertValue);
        System.out.println("Row count affected " + rowCount);

        String sql = "select * from [automationfc].[dbo].[branch]";
        ResultSet resultSet = statement.executeQuery(sql);

//        while (resultSet.next()) {
//            int empID = resultSet.getInt(1);
//            String empFirstName = resultSet.getString("first_name");
//            String empLastName = resultSet.getString("last_name");
//            int deptID = resultSet.getInt(4);
//
//            System.out.println("-----------------------------");
//            System.out.println("Employee ID: " + empID);
//            System.out.println("Employee first name: " + empFirstName);
//            System.out.println("Employee last name: " + empLastName);
//            System.out.println("Dept ID: " + deptID);
//
//        }
        while (resultSet.next()) {
            int branchID = resultSet.getInt(1);
            String branchAddress = resultSet.getString("ADDRESS");
            String branchCity = resultSet.getString("CITY");
            String branchName = resultSet.getString("NAME");

            System.out.println("-----------------------------");
            System.out.println("Branch ID: " + branchID);
            System.out.println("Branch address: " + branchAddress);
            System.out.println("Branch city: " + branchCity);
            System.out.println("Branch name: " + branchName);

        }
        conn.close();
    }
}
