import java.util.ArrayList;
import java.util.List;

public class DonacionViveres extends Donacion {

    private List<Producto> productos = new ArrayList<>();
    private List<Integer> cantidades = new ArrayList<>();

    public DonacionViveres(Donante informacionDonador, Fecha fechaEntrega, String nroIdentificacion) {
        super(informacionDonador, fechaEntrega, nroIdentificacion);
    }

    public void agregarViver(Producto producto, int cantidad) {
        productos.add(producto);
        cantidades.add(cantidad);
    }

    public List<Producto> obtenerProductos() {
        return productos;
    }

    public List<Integer> obtenerCantidades() {
        return cantidades;
    }

    public int obtenerCantidadTotal() {
        int total = 0;
        for (int cantidad : cantidades) {
            total += cantidad;
        }
        return total;
    }

    public List<Producto> obtenerViveres() {
        return productos;
    }

}
