package com.rajivraghu.hibernate;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.rajivraghu.hibernate.model.Account;
import com.rajivraghu.hibernate.model.Address;
import com.rajivraghu.hibernate.model.Article;
import com.rajivraghu.hibernate.model.ArticleJT;
import com.rajivraghu.hibernate.model.Bank;
import com.rajivraghu.hibernate.model.Book;
import com.rajivraghu.hibernate.model.Category;
import com.rajivraghu.hibernate.model.CategoryJT;
import com.rajivraghu.hibernate.model.CollegeStudent;
import com.rajivraghu.hibernate.model.Credential;
import com.rajivraghu.hibernate.model.Device;
import com.rajivraghu.hibernate.model.Employee;
import com.rajivraghu.hibernate.model.FourWheeler;
import com.rajivraghu.hibernate.model.House;
import com.rajivraghu.hibernate.model.Identification;
import com.rajivraghu.hibernate.model.Loan;
import com.rajivraghu.hibernate.model.Person;
import com.rajivraghu.hibernate.model.Player;
import com.rajivraghu.hibernate.model.Room;
import com.rajivraghu.hibernate.model.Student;
import com.rajivraghu.hibernate.model.Subject;
import com.rajivraghu.hibernate.model.Team;
import com.rajivraghu.hibernate.model.Territory;
import com.rajivraghu.hibernate.model.Transaction;
import com.rajivraghu.hibernate.model.TwoWheeler;
import com.rajivraghu.hibernate.model.User;
import com.rajivraghu.hibernate.model.UserTerritoryMapping;
import com.rajivraghu.hibernate.model.Vehicle;

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
		configuration.addAnnotatedClass(User.class);
		configuration.addAnnotatedClass(Credential.class);
		configuration.addAnnotatedClass(Transaction.class);
		configuration.addAnnotatedClass(Account.class);
		configuration.addAnnotatedClass(Loan.class);
		configuration.addAnnotatedClass(Employee.class);
		configuration.addAnnotatedClass(Device.class);
		configuration.addAnnotatedClass(Person.class);
		configuration.addAnnotatedClass(Identification.class);
		configuration.addAnnotatedClass(Category.class);
		configuration.addAnnotatedClass(Article.class);
		configuration.addAnnotatedClass(CategoryJT.class);
		configuration.addAnnotatedClass(ArticleJT.class);
		configuration.addAnnotatedClass(CollegeStudent.class);
		configuration.addAnnotatedClass(Subject.class);
		configuration.addAnnotatedClass(Vehicle.class);
		configuration.addAnnotatedClass(TwoWheeler.class);
		configuration.addAnnotatedClass(FourWheeler.class);
		configuration.addAnnotatedClass(Team.class);
		configuration.addAnnotatedClass(Player.class);
		configuration.addAnnotatedClass(Territory.class);
		configuration.addAnnotatedClass(UserTerritoryMapping.class);
		configuration.addAnnotatedClass(Book.class);
		
		/*configuration.addAnnotatedClass(House.class);
		configuration.addAnnotatedClass(Room.class);*/
		
			
		configuration.setProperties( new Properties(){
			{
			put("hibernate.connection.username","orderapp");
			put("hibernate.connection.password","orderapp");
			put("hibernate.connection.url","jdbc:oracle:thin:@localhost:1521:ORCL");
			put("hibernate.connection.driver_class","oracle.jdbc.driver.OracleDriver");
			put("hibernate.show_sql", "true");
			put("hibernate.hbm2ddl.auto","update");
			/*put("hibernate.cache.use_second_level_cache","true");
			put("hibernate.cache.region.factory_class","org.hibernate.cache.ehcache.EhCacheRegionFactory");*/
			
			
			
		}});
		
		sessionFactory=configuration.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build());
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
}
