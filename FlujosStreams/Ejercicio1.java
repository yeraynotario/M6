package Practica2;
import java.io.*;
public class Ejercicio1 {
	public static void main ( String [] args) throws IOException {
		File fichero = new File ("Ejercicio1.java"); // declaración fichero
		FileReader flu = new FileReader (fichero); // creamos flujo de entrada hacia el fichero
		int i;
		while ((i=flu.read())!=-1) //Vamos leyendo carácter a carácter
		System.out.print ((char) i); //hacemos cast a char del entero leído
		flu.close();
	}
}
