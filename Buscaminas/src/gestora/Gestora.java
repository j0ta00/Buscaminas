package gestora;

import java.util.Scanner;

import menus.Menu;
import tablero.Tablero;
import validaciones.Validaciones;

public class Gestora{
	static Scanner teclado = new Scanner(System.in);
	
	/*
	 * Cabecera:
	 * Proposito:
	 * Entrada:
	 * Salida:
	 * Precondición:
	 * Postcondición:
	 * */
	public static void partida(){
		boolean continuarConLaPartida=true;
		int resultado=0;
		Tablero tablero1=null;
		Menu.presentacion();
		switch(Validaciones.validar(1, 3, 5)){
			case 1->tablero1= new Tablero(10, 10, 6);
			case 2->tablero1= new Tablero(20, 20, 20);
			case 3->tablero1= new Tablero(1000, 1000, 2000);
		}
		tablero1.imprimirTablero();
		do{
			Menu.imprimirMarcar();
			if(Validaciones.validarCaracter()){
				tablero1.marcarCasilla(Validaciones.validar(0, tablero1.getFilas(), 3), Validaciones.validar(0, tablero1.getColumnas(), 4));
			}else{
				if(tablero1.seleccionarCasilla(Validaciones.validar(0, tablero1.getFilas(), 1),Validaciones.validar(0, tablero1.getColumnas(),2))){
					continuarConLaPartida=false;
				}else{
					if(tablero1.comprobarVictoria()==true){
						continuarConLaPartida=false;
						resultado=1;
					}
				}
			}
			tablero1.imprimirTablero();
		}while(continuarConLaPartida==true);
		Menu.mensajeFinal(resultado);
	}
}