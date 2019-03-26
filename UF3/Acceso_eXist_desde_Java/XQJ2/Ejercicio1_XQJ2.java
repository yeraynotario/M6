import java.util.Scanner;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;

import net.xqj.exist.ExistXQDataSource;

public class Ejercicio1_XQJ2 {
	public static void main(String[] args){
		Scanner lector=new Scanner(System.in);
		System.out.println("Introdueix el tipus de departament");
		String $x = lector.next();
		
		try{
			XQDataSource server = new ExistXQDataSource();
			server.setProperty ("serverName", "192.168.56.102");
			server.setProperty ("port","8080");
			server.setProperty ("user","admin");
			server.setProperty ("password","austria");
			XQConnection conn = server.getConnection();
			XQPreparedExpression consulta;
			XQResultSequence resultado;
			consulta = conn.prepareExpression ("for $dept in doc('nueva/universidad.xml')/universidad/departamento[@tipo='"+$x+"']/empleado/nombre/text() return $dept");
			resultado = consulta.executeQuery();	
			while (resultado.next()) {
				
				System.out.println("Empleado: " + resultado.getItemAsString(null));
				
			}
			conn.close();
		} catch (XQException ex) {System.out.println("Error al operar"+ex.getMessage());}
	}
}	
