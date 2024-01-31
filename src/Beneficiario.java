import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Beneficiario {
    private String nombre;
    private String apellido;
    private String cedula;
    private String genero;
    private Date fechaRegistro;

    // private EleccionMenu eleccion;


    public Beneficiario(String nombre, String apellido, String cedula, String genero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.genero = genero;
        this.fechaRegistro = new Date();

    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getCedula() {
        return cedula;
    }

    @Override
    public String toString() {
        return "Beneficiario" +
                "\nnombre =  " + nombre +
                "\napellido =  " + apellido +
                "\ncedula =  " + cedula +
                "\ngenero =  " + genero +
                "\nfechaRegistro =  " + fechaRegistro;
    }
}


