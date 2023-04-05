package com.training.springBootwithHibernate.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.springBootwithHibernate.config.HibernateConfig;
import com.training.springBootwithHibernate.dao.MyUsers;

@Service
public class UserService {

	@Autowired
	SessionFactory sessionfactory;
	
	public String saveUser(MyUsers u) {
		 Session session = sessionfactory.openSession();
		 Transaction tx  = session.beginTransaction();
		 session.save(u);
		 tx.commit();
		 session.close();
		 return "User Saved";
		 
	}
	
	public MyUsers getUser(Integer id) {
		Session session = sessionfactory.openSession();
		 Transaction tx  = session.beginTransaction();
		 MyUsers usr  = session.load(MyUsers.class, id);
		  tx.commit();
		 return usr;
	}
	
	
}
