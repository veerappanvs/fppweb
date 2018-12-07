package ma.dph.fpp.domain.generallicensing;

import java.util.List;
import java.util.ListIterator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "v_transmittal_reports")
public class TransmittalReport {

	public TransmittalReport(String dtreceive, String acctno, String checknum, String payer, String amount,
			String status) {
		super();
		this.dtreceive = dtreceive;
		this.acctno = acctno;
		this.checknum = checknum;
		this.payer = payer;
		this.amount = amount;
		this.status = status;
	}

	public TransmittalReport(String dtreceive, String acctno, String checknum, String payer, String amount,
			String status, String batchnum) {
		super();
		this.dtreceive = dtreceive;
		this.acctno = acctno;
		this.checknum = checknum;
		this.payer = payer;
		this.amount = amount;
		this.status = status;
		this.batchnum = batchnum;
	}

	public TransmittalReport(){}
	
	
	@Id
	@Column(name="batchnum")
	public String batchnum;
	
	@Column(name="dtreceive")
	public String dtreceive;
	
	@Column(name="acctno")
	public String  acctno;
	
	@Column(name="checknum")
	public String checknum;

	@Column(name="payer")
	public String payer;
	
	@Column(name="amount")
	public String amount;
	
	@Column(name="status")
	public String status;
	
	

	/**
	 * @return the dtreceive
	 */
	public String getDtreceive() {
		return dtreceive;
	}

	/**
	 * @param dtreceive the dtreceive to set
	 */
	public void setDtreceive(String dtreceive) {
		this.dtreceive = dtreceive;
	}

	/**
	 * @return the acctno
	 */
	public String getAcctno() {
		return acctno;
	}

	/**
	 * @param acctno the acctno to set
	 */
	public void setAcctno(String acctno) {
		this.acctno = acctno;
	}

	/**
	 * @return the checknum
	 */
	public String getChecknum() {
		return checknum;
	}

	/**
	 * @param checknum the checknum to set
	 */
	public void setChecknum(String checknum) {
		this.checknum = checknum;
	}

	/**
	 * @return the payer
	 */
	public String getPayer() {
		return payer;
	}

	/**
	 * @param payer the payer to set
	 */
	public void setPayer(String payer) {
		this.payer = payer;
	}

	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

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
	 * @return the batchnum
	 */
	public String getBatchnum() {
		return batchnum;
	}

	/**
	 * @param batchnum the batchnum to set
	 */
	public void setBatchnum(String batchnum) {
		this.batchnum = batchnum;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acctno == null) ? 0 : acctno.hashCode());
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((batchnum == null) ? 0 : batchnum.hashCode());
		result = prime * result + ((checknum == null) ? 0 : checknum.hashCode());
		result = prime * result + ((dtreceive == null) ? 0 : dtreceive.hashCode());
		result = prime * result + ((payer == null) ? 0 : payer.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		TransmittalReport other = (TransmittalReport) obj;
		if (acctno == null) {
			if (other.acctno != null)
				return false;
		} else if (!acctno.equals(other.acctno))
			return false;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (batchnum == null) {
			if (other.batchnum != null)
				return false;
		} else if (!batchnum.equals(other.batchnum))
			return false;
		if (checknum == null) {
			if (other.checknum != null)
				return false;
		} else if (!checknum.equals(other.checknum))
			return false;
		if (dtreceive == null) {
			if (other.dtreceive != null)
				return false;
		} else if (!dtreceive.equals(other.dtreceive))
			return false;
		if (payer == null) {
			if (other.payer != null)
				return false;
		} else if (!payer.equals(other.payer))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TrasmittalReport [dtreceive=" + dtreceive + ", acctno=" + acctno + ", checknum=" + checknum + ", payer="
				+ payer + ", amount=" + amount + ", status=" + status + ", batchnum=" + batchnum + "]";
	}
	
	
	
	
	
	
	
	
	

}
