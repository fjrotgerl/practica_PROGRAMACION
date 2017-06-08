import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * Created by Kekko on 24/05/2017.
 */
public class InicioForm {
    private JPanel inicioPanel;
    private JButton salirButton;
    private JButton cerrarSesiónButton;


    public InicioForm() {
        salirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.frame.dispatchEvent(new WindowEvent(Main.frame, WindowEvent.WINDOW_CLOSING));
            }
        });

        cerrarSesiónButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Main.frame.getContentPane().getLayout();
                cl.show(Main.frame.getContentPane(),"loginPanel");
                Main.configSimple(Main.frame,"Login");
                Main.frame.setSize(300, 150);
                Main.centreWindow(Main.frame);
                Main.frame.getJMenuBar().removeAll();
            }
        });
    }

    public JPanel getInicioPanel() {
        return inicioPanel;
    }
}
