package menus;
/**
 * @author <b>josmatoje AND jjmza</b><br> 	 
 *<b>Propiedades basicas:</b> Ninguna se trata de una clase est�tica menu que se encarga de <br>
 * imprimir por pantalla las distintas opciones y funcionalidades del proyecto		
 * <b>Propiedaes derivadas:</b> Ninguna<br>
 * <b>Propiedades Compartidas:</b> Scanner teclado<br>
 * <b>M�todos accesores: Ninguno</b></br>
 * <b>M�todos Adicionales:</b> public static void nuevaPartida()<br>
 * public static void presentacion()<br>
 *public static void pedirFila(String marcarODescubrir) <br>
 * public static void pedirColumna(String marcarODescubrir)<br>
 * public static void pedirDificultad()<br>
 * public static void pedirNumeroFilas()<br>
 * public static void pedirNumeroColumna()<br>
 * public static void pedirNumeroBombas()<br>
 * public static void pedirNumeroBombas()</br>
 * public static void parametrosInvalidos()</br>
 * public static void mensajeFinal(int resultado)</br>
 * public static void imprimirMarcar()
 * */
public class Menu{
	//M�todo para imprimir por pantalla
	public static void presentacion(){
		System.out.println("Bienvenido al juego del buscaminas, intenta descubrir el tablero al completo sin caer en ninguna mina");
	}
	//M�todo para imprimir por pantalla
	public static void pedirFila(String marcarODescubrir){
		System.out.print("\nIntroduce la fila de la casilla que quieres "+marcarODescubrir+" :");
	}
	//M�todo para imprimir por pantalla
	public static void pedirColumna(String marcarODescubrir){
		System.out.print("\nIntroduce la columna de la casilla que quieres "+marcarODescubrir+" :");
	}
	//M�todo para imprimir por pantalla
	public static void pedirDificultad(){
		System.out.println("Introduce la dificultad en función de esta habrá más minas y el tablero será mayor:");
		System.out.println("1) Fácil");
		System.out.println("2) Normal");
		System.out.println("3) Difícil");
		System.out.println("4) ¿Quieres ser tu propio jefe?");
	}
	//M�todo para imprimir por pantalla
	public static void pedirNumeroFilas(){
		System.out.print("\nIntroduce el numero de filas de su tablero (entre uno y mil):");
	}
	//M�todo para imprimir por pantalla
	public static void pedirNumeroColumna(){
		System.out.print("\nIntroduce el numero de columnas de su tablero (entre uno y mil):");
	}
	//M�todo para imprimir por pantalla
	public static void pedirNumeroBombas(){
		System.out.print("\nIntroduce el numero de bombas que desea tener (entre uno y nuevemil):");
	}
	//M�todo para imprimir por pantalla
	public static void parametrosInvalidos(){
		System.out.println("Recuerda, introduce un valor adecuado");
	}
	//M�todo para imprimir por pantalla
	public static void mensajeFinal(int resultado){
		if(resultado==1){
			System.out.println("Has ganado enhorabuena!!!");
		}else{
			System.out.println("PUM!!!\nTe ha estallado una bomba, has perdido :(");
		}
	}
	//M�todo para imprimir por pantalla
	public static void imprimirMarcar(){
		System.out.println("¿Quieres marcar/desmarcar una casilla? introduce M para marcar una");
		
	}
	//M�todo para imprimir por pantalla
	public static void nuevaPartida(){
		System.out.println("¿Desea jugar otra partida? Introduzca S si desea volver a jugar");
	}

}
