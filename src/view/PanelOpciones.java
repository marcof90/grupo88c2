package view;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

public class PanelOpciones extends JPanel implements ActionListener{

    public static final String BTN_SALDO = "Ver Saldo";
    public final static String BTN_CARGAR = "Cargar";

    //se crea la relacion o atributo
    private JButton btnSaldo;
    private JButton btnCargar;

    public PanelOpciones() {
        super();
        setLayout(new GridLayout(1, 2));
        setBorder(new TitledBorder("Opciones"));
        //se inicializan
        btnSaldo = new JButton(BTN_SALDO);
        btnCargar = new JButton(BTN_CARGAR);

        //se modifican las propiedades

        //se agregan
        add(btnCargar);
        add(btnSaldo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }





}
