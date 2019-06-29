package com.hibernate.HibernateLearn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pojo.Department;
import com.pojo.Employee;
import com.pojo.Project;

/**
 * Hello world!
 *
 */
public class App 
{
	private static SessionFactory factory;
	public static void main( String[] args )
    {
		 factory = new Configuration().configure().buildSessionFactory();
		//Project p = new Project();
		/*p.setDepId(1);
		p.setProjectId(1);
		p.setProjectName("UBS CE");*/
		
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
			
			tx = session.beginTransaction();
			//tx.begin();
			//session.save(p);
			
			// -------------Composite key example Starts------------------
			/*ProjectId pId = new ProjectId();
			pId.setDepId(1);
			pId.setProjectId(1);
			p=(Project)session.get(Project.class, pId);
			System.out.println(p.getProjectName());*/
			
			// -------------Composite key example Ends------------------
			
			// -------------Hibernate Methods example Starts------------------
			
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
			dep.setDepName("HR");
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
			
			tx.commit();
			session.close();
			/*emp.setEmpName("Surjeet1");
			Session session1 = factory.openSession();
			Employee emp2 = (Employee)session1.get(Employee.class, 1);
			//session1.update(emp);
			session.save(emp);
			session.save(emp1);*/
			
			/*Department dep1 = (Department)session.load(Department.class, 1);
			System.out.println(dep1.getEmployees());*/
			
			
		}
		catch(Exception ex){
			ex.printStackTrace();
			tx.rollback();
		}
		finally{
			//session.close();
		}
		factory.close();
	
	}
}
