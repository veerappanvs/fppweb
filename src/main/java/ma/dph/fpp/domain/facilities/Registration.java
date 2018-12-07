/**
 * 
 */
package ma.dph.fpp.domain.facilities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * @author vsubramaniyan
 *
 */
@Entity(name = "registrs")
public class Registration {
	


	public Registration(Integer classId, String regType, String regLicense, Date dateIssue, Date dateExpire,
			String regStatus, String rUserid, Date rEntrytm) {
		super();
		this.classId = classId;
		this.regType = regType;
		this.regLicense = regLicense;
		this.dateIssue = dateIssue;
		this.dateExpire = dateExpire;
		this.regStatus = regStatus;
		this.rUserid = rUserid;
		this.rEntrytm = rEntrytm;
	}

	public Registration(Integer regId, Integer classId, String regType, String regLicense, Date dateIssue,
			Date dateExpire, String regStatus, String rUserid, Date rEntrytm) {
		super();
		this.regId = regId;
		this.classId = classId;
		this.regType = regType;
		this.regLicense = regLicense;
		this.dateIssue = dateIssue;
		this.dateExpire = dateExpire;
		this.regStatus = regStatus;
		this.rUserid = rUserid;
		this.rEntrytm = rEntrytm;
	}

	Registration(){}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "reg_id", nullable=false)
	private Integer regId;
	
	@Column(name = "class_id", nullable=true)
	private Integer classId;
	
	@Column(name = "reg_type", nullable=true)
	private String regType;
	
	@Column(name = "reg_license", nullable=true)
	private String regLicense;
	
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM-dd-yyyy" )	
	@Column(name = "date_issue", nullable=true)
	private Date dateIssue;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM-dd-yyyy" )	
	@Column(name = "date_expire", nullable=true)
	private Date dateExpire;
	
	@Column(name = "reg_status", nullable=true)
	private String regStatus;
	
	@Column(name = "r_userid", nullable=true)
	private String rUserid;
	
	@Column(name = "r_entrytm", nullable=true)
	private Date rEntrytm;

	/**
	 * @return the regId
	 */
	public Integer getRegId() {
		return regId;
	}

	/**
	 * @param regId the regId to set
	 */
	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	/**
	 * @return the classId
	 */
	public Integer getClassId() {
		return classId;
	}

	/**
	 * @param classId the classId to set
	 */
	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	/**
	 * @return the regType
	 */
	public String getRegType() {
		return regType;
	}

	/**
	 * @param regType the regType to set
	 */
	public void setRegType(String regType) {
		this.regType = regType;
	}

	/**
	 * @return the regLicense
	 */
	public String getRegLicense() {
		return regLicense;
	}

	/**
	 * @param regLicense the regLicense to set
	 */
	public void setRegLicense(String regLicense) {
		this.regLicense = regLicense;
	}

	/**
	 * @return the dateIssue
	 */
	public Date getDateIssue() {
		return dateIssue;
	}

	/**
	 * @param dateIssue the dateIssue to set
	 */
	public void setDateIssue(Date dateIssue) {
		this.dateIssue = dateIssue;
	}

	/**
	 * @return the dateExpire
	 */
	public Date getDateExpire() {
		return dateExpire;
	}

	/**
	 * @param dateExpire the dateExpire to set
	 */
	public void setDateExpire(Date dateExpire) {
		this.dateExpire = dateExpire;
	}

	/**
	 * @return the regStatus
	 */
	public String getRegStatus() {
		return regStatus;
	}

	/**
	 * @param regStatus the regStatus to set
	 */
	public void setRegStatus(String regStatus) {
		this.regStatus = regStatus;
	}

	/**
	 * @return the rUserid
	 */
	public String getrUserid() {
		return rUserid;
	}

	/**
	 * @param rUserid the rUserid to set
	 */
	public void setrUserid(String rUserid) {
		this.rUserid = rUserid;
	}

	/**
	 * @return the rEntrytm
	 */
	public Date getrEntrytm() {
		return rEntrytm;
	}

	/**
	 * @param rEntrytm the rEntrytm to set
	 */
	public void setrEntrytm(Date rEntrytm) {
		this.rEntrytm = rEntrytm;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classId == null) ? 0 : classId.hashCode());
		result = prime * result + ((dateExpire == null) ? 0 : dateExpire.hashCode());
		result = prime * result + ((dateIssue == null) ? 0 : dateIssue.hashCode());
		result = prime * result + ((rEntrytm == null) ? 0 : rEntrytm.hashCode());
		result = prime * result + ((rUserid == null) ? 0 : rUserid.hashCode());
		result = prime * result + ((regId == null) ? 0 : regId.hashCode());
		result = prime * result + ((regLicense == null) ? 0 : regLicense.hashCode());
		result = prime * result + ((regStatus == null) ? 0 : regStatus.hashCode());
		result = prime * result + ((regType == null) ? 0 : regType.hashCode());
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
		Registration other = (Registration) obj;
		if (classId == null) {
			if (other.classId != null)
				return false;
		} else if (!classId.equals(other.classId))
			return false;
		if (dateExpire == null) {
			if (other.dateExpire != null)
				return false;
		} else if (!dateExpire.equals(other.dateExpire))
			return false;
		if (dateIssue == null) {
			if (other.dateIssue != null)
				return false;
		} else if (!dateIssue.equals(other.dateIssue))
			return false;
		if (rEntrytm == null) {
			if (other.rEntrytm != null)
				return false;
		} else if (!rEntrytm.equals(other.rEntrytm))
			return false;
		if (rUserid == null) {
			if (other.rUserid != null)
				return false;
		} else if (!rUserid.equals(other.rUserid))
			return false;
		if (regId == null) {
			if (other.regId != null)
				return false;
		} else if (!regId.equals(other.regId))
			return false;
		if (regLicense == null) {
			if (other.regLicense != null)
				return false;
		} else if (!regLicense.equals(other.regLicense))
			return false;
		if (regStatus == null) {
			if (other.regStatus != null)
				return false;
		} else if (!regStatus.equals(other.regStatus))
			return false;
		if (regType == null) {
			if (other.regType != null)
				return false;
		} else if (!regType.equals(other.regType))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Registration [regId=" + regId + ", classId=" + classId + ", regType=" + regType + ", regLicense="
				+ regLicense + ", dateIssue=" + dateIssue + ", dateExpire=" + dateExpire + ", regStatus=" + regStatus
				+ ", rUserid=" + rUserid + ", rEntrytm=" + rEntrytm + "]";
	}


}
