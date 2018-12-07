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


/**
 * @author vsubramaniyan
 *
 */

@Entity(name = "fclass")
public class Fclass {
	public Fclass(Integer facId, String facClass, String facSubclassID, String facStatus, String clComments,
			String clUserid, Date clEntrytm) {
		super();
		this.facId = facId;
		this.facClass = facClass;
		this.facSubclassID = facSubclassID;
		this.facStatus = facStatus;
		this.clComments = clComments;
		this.clUserid = clUserid;
		this.clEntrytm = clEntrytm;
	}

	public Fclass(Integer classId, Integer facId, String facClass, String facSubclassID, String facStatus,
			String clComments, String clUserid, Date clEntrytm) {
		super();
		this.classId = classId;
		this.facId = facId;
		this.facClass = facClass;
		this.facSubclassID = facSubclassID;
		this.facStatus = facStatus;
		this.clComments = clComments;
		this.clUserid = clUserid;
		this.clEntrytm = clEntrytm;
	}

	public Fclass(){
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="class_id")
	private Integer classId;
	
	@Column(name="fac_id")
	private Integer facId;
	
	@Column(name="fac_class")
	private String facClass;
	
	@Column(name="fac_subclassID")
	private String facSubclassID;
	
	@Column(name="fac_status")
	private String facStatus;
	
	@Column(name="cl_comments")
	private String clComments;
	
	@Column(name="cl_userid")
	private String clUserid;
	
	@Column(name="cl_entrytm")
	private Date clEntrytm;

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
	 * @return the facId
	 */
	public Integer getFacId() {
		return facId;
	}

	/**
	 * @param facId the facId to set
	 */
	public void setFacId(Integer facId) {
		this.facId = facId;
	}

	/**
	 * @return the facClass
	 */
	public String getFacClass() {
		return facClass;
	}

	/**
	 * @param facClass the facClass to set
	 */
	public void setFacClass(String facClass) {
		this.facClass = facClass;
	}

	/**
	 * @return the facSubclassID
	 */
	public String getFacSubclassID() {
		return facSubclassID;
	}

	/**
	 * @param facSubclassID the facSubclassID to set
	 */
	public void setFacSubclassID(String facSubclassID) {
		this.facSubclassID = facSubclassID;
	}

	/**
	 * @return the facStatus
	 */
	public String getFacStatus() {
		return facStatus;
	}

	/**
	 * @param facStatus the facStatus to set
	 */
	public void setFacStatus(String facStatus) {
		this.facStatus = facStatus;
	}

	/**
	 * @return the clComments
	 */
	public String getClComments() {
		return clComments;
	}

	/**
	 * @param clComments the clComments to set
	 */
	public void setClComments(String clComments) {
		this.clComments = clComments;
	}

	/**
	 * @return the clUserid
	 */
	public String getClUserid() {
		return clUserid;
	}

	/**
	 * @param clUserid the clUserid to set
	 */
	public void setClUserid(String clUserid) {
		this.clUserid = clUserid;
	}

	/**
	 * @return the clEntrytm
	 */
	public Date getClEntrytm() {
		return clEntrytm;
	}

	/**
	 * @param clEntrytm the clEntrytm to set
	 */
	public void setClEntrytm(Date clEntrytm) {
		this.clEntrytm = clEntrytm;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clComments == null) ? 0 : clComments.hashCode());
		result = prime * result + ((clEntrytm == null) ? 0 : clEntrytm.hashCode());
		result = prime * result + ((clUserid == null) ? 0 : clUserid.hashCode());
		result = prime * result + ((classId == null) ? 0 : classId.hashCode());
		result = prime * result + ((facClass == null) ? 0 : facClass.hashCode());
		result = prime * result + ((facId == null) ? 0 : facId.hashCode());
		result = prime * result + ((facStatus == null) ? 0 : facStatus.hashCode());
		result = prime * result + ((facSubclassID == null) ? 0 : facSubclassID.hashCode());
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
		Fclass other = (Fclass) obj;
		if (clComments == null) {
			if (other.clComments != null)
				return false;
		} else if (!clComments.equals(other.clComments))
			return false;
		if (clEntrytm == null) {
			if (other.clEntrytm != null)
				return false;
		} else if (!clEntrytm.equals(other.clEntrytm))
			return false;
		if (clUserid == null) {
			if (other.clUserid != null)
				return false;
		} else if (!clUserid.equals(other.clUserid))
			return false;
		if (classId == null) {
			if (other.classId != null)
				return false;
		} else if (!classId.equals(other.classId))
			return false;
		if (facClass == null) {
			if (other.facClass != null)
				return false;
		} else if (!facClass.equals(other.facClass))
			return false;
		if (facId == null) {
			if (other.facId != null)
				return false;
		} else if (!facId.equals(other.facId))
			return false;
		if (facStatus == null) {
			if (other.facStatus != null)
				return false;
		} else if (!facStatus.equals(other.facStatus))
			return false;
		if (facSubclassID == null) {
			if (other.facSubclassID != null)
				return false;
		} else if (!facSubclassID.equals(other.facSubclassID))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Fclass [classId=" + classId + ", facId=" + facId + ", facClass=" + facClass + ", facSubclassID="
				+ facSubclassID + ", facStatus=" + facStatus + ", clComments=" + clComments + ", clUserid=" + clUserid
				+ ", clEntrytm=" + clEntrytm + "]";
	}

	
	
	
}
