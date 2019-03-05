package primero;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import primero.Jugadores;
import primero.Paises;

public class Ejercicio1_BDOO {

	public static void main(String[] args) {

		Paises p1 = new Paises(1,"España");
		Paises p2 = new Paises(2,"Francia");
		Paises p3 = new Paises(3,"Inglaterra");
		Paises p4 = new Paises(4,"Alemania");

		Jugadores jugador1 = new Jugadores("Yeray Notario", "Basquet", "Barcelona", 22, p1);
		Jugadores jugador2 = new Jugadores("Alexis suarex", "futbol", "Paris", 23, p2);
		Jugadores jugador3 = new Jugadores("Tim Henman", "Tenis", "Londres", 24, p3);
		Jugadores jugador4 = new Jugadores("Marc marquez", "MotoGP", "Berlin", 25, p4);

		ODB odb = ODBFactory.open("EQUPOS.DB");
		
		odb.store(p1);
		odb.store(p2);
		odb.store(p3);
		odb.store(p4);
		
		odb.store(jugador1);               
		odb.store(jugador2);
		odb.store(jugador3);
		odb.store(jugador4);

		Objects<Paises> objectsPaises = odb.getObjects(Paises.class);
		Objects<Jugadores> objectsJugadores = odb.getObjects(Jugadores.class);   
		System.out.printf("%d Paises: %n", objectsPaises.size());
		System.out.printf("%d Jugadores: %n", objectsJugadores.size());

		int i = 1;
		while(objectsJugadores.hasNext()) {                                    
			Jugadores jugador = objectsJugadores.next();
			System.out.printf("%d: %s %n", i++, jugador.getPais());  
		} 

		System.out.print("");
		while(objectsPaises.hasNext()) {                                  
			Paises pais = objectsPaises.next();
			System.out.printf("%d: %s %s %n", i++, pais.getId(), pais.getNombrepais());  
		} 
		odb.close();      
	}
}
