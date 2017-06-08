import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by pnegre on 29/05/17.
 */
public class porva {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        final JComboBox<Integer> comboBoxAños = new JComboBox<Integer>();
        for (int i = 2017; i > 1899; i--) {
            comboBoxAños.addItem(i);
        }

        final JComboBox<String> comboBoxMeses = new JComboBox<String>();
        String[] meses =  {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        for (int i = 0; i < 12; i++) {
            comboBoxMeses.addItem(meses[i]);
        }

        final JComboBox<Integer> comboBoxDias = new JComboBox<Integer>();
        for (int i = 1; i < 32; i++) {
            comboBoxDias.addItem(i);
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(500, 500);
        frame.add(comboBoxDias);
        frame.add(comboBoxMeses);
        frame.add(comboBoxAños);
        frame.setVisible(true);
    }
}

