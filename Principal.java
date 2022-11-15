

import juego.Juego;
import elementos_juego.Actor;
import elementos_juego.Aesthetic;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Principal {

    static Scanner scan = new Scanner(System.in);
    
    static Juego juego;

    private static void guardar_partida() {

        try {

            FileOutputStream fos = new FileOutputStream("partida.sav");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(juego);
            oos.flush();
            oos.close();

            System.out.print("\n\t" + Aesthetic.ANSI_BRIGHT_GREEN + "Juego Guardado" + Aesthetic.ANSI_RESET + "\n");

        } catch (Exception e) {

            System.out.print(

            		  "\n\t" + "¡Error de serialización! No se pueden guardar los datos"
            		+ "\n\t" + e.getClass() + ": " + e.getMessage() + "\n"
            		
            		);

        }

    }
    

    private static void cargar_partida() {

        try {

            FileInputStream fis = new FileInputStream("partida.sav");
            ObjectInputStream ois = new ObjectInputStream(fis);

            juego = (Juego) ois.readObject();
            ois.close();

            System.out.print("\n\t" + "Juego cargado" + "\n");

        } catch (Exception e) {

            System.out.print(

            		  "\n\t" + "¡Error de serialización! No se pueden cargar los datos"            
            		+ "\n\t" + e.getClass() + ": " + e.getMessage() + "\n"

            		);

        }

    }

    public static void main(String[] args) throws IOException {

    	boolean volver = false;
    	
    	while (volver = true) {
        
            BufferedReader in;
            String input;
            String output = "";

            juego = new Juego();

            in = new BufferedReader(new InputStreamReader(System.in));

            juego.mostrar_introduccion();
            juego.mostrar_jugador();

            do {

                System.out.print("\t"  + ">> ");
                input = in.readLine().toLowerCase();

                switch (input) {

                    case "guardar":

                        guardar_partida();
                        break;

                    case "cargar":

                        cargar_partida();
                        break;

                    default:

                        output = juego.ejecutar_comando(input);
                        break;
                }

                System.out.println(output);

            } while (Juego.muerte != true && !input.equals("q"));

            System.out.print(
	        		
	        		  "\n\t" + "¿Quieres volver a jugar? (si / no)"
	        		+ "\n" 
	        		+ "\n\t" + ">> "
	        		
	        		);
	        
	        String opcion = scan.nextLine().toLowerCase();
	        
	        if (opcion.equals("si")) {
	        	
	        	volver = true;
	        	Juego.contador_oro(0);
	        	
	        } else {
	        	
	        	volver = false;
	        	
	        }

        }
        
    }

}


