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

public class Baraja {

 private List<Carta> baraja;
 private Deque<Carta> jugable;
 private List<Carta> descartes;
 
 	public Baraja(List<Carta> iBaraja) {
 		baraja= iBaraja;
 		jugable = new LinkedList<>();
 		descartes= new LinkedList<>();
 		Barajar();
 	}
 	
 	public Baraja() {
 		jugable = new LinkedList<>();
 		descartes= new LinkedList<>();
 		Properties properties = new Properties();
 		String path = "";
 		try {
 			properties.load(new FileInputStream("proyecto.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
 		
 	}
 	
 	public boolean insertarCarta(int id) {
 		return false;
 	}
 	
 	public Carta extraerCarta() {
 		if(jugable.size()<=0) {
 			Barajar();
 		}
 		Carta extraida = jugable.pop();
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
 	}
}
