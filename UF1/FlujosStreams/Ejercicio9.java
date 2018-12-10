package Practica2;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ejercicio9 {
	public static void main (String [] args) {
		try {
			
			PrintWriter fichero = new PrintWriter ( new FileWriter ("newtext2.txt"));
			
			String fila [] = new String [10];
			int contador=0;
			
			for(int i=0; i<fila.length; i++) {
				contador++;
				fichero.println("Esta es la fila "+contador);
			}
			
			fichero.close();
			
		}catch (FileNotFoundException fn) {
			System.out.println ("No se encuentra el fichero"); 
		}catch (IOException io) {
			System.out.println ("Error de E/S"); 
		}
	}
	
}
