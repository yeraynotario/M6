package Practica2;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio8 {
	public static void main (String [] args) {
		try {
			
			BufferedWriter fichero = new BufferedWriter (new FileWriter("newtext.txt")); // Atención: utilizamos otro constructor de FileReader. Enestá ocasión no utilizamos un objeto File sino le pasamos el nombre del archivo
			
			String fila [] = new String [10];
			int contador=0;
			
			for(int i=0; i<fila.length; i++) {
				contador++;
				fichero.write("Esta es la fila "+contador);
				fichero.newLine();
			}
			
			fichero.close();
			
		}catch (FileNotFoundException fn) {
			System.out.println ("No se encuentra el fichero"); 
		}catch (IOException io) {
			System.out.println ("Error de E/S"); 
		}
	}
}
