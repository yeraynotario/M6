package Practica2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio7 {
	public static void main (String [] args) {
		try {
			BufferedReader fichero = new BufferedReader (new FileReader(args[0])); // Atención: utilizamos otro constructor de FileReader. Enestá ocasión no utilizamos un objeto File sino le pasamos el nombre del archivo
			String linea;
			while ((linea = fichero.readLine()) != null) // leemos de línea en línea
			System.out.println (linea);
			fichero.close();
		}
		catch (FileNotFoundException fn) {
			System.out.println ("No se encuentra el fichero"); 
		}catch (IOException io) {
		System.out.println ("Error de E/S"); }
	}
}
