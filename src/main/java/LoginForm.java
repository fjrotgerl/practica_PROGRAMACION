import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kekko on 23/05/2017.
 */
public class LoginForm {

    private JButton loginButton;
    private JFormattedTextField userName;
    private JPasswordField userPass;
    private JPanel loginPanel;

    private boolean checkLogin;

    public LoginForm() {
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    checkLogin = DataBase.dataBase.checkLogin(userName.getText(), new String(userPass.getPassword()));
                    if (checkLogin) {
                        CardLayout cl = (CardLayout) Main.frame.getContentPane().getLayout();
                        cl.show(Main.frame.getContentPane(), "inicioPanel");
                        Main.configSimple(Main.frame, "Inicio");
                        Main.initMenu(Main.frame);
                    } else {
                        JOptionPane.showMessageDialog(null, "Login erróneo");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public JPanel getLoginPanel() {
        return loginPanel;
    }

}
