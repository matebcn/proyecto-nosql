package proyectonosql;

import utils.Utils;

public class Programa {
	private static Staff staff = new Staff();

	public static void main(String[] args) {
		
		Utils util = new Utils();
		String teclado;
		boolean salir = false;
		int opcionMenu;
		
		do {	/* bucle principal programa */
			do {	/* bucle menu */
				System.out.println("1. Listar alumnos");
				System.out.println("2. Insertar Alumno");
				System.out.println("3. Actualizar Alumno");
				System.out.println("4. Borrar Alumno");
				System.out.println("");
				System.out.println("0. Finalizar el programa");
				System.out.println("");
				System.out.print("Escoge una opción (0-4):");
				opcionMenu = Integer.parseInt(util.capturaTeclado("")); 
			} while (opcionMenu < 0 || opcionMenu > 4);
			
			switch (opcionMenu) {
			case 1:
				staff.listado();
				break;
			case 2:
				staff.alta();
				break;
			case 3:
				staff.edita();
				break;
			case 4:
				staff.baja();
				break;
			case 0:
				salir = true;
				break;
			}
			
		} while (!salir);

	}

}
