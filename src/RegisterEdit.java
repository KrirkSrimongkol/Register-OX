import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class RegisterEdit {
    private JLabel Register;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JPasswordField txtRePassword;
    private JButton btnRegister;
    private JButton btnClear;
    private JLabel lblUsername;
    private JLabel lblPassword;
    private JLabel lblRePassword;
    private JLabel lblEmail;
    private JTextField txtEmail;
    private JPanel MainPanel;


    public RegisterEdit() throws SQLException {

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                PreparedStatement pst;

                if (txtUsername.getText().equals("") || txtEmail.getText().equals("") ||
                        new String(txtPassword.getPassword()).equals("") ||
                        new String(txtRePassword.getPassword()).equals("")) {
                    JOptionPane.showMessageDialog(null, "กรุณากรอกข้อมูลให้ครบ !");
                } else {
                    if (new String(txtPassword.getPassword()).equals(new String(txtRePassword.getPassword()))) {


                        try {
                            String serverName = "sql12.freemysqlhosting.net";
                            String mydatabase = "sql12255832";
                            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
                            String username = "sql12255832";
                            String password = "VqusRaY3qH";
                            Connection connection = DriverManager.getConnection(url, username, password);
                            connection.createStatement();
                            //เช็คว่ามี user นี้หรือยัง
                            String CheckUser = txtUsername.getText();
                            String sql = "SELECT User_Name FROM sql12255832.User where User_Name=?";
                            pst = connection.prepareStatement(sql);
                            pst.setString(1, CheckUser);
                            ResultSet rs = pst.executeQuery();

///

                            boolean russ = rs.next();
                            if (russ == true) {
                                JOptionPane.showMessageDialog(null, "มี User ซ้ำ");
                            } else {
                                InsertUser();
                            }


                        } catch (Exception String) {
                            JOptionPane.showMessageDialog(null, e);

                        }


                    } else {
                        JOptionPane.showMessageDialog(null, "รหัสผ่านไม่ตรงกัน");

                    }
                }


            }
        });

     /*   btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtUsername.setText("");
                txtPassword.setText("");
                txtRePassword.setText("");
                txtEmail.setText("");
            }
        });*/
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtUsername.setText("");
                txtPassword.setText("");
                txtRePassword.setText("");
                txtEmail.setText("");
            }
        });
    }

    public void InsertUser() {
        PreparedStatement pst;
        try {
            String serverName = "sql12.freemysqlhosting.net";
            String mydatabase = "sql12255832";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String username = "sql12255832";
            String password = "VqusRaY3qH";
            Connection connection = DriverManager.getConnection(url, username, password);
            connection.createStatement();

            String sql = "Insert into User(User_Name, User_Email, User_Password) values (?,?,?)";

            pst = connection.prepareStatement(sql);
            pst.setString(1, txtUsername.getText());
            pst.setString(2, txtEmail.getText());
            pst.setString(3, new String(txtPassword.getPassword()));
            pst.execute();
            JOptionPane.showMessageDialog(null, "กรอกข้อมูลสำเห็จ");
            txtUsername.setText("");
            txtPassword.setText("");
            txtRePassword.setText("");
            txtEmail.setText("");
        } catch (Exception String) {

        }

        }
    public JPanel getMainPanel () { return MainPanel;}
    }


