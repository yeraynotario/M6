import java.io.File;

public class Ejercicio4 {
	public static void main (String[] args) {
		try{
			 System.out.println(args[0]);
				
			 File f = new File(args[0]);
			 File[] ficheros = f.listFiles();
			 for (int i=0;i<ficheros.length;i++){
				 System.out.printf("Nombre: %s, es fichero?: %b, es directorio?:%b %n", ficheros[i].getName(), ficheros[i].isFile(), ficheros[i].isDirectory());
			 }
		}catch (Exception ex){
			System.out.println("No existe el directorio");
		}	
	}
}

