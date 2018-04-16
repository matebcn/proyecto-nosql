package utils;

import java.util.Scanner;

public class Utils {
	private String entrada = "";
	
	public String capturaTeclado(String presentacion) {
		
		/*try(Scanner sc = new Scanner(System.in)) {
			System.out.println(presentacion);
			entrada = sc.nextLine();	
		}*/
		
		Scanner sc = new Scanner(System.in);
		System.out.println(presentacion);
		entrada = sc.nextLine();
		//sc.close();
		
		return entrada;
	}
}