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
	 * Precondici�n:
	 * Postcondici�n:
	 * */
	public static void partida(){

		boolean continuarConLaPartida=true;
		int resultado=0;
		Tablero tablero1=null;

		Menu.presentacion();
		switch(Validaciones.validar(1, 4, 5)){
			case 1->tablero1= new Tablero(10, 10, 10);
			case 2->tablero1= new Tablero(30, 30, 30);
			case 3->tablero1= new Tablero(100, 100, 100);

			case 4->{
				tablero1= new Tablero(	Validaciones.validar(1, 1000, 6),
										Validaciones.validar(1, 1000, 7),
										Validaciones.validar(1, 9000, 8));
			}
		}

		tablero1.imprimirTablero();

		while(continuarConLaPartida){
			Menu.imprimirMarcar();
			if(Validaciones.validarCaracter()){
				tablero1.marcarCasilla(	Validaciones.validar(0, tablero1.getFilas(), 3),
										Validaciones.validar(0, tablero1.getColumnas(), 4));
			}else{
				if(tablero1.seleccionarCasilla(	Validaciones.validar(0, tablero1.getFilas(), 1),
												Validaciones.validar(0, tablero1.getColumnas(),2)))
					continuarConLaPartida=false;
				else{
					if(tablero1.comprobarVictoria()){
						continuarConLaPartida=false;
						resultado=1;
					}
				}
			}
			tablero1.imprimirTablero();
		}
		Menu.mensajeFinal(resultado);
	}
}