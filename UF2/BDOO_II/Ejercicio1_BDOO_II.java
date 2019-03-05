package primero;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class Ejercicio1_BDOO_II {
	  
	public static void main(String[] args) {
		
		ODB odb = ODBFactory.open("EQUIPOS.DB");
		Scanner lector = new Scanner(System.in);
		
		String nombreJugador = null;

		try {
			System.out.print("Insertar nombre: ");
			nombreJugador = lector.next();
			
		} catch ( IOException e ) {
			
			e.printStackTrace();
			System.exit(-1);
		}

		ICriterion filtro = Where.equal("nombre", nombreJugador);
		CriteriaQuery query = new CriteriaQuery (Jugadores.class, filtro);
		Objects<Jugadores> objects = odb.getObjects(query);

		if (objects.size() > 0) {
			while (objects.hasNext()) {
				
				Jugadores jugador = objects.next();
				System.out.println("NOMBRE: " + jugador.getNombre() + "\n" +"DEPORTE: " + jugador.getDeporte() + "\n" +"CIUDAD: " + jugador.getCiudad() + "\n" +"EDAD: " + jugador.getEdad() + "\n" +"PAIS: " + jugador.getPais() + "\n");
			
			}
		} 
		else {
			System.out.println("No se ha encontrado!");
		}
	}
}
