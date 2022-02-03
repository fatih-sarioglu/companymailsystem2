package companymailsystem2;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class NewClass {

    public static void main(String[] args) throws SQLException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()));
        
        /*Worker w = new Worker();
        
        w.getMailList(1);
        for (int i = 0; i < w.getMailList(1).size(); i++) {
            System.out.println(w.getMailList(1).get(i).getMailTo());
        }*/
        
        /*Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/users?user=root&password=123456789");
        Statement st = conn.createStatement();*/

        /*Scanner input = new Scanner(System.in);
        System.out.print("Name: ");
        String name = input.nextLine();
        System.out.print("E-mail: : ");
        String email = input.nextLine();
        System.out.print("Password: ");
        String password = input.nextLine();*/

        //Veritabanına ekleme
        /*String query = "INSERT INTO user_info (user_name,user_email,user_password) VALUES ('" + name + "', '" + email + "', ' " + password + "')";
        st.executeUpdate(query);
        st.close();*/
        
        //Veritabanına ekleme
        /*String query = "INSERT INTO user_info (user_name,user_email,user_password) VALUES (?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, name);
        ps.setString(2, email);
        ps.setString(3, password);
        ps.executeUpdate();*/
        
        /*
        CREATE TABLE `users_mails`.`new_table` (
        `mail_to` VARCHAR(45) NOT NULL,
        `mail_from` VARCHAR(45) NOT NULL,
        `mail_subject` VARCHAR(45) NULL DEFAULT 'No Subject',
        `mail_content` VARCHAR(10000) NOT NULL,
        `mail_time` VARCHAR(45) NOT NULL,
        PRIMARY KEY (`mail_to`))
        ENGINE = InnoDB
        DEFAULT CHARACTER SET = utf8;
        */
        
        /*
        CREATE TABLE `users_mails`.`%dmails` (
        `mail_to` VARCHAR(45) NOT NULL,
        `mail_from` VARCHAR(45) NOT NULL,
        `mail_subject` VARCHAR(45) NULL DEFAULT 'No Subject',
        `mail_content` VARCHAR(10000) NOT NULL,
        `mail_time` VARCHAR(45) NOT NULL,
        `mail_box` VARCHAR(45) NOT NULL DEFAULT '1',
         PRIMARY KEY (`mail_to`))
        ENGINE = InnoDB
        DEFAULT CHARACTER SET = utf8;
        */
        /*ResultSet rs = st.executeQuery("SELECT * FROM user_info");
        System.out.println(rs);
        /*while (rs.next()) {            
            System.out.println(rs.getString("user_password"));
        }*/
        /*
        st.close();*/
        
        

    }
}
