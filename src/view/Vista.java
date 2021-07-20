package view;
import model.Owner;
import model.Wallet;
public class Vista {

    public static void main(String[] args) {
        Wallet wallet1 = new Wallet(); // Importar clase Wallet, comando new para crear un objeto
        Owner client = new Owner("Andrés");
        client.getWallet().saveMoney(500000);
        client.getWallet().takeMoney(20000);
        System.out.println(client.getWallet().getBalance());
        client.getWallet().cashBalance(); // toString se personaliza en la clase Transaction
    }
    
}
