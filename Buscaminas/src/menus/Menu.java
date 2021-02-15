package menus;

public class Menu{

	public static void presentacion(){
		System.out.println("Bienvenido al juego del buscaminas, intenta descubrir el tablero al completo sin caer en ninguna mina");
	}
	public static void pedirFila(String marcarODescubrir){
		System.out.print("\nIntroduce la fila de la casilla que quieres "+marcarODescubrir+" :");
	}
	public static void pedirColumna(String marcarODescubrir){
		System.out.print("\nIntroduce la columna de la casilla que quieres "+marcarODescubrir+" :");
	}
	public static void pedirDificultad(){
		System.out.println("Introduce la dificultad en función de esta habrá más minas y el tablero será mayor:");
		System.out.println("1) Fácil");
		System.out.println("2) Normal");
		System.out.println("3) Difícil");
		System.out.println("4) ¿Quieres ser tu propio jefe?");
	}
	public static void pedirNumeroFilas(){
		System.out.print("\nIntroduce el numero de filas de su tablero (entre uno y mil):");
	}
	public static void pedirNumeroColumna(){
		System.out.print("\nIntroduce el numero de columnas de su tablero (entre uno y mil):");
	}
	public static void pedirNumeroBombas(){
		System.out.print("\nIntroduce el numero de bombas que desea tener (entre uno y nuevemil):");
	}

	public static void parametrosInvalidos(){
		System.out.println("Recuerda, introduce un valor adecuado");
	}
	public static void mensajeFinal(int resultado){
		if(resultado==1){
			System.out.println("Has ganado enhorabuena!!!");
		}else{
			System.out.println("PUM!!!\nTe ha estallado una bomba, has perdido :(");
		}
	}
	
	public static void imprimirMarcar(){
		System.out.println("¿Quieres marcar/desmarcar una casilla? introduce M para marcar una");
		
	}

	public static void nuevaPartida(){
		System.out.println("¿Desea jugar otra partida? Introduzca S si desea volver a jugar");
	}

}
