package model;

public class Owner extends User {
    private Wallet wallet;

    public Owner(String nombre) {
        super();
        wallet = new Wallet();
        setNombre(nombre);
    }

    public Wallet getWallet() {
        return wallet;
    }

    public String compararWallet(Wallet otraWallet) {
        Wallet miWallet = getWallet();
        if (miWallet.getSaldo() > otraWallet.getSaldo()) {
            return "Mi Wallet tiene más saldo";
        } else if (miWallet.getSaldo() == otraWallet.getSaldo()) {
            return "Ambas Wallet tienen el mismo saldo";
        } else if (miWallet.getSaldo() < otraWallet.getSaldo()) {
            return "La otra Wallet tiene más saldo";
        } else {
            return "Hubo un error";
        }
    }
}
