import javax.swing.*;
import java.awt.*;
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
    private JPanel panelRegister;


    public RegisterEdit () {

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

//                JOptionPane.showMessageDialog(null,txtUsername.getText()+" "+
//                        new String(txtPassword.getPassword())+" "+ txtEmail.getText());


                /*if(txtUsername.equals(" ")|| txtPassword.equals(" ") || txtRePassword.equals(" ") || txtEmail.equals(" ")) {

                    JOptionPane.showMessageDialog(null, "\n" +
                            "ใส่ช้อมูลไม่ครบ");

                }*/
                PreparedStatement pst;

              if( new String(txtPassword.getPassword()).equals( new String(txtRePassword.getPassword()))){


                try{
        String serverName = "sql12.freemysqlhosting.net";
        String mydatabase = "sql12255832";
        String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
        String username = "sql12255832";
        String password = "VqusRaY3qH";
        Connection connection = DriverManager.getConnection(url, username, password);
        connection.createStatement();

                    String sql ="Insert into User(User_Name, User_Email, User_Password) values (?,?,?)";

                    pst=connection.prepareStatement(sql);
                    pst.setString(1, txtUsername.getText());
                    pst.setString(2, txtEmail.getText());
                    pst.setString(3,  new String(txtPassword.getPassword()));
                    pst.execute();


                    JOptionPane.showMessageDialog(null, "ลงทะเบียนเสร็จสิ้น");
                    txtUsername.setText("");
                    txtPassword.setText("");
                    txtRePassword.setText("");
                    txtEmail.setText("");

                }

                catch(Exception String) {
                    JOptionPane.showMessageDialog(null, e);

                } if( new String(txtPassword.getPassword()).equals( new String(txtRePassword.getPassword()))){
                      JOptionPane.showMessageDialog(null, "ลงทะเบียนเสร็จสิ้น");
                      txtUsername.setText("");
                      txtPassword.setText("");
                      txtRePassword.setText("");
                      txtEmail.setText("");
                  }


            }
                else{
                    JOptionPane.showMessageDialog(null, "รหัสผ่านไม่ตรงกัน");

                }

            }

            });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                txtUsername.setText("");
                txtPassword.setText("");
                txtRePassword.setText("");
                txtEmail.setText("");
            }
        });
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) throws SQLException {
        JFrame frame = new JFrame();
        RegisterEdit register = new RegisterEdit();
        frame.setContentPane(register.panelRegister);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(500,500));
        frame.setVisible(true);




        String serverName = "sql12.freemysqlhosting.net";
        String mydatabase = "sql12255832";
        String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
        String username = "sql12255832";
        String password = "VqusRaY3qH";
        Connection connection = DriverManager.getConnection(url, username, password);
        connection.createStatement();
        Statement s =    connection.createStatement();



    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
