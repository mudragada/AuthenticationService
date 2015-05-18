package com.rf.account.dao;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.rf.account.beans.Account;
public interface AccountDao {  
	 static Logger log = LogManager.getLogger("AccountDao");
	 public boolean addAccount(Account employee) throws Exception;  
	 public Account getAccountById(String id) throws Exception;  
	 public List<Account> getAccountList() throws Exception;  
	 public boolean deleteAccount(long id) throws Exception;  
}  