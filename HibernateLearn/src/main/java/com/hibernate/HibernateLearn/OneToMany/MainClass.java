package com.hibernate.HibernateLearn.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class MainClass {
	private static SessionFactory factory;
	public static void main( String[] args )
    {
		 factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
			
			tx = session.beginTransaction();
			
			
			Employee emp = new Employee();
			emp.setEmpName("Surjeet");
			emp.setSalary(5000);
			Employee emp1 = new Employee();
			emp1.setEmpName("nisha");
			emp1.setSalary(3000);
			
			Employee emp2 = new Employee();
			emp2.setEmpName("isha");
			emp2.setSalary(17000);
			
			Employee emp3 = new Employee();
			emp3.setEmpName("anisha");
			emp3.setSalary(30050);
			
			Employee emp4 = new Employee();
			emp4.setEmpName("manisha");
			emp4.setSalary(53000);
			Department dep = new Department();
			dep.setDepName("IT");
			
			Department dep1 = new Department();
			dep1.setDepName("HR");
			dep.getEmployees().add(emp);
			dep.getEmployees().add(emp3);
			dep1.getEmployees().add(emp1);
			dep1.getEmployees().add(emp2);
			dep1.getEmployees().add(emp4);
			emp.setDep(dep);
			emp1.setDep(dep1);
			emp2.setDep(dep1);
			emp3.setDep(dep);
			emp4.setDep(dep1);
		
			session.save(dep);
			session.save(dep1);
			
			System.out.println("After session save");
			emp1.setEmpName("Nishant");
			emp1.setEmpName("ishant");
			System.out.println("Before transaction commit");
			tx.commit();
			System.out.println("After transaction commit");
			session.close();
			
			session=null;
			
			//Starting new Session
			
			session=factory.openSession();
			Department dep3 = (Department)session.load(Department.class, 2);
			System.out.println(dep3.getDepId());
			session.close();
			System.out.println(dep3.getEmployees().size());
		}
		catch(Exception ex){
			ex.printStackTrace();
			tx.rollback();
		}
		finally{
			//session.close();
			factory.close();
		}
		
	
	}
}
