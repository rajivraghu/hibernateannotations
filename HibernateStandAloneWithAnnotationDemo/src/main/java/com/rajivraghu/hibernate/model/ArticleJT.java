package com.rajivraghu.hibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ARTICLEJT")
public class ArticleJT {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ID_SEQ")
	@SequenceGenerator(name="ID_SEQ",sequenceName="ID_SEQ")
	@Column(name="ARTICLE_ID")
	private Integer articleId;
	@Column(name="ARTICLE_DES")
	private String articleDescription;
	
 /*   @ManyToOne(cascade=CascadeType.ALL)
	@JoinTable(name="CATE_ART" , joinColumns =@JoinColumn(name="ARTICLE_ID"), inverseJoinColumns=@JoinColumn(name="CAT_ID"))
	CategoryJT cat; */
	

	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	public String getArticleDescription() {
		return articleDescription;
	}
	public void setArticleDescription(String articleDescription) {
		this.articleDescription = articleDescription;
	}
/*	public CategoryJT getCat() {
		return cat;
	}
	public void setCat(CategoryJT cat) {
		this.cat = cat;
	}
*/
	
	
	
}
