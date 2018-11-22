package Practica4;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejercicio4 {
	public static void main (String [] args) throws IOException {
		Scanner lector = new Scanner(System.in);
		File fichero = new File ("AleatorioEmpleado2.dat");
		RandomAccessFile file = new RandomAccessFile (fichero , "rw");
		
		String apellido[] = {"Fernández", "Gil", "López", "Ramos"};
		int dep[] = {10,20,10,10};
		Double salario[] = {1000.45,2400.60,3000.0,1500.56};
		
		StringBuffer buffer = null; //Buffer para almacenar apellido
		int n = apellido.length; //Número de elementos en el array
		int i =0;
		
		
		int mod = 1;
		while(mod==1){
			System.out.println("Quieres modificar un miembro?");
			System.out.println("Si = 1");
			System.out.println("No = 2");
			mod = lector.nextInt();
		
			if (mod==1) {
				System.out.println("Inserta el Identificador a modificar:");
				int iden = lector.nextInt();
	
				System.out.println("Inserta el importe:");
				Double impor = lector.nextDouble();
				for (i = 0; i<n; i++) { //Recorro los arrays
					if(iden==i) {
					file.writeInt (i+1);
					buffer = new StringBuffer (apellido[i]);
					buffer.setLength(10); // Fijo en 10 caracteres la longitud del apellido
				
					file.writeChars (buffer.toString());
					file.writeInt(dep[i]);

						Double suma = salario[i]+impor;
						System.out.println(suma);
						salario[i]= suma;
						file.writeDouble (salario[i]);
						System.out.println(salario[i]);
					}else {
						file.writeInt (i+1);
						buffer = new StringBuffer (apellido[i]);
						buffer.setLength(10); // Fijo en 10 caracteres la longitud del apellido
					
						file.writeChars (buffer.toString());
						file.writeInt(dep[i]);
						file.writeDouble (salario[i]);
					}
						
				}
					
					
				
				/*
				//Double suma = (salario[iden]+impor);
				
				//file.writeDouble(suma);
				for(i=0;i<n;i++){
					if(iden==i) {
						i=iden;
						file.writeInt (i);
						System.out.println(i);
						
						buffer = new StringBuffer (apellido[i]);
						buffer.setLength(10); // Fijo en 10 caracteres la longitud del apellido
					
						file.writeChars (buffer.toString());
						file.writeInt(dep[i]);
						
						System.out.println(salario[i]);
						
						Double suma = salario[i]+impor;
						
						System.out.println(suma);
						
				
						salario[i]= suma;
						file.writeDouble (salario[i]);
		
					}
				}*/
			}else{
				System.out.println("Ok!, vuelve pronto..");
			}
			file.close(); // No olvidarse de cerrar el fichero
		}
	}
}
