package t082001;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class T082001b {

    public static void main(String[] args) {
        try {
            // TODO code application logic here
            String driverName = "com.mysql.jdbc.Driver";
            String connString = "jdbc:mysql://localhost:3306/mydb?"
                    + "user=root&password=1234";
            Class.forName(driverName);
            Connection conn = DriverManager.getConnection(connString);
            PreparedStatement pstmt = conn.prepareStatement("Select * From students where name = ?");
            pstmt.setString(1, "aa");

            ResultSet rs = pstmt.executeQuery();
            // String name = "' or '1' = '1";
            // String name = "'; exec shell ''";
            // ResultSet rs = stmt.executeQuery("Select * From students where student_name = '" + name + "'");
            // SQL Injection , 資料隱碼攻擊

            while (rs.next()) {
                System.out.println("name:" + rs.getString(2));
                System.out.println("tel:" + rs.getString(3));
            }
            pstmt.executeQuery();
            pstmt.close();
            conn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(T082001b.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(T082001b.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
