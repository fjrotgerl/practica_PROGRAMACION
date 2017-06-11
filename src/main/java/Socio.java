import java.sql.Date;

/**
 * Created by Kekko on 11/06/2017.
 */
class Socio {
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
    Date fechaBaja;

    Socio(int numSocio, String dni, String nombre, String primerApellido, String segundoApellido, Date fechaNacimiento, String genero, String direccion, int cp, String provincia, String pais, int tel1, int tel2, String email, Date fechaBaja) {
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
        this.fechaBaja = fechaBaja;
    }
}