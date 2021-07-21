package view;

import java.util.Scanner;

import model.Owner;

public class UserView {
    
    public static void main(String[] args) {
        System.out.println("ingrese el valor a transferir");
        Scanner valor= new Scanner(System.in);
        String valor2= valor.nextLine();
        int valor3 =Integer.parseInt(valor2);

        Owner cliente3 = new Owner("lei David");
        Owner cliente4 = new Owner("Juan David");
               
        System.out.println(cliente3.getWallet().saveMoney(100000));
        System.out.println(cliente4.getWallet().saveMoney(10000));
        cliente4.transferencia(cliente3.getWallet(), valor3);
        System.out.println(cliente3.getWallet().getSaldo());
        System.out.println(cliente4.getWallet().getSaldo());

        /**
         *Owner cliente1 = new Owner("Juan");
         *Owner cliente2 = new Owner("Juan David"); 
         * System.out.println(cliente3.getWallet().getSaldo());
        System.out.println(cliente4.getWallet().getSaldo());
        cliente2.setNombre("Yimy");
        System.out.println(cliente1.getNombre());
        System.out.println(cliente2.getNombre());
        String response = cliente1.getWallet().saveMoney(100000);
        cliente1.getWallet().takeMoney(20000);
        cliente1.getWallet().saveMoney(500000);
        // System.out.println(response);
        // System.out.println(cliente1.getWallet().getSaldo());
        // System.out.println(cliente2.getWallet().getSaldo());
        // System.out.println(cliente1.compararWallet(cliente2.getWallet()));
        cliente1.getWallet().getBalance();
        */
    }
}
