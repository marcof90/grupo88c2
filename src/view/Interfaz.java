package view;

import javax.swing.JFrame;

import controller.Controller;

import java.awt.BorderLayout;

public class Interfaz extends JFrame {

    private PanelOpciones panelOpciones;
    private PanelClientes panelClientes;

    private Controller controlador;

    public Interfaz() {
        super();
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Wallet");
        setLayout(new BorderLayout());

        controlador = new Controller();

        panelOpciones = new PanelOpciones(this);
        panelClientes = new PanelClientes(this);

        add(panelOpciones, BorderLayout.SOUTH);
        add(panelClientes, BorderLayout.CENTER);
    }

    public void addOwner(String nombre) {
        controlador.addOwner(nombre);
        updateListClientes();
    }

    public String listarClientes(){
        return controlador.listarClientes();
    }
    
    public static void main(String[] args) {
        Interfaz i = new Interfaz();
        i.setVisible(true);
    }

    public void updateListClientes() {
        panelClientes.updateListClientes(controlador.getListClientes());
    }
    
}
