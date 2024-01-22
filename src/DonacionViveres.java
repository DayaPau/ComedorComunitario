import java.util.ArrayList;
import java.util.List;

public class DonacionViveres extends Donacion {

    private List<Producto> viveres;
    private List<Integer> cantidad;

    public DonacionViveres(Donante informacionDonador, Fecha fechaEntrega, String nroIdentificacion) {
        super(informacionDonador, fechaEntrega, nroIdentificacion);
        this.viveres = new ArrayList<>();
        this.cantidad = new ArrayList<>();
    }

    public void agregarViver(Producto producto, int cantidad) {
        viveres.add(producto);
        this.cantidad.add(cantidad);
    }

    public List<Producto> obtenerViveres() {
        return viveres;
    }

    public List<Integer> obtenerCantidad() {
        return cantidad;
    }

    public int obtenerCantidadTotalViveres() {
        return viveres.size();
    }

    public int obtenerCantidadTotal() {
        int total = 0;
        for (int cant : cantidad) {
            total += cant;
        }
        return total;
    }
}

