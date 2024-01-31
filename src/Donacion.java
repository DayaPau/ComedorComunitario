public class Donacion {

    private Donante informacionDonador;
    private Fecha fechaRegistroDonacion;
    private Fecha fechaEntrega;
    private String nroIdentificacion;

    public Donacion(Donante informacionDonador, Fecha fechaEntrega, String nroIdentificacion) {
        this.informacionDonador = informacionDonador;
        this.fechaRegistroDonacion = new Fecha(0, 0, 0);
        fechaRegistroDonacion.darFechaActual();
        this.fechaEntrega = new Fecha(0, 0, 0);
        fechaEntrega.obtenerFechaActualMas3();
        this.nroIdentificacion = nroIdentificacion;
    }




    // Método para obtener la cantidad total donada
    public int obtenerCantidadTotal() {
        if (this instanceof DonacionViveres) {
            DonacionViveres donacionViveres = (DonacionViveres) this;
            return donacionViveres.obtenerCantidadTotal();
        } else if (this instanceof DonacionCanasta) {
            DonacionCanasta donacionCanasta = (DonacionCanasta) this;
            return donacionCanasta.obtenerCantidadTotal();
        }
        return 0;
    }

    // Método para obtener la cantidad donada de un producto específico
    public int obtenerCantidadPorProducto(Producto producto) {
        if (this instanceof DonacionViveres) {
            DonacionViveres donacionViveres = (DonacionViveres) this;
            return donacionViveres.obtenerCantidadPorProducto(producto);
        }
        return 0;
    }
}

