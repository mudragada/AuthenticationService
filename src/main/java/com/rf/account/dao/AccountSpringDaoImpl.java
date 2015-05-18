package com.rf.account.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.rf.account.beans.Account;
import com.rf.util.HibernateUtil;

public class AccountSpringDaoImpl extends JdbcDaoSupport implements AccountDao{
	public static BeanPropertyRowMapper<Account> getRowMapper(){
		return BeanPropertyRowMapper.newInstance(Account.class);
	}
	 

	@Override
	public boolean addAccount(Account accountObj) throws Exception {
		return false;
    }



	@Override
	public boolean deleteAccount(long id) throws Exception {
//		Session session = sessionFactory.openSession();
//		Object o = session.load(Account.class, id);
//		Transaction tx = session.getTransaction();
//		session.beginTransaction();
//		session.delete(o);
//		tx.commit();
		return false;  
	}

	@Override
	public Account getAccountById(String id) throws Exception {
		log.info("Inside getAccountById");
		String sql = "select * from user_account where id = ? ";
		if(getJdbcTemplate() == null){
			System.out.println("Null JDBCTemplate");
		}
		if(getRowMapper() == null){
			log.error("Null RowMapper");
		}
		log.debug(sql);
        Account user = getJdbcTemplate().queryForObject(sql,getRowMapper(),id);
        return user;
    }


	@Override
	public List<Account> getAccountList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}

