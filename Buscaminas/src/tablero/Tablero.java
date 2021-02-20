package tablero;

import casilla.Casilla;

/**@author <b>josmatoje AND jjmza</b><br> 
 * Nombre de la clase:Tablero
 * 
 * <table>
 *	 <tr>
 *		 <th>Propiedades basicas:</th>
 * 	</tr>
 * 	 <tr>
 *	 	<td> int filas :consultable y no modificable</td>
 *   </tr>
 *	 <tr>
 * 		<td>int columnas:consultable y no modificable</td>
 * 	 </tr>
 *	 <tr>
 * 		<td>int bombas:consultable y no modificable</td>
 *	 </tr>
 * 	 <tr>
 * 		<td>Casilla[][] casillas:consultable y no modificable</td>
 *	 </tr>
 * </table>
 * 
 * <b>Propiedaes derivadas:</b> Ninguna<br>
 * <b>Propiedades Compartidas:</b> Ninguna<br>
 * 
 * <table>
 * 	<tr>
 * 		<th>Métodos accesores:</th>
 * 	</tr>
 * 	<tr>
 *		 <td> public int getFilas()</td>
 * 	</tr>
 * 	<tr> 
 * 		<td>public int getColumnas()</td>
 * 	</tr>
 * 	<tr>
 * 		<td>public int getBombas()</td>
 * 	</tr>
 *  <tr>
 * 		<td>public Casilla[][] getCasillas()</td>
 * 	</tr>
 * <tr>
 * 		<td>El resto son métodos accesores delegados sobre la clase Casilla</td>
 * 	</tr>
 * </table> 
 * <br><b>Metodos adicionales:</b><br>
 *-public void rellenarTablero()<br>
 *-comprobarBombasCercanas(int fila, int columna)<br>
 *-public void marcarCasilla(int fila, int columna) <br>
 *-public void marcarCasilla(int fila, int columna) <br>
 *-public boolean seleccionarCasilla(int fila, int columna) <br>
 *-public boolean comprobarVictoria () <br>
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

	/**
	 * @author<b>josmatoje AND jjmza</b><br> 
	 * Cabecera:public void rellenarTablero()<br>
	 * Proposito: Coloca tantas bombas como se hayan designado en el atributo de clase bombas y rellena<br> 
	 * el resto de celdas con los valores correspondientes a un tablero de buscaminas<br>
	 * Precondición:Ninguna<br>
	 * Postcondición:Ninguna, se trata de un procedimiento que llena el tablero de bombas/minas
	 * @param Ninguno
	 * @return Nada
	 * */
	public void rellenarTablero(){
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
	/**
	 * @author<b>josmatoje AND jjmza</b><br> 
	 * Cabecera:public void rellenarTablero()<br>
	 * Proposito:Comprueba las bombas que rodean a una casilla dada y devuelve este numero<br> 
	 * Precondición:Ninguna<br>
	 * Postcondición:Ninguna, se trata de un procedimiento que compruba las bombas cercanas a una casilla
	 * @param int fila, int columna
	 * @return int bombasCercanas
	 * */
	public int comprobarBombasCercanas(int fila, int columna){
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
	/**
	 * @author<b>josmatoje AND jjmza</b><br> 
	 * Cabecera:public void imprimirTablero()<br>
	 * Proposito:Imprime el tablero donde se jugará al buscaminas<br>
	 * Precondición:Ninguna<br>
	 * Postcondición:Ninguna, se trata de un procedimiento que imprime el tablero
	 * @param Ninguno
	 * @return Nada
	 * */
	public void imprimirTablero(){
		char imprimible;
		//Imprime los numeros para cada columna
		System.out.print("    ");
		for(int i=0;  i<this.columnas; i++) {
			if(i+1>9)
				System.out.print(" "+ (i+1) +" ");
			else
				System.out.print("  " + (i+1) + " ");
		}
		System.out.println();
		//Repite para cada fila
		for(int i=0; i<this.filas; i++) {
			//Imprime linea entre filas tantas veces como columnas haya
			System.out.print("    ");
			for(int j=0;  j<this.columnas; j++)
				System.out.print("+---");
			System.out.println("+");
			//Imprime numero de fila
			if(i+1>9)
				System.out.print(" "+ (i+1) +" ");
			else
				System.out.print("  " + (i+1) + " ");
			//Imprime las casillas de una fila
			for (int j=0; j<this.columnas; j++) {
				if(isCasillaDescubierta(i, j)) {
					if(getCasillaContenido(i,j)<0)
						imprimible='*';
					else if(getCasillaContenido(i,j)==0)
						imprimible=' ';
					else
						imprimible= (char) (getCasillaContenido(i,j)+'0');
				}else if(isCasillaMarcada(i, j)){
					imprimible='P';
				}else {
					imprimible='•';
				}
				System.out.print("| "+imprimible+" ");
			}
			System.out.println("|");
		}
		System.out.print("    ");
		for(int j=0;  j<this.columnas; j++) {
			System.out.print("+---");
		}
		System.out.println("+");
	}
	/**
	 * @author<b>josmatoje AND jjmza</b><br> 
	 * Cabecera:public void marcarCasilla(int fila, int columna)<br>
	 * Proposito: Alterna el estado de marcada de la casilla designada por fila y columna dados<br> 
	 * Precondición:Ninguna<br>
	 * Postcondición:Ninguna, se trata de un procedimiento que marca/desmarca una casilla
	 * @param int fila, int columna
	 * @return Nada
	 * */
	public void marcarCasilla(int fila, int columna){
		setCasillaMarcada(!isCasillaMarcada(fila,columna), fila, columna);
	}
	/**
	 * @author<b>josmatoje AND jjmza</b><br> 
	 * Cabecera:public boolean seleccionarCasilla(int fila, int columna)<br>
	 * Proposito: Este método descubre el valor de la casilla marcada y de las de su alrededor<br> 
	 * Precondición:Ninguna<br>
	 * Postcondición:Ninguna, se trata de una función recursiva
	 * @param int fila, int columna
	 * @return boolean perder
	 * */
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
	/**
	 * @author<b>josmatoje AND jjmza</b><br> 
	 * Cabecera:public boolean seleccionarCasilla(int fila, int columna)<br>
	 * Proposito: Este método comprueba el resultado de la partida<br> 
	 * Precondición:Ninguna<br>
	 * Postcondición:Ninguna, se trata de una función que devuelve un booleano
	 * @param Nada
	 * @return boolean ganador
	 * */
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
