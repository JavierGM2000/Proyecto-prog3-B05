package componentes;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class creadorDeCartas {
	
	public static void main(String[] args) {
		Carta carta1 = new Carta(00,TipoCarta.OCIO, new Buff(),10,-15,0,2,"Ya es hora de desconectar un poco\nNO?");
		Carta carta2 = new Carta(00,TipoCarta.ESTUDIO, new Buff(),-20,5,25,2,"Has decidido ponerte a \nestudiar");
		Carta carta3 = new Carta(00,TipoCarta.TRABAJO, new Buff(),-15,50,5,4,"Te toca ir a trabajar");
		Carta carta4 = new Carta(00,TipoCarta.OCIO, new Buff(),10,-15,0,2,"Ya es hora de desconectar un poco\nNO?");
		Carta carta5 = new Carta(00,TipoCarta.ESTUDIO, new Buff(),-20,5,25,2,"Has decidido ponerte a \nestudiar");
		Carta carta6 = new Carta(00,TipoCarta.TRABAJO, new Buff(),-15,50,5,4,"Te toca ir a trabajar");
		Carta carta7 = new Carta(00,TipoCarta.OCIO, new Buff(),10,-15,0,2,"Ya es hora de desconectar un poco\nNO?");
		Carta carta8 = new Carta(00,TipoCarta.ESTUDIO, new Buff(),-20,5,25,2,"Has decidido ponerte a \nestudiar");
		Carta carta9 = new Carta(00,TipoCarta.TRABAJO, new Buff(),-15,50,5,4,"Te toca ir a trabajar");
		
		List<Carta> cartas = new ArrayList<>();
		cartas.add(carta1);
		cartas.add(carta2);
		cartas.add(carta3);
		cartas.add(carta4);
		cartas.add(carta5);
		cartas.add(carta6);
		cartas.add(carta7);
		cartas.add(carta8);
		cartas.add(carta9);
		
		try (BufferedWriter buffWriter = new BufferedWriter(new FileWriter("data/baraja1.txt"))) {

			for(Carta c : cartas) {
				buffWriter.write(c.toString());
				buffWriter.newLine();
			}
	           

	        } catch (FileNotFoundException e) {
	            // Si no se encuentra el fichero al intentar abrirlo
	            System.out.println("No se pudo encontrar el fichero");
	        } catch (IOException e) {
	            // Si hay problemas al escribir en el fichero.
	            System.out.println("Hay problemas al escribir");
	        }
	}
}
