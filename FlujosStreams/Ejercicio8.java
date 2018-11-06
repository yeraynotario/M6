package Practica2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio8 {
	public static void main (String [] args) {
		try {
			BufferedWriter fichero = new BufferedWriter (new FileWriter("newtext.txt")); // Atención: utilizamos otro constructor de FileReader. Enestá ocasión no utilizamos un objeto File sino le pasamos el nombre del archivo
			String linea;
			while ((linea = fichero.newLine()) != null) // leemos de línea en línea
			System.out.println (linea);
			fichero.close();
		}
		catch (FileNotFoundException fn) {
			System.out.println ("No se encuentra el fichero"); 
		}catch (IOException io) {
		System.out.println ("Error de E/S"); }
	}
}
