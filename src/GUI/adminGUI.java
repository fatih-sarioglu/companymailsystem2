package GUI;

import Helper.DbConnection;
import Model.Admin;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.nio.charset.StandardCharsets;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class adminGUI extends javax.swing.JFrame {

    DbConnection conn = new DbConnection();
    static Admin admin = new Admin();
    private DefaultTableModel empTableModel = null;  
    private Object[] empData = null;
    private DefaultTableModel inboxModel = null;  
    private Object[] inboxData = null;
    private DefaultTableModel spamModel = null;  
    private Object[] spamData = null;
    private DefaultTableModel archModel = null;  
    private Object[] archData = null;
    private DefaultTableModel trashModel = null;  
    private Object[] trashData = null;
    private DefaultTableModel sentModel = null;  
    private Object[] sentData = null;
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Calendar cal = Calendar.getInstance();
    
    public adminGUI(Admin admin) {
        this.admin = admin;
        initComponents();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        empTableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        Object[] colEmpName = new Object[5];
        colEmpName[0] = "ID";
        colEmpName[1] = "Name";
        colEmpName[2] = "Email";
        colEmpName[3] = "Password";
        colEmpName[4] = "Position";
        empTableModel.setColumnIdentifiers(colEmpName);
        empData = new Object[5];
        try{
            for (int i = 0; i < admin.getEmpList().size(); i++){
                empData[0] = admin.getEmpList().get(i).getId();
                empData[1] = admin.getEmpList().get(i).getName();
                empData[2] = admin.getEmpList().get(i).getAddress();
                empData[3] = admin.getEmpList().get(i).getPassword();
                empData[4] = admin.getEmpList().get(i).getType();

                empTableModel.addRow(empData);
            }
        }catch(Exception e){

        }

        inboxModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        spamModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        archModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        trashModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        sentModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        Object[] colReqName = new Object[3];
        colReqName[0] = "Date";
        colReqName[1] = "From";
        colReqName[2] = "Subject";

        Object[] colReqName2 = new Object[3];
        colReqName2[0] = "Date";
        colReqName2[1] = "To";
        colReqName2[2] = "Subject";

        sentModel.setColumnIdentifiers(colReqName2);
        sentData = new Object[3];

        inboxModel.setColumnIdentifiers(colReqName);
        inboxData = new Object[3];
        spamModel.setColumnIdentifiers(colReqName);
        spamData = new Object[3];
        archModel.setColumnIdentifiers(colReqName);
        archData = new Object[3];
        trashModel.setColumnIdentifiers(colReqName);
        trashData = new Object[3];
        try{

            for (int i = 0; i < admin.getMailList(admin.getId()).size(); i++){
                switch(admin.getMailList(admin.getId()).get(i).getMailBox()){
                    case "1":
                    inboxData[0] = admin.getMailList(admin.getId()).get(i).getMailTime();
                    inboxData[1] = admin.getMailList(admin.getId()).get(i).getMailFrom();
                    inboxData[2] = admin.getMailList(admin.getId()).get(i).getMailSubject();
                    inboxModel.addRow(inboxData);
                    break;
                    case "2":
                    spamData[0] = admin.getMailList(admin.getId()).get(i).getMailTime();
                    spamData[1] = admin.getMailList(admin.getId()).get(i).getMailFrom();
                    spamData[2] = admin.getMailList(admin.getId()).get(i).getMailSubject();
                    spamModel.addRow(spamData);
                    break;
                    case "3":
                    archData[0] = admin.getMailList(admin.getId()).get(i).getMailTime();
                    archData[1] = admin.getMailList(admin.getId()).get(i).getMailFrom();
                    archData[2] = admin.getMailList(admin.getId()).get(i).getMailSubject();
                    archModel.addRow(archData);
                    break;
                    case "4":
                    trashData[0] = admin.getMailList(admin.getId()).get(i).getMailTime();
                    trashData[1] = admin.getMailList(admin.getId()).get(i).getMailFrom();
                    trashData[2] = admin.getMailList(admin.getId()).get(i).getMailSubject();
                    trashModel.addRow(trashData);
                    break;
                    case "5":
                    sentData[0] = admin.getMailList(admin.getId()).get(i).getMailTime();
                    sentData[1] = admin.getMailList(admin.getId()).get(i).getMailTo();
                    sentData[2] = admin.getMailList(admin.getId()).get(i).getMailSubject();
                    sentModel.addRow(sentData);
                    break;
                }
            }
        }catch(Exception e){

        }
        contentPane = new javax.swing.JPanel();
        welcomeText = new javax.swing.JLabel();
        tabs = new javax.swing.JTabbedPane();
        inboxTab = new javax.swing.JScrollPane();
        inboxTable = new javax.swing.JTable();
        sentTab = new javax.swing.JScrollPane();
        sentTable = new javax.swing.JTable();
        spamTab = new javax.swing.JScrollPane();
        spamTable = new javax.swing.JTable();
        archieveTab = new javax.swing.JScrollPane();
        archTable = new javax.swing.JTable();
        trashTab = new javax.swing.JScrollPane();
        trashTable = new javax.swing.JTable();
        composemailTab = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        composetoLabel = new javax.swing.JLabel();
        composetoField = new javax.swing.JTextField();
        composesubjectLabel = new javax.swing.JLabel();
        composesubjectField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        composesubjectLabel1 = new javax.swing.JLabel();
        sendButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        empTab = new javax.swing.JScrollPane();
        empTable = new javax.swing.JTable();
        logoutBtn = new javax.swing.JButton();
        refreshBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Company Mail System");
        setMinimumSize(new java.awt.Dimension(500, 600));
        setResizable(false);

        contentPane.setMinimumSize(new java.awt.Dimension(500, 600));
        contentPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        welcomeText.setFont(new java.awt.Font("Slenco Black", 1, 24)); // NOI18N
        byte[] bytes = admin.getName().getBytes(StandardCharsets.UTF_8);
        String utf8EncodedName = new String(bytes, StandardCharsets.UTF_8);
        welcomeText.setText("Welcome, " + utf8EncodedName);
        contentPane.add(welcomeText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 350, 30));

        tabs.setPreferredSize(new java.awt.Dimension(480, 440));

        inboxTable.setFocusable(false);
        inboxTable.setModel(inboxModel);
        inboxTab.setViewportView(inboxTable);
        inboxMenu = new JPopupMenu();
        JMenuItem spamItem = new JMenuItem("Mark as spam");
        JMenuItem trashItem = new JMenuItem("Put in the trash");
        JMenuItem archItem = new JMenuItem("Archieve");
        JMenuItem openItem = new JMenuItem("Open mail");
        inboxMenu.add(spamItem);
        inboxMenu.add(archItem);
        inboxMenu.add(trashItem);
        inboxMenu.add(openItem);
        inboxTable.setComponentPopupMenu(inboxMenu);

        spamItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e10){
                try{
                    String selSub = inboxTable.getValueAt(inboxTable.getSelectedRow(), 2).toString();
                    Connection con = conn.connDb();
                    Statement st = con.createStatement();
                    inboxModel.removeRow(inboxTable.getSelectedRow());
                    String query = String.format("UPDATE users_mails.%dmails SET mail_box = '2' WHERE mail_subject ='" + selSub + "'",admin.getId());
                    st.executeUpdate(query);
                } catch(SQLException e2){
                    e2.printStackTrace();
                } catch(Exception e){
                    Helper.Helper.showMsg("choose");
                }

            }

        });

        archItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e10){
                try{
                    String selSub = inboxTable.getValueAt(inboxTable.getSelectedRow(), 2).toString();
                    Connection con = conn.connDb();
                    Statement st = con.createStatement();
                    inboxModel.removeRow(inboxTable.getSelectedRow());
                    String query = String.format("UPDATE users_mails.%dmails SET mail_box = '3' WHERE mail_subject ='" + selSub + "'",admin.getId());
                    st.executeUpdate(query);
                } catch(SQLException e2){
                    e2.printStackTrace();
                } catch(Exception e){
                    Helper.Helper.showMsg("choose");
                }

            }

        });

        trashItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e10){
                try{
                    String selSub = inboxTable.getValueAt(inboxTable.getSelectedRow(), 2).toString();
                    Connection con = conn.connDb();
                    Statement st = con.createStatement();
                    inboxModel.removeRow(inboxTable.getSelectedRow());
                    String query = String.format("UPDATE users_mails.%dmails SET mail_box = '4' WHERE mail_subject ='" + selSub + "'",admin.getId());
                    st.executeUpdate(query);
                } catch(SQLException e2){
                    e2.printStackTrace();
                } catch(Exception e){
                    Helper.Helper.showMsg("choose");
                }

            }

        });

        openItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e10){
                try{
                    String selDate = inboxTable.getValueAt(inboxTable.getSelectedRow(),0).toString();
                    String selEmail = inboxTable.getValueAt(inboxTable.getSelectedRow(), 1).toString();
                    String selSub = inboxTable.getValueAt(inboxTable.getSelectedRow(), 2).toString();
                    JFrame mailFrame = new JFrame(selSub);
                    mailFrame.setVisible(true);
                    mailFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    mailFrame.setSize(400, 450);
                    mailFrame.setResizable(false);
                    mailFrame.setLayout(null);

                    JTextField dateField = new JTextField();
                    dateField.setText("Date: " + selDate);
                    dateField.setBounds(50, 20, 300, 30);
                    dateField.setEditable(false);
                    mailFrame.add(dateField);

                    JTextField fromField = new JTextField();
                    fromField.setText("From: " + selEmail);
                    fromField.setBounds(50, 60, 300, 30);
                    fromField.setEditable(false);
                    mailFrame.add(fromField);

                    JTextField subField = new JTextField();
                    subField.setText("Subject: " + selSub);
                    subField.setBounds(50, 100, 300, 30);
                    subField.setEditable(false);
                    mailFrame.add(subField);

                    JTextArea mailContent = new JTextArea();
                    JScrollPane sp = new JScrollPane(mailContent);
                    Connection con = conn.connDb();
                    Statement st = con.createStatement();
                    String query = String.format("SELECT mail_content FROM users_mails.%dmails WHERE mail_subject ='" + selSub + "'",admin.getId());
                    ResultSet rs = st.executeQuery(query);
                    String content = null;
                    while(rs.next()){
                        content = rs.getString("mail_content");
                    }
                    sp.setBounds(50, 140, 300, 250);
                    mailContent.setEditable(false);
                    mailContent.setText(content);
                    mailContent.setLineWrap(true);
                    mailFrame.getContentPane().add(sp);

                } catch(SQLException e2){
                    e2.printStackTrace();
                } catch(Exception e){
                    Helper.Helper.showMsg("choose");
                }

            }

        });

        inboxMenu.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent mevt){
                Point point = mevt.getPoint();
                int selectedRow = inboxTable.rowAtPoint(point);
                inboxTable.setRowSelectionInterval(selectedRow, selectedRow);
            }
        });

        tabs.addTab("Inbox", inboxTab);

        sentTable.setFocusable(false);
        sentTable.setModel(sentModel);
        sentTab.setViewportView(sentTable);
        sentMenu = new JPopupMenu();
        JMenuItem s2OpenItem = new JMenuItem("Open mail");
        sentMenu.add(s2OpenItem);
        sentTable.setComponentPopupMenu(sentMenu);

        s2OpenItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e10){
                try{
                    String selDate = sentTable.getValueAt(sentTable.getSelectedRow(),0).toString();
                    String selEmail = sentTable.getValueAt(sentTable.getSelectedRow(), 1).toString();
                    String selSub = sentTable.getValueAt(sentTable.getSelectedRow(), 2).toString();
                    JFrame mailFrame = new JFrame(selSub);
                    mailFrame.setVisible(true);
                    mailFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    mailFrame.setSize(400, 450);
                    mailFrame.setResizable(false);
                    mailFrame.setLayout(null);

                    JTextField dateField = new JTextField();
                    dateField.setText("Date: " + selDate);
                    dateField.setBounds(50, 20, 300, 30);
                    dateField.setEditable(false);
                    mailFrame.add(dateField);

                    JTextField fromField = new JTextField();
                    fromField.setText("To: " + selEmail);
                    fromField.setBounds(50, 60, 300, 30);
                    fromField.setEditable(false);
                    mailFrame.add(fromField);

                    JTextField subField = new JTextField();
                    subField.setText("Subject: " + selSub);
                    subField.setBounds(50, 100, 300, 30);
                    subField.setEditable(false);
                    mailFrame.add(subField);

                    JTextArea mailContent = new JTextArea();
                    JScrollPane sp = new JScrollPane(mailContent);
                    Connection con = conn.connDb();
                    Statement st = con.createStatement();
                    String query = String.format("SELECT mail_content FROM users_mails.%dmails WHERE mail_subject ='" + selSub + "'",admin.getId());
                    ResultSet rs = st.executeQuery(query);
                    String content = null;
                    while(rs.next()){
                        content = rs.getString("mail_content");
                    }
                    sp.setBounds(50, 140, 300, 250);
                    mailContent.setEditable(false);
                    mailContent.setText(content);
                    mailContent.setLineWrap(true);
                    mailFrame.getContentPane().add(sp);

                } catch(SQLException e2){
                    e2.printStackTrace();
                } catch(Exception e){
                    Helper.Helper.showMsg("choose");
                }

            }

        });

        tabs.addTab("Sent", sentTab);

        spamTable.setFocusable(false);
        spamTable.setModel(spamModel);
        spamTab.setViewportView(spamTable);
        spamMenu = new JPopupMenu();
        JMenuItem sInboxItem = new JMenuItem("Remove from spam");
        JMenuItem sTrashItem = new JMenuItem("Put in the trash");
        JMenuItem sArchItem = new JMenuItem("Archieve");
        spamMenu.add(sInboxItem);
        spamMenu.add(sArchItem);
        spamMenu.add(sTrashItem);
        spamTable.setComponentPopupMenu(spamMenu);

        sInboxItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e10){
                try{
                    String selSub = spamTable.getValueAt(spamTable.getSelectedRow(), 2).toString();
                    Connection con = conn.connDb();
                    Statement st = con.createStatement();
                    spamModel.removeRow(spamTable.getSelectedRow());
                    String query = String.format("UPDATE users_mails.%dmails SET mail_box = '1' WHERE mail_subject ='" + selSub + "'",admin.getId());
                    st.executeUpdate(query);
                } catch(SQLException e2){
                    e2.printStackTrace();
                } catch(Exception e){
                    Helper.Helper.showMsg("choose");
                }

            }

        });

        sArchItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e10){
                try{
                    String selSub = spamTable.getValueAt(spamTable.getSelectedRow(), 2).toString();
                    Connection con = conn.connDb();
                    Statement st = con.createStatement();
                    spamModel.removeRow(spamTable.getSelectedRow());
                    String query = String.format("UPDATE users_mails.%dmails SET mail_box = '3' WHERE mail_subject ='" + selSub + "'",admin.getId());
                    st.executeUpdate(query);
                } catch(SQLException e2){
                    e2.printStackTrace();
                } catch(Exception e){
                    Helper.Helper.showMsg("choose");
                }

            }

        });

        sTrashItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e10){
                try{
                    String selSub = spamTable.getValueAt(spamTable.getSelectedRow(), 2).toString();
                    Connection con = conn.connDb();
                    Statement st = con.createStatement();
                    spamModel.removeRow(spamTable.getSelectedRow());
                    String query = String.format("UPDATE users_mails.%dmails SET mail_box = '4' WHERE mail_subject ='" + selSub + "'",admin.getId());
                    st.executeUpdate(query);
                } catch(SQLException e2){
                    e2.printStackTrace();
                } catch(Exception e){
                    Helper.Helper.showMsg("choose");
                }

            }

        });

        spamMenu.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent mevt){
                Point point = mevt.getPoint();
                int selectedRow = spamTable.rowAtPoint(point);
                spamTable.setRowSelectionInterval(selectedRow, selectedRow);
            }
        });

        tabs.addTab("Spam", spamTab);

        archTable.setFocusable(false);
        archTable.setModel(archModel);
        archieveTab.setViewportView(archTable);
        archMenu = new JPopupMenu();
        JMenuItem aInboxItem = new JMenuItem("Remove from archieve");
        JMenuItem aTrashItem = new JMenuItem("Put in the trash");
        JMenuItem aSpamItem = new JMenuItem("Mark as spam");
        archMenu.add(aInboxItem);
        archMenu.add(aSpamItem);
        archMenu.add(aTrashItem);
        archTable.setComponentPopupMenu(archMenu);

        aInboxItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e10){
                try{
                    String selSub = archTable.getValueAt(archTable.getSelectedRow(), 2).toString();
                    Connection con = conn.connDb();
                    Statement st = con.createStatement();
                    archModel.removeRow(archTable.getSelectedRow());
                    String query = String.format("UPDATE users_mails.%dmails SET mail_box = '1' WHERE mail_subject ='" + selSub + "'",admin.getId());
                    st.executeUpdate(query);
                } catch(SQLException e2){
                    e2.printStackTrace();
                } catch(Exception e){
                    Helper.Helper.showMsg("choose");
                }

            }

        });

        aSpamItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e10){
                try{
                    String selSub = archTable.getValueAt(archTable.getSelectedRow(), 2).toString();
                    Connection con = conn.connDb();
                    Statement st = con.createStatement();
                    archModel.removeRow(archTable.getSelectedRow());
                    String query = String.format("UPDATE users_mails.%dmails SET mail_box = '2' WHERE mail_subject ='" + selSub + "'",admin.getId());
                    st.executeUpdate(query);
                } catch(SQLException e2){
                    e2.printStackTrace();
                } catch(Exception e){
                    Helper.Helper.showMsg("choose");
                }

            }

        });

        aTrashItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e10){
                try{
                    String selSub = archTable.getValueAt(archTable.getSelectedRow(), 2).toString();
                    Connection con = conn.connDb();
                    Statement st = con.createStatement();
                    archModel.removeRow(archTable.getSelectedRow());
                    String query = String.format("UPDATE users_mails.%dmails SET mail_box = '4' WHERE mail_subject ='" + selSub + "'",admin.getId());
                    st.executeUpdate(query);
                } catch(SQLException e2){
                    e2.printStackTrace();
                } catch(Exception e){
                    Helper.Helper.showMsg("choose");
                }

            }

        });

        archMenu.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent mevt){
                Point point = mevt.getPoint();
                int selectedRow = archTable.rowAtPoint(point);
                archTable.setRowSelectionInterval(selectedRow, selectedRow);
            }
        });

        tabs.addTab("Archieve", archieveTab);

        trashTable.setFocusable(false);
        trashTable.setModel(trashModel);
        trashTab.setViewportView(trashTable);
        trashMenu = new JPopupMenu();
        JMenuItem tInboxItem = new JMenuItem("Remove from trash");
        JMenuItem tArchItem = new JMenuItem("Archieve");
        JMenuItem tSpamItem = new JMenuItem("Mark as spam");
        JMenuItem tDeletePerm = new JMenuItem("Delete permanently");
        trashMenu.add(tInboxItem);
        trashMenu.add(tSpamItem);
        trashMenu.add(tArchItem);
        trashMenu.add(tDeletePerm);
        trashTable.setComponentPopupMenu(trashMenu);

        tInboxItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e10){
                try{
                    String selSub = trashTable.getValueAt(trashTable.getSelectedRow(), 2).toString();
                    Connection con = conn.connDb();
                    Statement st = con.createStatement();
                    trashModel.removeRow(trashTable.getSelectedRow());
                    String query = String.format("UPDATE users_mails.%dmails SET mail_box = '1' WHERE mail_subject ='" + selSub + "'",admin.getId());
                    st.executeUpdate(query);
                } catch(SQLException e2){
                    e2.printStackTrace();
                } catch(Exception e){
                    Helper.Helper.showMsg("choose");
                }

            }

        });

        tSpamItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e10){
                try{
                    String selSub = trashTable.getValueAt(trashTable.getSelectedRow(), 2).toString();
                    Connection con = conn.connDb();
                    Statement st = con.createStatement();
                    trashModel.removeRow(trashTable.getSelectedRow());
                    String query = String.format("UPDATE users_mails.%dmails SET mail_box = '2' WHERE mail_subject ='" + selSub + "'",admin.getId());
                    st.executeUpdate(query);
                } catch(SQLException e2){
                    e2.printStackTrace();
                } catch(Exception e){
                    Helper.Helper.showMsg("choose");
                }

            }

        });

        tArchItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e10){
                try{
                    String selSub = trashTable.getValueAt(trashTable.getSelectedRow(), 2).toString();
                    Connection con = conn.connDb();
                    Statement st = con.createStatement();
                    trashModel.removeRow(trashTable.getSelectedRow());
                    String query = String.format("UPDATE users_mails.%dmails SET mail_box = '3' WHERE mail_subject ='" + selSub + "'",admin.getId());
                    st.executeUpdate(query);
                } catch(SQLException e2){
                    e2.printStackTrace();
                } catch(Exception e){
                    Helper.Helper.showMsg("choose");
                }

            }

        });

        tDeletePerm.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e10){
                try{
                    String selSub = trashTable.getValueAt(trashTable.getSelectedRow(), 2).toString();
                    Connection con = conn.connDb();
                    Statement st = con.createStatement();
                    trashModel.removeRow(trashTable.getSelectedRow());
                    String query = String.format("DELETE FROM users_mails.%dmails WHERE mail_subject ='" + selSub + "'",admin.getId());
                    st.executeUpdate(query);
                } catch(SQLException e2){
                    e2.printStackTrace();
                } catch(Exception e){
                    Helper.Helper.showMsg("choose");
                }

            }

        });

        trashMenu.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent mevt){
                Point point = mevt.getPoint();
                int selectedRow = trashTable.rowAtPoint(point);
                trashTable.setRowSelectionInterval(selectedRow, selectedRow);
            }
        });

        tabs.addTab("Trash", trashTab);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        composetoLabel.setText("To:");
        jPanel1.add(composetoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 20));

        composetoField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                composetoFieldActionPerformed(evt);
            }
        });
        jPanel1.add(composetoField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 400, -1));

        composesubjectLabel.setText("Message:");
        jPanel1.add(composesubjectLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 80, 20));

        composesubjectField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                composesubjectFieldActionPerformed(evt);
            }
        });
        jPanel1.add(composesubjectField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 400, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 460, 300));

        composesubjectLabel1.setText("Subject:");
        jPanel1.add(composesubjectLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 50, 20));

        sendButton.setText("Send");
        sendButton.setFocusable(false);/*);
    jPanel1.add(sendButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 220, 40));
    */

    sendButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            String toMail = composetoField.getText();
            String subMail = composesubjectField.getText();
            String contMail = jTextArea1.getText();
            String curDate = dateFormat.format(cal.getTime());

            try{
                Connection con = conn.connDb();
                Statement st = con.createStatement();
                String query = "SELECT id_users_table FROM users.users_table WHERE users_email = '" + toMail + "'";
                ResultSet rs = st.executeQuery(query);
                String id = null;
                while(rs.next()){
                    id = rs.getString("id_users_table").toString();
                }

                String query2 = String.format("INSERT INTO users_mails.%smails (mail_to,mail_from,mail_subject,mail_content,mail_time,mail_box) VALUES (?,?,?,?,?,?)", id);
                PreparedStatement ps = con.prepareStatement(query2);
                ps.setString(1, toMail);
                ps.setString(2, admin.getAddress());
                ps.setString(3, subMail);
                ps.setString(4, contMail);
                ps.setString(5, curDate);
                ps.setString(6, "1");
                ps.executeUpdate();

                String query3 = String.format("INSERT INTO users_mails.%smails (mail_to,mail_from,mail_subject,mail_content,mail_time,mail_box) VALUES (?,?,?,?,?,?)", admin.getId());
                PreparedStatement ps2 = con.prepareStatement(query3);
                ps2.setString(1, toMail);
                ps2.setString(2, admin.getAddress());
                ps2.setString(3, subMail);
                ps2.setString(4, contMail);
                ps2.setString(5, curDate);
                ps2.setString(6, "5");
                ps2.executeUpdate();
            } catch(SQLException e11){
                e11.printStackTrace();
            }

            composetoField.setText("");
            composesubjectField.setText("");
            jTextArea1.setText("");

        }
    });

    jPanel1.add(sendButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 220, 40));

    clearButton.setText("Clear");
    clearButton.setFocusable(false);/*);
    jPanel1.add(clearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 430, 220, 40));
    */

    clearButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            composetoField.setText("");
            composesubjectField.setText("");
            jTextArea1.setText("");
        }
    });

    jPanel1.add(clearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 430, 220, 40));

    composemailTab.setViewportView(jPanel1);

    tabs.addTab("Compose Mail", composemailTab);

    empTable.setModel(empTableModel);
    empTable.setFocusable(false);
    empTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mousePressed(java.awt.event.MouseEvent evt) {
            empTableMousePressed(evt);
        }
    });
    empTab.setViewportView(empTable);
    empPopMenu = new JPopupMenu();
    JMenuItem deleteEmp = new JMenuItem("Delete Employee");
    JMenuItem demoteEmp = new JMenuItem("Make Worker");
    JMenuItem promoteEmp = new JMenuItem("Make Moderator");
    empPopMenu.add(deleteEmp);
    empPopMenu.add(demoteEmp);
    empPopMenu.add(promoteEmp);
    empTable.setComponentPopupMenu(empPopMenu);

    promoteEmp.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e10){
            try{
                String selEmail = empTable.getValueAt(empTable.getSelectedRow(), 2).toString();
                Connection con = conn.connDb();
                Statement st = con.createStatement();
                empTable.setValueAt("MODERATOR", empTable.getSelectedRow(), 4);
                String query = "UPDATE users.users_table SET users_type = 'MODERATOR' WHERE users_email ='" + selEmail +"'";
                st.executeUpdate(query);
            } catch(SQLException e2){
                Logger.getLogger(adminGUI.class.getName()).log(Level.SEVERE, null, e2);
            } catch(Exception e){
                Helper.Helper.showMsg("choose");
            }

        }

    });

    demoteEmp.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e10){
            try{
                String selEmail = empTable.getValueAt(empTable.getSelectedRow(), 2).toString();
                Connection con = conn.connDb();
                Statement st = con.createStatement();
                empTable.setValueAt("WORKER", empTable.getSelectedRow(), 4);
                String query = "UPDATE users.users_table SET users_type = 'WORKER' WHERE users_email ='" + selEmail +"'";
                st.executeUpdate(query);
            } catch(SQLException e2){
                Logger.getLogger(adminGUI.class.getName()).log(Level.SEVERE, null, e2);
            } catch(Exception e){
                Helper.Helper.showMsg("choose");
            }

        }

    });

    deleteEmp.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e10){
            try{
                String selEmail = empTable.getValueAt(empTable.getSelectedRow(), 2).toString();
                Connection con = conn.connDb();
                Statement st = con.createStatement();
                empTableModel.removeRow(empTable.getSelectedRow());
                String query = "DELETE FROM users.users_table WHERE users_EMAİL = '" + selEmail +"'";
                st.executeUpdate(query);
            } catch(SQLException e2){
                Logger.getLogger(adminGUI.class.getName()).log(Level.SEVERE, null, e2);
            } catch(Exception e){
                Helper.Helper.showMsg("choose");
            }

        }

    });

    empPopMenu.addMouseListener(new MouseAdapter(){
        public void mousePressed(MouseEvent mevt2){
            Point point = mevt2.getPoint();
            int selectedRow = empTable.rowAtPoint(point);
            empTable.setRowSelectionInterval(selectedRow, selectedRow);
        }
    });

    tabs.addTab("Employees", empTab);

    contentPane.add(tabs, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 480, 520));

    logoutBtn.setText("Logout");
    logoutBtn.setFocusPainted(false);
    logoutBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            logoutBtnActionPerformed(evt);
        }
    });
    contentPane.add(logoutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 110, -1));

    refreshBtn.setText("Refresh");
    refreshBtn.setFocusPainted(false);
    refreshBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            refreshBtnActionPerformed(evt);
        }
    });
    contentPane.add(refreshBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 110, -1));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(contentPane, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(contentPane, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        dispose();
        LoginPage.Login();
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void composetoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_composetoFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_composetoFieldActionPerformed

    private void composesubjectFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_composesubjectFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_composesubjectFieldActionPerformed

    private void empTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empTableMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_empTableMousePressed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        inboxModel.setRowCount(0);
        spamModel.setRowCount(0);
        archModel.setRowCount(0);
        trashModel.setRowCount(0);
        try{
            inboxModel.setRowCount(0);
            spamModel.setRowCount(0);
            archModel.setRowCount(0);
            trashModel.setRowCount(0);
            sentModel.setRowCount(0);
            for (int i = 0; i < admin.getMailList(admin.getId()).size(); i++){
                switch(admin.getMailList(admin.getId()).get(i).getMailBox()){
                    case "1":
                    inboxData[0] = admin.getMailList(admin.getId()).get(i).getMailTime();
                    inboxData[1] = admin.getMailList(admin.getId()).get(i).getMailFrom();
                    inboxData[2] = admin.getMailList(admin.getId()).get(i).getMailSubject();
                    inboxModel.addRow(inboxData);
                    break;
                    case "2":
                    spamData[0] = admin.getMailList(admin.getId()).get(i).getMailTime();
                    spamData[1] = admin.getMailList(admin.getId()).get(i).getMailFrom();
                    spamData[2] = admin.getMailList(admin.getId()).get(i).getMailSubject();
                    spamModel.addRow(spamData);
                    break;
                    case "3":
                    archData[0] = admin.getMailList(admin.getId()).get(i).getMailTime();
                    archData[1] = admin.getMailList(admin.getId()).get(i).getMailFrom();
                    archData[2] = admin.getMailList(admin.getId()).get(i).getMailSubject();
                    archModel.addRow(archData);
                    break;
                    case "4":
                    trashData[0] = admin.getMailList(admin.getId()).get(i).getMailTime();
                    trashData[1] = admin.getMailList(admin.getId()).get(i).getMailFrom();
                    trashData[2] = admin.getMailList(admin.getId()).get(i).getMailSubject();
                    trashModel.addRow(trashData);
                    break;
                    case "5":
                    sentData[0] = admin.getMailList(admin.getId()).get(i).getMailTime();
                    sentData[1] = admin.getMailList(admin.getId()).get(i).getMailTo();
                    sentData[2] = admin.getMailList(admin.getId()).get(i).getMailSubject();
                    sentModel.addRow(sentData);
                    break;
                }
            }
        }catch(Exception e){

        }
    }//GEN-LAST:event_refreshBtnActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(adminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminGUI(admin).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu archMenu;
    private javax.swing.JTable archTable;
    private javax.swing.JScrollPane archieveTab;
    private javax.swing.JButton clearButton;
    private javax.swing.JScrollPane composemailTab;
    private javax.swing.JTextField composesubjectField;
    private javax.swing.JLabel composesubjectLabel;
    private javax.swing.JLabel composesubjectLabel1;
    private javax.swing.JTextField composetoField;
    private javax.swing.JLabel composetoLabel;
    private javax.swing.JPanel contentPane;
    private javax.swing.JScrollPane empTab;
    private javax.swing.JPopupMenu empPopMenu;
    private javax.swing.JTable empTable;
    private javax.swing.JScrollPane inboxTab;
    private javax.swing.JPopupMenu inboxMenu;
    private javax.swing.JTable inboxTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JButton sendButton;
    private javax.swing.JScrollPane sentTab;
    private javax.swing.JPopupMenu sentMenu;
    private javax.swing.JTable sentTable;
    private javax.swing.JScrollPane spamTab;
    private javax.swing.JPopupMenu spamMenu;
    private javax.swing.JTable spamTable;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JScrollPane trashTab;
    private javax.swing.JPopupMenu trashMenu;
    private javax.swing.JTable trashTable;
    private javax.swing.JLabel welcomeText;
    // End of variables declaration//GEN-END:variables
}
