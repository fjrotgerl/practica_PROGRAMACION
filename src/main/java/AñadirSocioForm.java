import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

/**
 * Created by Kekko on 23/05/2017.
 */
public class AñadirSocioForm {
    private JPanel añadirSociPanel;
    private JTextField nameText;
    private JComboBox comboBoxDia;
    private JComboBox<Integer> comboBoxAño;
    private JComboBox comboBoxMes;
    private JRadioButton hombreRadioButton;
    private JRadioButton mujerRadioButton;
    private JButton guardarButton;
    private JButton cancelarButton;
    private JTextField idText;
    private JTextField primerApellido;
    private JTextField segundoApellido;
    private JTextField dniText;
    private JTextField direccionText;
    private JTextField cpText;
    private JTextField provinciaText;
    private JTextField paisText;
    private JTextField tel1Text;
    private JTextField tel2Text;
    private JTextField emailText;

    public AñadirSocioForm() {
        for (int i = 2017; i > 1899; i--) {
            getComboBoxAño().addItem(i);
        }
        Main.frame.add(getComboBoxAño());

        cancelarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Main.frame.getContentPane().getLayout();
                cl.show(Main.frame.getContentPane(),"inicioPanel");
                Main.configSimple(Main.frame,"Inicio");
            }
        });

        guardarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    DataBase.dataBase.insertSocio(getDniText().getText(),
                            getNameText().getText(), getPrimerApellido().getText(), getSegundoApellido().getText(),
                            getDireccionText().getText(), Integer.parseInt(getCpText().getText()), getProvinciaText().getText(),
                            getPaisText().getText(), Integer.parseInt(getTel1Text().getText()), (Integer.parseInt(getTel2Text().getText())),
                            getEmailText().getText());
                    JOptionPane.showMessageDialog(null, "Se ha añadido correctamente");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "No se ha podido añadir al socio");
                }
            }

        });
    }

    public JPanel getAñadirSociPanel() {
        return añadirSociPanel;
    }

    public JTextField getDniText() {
        return dniText;
    }

    public JTextField getNameText() {
        return nameText;
    }

    public JComboBox getComboBoxDia() {
        return comboBoxDia;
    }

    public JComboBox getComboBoxAño() {
        return comboBoxAño;
    }

    public JComboBox getComboBoxMes() {
        return comboBoxMes;
    }

    public JRadioButton getHombreRadioButton() {
        return hombreRadioButton;
    }

    public JRadioButton getMujerRadioButton() {
        return mujerRadioButton;
    }

    public JTextField getIdText() {
        return idText;
    }

    public JTextField getPrimerApellido() {
        return primerApellido;
    }

    public JTextField getSegundoApellido() {
        return segundoApellido;
    }

    public JTextField getDireccionText() {
        return direccionText;
    }

    public JTextField getCpText() {
        return cpText;
    }

    public JTextField getProvinciaText() {
        return provinciaText;
    }

    public JTextField getPaisText() {
        return paisText;
    }

    public JTextField getTel1Text() {
        return tel1Text;
    }

    public JTextField getTel2Text() {
        return tel2Text;
    }

    public JTextField getEmailText() {
        return emailText;
    }
}
