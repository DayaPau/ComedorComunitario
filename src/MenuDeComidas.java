/*import java.util.List;

public class MenuDeComidas {
    private List<Producto> viveresDesayuno;
    private List<Producto> viveresAlmuerzo;
    private List<Producto> viveresMerienda;

    public MenuDeComidas(List<Producto> viveresDesayuno, List<Producto> viveresAlmuerzo, List<Producto> viveresMerienda) {
        this.viveresDesayuno = viveresDesayuno;
        this.viveresAlmuerzo = viveresAlmuerzo;
        this.viveresMerienda = viveresMerienda;
    }

    public boolean verificarDisponibilidadDesayuno(Inventario inventario) {
        // Verifica la disponibilidad de los víveres de desayuno en el inventario
        // Puedes ajustar esta lógica según tus necesidades
        return inventario.verificarDisponibilidadViveres(viveresDesayuno) ||
                inventario.verificarDisponibilidadCanasta(TipoCanasta.DESAYUNO);
    }

    public boolean verificarDisponibilidadAlmuerzo(Inventario inventario) {
        // Verifica la disponibilidad de los víveres de almuerzo en el inventario
        // Puedes ajustar esta lógica según tus necesidades
        return inventario.verificarDisponibilidadViveres(viveresAlmuerzo) ||
                inventario.verificarDisponibilidadCanasta(TipoCanasta.ALMUERZO);
    }

    public boolean verificarDisponibilidadMerienda(Inventario inventario) {
        // Verifica la disponibilidad de los víveres de merienda en el inventario
        // Puedes ajustar esta lógica según tus necesidades
        return inventario.verificarDisponibilidadViveres(viveresMerienda) ||
                inventario.verificarDisponibilidadCanasta(TipoCanasta.CENA);
    }

    public void agregarViverAlMenu(Producto producto) {
        // Agregar el producto al menú de acuerdo a su tipo (desayuno, almuerzo o merienda)
        if (esDesayuno(producto)) {
            viveresDesayuno.add(producto);
        } else if (esAlmuerzo(producto)) {
            viveresAlmuerzo.add(producto);
        } else if (esMerienda(producto)) {
            viveresMerienda.add(producto);
        }
    }

    // Otros métodos y atributos según sea necesario

    // Método para verificar si un producto es de tipo desayuno
    private boolean esDesayuno(Producto producto) {
        // Lógica para verificar si el producto pertenece al desayuno
        // Puedes ajustar esta lógica según tus necesidades específicas
        return producto == Producto.YOGUR || producto == Producto.PAN ||
                producto == Producto.FRESAS || producto == Producto.HUEVOS ||
                producto == Producto.JAMON || producto == Producto.AGUACATE ||
                producto == Producto.LECHE || producto == Producto.QUESO ||
                producto == Producto.AVENA || producto == Producto.GRANOLA;
    }

    // Método para verificar si un producto es de tipo almuerzo
    private boolean esAlmuerzo(Producto producto) {
        // Lógica para verificar si el producto pertenece al almuerzo
        // Puedes ajustar esta lógica según tus necesidades específicas
        return producto == Producto.ARROZ || producto == Producto.POLLO ||
                producto == Producto.CARNE || producto == Producto.ATUN ||
                producto == Producto.SALCHICHAS || producto == Producto.PAPA ||
                producto == Producto.REPOLLO || producto == Producto.BROCOLI ||
                producto == Producto.LECHUGA;
    }

    // Método para verificar si un producto es de tipo merienda
    private boolean esMerienda(Producto producto) {
        // Lógica para verificar si el producto pertenece a la merienda
        // Puedes ajustar esta lógica según tus necesidades específicas
        return producto == Producto.ARROZ || producto == Producto.PAN ||
                producto == Producto.MIEL || producto == Producto.LECHE ||
                producto == Producto.TE_VERDE || producto == Producto.GALLETAS ||
                producto == Producto.NUECES || producto == Producto.POLLO ||
                producto == Producto.TORTILLAS;

        // Otros métodos según sea necesario
    }
}*/
