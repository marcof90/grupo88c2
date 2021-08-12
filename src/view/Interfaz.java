package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import controller.Controller;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class Interfaz extends JFrame {

    private PanelOpciones panelOpciones;
    private PanelClientes panelClientes;
    private PanelWallet panelWallet;
    private PanelTransactions panelTransactions;
    private Controller controlador;

    public Interfaz() {
        super();
        setSize(650, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Wallet");
        setLayout(new BorderLayout());

        controlador = new Controller();
        panelOpciones = new PanelOpciones(this);
        panelClientes = new PanelClientes(this);
        panelWallet = new PanelWallet(this);
        panelTransactions = new PanelTransactions(this);

        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout());
        panelCentral.add(panelClientes);
        panelCentral.add(panelWallet);
        panelCentral.add(panelTransactions);

        add(panelOpciones, BorderLayout.SOUTH);
        add(panelCentral, BorderLayout.CENTER);
        updateListClientes();
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

    public void updatePanelWallet(int id) {
        panelWallet.updateWallet(controlador.getWalletUser(id).getWallet());
    }
    
    public void fillTransactionsData(int id) {
        controlador.fillTransactionsData(id);
        updateListaTransactions(id);
    }

    public void updateListaTransactions(int id) {
        panelTransactions.updateListaTransactions(controlador.getDataTransactions(id));
    }
}
