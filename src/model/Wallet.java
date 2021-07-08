package model;

public class Wallet {
    public static final int TOPE_TRANSACCION = 200000;
    public static final int CAPACIDAD_MAXIMA = 1000000;// constante, se declaran en mayusculas y separados por _
    private int saldo;
    private boolean tieneLimite;

    public Wallet() {
        super();
        saldo = 0;
        tieneLimite = true;
    }

    public String saveMoney(int valor) {
        if (valor < 0) {
            return "Debe digitar una cantidad valida";
        }
        if (tieneLimite && valor + saldo > CAPACIDAD_MAXIMA) {
            return "Él valor no puede superar la capacidad máxima";
        }
        saldo += valor;
        return "Transacción Exítosa";
    }

    public String takeMoney(int valor) {
        if (saldo < valor) {
            return "El monto supera el saldo";
        }
        saldo -= valor;
        return "Transacción exitosa";
    }

    public int getSaldo() {
        return saldo;
    }

    public String breakLimits() {
        if (!tieneLimite) {
            return "Tu cuenta ya estaba configurada sin limites";
        }
        if (saldo >= CAPACIDAD_MAXIMA - 100000) {
            tieneLimite = false;
            return "Tu cuenta ya no tiene limites!";
        }
        return "Te hacen falta " + ((CAPACIDAD_MAXIMA - 100000) - saldo);

    }

    /*
     * Ahora la wallet tiene un atributo llamado topeTransaccion el cual si la
     * wallet tiene limite (tieneLimite==true) no debe permitir ingresar o retirar
     * dinero por un valor mayor a 200.000 este valor esta en una constante llamada
     * TOPE_TRANSACCION
     */
    public String stopTransaccion() {
        if (tieneLimite == true && saldo >= TOPE_TRANSACCION) {
            return "No puede ingresar o retirar dinero por un valor mayor a" + "" + TOPE_TRANSACCION;
        }
        return "Puede ingresar o retirar dinero normalmente";
    }

}
