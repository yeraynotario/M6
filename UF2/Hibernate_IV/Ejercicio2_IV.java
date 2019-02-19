package primero;

import java.util.Set;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Iterator;

public class Ejercicio2_IV {
	public static void main(String[] args){
		
		SessionFactory sesion = HibernateUtil.getSessionFactory();

		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
			
		Depart dep = new Depart();
		
		try {
			
			dep = (Depart) session.load(Depart.class, 10);
			
			Set<Emple> listaemp = dep.getEmples();
			Iterator<Emple> it = listaemp.iterator();
		
			while (it.hasNext()){
				Emple element = it.next();
				System.out.printf("Dept_no: %s  Dnombre: %s Loc: %s Apellido: %s Salario: %s %n",dep.getDeptNo(), dep.getDnombre(), dep.getLoc(),element.getApellido(), element.getSalario());
			}

		} catch (ObjectNotFoundException o) {
			System.out.println ("No existe el departamento");
		}
	}
}


