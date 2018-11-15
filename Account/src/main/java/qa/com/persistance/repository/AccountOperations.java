package qa.com.persistance.repository;

import static javax.transaction.Transactional.TxType.SUPPORTS;
import static javax.transaction.Transactional.TxType.REQUIRED;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import qa.com.persistance.domain.Account;

@Transactional(SUPPORTS)
public class AccountOperations {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	public List<Account> getAllAccounts(){
		TypedQuery<Account> query = em.createQuery("SELECT a FROM Accounts a", Account.class);
		return query.getResultList();
	}
	
	public Account findAccount(int accountNumber){
		TypedQuery<Account> query = em.createQuery("SELECT a FROM Accounts a WHERE a.accountNumber='" + accountNumber + "'", Account.class);
		return query.getSingleResult();
	}
	@Transactional(REQUIRED)
	public void createAnAccount(Account newAccount) {
		em.persist(newAccount);
	}
	@Transactional(REQUIRED)
	public void updateAnAccount(Account newAccount, int idToChange) {
		Account oldAccount = em.find(Account.class, idToChange);
		oldAccount.setFirstName(newAccount.getFirstName());
		oldAccount.setSecondName(newAccount.getSecondName());
		em.merge(oldAccount);
	}
	@Transactional(REQUIRED)
	public void deleteAccount(Account newAccount) {
		em.remove(newAccount);
	}
}

