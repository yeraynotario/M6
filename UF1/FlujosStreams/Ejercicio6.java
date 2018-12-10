package Practica2;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio6 {
	public static void main (String [] args) throws IOException {
		
		File fichero = new File("FicheroTexto3.txt");
		FileWriter fic = new FileWriter (fichero);
		
		String prov[] = {"Albacete", "Avila", "Badajoz", "Caceres", "Huelva", "Jaen","Madrid", "Segovia", "Soria", "Toledo", "Valladolid", "Zamora"};
		
		int size = prov.length;
		
        for (int i=0; i<size; i++){
           fic.write(prov[i]+" ");
        }

		fic.append ("*");
		fic.close (); // cerramos fichero
	}
}
