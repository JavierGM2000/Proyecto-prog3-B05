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
import java.util.Scanner;
import java.util.StringTokenizer;

public class Baraja {

	private List<Carta> baraja;
	private Deque<Carta> jugable;
	private List<Carta> descartes;

	public Baraja(List<Carta> iBaraja) {
		baraja = iBaraja;
		jugable = new LinkedList<>();
		descartes = new LinkedList<>();
		Barajar();
	}

	public Baraja() {
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
	}

	public boolean insertarCarta(int id) {
		return false;
	}

	public Carta extraerCarta() {
		if (jugable.size() <= 0) {
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
		BarajarRecursivo(jugable, rand, descartes.size());
		while (nuevBaraja.size() > 0) {
			baraja.add(nuevBaraja.pop());
		}
	}

	public void BarajarRecursivo(Deque<Carta> barajeado, Random rand, int n) {
		if (n <= 1) {
			barajeado.push(descartes.get(0));
			descartes.remove(0);
		} else {
			int catInt = rand.ints(0, --n).findFirst().getAsInt();
			barajeado.push(descartes.get(catInt));
			descartes.remove(catInt);
			BarajarRecursivo(barajeado, rand, n);
		}
	}
}
