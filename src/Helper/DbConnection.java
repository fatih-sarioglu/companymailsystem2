package Helper;

import java.sql.*;

public class DbConnection {
    Connection connection = null;
    
    public DbConnection(){}
    
    public Connection connDb(){
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root&password=123456789");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return connection;
    }
}
