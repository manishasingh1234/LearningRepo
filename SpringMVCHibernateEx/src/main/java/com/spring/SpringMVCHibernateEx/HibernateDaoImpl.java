package com.spring.SpringMVCHibernateEx;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.SpringMVCHibernateEx.model.Person;

@Repository
public class HibernateDaoImpl {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void savePerson(Person person){
		
		Session session = getSessionFactory().openSession();
		//Transaction tx = session.beginTransaction();
		session.save(person);
		//tx.commit();
		session.close();
	}

}
