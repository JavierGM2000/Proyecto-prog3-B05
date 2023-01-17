package componentes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Baraja {

 private List<Carta> baraja;
 private Deque<Carta> jugable;
 private List<Carta> descartes;
 
//Logger
	private static Logger logger = Logger.getLogger(Carta.class.getName());
 
 	public Baraja(List<Carta> iBaraja) {
 		//Cargamos la configuracion del Logger
 		try (FileInputStream fis = new FileInputStream("logger.properties")) {
			LogManager.getLogManager().readConfiguration(fis);
		} catch (Exception ex) {
			logger.warning(String.format("%s - Error leyendo configuración del Logger: %s", 
										this.getClass(), ex.getMessage()));
		}
 		baraja= iBaraja;
 		jugable = new LinkedList<>();
 		descartes= new LinkedList<>();
 		Barajar();
 		logger.info("Baraja de cartas creada");
 	}

	public Baraja() {
		//Cargamos la configuracion del Logger
 		try (FileInputStream fis = new FileInputStream("logger.properties")) {
			LogManager.getLogManager().readConfiguration(fis);
		} catch (Exception ex) {
			logger.warning(String.format("%s - Error leyendo configuración del Logger: %s", 
										this.getClass(), ex.getMessage()));
		}
		baraja = new ArrayList<>();
		jugable = new LinkedList<>();
		descartes = new ArrayList<>();
		Properties properties = new Properties();
		String path = "";
		try {
			properties.load(new FileInputStream("proyecto.properties"));
			path = properties.getProperty("nombre_archivo_baraja");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try (Scanner sc = new Scanner(new File(path))) {
			while (sc.hasNextLine()) {
				StringTokenizer st = new StringTokenizer(sc.nextLine(), "#");
				if (st.countTokens() == 8) {
					int id = Integer.parseInt(st.nextToken());
					TipoCarta tipo;
					switch (st.nextToken()) {
					case "OCIO": {
						tipo = TipoCarta.OCIO;
						break;
					}
					case "TRABAJO": {
						tipo = TipoCarta.TRABAJO;
						break;
					}
					default:
						tipo = TipoCarta.ESTUDIO;
					}
					//Buff bufo;
					st.nextToken();
					
					int salud = Integer.parseInt(st.nextToken());
					int dinero = Integer.parseInt(st.nextToken());
					int progreso = Integer.parseInt(st.nextToken());
					int horas = Integer.parseInt(st.nextToken());
					String descripcion = st.nextToken();
					baraja.add(new Carta(id, tipo, new Buff(), salud, dinero, progreso, horas, descripcion));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Barajar();
		logger.info("Baraja de cartas creada");
	}
 	
 	public boolean insertarCarta(int id) {
 		logger.fine("Carta " + id + "insertada en la baraja");
 		return false;
 	}
 	
 	public Carta extraerCarta() {
 		if(jugable.size()<=0) {
 			Barajar();
 		}
 		Carta extraida = jugable.pop();
 		logger.fine(String.format("Carta %d extraida", extraida.getId()));
 		return extraida;
 	}
 	
 	public void Barajar() {
 		
 		Random rand = new Random();
 		jugable.clear();
 		descartes.clear();
 		descartes = new ArrayList<>(baraja);
 		Deque<Carta> nuevBaraja = new LinkedList<>();
 		BarajarRecursivo(jugable,rand,descartes.size());
 		while(nuevBaraja.size()>0) {
 			baraja.add(nuevBaraja.pop());
 		}
 		logger.fine("Cartas barajeadas");
 	}
 	
 	public void BarajarRecursivo(Deque<Carta> barajeado,Random rand, int n){
 		if(n<=1) {
 			barajeado.push(descartes.get(0));
 			descartes.remove(0);
 		} else {
 			int catInt = rand.ints(0, --n).findFirst().getAsInt();
 			barajeado.push(descartes.get(catInt));
 			descartes.remove(catInt);
 			BarajarRecursivo(barajeado,rand,n);
 		}
 		logger.fine("Caratas barajeadas de manera recursiva");
 	}
}
