package t082001;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class T082002 {

    public static void main(String[] args) {
        // TODO code application logic here
        try {
            // TODO code application logic here
            String driverName = "com.mysql.jdbc.Driver";
            String connString = "jdbc:mysql://localhost:3306/mydb?"
                    + "user=root&password=1234";
            Class.forName(driverName);
            Connection conn = DriverManager.getConnection(connString);
            PreparedStatement pstmt = conn.prepareStatement("Insert Into students (name, tel) values (?,?)");
            pstmt.setString(1, "cde");
            pstmt.setString(2, "567");

            pstmt.executeUpdate();
            pstmt.close();
            conn.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(T082001.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(T082001.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
