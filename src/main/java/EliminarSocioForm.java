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
public class EliminarSocioForm {


    private JTable table;
    private JPanel mirarSocioPanel;
    private JButton borrarButton;
    private JButton cancelarButton;
    private JButton buscarButton;

    public EliminarSocioForm() throws Exception{
        final java.util.List<Socio> list = new ArrayList<Socio>();
        DataBase db = new DataBase();

        for (int i = db.getMinID(); i < db.getTotalSocios()+1; i++) {
            list.add(new Socio(i, db.getSocioString("DNI",i), db.getSocioString("NOMBRE",i),
                    db.getSocioString("PRIMER_APELLIDO",i), db.getSocioString("SEGUNDO_APELLIDO",i),
                    db.getSocioDate("FECHA_NACIMIENTO",i), db.getSocioString("GENERO",i),
                    db.getSocioString("DIRECCION",i),db.getSocioInt("CP",i),
                    db.getSocioString("PROVINCIA",i),db.getSocioString("PAIS",i),
                    db.getSocioInt("TELEFONO_1",i),db.getSocioInt("TELEFONO_2",i),
                    db.getSocioString("EMAIL",i)));
        }

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
                TableModel tm = new AbstractTableModel()  {
                    public int getRowCount() {
                        return list.size();
                    }

                    @Override
                    public String getColumnName(int col) {
                        switch(col) {
                            case 0:
                                return "Nº socio";
                            case 1:
                                return "DNI";
                            case 2:
                                return "Nombre";
                            case 3:
                                return "Primer apellido";
                            case 4:
                                return "Segundo apellido";
                            case 5:
                                return "Fecha de nacimiento";
                            case 6:
                                return "Genero";
                            case 7:
                                return "Direccion";
                            case 8:
                                return "CP";
                            case 9:
                                return "Provincia";
                            case 10:
                                return "Pais";
                            case 11:
                                return "Telefono 1";
                            case 12:
                                return "Telefono 2";
                            case 13:
                                return "Email";
                        }
                        throw new RuntimeException("Impossible");
                    }

                    @Override
                    public int getColumnCount() {
                        return 14;
                    }

                    public Object getValueAt(int i, int i1) {
                        Socio s = list.get(i);
                        switch (i1) {
                            case 0:
                                return s.numSocio;
                            case 1:
                                return s.dni;
                            case 2:
                                return s.nombre;
                            case 3:
                                return s.primerApellido;
                            case 4:
                                return s.segundoApellido;
                            case 5:
                                return s.fechaNacimiento;
                            case 6:
                                return s.genero;
                            case 7:
                                return s.direccion;
                            case 8:
                                return s.cp;
                            case 9:
                                return s.provincia;
                            case 10:
                                return s.pais;
                            case 11:
                                return s.tel1;
                            case 12:
                                return s.tel2;
                            case 13:
                                return s.email;
                        }
                        throw new RuntimeException("Impossible");
                    }
                };
                table.setModel(tm);
            }
        });

        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    static class Socio {
        int numSocio;
        String dni;
        String nombre;
        String primerApellido;
        String segundoApellido;
        Date fechaNacimiento;
        String genero;
        String direccion;
        int cp;
        String provincia;
        String pais;
        int tel1;
        int tel2;
        String email;

        Socio(int numSocio, String dni, String nombre, String primerApellido, String segundoApellido, Date fechaNacimiento, String genero, String direccion, int cp, String provincia, String pais, int tel1, int tel2, String email) {
            this.numSocio = numSocio;
            this.dni = dni;
            this.nombre = nombre;
            this.primerApellido = primerApellido;
            this.segundoApellido = segundoApellido;
            this.fechaNacimiento = fechaNacimiento;
            this.genero = genero;
            this.direccion = direccion;
            this.cp = cp;
            this.provincia = provincia;
            this.pais = pais;
            this.tel1 = tel1;
            this.tel2 = tel2;
            this.email = email;
        }
    }

    public JTable getTable() {
        return table;
    }

    public JPanel getEliminarSocioPanel() {
        return mirarSocioPanel;
    }
}