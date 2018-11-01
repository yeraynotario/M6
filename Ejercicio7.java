import java.io.*;
public class Ejercicio7 {
	public static void main(String[] args){
		
		String dir = "C:\\Users\\Yeray\\eclipse-workspace\\M6Uf1\\NuevoDir"; // directorio 
		
		File f = new File(dir);
		
		File[] ficheros = f.listFiles();
		
		System.out.printf("Ficheros en el directorio actual: %d %n", ficheros.length);
		
	 
		for (int i=0;i<ficheros.length;i++){
			
			
			if (ficheros[i].delete()) {
				System.out.println("El fichero: " + ficheros[i].getName() + " ha sido borrado correctamente.");
			}else {
				System.out.println("El fichero: " + ficheros[i].getName() + " no se ha podido borrar.");
			}
			ficheros[i].delete();
			
		}
		
		if (f.delete()) {
			 System.out.println("El directorio: " + dir + " ha sido borrado correctamente.");
		}else {
			 System.out.println("El directorio: " + dir + " no se ha podido borrar.");
		} 
	}
}
