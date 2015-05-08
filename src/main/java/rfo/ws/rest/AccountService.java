package rfo.ws.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import rfo.ws.dao.Account;
import rfo.ws.util.HibernateUtil;


@Path("/hello")
public class AccountService {
	@GET
	@Path("/account/{id}")
	@Produces(MediaType.APPLICATION_JSON)
    public Account getAccountById(@PathParam("id") int accountId) {
		System.out.println("######### Inside getAccountById#####");
        Account user = null;
        Transaction trns = null;
        Session session = null;
        SessionFactory sSessionFactory = HibernateUtil.getSessionFactory();
        if(sSessionFactory!=null){
        	System.out.println("######### SessionFactory not NULL #####");
        	session = sSessionFactory.openSession();
        }
        else{
        	System.out.println("######### SessionFactory is NULL, exiting.. #####");
        	return null;
        }
        try {
            trns = session.beginTransaction();
            String queryString = "from user_account where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", accountId);
            user = (Account) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return user;
    }
//	public Response getAccount(@PathParam("name") String msg) { 
//		
//	     System.out.println("Maven + Hibernate + MySQL");
//	     Session session = HibernateUtil.getSessionFactory().openSession();
//	 
//	        session.beginTransaction();
//	        Account stock = new Account();
//	 
//	        stock.setStockCode("4715");
//	        stock.setStockName("GENM");
//	 
//	        session.save(stock);
//	        session.getTransaction().commit();
//		String output = "Jersey say : " + msg;
//		return Response.status(200).entity(output).build();
//	}
}
