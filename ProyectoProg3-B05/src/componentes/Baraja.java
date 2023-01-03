package componentes;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Baraja {
 private List<Carta> baraja;
 
 	public Baraja(List<Carta> iBaraja) {
 		baraja= iBaraja;
 	}
 	
 	public Baraja() {
 	
 	}
 	
 	public boolean insertarCarta(int id) {
 		return false;
 	}
 	
 	public Carta extraerCarta() {
 		Random ran = new Random();
 		return baraja.get(ran.nextInt(3));
 	}
 	
 	public void Barajar() {
 		Random rand = new Random();
 		Deque<Carta> nuevBaraja = new LinkedList<>();
 		BarajarRecursivo(nuevBaraja,rand,baraja.size());
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
 			baraja.remove(catInt);
 			BarajarRecursivo(barajeado,rand,n);
 		}
 	}
}
