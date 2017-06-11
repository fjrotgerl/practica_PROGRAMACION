import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by Kekko on 11/06/2017.
 */
public class ModelTableSocio  extends AbstractTableModel{
    private List<Socio> listSocio;

    public ModelTableSocio(List<Socio> socios) {
        this.listSocio = socios;
    }

    @Override
    public int getRowCount() {
        return listSocio.size();
    }

    public Socio getSocioAt(int row) {
        return listSocio.get(row);
    }

    @Override
    public int getColumnCount() {
        return 15;
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
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
            case 14:
                return "Fecha baja";
        }
        throw new RuntimeException("Impossible");
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Socio s = listSocio.get(rowIndex);
        switch (columnIndex) {
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
            case 14:
                return s.fechaBaja;
        }
        throw new RuntimeException("Impossible");
    }
}
