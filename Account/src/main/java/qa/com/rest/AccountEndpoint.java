package qa.com.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import qa.com.persistance.domain.Account;
import qa.com.service.AccountServiceInterface;

@Path("/account")
public class AccountEndpoint {
	
	@Inject
	private AccountServiceInterface service;
	
	@Path("/json")
	@GET
	@Produces({"application/json"})
	public String returnAllUserAccounts() {
		return service.getAllUserAccounts();
	}
	
	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public Account addNewAccount(String JSONAccountInfoString) {
		return 
			service.createUserAccount(JSONAccountInfoString);
	}
	
	@Path("/json/{accountNumber}")
	@PUT
	@Produces({ "application/json" })
	public Account updateAccount(@PathParam("accountNumber") int accountNumber, String JSONAccountInfoString) {
		return 
			service.updateUserDetails(accountNumber, JSONAccountInfoString);
	}
	
	@Path("/json/{accountNumber}")
	@DELETE
	@Produces({ "application/json" })
	public boolean deleteAccount(@PathParam("accountNumber") int accountNumber) {
		return
			service.deleteUser(accountNumber);
	}



}
