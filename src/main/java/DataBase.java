import java.sql.*;

/**
 * Created by Kekko on 23/05/2017.
 */
public class DataBase {
    private String db;
    private String server;
    private String username;
    private String password;

    static DataBase dataBase = new DataBase();

    public DataBase() {
    }

    public boolean checkLogin(String user, String password) throws Exception {
        Connection c = DriverManager.getConnection("jdbc:mysql://172.16.7.130/BIBLIOTECA", "root", "123");
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

    public void insertSocio(String dni, String nombre, String apellido1, String apellido2, String direccion, int cp, String provincia, String pais, int tel1, int tel2, String email) throws Exception {
        PreparedStatement psInsertar = null;
        Connection c = DriverManager.getConnection("jdbc:mysql://172.16.7.130/BIBLIOTECA", "root", "123");
        Statement s = c.createStatement();
        try {
            // Insert into
            if (null == psInsertar) {
                psInsertar = c.prepareStatement("INSERT INTO SOCIO VALUES (NULL,'" + dni +
                        "','" + nombre +
                        "','" + apellido1 +
                        "','" + apellido2 +
                        "',now(),'HOMBRE','" + direccion +
                        "','" + cp +
                        "','" + provincia +
                        "','" + pais +
                        "','" + tel1 +
                        "','"+ tel2 +
                        "','" + email + "');");
                psInsertar.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(c != null) c.close();
            if(s != null)  s.close();
        }
    }

    public int getTotalSocios() throws Exception {
        Connection c = DriverManager.getConnection("jdbc:mysql://172.16.7.130/BIBLIOTECA", "root", "123");
        Statement s = c.createStatement();
        try {
            ResultSet rs = s.executeQuery("SELECT NUM_SOCIO FROM SOCIO;");
            int cont = 0;
            while (rs.next()) {
                cont++;
            }
            return cont;
        } catch (Exception e) {
            System.out.println("Fallo al contar las filas");
            e.printStackTrace();
        } finally{
            if(c != null) c.close();
            if(s != null)  s.close();
        }
        return 0;
    }

    public String getSocioString(String columnName, int id) throws Exception {
        Connection c = DriverManager.getConnection("jdbc:mysql://172.16.7.130/BIBLIOTECA", "root", "123");
        Statement s = c.createStatement();
        try {
            ResultSet rs = s.executeQuery("SELECT " + columnName + " FROM SOCIO;");
            while (rs.next()) {
                return new String(rs.getString(1));
            }
        } catch (Exception e) {
            System.out.println("Fallo al obtener el dato");
            e.printStackTrace();
        } finally{
            if(c != null) c.close();
            if(s != null)  s.close();
        }
        return null;
    }

    public int getSocioInt(String columnName, int id) throws Exception{
        Connection c = DriverManager.getConnection("jdbc:mysql://172.16.7.130/BIBLIOTECA", "root", "123");
        Statement s = c.createStatement();
        try {
            ResultSet rs = s.executeQuery("SELECT " + columnName + " FROM SOCIO WHERE NUM_SOCIO = " + id + ";");
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Fallo al obtener el dato");
            e.printStackTrace();
        } finally{
            if(c != null) c.close();
            if(s != null)  s.close();
        }
        return 0;
    }

    public Date getSocioDate(String columnName, int id) throws Exception{
        Connection c = DriverManager.getConnection("jdbc:mysql://172.16.7.130/BIBLIOTECA", "root", "123");
        Statement s = c.createStatement();
        try {
            ResultSet rs = s.executeQuery("SELECT " + columnName + " FROM SOCIO WHERE NUM_SOCIO = " + id + ";");
            while (rs.next()) {
                return rs.getDate(1);
            }
            c.close();
        } catch (Exception e) {
            System.out.println("Fallo al obtener el dato");
            e.printStackTrace();
        } finally{
            if(c != null) c.close();
            if(s != null)  s.close();
        }
        return null;
    }

    public int getMinID() throws Exception{
        Connection c = DriverManager.getConnection("jdbc:mysql://172.16.7.130/BIBLIOTECA", "root", "123");
        Statement s = c.createStatement();
        try {
            ResultSet rs = s.executeQuery("SELECT MIN(NUM_SOCIO) FROM SOCIO");
            while (rs.next()) {
                return rs.getInt(1);
            }
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(c != null) c.close();
            if(s != null)  s.close();
        }
        return 0;
    }
}
