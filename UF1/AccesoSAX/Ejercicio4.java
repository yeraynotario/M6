package SAX;

import java.io.*;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class Ejercicio4 {
	
	public static void main (String [] args) throws FileNotFoundException, IOException, SAXException {

		System.out.print("Introduce el nombre de una artista: ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String autor = reader.readLine();
		
		/* A continuación se crea objeto procesador XML - XMLReader -. Durante la creación de este objeto se puede producir una
		excepción SAXException. */
		XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
		/* A continuación, mediante setContentHandler establecemos que la clase que gestiona los eventos provocados por la
		lectura del XML será GestionContenido */
		GestionContenido gestor = new GestionContenido(autor);
		procesadorXML.setContentHandler(gestor);
		/* Por último, se define el fichero que se va leer mediante InputSource y se procesa el documento XML mediante el
		método parse() de XMLReader */
		InputSource fileXML = new InputSource ("discoteca.xml");
		procesadorXML.parse(fileXML);
	}
}

class GestionContenido extends DefaultHandler {
	public static int contador = 0;
	
	String autor;
	
	public GestionContenido(String NuevoAutor){
		super();
		autor = NuevoAutor;
	}
	
	public void startDocument(){
		System.out.println("Comienzo del documento XML");
	}
	public void endDocument(){
		System.out.println("Final del documento XML");
		
		if (contador != 0) {
		System.out.println("El numero total de discos de "+ autor +" es: " + contador);
		} else {
			System.out.println("El autor "+ autor + " no aparece en el archivo.");
		}
	}
	public void startElement (String uri, String nombre, String nombreC, Attributes atts) {
		System.out.printf("\tPrincipio Elemento: %s %n", nombre);
		
	}
	public void endElement (String uri, String nombre, String nombreC){
		System.out.printf("\tFin Elemento: %s %n",nombre);
	}
	public void characters(char[] ch, int inicio, int longitud) throws SAXException {
		String car = new String (ch, inicio, longitud);
		car = car.replaceAll("[\t\n]","");
		
		if (car.equalsIgnoreCase(autor)){
			contador += 1;
		}
				
		System.out.printf("\tCaracteres: %s %n", car);
	}
}
