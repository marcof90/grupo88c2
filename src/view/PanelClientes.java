package view;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;

public class PanelClientes extends JPanel{
    
    private Interfaz interfaz;
    private JList<String> listaClientes;

    public PanelClientes(Interfaz i) {
        super();
        setLayout(new GridLayout());
        setBorder(new TitledBorder("Clientes"));
        interfaz = i;

        listaClientes = new JList<>();

        add(listaClientes);
    }

    public void updateListClientes(String[] listado){
        listaClientes.setListData(listado);
    }

}
