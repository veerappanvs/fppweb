package ma.dph.fpp.domain.facilities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Get a clarity about the columns in this table
 * @author vsubramaniyan
 *
 */
@Entity(name = "facility")

public class Facilities {
	

	public Facilities(Integer corporationId, String facilityName, String facType, String facilityAddress1,
			String facilityAddress2, String facilityCity, String facilityState, String facilityZip, String facilityCNT,
			String facilityPhone, String facilityFax, String facilityFrontID, String facilityEmail,
			String facilityMailingAddressOne, String facilityMailingAddress2, String facilityMailingCity,
			String facilityMailingState, String facilityMailingZip, String facilityMailingLastName,
			String facilityMailingFirstName, String facilityMailingMiddleName, String facilityMailingSuffix,
			String facilityMailingTitle, String facilityStatus, String facilityComments, String facilityUserId,
			Date facilityEntryTime, String urn, String inspectionCompleted, Date inspectionCompletedDate,
			Integer foodProcesssorId, String phoneExt, String emergencyPhone, boolean isDefaultMailingAdd) {
		super();
		this.corporationId = corporationId;
		this.facilityName = facilityName;
		this.facType = facType;
		this.facilityAddress1 = facilityAddress1;
		this.facilityAddress2 = facilityAddress2;
		this.facilityCity = facilityCity;
		this.facilityState = facilityState;
		this.facilityZip = facilityZip;
		this.facilityCNT = facilityCNT;
		this.facilityPhone = facilityPhone;
		this.facilityFax = facilityFax;
		this.facilityFrontID = facilityFrontID;
		this.facilityEmail = facilityEmail;
		this.facilityMailingAddressOne = facilityMailingAddressOne;
		this.facilityMailingAddress2 = facilityMailingAddress2;
		this.facilityMailingCity = facilityMailingCity;
		this.facilityMailingState = facilityMailingState;
		this.facilityMailingZip = facilityMailingZip;
		this.facilityMailingLastName = facilityMailingLastName;
		this.facilityMailingFirstName = facilityMailingFirstName;
		this.facilityMailingMiddleName = facilityMailingMiddleName;
		this.facilityMailingSuffix = facilityMailingSuffix;
		this.facilityMailingTitle = facilityMailingTitle;
		this.facilityStatus = facilityStatus;
		this.facilityComments = facilityComments;
		this.facilityUserId = facilityUserId;
		this.facilityEntryTime = facilityEntryTime;
		this.urn = urn;
		this.inspectionCompleted = inspectionCompleted;
		this.inspectionCompletedDate = inspectionCompletedDate;
		this.foodProcesssorId = foodProcesssorId;
		this.phoneExt = phoneExt;
		this.emergencyPhone = emergencyPhone;
		this.isDefaultMailingAdd = isDefaultMailingAdd;
	}

	public Facilities(Integer corporationId, Integer id, String facilityName, String facType, String facilityAddress1,
			String facilityAddress2, String facilityCity, String facilityState, String facilityZip, String facilityCNT,
			String facilityPhone, String facilityFax, String facilityFrontID, String facilityEmail,
			String facilityMailingAddressOne, String facilityMailingAddress2, String facilityMailingCity,
			String facilityMailingState, String facilityMailingZip, String facilityMailingLastName,
			String facilityMailingFirstName, String facilityMailingMiddleName, String facilityMailingSuffix,
			String facilityMailingTitle, String facilityStatus, String facilityComments, String facilityUserId,
			Date facilityEntryTime, String urn, String inspectionCompleted, Date inspectionCompletedDate,
			Integer foodProcesssorId, String phoneExt, String emergencyPhone, boolean isDefaultMailingAdd) {
		super();
		this.corporationId = corporationId;
		this.id = id;
		this.facilityName = facilityName;
		this.facType = facType;
		this.facilityAddress1 = facilityAddress1;
		this.facilityAddress2 = facilityAddress2;
		this.facilityCity = facilityCity;
		this.facilityState = facilityState;
		this.facilityZip = facilityZip;
		this.facilityCNT = facilityCNT;
		this.facilityPhone = facilityPhone;
		this.facilityFax = facilityFax;
		this.facilityFrontID = facilityFrontID;
		this.facilityEmail = facilityEmail;
		this.facilityMailingAddressOne = facilityMailingAddressOne;
		this.facilityMailingAddress2 = facilityMailingAddress2;
		this.facilityMailingCity = facilityMailingCity;
		this.facilityMailingState = facilityMailingState;
		this.facilityMailingZip = facilityMailingZip;
		this.facilityMailingLastName = facilityMailingLastName;
		this.facilityMailingFirstName = facilityMailingFirstName;
		this.facilityMailingMiddleName = facilityMailingMiddleName;
		this.facilityMailingSuffix = facilityMailingSuffix;
		this.facilityMailingTitle = facilityMailingTitle;
		this.facilityStatus = facilityStatus;
		this.facilityComments = facilityComments;
		this.facilityUserId = facilityUserId;
		this.facilityEntryTime = facilityEntryTime;
		this.urn = urn;
		this.inspectionCompleted = inspectionCompleted;
		this.inspectionCompletedDate = inspectionCompletedDate;
		this.foodProcesssorId = foodProcesssorId;
		this.phoneExt = phoneExt;
		this.emergencyPhone = emergencyPhone;
		this.isDefaultMailingAdd = isDefaultMailingAdd;
	}

	public Facilities(){}
	
	
	@Column(name = "corp_id", nullable=true)
	private Integer corporationId;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "fac_id", nullable=true)
	private Integer id;

	@Column(name = "fac_name", nullable=true)
	private String facilityName;

	@Column(name = "fac_type", nullable=true)
	private String facType;

	@Column(name = "fac_add1", nullable=true)
	private String facilityAddress1;

	@Column(name = "fac_add2", nullable=true)
	private String facilityAddress2;

	@Column(name = "fac_city", nullable=true)
	private String facilityCity;

	@Column(name = "fac_state", nullable=true)
	private String facilityState;

	@Column(name = "fac_zip", nullable=true)
	private String facilityZip;

	@Column(name = "fac_cnt", nullable=true)
	private String facilityCNT;

	@Column(name = "fac_phone", nullable=true)
	private String facilityPhone;


	@Column(name = "fac_fax", nullable=true)
	private String facilityFax;

	@Column(name = "fac_fid", nullable=true)
	private String facilityFrontID;

	@Column(name = "fac_email", nullable=true)
	private String facilityEmail;

	@Column(name = "fac_madd1", nullable=true)
	private String facilityMailingAddressOne;

	@Column(name = "fac_madd2", nullable=true)
	private String facilityMailingAddress2;

	@Column(name = "fac_mcity", nullable=true)
	private String facilityMailingCity;

	@Column(name = "fac_mstate", nullable=true)
	private String facilityMailingState;

	@Column(name = "fac_mzip", nullable=true)
	private String facilityMailingZip;

	@Column(name = "f_last", nullable=true)
	private String facilityMailingLastName;

	@Column(name = "f_first", nullable=true)
	private String facilityMailingFirstName;

	@Column(name = "f_middle", nullable=true)
	private String facilityMailingMiddleName;

	@Column(name = "f_suffix", nullable=true)
	private String facilityMailingSuffix;

	@Column(name = "f_title", nullable=true)
	private String facilityMailingTitle;

	@Column(name = "f_status", nullable=true)
	private String facilityStatus;

	@Column(name = "f_comments", nullable=true)
	private String facilityComments;

	@Column(name = "f_userid", nullable=true)
	private String facilityUserId;

	@Column(name = "f_entrytm", nullable=true)
	private Date facilityEntryTime;
	
	@Column(name = "URN", nullable=true)
	private String urn;
	
	@Column(name = "inspection_completed", nullable=true)
	private String inspectionCompleted;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM-dd-yyyy" )	
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd" )
	@Column(name = "inspection_completed_date", nullable=true)
	//@Column(name = "inspection_date", nullable=true)
	private Date inspectionCompletedDate;
	
	@Column(name = "food_processsor_id", nullable=true)
	private Integer foodProcesssorId;
	
	@Column(name = "phone_ext", nullable=true)
	private String phoneExt;
	
	@Column(name = "emergency_phone", nullable=true)
	private String emergencyPhone;
	
	@Column(name = "is_default_mailing_add", nullable=true)
	private boolean isDefaultMailingAdd;

	/**
	 * @return the corporationId
	 */
	public Integer getCorporationId() {
		return corporationId;
	}

	/**
	 * @param corporationId the corporationId to set
	 */
	public void setCorporationId(Integer corporationId) {
		this.corporationId = corporationId;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the facilityName
	 */
	public String getFacilityName() {
		return facilityName;
	}

	/**
	 * @param facilityName the facilityName to set
	 */
	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	/**
	 * @return the facType
	 */
	public String getFacType() {
		return facType;
	}

	/**
	 * @param facType the facType to set
	 */
	public void setFacType(String facType) {
		this.facType = facType;
	}

	/**
	 * @return the facilityAddress1
	 */
	public String getFacilityAddress1() {
		return facilityAddress1;
	}

	/**
	 * @param facilityAddress1 the facilityAddress1 to set
	 */
	public void setFacilityAddress1(String facilityAddress1) {
		this.facilityAddress1 = facilityAddress1;
	}

	/**
	 * @return the facilityAddress2
	 */
	public String getFacilityAddress2() {
		return facilityAddress2;
	}

	/**
	 * @param facilityAddress2 the facilityAddress2 to set
	 */
	public void setFacilityAddress2(String facilityAddress2) {
		this.facilityAddress2 = facilityAddress2;
	}

	/**
	 * @return the facilityCity
	 */
	public String getFacilityCity() {
		return facilityCity;
	}

	/**
	 * @param facilityCity the facilityCity to set
	 */
	public void setFacilityCity(String facilityCity) {
		this.facilityCity = facilityCity;
	}

	/**
	 * @return the facilityState
	 */
	public String getFacilityState() {
		return facilityState;
	}

	/**
	 * @param facilityState the facilityState to set
	 */
	public void setFacilityState(String facilityState) {
		this.facilityState = facilityState;
	}

	/**
	 * @return the facilityZip
	 */
	public String getFacilityZip() {
		return facilityZip;
	}

	/**
	 * @param facilityZip the facilityZip to set
	 */
	public void setFacilityZip(String facilityZip) {
		this.facilityZip = facilityZip;
	}

	/**
	 * @return the facilityCNT
	 */
	public String getFacilityCNT() {
		return facilityCNT;
	}

	/**
	 * @param facilityCNT the facilityCNT to set
	 */
	public void setFacilityCNT(String facilityCNT) {
		this.facilityCNT = facilityCNT;
	}

	/**
	 * @return the facilityPhone
	 */
	public String getFacilityPhone() {
		return facilityPhone;
	}

	/**
	 * @param facilityPhone the facilityPhone to set
	 */
	public void setFacilityPhone(String facilityPhone) {
		this.facilityPhone = facilityPhone;
	}

	/**
	 * @return the facilityFax
	 */
	public String getFacilityFax() {
		return facilityFax;
	}

	/**
	 * @param facilityFax the facilityFax to set
	 */
	public void setFacilityFax(String facilityFax) {
		this.facilityFax = facilityFax;
	}

	/**
	 * @return the facilityFrontID
	 */
	public String getFacilityFrontID() {
		return facilityFrontID;
	}

	/**
	 * @param facilityFrontID the facilityFrontID to set
	 */
	public void setFacilityFrontID(String facilityFrontID) {
		this.facilityFrontID = facilityFrontID;
	}

	/**
	 * @return the facilityEmail
	 */
	public String getFacilityEmail() {
		return facilityEmail;
	}

	/**
	 * @param facilityEmail the facilityEmail to set
	 */
	public void setFacilityEmail(String facilityEmail) {
		this.facilityEmail = facilityEmail;
	}

	/**
	 * @return the facilityMailingAddressOne
	 */
	public String getFacilityMailingAddressOne() {
		return facilityMailingAddressOne;
	}

	/**
	 * @param facilityMailingAddressOne the facilityMailingAddressOne to set
	 */
	public void setFacilityMailingAddressOne(String facilityMailingAddressOne) {
		this.facilityMailingAddressOne = facilityMailingAddressOne;
	}

	/**
	 * @return the facilityMailingAddress2
	 */
	public String getFacilityMailingAddress2() {
		return facilityMailingAddress2;
	}

	/**
	 * @param facilityMailingAddress2 the facilityMailingAddress2 to set
	 */
	public void setFacilityMailingAddress2(String facilityMailingAddress2) {
		this.facilityMailingAddress2 = facilityMailingAddress2;
	}

	/**
	 * @return the facilityMailingCity
	 */
	public String getFacilityMailingCity() {
		return facilityMailingCity;
	}

	/**
	 * @param facilityMailingCity the facilityMailingCity to set
	 */
	public void setFacilityMailingCity(String facilityMailingCity) {
		this.facilityMailingCity = facilityMailingCity;
	}

	/**
	 * @return the facilityMailingState
	 */
	public String getFacilityMailingState() {
		return facilityMailingState;
	}

	/**
	 * @param facilityMailingState the facilityMailingState to set
	 */
	public void setFacilityMailingState(String facilityMailingState) {
		this.facilityMailingState = facilityMailingState;
	}

	/**
	 * @return the facilityMailingZip
	 */
	public String getFacilityMailingZip() {
		return facilityMailingZip;
	}

	/**
	 * @param facilityMailingZip the facilityMailingZip to set
	 */
	public void setFacilityMailingZip(String facilityMailingZip) {
		this.facilityMailingZip = facilityMailingZip;
	}

	/**
	 * @return the facilityMailingLastName
	 */
	public String getFacilityMailingLastName() {
		return facilityMailingLastName;
	}

	/**
	 * @param facilityMailingLastName the facilityMailingLastName to set
	 */
	public void setFacilityMailingLastName(String facilityMailingLastName) {
		this.facilityMailingLastName = facilityMailingLastName;
	}

	/**
	 * @return the facilityMailingFirstName
	 */
	public String getFacilityMailingFirstName() {
		return facilityMailingFirstName;
	}

	/**
	 * @param facilityMailingFirstName the facilityMailingFirstName to set
	 */
	public void setFacilityMailingFirstName(String facilityMailingFirstName) {
		this.facilityMailingFirstName = facilityMailingFirstName;
	}

	/**
	 * @return the facilityMailingMiddleName
	 */
	public String getFacilityMailingMiddleName() {
		return facilityMailingMiddleName;
	}

	/**
	 * @param facilityMailingMiddleName the facilityMailingMiddleName to set
	 */
	public void setFacilityMailingMiddleName(String facilityMailingMiddleName) {
		this.facilityMailingMiddleName = facilityMailingMiddleName;
	}

	/**
	 * @return the facilityMailingSuffix
	 */
	public String getFacilityMailingSuffix() {
		return facilityMailingSuffix;
	}

	/**
	 * @param facilityMailingSuffix the facilityMailingSuffix to set
	 */
	public void setFacilityMailingSuffix(String facilityMailingSuffix) {
		this.facilityMailingSuffix = facilityMailingSuffix;
	}

	/**
	 * @return the facilityMailingTitle
	 */
	public String getFacilityMailingTitle() {
		return facilityMailingTitle;
	}

	/**
	 * @param facilityMailingTitle the facilityMailingTitle to set
	 */
	public void setFacilityMailingTitle(String facilityMailingTitle) {
		this.facilityMailingTitle = facilityMailingTitle;
	}

	/**
	 * @return the facilityStatus
	 */
	public String getFacilityStatus() {
		return facilityStatus;
	}

	/**
	 * @param facilityStatus the facilityStatus to set
	 */
	public void setFacilityStatus(String facilityStatus) {
		this.facilityStatus = facilityStatus;
	}

	/**
	 * @return the facilityComments
	 */
	public String getFacilityComments() {
		return facilityComments;
	}

	/**
	 * @param facilityComments the facilityComments to set
	 */
	public void setFacilityComments(String facilityComments) {
		this.facilityComments = facilityComments;
	}

	/**
	 * @return the facilityUserId
	 */
	public String getFacilityUserId() {
		return facilityUserId;
	}

	/**
	 * @param facilityUserId the facilityUserId to set
	 */
	public void setFacilityUserId(String facilityUserId) {
		this.facilityUserId = facilityUserId;
	}

	/**
	 * @return the facilityEntryTime
	 */
	public Date getFacilityEntryTime() {
		return facilityEntryTime;
	}

	/**
	 * @param facilityEntryTime the facilityEntryTime to set
	 */
	public void setFacilityEntryTime(Date facilityEntryTime) {
		this.facilityEntryTime = facilityEntryTime;
	}

	/**
	 * @return the urn
	 */
	public String getUrn() {
		return urn;
	}

	/**
	 * @param urn the urn to set
	 */
	public void setUrn(String urn) {
		this.urn = urn;
	}

	/**
	 * @return the inspectionCompleted
	 */
	public String getInspectionCompleted() {
		return inspectionCompleted;
	}

	/**
	 * @param inspectionCompleted the inspectionCompleted to set
	 */
	public void setInspectionCompleted(String inspectionCompleted) {
		this.inspectionCompleted = inspectionCompleted;
	}

	/**
	 * @return the inspectionCompletedDate
	 */
	public Date getInspectionCompletedDate() {
		return inspectionCompletedDate;
	}

	/**
	 * @param inspectionCompletedDate the inspectionCompletedDate to set
	 */
	public void setInspectionCompletedDate(Date inspectionCompletedDate) {
		this.inspectionCompletedDate = inspectionCompletedDate;
	}

	/**
	 * @return the foodProcesssorId
	 */
	public Integer getFoodProcesssorId() {
		return foodProcesssorId;
	}

	/**
	 * @param foodProcesssorId the foodProcesssorId to set
	 */
	public void setFoodProcesssorId(Integer foodProcesssorId) {
		this.foodProcesssorId = foodProcesssorId;
	}

	/**
	 * @return the phoneExt
	 */
	public String getPhoneExt() {
		return phoneExt;
	}

	/**
	 * @param phoneExt the phoneExt to set
	 */
	public void setPhoneExt(String phoneExt) {
		this.phoneExt = phoneExt;
	}

	/**
	 * @return the emergencyPhone
	 */
	public String getEmergencyPhone() {
		return emergencyPhone;
	}

	/**
	 * @param emergencyPhone the emergencyPhone to set
	 */
	public void setEmergencyPhone(String emergencyPhone) {
		this.emergencyPhone = emergencyPhone;
	}

	/**
	 * @return the isDefaultMailingAdd
	 */
	public boolean isDefaultMailingAdd() {
		return isDefaultMailingAdd;
	}

	/**
	 * @param isDefaultMailingAdd the isDefaultMailingAdd to set
	 */
	public void setDefaultMailingAdd(boolean isDefaultMailingAdd) {
		this.isDefaultMailingAdd = isDefaultMailingAdd;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((corporationId == null) ? 0 : corporationId.hashCode());
		result = prime * result + ((emergencyPhone == null) ? 0 : emergencyPhone.hashCode());
		result = prime * result + ((facType == null) ? 0 : facType.hashCode());
		result = prime * result + ((facilityAddress1 == null) ? 0 : facilityAddress1.hashCode());
		result = prime * result + ((facilityAddress2 == null) ? 0 : facilityAddress2.hashCode());
		result = prime * result + ((facilityCNT == null) ? 0 : facilityCNT.hashCode());
		result = prime * result + ((facilityCity == null) ? 0 : facilityCity.hashCode());
		result = prime * result + ((facilityComments == null) ? 0 : facilityComments.hashCode());
		result = prime * result + ((facilityEmail == null) ? 0 : facilityEmail.hashCode());
		result = prime * result + ((facilityEntryTime == null) ? 0 : facilityEntryTime.hashCode());
		result = prime * result + ((facilityFax == null) ? 0 : facilityFax.hashCode());
		result = prime * result + ((facilityFrontID == null) ? 0 : facilityFrontID.hashCode());
		result = prime * result + ((facilityMailingAddress2 == null) ? 0 : facilityMailingAddress2.hashCode());
		result = prime * result + ((facilityMailingAddressOne == null) ? 0 : facilityMailingAddressOne.hashCode());
		result = prime * result + ((facilityMailingCity == null) ? 0 : facilityMailingCity.hashCode());
		result = prime * result + ((facilityMailingFirstName == null) ? 0 : facilityMailingFirstName.hashCode());
		result = prime * result + ((facilityMailingLastName == null) ? 0 : facilityMailingLastName.hashCode());
		result = prime * result + ((facilityMailingMiddleName == null) ? 0 : facilityMailingMiddleName.hashCode());
		result = prime * result + ((facilityMailingState == null) ? 0 : facilityMailingState.hashCode());
		result = prime * result + ((facilityMailingSuffix == null) ? 0 : facilityMailingSuffix.hashCode());
		result = prime * result + ((facilityMailingTitle == null) ? 0 : facilityMailingTitle.hashCode());
		result = prime * result + ((facilityMailingZip == null) ? 0 : facilityMailingZip.hashCode());
		result = prime * result + ((facilityName == null) ? 0 : facilityName.hashCode());
		result = prime * result + ((facilityPhone == null) ? 0 : facilityPhone.hashCode());
		result = prime * result + ((facilityState == null) ? 0 : facilityState.hashCode());
		result = prime * result + ((facilityStatus == null) ? 0 : facilityStatus.hashCode());
		result = prime * result + ((facilityUserId == null) ? 0 : facilityUserId.hashCode());
		result = prime * result + ((facilityZip == null) ? 0 : facilityZip.hashCode());
		result = prime * result + ((foodProcesssorId == null) ? 0 : foodProcesssorId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((inspectionCompleted == null) ? 0 : inspectionCompleted.hashCode());
		result = prime * result + ((inspectionCompletedDate == null) ? 0 : inspectionCompletedDate.hashCode());
		result = prime * result + (isDefaultMailingAdd ? 1231 : 1237);
		result = prime * result + ((phoneExt == null) ? 0 : phoneExt.hashCode());
		result = prime * result + ((urn == null) ? 0 : urn.hashCode());
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
		Facilities other = (Facilities) obj;
		if (corporationId == null) {
			if (other.corporationId != null)
				return false;
		} else if (!corporationId.equals(other.corporationId))
			return false;
		if (emergencyPhone == null) {
			if (other.emergencyPhone != null)
				return false;
		} else if (!emergencyPhone.equals(other.emergencyPhone))
			return false;
		if (facType == null) {
			if (other.facType != null)
				return false;
		} else if (!facType.equals(other.facType))
			return false;
		if (facilityAddress1 == null) {
			if (other.facilityAddress1 != null)
				return false;
		} else if (!facilityAddress1.equals(other.facilityAddress1))
			return false;
		if (facilityAddress2 == null) {
			if (other.facilityAddress2 != null)
				return false;
		} else if (!facilityAddress2.equals(other.facilityAddress2))
			return false;
		if (facilityCNT == null) {
			if (other.facilityCNT != null)
				return false;
		} else if (!facilityCNT.equals(other.facilityCNT))
			return false;
		if (facilityCity == null) {
			if (other.facilityCity != null)
				return false;
		} else if (!facilityCity.equals(other.facilityCity))
			return false;
		if (facilityComments == null) {
			if (other.facilityComments != null)
				return false;
		} else if (!facilityComments.equals(other.facilityComments))
			return false;
		if (facilityEmail == null) {
			if (other.facilityEmail != null)
				return false;
		} else if (!facilityEmail.equals(other.facilityEmail))
			return false;
		if (facilityEntryTime == null) {
			if (other.facilityEntryTime != null)
				return false;
		} else if (!facilityEntryTime.equals(other.facilityEntryTime))
			return false;
		if (facilityFax == null) {
			if (other.facilityFax != null)
				return false;
		} else if (!facilityFax.equals(other.facilityFax))
			return false;
		if (facilityFrontID == null) {
			if (other.facilityFrontID != null)
				return false;
		} else if (!facilityFrontID.equals(other.facilityFrontID))
			return false;
		if (facilityMailingAddress2 == null) {
			if (other.facilityMailingAddress2 != null)
				return false;
		} else if (!facilityMailingAddress2.equals(other.facilityMailingAddress2))
			return false;
		if (facilityMailingAddressOne == null) {
			if (other.facilityMailingAddressOne != null)
				return false;
		} else if (!facilityMailingAddressOne.equals(other.facilityMailingAddressOne))
			return false;
		if (facilityMailingCity == null) {
			if (other.facilityMailingCity != null)
				return false;
		} else if (!facilityMailingCity.equals(other.facilityMailingCity))
			return false;
		if (facilityMailingFirstName == null) {
			if (other.facilityMailingFirstName != null)
				return false;
		} else if (!facilityMailingFirstName.equals(other.facilityMailingFirstName))
			return false;
		if (facilityMailingLastName == null) {
			if (other.facilityMailingLastName != null)
				return false;
		} else if (!facilityMailingLastName.equals(other.facilityMailingLastName))
			return false;
		if (facilityMailingMiddleName == null) {
			if (other.facilityMailingMiddleName != null)
				return false;
		} else if (!facilityMailingMiddleName.equals(other.facilityMailingMiddleName))
			return false;
		if (facilityMailingState == null) {
			if (other.facilityMailingState != null)
				return false;
		} else if (!facilityMailingState.equals(other.facilityMailingState))
			return false;
		if (facilityMailingSuffix == null) {
			if (other.facilityMailingSuffix != null)
				return false;
		} else if (!facilityMailingSuffix.equals(other.facilityMailingSuffix))
			return false;
		if (facilityMailingTitle == null) {
			if (other.facilityMailingTitle != null)
				return false;
		} else if (!facilityMailingTitle.equals(other.facilityMailingTitle))
			return false;
		if (facilityMailingZip == null) {
			if (other.facilityMailingZip != null)
				return false;
		} else if (!facilityMailingZip.equals(other.facilityMailingZip))
			return false;
		if (facilityName == null) {
			if (other.facilityName != null)
				return false;
		} else if (!facilityName.equals(other.facilityName))
			return false;
		if (facilityPhone == null) {
			if (other.facilityPhone != null)
				return false;
		} else if (!facilityPhone.equals(other.facilityPhone))
			return false;
		if (facilityState == null) {
			if (other.facilityState != null)
				return false;
		} else if (!facilityState.equals(other.facilityState))
			return false;
		if (facilityStatus == null) {
			if (other.facilityStatus != null)
				return false;
		} else if (!facilityStatus.equals(other.facilityStatus))
			return false;
		if (facilityUserId == null) {
			if (other.facilityUserId != null)
				return false;
		} else if (!facilityUserId.equals(other.facilityUserId))
			return false;
		if (facilityZip == null) {
			if (other.facilityZip != null)
				return false;
		} else if (!facilityZip.equals(other.facilityZip))
			return false;
		if (foodProcesssorId == null) {
			if (other.foodProcesssorId != null)
				return false;
		} else if (!foodProcesssorId.equals(other.foodProcesssorId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inspectionCompleted == null) {
			if (other.inspectionCompleted != null)
				return false;
		} else if (!inspectionCompleted.equals(other.inspectionCompleted))
			return false;
		if (inspectionCompletedDate == null) {
			if (other.inspectionCompletedDate != null)
				return false;
		} else if (!inspectionCompletedDate.equals(other.inspectionCompletedDate))
			return false;
		if (isDefaultMailingAdd != other.isDefaultMailingAdd)
			return false;
		if (phoneExt == null) {
			if (other.phoneExt != null)
				return false;
		} else if (!phoneExt.equals(other.phoneExt))
			return false;
		if (urn == null) {
			if (other.urn != null)
				return false;
		} else if (!urn.equals(other.urn))
			return false;
		return true;
	}

	
}
