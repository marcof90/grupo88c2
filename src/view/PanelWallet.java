package view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import model.Wallet;

import java.awt.GridLayout;

public class PanelWallet extends JPanel{
    
    private JLabel lblSaldo;
    private JLabel lblId;
    private JLabel lblTieneLimite;

    private Interfaz interfaz;

    public PanelWallet(Interfaz i) {
        super();
        setBorder(new TitledBorder("Detalle Wallet"));
        setLayout(new GridLayout());
        interfaz = i;

        JPanel panelAuxiliar = new JPanel();
        panelAuxiliar.setLayout(new GridLayout(4, 1));
        panelAuxiliar.setBorder(new EmptyBorder(20, 20, 10, 10));

        lblSaldo = new JLabel("Saldo:");
        lblId = new JLabel("ID:");
        lblTieneLimite = new JLabel("Tiene Limite:");

        panelAuxiliar.add(lblSaldo);
        panelAuxiliar.add(lblId);
        panelAuxiliar.add(lblTieneLimite);

        add(panelAuxiliar);
    }

    public void updateWallet(Wallet w) {
        lblSaldo.setText("Saldo: "+w.getSaldo());
        lblId.setText("ID: "+w.getId());
    }

}
