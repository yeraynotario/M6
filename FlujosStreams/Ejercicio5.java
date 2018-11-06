package Practica2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio5 {
	public static void main (String [] args) throws IOException {
		File fichero = new File("FicheroTexto2.txt");
		FileWriter fic = new FileWriter (fichero);
		
		String cadena = " Esto es una prueba con FileWriter";
		char [] cad = cadena.toCharArray () ;
		
		fic.write (cad); // se escribe la cadena de golpe.
		fic.append ("*"); // añadimos un asterisco al final
		fic.close (); // cerramos fichero
		}
}
