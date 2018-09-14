import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        JFrame frame = new JFrame();
        RegisterEdit OX_Game = new RegisterEdit();
        frame.setContentPane((new RegisterEdit()).getMainPanel());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.setMinimumSize(new Dimension(500,500));
    }
}
