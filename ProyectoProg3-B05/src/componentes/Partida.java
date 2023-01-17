package componentes;

import java.io.FileInputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Partida {
	int id;
	String fecha;
	String info;
	//Logger
	private static Logger logger = Logger.getLogger(Carta.class.getName());
	
	public Partida(int iId,String iFecha,String iInfo){
		//Cargamos la configuracion del Logger
 		try (FileInputStream fis = new FileInputStream("logger.properties")) {
			LogManager.getLogManager().readConfiguration(fis);
		} catch (Exception ex) {
			logger.warning(String.format("%s - Error leyendo configuración del Logger: %s", 
										this.getClass(), ex.getMessage()));
		}
		id = iId;
		fecha= iFecha;
		info = iInfo;
		logger.info("Partida creada");
	}

	public int getId() {
		logger.fine("Devuelta Id: " + id);
		return id;
	}

	public String getFecha() {
		logger.fine("Devuelta Fecha: " + fecha);
		return fecha;
	}

	public String getInfo() {
		logger.fine("Devuelta informacion: " + info);
		return info;
	}
	
	
}
