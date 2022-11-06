package componentes;

import sistemas.GestorBBDD;

public class Usuario {
	
	private int id;
	private String nombre;
	private TipoUsuario tipo;
	
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
		this.nombre = nombre;
		this.id = id;
		this.tipo = TipoUsuario.JUGADOR;
	}
	
	/**
	 * get del id del usuario que se quiera conseguir
	 * 
	 * @return Devuelve el id del usuario
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * get del nombre del usuario que se quiere conseguir
	 * 
	 * @return devuelve el nombre de usuario
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * get del tipo de usuario que se quiere conseguir
	 * 
	 * @return devuelve el tipo del usuario
	 */
	public TipoUsuario getTipo() {
		return tipo;
	}
	
}
