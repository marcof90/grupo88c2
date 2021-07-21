package view;

import model.Owner;

public class UserView {
    public static void main(String[] args) {
        Owner cliente1 = new Owner("Daniela");
        Owner cliente2 = new Owner("Damaris");
        System.out.println(cliente1.getNombre());
        System.out.println(cliente2.getNombre());
        String response = cliente1.getWallet().saveMoney(300000);
        cliente1.getWallet().takeMoney(200000);
        cliente1.getWallet().saveMoney(500000);
        System.out.println(response);
        // System.out.println(cliente1.compararWallet(cliente2.getWallet()));
        cliente1.getWallet().getBalance();
    }
}
