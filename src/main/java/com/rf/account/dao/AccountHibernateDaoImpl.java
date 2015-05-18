package com.rf.account.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.rf.account.beans.Account;
import com.rf.util.HibernateUtil;

public class AccountHibernateDaoImpl implements AccountDao {
	SessionFactory sessionFactory;
	public AccountHibernateDaoImpl(){
		sessionFactory = HibernateUtil.getSessionFactory();
	    if(sessionFactory==null){
	    	System.out.println("Unable to create a sessionFactory Obj");
	    } 
	}
	@Override
	public List<Account> getAccountList() throws Exception {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Account> accList = session.createCriteria(Account.class).list();
		tx.commit();
		session.close();
		return accList;  
	}

	@Override
	public boolean addAccount(Account employee) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Account getAccountById(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteAccount(long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
