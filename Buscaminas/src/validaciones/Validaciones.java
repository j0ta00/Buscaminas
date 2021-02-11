package validaciones;
import java.util.Scanner;

import menus.Menu;
public class Validaciones {
	static Scanner teclado = new Scanner(System.in);

	public static int validar(int parametroMenor,int parametroMayor, int mensajeAImprimir){
		int respuesta=-1;
		while(respuesta<parametroMenor || respuesta>parametroMayor){
			if (respuesta!=-1)
				Menu.parametrosInvalidos();
			switch(mensajeAImprimir){
				case 1->Menu.pedirFila("descubrir");
				case 2->Menu.pedirColumna("descubrir");
				case 3->Menu.pedirFila("marcar");
				case 4->Menu.pedirColumna("marcar");
				case 5->Menu.pedirDificultad();
				case 6->Menu.pedirNumeroFilas();
				case 7->Menu.pedirNumeroColumna();
				case 8->Menu.pedirNumeroBombas();
			}
			respuesta=teclado.nextInt();
			if(mensajeAImprimir>=1 && mensajeAImprimir<=4)
				respuesta--;
		}
		return respuesta;
	}
	
	public static boolean validarCaracter(){
		return teclado.next().toUpperCase().charAt(0)=='M';
	}
}

