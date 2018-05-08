package com.rajivraghu.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.rajivraghu.hibernate.model.Book;

public class BookDemo {
	
	
	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session currentSession = sessionFactory.openSession();
		currentSession.beginTransaction();
		
		Book book = (Book) currentSession.get(Book.class, 767550);
		
		currentSession.getTransaction().commit();
		currentSession.close();
		book.setBookName("Hello");
		Session currentSession2 = sessionFactory.openSession();
		currentSession2.beginTransaction();
		
		System.out.println("book nbookame --"+book);
		//Book books = (Book) currentSession2.get(Book.class, 767550);
		//books.setAuthor("ssss");
		currentSession2.update(book);
		//currentSession2.update(books);
		currentSession2.getTransaction().commit();
		currentSession2.close();
		//System.out.println("book nbookame --"+books);
		/*System.out.println(" book id--"+book.getBookId());
		Session currentSession2 = sessionFactory.openSession();
		currentSession2.beginTransaction();
		currentSession2.saveOrUpdate(book);
		currentSession2.getTransaction().commit();
		currentSession2.close();
		System.out.println(" book id in s2--"+book.getBookId());*/
		
		
		
	}

}
