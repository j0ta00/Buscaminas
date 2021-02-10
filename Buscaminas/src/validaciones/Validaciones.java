package validaciones;
import java.util.Scanner;

import menus.Menu;
public class Validaciones {
	static Scanner teclado = new Scanner(System.in);
	
	public static int validarDificultad(int parametroMenor,int parametroMayor){
		int respuesta=-1;
		while(respuesta<parametroMenor || respuesta>parametroMayor){
			Menu.parametrosInvalidos();
			respuesta=teclado.nextInt();
		}
		return respuesta;
	}
	
		public static int validarFilas(int filaTablero){
			int fila=-1;
			while(fila<0 || fila>filaTablero-1){
				Menu.pedirFila();
				fila=teclado.nextInt();
			}
			return fila;
		}
		
		public static int validarColumnas(int columnaTablero){
			int columna=-1;
			while(columna<0 || columna>columnaTablero-1){
				Menu.pedirColumna();
				columna=teclado.nextInt();
			}
			return columna;
		}
}

