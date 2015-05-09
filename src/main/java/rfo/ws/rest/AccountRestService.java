package rfo.ws.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import rfo.ws.beans.Account;
import rfo.ws.dao.AccountDao;
import rfo.ws.dao.AccountDaoImpl;


@Path("/account")
public class AccountRestService {
    private static AccountDao acDaoObj;
    public AccountRestService() {
        acDaoObj = new AccountDaoImpl();
    }

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Account getAccountById(@PathParam("id") int id){
		Account accountObj = null;
		try {
			accountObj = acDaoObj.getAccountById(id);
		}
		catch (Exception e) {
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
			accountObj = acDaoObj.getAccountList();
		}
		catch (Exception e) {
				e.printStackTrace();
		}  
		return accountObj;
	}
}
