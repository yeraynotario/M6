package primero;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class Ejercicio2_BDOO_II {
	public static void main(String[] args) {
		
		ODB odb = ODBFactory.open("EQUIPOS.DB");
		String nombreJugador = null;

		ICriterion filtro = new And().add(Where.ge("edad", 14)).add(Where.le("edad", 20));
		CriteriaQuery query = new CriteriaQuery (Jugadores.class, filtro);
		Objects<Jugadores> objects = odb.getObjects(query);

		if (objects.size() > 0) {
			while (objects.hasNext()) {
				Jugadores jugador = objects.next();
				System.out.println("NOMBRE: " + jugador.getNombre() + "\n" +"DEPORTE: " + jugador.getDeporte() + "\n" +"CIUDAD: " + jugador.getCiudad() + "\n" + "EDAD: " + jugador.getEdad() + "\n" +"PAIS: " + jugador.getPais() + "\n");
			}
		} 
		else {
			
			System.out.println("No se ha encontrado!");
		}
	}
}