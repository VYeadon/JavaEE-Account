package qa.com.service;

import java.util.List;

import javax.inject.Inject;

import qa.com.persistance.domain.Account;
import qa.com.persistance.repository.DataStorageMethodInterface;
import qa.com.util.JSONToJavaUtility;

public class AccountService implements AccountServiceInterface{
	
	@Inject
	private DataStorageMethodInterface dataRepository;
	
	public void createUserAccount(String JSONUserInfoString)
	{
		Account newUser =
		JSONToJavaUtility.getObjectFromJSON(JSONUserInfoString, Account.class);
		
		if(newUser.getAccountNumber() == 999)
		{
			System.out.println("Invalid account number");
		}
		
		dataRepository.setPerson(newUser);
	}
	
	public Account getUserAccount(int accountNumber)
	{
		return
		dataRepository.getPerson(accountNumber);
	}
	
	public List<Account> getAllUserAccounts()
	{
		return
		dataRepository.getAllUsers();
	}
	
	public void updateUserDetails(int accountNumber, String JSONOfFirstandLastName)
	{
		Account updatedUserAccount =
				JSONToJavaUtility.getObjectFromJSON(JSONOfFirstandLastName, Account.class);
		updatedUserAccount.setAccountNumber(accountNumber);
		
		dataRepository.updateUserDetails(updatedUserAccount);
	}
	
	public void deleteUser(int accountNumber)
	{
		dataRepository.deleteUserDetails(getUserAccount(accountNumber));
	}

}
