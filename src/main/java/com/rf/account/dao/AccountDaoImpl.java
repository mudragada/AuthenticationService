package com.rf.account.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.rf.account.beans.Account;
import com.rf.util.HibernateUtil;

public class AccountDaoImpl implements AccountDao{
	SessionFactory sessionFactory;
	public AccountDaoImpl(){
		sessionFactory = HibernateUtil.getSessionFactory();
	    if(sessionFactory==null){
	    	System.out.println("Unable to create a sessionFactory Obj");
	    } 
	}
	 

	@Override
	public boolean addAccount(Account accountObj) throws Exception {
		return false;
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
	public boolean deleteAccount(long id) throws Exception {
		Session session = sessionFactory.openSession();
		Object o = session.load(Account.class, id);
		Transaction tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;  
	}

	@Override
	public Account getAccountById(String id) throws Exception {
        Account user = null;
        Transaction tx = null;
        Session session = null;
        try {
    		session = sessionFactory.openSession();
    		tx = session.beginTransaction();
    		tx.setTimeout(10);
    		user = (Account)session.get(Account.class, id); 
        }
        catch(RuntimeException rex){
        	System.out.println("RTE on beginTransaction()");
        	try{
        		tx.rollback();
        	}
        	catch(RuntimeException rexe){
        		System.out.println("RTE on tx rollback()");
        	}
        }finally {
            session.flush();
            session.close();
        }
        return user;
    }
}

