package view;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

public class PanelOpciones extends JPanel implements ActionListener{

    public static final String BTN_SALDO = "Ver Saldo";
    public final static String BTN_CARGAR = "Cargar";
    public final static String BTN_CREAR = "Crear cliente";

    //se crea la relacion o atributo
    private JButton btnSaldo;
    private JButton btnCargar;
    private JButton btnCrear;
    private JButton btnListar;

    private Interfaz interfaz;

    public PanelOpciones(Interfaz inter) {
        super();
        setLayout(new GridLayout(1, 3));
        setBorder(new TitledBorder("Opciones"));

        interfaz = inter;
        //se inicializan
        btnSaldo = new JButton(BTN_SALDO);
        btnCargar = new JButton(BTN_CARGAR);
        btnCrear = new JButton(BTN_CREAR);
        btnListar = new JButton("Listar clientes");

        //se modifican las propiedades
        btnCargar.setActionCommand(BTN_CARGAR);
        btnSaldo.setActionCommand(BTN_SALDO);
        btnCrear.setActionCommand(BTN_CREAR);

        btnCargar.addActionListener(this);
        btnSaldo.addActionListener(this);
        btnCrear.addActionListener(this);
        btnListar.addActionListener(this);
        //se agregan
        add(btnCargar);
        add(btnSaldo);
        add(btnCrear);
        add(btnListar);
    }

    public void addOwner() {
        String nombre = JOptionPane.showInputDialog(interfaz, "Digita el nombre del usuario");
        if (nombre!=null && !nombre.equalsIgnoreCase("")) {            
            interfaz.addOwner(nombre);
        }else if(nombre.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(interfaz, "Revisa los datos", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void listarClientes() {
        JOptionPane.showMessageDialog(interfaz, interfaz.listarClientes());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getActionCommand().equals(BTN_CARGAR)){
            JOptionPane.showMessageDialog(interfaz, "Estas cargando dinero");
            // System.out.println("vas a cargar");
        }else if(e.getActionCommand().equals(BTN_SALDO)){            
            JOptionPane.showMessageDialog(interfaz, "Estas viendo el saldo", "Tu saldo", JOptionPane.PLAIN_MESSAGE);
            // System.out.println("Estas viendo el saldo");
        }else if(e.getActionCommand().equals(BTN_CREAR)){
            addOwner();
        }else if(e.getActionCommand().equals(btnListar.getActionCommand())){
            listarClientes();
        }
    }

}
