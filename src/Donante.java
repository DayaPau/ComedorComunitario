import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Donante {
    private String nombre;
    private String apellido;
    private String genero;
    private String celular;
    private String cedula;
    private String direccion;
    private List<Donacion> donaciones;
    private Date fechaRegistro;


    public Donante(String nombre, String apellido, String genero, String celular, String cedula, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.celular = celular;
        this.cedula = cedula;
        this.direccion = direccion;
        this.donaciones = new ArrayList<>();
        this.fechaRegistro = new Date();
    }

    public void añadirDonacion(Donacion donacion) {
        donaciones.add(donacion);
    }

    public String getDireccion(){
        return direccion;
    }
    public int cuantasVecesHeDonado() {
        return donaciones.size();
    }

    public String getCedula() {
        return cedula;
    }
    public int cuantasCanastasHeDonado() {
        int countCanastas = 0;
        for (Donacion donacion : donaciones) {
            if (donacion instanceof DonacionCanasta) {
                countCanastas++;
            }
        }
        return countCanastas;
    }
    public int cuantosViveresHeDonado() {
        int countViveres = 0;
        for (Donacion donacion : donaciones) {
            if (donacion instanceof DonacionViveres) {
                countViveres += ((DonacionViveres) donacion).obtenerViveres().size();
            }
        }
        return countViveres;
    }


    @Override
    public String toString() {
        return "Donante" +
                "\nnombre =  " + nombre +
                "\napellido =  " + apellido +
                "\ngenero =  " + genero +
                "\ncelular = " + celular +
                "\ncedula =  " + cedula +
                "\ndireccion =  " + direccion +
                "\nfechaRegistro =  " + fechaRegistro;
    }
}


