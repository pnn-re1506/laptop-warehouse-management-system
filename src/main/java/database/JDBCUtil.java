package database;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class JDBCUtil {
    public static Connection getConnection(){
        Connection c = null;
        try {
            // register mySQL Driver with DriverManager
            DriverManager.registerDriver(new Driver());

            String url = getEnv("DB_URL", "jdbc:mysql://localhost:3306/managelaptop?useSSL=false&characterEncoding=UTF-8");
            String userName = getEnv("DB_USERNAME", "root");
            String password = getEnv("DB_PASSWORD", "");

            c = (Connection) DriverManager.getConnection(url, userName, password);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return c;

    }

    private static String getEnv(String key, String defaultValue) {
        String value = System.getenv(key);
        return value == null || value.isBlank() ? defaultValue : value;
    }

    public static void closeConnection(Connection c){
        try {
            if(c != null){
                c.close();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void printInformation(Connection c){
        try {
            if (c != null) {
                DatabaseMetaData metadata = c.getMetaData();
                System.out.println(metadata.getDatabaseProductName());
                System.out.println(metadata.getDatabaseProductVersion());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
