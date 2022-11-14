
package elementos_juego;

@SuppressWarnings("serial")
public class Habitacion extends Colector_Objeto implements java.io.Serializable {

    private int n;
    private int s; 
    private int o; 
    private int e;

    public Habitacion(String un_nombre, String una_descripcion, int una_cantidad, int un_precio, int a_N, int a_S, int a_O, int a_E, Lista_Objeto una_lista) {
    	
        super(un_nombre, una_descripcion, una_cantidad, un_precio, una_lista); 
        this.n = a_N;
        this.s = a_S;
        this.o = a_O;
        this.e = a_E;
        
    }

      
    public int getN() {
    	
        return n;
        
    }

    public void setN(int a_N) {
    	
        this.n = a_N;
        
    }

    public int getS() {
    	
        return s;
        
    }

    public void setS(int a_S) {
    	
        this.s = a_S;
        
    }

    
    public int getE() {
    	
        return e;
        
    }

    public void setE(int a_E) {
    	
        this.e = a_E;
        
    }

    
    public int getO() {
    	
        return o;
        
    }

    void setO(int a_O) {
    	
        this.o = a_O;
        
    }    

    public String describe() {
    	//                    %s.%s.
        return String.format("%s %s", getNombre(), "\n" + getDescripcion()) /*+ "\n\n\t" + "Hay: \n" + getObjetos().descripcion_objetos()*/;
        
    }
    
    public String describe_objetos() {
    	
    	return String.format("Hay: \n" + getObjetos().descripcion_objetos());
    	
    }
    
}
