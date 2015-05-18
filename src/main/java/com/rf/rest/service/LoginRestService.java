package com.rf.rest.service;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rf.security.authentication.LoginAuthHandler;
import com.rf.security.beans.UserCredentials;

@Path("/login")
public class LoginRestService {

	// This method is called if TEXT_PLAIN is request
	  @POST
	  @Produces(MediaType.APPLICATION_JSON)
	  @Consumes(MediaType.APPLICATION_JSON)
	  public boolean isUserValid(Map<String,UserCredentials> params) {
		  boolean isUserValid = false;
		  String sUserName = params.get("data").getUsername();
		  String sPassword = params.get("data").getPassword();	  
		  LoginAuthHandler authenticateUser = LoginAuthHandler.getInstance();
		  try {
			  isUserValid = authenticateUser.authenticateUser(sUserName, sPassword);			  	
			  System.out.println("LoginRestService::isUserValid - Authenticating " + sUserName + ", isUserValid = " + isUserValid);	  
		   }
		   catch (Exception e) {
			   System.out.println("LoginRestService::isUserValid - Exception e = " + e);
		   }
		  return isUserValid;
	  }
	  @Path("/create")
	  @POST
	  @Produces(MediaType.APPLICATION_JSON)
	  @Consumes(MediaType.APPLICATION_JSON)
	  public boolean createUser(Map<String,UserCredentials> params) {
		  boolean isRegistered = false;
		  String sUserName = params.get("data").getUsername();
		  String sPassword = params.get("data").getPassword();	  
		  LoginAuthHandler authUser = LoginAuthHandler.getInstance();
		  if(authUser==null){
			  System.out.println("LoginRestService::createUser::authUser is null");
		  }
		  try {
		   isRegistered = authUser.registerUser(sUserName,sPassword);
		  }
		   catch (Exception e) {
			   System.out.println("LoginRestService::createUser::Exception e = " + e);
		   }
		  return isRegistered;
	  }
}