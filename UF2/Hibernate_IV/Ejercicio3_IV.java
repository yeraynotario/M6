package primero;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Ejercicio3_IV {
	public static void main(String[] args){
		
		SessionFactory sesion = HibernateUtil.getSessionFactory();

		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
			
		Emple empl = new Emple();
		Depart dept = new Depart();
	
		try {
			empl = (Emple) session.load(Emple.class, 7369);
			dept = (Depart) session.load(Depart.class, 30);
			
			empl.setDepart(dept);
			empl.setSalario(empl.getSalario()+1000);
			
			session.update(empl);
			tx.commit();
			System.out.printf("Depart: %s Apellido: %s Salario: %s %n",empl.getDepart().getDeptNo(), empl.getApellido(), empl.getSalario());
			
		} catch (ObjectNotFoundException o) {
			System.out.println ("No existe el departamento");
		}
		
	}
}
