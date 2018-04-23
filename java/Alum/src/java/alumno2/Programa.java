package alumno2;

import alumno2.Utils;

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
				System.out.println("5. Detalle Alumno");
				System.out.println("6. testing");
				System.out.println("");
				System.out.println("0. Finalizar el programa");
				System.out.println("");
				System.out.print("Escoge una opción (1-5,0):");
				opcionMenu = Integer.parseInt(util.capturaTeclado("")); 
			} while (opcionMenu < 0 || opcionMenu > 6);
			
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
			case 5:
				staff.detalle();
				break;
			case 6:
				staff.jsonString2map();
				break;			
			case 0:
				salir = true;
				break;
			}
			
		} while (!salir);

	}

}

