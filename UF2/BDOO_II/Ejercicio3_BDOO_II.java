package primero;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

public class Ejercicio3_BDOO_II {
	public static void main(String[] args) {
		
		ODB odb = ODBFactory.open("EQUIPOS.DB");
		Objects<Jugadores> objects = odb.getObjects(Jugadores.class);

		while(objects.hasNext()){  
			
			Jugadores jugador = objects.next();
			jugador.setEdad(jugador.getEdad() + 1);
			odb.store(jugador);
		}
		odb.commit();
		odb.close(); 
	}
}