/*public class EleccionMenu {
    private Inventario inventario;
    private Beneficiario beneficiario;

    public EleccionMenu(Inventario inventario, Beneficiario beneficiario) {
        this.inventario = inventario;
        this.beneficiario = beneficiario;
    }

    public void elegirDesayuno() {
        int cantidadDesayunos = inventario.obtenerCantidadDesayuno();
        if (cantidadDesayunos > 0) {
            inventario.restarDesayuno();
            System.out.println("El beneficiario " + beneficiario.getNombre() + " ha elegido desayuno.");
        } else {
            System.out.println("Lo siento, no hay desayunos disponibles en el inventario.");
        }
    }

    public void elegirAlmuerzo() {
        int cantidadAlmuerzos = inventario.obtenerCantidadAlmuerzo();
        if (cantidadAlmuerzos > 0) {
            inventario.restarAlmuerzo();
            System.out.println("El beneficiario " + beneficiario.getNombre() + " ha elegido almuerzo.");
        } else {
            System.out.println("Lo siento, no hay almuerzos disponibles en el inventario.");
        }
    }

    public void elegirCena() {
        int cantidadCenas = inventario.obtenerCantidadCena();
        if (cantidadCenas > 0) {
            inventario.restarCena();
            System.out.println("El beneficiario " + beneficiario.getNombre() + " ha elegido cena.");
        } else {
            System.out.println("Lo siento, no hay cenas disponibles en el inventario.");
        }
    }
}*/
