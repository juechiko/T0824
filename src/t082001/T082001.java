package t082001;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class T082001 {

    public static void main(String[] args) {
        try {
            // TODO code application logic here
            String driverName = "com.mysql.jdbc.Driver";
            String connString = "jdbc:mysql://localhost:3306/mydb?" +
                    "user=root&password=1234";
            Class.forName(driverName);
            Connection conn = DriverManager.getConnection(connString);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * From students");
            // String name = "' or '1' = '1";
            // String name = "'; exec shell ''";
            // ResultSet rs = stmt.executeQuery("Select * From students where student_name = '" + name + "'");
            // SQL Injection , 資料隱碼攻擊
            
            while(rs.next())
            {
                System.out.println("name:" + rs.getString(2));
                System.out.println("tel:" + rs.getString(3));
            }
            //rs.next();
            //System.out.println("第一列第二個欄位內容: " + rs.getString(2));
            //rs.next();
           // System.out.println("第二列第三個欄位內容: " + rs.getString(3));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(T082001.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(T082001.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
