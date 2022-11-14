
package juego;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom; // int numero_aleatorio = ThreadLocalRandom.current().nextInt(min, max + 1);

import elementos_juego.Actor;
import elementos_juego.Habitacion;
import elementos_juego.Objeto;
import elementos_juego.Lista_Objeto;
import elementos_juego.Tipo_Objeto;
import elementos_juego.Aesthetic;
import globales.Direccion;


@SuppressWarnings("serial")
public class Juego implements java.io.Serializable {

	static Scanner scan = new Scanner(System.in);

	static String nombre_jugador = "jugador";
	static int oro = 0;
	
	
	static boolean cabaña 	= false;
	static boolean pozo 	= false;
	static boolean cueva 	= false;
	static boolean rio 		= false;
	static boolean bosque	= false;
	static boolean mina 	= false;
	static boolean montaña 	= false;
	static boolean ruinas 	= false;
	static boolean granja 	= false;
	static boolean mercado	= false;
	
	static int salida_rio = -1;
	
    private ArrayList<Habitacion> mapa;
    
    List<String> comandos = new ArrayList<>(Arrays.asList(

    		"help",
    		"mapa",
    		"ayuda",
    		"limpiar",
    		"clear",
    		"vida",
    		"oro",
    		"cls",
    		"yo",
    		"?",

    		"buscar",
            "recoger",
            "soltar",
            "hablar",
            "usar",
            "utilizar",
            "encender",
            
            // "apagar",
            // "abrir",      
            // "subir",
            
            "inventario",
         	"i",
            
            
            "norte",
            "sur",
            "este",
            "oeste", 
                      
            
            "guardar",
            "cargar"
            
    		));
    
    List<String> objectos = new ArrayList<>(Arrays.asList(
    		
    		"mochila",
    		"hoguera",
    		"cuerda",
    		"mesa",
    		"madera",
    		"piedra",
    		"oro",
    		"mision",
    		"tela",

    		"antorcha",
    		"escalera",
    		"puñal",
    		"patatas"
    		
    		));

    public Juego() {
    	
        this.mapa = new ArrayList<Habitacion>(); // TODO: Make map a Generic list of Room

        // -------------------------------------- O B J E T O S -------------------------------------- \\
        
        Lista_Objeto cabaña_lista = new Lista_Objeto();
        cabaña_lista.add(new Tipo_Objeto(
        		
        		"\t" + "mochila", "descripcion_objeto"
        		
        		, 1, 1));
        
        Lista_Objeto pozo_lista = new Lista_Objeto();
        pozo_lista.add(new Tipo_Objeto(
        		
        		"\t" + "cuerda", "descripcion_objeto"
        		
        		, 9, 20));
        
        Lista_Objeto cueva_lista = new Lista_Objeto();
        cueva_lista.add(new Tipo_Objeto(
        		
        		"\t" + "antorcha", "descripcion_objeto" // 🔨 🪵 🪚...
        		
        		, 1, 40));
        
        Lista_Objeto rio_lista = new Lista_Objeto();
        
        Lista_Objeto habitacion_bosque_lista = new Lista_Objeto();
        habitacion_bosque_lista.add(new Tipo_Objeto(
        		
        		"\t" + "hoguera", "acogedora..." //🔥
        		
        		, 1, 0));
        habitacion_bosque_lista.add(new Tipo_Objeto(
        		
        		"\t" + "mesa", "puedes construir..."
        		
        		, 1, 0));
        habitacion_bosque_lista.add(new Tipo_Objeto(
        		
        		"\t" + "madera", "descripcion_objeto" // 🔨 🪵 🪚...
        		
        		, 10, 30));
        
        Lista_Objeto mina_lista = new Lista_Objeto();
        mina_lista.add(new Tipo_Objeto(
        		
        		"\t" + "oro", "descripcion_objeto"
        		
        		, 10, 0));

        Lista_Objeto montaña_lista = new Lista_Objeto();
        
        Lista_Objeto ruinas_lista = new Lista_Objeto();
        ruinas_lista.add(new Tipo_Objeto(
        		
        		"\t" + "piedra", "..."
        		
        		, 4, 0));
        ruinas_lista.add(new Tipo_Objeto(
        		
        		"\t" + "oro", "..."
        		
        		, 100, 0));
        ruinas_lista.add(new Tipo_Objeto(
        		
        		"\t" + "escalera", "..."
        		
        		, 1, 50));
        
        Lista_Objeto granja_lista = new Lista_Objeto();
        granja_lista.add(new Tipo_Objeto(
        		
        		"\t" + "tela", "..."
        		
        		, 5, 20));
        
        Lista_Objeto mercado_lista = new Lista_Objeto();
        mercado_lista.add(new Tipo_Objeto(
        		
        		"\t" + "oro", "..."
        		
        		, 1000, 0));
       
        Lista_Objeto respawn_lista = new Lista_Objeto();        
        respawn_lista.add(new Tipo_Objeto(
        		
        		"\t" + "antorcha", "descripcion_objeto" // 🔨 🪵 🪚...
        		
        		, 1, 40));
        
        respawn_lista.add(new Tipo_Objeto(
        		
        		"\t" + "escalera", "descripcion_objeto" // 🔨 🪵 🪚...
        		
        		, 1, 50));
        
        respawn_lista.add(new Tipo_Objeto(
        		
        		"\t" + "oro", "..."
        		
        		, 90, 0));
        
        respawn_lista.add(new Tipo_Objeto(
        		
        		"\t" + "patatas", "..."
        		
        		, 8, 15));
        
        respawn_lista.add(new Tipo_Objeto(
        		
        		"\t" + "puñal", "..."
        		
        		, 1, 90));
        
        Lista_Objeto lista_jugador = new Lista_Objeto();        
        Lista_Objeto lista_bot = new Lista_Objeto();
        Lista_Objeto lista_mercader = new Lista_Objeto();
        
        
        
//		\\ -------------------------------------- O B J E T O S -------------------------------------- // 
        
        
        // ----------------------------------------- M A P A ----------------------------------------- \\
        
        
        mapa.add(new Habitacion("la Cabaña 🛖",
        		
      		  	  "\n\t" + "En lo profundo del bosque"
              	+ "\n\t" + "una cabaña hecha de troncos de roble"
        		
        		, 99, 0, Direccion.SINSALIDA, 4, Direccion.SINSALIDA, 1, cabaña_lista));
       
        
        mapa.add(new Habitacion("el Pozo",
        		
      		  	  "\n\t" + ""
              	+ "\n\t" + "" //🚰 🪢 
        		
        		, 99, 0, Direccion.SINSALIDA, Direccion.SINSALIDA, 0, 2, pozo_lista));
        
        
        mapa.add(new Habitacion("la Cueva",
        		
        		  "\n\t" + "Es un agujero oscuro en una ladera con una apertura estrecha, te"
        		+ "\n\t" + "inclinas para poder pasar por la grieta. La oscuridad es tan"
        	  	+ "\n\t" + "densa que es imposible ver más allá de unos pocos pies frente a ti" //🪨 ⛏️ 🪦 
        		
        		, 99, 0, Direccion.SINSALIDA, Direccion.SINSALIDA, 1, Direccion.SINSALIDA, cueva_lista));
        
        
        mapa.add(new Habitacion("el Rio",
        		
        		  "\n\t" + ""
        	    + "\n\t" + "" //💧 💦 
        		
        		, 99, 0, Direccion.SINSALIDA, Direccion.SINSALIDA, salida_rio, 4, rio_lista));
        
        
        mapa.add(new Habitacion("el Bosque",
        		
        		  "\n\t" + "Levanté la cara, al principio la luz y la sombra que me cubrían no me dejaban ver bien" 
        		+ "\n\t" + "Los árboles azotaban y chocaban unos contra otros…" // 🥩 🍖 🌿 🍁 🍂
                		
                , 99, 0, 0, 7, 3, 5, habitacion_bosque_lista));
        
       
        mapa.add(new Habitacion("la Mina abandonada",
        		
        		  "\n\t" + "Es un agujero oscuro a los pies de una montaña inmensa, te" 
        	   	+ "\n\t" + "asomas para poder mirar a ver si puedes distinguir algo"
        		+ "\n\t" + "entre la oscuridad, pero no consigues distinguir ninguna silueta"
        	   	
        	   	, 99, 0, Direccion.SINSALIDA, Direccion.SINSALIDA, 4, Direccion.SINSALIDA, mina_lista));
     
        
        mapa.add(new Habitacion("la Montaña", 
        		
      		  	  "\n\t" + ""
              	+ "\n\t" + "" //🏔️ 
        		
        		, 99, 0, Direccion.SINSALIDA, 9, Direccion.SINSALIDA, Direccion.SINSALIDA, montaña_lista));
      
        
        mapa.add(new Habitacion("las Ruinas",
        		
      		  	  "\n\t" + "Pilares de piedra desgastados por la intemperie rodeados de matas de hierba muerta,"
              	+ "\n\t" + "descripcion paisaje, hay una estructura muy derruida parece tener un objeto pero no puedes acceder porque esta muy alto..." //🏘️ 🏚️ 🪜 
        		
        		, 99, 0, 4, Direccion.SINSALIDA, Direccion.SINSALIDA, 8, ruinas_lista));
     
        
        mapa.add(new Habitacion("la Granja",
        		
      		  	  "\n\t" + ""
              	+ "\n\t" + "" //🌱 🪜 🪴 
        		
        		, 99, 0, Direccion.SINSALIDA, Direccion.SINSALIDA, 7, 9, granja_lista));
      
        
        mapa.add(new Habitacion("el Mercado",
        		
      		  	  "\n\t" + ""
              	+ "\n\t" + "" //🍗 🧀 
        		
        		, 99, 0, 6, Direccion.SINSALIDA, 8, Direccion.SINSALIDA, mercado_lista));
        
        mapa.add(new Habitacion("respawn",
        		
      		  	  "\n\t" + ""
              	+ "\n\t" + "donde los objetos aparecen desde el principio, no se puede acceder aqui" //🍗 🧀 
        		
        		, 99, 0, Direccion.SINSALIDA, Direccion.SINSALIDA, Direccion.SINSALIDA, Direccion.SINSALIDA, respawn_lista));

        
//		\\ ----------------------------------------- M A P A ----------------------------------------- //
        
        // 							   Nombre			Descripcion				Capacidad Carga 					Posicion mapa 	Vida
        Actor.jugador = 	new Actor(nombre_jugador/*()*/, 	"un adorable jugador", 			20, 0, 		lista_jugador, 	mapa.get(9), 	100);
        Actor.bot = 		new Actor("bot", 			"un robot automatizado", 		5, 0, 			lista_bot, 		mapa.get(3), 	1);
        Actor.mercader = 	new Actor("mercader", 		"un comerciante simpatico", 	5, 0, 			lista_mercader, mapa.get(9), 	1);
    }
    
    ArrayList<Habitacion> getMapa() {
    	
        return mapa;
        
    }

    void setMapa(ArrayList<Habitacion> un_mapa) {
    	
        mapa = un_mapa;
        
    }
    
    public String nombre_jugador() {
    	
    	String nombre = "";
    	
    	mostrar_string("\n\t" + "Introduce el nombre de tu protagonista");
    	
    	System.out.print("\n\t" + ">> ");
    	
		nombre = scan.next().toLowerCase();
		
		nombre_jugador = nombre.toUpperCase().charAt(0) + nombre.substring(1, nombre.length()).toLowerCase();
		
		System.out.print("\n\t" + "Te llamas ");
		
    	for (int i = 0; i < nombre_jugador.length(); i++) {

    		sleep(40);
    		System.out.print(nombre_jugador.charAt(i));
    		sleep(40);
        
    	}
    	
    	mostrar_string("\n" + "\n" + "\n");
    	
    	return nombre_jugador;
    	
    }
    
    public int dificultad() {

    	int dificultad = 9;

    	while (dificultad != 1 || dificultad != 2 || dificultad != 3) {

			try {

				int vida_aleatorio = 100;

				mostrar_string(

						  "\n\t" + "Escoge la dificultad"
						+ "\n"
						+ "\n\t" + "(1) Fácil"
						+ "\n\t" + "(2) Intermedio"
						+ "\n\t" + "(3) Difícil"

						);

				dificultad = scan.nextInt();

				switch (dificultad) {

					case 1:

						mostrar_string("\n\t" + "Has escogido dificultad \"Fácil\"");

						// capacidad de carga

						break;

					case 2:

						mostrar_string("\n\t" + "Has escogido dificultad \"Intermedia\"");

						vida_aleatorio = ThreadLocalRandom.current().nextInt(60, 80 + 1);

						break;

					case 3:

						mostrar_string("\n\t" + "Has escogido dificultad \"Difícil\"");

						vida_aleatorio = ThreadLocalRandom.current().nextInt(30, 50 + 1);

						break;

					default:

						mostrar_string("\n\t" + "Valor incorrecto");

				}

			} catch (Exception e) {

				mostrar_string("\n\t" + "¡Error!");

			}

    	}

    	return dificultad;

    }
    
    private void transferir_objetos(Objeto objeto, Lista_Objeto desde_lista, Lista_Objeto hacia_lista) {
    	
        desde_lista.remove(objeto);
        hacia_lista.add(objeto);
        
    }
    
    private int contador_oro(int nuevo_oro) {
    	
    	oro += nuevo_oro;
    	
    	return oro;
    	
    }

    public String recoger_objeto(String nombre_objeto) {
    	
        String mensaje = "";
        Objeto objeto = Actor.jugador.getHabitacion().getObjetos().este_objeto(nombre_objeto);
        
        if (nombre_objeto.equals("")) {
        	
        	nombre_objeto = "\n\t" + "Objeto innombrado" + "\n";
        	
        }
        
        if (objeto == null) {
        	
            mensaje = "\n\t" + "¡No hay " + nombre_objeto + " aquí!" + "\n";
            
        } else {        	
        	
        	if (nombre_objeto.equals("mesa")) {
        		
        		mensaje = "\n\t" + "No puedes recoger la " + nombre_objeto + "!" + "\n";
        		
        	} else if (nombre_objeto.equals("hoguera")) {
        		
        		mensaje = "\n\t" + "No puedes recoger la " + nombre_objeto + "!" + "\n";
        		
        	} else if (nombre_objeto.equals("mochila")) {
        	
        		transferir_objetos(objeto, Actor.jugador.getHabitacion().getObjetos(), Actor.jugador.getObjetos());
        		
        		Actor.jugador.setCantidad(50);
        		
            	mensaje = "\n\t" + "¡Has recojido " + nombre_objeto + "!"
            			+ "\n\t" + "+ 30 de espacio" + "\n";
            
        	} else if (nombre_objeto.equals("oro")) {

        		int cantidad_oro = objeto.getCantidad();
        		
        		contador_oro(cantidad_oro);
        		
             	mensaje = "\n\t" + objeto.getDescripcion() 
             			+ "\n"
             			+ "\n\t" + "¡Has recojido " + objeto.getCantidad() + " monedas de " + nombre_objeto + "!" + "\n";

         	} else {
        		
        		if (objeto.getCantidad() > Actor.jugador.getCantidad()) {
        			
        			mensaje = "\n\t" + "¡No tienes espacio!" + "\n";
        		
        		} else {
        		
        			transferir_objetos(objeto, Actor.jugador.getHabitacion().getObjetos(), Actor.jugador.getObjetos());
        			mensaje = "\n\t" + "¡Has recojido " + nombre_objeto + "! Te ocupa " + objeto.getCantidad() + " de espacio" + "\n";
        		
        		}
        	
        	}
        	
        }
        
        return mensaje;
        
    }

    public String soltar_objeto(String nombre_objeto) {
    	
        String mensaje = "";
        
        Objeto objeto = Actor.jugador.getObjetos().este_objeto(nombre_objeto);
        
        if (nombre_objeto.equals("")) {
        	
            mensaje = "\n\t" + "¡Tienes que nombrar el objeto que quieres soltar!" + "\n"; 
            
        } else if (objeto == null) {
        	
            mensaje = "\n\t" + "¡Todavia no lo tienes!" + "\n";
            
        } else if (nombre_objeto.equals("mochila")) {
        	
    		transferir_objetos(objeto, Actor.jugador.getObjetos(), Actor.jugador.getHabitacion().getObjetos());
    		
    		Actor.jugador.setCantidad(20);
    		
        	mensaje = "\n\t" + "¡Has soltado " + nombre_objeto + "!" 
        			+ "\n\t" + "Ahora tienes - 30 de espacio" + "\n";
        
    	} else {
    		
    		transferir_objetos(objeto, Actor.jugador.getObjetos(), Actor.jugador.getHabitacion().getObjetos());
            mensaje = "\n\t" + "¡Has soltado " + nombre_objeto + "!"
            		+ "\n\t" + "- " + objeto.getCantidad() + " de espacio" 
            		+ "\n";       	
            
        }
        
        return mensaje;
        
    }
    
    public String construir_objeto(String una_mesa) {
    	
    	String mensaje = "";
    	
        Objeto objeto = Actor.jugador.getHabitacion().getObjetos().este_objeto(una_mesa);
    	
    	if (una_mesa.equals("")) {
    		
    		mensaje = "\n\t" + "¡Tienes que nombrar el objeto que quieres utilizar!" + "\n";
    		
    	} else if (una_mesa.equals("escalera")) {
    		
    		if (Actor.jugador.getHabitacion() == mapa.get(7)) {
    		
    			int opcion = 9;
    			
    			while (opcion != 0) {

					try {

						mostrar_string("\n\t" + "Descripcion extensa arriba escalera de las ruinas");

						mostrar_string(

								  "\n\t" + "¿Qué quieres hacer?"
								+ "\n"
								+ "\n\t" + "(0) Bajar las escaleras"
								+ "\n\t" + "(1) "

						);

						System.out.print("\n\t" + ">> ");
						opcion = Integer.parseInt(scan.nextLine());
				
					} catch (Exception e) {

						mostrar_string("\n\t" + "¡Error nivel 2!");

					}

				}
    			
    			// mensaje = "\n\t" + "Recoger " + "\n";
    		
    		}
    		
    		if (Actor.jugador.getHabitacion() == mapa.get(8)) {
        		
    			mensaje = "\n\t" + "Colocas la escalera en la granja" + "\n";
    		
    		}
    		
    		if (
					Actor.jugador.getHabitacion() == mapa.get(0)
				 || Actor.jugador.getHabitacion() == mapa.get(1)
				 || Actor.jugador.getHabitacion() == mapa.get(2)
				 || Actor.jugador.getHabitacion() == mapa.get(3)
				 || Actor.jugador.getHabitacion() == mapa.get(4)
				 || Actor.jugador.getHabitacion() == mapa.get(5)
				 || Actor.jugador.getHabitacion() == mapa.get(6)
				 || Actor.jugador.getHabitacion() == mapa.get(9)
					) {
		
					mostrar_string("\n\t" + "Colocas la ESCALERA PERO NO PASA NADA O PASA ALGO");
					
				}
    		
    	} else if (!una_mesa.equals("mesa")) {
        	
            mensaje = "\n\t" + "No puedes utilizar " + una_mesa + "\n";
            
        } else if (objeto == null) {
        	
        	mensaje = "\n\t" + "¡No hay " + una_mesa + " aquí!" + "\n";          
            
        } else {

			String producto = "vacio";

///////////////////////////////////////////////////////////

			String madera = "madera";

			int previa_cantidad_madera = 0;
			int nueva_cantidad_madera = 0;

			String tela = "tela";

			int previa_cantidad_tela = 0;
			int nueva_cantidad_tela = 0;

			String cuerda = "cuerda";

			int previa_cantidad_cuerda = 0;
			int nueva_cantidad_cuerda = 0;

///////////////////////////////////////////////////////////

			while (producto != "") {

				String problema = "\n\t" + "¡Error!";

				try {

					mostrar_string(

							"\n\t" + "- - - - - - - - - - - - -" 
							+ "\n\t" + "Construcciones disponibles" 
							+ "\n" 
							+ "\n\t" + "antorcha"
							+ "\n\t" + "escalera" 
							+ "\n\t" + "bla" // lanza? madera + piedra
							+ "\n\t" + "bla"

					);

					System.out.print("\n\t" + "Construir ");
					producto = scan.nextLine();

					switch (producto) {

					case "antorcha":

						if (Actor.jugador.getObjetos().este_objeto(madera) == null) {

							mostrar_string(

									"\n\t" + "Para construir una antorcha se requiere:" 
									+ "\n\t" + "madera 	x " + Aesthetic.ANSI_LIGHT_RED + 1 + Aesthetic.ANSI_RESET

							);

						} else if (Actor.jugador.getObjetos().este_objeto(madera).getCantidad() >= 1) {

							mostrar_string(

									"\n\t" + "Para construir una antorcha se requiere:" 
									+ "\n\t" + "madera 	x " + Aesthetic.ANSI_GREEN + 1 + Aesthetic.ANSI_RESET

							);

						}

						if (Actor.jugador.getObjetos().este_objeto(tela) == null) {

							mostrar_string(

									"\t" + "tela 	x " + Aesthetic.ANSI_LIGHT_RED + 1 + Aesthetic.ANSI_RESET + "\n"

							);

						} else if (Actor.jugador.getObjetos().este_objeto(tela).getCantidad() >= 1) {

							mostrar_string(

									"\t" + "tela 	x " + Aesthetic.ANSI_GREEN + 1 + Aesthetic.ANSI_RESET + "\n"

							);

						}

						problema = "\t" + "No tienes madera suficiente";

						if (Actor.jugador.getObjetos().este_objeto(madera).getCantidad() >= 1) { // no funciona si quieres crear otra

							problema = "\t" + "No tienes tela suficiente";

							if (Actor.jugador.getObjetos().este_objeto(tela).getCantidad() >= 1) {

								previa_cantidad_madera += Actor.jugador.getObjetos().este_objeto(madera).getCantidad();
								nueva_cantidad_madera = previa_cantidad_madera - 1;
								Actor.jugador.getObjetos().este_objeto(madera).setCantidad(nueva_cantidad_madera);

								previa_cantidad_tela += Actor.jugador.getObjetos().este_objeto(tela).getCantidad();
								nueva_cantidad_tela = previa_cantidad_tela - 1;
								Actor.jugador.getObjetos().este_objeto(tela).setCantidad(nueva_cantidad_tela);

								String antorcha = "antorcha";
								int cantidad_antorcha = 0;
								cantidad_antorcha = 1;

								mover_actor_hacia(Actor.jugador, mapa.get(10));

								Objeto objeto_antorcha = Actor.jugador.getHabitacion().getObjetos().este_objeto(antorcha);

								transferir_objetos(objeto_antorcha, Actor.jugador.getHabitacion().getObjetos(), Actor.jugador.getObjetos());

								Actor.jugador.getObjetos().este_objeto(antorcha).setCantidad(cantidad_antorcha);

								mover_actor_hacia(Actor.jugador, mapa.get(4));

								mostrar_string("\t" + "¡Has construido una antorcha! se ha guardado en el inventario");

							}

						}

						break;

					case "escalera":

						if (Actor.jugador.getObjetos().este_objeto(madera) == null) {

							mostrar_string(

									"\n\t" + "Para construir una escalera se requiere:" 
									+ "\n\t" + "madera 	x " + Aesthetic.ANSI_LIGHT_RED + 6 + Aesthetic.ANSI_RESET

							);

						} else if (Actor.jugador.getObjetos().este_objeto(madera).getCantidad() >= 6) {

							mostrar_string(

									  "\n\t" + "Para construir una escalera se requiere:" 
									+ "\n\t" + "madera 	x " + Aesthetic.ANSI_GREEN + 6 + Aesthetic.ANSI_RESET

							);

						}

						if (Actor.jugador.getObjetos().este_objeto(cuerda) == null) {

							mostrar_string(

									"\t" + "cuerda 	x " + Aesthetic.ANSI_LIGHT_RED + 1 + Aesthetic.ANSI_RESET + "\n"

							);

						} else if (Actor.jugador.getObjetos().este_objeto(cuerda).getCantidad() >= 1) {

							mostrar_string(

									"\t" + "cuerda 	x " + Aesthetic.ANSI_GREEN + 1 + Aesthetic.ANSI_RESET + "\n"

							);
						}

						problema = "\t" + "No tienes madera suficiente";

						if (Actor.jugador.getObjetos().este_objeto(madera).getCantidad() >= 6) {

							problema = "\t" + "No tienes cuerda suficiente";

							if (Actor.jugador.getObjetos().este_objeto(cuerda).getCantidad() >= 1) {

								previa_cantidad_madera += Actor.jugador.getObjetos().este_objeto(madera).getCantidad();
								nueva_cantidad_madera = previa_cantidad_madera - 6;
								Actor.jugador.getObjetos().este_objeto(madera).setCantidad(nueva_cantidad_madera);

								previa_cantidad_cuerda += Actor.jugador.getObjetos().este_objeto(cuerda).getCantidad();
								nueva_cantidad_cuerda = previa_cantidad_cuerda - 1;
								Actor.jugador.getObjetos().este_objeto(cuerda).setCantidad(nueva_cantidad_cuerda);

								String escalera = "escalera";
								int cantidad_escalera = 0;
								cantidad_escalera += +1;

								mover_actor_hacia(Actor.jugador, mapa.get(10));

								Objeto objeto_escalera = Actor.jugador.getHabitacion().getObjetos().este_objeto(escalera);

								transferir_objetos(objeto_escalera, Actor.jugador.getHabitacion().getObjetos(), Actor.jugador.getObjetos());

								Actor.jugador.getObjetos().este_objeto(escalera).setCantidad(cantidad_escalera);

								mover_actor_hacia(Actor.jugador, mapa.get(4));

								mostrar_string("\t" + "¡Has construido una escalera! se ha guardado en el inventario");

							}

						}

						break;

					case "manzanas":

						mostrar_string("\n\t" + "Has creado " + producto + "!");
						break;

					case "tomates":

						mostrar_string("\n\t" + "Has creado " + producto + "!");
						break;

					default:

						if (producto != "") {

							mostrar_string("\n\t" + "Producto incorrecto");

						}

						break;

					}

				} catch (Exception e) {

					mostrar_string(problema);

				}

			}

			mostrar_string("\n\t" + "- - - - - - - - - - - - -");

			mensaje = "\n\t" + "Hay una gran variedad de productos que se pueden construir, consigue mas material para construir mas cosas" + "\n";

		}

		return mensaje;

	}
    
    public String encender_objeto(String nombre_objeto) {
    	
    	String mensaje = "";
    	Objeto objeto = Actor.jugador.getObjetos().este_objeto(nombre_objeto);
        
        if (nombre_objeto.equals("")) {
        	
        	nombre_objeto = "\n\t" + "Objeto innombrado" + "\n"; 
        	
        }
        
        if (objeto == null) {
        	
            mensaje = "\n\t" + "¡No hay " + nombre_objeto + " aquí!" + "\n";
            
        } else {        	
        	
        	if (!nombre_objeto.equals("antorcha")) {
        		
        		mensaje = "\n\t" + "No puedes encender una " + nombre_objeto + "!" + "\n";
        	
        	}
        	
        	if (nombre_objeto.equals("antorcha")) {

        		if (Actor.jugador.getHabitacion() == mapa.get(2)) {

					int opcion_nivel_1 = 9;
					int opcion_nivel_2 = 9;
					int opcion_nivel_3 = 9;
					int opcion_nivel_4 = 9;
					int opcion_nivel_5 = 9;
					
					boolean nivel_5 = false;

					while (opcion_nivel_1 != 0) {

						try {

							mostrar_string("\n\t" + "Descripcion extensa cueva nivel 0");

							mostrar_string(

									  "\n\t" + "¿Qué quieres hacer?"
									+ "\n"
									+ "\n\t" + "(0) Salir de la cueva"
									+ "\n\t" + "(1) Adentrarse en la cueva"

							);

							System.out.print("\n\t" + ">> ");
							opcion_nivel_1 = Integer.parseInt(scan.nextLine());

							if (opcion_nivel_1 == 1) {

								while (opcion_nivel_1 != 0) {

									try {

										mostrar_string("\n\t" + "descripcion nivel 1");

										mostrar_string(

												  "\n\t" + "¿Qué quieres hacer?"
												+ "\n"
												+ "\n\t" + "(0) Salir de la cueva"
												+ "\n\t" + "(1) Adentrarse más en la cueva"

										);

										System.out.print("\n\t" + ">> ");
										opcion_nivel_2 = Integer.parseInt(scan.nextLine());

										if (opcion_nivel_2 == 1) {

											while (opcion_nivel_2 != 0) {

												try {

													mostrar_string("\n\t" + "descripcion nivel 2: cuidado paso estrecho y peligroso - 5 hp?");

													mostrar_string(

															  "\n\t" + "¿Qué quieres hacer?"
															+ "\n"
															+ "\n\t" + "(0) Salir de la cueva por donde has venido"
															+ "\n\t" + "(1) Escabullirse por el paso estrecho"

													);

													System.out.print("\n\t" + ">> ");
													opcion_nivel_3 = Integer.parseInt(scan.nextLine());

													if (opcion_nivel_3 == 1) {

														while (opcion_nivel_3 != 0) {

															try {

																mostrar_string("\n\t" + "descripcion nivel 3: peligro!! grieta por donde pasar - 25 hp?");

																mostrar_string(

																		  "\n\t" + "¿Qué quieres hacer?"
																		+ "\n"
																		+ "\n\t" + "(0) Salir por dónde has venido"
																		+ "\n\t" + "(1) Intentar pasar por la escueta grieta"

																);

																System.out.print("\n\t" + ">> ");
																opcion_nivel_4 = Integer.parseInt(scan.nextLine());

																if (opcion_nivel_4 == 1) {

																	while (opcion_nivel_4 != 0) {

																		try {

																			mostrar_string("\n\t" + "descripcion nivel 4: buen teseoro ataque!?");

																			mostrar_string(

																					  "\n\t" + "¿Qué quieres hacer?"
																					+ "\n" 
																					+ "\n\t" + "(0) Dar media vuelta"
																					+ "\n\t" + "(1) Seguir adentrándose en la cueva"

																			);

																			System.out.print("\n\t" + ">> ");
																			opcion_nivel_5 = Integer.parseInt(scan.nextLine());

																			if (opcion_nivel_5 == 1) {

																				while (opcion_nivel_5 != 0) {

																					try {

																						nivel_5 = true;
																						
																						mostrar_string("\n\t" + "descripcion nivel 5");

																						opcion_nivel_5 = 0;
																						opcion_nivel_4 = 0;
																						opcion_nivel_3 = 0;
																						opcion_nivel_2 = 0;
																						opcion_nivel_1 = 0;

																						mostrar_string_lento("\n\t" + "¡Has muerto!" + "\n");

																						Actor.jugador.setVida(0);

																					} catch (Exception e) {

																						mostrar_string("\n\t" + "¡Error nivel 5!");

																					}

																				}

																			}

																		} catch (Exception e) {

																			mostrar_string("\n\t" + "¡Error nivel 4!");

																		}

																	}

																}

															} catch (Exception e) {

																mostrar_string("\n\t" + "¡Error nivel 3!");

															}

														}

													}

												} catch (Exception e) {

													mostrar_string("\n\t" + "¡Error nivel 2!");

												}

											}

										}

									} catch (Exception e) {

										mostrar_string("\n\t" + "¡Error nivel 1!");

									}

								}

							}

						} catch (Exception e) {

							mostrar_string("\n\t" + "¡Error nivel 0!");

						}

					}

					if (nivel_5 == false) {
						
						mostrar_string("\n\t" + "Decides salir de la cueva con la incognita de no saber si hay mas tesoros");
						
					}
					
				}

        		if (Actor.jugador.getHabitacion() == mapa.get(5)) {

        			mostrar_string("\n\t" + "Descripcion extensa mina" + "\n");

        		}

				if (
					Actor.jugador.getHabitacion() == mapa.get(0) 
				 || Actor.jugador.getHabitacion() == mapa.get(1)
				 || Actor.jugador.getHabitacion() == mapa.get(3)
				 || Actor.jugador.getHabitacion() == mapa.get(4)
				 || Actor.jugador.getHabitacion() == mapa.get(6)
				 || Actor.jugador.getHabitacion() == mapa.get(7)
				 || Actor.jugador.getHabitacion() == mapa.get(8)
				 || Actor.jugador.getHabitacion() == mapa.get(9)
					) {
		
					mostrar_string("\n\t" + "¡Has encendido la antorcha! Si cambias de habitación se apagará");
					
				}
	
        	}
	
        }
        
        return mensaje;
    
    }
    
    
    void mover_actor_hacia(Actor jugador, Habitacion una_habitacion) {
    	
        jugador.setHabitacion(una_habitacion);
        
    }

    
    int mover_hacia(Actor un_actor, Direccion direccion) {
    	
        Habitacion habitacion = un_actor.getHabitacion();
        int exit;

        switch (direccion) {
        
            case NORTE:
            	
                exit = habitacion.getN();
                break;
                
            case SUR:
            	
                exit = habitacion.getS();
                break;
                
            case ESTE:
            	
                exit = habitacion.getE();
                break;
                
            case OESTE:
            	
                exit = habitacion.getO();
                break;
                
            default:
            	
                exit = Direccion.SINSALIDA; 
                break;
                
        }
        
        if (exit != Direccion.SINSALIDA) {
        	
        	mover_actor_hacia(un_actor, mapa.get(exit));
        	
        }
        
        return exit;
        
    }

    public int mover_jugador_hacia(Direccion direccion) {
    	
        return mover_hacia(Actor.jugador, direccion);
        
    }

    private void ir_norte() {
    	
    	mostrar_descripcion_habitacion(mover_jugador_hacia(Direccion.NORTE));
    	
    }

    private void ir_sur() {
    	
    	mostrar_descripcion_habitacion(mover_jugador_hacia(Direccion.SUR));
    	
    }

    private void ir_oeste() {
    	
    	mostrar_descripcion_habitacion(mover_jugador_hacia(Direccion.OESTE));
    	
    }

    private void ir_este() {
    	
    	mostrar_descripcion_habitacion(mover_jugador_hacia(Direccion.ESTE));
    	
    }

    private void buscar() {
    	
    	if (Actor.jugador.getHabitacion().equals(Actor.bot.getHabitacion())) {
    		
    		mostrar_string("\n\t" + "Hay un bot aqui");
    		
    	} 
    	
    	if (Actor.jugador.getHabitacion().equals(Actor.mercader.getHabitacion())) {
    		
    		mostrar_string("\n\t" + "Hay un mercader aqui");
    		
    	}    	
    	
    	mostrar_string("\n\t" + Actor.getJugador().getHabitacion().describe_objetos());
    	
    }

    private void mostrar_string(String mensaje) {
    	
        System.out.println(mensaje);
        
    }
    
    private void mostrar_string_lento(String mensaje) {
    	
    	for (int i = 0; i < mensaje.length(); i++) {
    	
    		sleep(40);
    		System.out.print(mensaje.charAt(i));
    		sleep(40);
        
    	}
    	
    }
    
    private void mostrar_string_rojo(String mensaje) {
    	
    	sleep(40);
        System.err.print(mensaje);
        sleep(40);
        
    }

    private void mostrar_descripcion_habitacion(int numero_habitacion) {

        String mensaje;
        
        if (numero_habitacion == Direccion.SINSALIDA) {
        	
        	mensaje = "\n\t" + "Sin salida!";
        	
        } else {
        	
            Habitacion habitacion = Actor.getJugador().getHabitacion();
            mensaje = "\n\t" + "Estás en " + habitacion.describe();
            
        }
        
        mostrar_string(mensaje);
        
    }
    
    private void mostrar_inventario() {

    	mostrar_string(
      	
    			"\n" + Actor.getJugador().getObjetos()

      			+ " / " + Actor.getJugador().getCantidad()

      			);

    }
    
    private void mostrar_vida() {
    	
    	mostrar_string("\n\t" + "Tienes " + Actor.getJugador().getVida() + " ❤️");
    	
    }
    
    private void mostrar_oro() {

    	if (oro <= 0) {

    		mostrar_string("\n\t" + "No tienes monedas de oro");

    	} else if (oro == 1) {

    		mostrar_string("\n\t" + "Tienes " + oro + "moneda de oro");

    	} else {

        	mostrar_string("\n\t" + "Tienes " + oro + " monedas de oro");

    	}

    }
    
    private void hablar() {
    	
    	if (Actor.getJugador().getHabitacion() == Actor.bot.getHabitacion()) {

			mostrar_string("\n\t" + "___________________");
    		hablar_bot();
			mostrar_string("\t" + "___________________");

    	
    	} else if (Actor.getJugador().getHabitacion() == Actor.mercader.getHabitacion()) {
    		
			mostrar_string("\n\t" + "___________________");
    		hablar_mercader();
			mostrar_string("\t" + "___________________");
    		
    	} else {
    		
    		mostrar_string("\n\t" + "¡No hay nadie en esta habitación con quien hablar!");
    		
    	}    	
    	
    }
    
    private void hablar_bot() {
    	
    	int opcion = 99;
    	
    	mostrar_string("\n\t" + Actor.bot.getNombre() + ", " + Actor.bot.getDescripcion());
		
		while (opcion != 0) {
		
			try {
				
				mostrar_string( // salida_rio = un número para cambiar de habitacion
						
						  "\n\t" + "¿Que quieres hacer?"
						+ "\n"
						+ "\n\t" + "(0) dejar de hablar"
						+ "\n\t" + "(1) primera opcion"
						+ "\n\t" + "(2) segunda opcion"
						+ "\n\t" + "(3) tercera opcion"
						
						);
				
				System.out.print("\n\t" + ">> ");
				opcion = Integer.parseInt(scan.nextLine());
				
				
	    		switch (opcion) {
	    		
	    			case 1:
	    			
	    				mostrar_string("\n\t" + "opcion 1");
	    				break;
	    			
	    			case 2:
	    			
	    				mostrar_string("\n\t" + "opcion 2");
	    				break;
	    			
	    			case 3:
	    			
	    				mostrar_string("\n\t" + "opcion 3");
	    				break;
	    			
	    			default:
	    			
	    				if (opcion != 0) {
	    					
	    					mostrar_string("\n\t" + "Valor incorrecto");
	    					
	    				} else {
	    					
	    					mostrar_string("\n\t" + "Vuelve cuando quieras!");
	    					
	    				}
	    				
	    				break;

	    		}
	    		
			} catch (Exception e) {
				
				System.out.println("\n\t" + "Error!");
			
			}
			
		}
    	
    }
    
    private void hablar_mercader() {
    	
    	int opcion = 99;
    	
    	mostrar_string("\n\t" + Actor.mercader.getNombre() + ", " + Actor.mercader.getDescripcion());
		
		while (opcion != 0) {
		
			try {
				
				mostrar_string(
						
						  "\n\t" + "¿Que quieres hacer?"
						+ "\n"
						+ "\n\t" + "(0) dejar de hablar"
						+ "\n\t" + "(1) preguntar por algo"
						+ "\n\t" + "(2) comprar objetos"
						+ "\n\t" + "(3) vender objetos"
						
						);
				
				System.out.print("\n\t" + ">> ");
				opcion = Integer.parseInt(scan.nextLine());
				
				
	    		switch (opcion) {
	    		
	    			case 1:
	    			
	    				mostrar_string("\n\t" + "preguntar por algo");
	    				break;
	    			
	    			case 2:
	    			
	    				comprar_objetos_mercader();
	    				break;
	    			
	    			case 3:
	    			
	    				vender_objetos_mercader();
	    				break;
	    			
	    			default:
	    			
	    				if (opcion != 0) {
	    					
	    					mostrar_string("\n\t" + "Valor incorrecto");
	    					
	    				} else {
	    					
	    					mostrar_string("\n\t" + "Vuelve cuando quieras!");
	    					
	    				}
	    				
	    				break;

	    		}
	    		
			} catch (Exception e) {
				
				System.out.println("\n\t" + "Error!");
			
			}
			
		}
    	
    }
    
    private void comprar_objetos_mercader() {
    	
    	String producto = "vacio";
    	
    	String producto_01 = "";
    	String producto_02 = "";
    	String producto_03 = "";
    	String producto_04 = "";
    	
    	ArrayList aleatorios = new ArrayList();
        aleatorios = calcular_aleatorios(0, 5);

        for (int i = 1; i <= 4; i++) {
        	
        	int nombre_producto = (int) aleatorios.get(i);
        	
    		switch (nombre_producto) {
    			
    			case 0: producto = "puñal"; 	break;
    			case 1: producto = "patatas"; 	break;
    			case 2: producto = "escalera"; 	break;
    			case 3: producto = "antorcha"; 	break;
    			case 4: producto = "puñal"; 	break;
    			case 5: producto = "patatas"; 	break;
    		
    		}
    		
    		if (i == 1) { producto_01 = producto; }
    		if (i == 2) { producto_02 = producto; }
    		if (i == 3) { producto_03 = producto; }
    		if (i == 4) { producto_04 = producto; }
    	}
        
    	while (producto != "") {
    		
			try {
				
				Actor.jugador.setHabitacion(mapa.get(10));
				
		        Objeto objeto_01 = Actor.jugador.getHabitacion().getObjetos().este_objeto(producto_01);
		        Objeto objeto_02 = Actor.jugador.getHabitacion().getObjetos().este_objeto(producto_02);
		        Objeto objeto_03 = Actor.jugador.getHabitacion().getObjetos().este_objeto(producto_03);
		        Objeto objeto_04 = Actor.jugador.getHabitacion().getObjetos().este_objeto(producto_04);
		        
		        Actor.jugador.setHabitacion(mapa.get(9));
		        
		        mostrar_string(				
		    			
						  "\n\t" + "-- -- -- -- -- -- -- -- -- -- -- -- --"
						+ "\n\t" + "Coste |  Productos disponibles"
						+ "\n\t" + "      |"
						
		        		);
		        
		        if (oro < objeto_01.getPrecio()) {
		        	
		        	mostrar_string("\t" + Aesthetic.ANSI_LIGHT_RED + "  " + objeto_01.getPrecio() + Aesthetic.ANSI_RESET + "  |  " + objeto_01.getCantidad() + "  x " + producto_01);
		        	
		        } else {
		        	
		        	mostrar_string("\t" + Aesthetic.ANSI_GREEN + "  " + objeto_01.getPrecio() + Aesthetic.ANSI_RESET + "  |  " + objeto_01.getCantidad() + "  x " + producto_01);
		        	
		        }
		        
		        if (oro < objeto_02.getPrecio()) {
		        	
		        	mostrar_string("\t" + Aesthetic.ANSI_LIGHT_RED + "  " + objeto_02.getPrecio() + Aesthetic.ANSI_RESET + "  |  " + objeto_02.getCantidad() + "  x " + producto_02);
		        	
		        } else {
		        	
		        	mostrar_string("\t" + Aesthetic.ANSI_GREEN + "  " + objeto_02.getPrecio() + Aesthetic.ANSI_RESET + "  |  " + objeto_02.getCantidad() + "  x " + producto_02);
		        	
		        }
		        
		        if (oro < objeto_03.getPrecio()) {
		        	
		        	mostrar_string("\t" + Aesthetic.ANSI_LIGHT_RED + "  " + objeto_03.getPrecio() + Aesthetic.ANSI_RESET + "  |  " + objeto_03.getCantidad() + "  x " + producto_03);
		        	
		        } else {
		        	
		        	mostrar_string("\t" + Aesthetic.ANSI_GREEN + "  " + objeto_03.getPrecio() + Aesthetic.ANSI_RESET + "  |  " + objeto_03.getCantidad() + "  x " + producto_03);
		        	
		        }
		        
		        if (oro < objeto_04.getPrecio()) {
		        	
		        	mostrar_string("\t" + Aesthetic.ANSI_LIGHT_RED + "  " + objeto_04.getPrecio() + Aesthetic.ANSI_RESET + "  |  " + objeto_04.getCantidad() + "  x " + producto_04);
		        	
		        } else {
		        	
		        	mostrar_string("\t" + Aesthetic.ANSI_GREEN + "  " + objeto_04.getPrecio() + Aesthetic.ANSI_RESET + "  |  " + objeto_04.getCantidad() + "  x " + producto_04);
		        	
		        }
		        
		    	mostrar_string("\t" + "-- -- -- -- -- -- -- -- -- -- -- -- --");
				
				System.out.print("\n\t" + "Comprar ");
				producto = scan.nextLine();
				
				switch (producto) {
	    		
	    			case "puñal":
	    				
	    				Actor.jugador.setHabitacion(mapa.get(10));
	    				
	    				String puñal = "puñal";
	    				Objeto objeto_puñal = Actor.jugador.getHabitacion().getObjetos().este_objeto(puñal);
	    				
	    				if (oro < objeto_puñal.getPrecio()) {
	    					
	    					mostrar_string("\n\t" + "¡No tienes oro suficiente!");
	    					
	    				} else {
		    		        
		    		        // transferir_objetos(objeto_puñal, Actor.jugador.getHabitacion().getObjetos(), Actor.jugador.getObjetos());

	    					contador_oro(-objeto_puñal.getPrecio());

		    				mostrar_string(
		    						
		    						  "\n\t" + "¡Has comprado un puñal! se ha guardado en el inventario"
		    						+ "\n"
		    						+ "\n\t" + "- " + Aesthetic.ANSI_LIGHT_RED + objeto_puñal.getPrecio() + Aesthetic.ANSI_RESET + " monedas de oro"
		    						
		    						);
	    					
	    				}
	    				
	    				Actor.jugador.setHabitacion(mapa.get(9));
	    				
	    				break;
	    			
	    			case "patatas":
	    			
	    				String patatas = "patatas";
	    				Objeto objeto_patatas = Actor.jugador.getHabitacion().getObjetos().este_objeto(patatas);
	    				
	    				if (oro < 9) {
	    					
	    					mostrar_string("\n\t" + "¡No tienes oro suficiente!");
	    					
	    				} else {
	    					
		    				mover_actor_hacia(Actor.jugador, mapa.get(10));
		    		        
		    		        transferir_objetos(objeto_patatas, Actor.jugador.getHabitacion().getObjetos(), Actor.jugador.getObjetos());
		    	    		mover_actor_hacia(Actor.jugador, mapa.get(9));
		    	    		
		    	    		
		    	    		contador_oro(-objeto_patatas.getPrecio());
		    	    		
		    				mostrar_string(
		    						
		    						  "\n\t" + "¡Has comprado patatas! se han guardado en el inventario"
		    						+ "\n"
		    						+ "\n\t" + "- " + objeto_patatas.getPrecio()
		    						
		    						);
	    					
	    				}
	    				
	    				break;
	    			
	    			default:
	    			
	    				if (producto != "") {
	    					
	    					mostrar_string("\n\t" + "Producto incorrecto");
	    					
	    				}
	    				
	    				break;

				}

			} catch (Exception e) {

				System.out.println("\n\t" + "Error al comprar!");

			}

		}

    }
    
    private void vender_objetos_mercader() {

    	String objeto = "vacio";

    	while (objeto != "") {

			try {

		    	mostrar_inventario();

				System.out.print("\n\t" + "Vender ");
				objeto = scan.nextLine();
				
				switch (objeto) {
	    		
	    			case "madera":
	    			
	    				mostrar_string("\n\t" + "Has vendido " + objeto + "!");
	    				break;
	    			
	    			case "cuerda":
	    			
	    				mostrar_string("\n\t" + "Has vendido " + objeto + "!");
	    				break;
	    			
	    			case "a":
	    			
	    				mostrar_string("\n\t" + "Has vendido " + objeto + "!");
	    				break;
	    				
	    			case "b":
		    			
	    				mostrar_string("\n\t" + "Has vendido " + objeto + "!");
	    				break;
	    			
	    			default:
	    			
	    				if (objeto != "") {
	    					
	    					mostrar_string("\n\t" + "Objeto incorrecto");
	    					
	    				}
	    				
	    				break;
    		
				}
    	
			} catch (Exception e) {
				
				System.out.println("\n\t" + "Error!");
			
			}
			
		}
		
    	mostrar_string("\n\t" + "- - - - - - - - - - - - -");
    	
    }
    
    
    
    private void ayuda() {

    	mostrar_string(

	    		  "\n\t" 	+ "Lista comandos"
	    		+ "\n\t"
	    		+ "\n\t" 	+ "\"ayuda\", \"?\": 			mostrar la lista de comandos"
	    		+ "\n\t" 	+ "\"vida\": 			mostrar la lista de comandos"
	    		+ "\n\t"
	    		+ "\n\t" 	+ "\"buscar\": 			mostrar las posibles interaciones de la zona"
	    		+ "\n\t" 	+ "\"inventario\", \"i\":		mostrar el inventario"
	    		+ "\n\t" 	+ "\"recoger\"	+ sustantivo: 	recoger un objeto y ponerlo en el inventario"
	    		+ "\n\t" 	+ "\"soltar\" 	+ sustantivo: 	soltar un objeto y quitarlo del inventario"
	    		+ "\n\t" 	+ "\"construir\" 	+ sustantivo: 	seleccionar objeto deseado a cambio de otros objetos"
	    		+ "\n\t"
	    		+ "\n\t" 	+ "\"norte\": 			ir en dirección Norte"
	    		+ "\n\t" 	+ "\"sur\": 				ir en dirección Sur"
	    		+ "\n\t" 	+ "\"oeste\": 			ir en dirección Oeste"
	    		+ "\n\t" 	+ "\"este\": 			ir en dirección Este"

    			);
    	
    }
      
    private void imprimir_mapa() {

    	/*mostrar_string(
  			  "\n\t" 	+ "           ╔══════════╗"
      		+ "\n\t" 	+ "           ║          ║"
      		+ "\n\t" 	+ "           ║  bosque  ║"
      		+ "\n\t" 	+ "           ║          ║"
      		+ "\n\t" 	+ "           ║          ║"
      		+ "\n\t" 	+ "           ║          ║"
      		+ "\n\t"	+ "           ╚══════════╝");*/
    	
    	mostrar_string(""
        		+ "\n\t"	+ "           ┌──────────┬──────────┬──────────┐"
        		+ "\n\t" 	+ "           │          │          │          │"
        		+ "\n\t" 	+ "     N     │  cabaña  │   pozo   │  cueva   │"
        		+ "\n\t" 	+ "   O + E   │                                │"
        		+ "\n\t"	+ "     S     │          │          │          │"
        		+ "\n\t" 	+ "           │          │          │          │"
        		+ "\n\t" 	+ "┌──────────╔════  ════╗──────────┼──────────┤"
        		+ "\n\t" 	+ "│          ║          ║          │          │"
        		+ "\n\t" 	+ "│   rio    ║  bosque  ║   mina   │  montaña │"
        		+ "\n\t" 	+ "│                                │          │"
        		+ "\n\t" 	+ "│          ║          ║          │          │"
        		+ "\n\t" 	+ "│          ║          ║          │          │"
        		+ "\n\t" 	+ "└──────────╚════  ════╝──────────┼────  ────┤"
        		+ "\n\t"	+ "           │          │          │          │"
        		+ "\n\t" 	+ "           │  ruinas  │  granja  │  mercado │"
        		+ "\n\t"	+ "           │                                │"
        		+ "\n\t" 	+ "           │          │          │          │"
        		+ "\n\t" 	+ "           │          │          │          │"
        		+ "\n\t" 	+ "           └──────────┴──────────┴──────────┘");
    	
    	mostrar_string(""
        		+ "\n\t"	+ "           ╔══════════╦══════════╦══════════╗"
        		+ "\n\t" 	+ "           ║          ║          ║          ║"
        		+ "\n\t" 	+ "     N     ║  cabaña  ║   pozo   ║   cueva  ║"
        		+ "\n\t" 	+ "   O + E   ║                                ║"
        		+ "\n\t"	+ "     S     ║          ║          ║          ║"
        		+ "\n\t" 	+ "           ║          ║          ║          ║"
        		+ "\n\t" 	+ "╔══════════╬════  ════╬══════════╬══════════╣"
        		+ "\n\t" 	+ "║          ║          ║          ║          ║"
        		+ "\n\t" 	+ "║   rio    ║  bosque  ║   mina   ║  montaña ║"
        		+ "\n\t" 	+ "║                                ║          ║"
        		+ "\n\t" 	+ "║          ║          ║          ║          ║"
        		+ "\n\t" 	+ "║          ║          ║          ║          ║"
        		+ "\n\t" 	+ "╚══════════╬════  ════╬══════════╬════  ════╣"
        		+ "\n\t"	+ "           ║          ║          ║          ║"
        		+ "\n\t" 	+ "           ║  ruinas  ║  granja  ║  mercado ║"
        		+ "\n\t"	+ "           ║                                ║"
        		+ "\n\t" 	+ "           ║          ║          ║          ║"
        		+ "\n\t" 	+ "           ║          ║          ║          ║"
        		+ "\n\t" 	+ "           ╚══════════╩══════════╩══════════╝");
    	}
   
    public String processador_verbo(List<String> lista_palabra) {
    	
        String verbo;
        String mensaje = "";
        
        verbo = lista_palabra.get(0);
        
        if (!comandos.contains(verbo)) {
        	
            mensaje = "\n\t" + "=== " + verbo + " no es un verbo conocido ===" + "\n";
            
        } else {
        	
            switch (verbo) {
            
	            case "help":
	            case "ayuda":
	            case "?":
	            	
	                ayuda();
	                break;
	                
	            case "yo":
	            	
	            	mostrar_jugador();
	            	//mostrar_string("\n\t" + "Tu vida");
	            	mostrar_vida();
	            	//mostrar_string("\n\t" + "Tu inventario");
	            	mostrar_inventario();           	
	            	break;
	                
	            case "vida":
	            	
	            	mostrar_vida();
	            	break;
	                
	            case "mapa":
	            	
	                imprimir_mapa();
	                break;
	                
                case "norte":
                	
                    ir_norte();
                    break;
                    
                case "sur":
                	
                    ir_sur();
                    break;
                    
                case "oeste":
                	
                    ir_oeste();
                    break;
                    
                case "este":
                	
                    ir_este();
                    break;
                    
                case "buscar":
                	
                    buscar();
                    break;
                    
                case "oro":
                	
                	mostrar_oro();
                	break;
                    
                case "hablar":
                	
                	hablar();
                	break;
                    
                case "inventario":
                case "i":
                	
                	mostrar_inventario();
                    break;
                    
                case "limpiar":
                case "cls":
                case "clear":
                    
                	limpiar_consola();
                	break;
                	
                default:
                	
                    mensaje = "\n\t\"" + verbo + "\" (todavía no ha sido implementado)" + "\n";
                    break;
                    
            }
            
        }
        
        return mensaje;
    }

    public String processador_verbo_sustantivo(List<String> lista_palabra) {

        String verbo;
        String sustantivo;
        String mensaje = "";

        boolean error = false;

        verbo = lista_palabra.get(0);
        sustantivo = lista_palabra.get(1);

        if (!comandos.contains(verbo)) {

            mensaje = "\n\t" + "=== " + verbo + " no es un verbo conocido ===" + "\n";
            error = true;

        }

        if (!objectos.contains(sustantivo)) {

            mensaje += ("\n\t" + "=== " + sustantivo + " no es un sustantivo conocido ===" + "\n");
            error = true;

        }

        if (!error) {
        	
            switch (verbo) {

                case "recoger":

                    mensaje = recoger_objeto(sustantivo);
                    break;

               case "soltar":

                    mensaje = soltar_objeto(sustantivo);
                    break;

               case "usar":
               case "utilizar":

            	   mensaje = construir_objeto(sustantivo);
            	   break;

               case "encender":

            	   mensaje = encender_objeto(sustantivo);
            	   break;

                default:

                    mensaje += "\n\t\"" + sustantivo + "\" (todavía no ha sido implementado)" + "\n";
                    break;

            }

        }

        return mensaje;

    }

    public String comando_analisis(List<String> lista_palabra) {
    	
        String mensaje;
        
        if (lista_palabra.size() == 1) {
        	
            mensaje = processador_verbo(lista_palabra);
            
        } else if (lista_palabra.size() == 2) {
        	
            mensaje = processador_verbo_sustantivo(lista_palabra);
            
        } else {
        	
            mensaje = "\n\t" + "=== Sólo están permitidos comandos de dos palabras ===" + "\n";
                    
        }
        
        return mensaje;
        
    }

    public List<String> lista_palabras(String input) {
    	
        String delims = " \t,.:;!\"'";
        
        List<String> una_lista = new ArrayList<>();
        
        StringTokenizer tokenizer = new StringTokenizer(input, delims);
        
        String objeto;

        while (tokenizer.hasMoreTokens()) {
        	
            objeto = tokenizer.nextToken();
            una_lista.add(objeto);
            
        }
        
        return una_lista;
        
    }

    public void mostrar_introduccion() {
    	
        String introduccion;
        
        introduccion = 
        		
        		  "\n\t" + "Introduccion                      N"
        		+ "\n\t" + "mas introducion.                O + E"
        		+ "\n\t" + "mas introducion.                  S";
        
        // mostrar_string_lento(introduccion);
        
        mostrar_descripcion_habitacion(4);
        
        
    }
    
    public void mostrar_jugador() {
    	
    	String jugador;
        
        String nombre = Actor.jugador.getNombre().toString();
        String descripcion = Actor.jugador.getDescripcion().toString();
        int cantidad = Actor.jugador.getCantidad();
    	
        jugador = 
        
        		  "\n\t" + "Tu eres " + nombre + ", " + descripcion
        		+ "\n\t" + "Tienes una capacidad de carga de " + cantidad + "\n";
        

        
        mostrar_string(jugador);
    	
    }

    public String ejecutar_comando(String inputstr) {
    	
        List<String> lista_palabra;
        
        String mensaje = "\n\t" + "Saliendo del juego";
        
        String string_minuscula = inputstr.trim().toLowerCase();
        
        if (!string_minuscula.equals("q")) {
        	
            if (string_minuscula.equals("")) {
            	
                mensaje = "\n\t" + "=== Debes introducir un comando ===" + "\n";
                
            } else {
            	
            	lista_palabra = lista_palabras(string_minuscula);
                mensaje = comando_analisis(lista_palabra);
                
            }
            
        }
        
        return mensaje;
    }
    
	public ArrayList calcular_aleatorios(int inicio, int fin) {
		
		int numero;
		ArrayList numerosAleatorios = new ArrayList();

		while (numerosAleatorios.size() < (fin - inicio) + 1) {

			numero = generar_aleatorio(inicio, fin);
			
			if (numerosAleatorios.isEmpty()) {

				numerosAleatorios.add(numero);

			} else {

				if (!numerosAleatorios.contains(numero)) {
					
					numerosAleatorios.add(numero);
				
				}
			
			}
		
		}
		
		return numerosAleatorios;
	
	}

	public int generar_aleatorio(int inicio, int fin) {
		
		Random ran = new Random();
		return ran.nextInt((fin - inicio) + 1) + inicio;
		
	}
	
    public void sleep(int time) {
		
		try {
			
			Thread.sleep(time);
			
		} catch (InterruptedException e) {}
		
	}
    
    public void limpiar_consola() {

        for (int enter = 0; enter < 40; enter++) {
        	
        	mostrar_string("");
        	sleep(40);
    
        }
        
    	mostrar_jugador();
    	mostrar_vida();
    	mostrar_inventario();
        
    }

}
