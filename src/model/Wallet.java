package model;

import java.util.ArrayList;

public class Wallet {

    public static final int CAPACIDAD_MAXIMA = 1000000;
    private int saldo;
    private boolean tieneLimite;
    private int id;

    private ArrayList<Transaction> transactions;

    public Wallet() {
        super();
        saldo = 0;
        tieneLimite = true;
        transactions = new ArrayList<>();
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public String saveMoney(int valor) {
        if (valor < 0) {
            return "Debe digitar una cantidad válida";
        }
        if(tieneLimite && valor+saldo > CAPACIDAD_MAXIMA  ){
            return "El saldo no puede superar la capacidad máxima";
        }
        saldo += valor;
        Transaction transaction = new Transaction(valor, "hoy", 1);
        transactions.add(transaction);
        return "Transacción exitosa!";
    }
    
    public String takeMoney(int valor){
        if(saldo < valor){
            return "El monto supera el saldo";
        }
        saldo -= valor; // saldo = saldo - valor;
        Transaction transaction = new Transaction(valor, "hoy", 2);
        transactions.add(transaction);
        return "Transacción exitosa!";
    }

    public int getSaldo(){
        return saldo;
    }

    public String breakLimits(){
        if(!tieneLimite){
            return "Tu cuenta ya estaba configurada sin limites";
        }
        if(saldo >= CAPACIDAD_MAXIMA - 100000){
            tieneLimite = false;
            return "Tu cuenta ya no tiene limites!";
        }
        return "Te hacen falta "+ ((CAPACIDAD_MAXIMA - 100000) - saldo);
    }  
    
    public void getBalance(){
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

}
