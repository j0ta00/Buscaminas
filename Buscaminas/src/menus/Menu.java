package menus;
/**
 * @author <b>josmatoje AND jjmza</b><br> 	 
 *<b>Propiedades basicas:</b> Ninguna se trata de una clase estática menu que se encarga de <br>
 * imprimir por pantalla las distintas opciones y funcionalidades del proyecto		
 * <b>Propiedaes derivadas:</b> Ninguna<br>
 * <b>Propiedades Compartidas:</b> Scanner teclado<br>
 * <b>Métodos accesores: Ninguno</b></br>
 * <b>Métodos Adicionales:</b> public static void nuevaPartida()<br>
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
	//Método para imprimir por pantalla
	public static void presentacion(){
		System.out.println("Bienvenido al juego del buscaminas, intenta descubrir el tablero al completo sin caer en ninguna mina");
	}
	//Método para imprimir por pantalla
	public static void pedirFila(String marcarODescubrir){
		System.out.print("\nIntroduce la fila de la casilla que quieres "+marcarODescubrir+" :");
	}
	//Método para imprimir por pantalla
	public static void pedirColumna(String marcarODescubrir){
		System.out.print("\nIntroduce la columna de la casilla que quieres "+marcarODescubrir+" :");
	}
	//Método para imprimir por pantalla
	public static void pedirDificultad(){
		System.out.println("Introduce la dificultad en funciÃ³n de esta habrÃ¡ mÃ¡s minas y el tablero serÃ¡ mayor:");
		System.out.println("1) FÃ¡cil");
		System.out.println("2) Normal");
		System.out.println("3) DifÃ­cil");
		System.out.println("4) Â¿Quieres ser tu propio jefe?");
	}
	//Método para imprimir por pantalla
	public static void pedirNumeroFilas(){
		System.out.print("\nIntroduce el numero de filas de su tablero (entre uno y mil):");
	}
	//Método para imprimir por pantalla
	public static void pedirNumeroColumna(){
		System.out.print("\nIntroduce el numero de columnas de su tablero (entre uno y mil):");
	}
	//Método para imprimir por pantalla
	public static void pedirNumeroBombas(){
		System.out.print("\nIntroduce el numero de bombas que desea tener (entre uno y nuevemil):");
	}
	//Método para imprimir por pantalla
	public static void parametrosInvalidos(){
		System.out.println("Recuerda, introduce un valor adecuado");
	}
	//Método para imprimir por pantalla
	public static void mensajeFinal(int resultado){
		if(resultado==1){
			System.out.println("Has ganado enhorabuena!!!");
		}else{
			System.out.println("PUM!!!\nTe ha estallado una bomba, has perdido :(");
		}
	}
	//Método para imprimir por pantalla
	public static void imprimirMarcar(){
		System.out.println("Â¿Quieres marcar/desmarcar una casilla? introduce M para marcar una");
		
	}
	//Método para imprimir por pantalla
	public static void nuevaPartida(){
		System.out.println("Â¿Desea jugar otra partida? Introduzca S si desea volver a jugar");
	}

}
