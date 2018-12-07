/**
 * 
 */
package ma.dph.fpp.domain.facilities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author vsubramaniyan
 *
 */


//@NoArgsConstructor
//@AllArgsConstructor
@Entity(name = "v_Renewals")
public class RenewalsView {

	
	public RenewalsView(String catShort, Date dstart, Date dend, int totalsent, int secondsent, int thirdsent,
			String whosent1, String whosent2, String whosent3, Date run1st, Date run2nd, Date run3rd) {
		super();
		this.catShort = catShort;
		this.dstart = dstart;
		this.dend = dend;
		this.totalsent = totalsent;
		this.secondsent = secondsent;
		this.thirdsent = thirdsent;
		this.whosent1 = whosent1;
		this.whosent2 = whosent2;
		this.whosent3 = whosent3;
		this.run1st = run1st;
		this.run2nd = run2nd;
		this.run3rd = run3rd;
	}

	public RenewalsView(){
		
	}
	


	@Id
	@Column(name="cat_short")
	private String catShort;
	
	@Column(name="dstart")
	private Date dstart;
	
	@Column(name="dend")
	private Date dend;
	
	@Column(name="totalsent")
	private int  totalsent;
	
	@Column(name="secondsent")
	private int  secondsent;
	
	@Column(name="thirdsent")
	private int  thirdsent;
	
	@Column(name="whosent1	")
	private String whosent1;
	
	@Column(name="whosent2")
	private String whosent2;
	
	@Column(name="whosent3")
	private String whosent3;
	
	@Column(name="run_1st")
	private Date run1st;
	
	@Column(name="run_2nd")
	private Date run2nd;
	
	@Column(name="run_3rd")
	private Date run3rd;

	/**
	 * @return the catShort
	 */
	public String getCatShort() {
		return catShort;
	}

	/**
	 * @param catShort the catShort to set
	 */
	public void setCatShort(String catShort) {
		this.catShort = catShort;
	}

	/**
	 * @return the dstart
	 */
	public Date getDstart() {
		return dstart;
	}

	/**
	 * @param dstart the dstart to set
	 */
	public void setDstart(Date dstart) {
		this.dstart = dstart;
	}

	/**
	 * @return the dend
	 */
	public Date getDend() {
		return dend;
	}

	/**
	 * @param dend the dend to set
	 */
	public void setDend(Date dend) {
		this.dend = dend;
	}

	/**
	 * @return the totalsent
	 */
	public int getTotalsent() {
		return totalsent;
	}

	/**
	 * @param totalsent the totalsent to set
	 */
	public void setTotalsent(int totalsent) {
		this.totalsent = totalsent;
	}

	/**
	 * @return the secondsent
	 */
	public int getSecondsent() {
		return secondsent;
	}

	/**
	 * @param secondsent the secondsent to set
	 */
	public void setSecondsent(int secondsent) {
		this.secondsent = secondsent;
	}

	/**
	 * @return the thirdsent
	 */
	public int getThirdsent() {
		return thirdsent;
	}

	/**
	 * @param thirdsent the thirdsent to set
	 */
	public void setThirdsent(int thirdsent) {
		this.thirdsent = thirdsent;
	}

	/**
	 * @return the whosent1
	 */
	public String getWhosent1() {
		return whosent1;
	}

	/**
	 * @param whosent1 the whosent1 to set
	 */
	public void setWhosent1(String whosent1) {
		this.whosent1 = whosent1;
	}

	/**
	 * @return the whosent2
	 */
	public String getWhosent2() {
		return whosent2;
	}

	/**
	 * @param whosent2 the whosent2 to set
	 */
	public void setWhosent2(String whosent2) {
		this.whosent2 = whosent2;
	}

	/**
	 * @return the whosent3
	 */
	public String getWhosent3() {
		return whosent3;
	}

	/**
	 * @param whosent3 the whosent3 to set
	 */
	public void setWhosent3(String whosent3) {
		this.whosent3 = whosent3;
	}

	/**
	 * @return the run1st
	 */
	public Date getRun1st() {
		return run1st;
	}

	/**
	 * @param run1st the run1st to set
	 */
	public void setRun1st(Date run1st) {
		this.run1st = run1st;
	}

	/**
	 * @return the run2nd
	 */
	public Date getRun2nd() {
		return run2nd;
	}

	/**
	 * @param run2nd the run2nd to set
	 */
	public void setRun2nd(Date run2nd) {
		this.run2nd = run2nd;
	}

	/**
	 * @return the run3rd
	 */
	public Date getRun3rd() {
		return run3rd;
	}

	/**
	 * @param run3rd the run3rd to set
	 */
	public void setRun3rd(Date run3rd) {
		this.run3rd = run3rd;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((catShort == null) ? 0 : catShort.hashCode());
		result = prime * result + ((dend == null) ? 0 : dend.hashCode());
		result = prime * result + ((dstart == null) ? 0 : dstart.hashCode());
		result = prime * result + ((run1st == null) ? 0 : run1st.hashCode());
		result = prime * result + ((run2nd == null) ? 0 : run2nd.hashCode());
		result = prime * result + ((run3rd == null) ? 0 : run3rd.hashCode());
		result = prime * result + secondsent;
		result = prime * result + thirdsent;
		result = prime * result + totalsent;
		result = prime * result + ((whosent1 == null) ? 0 : whosent1.hashCode());
		result = prime * result + ((whosent2 == null) ? 0 : whosent2.hashCode());
		result = prime * result + ((whosent3 == null) ? 0 : whosent3.hashCode());
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
		RenewalsView other = (RenewalsView) obj;
		if (catShort == null) {
			if (other.catShort != null)
				return false;
		} else if (!catShort.equals(other.catShort))
			return false;
		if (dend == null) {
			if (other.dend != null)
				return false;
		} else if (!dend.equals(other.dend))
			return false;
		if (dstart == null) {
			if (other.dstart != null)
				return false;
		} else if (!dstart.equals(other.dstart))
			return false;
		if (run1st == null) {
			if (other.run1st != null)
				return false;
		} else if (!run1st.equals(other.run1st))
			return false;
		if (run2nd == null) {
			if (other.run2nd != null)
				return false;
		} else if (!run2nd.equals(other.run2nd))
			return false;
		if (run3rd == null) {
			if (other.run3rd != null)
				return false;
		} else if (!run3rd.equals(other.run3rd))
			return false;
		if (secondsent != other.secondsent)
			return false;
		if (thirdsent != other.thirdsent)
			return false;
		if (totalsent != other.totalsent)
			return false;
		if (whosent1 == null) {
			if (other.whosent1 != null)
				return false;
		} else if (!whosent1.equals(other.whosent1))
			return false;
		if (whosent2 == null) {
			if (other.whosent2 != null)
				return false;
		} else if (!whosent2.equals(other.whosent2))
			return false;
		if (whosent3 == null) {
			if (other.whosent3 != null)
				return false;
		} else if (!whosent3.equals(other.whosent3))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RenewalsView [catShort=" + catShort + ", dstart=" + dstart + ", dend=" + dend + ", totalsent="
				+ totalsent + ", secondsent=" + secondsent + ", thirdsent=" + thirdsent + ", whosent1=" + whosent1
				+ ", whosent2=" + whosent2 + ", whosent3=" + whosent3 + ", run1st=" + run1st + ", run2nd=" + run2nd
				+ ", run3rd=" + run3rd + "]";
	}


	
}
