import sistemas.GestorBBDD;
import sistemas.GestorVentanas;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GestorBBDD GBBDD = new GestorBBDD();
		GestorVentanas GV = new GestorVentanas(GBBDD);
	}

}
