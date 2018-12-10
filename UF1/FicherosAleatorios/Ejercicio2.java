package Practica4;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejercicio2 {
	public static void main(String[] args) throws IOException {
		Scanner lector = new Scanner(System.in);
		File fichero = new File ("AleatorioEmpleado.dat");
		RandomAccessFile file = new RandomAccessFile (fichero, "r");
		int id, dep ,posicion;
		Double salario;
		char apellido[]= new char[10], aux;
		posicion =0;
		
		System.out.println("Introduce el Id a buscar:");
		int intro = lector.nextInt();
		
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
			
			if (id == intro) {
				System.out.printf("ID: %s, Apellido: %s, Departamento: %d, Salario: %.2f %n", id,
						 apellidos.trim(), dep, salario); break;
			}
			
			posicion = posicion + 36;
			if (file.getFilePointer() ==file.length()) { break;} // Si he recorrido todo el fichero, salgo		
			
			//Nos situamos al principio del fichero
			
		} // del for
		if (id != intro) {
			System.out.printf("Identificador erroneo!");
		}
		file.close();
	}
}

