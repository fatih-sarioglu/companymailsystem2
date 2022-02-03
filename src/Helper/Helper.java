package Helper;

import java.sql.*;
import javax.swing.JOptionPane;

public class Helper {
    
    public static void showMsg(String str){
        String msg;
        switch (str) {
            case "fill":
                msg = "Please fill all the boxes!";
                break;
            case "choose":
                msg = "Please choose something!";
                break;
            default:
                msg = str;
        }
        
        JOptionPane.showMessageDialog(null, msg, "!", JOptionPane.INFORMATION_MESSAGE);
        
        
    }
    
    public static int userRowCount(ResultSet rs){
        int size = 0;
        try {
            rs.last();
            size = rs.getRow();
            rs.beforeFirst();
        } catch(Exception ex) {
            return 0;
        }
        return size;
    }
    
}
