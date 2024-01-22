import javax.swing.*;

public class Interface {
    private JButton button1;
    private JPanel panel1;

    public Interface(){

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Interface");
        frame.setContentPane(new Interface().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void button1ActionPerformed(java.awt.event.ActionEvent evt){
        Ventana2 newframe = new Ventana2();
        newframe.setVisible(true);


    }








}
