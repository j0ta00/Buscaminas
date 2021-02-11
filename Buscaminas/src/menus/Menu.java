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

}
