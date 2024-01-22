import java.util.ArrayList;
import java.util.List;

public class Donante {
    private String nombre;
    private String apellido;
    private String genero;
    private String celular;
    private String cedula;
    private String direccion;
    private List<Donacion> donaciones;

    public Donante(String nombre, String apellido, String genero, String celular, String cedula, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.celular = celular;
        this.cedula = cedula;
        this.direccion = direccion;
        this.donaciones = new ArrayList<Donacion>();
    }

    // Otros métodos y atributos

    public void registrarDonacion(Donacion donacion){}

    public void añadirDonacion(Donacion donacion) {
        donaciones.add(donacion);
    }



    public int cuantasCanastasHeDonado() {
        int countCanastas = 0;
        for (Donacion donacion : donaciones) {
            if (donacion instanceof DonacionCanasta) {  //devuelve true si el objeto a la izquierda es una instancia de la clase o interfaz a la derecha
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
    public int cuantasVecesHeDonado() {
        return donaciones.size();
    }


    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getGenero() {
        return genero;
    }

    public String getCelular() {
        return celular;
    }

    public String getCedula() {
        return cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }





    @Override
    public String toString() {
        return "Donante" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", genero='" + genero + '\'' +
                ", celular='" + celular + '\'' +
                ", cedula='" + cedula + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }


}
