import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.*;

/**
 * Created by Kekko on 06/06/2017.
 */
public class BajaAltaSocioForm {


    private JTable table;
    private JPanel mirarSocioPanel;
    private JButton borrarButton;
    private JButton cancelarButton;
    private JButton buscarButton;
    private JButton altaButton;

    final java.util.List<Socio> list = new ArrayList<Socio>();
    final DataBase db = new DataBase();

    public BajaAltaSocioForm() {

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Main.frame.getContentPane().getLayout();
                cl.show(Main.frame.getContentPane(),"inicioPanel");
                Main.configSimple(Main.frame,"Inicio");
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeTable();
            }

        });

        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    db.deleteSocio(Main.db.getSocio(table));
                    JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        altaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    db.darAltaSocio(Main.db.getSocio(table));
                    JOptionPane.showMessageDialog(null, "Se ha dado de alta correctamente");
                } catch (Exception ex) {
                    System.out.println("Fallo al dar de alta al socio");
                }
            }
        });
    }

    public void makeTable() {
        ModelTableSocio mts = new ModelTableSocio(new DataBase().getSocios());
        table.setModel(mts);
    }

    public JTable getTable() {
        return table;
    }

    public JPanel getEliminarSocioPanel() {
        return mirarSocioPanel;
    }
}