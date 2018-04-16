package proyectonosql;

import postgres.Alumnado;

public class Alumnos {

	public String listado() {
		Alumnado alumnosDB = new Alumnado();
		alumnosDB.conecta();
		String alumnos = alumnosDB.listado();
		alumnosDB.desconecta();
		return alumnos;
		
	}
}
