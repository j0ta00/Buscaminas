package casilla;
/**
 * @author <b>josmatoje AND jjmza</b><br> 
 *<b> Nombre de la clase:</b> Casilla<br> 
 * 
 * <table>
 *	 <tr>
 *		 <th>Propiedades basicas:</th>
 * 	</tr>
 * 	 <tr>
 *	 	<td> Boolean descubierta consultable y modificable</td>
 *   </tr>
 *	 <tr>
 * 		<td>Int contenido consultable y no modificable</td>
 * 	 </tr>
 *	 <tr>
 * 		<td>boolean marcada consultable y modificable</td>
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
 *		 <td>public boolean isDescubierta()</td>
 * 	</tr>
 * 	<tr> 
 * 		<td>public int getContenido()</td>
 * 	</tr>
 * 	<tr>
 * 		<td>public boolean isMarcada()</td>
 * 	</tr>
 * 	<tr>
 * 		<td>public void setDescubierta(boolean descubierta)</td>
 * 	</tr>
 *	 <tr> 
 * 		<td>public void setMarcada(boolean marcada)</td>
 * 	</tr>
 * </table> 
 * <br><b>Metodos adicionales:</b> Ninguno
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
