import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<DonacionViveres> viveres;
    private List<DonacionCanasta> canastas;

    public Inventario() {
        this.viveres = new ArrayList<>();
        this.canastas = new ArrayList<>();
    }

    public List<DonacionViveres> getViveres() {
        return viveres;
    }

    public List<DonacionCanasta> getCanastas() {
        return canastas;
    }

    public void agregarViveres(DonacionViveres donacionViveres) {
        viveres.add(donacionViveres);
    }

    public void agregarCanasta(DonacionCanasta donacionCanasta) {
        canastas.add(donacionCanasta);
    }

    public List<String> obtenerInventarioCompleto() {
        List<String> inventarioCompleto = new ArrayList<>();

        for (DonacionViveres viver : viveres) {
            inventarioCompleto.add("Viveres: " + viver.obtenerViveres().toString());
        }

        for (DonacionCanasta canasta : canastas) {
            inventarioCompleto.add("Canasta - Tipo: " + canasta.obtenerTipoCanasta() +
                    ", Cantidad: " + canasta.obtenerListaCantidades().size());
        }

        return inventarioCompleto;
    }

    // Otros métodos según sea necesario
}
