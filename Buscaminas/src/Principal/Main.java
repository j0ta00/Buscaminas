package Principal;

import gestora.Gestora;
import menus.Menu;
import validaciones.Validaciones;

/**
 * <b>CLASE PRINCIPAL</b>
 * <p>
 * Se trata de uan clase que solamente contiene el método main que nos perimitirá jugar al juego<br>
 * del buscaminas
 * </p>
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
