package gestora;

import java.util.Scanner;
import menus.Menu;
import tablero.Tablero;
import validaciones.Validaciones;

/**
 * @author <b>josmatoje AND jjmza</b><br> 	 
 *<b>Propiedades basicas:</b> Ninguna se trata de una clase estática gestora que se encarga de <br>
 * gestinar los diferentes objetos y realizar distintos métodos gestores entre las distintas<br>
 * clases y sus instancias. 		
 * 
 * <b>Propiedaes derivadas:</b> Ninguna<br>
 * <b>Propiedades Compartidas:</b> Scanner teclado<br>
 * <b>Métodos accesores: Ninguno</b></br>
 * <b>Métodos Adicionales:</b> public static void partida()
 * 
 * */
public class Gestora{
	//Objeto estático teclado
	static Scanner teclado = new Scanner(System.in);
	/**
	 * @author<b>josmatoje AND jjmza</b><br> 
	 * Cabecera:public static void partida()<br>
	 * Proposito: Se trata de un método que simula una partida del juego del buscaminas<br>
	 * Precondición:Ninguna<br>
	 * Postcondición:Ninguna, se trata de un procedimiento que llama a numerosos métodos auxilliares<br>
	 * y clases de utilidades para el correcto desarrollo del juego<br>
	 * @param Ninguno
	 * @return Nada
	 * */
	public static void partida(){

		boolean continuarConLaPartida=true;
		int resultado=0;
		Tablero tablero1=null;//inicia el tablero a null posteriormente será rellenado
		Menu.presentacion();//imprime la presentación del juego
		switch(Validaciones.validar(1, 4, 5)){//Elegir dificultad
			case 1->tablero1= new Tablero(10, 10, 10);//se rellena el tablero es decir se construye
			case 2->tablero1= new Tablero(30, 30, 30);//se rellena el tablero es decir se construye
			case 3->tablero1= new Tablero(100, 100, 100);//se rellena el tablero es decir se construye
			case 4->{//se rellena el tablero es decir se construye
				tablero1= new Tablero(	Validaciones.validar(1, 1000, 6),//se valida si el tablero no pasa el límite de filas
										Validaciones.validar(1, 1000, 7),//se valida si el tablero no pasa el límite de columnas
										Validaciones.validar(1, 9000, 8));//se valida si el tablero no pasa el límite de bombas
			}
		}
		tablero1.imprimirTablero();//imprimir tablero con todo aun por descubrir
		while(continuarConLaPartida){//mientras se deba continuar con la partida es decir no haya explotado o ganado
			Menu.imprimirMarcar();
			if(Validaciones.validarCaracter()){//validamos el caracter para saber si quiere o no marcar
				tablero1.marcarCasilla(	Validaciones.validar(0, tablero1.getFilas(), 3),//marcamos y validamos fila
										Validaciones.validar(0, tablero1.getColumnas(), 4));//marcamos y validamos columna
			}else{
				if(tablero1.seleccionarCasilla(	Validaciones.validar(0, tablero1.getFilas(), 1),//validamos y seleccionamos fila
												Validaciones.validar(0, tablero1.getColumnas(),2)))//validamos y seleccionamos columna
					continuarConLaPartida=false;
				else{
					if(tablero1.comprobarVictoria()){//se comprueba si el usuario ha ganado
						continuarConLaPartida=false;
						resultado=1;
					}
				}
			}
			tablero1.imprimirTablero();//vuelve ha imprimirse el tablero mostrando el resultado del descubrimiento de las respectivas casillas seleccionadas
		}
		Menu.mensajeFinal(resultado);//Imprime el resultado de la partida
	}
}