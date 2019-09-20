package com.virtusa.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.model.Jobseeker;

@Repository
public class JobseekerDao implements JobSeekerDaoIf {

	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(Jobseeker just) {
		Session session = this.getSessionFactory().getCurrentSession();
		session.save(just);

	}

	public List<Jobseeker> show() {
		Query query = this.getSessionFactory().getCurrentSession().createQuery("from Jobseeker");
		List<Jobseeker> customers = query.list();
		return customers;

	}

	public String generateId() {

		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.createSQLQuery("select MAX(id) from jsregistration");
		List<Integer> result = (List<Integer>) query.list();
		System.out.println("Test" + query.uniqueResult());
		if (result.get(0) == null) {
			return "0";
		}
		return " " + query.uniqueResult();

	}

}
