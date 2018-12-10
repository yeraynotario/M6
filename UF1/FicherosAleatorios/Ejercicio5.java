package Practica4;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejercicio5 {
	public static void main (String [] args) throws IOException {
		Scanner lector = new Scanner(System.in);
		File fichero = new File ("AleatorioEmpleado9.dat");
		RandomAccessFile file = new RandomAccessFile (fichero , "rw");
		int id, dep ,posicion;
		Double salario;
		char apellido[]= new char[10], aux;

		StringBuffer buffer = null; //Buffer para almacenar apellido
		int n = apellido.length; //Número de elementos en el array
		posicion =0;
		System.out.println("Inserta el Identificador a borrar:");
		int iden = lector.nextInt();

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
					
			if (id==iden) {
				file.seek (posicion);
				
				//identi=(id*0)-1;
				//System.out.println(identi);
				//file.writeInt(identi);
				file.writeInt(id);
				
				file.seek (posicion+4);
				buffer = new StringBuffer (String.valueOf(id));
				buffer.setLength(10); // Fijo en 10 caracteres la longitud del apellido
				
				file.writeChars (buffer.toString());
				file.writeInt(dep*0);
				file.writeDouble (salario*0);
				//System.out.println("Salario nuevo: "+suma+ " Salario antigo: "+ salario);
				break;
			}
			posicion = posicion + 36;
			if (file.getFilePointer() ==file.length()) break; // Si he recorrido todo el fichero, salgo
		} 
			file.close(); // No olvidarse de cerrar el fichero

	}
}