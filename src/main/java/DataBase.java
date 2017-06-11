import javax.swing.*;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Kekko on 23/05/2017.
 */
public class DataBase {

    static DataBase dataBase = new DataBase();

    public DataBase() {
    }

    public boolean checkLogin(String user, String password) throws Exception {
        // Connection c = DriverManager.getConnection("jdbc:mysql://172.16.7.130/BIBLIOTECA", "root", "123");
       // Connection c = DriverManager.getConnection("jdbc:mysql://192.168.1.54/BIBLIOTECA", "root", "123");
        Connection c = DriverManager.getConnection("jdbc:mysql://10.82.246.141/BIBLIOTECA", "root", "123");

        Statement s = c.createStatement();
        try {
            ResultSet rs = s.executeQuery("SELECT COUNT(USUARIO),COUNT(CONTRASEÑA) FROM BIBLIOTECARIO WHERE USUARIO = '" + user + "' AND CONTRASEÑA = MD5('" + password + "');");
            while (rs.next()) {
                if (rs.getInt(1) == 1) {
                    return true;
                }
            }
            c.close();

        } catch (Exception e) {
            System.out.println("Fallo en el usuario y/o contraseña");
            e.printStackTrace();
        } finally{
            if(c != null) c.close();
            if(s != null)  s.close();
        }
        return false;
    }

      /////////////
     // SOCIOS  //
    ////////////

    // Hacemos un insert de socio
    public void insertSocio(String dni, String nombre, String apellido1, String apellido2, int año, int mes, int dia, String genero, String direccion, int cp, String provincia, String pais, int tel1, int tel2, String email) throws Exception {
        PreparedStatement psInsertar = null;
        //Connection c = DriverManager.getConnection("jdbc:mysql://192.168.1.54/BIBLIOTECA", "root", "123");
        //Connection c = DriverManager.getConnection("jdbc:mysql://172.16.7.130/BIBLIOTECA", "root", "123");
        Connection c = DriverManager.getConnection("jdbc:mysql://10.82.246.141/BIBLIOTECA", "root", "123");
        Statement s = c.createStatement();
        try {
            // Insert into
            if (null == psInsertar) {
                psInsertar = c.prepareStatement("INSERT INTO SOCIO VALUES (NULL,'" + dni +
                        "','" + nombre +
                        "','" + apellido1 +
                        "','" + apellido2 +
                        "','" + año + "-" + mes + "-" + dia +
                        "','" + genero + "','"
                        + direccion +
                        "','" + cp +
                        "','" + provincia +
                        "','" + pais +
                        "','" + tel1 +
                        "','"+ tel2 +
                        "','" + email +
                        "', NULL);");
                psInsertar.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(c != null) c.close();
            if(s != null)  s.close();
        }
    }

    List getSocios(){
        try {
            List<Socio> socios = new LinkedList<Socio>();
            Connection c = DriverManager.getConnection("jdbc:mysql://10.82.246.141/BIBLIOTECA", "root", "123");
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM SOCIO");
            while (rs.next()) {
                int id = rs.getInt(1);
                String dni = rs.getString(2);
                String nombre = rs.getString(3);
                String primerApellido = rs.getString(4);
                String segundoApellido = rs.getString(5);
                Date fechaNacimiento = rs.getDate(6);
                String genero = rs.getString(7);
                String direccion = rs.getString(8);
                int cp = rs.getInt(9);
                String provincia = rs.getString(10);
                String pais = rs.getString(11);
                int tel1 = rs.getInt(12);
                int tel2 = rs.getInt(13);
                String email = rs.getString(14);
                Date fechaBaja = rs.getDate(15);
                socios.add(new Socio(id,dni,nombre,primerApellido,segundoApellido,fechaNacimiento,genero,direccion,cp,provincia,pais,tel1,tel2,email,fechaBaja));
            }
            return socios;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Añadimos fecha de baja al socio
    public void deleteSocio(Socio socio) throws Exception {
        PreparedStatement psDelete = null;
        //Connection c = DriverManager.getConnection("jdbc:mysql://172.16.7.130/BIBLIOTECA", "root", "123");
       // Connection c = DriverManager.getConnection("jdbc:mysql://192.168.1.54/BIBLIOTECA", "root", "123");
        Connection c = DriverManager.getConnection("jdbc:mysql://10.82.246.141/BIBLIOTECA", "root", "123");

        Statement s = c.createStatement();
        try {
            if (psDelete == null) {
                psDelete = c.prepareStatement("UPDATE SOCIO SET FECHA_BAJA = NOW() WHERE NUM_SOCIO = " + socio.numSocio + ";");
                psDelete.execute();
            }
        } catch (Exception e) {
            System.out.println("Fallo al borrar el socio");
            e.printStackTrace();
        } finally{
            if(c != null) c.close();
            if(s != null)  s.close();
        }
    }

    // Eliminamos fecha de baja al socio
    public void darAltaSocio(Socio socio) throws Exception {
        PreparedStatement psDelete = null;
        //Connection c = DriverManager.getConnection("jdbc:mysql://172.16.7.130/BIBLIOTECA", "root", "123");
        // Connection c = DriverManager.getConnection("jdbc:mysql://192.168.1.54/BIBLIOTECA", "root", "123");
        Connection c = DriverManager.getConnection("jdbc:mysql://10.82.246.141/BIBLIOTECA", "root", "123");

        Statement s = c.createStatement();
        try {
            if (psDelete == null) {
                psDelete = c.prepareStatement("UPDATE SOCIO SET FECHA_BAJA = NULL WHERE NUM_SOCIO = " + socio.numSocio + ";");
                psDelete.execute();
            }
        } catch (Exception e) {
            System.out.println("Fallo al borrar el socio");
            e.printStackTrace();
        } finally{
            if(c != null) c.close();
            if(s != null)  s.close();
        }
    }

      //////////////
     // TEMATICA //
    //////////////

    public void añadirTematica(String tematica) throws Exception {
        PreparedStatement psInsertar = null;
        //Connection c = DriverManager.getConnection("jdbc:mysql://192.168.1.54/BIBLIOTECA", "root", "123");
        //Connection c = DriverManager.getConnection("jdbc:mysql://172.16.7.130/BIBLIOTECA", "root", "123");
        Connection c = DriverManager.getConnection("jdbc:mysql://10.82.246.141/BIBLIOTECA", "root", "123");
        Statement s = c.createStatement();
        try {
            // Insert into
            if (null == psInsertar) {
                psInsertar = c.prepareStatement("INSERT INTO TEMATICA VALUES('" + tematica + "');");
                psInsertar.execute();
            }
        } catch (Exception e) {
            System.out.println("Fallo al añadir la tematica");
        } finally{
            if(c != null) c.close();
            if(s != null)  s.close();
        }
    }

    public Socio getSocio(JTable table) {
        ModelTableSocio modeloSocio = (ModelTableSocio) table.getModel();
        return modeloSocio.getSocioAt(table.getSelectedRow());
    }

}
