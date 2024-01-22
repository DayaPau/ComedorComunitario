public class Beneficiario {
    private String nombre;
    private String apellido;
    private String genero;
    private String cedula;
    private Fecha fechaRegistro;
    private ElecciondeMenu menuSeleccionado;

    public Beneficiario(String nombre, String apellido, String genero, String cedula, Fecha fechaRegistro) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.cedula = cedula;
        this.fechaRegistro = fechaRegistro;
    }
    public void realizarEleccionDeMenu(Inventario inventario) {
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

    public String getCedula() {
        return cedula;
    }

    public Fecha getFechaRegistro() {
        return fechaRegistro;
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

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setFechaRegistro(Fecha fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
