package qa.com.persistance.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import qa.com.persistance.domain.Account;

@Transactional(SUPPORTS)
@Default
public class PersistanceDBDataStorage implements DataStorageMethodInterface{

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;


	@Transactional(REQUIRED)
	public void setPerson(Account newUserAccount) {
		manager.persist(newUserAccount);
	}

	@Transactional(REQUIRED)
	public void updateUserDetails(Account AccountToBeUpdated) {
		manager.merge(AccountToBeUpdated);	
	}

	@Transactional(REQUIRED)
	public void deleteUserDetails(Account accountToBeDeleted) {
		manager.remove(accountToBeDeleted);
	}
	

	public Account getPerson(int accountNumber) {
		TypedQuery<Account> query = manager.createQuery("SELECT * FROM Account WHERE accountNumber=" + accountNumber + ";", Account.class);
		return query.getSingleResult();
	}

	public List<Account> getAllUsers() {
		TypedQuery<Account> query = manager.createQuery("SELECT * FROM Account;", Account.class);
		return query.getResultList();
	}
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

}
