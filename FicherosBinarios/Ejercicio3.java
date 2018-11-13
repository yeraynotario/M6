package Practica3;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

public class Ejercicio3 {
	public static void main (String [] args) throws IOException {
		
		File fichero = new File ("FicheroDatos.dat");
		FileInputStream filein= new FileInputStream (fichero);
		DataInputStream dataIS = new DataInputStream (filein);
	
		try{
			while (true) {
				String k = dataIS.readUTF();
				int j = dataIS.readInt();
				System.out.println(k+" "+j+" ");
			}
		}
		catch(EOFException eo) {
			System.out.print("Fin de Lectura.");
		}	
		dataIS.close();
	}
}
