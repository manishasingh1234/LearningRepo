package com.hibernate.SquenceGeneration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainClass {

	private static SessionFactory factory;
	public static void main(String[] args) {
		
		factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
			
			tx = session.beginTransaction();
			Person p = new Person();
			p.setName("manisha");
			session.save(p);
			tx.commit();
		}
		catch(Exception e){
			
		}
		finally{
			session.close();
			factory.close();
			
		}
	}

}
