import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBTest2 {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://188.166.209.237:3306/managelaptop?useSSL=false";
            String user = "java_app";
            String password = "Phucnhan1506@";
            
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to managelaptop!");
            
            Statement stmt = con.createStatement();
            
            System.out.println("\n--- TABLES IN managelaptop ---");
            ResultSet rs = stmt.executeQuery("SHOW TABLES");
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
            
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
