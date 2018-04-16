package proyectonosql;

import utils.Utils;

public class Staff {

	public void listado() {
		Alumnos alumnos = new Alumnos();
		separadorON("Listado de alumnos");
		System.out.println(alumnos.listado());
		separadorOFF();
	}
	
	public void alta() {
		Utils util = new Utils();
		separadorON("Alta de alumno");
		String nombre = "";
		while (nombre.isEmpty()) {
			nombre = util.capturaTeclado("Nombre:");
		}
		Alumno alumno = new Alumno(nombre);
		alumno.guardar();
		separadorOFF();
		
	}
	
	public void baja() {
		Utils util = new Utils();
		separadorON("Baja de alumno");
		int idBorrar = Integer.parseInt(util.capturaTeclado("Indica el ID del alumno a borrar:"));
		if (idBorrar > 0) {
			Alumno alumno = new Alumno();
			alumno.borrar(idBorrar);
		}
		separadorOFF();
		
	}
	public void edita() {}
	private void separadorON(String cabecera) {
		System.out.println(cabecera);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
	}
	private void separadorOFF() {
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	}
}
