package jdbcTest;


import jdbcConnection.SQLServerJTDSConnection;

import java.sql.*;

public class SQLServerJTDSTest {
    public static void main(String[] args) throws SQLException {
        Connection conn = SQLServerJTDSConnection.getSQLServerConnection();
        System.out.println("Opened connection: " + conn);

        String sqlParam = "SELECT [EMP_ID], [FIRST_NAME], [TITLE], [DEPT_ID] from [automationfc].[dbo].[EMPLOYEE] where [TITLE] like ? and [DEPT_ID] = ?";

        PreparedStatement preparedStatement = conn.prepareStatement(sqlParam);
        preparedStatement.setString(1, "%ent");
        preparedStatement.setInt(2,3);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int empID = resultSet.getInt(1);
            String empFirstName = resultSet.getString("first_name");
            String empTitle = resultSet.getString("TITLE");
            int deptID = resultSet.getInt(4);

            System.out.println("-----------------------------");
            System.out.println("Employee ID: " + empID);
            System.out.println("Employee first name: " + empFirstName);
            System.out.println("Employee title: " + empTitle);
            System.out.println("Dept ID: " + deptID);

        }
        conn.close();
    }
}
