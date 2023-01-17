package componentes;

import java.io.FileInputStream;
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
 		jugable = new LinkedList<>();
 		descartes= new LinkedList<>();
 		Properties properties = new Properties();
 		String path = "";
 		logger.info("Baraja de cartas por defecto creada");
 		try {
 			properties.load(new FileInputStream("proyecto.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
 		
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
