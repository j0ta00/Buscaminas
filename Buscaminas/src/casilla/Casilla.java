package casilla;
/*
 * Nombre de la classe: Casilla
 * 
 * Propiedades basicas:
 * Boolean descubierta consultable y modificable
 * Int contenido consultable y no modificable
 * boolean marcada consultable y modificable
 * 
 * Propiedaes derivadas: Ninguna
 * Propiedades Compartidas:Ninguna
 * 
 * Getters y Setters:
 * public boolean isDescubierta() 
 * public int getContenido()
 * public boolean isMarcada()
 * public void setDescubierta(boolean descubierta) 
 * public void setMarcada(boolean marcada) 
 * Metodos adicionales/añadidos:Ninguno
 * 
 * */
public class Casilla{
	//Atributos
	boolean descubierta;
	boolean marcada;
	int contenido;
	//Metodos constructores
	//Constructor por defecto
	public Casilla(){
		this.descubierta = false;
		this.marcada = false;
		this.contenido = 0;
	}
	//Constructor por parametros
	public Casilla(int contenido){
		this.descubierta = false;
		this.marcada = false;
		this.contenido = contenido;
	}
	//Metodos accesores
	//Getters
	public boolean isDescubierta(){
		return descubierta;
	}
	public int getContenido(){
		return contenido;
	}
	public boolean isMarcada(){
		return marcada;
	}
	//Setters
	public void setDescubierta(boolean descubierta){
		this.descubierta = descubierta;
	}
	public void setMarcada(boolean marcada){
		this.marcada = marcada;
	}

}
