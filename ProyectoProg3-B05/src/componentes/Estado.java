package componentes;

public class Estado {
	
	private int dia;
	private int dinero;
	private int progreso;
	private int salud;
	
	public Estado() {
		
		this.dia = 0;
		this.dinero = 500;
		this.progreso = 0;
		this.salud = 100;
		
	}
	
//	public Estado( Tenemos que encontrar el parametro de entrada ){
//
//	}
	
	
	public void verificarDia() {
		if(dia >= 30) {
			if(getProgreso() >= 50 && getSalud() > 0);
				finDelJuego();
		}
	}

	public void finDelJuego() {
		
		// TODO
		
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

	public int getProgreso() {
		return progreso;
	}

	public void setProgreso(int progreso) {
		this.progreso = progreso;
	}

	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}

}