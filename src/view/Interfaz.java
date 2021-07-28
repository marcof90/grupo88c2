package view;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class Interfaz extends JFrame {

    private PanelOpciones panelOpciones;

    public Interfaz() {
        super();
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Wallet");
        setLayout(new BorderLayout());

        panelOpciones = new PanelOpciones();

        add(panelOpciones, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        Interfaz i = new Interfaz();
        i.setVisible(true);
    }
}
