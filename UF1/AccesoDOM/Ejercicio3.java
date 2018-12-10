package DOM;
import java.io.File;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class Ejercicio3 {
	public static void main (String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File ("Empleados.xml"));
			System.out.printf ("Elemento raíz : %s %n", document.getDocumentElement().getNodeName());
			NodeList empleados = document.getElementsByTagName("Empleado");
			System.out.printf ("Nodos empleado a recorrer: %d %n", empleados.getLength());
			
			for (int i = 0; i < empleados.getLength(); i++) {
				Node emple = empleados.item(i);
				
				if (emple.getNodeType() == Node.ELEMENT_NODE){
					Element elemento = (Element) emple;
					System.out.printf("ID = %s %n", elemento.getElementsByTagName("Id").item(0).getTextContent());
					System.out.printf(" * Apellido = %s %n", 
							elemento.getElementsByTagName("Apellido").item(0).getTextContent());
					System.out.printf(" * Departamento = %s %n", 
							elemento.getElementsByTagName("Departamento").item(0).getTextContent());
					System.out.printf(" * Salario = %s %n",
							elemento.getElementsByTagName("Salario").item(0).getTextContent());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			}
	}
}
