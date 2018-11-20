package Practica4;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejercicio3 {
	public static void main (String [] args) throws IOException {
		Scanner lector = new Scanner(System.in);
		File fichero = new File ("AleatorioEmpleado1.dat");
		RandomAccessFile file = new RandomAccessFile (fichero , "rw");
		String apellido[] = {"Fernández", "Gil", "López", "Ramos"};
		int dep[] = {10,20,10,10};
		Double salario[] = {1000.45,2400.60,3000.0,1500.56};
		StringBuffer buffer = null; //Buffer para almacenar apellido
		int n = apellido.length; //Número de elementos en el array
		int i=0;
		for (i = 0; i<n; i++) { //Recorro los arrays
			file.writeInt (i+1);
			buffer = new StringBuffer (apellido[i]);
			buffer.setLength(10); // Fijo en 10 caracteres la longitud del apellido
		
			file.writeChars (buffer.toString());
			file.writeInt(dep[i]);
			file.writeDouble (salario[i]);
		}
		
		
		int miembro = 1;
		while(miembro==1){
		System.out.println("Quieres insertar un nuevo miembro?");
		System.out.println("Si = 1");
		System.out.println("No = 2");
		miembro = lector.nextInt();
		
		if (miembro==1) {
			System.out.println(i);
			System.out.println("Inserta el Identificador:");
			int iden = lector.nextInt();
			if (iden>i) {
				//inserto
				i=iden;
				file.writeInt (i);
				System.out.println(i);
				
				System.out.println("Inserta el Apellido:");
				String ape = lector.next();
				
				buffer = new StringBuffer (ape);
				buffer.setLength(10); // Fijo en 10 caracteres la longitud del apellido
			
				file.writeChars (buffer.toString());
				
				System.out.println("Inserta el Departamento:");
				int depar = lector.nextInt();
				
				file.writeInt(depar);
				
				System.out.println("Inserta el Salario:");
				Double sal = lector.nextDouble();
				
				file.writeDouble (sal);
				
			}else {
				if(iden <= i) {
					System.out.println("Este identificador ya existe");
				}
			}
			
		}
		else {
			System.out.println("Ok!, vuelve pronto..");
		}
		file.close(); // No olvidarse de cerrar el fichero
	}
	}
}
