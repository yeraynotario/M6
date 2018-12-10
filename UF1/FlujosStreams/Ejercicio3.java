package Practica2;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio3 {
	public static void main ( String [] args) throws IOException {
		Scanner lector = new Scanner(System.in);
		
		System.out.println("Introdueix el directori:");
		String dir = lector.nextLine();
		
		File fichero = new File (dir); // declaración fichero
		FileReader flu = new FileReader (fichero); // creamos flujo de entrada hacia el fichero
		
		char cbuf[] = new char[20]; //creamos un char de 20 que es lo que guardara
		
		while ((flu.read(cbuf))!=-1) //Vamos leyendo caracteres del cbuf
			System.out.println(cbuf); //pintamos el cbuf
		
		flu.close();
		lector.close();
	}
}
