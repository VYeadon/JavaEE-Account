package qa.com.persistance.repository;

import java.util.List;

import qa.com.persistance.domain.Account;

public interface DataStorageMethodInterface {

	public void setPerson(Account newUserAccount);
	
	public Account getPerson(int accountNumber);
	
	public List<Account> getAllUsers();
	
	public void updateUserDetails(Account AccountToBeUpdated);
	
	public void deleteUserDetails(Account accountToBeDeleted);
	
}
