import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kekko on 11/06/2017.
 */
public class AñadirTematicaForm {
    private JTextField tematicaText;
    private JButton añadirButton;
    private JPanel tematicaPanel;

    public AñadirTematicaForm() {
        añadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Main.db.añadirTematica(tematicaText.getText());
                    JOptionPane.showMessageDialog(null, "Temática añadida");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Fallo al añadir temática");
                    System.out.println("Fallo al añadir la tematica");
                }
            }
        });
    }

    public JPanel getTematicaPanel() {
        return tematicaPanel;
    }
}
