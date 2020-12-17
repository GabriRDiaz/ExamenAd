package eval.database;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import eval.pojo.Autores;

public class AddHibernate {
	public static void addAutores(ArrayList<Autores> autores) {
		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
		
		Session ss = sf.openSession();
		ss.getTransaction().begin();
		autores.forEach(a->{
			ss.save(a);
		});
		ss.getTransaction().commit();
		ss.close();
		sf.close();
		sr.close();
	}
}
