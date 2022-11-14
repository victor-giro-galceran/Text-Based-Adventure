
package elementos_juego;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class Lista_Objeto extends ArrayList<Objeto> implements java.io.Serializable {

    public String descripcion_objetos() {
    	
        String mensaje = "";
        
        if (this.size() == 0) {
        	
            mensaje = "\t" + "Vacío" + "\n";
        
        } else {
        
        	for (Objeto objeto : this) {
            
        		mensaje = mensaje + objeto.getNombre() + ": " + objeto.getDescripcion() + "\n";
            
        	}
        
        }
        
        return mensaje;
    
    }

    public Objeto este_objeto(String un_nombre) {
        
    	Objeto un_objeto = null;
        
    	String nombre_objeto = "";
    	
        String un_nombre_minuscula = un_nombre.trim().toLowerCase();
        
        for (Objeto objeto : this) {
        
        	nombre_objeto = objeto.getNombre().trim().toLowerCase();
            
        	if (nombre_objeto.equals(un_nombre_minuscula)) {
            
        		un_objeto = objeto;
            
        	}
        
        }
        
        return un_objeto;
    
    }
        
    public String toString() {
    	
    	String mensaje = "";
    	String nombre = "";
    	int cantidad_total = 0;

    	
    	if (Lista_Objeto.this.size() == 0) {
    		
    		mensaje = "\t" 	 + "No tienes objetos"
    				+ "\n"
    				+ "\n\t" + "0";
    		
    	} else if (Lista_Objeto.this.size() <= 1) {
    		
    		mensaje = "\t" + "Tienes " + size() + " objeto" + "\n";
    	
    	} else {
    		
    		mensaje = "\t" + "Tienes " + size() + " objetos" + "\n";
    		
    	}
    	
    	for (Objeto o : this) {
   		
    		nombre += o.toString() + "\n";
        		        
    		cantidad_total += o.getCantidad();
	
    		mensaje = nombre + "\n\t" + cantidad_total;
    		
    	}    	
    	    	
    	return mensaje;
    	
    }
}
