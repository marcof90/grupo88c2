package Retos;

public class Retos_view {
    public static void main(String[] args) {
        Proyecto resultadoInversion = new Proyecto();
        System.out.println(resultadoInversion.compararPresupuestos(24, 2000000, 5));
        Proyecto resultadoInversion2 = new Proyecto();
        System.out.println(resultadoInversion2.compararPresupuestos(1, 1000000, 1));
    }
}
