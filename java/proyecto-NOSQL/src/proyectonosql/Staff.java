package proyectonosql;

import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import utils.Utils;

public class Staff {

	public void listado() {
		Alumnos alumnos = new Alumnos();
		separadorON("Listado de alumnos");
		Alumno[] detalleAlumnos = alumnos.listado();
		for (Alumno alumno : detalleAlumnos) {
			if (alumno != null && alumno.id != 0) {
				System.out.println("["+alumno.id+"] "+alumno.nombre+" "+alumno.apellido);
			}
		}
		separadorOFF();
	}
	
	public void alta() {
		Utils util = new Utils();
		Alumno alumno = new Alumno();
		
		String nombre = "";
		String apellido = "";
		String email = "";
		String nomAtributo = "";
		String valorAtributo = "";

		separadorON("Alta de alumno");
		while (nombre.isEmpty()) {
			nombre = util.capturaTeclado("Nombre:");
		}
		
		while (apellido.isEmpty()) {
			apellido = util.capturaTeclado("Apellido:");
		}
		
		while (email.isEmpty()) {
			email = util.capturaTeclado("Email:");
		}
		
		do {
			nomAtributo = util.capturaTeclado("Nombre atributo (vacío acaba) :");
		
			if (!nomAtributo.isEmpty()) {
				while (valorAtributo.isEmpty()) {
					valorAtributo = util.capturaTeclado("Valor atributo:");
				}
				
				// guardar en MAP
				System.out.println(nomAtributo + " " + valorAtributo);
				alumno.setAtributo(nomAtributo,valorAtributo);
				valorAtributo = "";
			}
		} while (!nomAtributo.isEmpty());
		
		// guardar alumno
		alumno.nombre = nombre;
		alumno.apellido = apellido;
		alumno.email = email;
		alumno.guardar();
		separadorOFF();
		
	}
	
	public void detalle() {
		Utils util = new Utils();
		separadorON("Detalle de alumno");
		int id = Integer.parseInt(util.capturaTeclado("Indica el ID del alumno a detallar:"));
		if (id > 0) {
			Alumno alumno = new Alumno(id);
			System.out.println(alumno);
		}
		separadorOFF();
	}
	
	public void jsonString2map() {
		
		String atributos = "{ \"ojos\": \"azules\",\"pelo\": \"rubio\"}";
		
		JSONParser parser = new JSONParser();
		JSONObject jSonObj = new JSONObject();
		
		try {
			jSonObj = (JSONObject) parser.parse(atributos);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		for (Object obj : jSonObj.keySet() ) {
			String clave = (String) obj;
			String valor = (String) jSonObj.get(clave);
			System.out.println(clave + " - " + valor);
		}
		
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
	
	public void edita() {
		Utils util = new Utils();
		String newNombre = "";
		String newApellido = "";
		String newEmail = "";
		String nombre = "";
		String apellido = "";
		String email = "";
		
		separadorON("Modificación de alumno");
		int idModificar = Integer.parseInt(util.capturaTeclado("Indica el ID del alumno a modificar:"));
		
		if (idModificar > 0) {
			Alumno alumno = new Alumno(idModificar);
			
			nombre = alumno.nombre;
			while (newNombre.isEmpty()) {
				newNombre = util.capturaTeclado("Nombre ["+nombre+"]:");
			}
			alumno.nombre = newNombre;
			
			apellido = alumno.apellido;
			while (newApellido.isEmpty()) {
				newApellido = util.capturaTeclado("Apellido ["+apellido+"]:");
			}
			alumno.apellido = newApellido;
			
			email = alumno.email;
			while (newEmail.isEmpty()) {
				newEmail = util.capturaTeclado("Email ["+email+"]:");
			}
			alumno.email = newEmail;
			
			alumno.guardar();
			
		}
		
		separadorOFF();
	}
	
	private void separadorON(String cabecera) {
		System.out.println(cabecera);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
	}
	private void separadorOFF() {
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	}
}
