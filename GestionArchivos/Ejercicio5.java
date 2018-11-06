import java.io.File;

public class Ejercicio5 {
	public static void main (String[] args) {
		System.out.println(args[0]);
		
		File f = new File(args[0]);
		File[] ficheros = f.listFiles();
		for (int i=0;i<ficheros.length;i++){
		  System.out.printf("Nombre: %s, Ruta relativa: %s, Ruta absoluta: %s, Permisos: Escritura %s, Lectura %s, Ejecucion: %s, Tamaño: %s bytes.%n", ficheros[i].getName(), ficheros[i].getPath(), ficheros[i].getAbsolutePath(),ficheros[i].canWrite(),ficheros[i].canRead(),ficheros[i].canExecute(), ficheros[i].length());
		}
	}
}
