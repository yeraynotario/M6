package DOM;
import java.io.File;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class Ejercicio5 {
	public static void main (String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File ("Albums.xml"));
			System.out.printf ("Elemento raíz : %s %n", document.getDocumentElement().getNodeName());
			NodeList albums = document.getElementsByTagName("Album");
			System.out.printf ("Nodos Album a recorrer: %d %n", albums.getLength());
			System.out.println();
			
			for (int i = 0; i < albums.getLength(); i++) {
				Node emple = albums.item(i);
				
				if (emple.getNodeType() == Node.ELEMENT_NODE){
					Element elemento = (Element) emple;
					System.out.printf(" - AUTOR: %s %n", elemento.getElementsByTagName("Autor").item(0).getTextContent());
					System.out.printf(" - TITULO: %s %n", 
							elemento.getElementsByTagName("Titulo").item(0).getTextContent());
					System.out.printf(" - FORMATO: %s %n", 
							elemento.getElementsByTagName("Formato").item(0).getTextContent());
					System.out.println();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			}
	}
}