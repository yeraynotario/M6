package Practica4ex4;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejercicio4 {
	public static void main (String [] args) throws IOException {
		Scanner lector = new Scanner(System.in);
		File fichero = new File ("AleatorioEmpleado8.dat");
		RandomAccessFile file = new RandomAccessFile (fichero , "rw");
		int id, dep ,posicion;
		Double salario;
		char apellido[]= new char[10], aux;
	
		StringBuffer buffer = null; //Buffer para almacenar apellido
		int n = apellido.length; //Número de elementos en el array
		int j =0;
		posicion =0;
		System.out.println("Inserta el Identificador a modificar:");
		int iden = lector.nextInt();

		System.out.println("Inserta el importe:");
		Double impor = lector.nextDouble();
		for ( ; ; ){
			file.seek (posicion); // Nos posicionamos en posicion
			id = file.readInt(); // Obtengo identificar de Empleado
			for ( int i =0; i<apellido.length; i++) {
				aux = file.readChar(); // Voy leyendo carácter a carácter el apellido y lo guardo
				apellido[i]=aux; // en el array apellido
			}
			String apellidos = new String (apellido);
			dep = file.readInt(); //Lectura de departamento y salario
			salario = file.readDouble();
					
					System.out.println(id);
					
					if (id==iden) {
						//posicion=iden*36;
						file.seek (posicion+28);
						System.out.println(salario);
						Double suma = salario+impor;
						
						file.writeDouble (suma);
						
						System.out.println("nuevo: "+suma+ "antigo: "+ salario);break;
					}
			
			
			posicion = posicion + 36;
			if (file.getFilePointer() ==file.length()) break; // Si he recorrido todo el fichero, salgo
		} 
			file.close(); // No olvidarse de cerrar el fichero
	}

}
	
	
