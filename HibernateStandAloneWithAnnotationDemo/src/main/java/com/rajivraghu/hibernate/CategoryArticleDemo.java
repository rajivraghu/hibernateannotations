package com.rajivraghu.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.Session;

import com.rajivraghu.hibernate.model.Article;
import com.rajivraghu.hibernate.model.Category;

public class CategoryArticleDemo {
	
	public static void main(String[] args) {
		
		
		Session openSession = HibernateUtil.getSessionFactory().openSession();
		openSession.beginTransaction();
		
		/** Having @manytoone in child **/
	/*	Category cat = new Category();
		cat.setCategory("Hibernate");
		Article art = new Article();
		art.setArticleDescription("hibernate mapping");
		art.setCat(cat);
		
		Article art1 = new Article();
		art1.setArticleDescription("hibernate config");
		art1.setCat(cat);
		openSession.save(art);
		openSession.save(art1);*/
		/** having @onetomany **/
		Category cat = new Category();
		cat.setCategory("Hibernate");
		List<Article> articles = new ArrayList<Article>();
		Article art = new Article();
		art.setArticleDescription("hibernate mapping");
		
		
		Article art1 = new Article();
		art1.setArticleDescription("hibernate config");
		articles.add(art1);
		articles.add(art);
		cat.setArticles(articles);
		openSession.save(cat);
	
		openSession.getTransaction().commit();
		/** getting child from parent **/
		/*Category object = (Category) openSession.get(Category.class, 392550);
		List<Article> articles2 = object.getArticles();*/
		
		/***********************************************************/
		
		/** getting parent from child - by using 	@ManyToOne(cascade=CascadeType.ALL)
			@JoinColumn(name="CAT_ID")
			Category cat;*/
		Article object = (Article) openSession.get(Article.class, 400051);
		System.out.println(object.getCat().getCategory());
		
		openSession.close();
		
	}

}
