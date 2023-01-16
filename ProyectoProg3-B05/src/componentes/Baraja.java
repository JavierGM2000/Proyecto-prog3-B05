package componentes;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class Baraja {

 private List<Carta> baraja;
 private Deque<Carta> jugable;
 private Deque<Carta> descartes;
 
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
 		descartes.add(extraida);
 		return extraida;
 	}
 	
 	public void Barajar() {
 		
 		Random rand = new Random();
 		jugable.clear();
 		descartes.clear();
 		Deque<Carta> nuevBaraja = new LinkedList<>();
 		BarajarRecursivo(jugable,rand,baraja.size());
 		while(nuevBaraja.size()>0) {
 			baraja.add(nuevBaraja.pop());
 		}
 	}
 	public void BarajarRecursivo(Deque<Carta> barajeado,Random rand, int n){
 		if(n==1) {
 			barajeado.push(baraja.get(0));
 			baraja.remove(0);
 		} else {
 			int catInt = rand.ints(0, --n).findFirst().getAsInt();
 			barajeado.push(baraja.get(catInt));
 			BarajarRecursivo(barajeado,rand,n);
 		}
 	}
}
