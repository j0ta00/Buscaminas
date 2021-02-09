package Principal;

import tablero.Tablero;

/*
 * CLASES:Tablero(Casilla[][] casillas),Casilla( boolean estado,int contnido),Main,Gestora,Validaciones
 * 
 * */
public class Main {

	public static void main(String[] args){
		
		Tablero ej1 = new Tablero(10, 10, 30);
		ej1.imprimirTablero();
		
	}

}
