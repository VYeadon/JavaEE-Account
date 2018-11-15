package qa.com.service;

import java.util.List;

import qa.com.persistance.domain.Account;

public interface AccountServiceInterface {

	public void createUserAccount(String JSONUserInfoString);
	
	public Account getUserAccount(int accountNumber);
	
	public List<Account> getAllUserAccounts();
	
	public void updateUserDetails(int accountNumber, String JSONOfFirstandLastName);
	
	public void deleteUser(int accountNumber);
}
