package validaciones;
import java.util.Scanner;
import menus.Menu;
/**
 * @author <b>josmatoje AND jjmza</b><br> 	 
 *<b>Propiedades basicas:</b> Ninguna se trata de una clase estática validaciones que se encarga de <br>
 * validar las entradas de datos	
 * <b>Propiedaes derivadas:</b> Ninguna<br>
 * <b>Propiedades Compartidas:</b> Scanner teclado<br>
 * <b>Métodos accesores: Ninguno</b></br>
 * <b>Métodos Adicionales:</b> public static int validar(int parametroMenor,int parametroMayor, int mensajeAImprimir)<br>
 *  public static boolean validarCaracter()<br>
 *  public static boolean repetirPartida()
 * 
 * */
public class Validaciones {
	static Scanner teclado = new Scanner(System.in);
	
	/**
	 * @author<b>josmatoje AND jjmza</b><br> 
	 * Cabecera:public static int validar(int parametroMenor,int parametroMayor, int mensajeAImprimir)<br>
	 * Proposito: Se trata de un método validará las entradas por teclado<br>
	 * Precondición:Ninguna<br>
	 * Postcondición:Ninguna, se trata de una función que valida la entrada por teclado<br>
	 * @param int parametroMenor,int parametroMayor, int mensajeAImprimir
	 * @return int respuesta
	 * */
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
	/**
	 * @author<b>josmatoje AND jjmza</b><br> 
	 * Cabecera:public static boolean validarCaracter()<br>
	 * Proposito: Se trata de un método validará las entradas por teclado<br>
	 * Precondición:Ninguna<br>
	 * Postcondición:Ninguna, se trata de una función que valida la entrada por teclado<br>
	 * @param Ninguna
	 * @return booleano(Si la entrada por teclado es una 'M' o no)
	 * */
	public static boolean validarCaracter(){
		return teclado.next().toUpperCase().charAt(0)=='M';
	}
	/**
	 * @author<b>josmatoje AND jjmza</b><br> 
	 * Cabecera:public static boolean validarCaracter()<br>
	 * Proposito: Se trata de un método validará las entradas por teclado<br>
	 * Precondición:Ninguna<br>
	 * Postcondición:Ninguna, se trata de una función que valida la entrada por teclado<br>
	 * @param Ninguna
	 * @return booleano(Si la entrada por teclado es una 'S' o no)
	 * */
	public static boolean repetirPartida(){return teclado.next().toUpperCase().charAt(0)=='S';}
}

