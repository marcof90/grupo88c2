package model;

public class Producto {

    public static final String CIUDAD_BASE = "Barranquilla";
    public final static double PRECIO_BASE = 1500000;
    
    private String ciudad;
    private float valor;    

    public Producto() {
        ciudad = CIUDAD_BASE;
        valor = (float) PRECIO_BASE;
    }

    public Producto(String ciudad) {
        super();
        this.ciudad = ciudad;
        if(!ciudad.equals("Barranquilla")){
            valor = (float) (PRECIO_BASE + 50000);
        }else{
            valor = (float) PRECIO_BASE;
        }
    }

    public Producto(float valor) {
        super();
        ciudad = CIUDAD_BASE;
        this.valor = valor;                
    }

    public void name() {
        int[] numeros = {1 , 5 , 8 , 9 , 5 , 7};

        for (int i : numeros) {
            System.out.println(i);
        }

        for (int i = 0; i < numeros.length; i++) {
            int valor = numeros[i];
            System.out.println(valor);
        }
    }

}
