package Helper;

import GUI.*;
import Helper.*;
import Model.*;
import java.sql.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class LoginPage {
    
    private static DbConnection conn = new DbConnection();
    
    public static void main(String[] args){
        Login();
    }
    
    public static void Login() {
        JFrame frame1 = new JFrame();
        frame1.setSize(500, 600);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setResizable(true);
        frame1.setTitle("Login");
        frame1.setVisible(true);
        
        frame1.setLayout(null);
        
        JLabel title = new JLabel("COMPANY MAIL SYSTEM");
        title.setBounds(60, 0, 380, 50);
        title.setFont(new Font("Slenco", Font.BOLD, 30));
        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setVerticalTextPosition(JLabel.CENTER);
        frame1.add(title);
        
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(150, 220, 200, 30);
        JTextField emailField = new JTextField();
        emailField.setBounds(150, 250, 200, 30);
        frame1.add(emailLabel);
        frame1.add(emailField);
        
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(150, 320, 200, 30);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 350, 200, 30);
        frame1.add(passwordLabel);
        frame1.add(passwordField);
        
        ImageIcon icon = new ImageIcon("C:\\Users\\elifm\\Documents\\NetBeansProjects\\CompanyMailSystem2\\src\\workspace .png");
        JLabel logoLabel = new JLabel();
        logoLabel.setIcon(icon);
        logoLabel.setBounds(186, 75, 128, 128);
        frame1.add(logoLabel);
        frame1.setIconImage(icon.getImage());
        
        ImageIcon emailIcon = new ImageIcon("C:\\Users\\elifm\\Documents\\NetBeansProjects\\CompanyMailSystem2\\src\\email.png");
        JLabel emailLogoLabel = new JLabel();
        emailLogoLabel.setIcon(emailIcon);
        emailLogoLabel.setBounds(120, 252, 24, 24);
        frame1.add(emailLogoLabel);
        
        ImageIcon passwordIcon = new ImageIcon("C:\\Users\\elifm\\Documents\\NetBeansProjects\\CompanyMailSystem2\\src\\password.png");
        JLabel passwordLogoLabel = new JLabel();
        passwordLogoLabel.setIcon(passwordIcon);
        passwordLogoLabel.setBounds(120, 353, 24, 24);
        frame1.add(passwordLogoLabel);
        
        Button btn1 = new Button("Login");
        btn1.setFocusable(false);
        btn1.setBounds(125, 430, 100, 50);
        btn1.setBackground(new Color(0x9AD0EC));
        btn1.addActionListener((a) -> {
            if (emailField.getText().length() == 0 || passwordField.getText().length() == 0) {
                Helper.showMsg("fill");
            } else {
                try {
                    Connection con = conn.connDb();
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM users.users_table");
                    
                    while (rs.next()) {
                        if (emailField.getText().equals(rs.getString("users_email")) && passwordField.getText().equals(rs.getString("users_password"))) {
                            switch (rs.getString("users_type")) {
                                case "ADMIN" -> {
                                    Admin admin = new Admin();
                                    admin.setId(rs.getInt("id_users_table"));
                                    admin.setName(rs.getString("users_name"));
                                    admin.setAddress(rs.getString("users_email"));
                                    admin.setPassword(rs.getString("users_password"));
                                    admin.setType(rs.getString("users_type"));
                                    adminGUI aGUI = new adminGUI(admin);
                                    aGUI.setVisible(true);
                                    frame1.dispose();
                                    
                                }
                                case "MODERATOR" -> {
                                    Moderator moderator = new Moderator();
                                    moderator.setId(rs.getInt("id_users_table"));
                                    moderator.setName(rs.getString("users_name"));
                                    moderator.setAddress(rs.getString("users_email"));
                                    moderator.setPassword(rs.getString("users_password"));
                                    moderator.setType(rs.getString("users_type"));
                                    modGUI mGUI = new modGUI(moderator);
                                    mGUI.setVisible(true);
                                    frame1.dispose();
                                }
                                case "WORKER" -> {
                                    Worker worker = new Worker();
                                    worker.setId(rs.getInt("id_users_table"));
                                    worker.setName(rs.getString("users_name"));
                                    worker.setAddress(rs.getString("users_email"));
                                    worker.setPassword(rs.getString("users_password"));
                                    worker.setType(rs.getString("users_type"));
                                    workerGUI wGUI = new workerGUI(worker);
                                    wGUI.setVisible(true);
                                    frame1.dispose();
                                    
                                }
                                default -> throw new AssertionError();
                            }

                        } else {
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            
        });
        frame1.add(btn1);
        
        Button btn2 = new Button("Register");
        btn2.setFocusable(false);
        btn2.setBounds(275, 430, 100, 50);
        btn2.setBackground(new Color(0x9AD0EC));
        btn2.addActionListener((e) -> {
            JFrame registerFrame = new JFrame("Register");
            registerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            registerFrame.setSize(300, 400);
            registerFrame.setVisible(true);
            registerFrame.setResizable(false);
            
            registerFrame.setLayout(null);
            
            JLabel regNameLabel = new JLabel("Name:");
            regNameLabel.setBounds(50, 10, 200, 30);
            JTextField regNameField = new JTextField();
            regNameField.setBounds(50, 40, 200, 30);
            registerFrame.add(regNameLabel);
            registerFrame.add(regNameField);
            
            JLabel regEmailLabel = new JLabel("Email:");
            regEmailLabel.setBounds(50, 75, 200, 30);
            JTextField regEmailField = new JTextField();
            regEmailField.setBounds(50, 105, 200, 30);
            registerFrame.add(regEmailLabel);
            registerFrame.add(regEmailField);
            
            JLabel regPasswordLabel = new JLabel("Password:");
            regPasswordLabel.setBounds(50, 140, 200, 30);
            JPasswordField regPasswordField = new JPasswordField();
            regPasswordField.setBounds(50, 170, 200, 30);
            registerFrame.add(regPasswordLabel);
            registerFrame.add(regPasswordField);
            
            JLabel regPasswordCLabel = new JLabel("Confirm Password:");
            regPasswordCLabel.setBounds(50, 205, 200, 30);
            JPasswordField regPasswordCField = new JPasswordField();
            regPasswordCField.setBounds(50, 235, 200, 30);
            registerFrame.add(regPasswordCLabel);
            registerFrame.add(regPasswordCField);
            
            JButton regButton = new JButton("Register");
            regButton.setFocusable(false);
            regButton.setBackground(new Color(0x9AD0EC));
            regButton.setBounds(50, 290, 90, 30);
            registerFrame.add(regButton);
            regButton.addActionListener((e1) -> {
                if (regEmailField.getText().length() == 0 || regPasswordField.getText().length() == 0 || regNameField.getText().length() == 0 || regPasswordCField.getText().length() == 0) {
                    Helper.showMsg("fill");
                }else if (!regPasswordField.getText().equals(regPasswordCField.getText())) {
                    JOptionPane.showMessageDialog(null, "Please confirm your password correctly!", "!", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    try {
                        Connection con = conn.connDb();
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("SELECT * FROM users.users_table");
                        try {
                            while (rs.next()) {
                                if (regEmailField.getText().equals(rs.getString("users_email"))) {
                                    JOptionPane.showMessageDialog(null, "This e-mail address has been taken!", "!", JOptionPane.INFORMATION_MESSAGE);
                                    break;
                                } else {
                                    Connection con1 = conn.connDb();
                                    Statement st1 = con1.createStatement();
                                    ResultSet rs1 = st1.executeQuery("SELECT * FROM user_reqs.reqs");
                                    
                                    try {
                                        while (rs1.next()) {
                                            if (regEmailField.getText().equals(rs1.getString("req_email"))) {
                                                JOptionPane.showMessageDialog(null, "There is a registeration in the system with this e-mail!", "!", JOptionPane.INFORMATION_MESSAGE);
                                                break;
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Your application has been sent to moderator!", "!", JOptionPane.INFORMATION_MESSAGE);
                                                String query = "INSERT INTO user_reqs.reqs (req_name,req_email,req_password) VALUES (?,?,?)";
                                                PreparedStatement ps = con1.prepareStatement(query);
                                                ps.setString(1, regNameField.getText());
                                                ps.setString(2, regEmailField.getText());
                                                ps.setString(3, regPasswordField.getText());
                                                ps.executeUpdate();
                                                registerFrame.dispose();
                                                break;
                                            }
                                        }
                                        JOptionPane.showMessageDialog(null, "Your application has been sent to moderator!", "!", JOptionPane.INFORMATION_MESSAGE);
                                        String query = "INSERT INTO user_reqs.reqs (req_name,req_email,req_password) VALUES (?,?,?)";
                                        PreparedStatement ps = con1.prepareStatement(query);
                                        ps.setString(1, regNameField.getText());
                                        ps.setString(2, regEmailField.getText());
                                        ps.setString(3, regPasswordField.getText());
                                        ps.executeUpdate();
                                        registerFrame.dispose();
                                    } catch (SQLException e4) {
                                        Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, e4);
                                    } finally{
                                        con1.close();
                                        st1.close();
                                        rs1.close();
                                    }
                                    break;
                                }
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
                        }finally{
                            con.close();
                            st.close();
                            rs.close();
                        }
                    } catch (Exception e15) {
                        Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, e15);
                    }
                }
            });
                
            JButton clearButton = new JButton("Cancel");
            clearButton.setFocusable(false);
            clearButton.setBackground(new Color(0x9AD0EC));
            clearButton.setBounds(160, 290, 90, 30);
            registerFrame.add(clearButton);
            clearButton.addActionListener((e2) -> {
                registerFrame.dispose();
            });
            
        });
        frame1.add(btn2);
        
    }
    
}
