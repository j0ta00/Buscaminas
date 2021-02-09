package tests;

import tablero.Tablero;

public class PruebasTablero {

    public static void main(String[] args){

        Tablero ej1 = new Tablero(20, 20, 20);//Modificar bombas para probar (2 / 20/ 200/ 2000)
        if(ej1.seleccionarCasilla(2,2))
            System.out.println("PUM");
        else{
            ej1.imprimirTablero();
            if(ej1.comprobarVictoria())
                System.out.println("Ganaste wey");
        }

    }

}
