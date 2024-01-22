import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI implements ActionListener {

    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel cards;
    private JTextField cedulaField;
    private JTextField nombreField;
    private JTextField apellidoField;
    private JComboBox<String> generoComboBox;
    private JTextField celularField;
    private JTextField direccionField;
    private JTextArea resultadoTextArea;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new MainGUI().createAndShowGUI();
        });
    }

    private void createAndShowGUI() {
        frame = new JFrame("Sistema de Donaciones");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        JPanel menuPrincipal = crearMenuPrincipal();
        cards.add(menuPrincipal, "MENU_PRINCIPAL");

        resultadoTextArea = new JTextArea();
        resultadoTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultadoTextArea);

        frame.add(cards, BorderLayout.CENTER);
        frame.add(scrollPane, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private JPanel crearMenuPrincipal() {
        JPanel menuPrincipal = new JPanel();
        menuPrincipal.setLayout(new BoxLayout(menuPrincipal, BoxLayout.Y_AXIS));

        JButton menuDonanteButton = new JButton("MENU DONANTE");
        JButton salirButton = new JButton("SALIR");

        menuDonanteButton.addActionListener(e -> mostrarMenuDonante());
        salirButton.addActionListener(e -> frame.dispose());

        menuPrincipal.add(menuDonanteButton);
        menuPrincipal.add(salirButton);

        return menuPrincipal;
    }

    private void mostrarMenuDonante() {
        JPanel menuDonante = new JPanel();
        menuDonante.setLayout(new BoxLayout(menuDonante, BoxLayout.Y_AXIS));

        JButton registroDonanteButton = new JButton("Registro Donante");
        JButton buscarDonanteButton = new JButton("Buscar Donante");
        JButton realizarDonacionButton = new JButton("Realizar Donación");
        JButton cuantasCanastasButton = new JButton("Cuantas Canastas se ha donado");
        JButton cuantosViveresButton = new JButton("Cuantos Viveres se ha donado");
        JButton cuantasVecesButton = new JButton("Cuantas Veces se ha donado");
        JButton volverMenuPrincipalButton = new JButton("Volver al Menú Principal");

        registroDonanteButton.addActionListener(e -> mostrarVentanaRegistroDonante());
        buscarDonanteButton.addActionListener(e -> mostrarVentanaBuscarDonante());
        realizarDonacionButton.addActionListener(e -> mostrarVentanaRealizarDonacion());
        cuantasCanastasButton.addActionListener(e -> mostrarCuantasCanastas());
        cuantosViveresButton.addActionListener(e -> mostrarCuantosViveres());
        cuantasVecesButton.addActionListener(e -> mostrarCuantasVeces());
        volverMenuPrincipalButton.addActionListener(e -> volverMenuPrincipal());

        menuDonante.add(registroDonanteButton);
        menuDonante.add(buscarDonanteButton);
        menuDonante.add(realizarDonacionButton);
        menuDonante.add(cuantasCanastasButton);
        menuDonante.add(cuantosViveresButton);
        menuDonante.add(cuantasVecesButton);
        menuDonante.add(volverMenuPrincipalButton);

        cards.add(menuDonante, "MENU_DONANTE");
        cardLayout.show(cards, "MENU_DONANTE");
    }

    private void mostrarVentanaRegistroDonante() {
        JPanel ventanaRegistro = new JPanel();
        ventanaRegistro.setLayout(new GridLayout(8, 2));

        cedulaField = new JTextField();
        nombreField = new JTextField();
        apellidoField = new JTextField();
        generoComboBox = new JComboBox<>(new String[]{"Femenino", "Masculino", "Otro"});
        celularField = new JTextField();
        direccionField = new JTextField();

        JButton registrarButton = new JButton("Registrar");
        JButton regresarButton = new JButton("Regresar");

        registrarButton.addActionListener(e -> registrarDonante());
        regresarButton.addActionListener(e -> volverMenuDonante());

        ventanaRegistro.add(new JLabel("Cedula:"));
        ventanaRegistro.add(cedulaField);
        ventanaRegistro.add(new JLabel("Nombre:"));
        ventanaRegistro.add(nombreField);
        ventanaRegistro.add(new JLabel("Apellido:"));
        ventanaRegistro.add(apellidoField);
        ventanaRegistro.add(new JLabel("Género:"));
        ventanaRegistro.add(generoComboBox);
        ventanaRegistro.add(new JLabel("Celular:"));
        ventanaRegistro.add(celularField);
        ventanaRegistro.add(new JLabel("Dirección:"));
        ventanaRegistro.add(direccionField);
        ventanaRegistro.add(new JLabel(""));
        ventanaRegistro.add(registrarButton);
        ventanaRegistro.add(new JLabel(""));
        ventanaRegistro.add(regresarButton);

        cards.add(ventanaRegistro, "REGISTRO_DONANTE");
        cardLayout.show(cards, "REGISTRO_DONANTE");
    }

    private void registrarDonante() {
        String cedula = cedulaField.getText();
        String nombre = nombreField.getText();
        String apellido = apellidoField.getText();
        String genero = (String) generoComboBox.getSelectedItem();
        String celular = celularField.getText();
        String direccion = direccionField.getText();
        Donante nuevoDonante = new Donante(nombre, apellido, genero, celular, cedula, direccion);

        // Implementar la lógica para registrar el donante con los datos proporcionados
        // Aquí puedes agregar la lógica específica de registro

        // Muestra un mensaje en el área de resultados
        resultadoTextArea.setText("Donante registrado con éxito:\n" +
                "Cedula: " + cedula + "\n" +
                "Nombre: " + nombre + "\n" +
                "Apellido: " + apellido + "\n" +
                "Género: " + genero + "\n" +
                "Celular: " + celular + "\n" +
                "Dirección: " + direccion);
    }

    private void mostrarVentanaBuscarDonante() {
        JPanel ventanaBuscarDonante = new JPanel();
        ventanaBuscarDonante.setLayout(new GridLayout(2, 2));

        cedulaField = new JTextField();

        JButton buscarButton = new JButton("Buscar");
        JButton regresarButton = new JButton("Regresar");

        buscarButton.addActionListener(e -> buscarDonante());
        regresarButton.addActionListener(e -> volverMenuDonante());

        ventanaBuscarDonante.add(new JLabel("Cedula:"));
        ventanaBuscarDonante.add(cedulaField);
        ventanaBuscarDonante.add(new JLabel(""));
        ventanaBuscarDonante.add(buscarButton);
        ventanaBuscarDonante.add(new JLabel(""));
        ventanaBuscarDonante.add(regresarButton);

        cards.add(ventanaBuscarDonante, "BUSCAR_DONANTE");
        cardLayout.show(cards, "BUSCAR_DONANTE");
    }

    private void buscarDonante() {
        String cedulaBuscada = cedulaField.getText();

        // Implementar la lógica para buscar el donante por cédula
        // Aquí puedes agregar la lógica específica de búsqueda

        // Muestra un mensaje en el área de resultados
        resultadoTextArea.setText("Donante encontrado:\n" +
                "Cedula: " + cedulaBuscada + "\n" +
                "Nombre: DonanteEncontrado\n" +
                "Apellido: ApellidoEncontrado\n" +
                "Género: Femenino\n" +
                "Celular: 123456789\n" +
                "Dirección: DirecciónEncontrada");
    }

    private void mostrarVentanaRealizarDonacion() {
        JPanel ventanaRealizarDonacion = new JPanel();
        ventanaRealizarDonacion.setLayout(new GridLayout(4, 2));

        JButton regresarButton = new JButton("Regresar");

        regresarButton.addActionListener(e -> volverMenuDonante());

        ventanaRealizarDonacion.add(new JLabel("Implementar lógica para donaciones aquí..."));
        ventanaRealizarDonacion.add(regresarButton);

        cards.add(ventanaRealizarDonacion, "REALIZAR_DONACION");
        cardLayout.show(cards, "REALIZAR_DONACION");
    }

    private void mostrarCuantasCanastas() {
        // Implementar la lógica para mostrar la cantidad de canastas donadas por el donante
        // Aquí puedes agregar la lógica específica de cuantas canastas

        // Muestra un mensaje en el área de resultados
        resultadoTextArea.setText("El donante ha donado 5 canastas");
    }

    private void mostrarCuantosViveres() {
        // Implementar la lógica para mostrar la cantidad y los viveres donados por el donante
        // Aquí puedes agregar la lógica específica de cuantos viveres

        // Muestra un mensaje en el área de resultados
        resultadoTextArea.setText("El donante ha donado 20 viveres, incluyendo arroz, frijoles y aceite");
    }

    private void mostrarCuantasVeces() {
        // Implementar la lógica para mostrar la cantidad de veces que el donante ha donado
        // Aquí puedes agregar la lógica específica de cuantas veces

        // Muestra un mensaje en el área de resultados
        resultadoTextArea.setText("El donante ha donado 3 veces");
    }

    private void volverMenuPrincipal() {
        cardLayout.show(cards, "MENU_PRINCIPAL");
    }

    private void volverMenuDonante() {
        cardLayout.show(cards, "MENU_DONANTE");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}