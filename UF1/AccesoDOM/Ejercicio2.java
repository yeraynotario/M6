package DOM;

import org.w3c.dom.*;
import javax.naming.Context;
import javax.xml.parsers.*;
import javax.xml.transform.*;  
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class Ejercicio2 {
	public static void main (String args[]) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("Empleados.txt"));
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();
			Document document = implementation.createDocument(null,"Empleados", null);
			document.setXmlVersion("1.0");

			String linea = null;

			while ((linea = file.readLine())!=null) { //creamos un bucle que vya guardando en posicion los datos que vaya leyendo del fichero hasta el final del fichero.
				System.out.println(linea); //pintamos por consola linea a linea lo que hay dentro del fichero txt
				
				String[] data = linea.split(":");
				
				Element raiz = document.createElement ("empleado");
				document.getDocumentElement().appendChild(raiz);
				
				newElement("Id", data[0], raiz, document);
				newElement("Apellido", data[1], raiz, document);
				newElement("Departamento", data[2], raiz, document);
				newElement("Salario", data[3], raiz, document);	
			}

			Source source = new DOMSource(document);
			Result result = new StreamResult(new File ("Empleados.xml"));
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(source, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		file.close();		
	}

	static void newElement(String datoEmpleado, String valor, Element raiz, Document document) {
		Element elem = document.createElement (datoEmpleado);
		Text text = document.createTextNode(valor);
		raiz.appendChild(elem);
		elem.appendChild(text);
	}
}
