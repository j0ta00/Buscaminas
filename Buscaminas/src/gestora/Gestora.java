package gestora;

import java.util.Scanner;

import menus.Menu;
import tablero.Tablero;
import validaciones.Validaciones;

public class Gestora{
	static Scanner teclado = new Scanner(System.in);
	
	public static void partida(){
		boolean continuarConLaPartida=true;
		int resultado=0;
		Tablero tablero1=null;
		Menu.presentacion();
		Menu.pedirDificultad();
		switch(Validaciones.validarDificultad(1, 3)){
			case 1->tablero1= new Tablero(10, 10, 6);
			case 2->tablero1= new Tablero(20, 20, 20);
			case 3->tablero1= new Tablero(25, 25, 35);
		}
		do{
			tablero1.imprimirTablero();
			if(tablero1.seleccionarCasilla(Validaciones.validarFilas(tablero1.getFilas()),Validaciones.validarColumnas(tablero1.getColumnas()))){
				continuarConLaPartida=false;
			}else{
				if(tablero1.comprobarVictoria()==true){
					continuarConLaPartida=false;
					resultado=1;
				}
			}
		}while(continuarConLaPartida==true);
		Menu.mensajeFinal(resultado);
	}
}