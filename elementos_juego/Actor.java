

package elementos_juego;

@SuppressWarnings("serial")
public class Actor extends Colector_Objeto implements java.io.Serializable {

    private Habitacion habitacion; 
    
    public static Actor jugador; 
    
    public static Actor bot;
    
    public static Actor mercader;
    
    private int vida;
    
    public Actor(String un_nombre, String una_descripcion, int una_cantidad, int un_precio, Lista_Objeto una_lista, Habitacion una_habitacion, int una_vida) {
    	
        super(un_nombre, una_descripcion, una_cantidad, un_precio, una_lista); 
        this.habitacion = una_habitacion;
        this.vida = una_vida;
        
    }

    public void setHabitacion(Habitacion una_habitacion) {
    	
        this.habitacion = una_habitacion;
        
    }

    public Habitacion getHabitacion() {
    	
        return this.habitacion;
        
    }
       
    public void setVida(int una_vida) {
    	
    	this.vida = una_vida;
    	
    }
    
    public int getVida() {
    	
    	return this.vida;
    	
    }
    
    
//////////////////////////////////////////////
    
    public static Actor getJugador() {
    	
        return jugador;
        
    }

    public void setJugador(Actor un_jugador) {
    	
        jugador = un_jugador;
        
    }
    
    public Actor getBot() {
    	
    	return bot;
    	
    }
    
    public void setBot(Actor un_bot) {
    	
    	bot = un_bot;
    	
    }
    
    public static Actor getMercader() {
    	
        return mercader;
        
    }

    public void setMercader(Actor un_mercader) {
    	
        mercader = un_mercader;
        
    }
    
//////////////////////////////////////////////    
    
}