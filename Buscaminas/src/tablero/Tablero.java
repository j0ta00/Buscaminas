package tablero;

import casilla.Casilla;

/*
 * Nombre de la clase:Tablero
 * 
 * Propiedades básicas:
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
	//Métodos constructores
	//Constructor por parámetros
	public Tablero(int filas, int columnas, int bombas){
		this.filas = filas;
		this.columnas = columnas;
		this.bombas = bombas;
		this.casillas = new Casilla[filas][columnas];
		rellenarTablero();
	}
	
	//Métodos accesores
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
	public int getCasillaContenido(int fila, int columna){
		return this.casillas[fila][columna].getContenido();
	}
	public boolean isCasillaMarcada(int fila, int columna){
		return this.casillas[fila][columna].isMarcada();
	}
	public void setCasillaDescubierta(boolean descubierta, int fila, int columna){
		this.casillas[fila][columna].setDescubierta(descubierta);
	}
	public void setMarcada(boolean marcada, int fila, int columna){
		this.casillas[fila][columna].setDescubierta(marcada);
	}
	
	
	
	public void rellenarTablero() {
		int bombascreadas=0, fila, columna, numeroBombas;
		//Coloca bombas aleatorias
		while(bombascreadas<this.bombas) {
			fila = (int)(Math.random()*this.filas);
			columna = (int)(Math.random()*this.columnas);
			if(casillas[fila][columna]==null)
				casillas[fila][columna]= new Casilla(-1);
			bombascreadas++;
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
			System.out.println("__________________________________________");
			for (int j=0; j<this.columnas; j++) {
				if(isCasillaDescubierta(i, j)) {
					if(getCasillaContenido(i,j)==0)
						imprimible=' ';
					else if(getCasillaContenido(i,j)<0)
						imprimible='*';
					else
						imprimible= (char) getCasillaContenido(i,j);
				}else if(isCasillaMarcada(i, j)){
					imprimible='P';
				}else {
					imprimible=' ';
				}
				System.out.print("| "+imprimible+" ");
			}
			System.out.println("|");
		}
		System.out.println("__________________________________________");
	}
	
	
}
