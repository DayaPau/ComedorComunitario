import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        List<Donante> donantes = new ArrayList<>();
        List<Beneficiario> beneficiarios = new ArrayList<Beneficiario>();
        Inventario inventario = new Inventario();
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
                case 2:
                    menuBeneficiario(beneficiarios);
                    break;
                case 3:
                    System.out.println("Inventario:");
                    System.out.println("Total de donaciones: " + inventario.obtenerCantidadTotal());
                    System.out.println("Total de canastas: " + inventario.obtenerCantidadDesayuno() + " desayunos, "
                            + inventario.obtenerCantidadAlmuerzo() + " almuerzos, y " + inventario.obtenerCantidadCena() + " cenas");
                    System.out.println("Total de viveres: " + inventario.obtenerCantidadProductos() + " productos diferentes");

                    // Mostrar cantidad por cada tipo de canasta
                    for (DonacionCanasta.TipoCanasta tipo : DonacionCanasta.TipoCanasta.values()) {
                        System.out.println("Cantidad de " + tipo.name() + ": " + inventario.obtenerCantidadPorCanasta(tipo));
                    }

                    // Mostrar productos donados
                    inventario.mostrarProductosDonados();
                    break;


                case 4:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opc != 4);
    }

    private static void menuDonante(List<Donante> donantes) {
        int opcionDonante;
        Inventario inventario = new Inventario();

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
            Scanner scanner = new Scanner(System.in);
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
                    donar(donantes,inventario);
                    break;

                case 4:
                    // Cantidad total de canastas donadas
                    int totalCanastasDonadas = 0;

                    System.out.print("Ingrese la cédula del donante: ");
                    String cedulaDonante = scanner.nextLine();

                    for (Donante donante : donantes) {
                        if (donante.getCedula().equals(cedulaDonante)) {
                            totalCanastasDonadas += donante.cuantasCanastasHeDonado();
                        }
                    }
                    System.out.println("Cantidad total de canastas donadas por el donante con cédula " + cedulaDonante + ": " + totalCanastasDonadas);
                    break;


                case 5:
                    // Cantidad total de víveres donados
                    int totalViveresDonados = 0;

                    System.out.print("Ingrese la cédula del donante: ");
                    String cedulaDonantes = scanner.nextLine();

                    for (Donante donante : donantes) {
                        if (donante.getCedula().equals(cedulaDonantes)) {
                            totalViveresDonados += donante.cuantosViveresHeDonado();
                        }
                    }

                    System.out.println("Cantidad total de víveres donados por el donante con cédula " + cedulaDonantes + ": " + totalViveresDonados);
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


    private static void menuBeneficiario(List<Beneficiario> beneficiarios) {
        int opcionBeneficiario;

        do {
            System.out.println("Menú Beneficiario:");
            System.out.println("1. Registro Beneficiario");
            System.out.println("2. Buscar Beneficiario");
            System.out.println("3. Elección de Menú");
            System.out.println("4. ¿Cuantas comidas ha recibido el beneficiario?");
            System.out.println("5. ¿En que fecha se registro el beneficiario?  ");
            System.out.println("6. ¿Qué menú(s) ha escogido?  ");
            System.out.println("7. Volver al Menú Principal");


            System.out.print("Seleccione una opción: ");
            opcionBeneficiario = sc.nextInt();

            switch (opcionBeneficiario) {
                case 1:
                    Beneficiario nuevoBeneficiario = registrarBeneficiario(beneficiarios);
                    beneficiarios.add(nuevoBeneficiario);
                    break;
                case 2:
                    System.out.print("Ingrese la cédula del beneficiario a buscar: ");
                    String cedulaBuscada = sc.next();
                    Beneficiario beneficiarioEncontrado = buscarBeneficiarioPorCedula(beneficiarios, cedulaBuscada);

                    if (beneficiarioEncontrado != null) {
                        System.out.println("Donante encontrado:");
                        System.out.println(beneficiarioEncontrado);
                    } else {
                        System.out.println("Donante no encontrado.");
                    }
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                case 6:

                case 7 :

                    return;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcionBeneficiario != 7);
    }

    private static Donante registrarDonante(List<Donante> lista) {
        String cedula;
        do {
            System.out.print("Ingrese la cédula del donante: ");
            cedula = sc.next();

            if (cedula.length() == 10 && cedula.matches("[0-9]+")) {
                break;
            } else {
                System.out.println("La cédula debe contener solo números y tener 10 dígitos.");
            }
        } while (true);

        for (Donante donante : lista) {
            if (donante.getCedula().equals(cedula)) {
                System.out.println("Ya existe un beneficiario con la misma cédula. No se puede registrar nuevamente.");
                return registrarDonante(lista);
            }
        }


        String nombre;
        do {
            System.out.print("Ingrese el nombre del donante: ");
            nombre = sc.next();

            if (!nombre.matches("[a-zA-Z]+")) {
                System.out.println("El nombre solo puede contener letras.");
            } else {
                break;
            }
        } while (true);



        String apellido;
        do {
            System.out.print("Ingrese el apellido del donante: ");
            apellido = sc.next();

            if (!apellido.matches("[a-zA-Z]+")) {
                System.out.println("El nombre solo puede contener letras.");
            } else {
                break;
            }
        } while (true);


        String genero;
        do {
            System.out.print("Ingrese el genero del donante (masculino, femenino, otro): ");
            genero = sc.next().toLowerCase();
            if (!(genero.equals("masculino") || genero.equals("femenino") || genero.equals("otro"))) {
                System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (!(genero.equals("masculino") || genero.equals("femenino") || genero.equals("otro")));

        String celular;
        do {
            System.out.print("Ingrese el numero celular del donante ");
            celular = sc.next();

            if (celular.length() == 10 && celular.matches("[0-9]+")) {
                break;
            } else {
                System.out.println("El numero debe contener solo números y tener 10 dígitos.");
            }
        } while (true);


        System.out.print("Ingrese el nombre de la calle: ");
        String direccion = sc.next();

        Donante nuevoDonante = new Donante(nombre, apellido, genero, celular, cedula, direccion);
        System.out.println("Donante registrado con éxito.");
        return nuevoDonante;
    }

    private static Beneficiario registrarBeneficiario(List<Beneficiario> lista) {
        String cedula;
        do {
            System.out.print("Ingrese la cédula del donante: ");
            cedula = sc.next();

            if (cedula.length() == 10 && cedula.matches("[0-9]+")) {
                break;
            } else {
                System.out.println("La cédula debe contener solo números y tener 10 dígitos.");
            }
        } while (true);

        for (Beneficiario beneficiario : lista) {
            if (beneficiario.getCedula().equals(cedula)) {
                System.out.println("Ya existe un beneficiario con la misma cédula. No se puede registrar nuevamente.");
                return beneficiario;
            }
        }

        String nombre;
        do {
            System.out.print("Ingrese el nombre del beneficiario: ");
            nombre = sc.next();

            if (!nombre.matches("[a-zA-Z]+")) {
                System.out.println("El nombre solo puede contener letras.");
            } else {
                break;
            }
        } while (true);

        String apellido;
        do {
            System.out.print("Ingrese el apellido del beneficiario: ");
            apellido = sc.next();

            if (!apellido.matches("[a-zA-Z]+")) {
                System.out.println("El nombre solo puede contener letras.");
            } else {
                break;
            }
        } while (true);


        String genero;
        do {
            System.out.print("Ingrese el genero del beneficiario (masculino, femenino, otro): ");
            genero = sc.next().toLowerCase();
            if (!(genero.equals("masculino") || genero.equals("femenino") || genero.equals("otro"))) {
                System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (!(genero.equals("masculino") || genero.equals("femenino") || genero.equals("otro")));

        Beneficiario nuevoBeneficiario= new Beneficiario(nombre, apellido, cedula, genero);
        System.out.println("Donante registrado con éxito.");

        return nuevoBeneficiario;
    }
    private static void donar(List<Donante> donantes, Inventario inventario) {
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
                        inventario.agregarDonacion(donacionCanasta);
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

                DonacionViveres donacionViveres = new DonacionViveres(donante, fechaEntrega, cedulaDonante);

                for (int i = 0; i < cantidadViveres; i++) {
                    System.out.print("Ingrese el nombre del producto #" + (i + 1) + ": ");
                    String nombreProducto = sc.nextLine();

                    Producto producto = null;
                    try {
                        producto = Producto.valueOf(nombreProducto.toUpperCase());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Producto no válido. Intente de nuevo.");
                        i--;
                        continue;
                    }

                    donacionViveres.agregarViver(producto, cantidadViveres);
                }

                donante.añadirDonacion(donacionViveres);
                inventario.agregarDonacion(donacionViveres);

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
    private static Beneficiario buscarBeneficiarioPorCedula(List<Beneficiario> beneficiarios, String cedula) {
        for (Beneficiario beneficiario : beneficiarios) {
            if (beneficiario.getCedula().equals(cedula)) {
                return beneficiario;
            }
        }
        return null;
    }
}

