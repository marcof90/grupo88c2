public class App {

    // Atributte of the class
    private String nombre;
    private int id;
    private double estatura;
    private float peso;
    private char sexo;
    private boolean estaVacunado;

    // Main method
    public static void main(String[] args) {
        System.out.println("Dani");
        // Operadores aritmeticos
        int resultado = 45 + 12;
        resultado = 45 - 12;
        resultado = 45 * 12;
        resultado = 45 / 12;
        resultado = 45 % 12;

        // operadores unarios
        resultado++;
        resultado--;
        // Algebra booleana
        boolean respuesta = true;
        respuesta = 5 < 8;
        respuesta = 5 > 8;
        respuesta = 5 >= 8;
        respuesta = 5 <= 8;
        respuesta = 5 == 8;
        respuesta = 5 != 8;

        // operadores logicos
        respuesta = 5 < 8 && 4 >= 6;
        respuesta = 5 < 8 || 4 >= 6;

        // opeadores bit a bit
        // &, |, ^

        // Estructuras de control
        if (respuesta) {
            // bloque de codigo
        } else if (!respuesta) {
            // bloque de codigo
        } else {
            // bloque de codigo
        }

        int llave = 2;
        switch (llave) {
            case 2:

                break;

            default:
                break;
        }

        // --Ciclos, repetitivas, blucles --
        while (respuesta) {
            // bloque de codigo
        }
        do {
            // bloque de codigo
        } while (respuesta);
        // declaracion de variable; condicion; incremento
        for (int i = 0; i < args.length; i++) {
            // bloque de codigo
        }
        for (String string : args) {
            // bloque de codigo
        }

    }
}
