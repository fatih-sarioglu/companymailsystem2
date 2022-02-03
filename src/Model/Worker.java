package Model;

import java.sql.*;
import java.util.ArrayList;

public class Worker extends User{

    Connection con = conn.connDb();
    Statement st = null;
    ResultSet rs = null;
    
    public Worker(String name, String address, String type, int id, String password) {
        super(name, address, type, id, password);
    }

    public Worker (){}
    
    
    public ArrayList<Mail> getMailList (int id) throws SQLException{
        ArrayList<Mail> list3 = new ArrayList<>();
        Mail obj;
        try {
            String query = String.format("SELECT * FROM users_mails.%dmails", id);
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {                
                obj = new Mail(rs.getString("mail_to"), rs.getString("mail_from"), rs.getString("mail_subject"), rs.getString("mail_content"), rs.getString("mail_time"), rs.getString("mail_box"));
                list3.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list3;
    }
    
}
