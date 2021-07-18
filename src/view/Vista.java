package view;
import model.Owner;
import model.Wallet;
public class Vista {

    public static void main(String[] args) {
        Wallet wallet1 = new Wallet(); // Importar clase Wallet, comando new para crear un objeto
        Owner client = new Owner("Paula");
        client.getWallet().saveMoney(500000);
        System.out.println(client.getWallet().getBalance());
    }
    
}
