package model;

public class Transaction {
    private int value;
    private String date;

    /*Instrucciones: type
    1: ingreso de dinero
    2: egreso de dinero
    */
    private int type;

    public Transaction(int value, String date, int type) {
        super();
        this.value = value;
        this.date = date;
        this.type = type;
    } 

    public int getValue() {
        return value;
    }

    public String getDate() {
        return date;
    }

    public int getType() {
        return type;
    }
    
    // Personalización toString
    public String toString() {
        return "Value:$"+ value + " Date: "+ date + " Type: "+ ((type == 1)? "Deposit":"Withdraw");
    }

}
