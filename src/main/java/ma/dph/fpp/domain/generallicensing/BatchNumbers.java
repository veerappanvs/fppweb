package ma.dph.fpp.domain.generallicensing;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "batch_revised")
public class BatchNumbers {

	public BatchNumbers(String accountNumber, String createdByUser, String entrytime, String assingedOn, String count) {
		super();
		this.accountNumber = accountNumber;
		this.createdByUser = createdByUser;
		this.entrytime = entrytime;
		this.assingedOn = assingedOn;
		this.count = count;
	}

	public BatchNumbers(String batchNumber, String accountNumber, String createdByUser, String entrytime,
			String assingedOn, String count) {
		super();
		this.batchNumber = batchNumber;
		this.accountNumber = accountNumber;
		this.createdByUser = createdByUser;
		this.entrytime = entrytime;
		this.assingedOn = assingedOn;
		this.count = count;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "batch_number", nullable=true)
	private String batchNumber;
	
	@Column(name = "account_number", nullable=true)
	private String accountNumber;
	
	@Column(name = "created_by_user", nullable=true)
	private String createdByUser;

	@Column(name = "entertime", nullable=true)
	private String entrytime;

	@Column(name = "assigned_on", nullable=true)
	private String assingedOn;

	@Column(name = "count", nullable=true)
	private String count;

	public BatchNumbers() {}


	/*
	 * @return the batchNumber
	 */
	public String getBatchNumber() {
		return batchNumber;
	}

	/**
	 * @param batchNumber the batchNumber to set
	 */
	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the createdByUser
	 */
	public String getCreatedByUser() {
		return createdByUser;
	}

	/**
	 * @param createdByUser the createdByUser to set
	 */
	public void setCreatedByUser(String createdByUser) {
		this.createdByUser = createdByUser;
	}

	/**
	 * @return the entrytime
	 */
	public String getEntryTime() {
		return entrytime;
	}

	/**
	 * @param entrytime the entrytime to set
	 */
	public void setEntryTime(String entrytime) {
		this.entrytime = entrytime;
	}

	/**
	 * @return the assingedOn
	 */
	public String getAssingedOn() {
		return assingedOn;
	}

	/**
	 * @param assingedOn the assingedOn to set
	 */
	public void setAssingedOn(String assingedOn) {
		this.assingedOn = assingedOn;
	}

	/**
	 * @return the count
	 */
	public String getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(String count) {
		this.count = count;
	}

	public String getEntrytime() {
		return entrytime;
	}

	public void setEntrytime(String entrytime) {
		this.entrytime = entrytime;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((assingedOn == null) ? 0 : assingedOn.hashCode());
		result = prime * result + ((batchNumber == null) ? 0 : batchNumber.hashCode());
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((createdByUser == null) ? 0 : createdByUser.hashCode());
		result = prime * result + ((entrytime == null) ? 0 : entrytime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BatchNumbers other = (BatchNumbers) obj;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (assingedOn == null) {
			if (other.assingedOn != null)
				return false;
		} else if (!assingedOn.equals(other.assingedOn))
			return false;
		if (batchNumber == null) {
			if (other.batchNumber != null)
				return false;
		} else if (!batchNumber.equals(other.batchNumber))
			return false;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (createdByUser == null) {
			if (other.createdByUser != null)
				return false;
		} else if (!createdByUser.equals(other.createdByUser))
			return false;
		if (entrytime == null) {
			if (other.entrytime != null)
				return false;
		} else if (!entrytime.equals(other.entrytime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BatchNumbers [batchNumber=" + batchNumber + ", accountNumber=" + accountNumber + ", createdByUser="
				+ createdByUser + ", entrytime=" + entrytime + ", assingedOn=" + assingedOn + ", count=" + count + "]";
	}


}