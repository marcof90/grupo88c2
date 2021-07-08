package view;
import model.Wallet;

public class Vista { 
    public static void main2(String[] args) {
        Wallet wallet1 = new Wallet();
        System.out.println(wallet1.saveMoney(300000));
        System.out.println(wallet1.getSaldo());
        System.out.println(wallet1.saveMoney(900000));
        System.out.println(wallet1.getSaldo());
    }
}
