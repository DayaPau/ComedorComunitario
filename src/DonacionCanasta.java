import java.util.ArrayList;
import java.util.List;

public class DonacionCanasta extends Donacion {
    public enum TipoCanasta {
        DESAYUNO,
        ALMUERZO,
        CENA
    }

    private TipoCanasta tipoCanasta;

    // Lista para almacenar la cantidad de cada tipo de canasta
    private List<TipoCanasta> listaCantidades = new ArrayList<>();

    public DonacionCanasta(Donante informacionDonador, Fecha fechaEntrega, String nroIdentificacion, TipoCanasta tipoCanasta) {
        super(informacionDonador, fechaEntrega, nroIdentificacion);
        this.tipoCanasta = tipoCanasta;
        // Inicializar la lista con la primera canasta
        listaCantidades.add(tipoCanasta);
    }

    // Método para obtener el tipo de canasta
    public TipoCanasta obtenerTipoCanasta() {
        return tipoCanasta;
    }

    // Método para obtener la lista de cantidades de cada tipo de canasta
    public List<TipoCanasta> obtenerListaCantidades() {
        return listaCantidades;
    }

    // Método para agregar una donación de canasta a la lista
    public void agregarDonacion() {
        listaCantidades.add(tipoCanasta);
    }

    // Método para obtener la cantidad de cada tipo de canasta
    public int obtenerCantidadPorTipo(TipoCanasta tipo) {
        int count = 0;
        for (TipoCanasta canasta : listaCantidades) {
            if (canasta == tipo) {
                count++;
            }
        }
        return count;
    }
}
