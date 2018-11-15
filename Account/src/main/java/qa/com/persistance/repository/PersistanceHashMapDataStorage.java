package qa.com.persistance.repository;

import java.util.HashMap;
import java.util.List;

import javax.enterprise.inject.Alternative;

import qa.com.persistance.domain.Account;

@Alternative
public class PersistanceHashMapDataStorage implements DataStorageMethodInterface {
	
	private HashMap<Integer, Account> personList = new HashMap<Integer, Account>();
	
	public HashMap<Integer, Account> getPersonListMap()
	{
		return personList;
	}
	
	public void setPerson(Account newUserAccount)
	{
		personList.put(newUserAccount.getAccountNumber(), newUserAccount);
	}
	
	public Account getPerson(int accountNumber)
	{
		if(personList.size()<accountNumber)
		{
			System.out.println("no account found with this account number");
			return null;
		}
		
		Account user = personList.get(accountNumber);
		
		System.out.println("The users first name is: " + user.getFirstName());
		System.out.println("The users last name is: " + user.getSecondName());
		System.out.println("The users account number is: " + accountNumber);
		
		return user;
	}
	
	public int numberOfUsersWithFirstName(String name) {
		
		return
		(int) personList.entrySet()
						.stream()
						.filter( account -> 
									account.getValue().getFirstName().equalsIgnoreCase(name))
						.count();
	}

	public List<Account> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateUserDetails(Account AccountToBeUpdated) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserDetails(Account accountToBeDeleted) {
		// TODO Auto-generated method stub
		
	}

}
