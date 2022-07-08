package testHibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class testMain {
	
	private static SessionFactory sessionFactory;
	
	public static void main(String[] args) {

		sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Person person1 = new Person();
		person1.setFirstName("Jeong");
		person1.setLastName("Lee");
		
		License license1 = new License();
		license1.setLicenseNumber("12345");
		license1.setIssueDate(new Date());
		license1.setPerson(person1); // license -> person
		
		Person person2 = new Person();
		person2.setFirstName("Alice");
		person2.setLastName("kim");
		
		License license2 = new License();
		license2.setLicenseNumber("568789");
		license2.setIssueDate(new Date());
		license2.setPerson(person2);
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		// 객체를 저장하여 DB에 반영. sql statement 를 대신함.
		session.save(license1);
		session.save(license2);

		tx.commit();
		session.close();
		
	}

}
