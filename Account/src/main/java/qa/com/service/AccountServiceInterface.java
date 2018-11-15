package qa.com.service;

import qa.com.persistance.domain.Account;

public interface AccountServiceInterface {

	public Account createUserAccount(String JSONUserInfoString);
	
	public Account getUserAccount(int accountNumber);
	
	public String getAllUserAccounts();
	
	public Account updateUserDetails(int accountNumber, String JSONOfFirstandLastName);
	
	public boolean deleteUser(int accountNumber);
}
