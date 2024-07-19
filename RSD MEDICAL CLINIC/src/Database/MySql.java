package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySql {
    
    private static Connection mysqlconfig;
    public static Connection configDB() throws SQLException {
        
        String url="jdbc:mysql://localhost:3306/Clinic"; 
        String user="root";
        String pass="";
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        mysqlconfig= DriverManager.getConnection(url, user, pass);            

        return mysqlconfig;
    }   
    
    
}