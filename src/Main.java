import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        List<Donante> donantes = new ArrayList<Donante>();
        int opc;

        do {
            System.out.println("*******MENU PRINCIPAL*******");
            System.out.println("1.- MENU DONANTE");
            System.out.println("2.- MENU BENEFICIARIO");
            System.out.println("3.- INVENTARIO");
            System.out.println("4.- SALIR");
            System.out.print("\nIngrese una opción: ");
            opc = Integer.parseInt(sc.next());

            switch (opc) {
                case 1:
                    menuDonante(donantes);
                    break;
                case 5:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opc != 5);
    }

    private static void menuDonante(List<Donante> donantes) {
        int opcionDonante;

        do {
            System.out.println("Menú Donante:");
            System.out.println("1. Registro Donante");
            System.out.println("2. Buscar Donante");
            System.out.println("3. Realizar Donación");
            System.out.println("4. Cuantas canastas se ha donado");
            System.out.println("5.Cuantos viveres se ha donado ");
            System.out.println("6.Cuantas veces se ha donado");
            System.out.println("7. Volver al Menú Principal");


            System.out.print("Seleccione una opción: ");
            opcionDonante = sc.nextInt();

            switch (opcionDonante) {
                case 1:
                    Donante nuevoDonante = registrarDonante(donantes);
                    donantes.add(nuevoDonante);
                    break;
                case 2:
                    System.out.print("Ingrese la cédula del donante a buscar: ");
                    String cedulaBuscada = sc.next();
                    Donante donanteEncontrado = buscarDonantePorCedula(donantes, cedulaBuscada);

                    if (donanteEncontrado != null) {
                        System.out.println("Donante encontrado:");
                        System.out.println(donanteEncontrado);
                    } else {
                        System.out.println("Donante no encontrado.");
                    }
                    break;
                case 3:
                    donar(donantes);
                    break;
                case 4:
                    int totalCanastasDonadas = 0;

                    for (Donante donante : donantes) {
                        totalCanastasDonadas += donante.cuantasCanastasHeDonado();
                    }

                    System.out.println("Cantidad total de canastas donadas por todos los donantes: " + totalCanastasDonadas);
                    break;
                case 5:
                    int totalViveresDonados = 0;

                    for (Donante donante : donantes) {
                        totalViveresDonados += donante.cuantosViveresHeDonado();
                    }

                    System.out.println("Cantidad total de viveres donados por todos los donantes: " + totalViveresDonados);
                    break;
                case 6:
                    int totalDonaciones = 0;

                    for (Donante donante : donantes) {
                        totalDonaciones += donante.cuantasVecesHeDonado();
                    }

                    System.out.println("Cantidad total de donaciones realizadas por todos los donantes: " + totalDonaciones);
                    break;
                case 7 :

                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcionDonante != 7);
    }

    private static Donante registrarDonante(List<Donante> lista) {
        System.out.print("Ingrese el cedula del donante: ");
        String cedula = sc.next();


        for (Donante donante : lista) {
            if (donante.getCedula().equals(cedula)) {
                System.out.println("Ya existe un donante con la misma cédula. No se puede registrar nuevamente.");
                return null;
            }
        }

        System.out.print("Ingrese el nombre del donante: ");
        String nombre = sc.next();

        System.out.print("Ingrese el apellido del donante: ");
        String apellido = sc.next();


        String genero;
        do {
            System.out.print("Ingrese el genero del donante (masculino, femenino, otro): ");
            genero = sc.next().toLowerCase();
            if (!(genero.equals("masculino") || genero.equals("femenino") || genero.equals("otro"))) {
                System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (!(genero.equals("masculino") || genero.equals("femenino") || genero.equals("otro")));

        System.out.print("Ingrese el celular del donante: ");
        String celular = sc.next();

        System.out.print("Ingrese la direccion del donante: ");
        String direccion = sc.next();

        Donante nuevoDonante = new Donante(nombre, apellido, genero, celular, cedula, direccion);
        System.out.println("Donante registrado con éxito.");

        return nuevoDonante;
    }
    private static void donar(List<Donante> donantes) {
        System.out.print("Ingrese la cédula del donante: ");
        String cedulaDonante = sc.next();
        sc.nextLine();

        Donante donante = buscarDonantePorCedula(donantes, cedulaDonante);

        if (donante == null) {
            System.out.println("Donante no encontrado. Volviendo al Menú Donante.");
            return;
        }

        System.out.println("Elige el tipo de donación:");
        System.out.println("1. Donación de Canasta");
        System.out.println("2. Donación de Víveres");
        System.out.print("Seleccione una opción: ");
        int tipoDonacion = sc.nextInt();
        sc.nextLine();

        Fecha fechaEntrega = new Fecha(0, 0, 0);
        fechaEntrega.obtenerFechaActualMas3();

        switch (tipoDonacion) {
            case 1:
                boolean tipoCanastaValido = false;
                do {
                    mostrarTiposCanasta();
                    System.out.print("Ingrese el tipo de la canasta (DESAYUNO, ALMUERZO, CENA): ");
                    String tipoCanastaInput = sc.nextLine().toUpperCase();

                    try {
                        DonacionCanasta.TipoCanasta tipoCanasta = DonacionCanasta.TipoCanasta.valueOf(tipoCanastaInput);
                        DonacionCanasta donacionCanasta = new DonacionCanasta(donante, fechaEntrega, cedulaDonante, tipoCanasta);
                        donante.añadirDonacion(donacionCanasta);
                        donacionCanasta.actualizarInventario(new Inventario());
                        System.out.println("Donación de Canasta realizada con éxito.");
                        tipoCanastaValido = true;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Tipo de canasta no válido. Intente de nuevo.");
                    }
                } while (!tipoCanastaValido);
                break;

            case 2:
                mostrarProductosDisponibles();
                System.out.print("Ingrese la cantidad de viveres a donar: ");
                int cantidadViveres = sc.nextInt();
                sc.nextLine();  // Consumir el salto de línea

                DonacionViveres donacionViveres = new DonacionViveres(donante, fechaEntrega, cedulaDonante);

                for (int i = 0; i < cantidadViveres; i++) {
                    System.out.print("Ingrese el nombre del producto #" + (i + 1) + ": ");
                    String nombreProducto = sc.nextLine();

                    // Validate the product input
                    Producto producto = null;
                    try {
                        producto = Producto.valueOf(nombreProducto.toUpperCase());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Producto no válido. Intente de nuevo.");
                        i--;
                        continue;
                    }

                    donacionViveres.agregarViver(producto,cantidadViveres);
                }

                donante.añadirDonacion(donacionViveres);
                donacionViveres.actualizarInventario(new Inventario());

                System.out.println("Donación de Víveres realizada con éxito.");
                break;

            default:
                System.out.println("Opción no válida. Volviendo al Menú Donante.");
                break;
        }

    }
    private static void mostrarTiposCanasta() {
        System.out.println("Tipos de Canasta Disponibles:");
        for (DonacionCanasta.TipoCanasta tipo : DonacionCanasta.TipoCanasta.values()) {
            System.out.println(tipo.name());
        }
    }
    private static void mostrarProductosDisponibles() {
        System.out.println("Productos Disponibles:");
        for (Producto producto : Producto.values()) {
            System.out.println(producto.name());
        }
    }

    private static Donante buscarDonantePorCedula(List<Donante> donantes, String cedula) {
        for (Donante donante : donantes) {
            if (donante.getCedula().equals(cedula)) {
                return donante;
            }
        }
        return null;
    }

}

