package primero;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class Ejercicio1_IV {
	public static void main(String[] args){
		
		SessionFactory sesion = HibernateUtil.getSessionFactory();

		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
			
		Emple empl = new Emple();
	
		try {
			empl = (Emple) session.load(Emple.class, 7369);
			System.out.printf("Apellido: %s Salario: %s %n", empl.getApellido(), empl.getSalario());
		} catch (ObjectNotFoundException o) {
			System.out.println ("No existe el departamento");
		}
	}
}
