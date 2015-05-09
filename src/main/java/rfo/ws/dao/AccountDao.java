package rfo.ws.dao;
import java.util.List;

import rfo.ws.beans.Account;
public interface AccountDao {  
	  
	 public boolean addAccount(Account employee) throws Exception;  
	 public Account getAccountById(String id) throws Exception;  
	 public List<Account> getAccountList() throws Exception;  
	 public boolean deleteAccount(long id) throws Exception;  
}  