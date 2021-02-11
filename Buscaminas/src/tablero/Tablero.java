package tablero;

import casilla.Casilla;

/*
 * Nombre de la clase:Tablero
 * 
 * Propiedades basicas:
 * int filas :consultable y no modificable
 * int columnas:consultable y no modificable
 * int bombas:consultable y no modificable
 * Casilla[][] casillas:consultable y no modificable
 * 
 * Propiedades Derivadas:Ninguna
 * Propiedades Compartidas:Ninguna
 * 
 * Getters
 * public int getFilas()
 * public int getColumnas()
 * public int getBombas()
 * public Casilla[][] getCasillas()
 * 
 * */
public class Tablero {

	//Atributos
	int filas;
	int columnas;
	int bombas;
	Casilla[][] casillas;

	//Metodos constructores
	//Constructor por parametros
	public Tablero(int filas, int columnas, int bombas){
		this.filas = filas;
		this.columnas = columnas;
		if (bombas>=filas*columnas)
			bombas=(filas*columnas)-1;//Se reasignan las bombas a un valor de todas las casillas existentes menos una
		this.bombas = bombas;
		this.casillas = new Casilla[filas][columnas];
		rellenarTablero();
	}
	
	//Metodos accesores
	//Gettters
	public int getFilas() {
		return filas;
	}
	public int getColumnas() {
		return columnas;
	}
	public int getBombas() {
		return bombas;
	}
	//Metodo Delegados
	public boolean isCasillaDescubierta(int fila, int columna){
		return this.casillas[fila][columna].isDescubierta();
	}
	public boolean isCasillaMarcada(int fila, int columna){
		return this.casillas[fila][columna].isMarcada();
	}
	public int getCasillaContenido(int fila, int columna){
		return this.casillas[fila][columna].getContenido();
	}
	public void setCasillaDescubierta(boolean descubierta, int fila, int columna){
		this.casillas[fila][columna].setDescubierta(descubierta);
	}
	public void setCasillaMarcada(boolean marcada, int fila, int columna){
		this.casillas[fila][columna].setMarcada(marcada);
	}

	//Metodos aÃ±adidos
	/* Coloca tantas bombas como se hayan designado en el atributo de clase bombas y rellena el resto de celdas con los
		valores correspondientes a un tablero de buscaminas*/
	public void rellenarTablero() {
		int bombascreadas=0, fila, columna, numeroBombas;

		//Coloca bombas aleatorias
		while(bombascreadas<this.bombas) {
			fila = (int)(Math.random()*this.filas);
			columna = (int)(Math.random()*this.columnas);
			if(casillas[fila][columna]==null){
				casillas[fila][columna]= new Casilla(-1);
				bombascreadas++;
			}
		}

		//Relenar resto de celdas
		for(int i=0; i<this.filas; i++) {
			for (int j=0; j<this.columnas; j++) {
				if(casillas[i][j]==null) {
					numeroBombas=comprobarBombasCercanas(i,j);
					casillas[i][j]= new Casilla(numeroBombas);
				}
			}
		}
	}

	//Comprueba las bombas que rodean a una casilla dada y devuelve este numero
	public int comprobarBombasCercanas(int fila, int columna) {
		int bombasCercanas=0;
		
		if(casillas[fila][columna]==null) {

			if(fila-1>=0 && !(casillas[fila-1][columna]==null)){
				if(getCasillaContenido(fila-1, columna)==-1)
					bombasCercanas++;
			}

			if(fila-1>=0 && columna-1>=0 && !(casillas[fila-1][columna-1]==null)){
				if(getCasillaContenido(fila-1, columna-1)==-1)
					bombasCercanas++;
			}

			if(columna-1>=0 && !(casillas[fila][columna-1]==null)){
				if(getCasillaContenido(fila, columna-1)==-1)
					bombasCercanas++;
			}

			if(columna-1>=0 && fila+1<this.filas && !(casillas[fila+1][columna-1]==null)){
				if(getCasillaContenido(fila+1, columna-1)==-1)
					bombasCercanas++;
			}

			if(fila+1<this.filas && !(casillas[fila+1][columna]==null)){
				if(getCasillaContenido(fila+1, columna)==-1)
					bombasCercanas++;
			}

			if(columna+1<this.columnas && fila+1<this.filas && !(casillas[fila+1][columna+1]==null)){
				if(getCasillaContenido(fila+1, columna+1)==-1)
					bombasCercanas++;
			}

			if(columna+1<this.columnas && !(casillas[fila][columna+1]==null)){
				if(getCasillaContenido(fila, columna+1)==-1)
					bombasCercanas++;
			}

			if(fila-1>=0 && columna+1<this.columnas && !(casillas[fila-1][columna+1]==null)){
				if(getCasillaContenido(fila-1, columna+1)==-1)
					bombasCercanas++;
			}
			
		}
		
		return bombasCercanas;
	}
	
	public void imprimirTablero() {
		char imprimible;
		for(int i=0; i<this.filas; i++) {
			for(int j=0;  j<this.columnas; j++) {
				System.out.print("+---");
			}
			System.out.println("+");
			for (int j=0; j<this.columnas; j++) {
				if(isCasillaDescubierta(i, j)) {
					if(getCasillaContenido(i,j)<0)
						imprimible='*';
					else if(getCasillaContenido(i,j)==0)
						imprimible=' ';
					else{
						;
						imprimible= (char) (getCasillaContenido(i,j)+'0');
					}
				}else if(isCasillaMarcada(i, j)){
					imprimible='P';
				}else {
					imprimible='�';
				}
				System.out.print("| "+imprimible+" ");
			}
			System.out.println("|");
		}
		for(int j=0;  j<this.columnas; j++) {
			System.out.print("+---");
		}
		System.out.println("+");
	}

	//Alterna el estado de marcada de la casilla designada por fils y columna dados (marcada <--> desmaracada)
	public void marcarCasilla(int fila, int columna){
		setCasillaMarcada(!isCasillaMarcada(fila,columna), fila, columna);
	}

	//Marca la casilla como seleccionada, en caso de ser una bomba devuelve true y en caso contrario false. Este metodo marca
	// como descubiertas todas las casillas que le rodean en caso de encontrar un cero y lo hace para todas las siguientes
	// casillas con cero que encuentre.
	public boolean seleccionarCasilla(int fila, int columna){
		boolean perder = false;
		if(!isCasillaDescubierta(fila, columna)) {//Equivale al resto de !isCasillaDescubierta internos
			setCasillaDescubierta(true, fila, columna);

			if (getCasillaContenido(fila, columna) == -1)
				perder = true;
			else if (getCasillaContenido(fila, columna) == 0) {
				if (fila - 1 >= 0)// && !isCasillaDescubierta(fila - 1, columna))
					seleccionarCasilla(fila - 1, columna);

				if (fila - 1 >= 0 && columna - 1 >= 0 )//&& !isCasillaDescubierta(fila - 1, columna - 1))
					seleccionarCasilla(fila - 1, columna - 1);

				if (columna - 1 >= 0 )//&& !isCasillaDescubierta(fila, columna - 1))
					seleccionarCasilla(fila, columna - 1);

				if (columna - 1 >= 0 && fila + 1 < this.filas)// && !isCasillaDescubierta(fila + 1, columna - 1))
					seleccionarCasilla(fila + 1, columna - 1);

				if (fila + 1 < this.filas)// && !isCasillaDescubierta(fila + 1, columna))
					seleccionarCasilla(fila + 1, columna);

				if (columna + 1 < this.columnas && fila + 1 < this.filas)// && !isCasillaDescubierta(fila + 1, columna + 1))
					seleccionarCasilla(fila + 1, columna + 1);

				if (columna + 1 < this.columnas)// && !isCasillaDescubierta(fila, columna + 1))
					seleccionarCasilla(fila, columna + 1);

				if (fila - 1 >= 0 && columna + 1 < this.columnas)// && !isCasillaDescubierta(fila - 1, columna + 1))
					seleccionarCasilla(fila - 1, columna + 1);
			}
		}

		return perder;

	}

	//Comprueba si las casillas que quedan sin descubrir equivalen a las bombas que hay en el tablero
	public boolean comprobarVictoria (){
		int contadorCasillas=0;
		boolean ganador = true;

		for(int i=0; i<filas && ganador; i++){
			for (int j=0; j<columnas && ganador; j++){
				if(!isCasillaDescubierta(i,j)) {
					contadorCasillas++;
					if(contadorCasillas>bombas)
						ganador=false;
				}
			}
		}
		return ganador;
	}
	
}
