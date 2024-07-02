package Task23;
import java.math.BigDecimal;
import java.sql.*;

public class JdbcConnection {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/company1";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "root24";
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
    // Connect to MySQL database 'company1'
        connection = DriverManager.getConnection(JDBC_URL,JDBC_USERNAME,JDBC_PASSWORD);
        Statement statement = connection.createStatement();
    // Create database 'company1' if it doesn't exist
        String query = "CREATE DATABASE IF NOT EXISTS company1;";
        statement.executeUpdate(query);
    // Switch to database 'company'
        query = "USE company";
        statement.executeUpdate(query);
    // Create table 'employee' if it doesn't exist
        query = "CREATE TABLE IF NOT EXISTS employee (empcode INT PRIMARY KEY, empname VARCHAR(255), empage INT, esalary DECIMAL(10,2))";
        statement.executeUpdate(query);
    // Insert data into 'employee' table using PreparedStatement
        String insertQuery = "INSERT INTO employee (empcode, empname, empage, esalary) VALUES (?, ?, ?, ?)";
         pstmt = connection.prepareStatement(insertQuery);
    // Insert multiple records
            pstmt.setInt(1, 101);
            pstmt.setString(2, "Jenny");
            pstmt.setInt(3, 25);
            pstmt.setBigDecimal(4, new BigDecimal("10000"));
            pstmt.executeUpdate();

            pstmt.setInt(1, 102);
            pstmt.setString(2, "Jacky");
            pstmt.setInt(3, 30);
            pstmt.setBigDecimal(4, new BigDecimal("20000"));
            pstmt.executeUpdate();

            pstmt.setInt(1, 103);
            pstmt.setString(2, "Joe");
            pstmt.setInt(3, 20);
            pstmt.setBigDecimal(4, new BigDecimal("40000"));
            pstmt.executeUpdate();

            pstmt.setInt(1, 104);
            pstmt.setString(2, "John");
            pstmt.setInt(3, 40);
            pstmt.setBigDecimal(4, new BigDecimal("80000"));
            pstmt.executeUpdate();

            pstmt.setInt(1, 105);
            pstmt.setString(2, "Shameer");
            pstmt.setInt(3, 25);
            pstmt.setBigDecimal(4, new BigDecimal("90000"));
            pstmt.executeUpdate();  // Execute the insert statement

            System.out.println("Data inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
