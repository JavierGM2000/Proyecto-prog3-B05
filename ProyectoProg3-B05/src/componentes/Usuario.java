package componentes;

import java.io.FileInputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import sistemas.GestorBBDD;

public class Usuario {
	
	private int id;
	private String nombre;
	private TipoUsuario tipo;
	
	//Logger
	private static Logger logger = Logger.getLogger(Carta.class.getName());
	
	/**
	 * Se crea un usuario con unos valores por defecto
	 * desde la base de datos
	 * 
	 * NO SE CREA EN NINGUN MOMENTO UN USUARIO "ADMINISTRADR"
	 * ya esta creado directamente en la base
	 * 
	 * @param nombre El nombre de usuario recibido desde la ventana
	 * @param id El id que tiene el usuario asignado en la base de datos
	 */
	public Usuario(String nombre, int id) {
		//Cargamos la configuracion del Logger
 		try (FileInputStream fis = new FileInputStream("logger.properties")) {
			LogManager.getLogManager().readConfiguration(fis);
		} catch (Exception ex) {
			logger.warning(String.format("%s - Error leyendo configuración del Logger: %s", 
										this.getClass(), ex.getMessage()));
		}
		this.nombre = nombre;
		this.id = id;
		this.tipo = TipoUsuario.JUGADOR;
		logger.info(String.format("Usuario %s creado",nombre));
	}
	
	/**
	 * get del id del usuario que se quiera conseguir
	 * 
	 * @return Devuelve el id del usuario
	 */
	public int getId() {
		logger.fine("Devuelta Id: " + id);
		return id;
	}
	
	/**
	 * get del nombre del usuario que se quiere conseguir
	 * 
	 * @return devuelve el nombre de usuario
	 */
	public String getNombre() {
		logger.fine("Devuelto nombre: " + nombre);
		return nombre;
	}
	
	/**
	 * get del tipo de usuario que se quiere conseguir
	 * 
	 * @return devuelve el tipo del usuario
	 */
	public TipoUsuario getTipo() {
		logger.fine("Devuelto tipo: " + tipo.toString());
		return tipo;
	}
	
}
