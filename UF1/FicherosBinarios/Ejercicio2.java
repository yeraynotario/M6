package Practica3;
import java.io.* ;

public class Ejercicio2 {
	public static void main (String [] args) throws IOException {
		
		String[] nombre = {"Yeray", "Alejandro", "Carlos"};
		int[] edad = {23, 22, 30};
		
		File fichero = new File ("FicheroDatos.dat");
		DataOutputStream fileout = new DataOutputStream ( new FileOutputStream (fichero));
		
		
		for (int i=0; i<nombre.length && i<edad.length; i++ ) {
			
			fileout.writeUTF(nombre[i]);
			fileout.writeInt(edad[i]);
		}
		fileout.close();
		
	
		
	
	}
}



