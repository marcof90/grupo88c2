package view;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.GridLayout;

public class PanelTransactions extends JPanel{
    
    private Interfaz interfaz;
    private JList<String> listaTransactions;

    public PanelTransactions(Interfaz i) {
        super();
        setLayout(new GridLayout());
        setBorder(new TitledBorder("Transacciones"));
        interfaz = i;

        listaTransactions = new JList<>();

        add(listaTransactions);
    }

    public void updateListaTransactions(String[] listadoTransactions) {
        listaTransactions.setListData(listadoTransactions);
    }

}
