package proyectonosql;

import java.util.ArrayList;

import postgres.Alumnado;

public class Alumnos {

	public ArrayList<Alumno> listado() {
		Alumnado alumnosDB = new Alumnado();
		alumnosDB.conecta();
		ArrayList<Alumno> alumnos = alumnosDB.listado();
		alumnosDB.desconecta();
		return alumnos;
		
	}
	
	public ArrayList<Alumno> buscarAtributo(String campo, String valor) {
		Alumnado alumnosDB = new Alumnado();
		alumnosDB.conecta();
		ArrayList<Alumno> alumnos = alumnosDB.buscar(campo,valor);
		alumnosDB.desconecta();
		return alumnos;
	}
}
