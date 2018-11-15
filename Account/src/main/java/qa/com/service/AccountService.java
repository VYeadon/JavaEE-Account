package qa.com.service;

import javax.inject.Inject;

import qa.com.persistance.domain.Account;
import qa.com.persistance.repository.DataStorageMethodInterface;
import qa.com.util.JSONToJavaUtility;

public class AccountService implements AccountServiceInterface{
	
	@Inject
	private DataStorageMethodInterface dataRepository;
	
	public Account createUserAccount(String JSONUserInfoString)
	{
		Account newUser =
		JSONToJavaUtility.getObjectFromJSON(JSONUserInfoString, Account.class);
		
		if(newUser.getAccountNumber() == 999)
		{
			System.out.println("Invalid account number");
			return null;
		}
		
		dataRepository.setPerson(newUser);
		
		return newUser;
	}
	
	public Account getUserAccount(int accountNumber)
	{
		return
		dataRepository.getPerson(accountNumber);
	}
	
	public String getAllUserAccounts()
	{
		return
		JSONToJavaUtility.getJSONFromObject(
						dataRepository.getAllUsers());
	}
	
	public Account updateUserDetails(int accountNumber, String JSONOfFirstandLastName)
	{
		Account updatedUserAccount =
				JSONToJavaUtility.getObjectFromJSON(JSONOfFirstandLastName, Account.class);
		updatedUserAccount.setAccountNumber(accountNumber);
		
		dataRepository.updateUserDetails(updatedUserAccount);
		
		return updatedUserAccount;
	}
	
	public boolean deleteUser(int accountNumber)
	{
		if(getUserAccount(accountNumber) == null)
		{
			System.out.println("No such account");
			return false;
		}
		else 
		{
			dataRepository.deleteUserDetails(getUserAccount(accountNumber));
			return true;
		}
		
		
	}

}
