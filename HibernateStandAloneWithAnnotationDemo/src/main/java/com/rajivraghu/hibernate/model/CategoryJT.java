package com.rajivraghu.hibernate.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORYJT")
public class CategoryJT {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ID_SEQ")
	@SequenceGenerator(name="ID_SEQ",sequenceName="ID_SEQ")
	@Column(name="CAT_ID")
	private Integer categoryId;
	@Column(name="CAT_DES")
	private String category;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="CATE_ART", joinColumns=@JoinColumn(name="CAT_ID") , inverseJoinColumns=@JoinColumn(name="ARTICLE_ID"))
	List<ArticleJT> articles;
	
	
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<ArticleJT> getArticles() {
		return articles;
	}
	public void setArticles(List<ArticleJT> articles) {
		this.articles = articles;
	}

	
}
