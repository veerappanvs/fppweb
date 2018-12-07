package ma.dph.fpp.domain.generallicensing;

import java.util.List;
import java.util.ListIterator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "v_fiscal_reports")
public class FiscalReport {

	public FiscalReport(String mnt, String count, String amountsum) {
		super();
		this.mnt = mnt;
		this.count = count;
		this.amountsum = amountsum;
	}

	/*public FiscalReport(String acctname, String mnt, String count, String amountsum) {
		super();
		this.acctname = acctname;
		this.mnt = mnt;
		this.count = count;
		this.amountsum = amountsum;
	}

*/	public FiscalReport(){}
	
	
	/*@Id
	@Column(name="acctname")
	public String acctname;
	*/
	
	@Id
	@Column(name="mnt")
	public String  mnt;
	
	@Column(name="count")
	public String count;
	
	@Column(name="amountsum")
	public String amountsum;

	/**
	 * @return the acctname
	 *//*
	public String getAcctname() {
		return acctname;
	}

	*//**
	 * @param acctname the acctname to set
	 *//*
	public void setAcctname(String acctname) {
		this.acctname = acctname;
	}
*/
	/**
	 * @return the mnt
	 */
	public String getMnt() {
		return mnt;
	}

	/**
	 * @param mnt the mnt to set
	 */
	public void setMnt(String mnt) {
		this.mnt = mnt;
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
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((mnt == null) ? 0 : mnt.hashCode());
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
		FiscalReport other = (FiscalReport) obj;
		if (amountsum == null) {
			if (other.amountsum != null)
				return false;
		} else if (!amountsum.equals(other.amountsum))
			return false;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (mnt == null) {
			if (other.mnt != null)
				return false;
		} else if (!mnt.equals(other.mnt))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FiscalReport [" +   " mnt=" + mnt + ", count=" + count + ", amountsum=" + amountsum
				+ "]";
	}




}
