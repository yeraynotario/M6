package Practica2;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio2 {
	public static void main ( String [] args) throws IOException {
		File fichero = new File ("Ejercicio1.java"); // declaración fichero
		FileReader flu = new FileReader (fichero); // creamos flujo de entrada hacia el fichero
		char cbuf[] = new char[20]; //creamos un char de 20 que es lo que guardara
		
	
		while ((flu.read(cbuf))!=-1) //Vamos leyendo caracteres del cbuf
		System.out.println(cbuf); //pintamos el cbuf
		flu.close();
	}
}
