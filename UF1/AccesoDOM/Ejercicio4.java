package DOM;

import org.w3c.dom.*;
import javax.naming.Context;
import javax.xml.parsers.*;
import javax.xml.transform.*;  
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class Ejercicio4 {
	public static void main (String args[]) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("Albums.txt"));
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();
			Document document = implementation.createDocument(null,"Albums", null);
			document.setXmlVersion("1.0");

			String linea = null;

			while ((linea = file.readLine())!=null) { //creamos un bucle que vya guardando en posicion los datos que vaya leyendo del fichero hasta el final del fichero.
				System.out.println(linea); //pintamos por consola linea a linea lo que hay dentro del fichero txt
				
				String[] var = linea.split(":");
				
				Element raiz = document.createElement ("Album");
				document.getDocumentElement().appendChild(raiz);
				
				NuevoElement("Autor", var[0], raiz, document);
				NuevoElement("Titulo", var[1], raiz, document);
				NuevoElement("Formato", var[2], raiz, document);
			}

			Source source = new DOMSource(document);
			Result result = new StreamResult(new File ("Albums.xml"));
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(source, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		file.close();		
	}

	static void NuevoElement(String datoEmpleado, String valor, Element raiz, Document document) {
		Element elem = document.createElement (datoEmpleado);
		Text text = document.createTextNode(valor);
		raiz.appendChild(elem);
		elem.appendChild(text);
	}
}
