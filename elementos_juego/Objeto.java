
package elementos_juego;

@SuppressWarnings("serial")
public class Objeto implements java.io.Serializable {

	private String nombre;
	private String descripcion;
	private int cantidad;
	private int precio;

	public Objeto(String un_nombre, String una_descripcion, int una_cantidad, int un_precio) {
		
		this.nombre = un_nombre;
		this.descripcion = una_descripcion;
		this.cantidad = una_cantidad;
		this.precio = un_precio;
		
	}

	public String getNombre() {
		
		return nombre;
		
	}

	public void setNombre(String un_nombre) {
		
		this.nombre = un_nombre;
		
	}

	public String getDescripcion() {
		
		return descripcion;
		
	}

	public void setDescripcion(String una_descripcion) {
		
		this.descripcion = una_descripcion;
		
	}
	
	public int getCantidad() {
		
		return cantidad;
		
	}

	public void setCantidad(int una_cantidad) {
		
		this.cantidad = una_cantidad;
		
	}
	
	public int getPrecio() {
		
		return precio;
		
	}

	public void setPrecio(int un_precio) {
		
		this.precio = un_precio;
		
	}
	
	public String toString() {
		
		return "\t" + cantidad + " x " + nombre + " - Descripcion: " + descripcion;
		
	}
	
}
