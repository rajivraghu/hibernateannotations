package com.rajivraghu.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import org.hibernate.Session;

import com.rajivraghu.hibernate.model.ArticleJT;
import com.rajivraghu.hibernate.model.CategoryJT;

public class CategoryArticleJTDemo {

	
	public static void main(String[] args) {
		
		Session openSession = HibernateUtil.getSessionFactory().openSession();
		openSession.beginTransaction();
		
		/** Having @manytoone in child **/
		/*
		CategoryJT cat = new CategoryJT();
		cat.setCategory("Java");
		ArticleJT art = new ArticleJT();
		art.setArticleDescription("OOPS");
		art.setCat(cat);
		
		ArticleJT art1 = new ArticleJT();
		art1.setArticleDescription("Multi threading");
		art1.setCat(cat);
		openSession.save(art);
		openSession.save(art1);
		openSession.getTransaction().commit();
		openSession.close();
			*/
		
		CategoryJT cat = new CategoryJT();
		cat.setCategory("JS");
		List<ArticleJT> articles = new ArrayList<ArticleJT>();
		ArticleJT art = new ArticleJT();
		art.setArticleDescription("nodejs");
		//art.setCat(cat);
		
		ArticleJT art1 = new ArticleJT();
		art1.setArticleDescription("Angular");
		articles.add(art1);
		articles.add(art);
		//art1.setCat(cat);
/*		openSession.save(art);
		openSession.save(art1);*/
		cat.setArticles(articles);
		
		/** Saving parent, child will be saved because @OneToMany(cascade=CascadeType.ALL)
	    @JoinTable(name="CATE_ART", joinColumns=@JoinColumn(name="CAT_ID") , inverseJoinColumns=@JoinColumn(name="ARTICLE_ID")) List<ArticleJT> articles;  in  parent**/
	
		openSession.save(cat);
	
		openSession.getTransaction().commit();
		openSession.close();
		
		
		
	}
	
}
