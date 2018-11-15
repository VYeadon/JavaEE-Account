package qa.com.persistance.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import qa.com.persistance.domain.Account;

@Default
public class PersistanceDBDataStorage implements DataStorageMethodInterface{

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	

	@Transactional(REQUIRED)
	public void setPerson(Account newUserAccount) {
		em.persist(newUserAccount);
	}

	@Transactional(REQUIRED)
	public void updateUserDetails(Account AccountToBeUpdated) {
		em.merge(AccountToBeUpdated);	
	}

	@Transactional(REQUIRED)
	public void deleteUserDetails(Account accountToBeDeleted) {
		em.remove(accountToBeDeleted);
	}
	

	public Account getPerson(int accountNumber) {
		TypedQuery<Account> query = em.createQuery("SELECT a FROM Accounts a WHERE a.accountNumber='" + accountNumber + "'", Account.class);
		return query.getSingleResult();
	}

	public List<Account> getAllUsers() {
		TypedQuery<Account> query = em.createQuery("SELECT a FROM Accounts a", Account.class);
		return query.getResultList();
	}
}
