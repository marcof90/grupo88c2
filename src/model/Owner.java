package model;

public class Owner extends User { // relación de herencia
    private Wallet wallet; // relación entre clase Owner y clase Wallet
    
    public Owner(String name) {
        super();
        wallet = new Wallet();
        setName("Andrés");
    }

    public Wallet getWallet() {
        return wallet;
    }

    public String compareWallet(Wallet compareWallet){
        Wallet myWallet = getWallet();

        if (myWallet.getBalance() > compareWallet.getBalance()) {
            return "My wallet has more balance";
        } else if (myWallet.getBalance() == compareWallet.getBalance()) {
            return "Both wallets have the same balance";
        } else {
            return "The other wallet has more balance";
        }
    }
}
