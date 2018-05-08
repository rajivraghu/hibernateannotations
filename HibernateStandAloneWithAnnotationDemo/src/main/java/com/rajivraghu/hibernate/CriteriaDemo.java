package com.rajivraghu.hibernate;

import java.util.List;

import javax.persistence.criteria.Order;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import com.rajivraghu.hibernate.model.Bank;

public class CriteriaDemo {

	

	public static void main(String[] args) {
		
		Session s=	HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		
		Criteria createCriteria = s.createCriteria(Bank.class);
		
		Criterion bankManger = Restrictions.eq("bankManager", "Raj");
		Criterion bankName = Restrictions.eq("bankName", "Bradesco");
		
		LogicalExpression orExp =Restrictions.or(bankManger,bankName);
		LogicalExpression orExp1 =Restrictions.and(bankManger,bankName);
		createCriteria.add(orExp);
		createCriteria.setFirstResult(5);
		createCriteria.setMaxResults(10);
	
		//createCriteria.add(Restrictions.isEmpty("isInternational"));
		//createCriteria.add(Restrictions.eq("bankManager", "Raj"));
		//createCriteria.add(Restrictions.eq("bankId", 172550));
		List<Bank> list = (List<Bank>) createCriteria.list();
		System.out.println(list.size());
		s.close();
		
	}
}
