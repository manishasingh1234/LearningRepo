package com.spring.SpringMVCHibernateEx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.SpringMVCHibernateEx.model.Person;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
       HibernateDaoImpl dao = ctx.getBean("hibarnateDaoImpl", HibernateDaoImpl.class);
       Person person = new Person();
       person.setName("Neha");
       dao.savePerson(person);
    }
}
