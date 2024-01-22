public class Donacion {

        private Donante informacionDonador;
        private Fecha fechaRegistroDonacion;
        private Fecha fechaEntrega;
        private String nroIdentificacion;

        public Donacion(Donante informacionDonador, Fecha fechaEntrega, String nroIdentificacion) {
            this.informacionDonador = informacionDonador;
            this.fechaRegistroDonacion = new Fecha(0,0,0);
            fechaRegistroDonacion.darFechaActual();
            this.fechaEntrega = new Fecha(0,0,0);
            fechaEntrega.obtenerFechaActualMas3();
            this.nroIdentificacion = nroIdentificacion;
        }
    public void actualizarInventario(Inventario inventario) {
        // Método para actualizar el inventario con la donación actual
        // que devuelve la donación específica (viveres o canasta)
        if (this instanceof DonacionViveres) {
            DonacionViveres donacionViveres = (DonacionViveres) this;
            inventario.agregarViveres(donacionViveres);
        } else if (this instanceof DonacionCanasta) {
            DonacionCanasta donacionCanasta = (DonacionCanasta) this;
            inventario.agregarCanasta(donacionCanasta);
        }
    }
}
