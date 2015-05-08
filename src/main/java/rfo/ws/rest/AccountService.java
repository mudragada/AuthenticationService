package rfo.ws.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import rfo.ws.dao.Account;
import rfo.ws.util.HibernateUtil;


@Path("/account")
public class AccountService {
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
    public Account getAccountById(@PathParam("id") int accountId) {
        Account user = null;
        Transaction tx = null;
        Session session = null;
        SessionFactory sSessionFactory = HibernateUtil.getSessionFactory();
        if(sSessionFactory==null){
        	System.out.println("Unable to create a sessionFactory Obj");
        	return null;
        }
        try {
    		session = sSessionFactory.openSession();
    		tx = session.beginTransaction();
    		tx.setTimeout(10);
            String queryString = "from Account where id = " + accountId;
            Query query = session.createQuery(queryString);
            user = (Account) query.uniqueResult();
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
        
        if (user == null) {
             throw new RuntimeException("Unable to find Account for account number :" + accountId);
        }
        else{
        	
        }
        return user;
    }
}
