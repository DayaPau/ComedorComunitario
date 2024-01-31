import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Donacion> donaciones = new ArrayList<>();
    private List<Producto> productos = new ArrayList<>();
    private List<Integer> cantidades = new ArrayList<>();
    private int cantDesayuno = 0;
    private int cantAlmuerzo = 0;
    private int cantCena = 0;

    public void agregarDonacion(Donacion donacion) {
        donaciones.add(donacion);
        if (donacion instanceof DonacionCanasta) {
            DonacionCanasta donacionCanasta = (DonacionCanasta) donacion;
            List<DonacionCanasta.TipoCanasta> listaCantidades = donacionCanasta.obtenerListaCantidades();
            for (DonacionCanasta.TipoCanasta tipoCanasta : listaCantidades) {
                switch (tipoCanasta) {
                    case DESAYUNO:
                        cantDesayuno += 1;
                        break;
                    case ALMUERZO:
                        cantAlmuerzo += 1;
                        break;
                    case CENA:
                        cantCena += 1;
                        break;
                }
            }
        } else if (donacion instanceof DonacionViveres) {
            // Procesar DonacionViveres
            DonacionViveres donacionViveres = (DonacionViveres) donacion;
            // Actualizar cantidades de productos
            actualizarCantidadesProductos(donacionViveres);
        }
    }




    private void actualizarCantidadesProductos(DonacionViveres donacionViveres) {
        List<Producto> productosDonacion = donacionViveres.obtenerProductos();
        List<Integer> cantidadesDonacion = donacionViveres.obtenerCantidades();

        for (int i = 0; i < productosDonacion.size(); i++) {
            Producto producto = productosDonacion.get(i);
            int cantidad = cantidadesDonacion.get(i);

            int index = productos.indexOf(producto);
            if (index != -1) {
                cantidades.set(index, cantidades.get(index) + cantidad);
            } else {
                productos.add(producto);
                cantidades.add(cantidad);
            }
        }
    }

    public int obtenerCantidadDesayuno() {
        return cantDesayuno;
    }

    public int obtenerCantidadAlmuerzo() {
        return cantAlmuerzo;
    }

    public int obtenerCantidadCena() {
        return cantCena;
    }

    public int obtenerCantidadProductos() {
        return productos.size();
    }

    public int obtenerCantidadPorCanasta(DonacionCanasta.TipoCanasta tipoCanasta) {
        switch (tipoCanasta) {
            case DESAYUNO:
                return cantDesayuno;
            case ALMUERZO:
                return cantAlmuerzo;
            case CENA:
                return cantCena;
            default:
                return 0;
        }
    }

    public void mostrarProductosDonados() {
        System.out.println("Productos donados:");
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            int cantidad = cantidades.get(i);
            System.out.println(producto.name() + ": " + cantidad);
        }
    }
    public int obtenerCantidadTotal() {
        int total = 0;
        for (Donacion donacion : donaciones) {
            if (donacion instanceof DonacionCanasta) {
                total += ((DonacionCanasta) donacion).obtenerCantidadTotal();
            } else if (donacion instanceof DonacionViveres) {
                total += ((DonacionViveres) donacion).obtenerCantidadTotal();
            }
        }
        return total;
    }

}

