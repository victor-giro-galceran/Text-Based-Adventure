
package elementos_juego;

@SuppressWarnings("serial")
public class Colector_Objeto extends Objeto implements java.io.Serializable {

	private Lista_Objeto objetos = new Lista_Objeto();

	public Colector_Objeto(String un_nombre, String una_descipcion, int una_cantidad, int un_precio, Lista_Objeto una_lista) {
		
		super(un_nombre, una_descipcion, una_cantidad, un_precio);
		
		objetos = una_lista;
		
	}

	public Lista_Objeto getObjetos() {
		
		return objetos;
		
	}
	
	public void setObjetos(Lista_Objeto objetos) {
		
		this.objetos = objetos;
		
	}

}
