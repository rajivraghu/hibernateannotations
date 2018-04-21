package com.rajivraghu.hibernate;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.rajivraghu.hibernate.model.Address;
import com.rajivraghu.hibernate.model.Bank;
import com.rajivraghu.hibernate.model.Student;

@SuppressWarnings("deprecation")
public class HibernateUtil {
	
	private static final SessionFactory sessionFactory;
	
	static{
		/** XML configuration **/
		/*try{
			sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();

		}catch (Throwable ex) {
			System.err.println("Session Factory could not be created." + ex);
			throw new ExceptionInInitializerError(ex);
		}	*/
		
		/** In-line Configuration **/
		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(Student.class);
		configuration.addAnnotatedClass(Bank.class);
		configuration.addAnnotatedClass(Address.class);
		configuration.setProperties( new Properties(){
			{
			put("hibernate.connection.username","orderapp");
			put("hibernate.connection.password","orderapp");
			put("hibernate.connection.url","jdbc:oracle:thin:@localhost:1521:ORCL");
			put("hibernate.connection.driver_class","oracle.jdbc.driver.OracleDriver");
			put("hibernate.show_sql", "true");
			
		}});
		
		sessionFactory=configuration.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build());
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
}
