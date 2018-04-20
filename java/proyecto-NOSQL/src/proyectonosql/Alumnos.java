package proyectonosql;

import postgres.Alumnado;

public class Alumnos {

	public String listado_OLD() {
		Alumnado alumnosDB = new Alumnado();
		alumnosDB.conecta();
		String alumnos = alumnosDB.listado_OLD();
		alumnosDB.desconecta();
		return alumnos;
		
	}
	
	public Alumno[] listado() {
		Alumnado alumnosDB = new Alumnado();
		alumnosDB.conecta();
		Alumno[] alumnos = alumnosDB.listado();
		alumnosDB.desconecta();
		return alumnos;
		
	}
	
	public Alumno[] buscarAtributo(String campo, String valor) {
		Alumnado alumnosDB = new Alumnado();
		alumnosDB.conecta();
		Alumno[] alumnos = alumnosDB.buscar(campo,valor);
		alumnosDB.desconecta();
		return alumnos;
	}
}
