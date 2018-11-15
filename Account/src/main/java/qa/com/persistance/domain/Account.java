package qa.com.persistance.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
	
	public Account() {
	}
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id 
	private Integer accountNumber;
	
	@Column(length=50)
	private String firstName;
	
	@Column(length=50)
	private String secondName;
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNo) {
		this.accountNumber = accountNo;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getSecondName() {
		return firstName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	
}
