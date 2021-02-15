package Principal;

import gestora.Gestora;
import menus.Menu;
import validaciones.Validaciones;

/*
 * CLASES:Tablero(Casilla[][] casillas),Casilla( boolean estado,int contnido),Main,Gestora,Validaciones
 * 
 * */
public class Main {

	public static void main(String[] args){

		/*
		boolean otraPartida = true;

		while (otraPartida) {
			Gestora.partida();
			Menu.nuevaPartida();
			otraPartida = Validaciones.repetirPartida();
		}*/
		
		do{
			Gestora.partida();
			Menu.nuevaPartida();
		}while(Validaciones.repetirPartida());

	}

}
