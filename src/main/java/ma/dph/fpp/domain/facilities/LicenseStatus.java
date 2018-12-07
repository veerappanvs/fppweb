/**
 * 
 */
package ma.dph.fpp.domain.facilities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * @author vsubramaniyan
 *
 */
@Entity(name = "licstat")
public class LicenseStatus {

	public LicenseStatus(String statdesc, String shortdesc, String routine, String prvntmod, String isActive) {
		super();
		this.statdesc = statdesc;
		this.shortdesc = shortdesc;
		this.routine = routine;
		this.prvntmod = prvntmod;
		this.isActive = isActive;
	}

	/**
	 * 
	 */
	public LicenseStatus() {	
		// TODO Auto-generated constructor stub
	}
	
	
	@Id
	@Column(name = "statdesc")
	private String  statdesc;
	
	@Column(name = "shortdesc")
	private String  shortdesc;
	
	@Column(name = "routine")
	private String  routine;
	
	@Column(name = "prvntmod")
	private String  prvntmod;
	
	@Column(name = "is_active")
	private String  isActive;

	/**
	 * @return the statdesc
	 */
	public String getStatdesc() {
		return statdesc;
	}

	/**
	 * @param statdesc the statdesc to set
	 */
	public void setStatdesc(String statdesc) {
		this.statdesc = statdesc;
	}

	/**
	 * @return the shortdesc
	 */
	public String getShortdesc() {
		return shortdesc;
	}

	/**
	 * @param shortdesc the shortdesc to set
	 */
	public void setShortdesc(String shortdesc) {
		this.shortdesc = shortdesc;
	}

	/**
	 * @return the routine
	 */
	public String getRoutine() {
		return routine;
	}

	/**
	 * @param routine the routine to set
	 */
	public void setRoutine(String routine) {
		this.routine = routine;
	}

	/**
	 * @return the prvntmod
	 */
	public String getPrvntmod() {
		return prvntmod;
	}

	/**
	 * @param prvntmod the prvntmod to set
	 */
	public void setPrvntmod(String prvntmod) {
		this.prvntmod = prvntmod;
	}

	/**
	 * @return the isActive
	 */
	public String getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result + ((prvntmod == null) ? 0 : prvntmod.hashCode());
		result = prime * result + ((routine == null) ? 0 : routine.hashCode());
		result = prime * result + ((shortdesc == null) ? 0 : shortdesc.hashCode());
		result = prime * result + ((statdesc == null) ? 0 : statdesc.hashCode());
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
		LicenseStatus other = (LicenseStatus) obj;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		if (prvntmod == null) {
			if (other.prvntmod != null)
				return false;
		} else if (!prvntmod.equals(other.prvntmod))
			return false;
		if (routine == null) {
			if (other.routine != null)
				return false;
		} else if (!routine.equals(other.routine))
			return false;
		if (shortdesc == null) {
			if (other.shortdesc != null)
				return false;
		} else if (!shortdesc.equals(other.shortdesc))
			return false;
		if (statdesc == null) {
			if (other.statdesc != null)
				return false;
		} else if (!statdesc.equals(other.statdesc))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LicenseStatus [statdesc=" + statdesc + ", shortdesc=" + shortdesc + ", routine=" + routine
				+ ", prvntmod=" + prvntmod + ", isActive=" + isActive + "]";
	}

}
