package com.rf.rest.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.rf.account.beans.Account;
import com.rf.account.dao.AccountDao;
import com.rf.account.dao.AccountHibernateDaoImpl;
import com.rf.util.SpringUtil;


@Path("/account")
public class AccountRestService {
	private static final Logger log = LogManager.getLogger("AccountRestService");
    private static AccountDao acSpringDaoObj = (AccountDao) SpringUtil.getContext().getBean("AccountDAO");
    AccountHibernateDaoImpl acHibernateDaoObj = null;
	public AccountRestService(){
		log.info("Initializing Account Hibernate Dao Obj");
		acHibernateDaoObj = new AccountHibernateDaoImpl();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Account getAccountById(@PathParam("id") String id){
		if(acSpringDaoObj==null){
			log.error("Unable to init acSpringDaoObj");
		}
		Account accountObj = null;
		try {
			accountObj = acSpringDaoObj.getAccountById(id);
		}
		catch (Exception e) {
			log.error("Caught an exception while retreiving the account details");
			e.printStackTrace();
		}  
		return accountObj;
	}
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Account> getAccountList(){
		List<Account> accountObj = null;
		try {
			accountObj = acHibernateDaoObj.getAccountList();
		}
		catch (Exception e) {
			log.error("Unable to retrieve the account list");
			e.printStackTrace();
		}  
		return accountObj;
	}
}
