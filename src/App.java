public class App {

    private String nombre;
    private int identificacion;
    private double estatura;
    private float peso;
    private char sexo;
    private boolean estaVacunado;

    public static void main2(String[] args) {
        System.out.println("Hello world!");
        //operadores aritmeticos
        int resultado = 45 + 12;
        resultado = 45 - 12;
        resultado = 45 * 12;
        resultado = 45 / 12;
        resultado = 45 % 12;
        //operadores unarios
        resultado++;
        resultado = resultado--;
        boolean respuesta = true;
        //!respuesta;
        //algebra booleana
        respuesta = 5 < 8;
        respuesta = 5 > 8;
        respuesta = 5 >= 8;
        respuesta = 5 <= 8;
        respuesta = 5 == 8;
        respuesta = 5 != 8;
        //operadores logicos
        respuesta = 5 < 8 && 4 >= 6;
        respuesta = 5 < 8 || 4 >= 6;
        //operadores bit a bit
        // &
        // |
        // ^
        //estructuras de control
        //---condicionales---
        if (5 != 10) {
            //bloque de código
        }

        if (respuesta) {
            //bloque de código
        } else if(!respuesta){
            //bloque de código
        } else {
            //bloque de código
        }
        int llave = 2;
        switch (llave) {
            case 1:
                //bloque de código
                break;
            case 2:
                //bloque de código
                break;
        
            default:
                break;
        }
        //---ciclos, repetitivas, bucles---
        while (llave > 5) {
            //bloque de código 
        }
        
        do {
            //bloque de código             
        } while (llave > 5);

        for (String string : args) {
            //bloue de código
        }
        // declaración de una variable ; condición ; incremento 
        for (int i = 0; i < args.length; i++) {
            
        }
    }
}
