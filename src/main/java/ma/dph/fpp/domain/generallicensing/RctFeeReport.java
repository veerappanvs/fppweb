package ma.dph.fpp.domain.generallicensing;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "v_rctfee_reports")
public class RctFeeReport {

	public RctFeeReport(String statuscnt, String amountsum) {
		super();
		this.statuscnt = statuscnt;
		this.amountsum = amountsum;
	}

	public RctFeeReport(String status, String statuscnt, String amountsum) {
		super();
		this.status = status;
		this.statuscnt = statuscnt;
		this.amountsum = amountsum;
	}

	public RctFeeReport() {}
    
	@Id
	@Column(name="status")
	String status;
	
	@Column(name="statuscnt")
	String statuscnt;
	
	@Column(name="amountsum")
	String amountsum;

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the statuscnt
	 */
	public String getStatuscnt() {
		return statuscnt;
	}

	/**
	 * @param statuscnt the statuscnt to set
	 */
	public void setStatuscnt(String statuscnt) {
		this.statuscnt = statuscnt;
	}

	/**
	 * @return the amountsum
	 */
	public String getAmountsum() {
		return amountsum;
	}

	/**
	 * @param amountsum the amountsum to set
	 */
	public void setAmountsum(String amountsum) {
		this.amountsum = amountsum;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amountsum == null) ? 0 : amountsum.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((statuscnt == null) ? 0 : statuscnt.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RctFeeReport other = (RctFeeReport) obj;
		if (amountsum == null) {
			if (other.amountsum != null)
				return false;
		} else if (!amountsum.equals(other.amountsum))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (statuscnt == null) {
			if (other.statuscnt != null)
				return false;
		} else if (!statuscnt.equals(other.statuscnt))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RctFeeReport [status=" + status + ", statuscnt=" + statuscnt + ", amountsum=" + amountsum + "]";
	}
	
	
	


}
	
	
	
	
	
	
	

