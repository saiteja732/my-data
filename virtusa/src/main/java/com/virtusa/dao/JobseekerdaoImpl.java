package com.virtusa.dao;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.model.Jobseeker;

@Repository
public class JobseekerdaoImpl implements JobseekerdaoIface {

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	JobSeekerDaoIf jobSeekerDaoIf;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}



	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public String loginValidate(Jobseeker jobseeker) {
		Session session=sessionFactory.getCurrentSession();
		Query query = session.createQuery("select jsid from  Jobseeker where email=:Email and password=:Password");
		query.setParameter("Email", jobseeker.getEmail());
		query.setParameter("Password", jobseeker.getPassword());
		List list =query.list();
		System.out.println(list);
		System.out.println(list.isEmpty());
		
		if(!(list.isEmpty())) {
			String str = (String)list.get(0);
			System.out.println(list.get(0));
			return list.get(0).toString();
		}
		return "unable to login or wrong credentials";
	}


	
	public boolean RegisterJob(String fname, String lname, String email, String password, String question,String phoneno,
			String answer) {
		 Session session=sessionFactory.getCurrentSession();
		 String temp =jobSeekerDaoIf.generateId();
		 temp=temp.trim();
		 System.out.println(temp);
		 int id =Integer.parseInt(temp);
		 id++;
		 String jsid="JSK-"+id;
		 SQLQuery query=session.createSQLQuery("insert into jsregistration (id,jsid,jsfirstname,jslastname,jsemail,jsphoneno,jspassword,question,answer)values(?,?,?,?,?,?,?,?,?)");
		 query.setParameter(0, id);
		 query.setParameter(1, jsid);
		 query.setParameter(2, fname);
	 	 query.setParameter(3, lname);
	   	 query.setParameter(4, email);
	 	 query.setParameter(5, phoneno);
	 	 query.setParameter(6, password);
	 	 query.setParameter(7, question);
	 	 query.setParameter(8, answer);
	 	 int result=query.executeUpdate();
	 	 if(result>0)
	 		 return true;
	 	 else
	 		return false;
	
	}



	public String forgotpass(Jobseeker jobseeker) {
		Session session=sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery("update jsregistration set jspassword=:password where jsemail=:email and question=:question and answer=:answer");
		query.setParameter("email", jobseeker.getEmail());
		query.setParameter("question", jobseeker.getQuestion());
		query.setParameter("answer",jobseeker.getAnswer());
		query.setParameter("password", jobseeker.getPassword());
		int result=query.executeUpdate();
		if(result!=0)
			 return "Sucessfully updated";
		else
			 return "Your details are not correct";
	}




	public String editpass(Jobseeker jobseeker) {
		Session session=sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery("update jsregistration set jspassword=:password where jsid=:jid");
		query.setParameter("jid", jobseeker.getJsid());
		query.setParameter("password", jobseeker.getPassword());
		int result=query.executeUpdate();
		if(result!=0)
			 return "Sucessfully updated";
		else
			 return "Your details are not correct";
	}
   public String saveprofile(Jobseeker jobseeke) {
	 Session session=sessionFactory.getCurrentSession();
	 return null;
   }
   
   public Jobseeker getJSDetails(String jsid) {
	   return (Jobseeker)sessionFactory.getCurrentSession().get(Jobseeker.class, jsid);
   }
   
   public void updateJSDetails(Jobseeker jobseeker) {
	   Session session=sessionFactory.getCurrentSession();
	   session.update(jobseeker);
   }

	   }

