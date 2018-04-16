package proyectonosql;

import postgres.Alumnado;

public class Alumno {

	public String nombre;
	public String apellido;
	public String email;
	public String atributos;
	private int id = 0;
	
	public Alumno() {}
	public Alumno(int id) {
		this.id = id;
	}

	public Alumno(String nombre, String apellido, String email, String atributos) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.atributos = atributos;
		this.id = 0;
	}
	
	public Alumno(String nombre) {
		/* solo creado para pruebas */
		this.nombre = nombre;
	}
	
	public void guardar() {
		String campos = "nombre";
		String valores = "'"+this.nombre+"'";
		Alumnado alumnoDB = new Alumnado();
		alumnoDB.conecta();
		alumnoDB.insertar(campos,valores);
		alumnoDB.desconecta();
	}
	public void cargar() {}
	public void cargar(int id) {}
	
	public void borrar() {
		Alumnado alumnoDB = new Alumnado();
		alumnoDB.conecta();
		alumnoDB.borrar(this.id);
		alumnoDB.desconecta();
	}
	
	public void borrar(int id) {
		this.id = id;
		borrar();
	}
	
}
