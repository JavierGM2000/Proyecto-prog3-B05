package componentes;

public class Partida {
	int id;
	String fecha;
	String info;
	
	public Partida(int iId,String iFecha,String iInfo){
		id = iId;
		fecha= iFecha;
		info = iInfo;
	}

	public int getId() {
		return id;
	}

	public String getFecha() {
		return fecha;
	}

	public String getInfo() {
		return info;
	}
	
	
}
