package Model;

import java.util.ArrayList;
import java.sql.*;

public class Moderator extends Worker{
    
    Connection con = conn.connDb();
    Statement st = null;
    ResultSet rs = null;

    public Moderator(String name, String address, String type, int id, String password) {
        super(name, address, type, id, password);
    }
    
    public Moderator (){}
    
    
    public ArrayList<Requests> getReqList() throws SQLException{
        ArrayList<Requests> list = new ArrayList<>();
        Requests obj;
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM user_reqs.reqs");
            while (rs.next()) {
                obj = new Requests(rs.getString("req_name"), rs.getString("req_email"), rs.getString("req_password"));
                list.add(obj);
                
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            //st.close();
            //rs.close();
            //con.close();
        }
        return list;
    }    
        
    public ArrayList<User> getEmpList () throws SQLException{
        ArrayList<User> list2 = new ArrayList<>();
        User obj;
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM users.users_table");
            while (rs.next()) {                
                obj = new User(rs.getString("users_name"), rs.getString("users_email"), rs.getString("users_type"), rs.getInt("id_users_table"), rs.getString("users_password"));
                list2.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list2;
    }
    
    
    
    
    
    
}
