package proyectonosql;

import postgres.Alumnado;

public class Alumno {

	public String nombre;
	public String apellido;
	public String email;
	public String atributos;
	private int id = 0;
	//private String[] aCampos = {"nombre","apellido","email","atributos"};
	
	public Alumno() {}
	public Alumno(int id) {
		this.id = id;
		cargar();
	}

	public Alumno(String nombre, String apellido, String email, String atributos) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.atributos = atributos;
		this.id = 0;
	}
	
	public Alumno(String nombre, String apellido, String email) {
		/* solo creado para pruebas */
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}
	
	public void guardar() {
		String campos = "nombre,apellido,mail";
		String valores = "'"+this.nombre+"','"+this.apellido+"','"+this.email+"'";
		String actualizar = "nombre='"+this.nombre+"',apellido='"+this.apellido+"',mail='"+this.email+"'";
		Alumnado alumnoDB = new Alumnado();
		alumnoDB.conecta();
		if (this.id != 0) {
			alumnoDB.actualizar(actualizar,this.id);
		} else {
			alumnoDB.insertar(campos,valores);
		}
		
		alumnoDB.desconecta();
	}
	
	
	
	public void cargar() {
		Alumnado alumnoDB = new Alumnado();
		alumnoDB.conecta();
		String[] sAlumno = alumnoDB.recuperar(this.id);
		
		// mejor MAP ?
		this.nombre = sAlumno[0];
		this.apellido = sAlumno[1];
		this.email = sAlumno[2];
		this.atributos = sAlumno[3];
		
		alumnoDB.desconecta();
	}
	
	public void cargar(int id) {
		this.id = id;
		cargar();
	}
	
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
