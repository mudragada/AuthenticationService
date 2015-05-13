package com.rf.rest;

import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rf.beans.UserCredentials;

@Path("/login")
public class LoginRestService {

	// This method is called if TEXT_PLAIN is request
	  @POST
	  @Produces(MediaType.APPLICATION_JSON)
	  @Consumes(MediaType.APPLICATION_JSON)
	  
//	  public boolean isUserValid(Map<String,UserCredentials> params) {
//	    for (Entry<String, Map<String, String>> node : params.entrySet()) {
//	    	System.out.println("key=" + node.getKey() + ", value=" + node.getValue());
//	    	for(Entry<String, String> entry : node.getValue().entrySet()){
//	    		System.out.println("key=" + entry.getKey() + ", value=" + entry.getValue());
//	    	}
//		}
//			return true;
//	  }	
	  public boolean isUserValid(Map<String,UserCredentials> params) {
		  System.out.println(params.get("data").getUsername());
		  System.out.println(params.get("data").getPassword());
		  return true;
	  }
}