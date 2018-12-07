package ma.dph.fpp.domain.facilities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name = "v_Facsearch")
public class FacilitySearchResult {

	
	
	public FacilitySearchResult(String licenseType, String corpName, String license, String facilityName,
			String facilityAdd1, String facilityCity, String facilityPhone, String facState, String facZip,
			String facAdd2, String facMcity, String facMState, String facMzip, String facFax, String facEmail,
			String facMadd2, String facCnt, String fLast, String fFirst, String fMiddle, String fSuffix, String fTitle,
			String fStatus, String fComments, String fUserid, String fEntrytm, String corpId, String registrationId,
			String facClass, String classId, String facStatus, String cMailadd1, String cMailadd2, String cMailcity,
			String cMailstate, String cMailzip, String cFirst, String cMiddle, String cLast, String cSuffix,
			String cTitle, String cPhone, String cPhoneExt, String cEmail, String inspectionCompleted,
			Date inspectionCompletedDate) {
		super();
		this.licenseType = licenseType;
		this.corpName = corpName;
		this.license = license;
		this.facilityName = facilityName;
		this.facilityAdd1 = facilityAdd1;
		this.facilityCity = facilityCity;
		this.facilityPhone = facilityPhone;
		this.facState = facState;
		this.facZip = facZip;
		this.facAdd2 = facAdd2;
		this.facMcity = facMcity;
		this.facMState = facMState;
		this.facMzip = facMzip;
		this.facFax = facFax;
		this.facEmail = facEmail;
		this.facMadd2 = facMadd2;
		this.facCnt = facCnt;
		this.fLast = fLast;
		this.fFirst = fFirst;
		this.fMiddle = fMiddle;
		this.fSuffix = fSuffix;
		this.fTitle = fTitle;
		this.fStatus = fStatus;
		this.fComments = fComments;
		this.fUserid = fUserid;
		this.fEntrytm = fEntrytm;
		this.corpId = corpId;
		this.registrationId = registrationId;
		this.facClass = facClass;
		this.classId = classId;
		this.facStatus = facStatus;
		this.cMailadd1 = cMailadd1;
		this.cMailadd2 = cMailadd2;
		this.cMailcity = cMailcity;
		this.cMailstate = cMailstate;
		this.cMailzip = cMailzip;
		this.cFirst = cFirst;
		this.cMiddle = cMiddle;
		this.cLast = cLast;
		this.cSuffix = cSuffix;
		this.cTitle = cTitle;
		this.cPhone = cPhone;
		this.cPhoneExt = cPhoneExt;
		this.cEmail = cEmail;
		this.inspectionCompleted = inspectionCompleted;
		this.inspectionCompletedDate = inspectionCompletedDate;
	}

	public FacilitySearchResult(Integer facId, String licenseType, String corpName, String license, String facilityName,
			String facilityAdd1, String facilityCity, String facilityPhone, String facState, String facZip,
			String facAdd2, String facMcity, String facMState, String facMzip, String facFax, String facEmail,
			String facMadd2, String facCnt, String fLast, String fFirst, String fMiddle, String fSuffix, String fTitle,
			String fStatus, String fComments, String fUserid, String fEntrytm, String corpId, String registrationId,
			String facClass, String classId, String facStatus, String cMailadd1, String cMailadd2, String cMailcity,
			String cMailstate, String cMailzip, String cFirst, String cMiddle, String cLast, String cSuffix,
			String cTitle, String cPhone, String cPhoneExt, String cEmail, String inspectionCompleted,
			Date inspectionCompletedDate) {
		super();
		this.facId = facId;
		this.licenseType = licenseType;
		this.corpName = corpName;
		this.license = license;
		this.facilityName = facilityName;
		this.facilityAdd1 = facilityAdd1;
		this.facilityCity = facilityCity;
		this.facilityPhone = facilityPhone;
		this.facState = facState;
		this.facZip = facZip;
		this.facAdd2 = facAdd2;
		this.facMcity = facMcity;
		this.facMState = facMState;
		this.facMzip = facMzip;
		this.facFax = facFax;
		this.facEmail = facEmail;
		this.facMadd2 = facMadd2;
		this.facCnt = facCnt;
		this.fLast = fLast;
		this.fFirst = fFirst;
		this.fMiddle = fMiddle;
		this.fSuffix = fSuffix;
		this.fTitle = fTitle;
		this.fStatus = fStatus;
		this.fComments = fComments;
		this.fUserid = fUserid;
		this.fEntrytm = fEntrytm;
		this.corpId = corpId;
		this.registrationId = registrationId;
		this.facClass = facClass;
		this.classId = classId;
		this.facStatus = facStatus;
		this.cMailadd1 = cMailadd1;
		this.cMailadd2 = cMailadd2;
		this.cMailcity = cMailcity;
		this.cMailstate = cMailstate;
		this.cMailzip = cMailzip;
		this.cFirst = cFirst;
		this.cMiddle = cMiddle;
		this.cLast = cLast;
		this.cSuffix = cSuffix;
		this.cTitle = cTitle;
		this.cPhone = cPhone;
		this.cPhoneExt = cPhoneExt;
		this.cEmail = cEmail;
		this.inspectionCompleted = inspectionCompleted;
		this.inspectionCompletedDate = inspectionCompletedDate;
	}

	public FacilitySearchResult() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Id
	@Column(name="fac_id")
	Integer facId;
	
	 @Column(name="cat_name")
	String licenseType;

	 @Column(name="corp_name")
	String corpName;
	
	 @Column(name="reg_license")
	String license; 

	 @Column(name="facility_name")
	String facilityName; 

	 @Column(name="facility_add1")
	String facilityAdd1; 

	 @Column(name="facility_city")
	String facilityCity; 

	 @Column(name="fac_phone")
	String facilityPhone;

	 @Column(name="fac_state")
	String facState;
	
	 @Column(name="fac_zip")
	String facZip;
	
	 @Column(name="fac_add2")
	String facAdd2;
	
	 @Column(name="fac_mcity")
	String facMcity;
	
	 @Column(name="fac_mstate")
	String facMState;
	
	 @Column(name="fac_mzip")
	String facMzip;
	
	 @Column(name="fac_fax")
	String facFax;
	
	 @Column(name="fac_email")
	String facEmail;
	
	 @Column(name="fac_madd2")
	String facMadd2;
	
	 @Column(name="fac_cnt")
	String facCnt;
	
	 @Column(name="f_last")
	String fLast;
	
	 @Column(name="f_first")
	String fFirst;
	
	 @Column(name="f_middle")
	String fMiddle;
	
	 @Column(name="f_suffix")
	String fSuffix;
	
	 @Column(name="f_title")
	String fTitle;
	
	 @Column(name="f_status")
	String fStatus;
	
	 @Column(name="f_comments")
	String fComments;
	
	 @Column(name="f_userid")
	String fUserid;
	
	 @Column(name="f_entrytm")
	String fEntrytm;
	
	 @Column(name="fcorp_id")
	String corpId;
	
	 @Column(name="reg_id")
	String registrationId;
	
	 @Column(name="fac_class")
	String facClass;
	
	 @Column(name="class_id")
	String classId;
		
	 @Column(name="fac_status")
	String facStatus;
	 
	@Column(name="c_mailadd1")
	String cMailadd1;
	
	 @Column(name="c_mailadd2")
	String cMailadd2;
	
	 @Column(name="c_mailcity")
	String cMailcity;
	
	 @Column(name="c_mailstate")
	String cMailstate;
	
	 @Column(name="c_mailzip")
	String cMailzip;
	 
	@Column(name="c_first")
	String cFirst;
	
	@Column(name="c_middle")
	String cMiddle;
	
	@Column(name="c_last")
	String cLast;
	
	@Column(name="c_suffix")
	String cSuffix;
	
	@Column(name="c_title")
	String cTitle;
	
	@Column(name="c_phone")
	String cPhone;
	
	@Column(name="c_phone_ext")
	String cPhoneExt;
	
	@Column(name="c_email")
	String cEmail;
	
	@Column(name="inspection_completed")
	String inspectionCompleted;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd" )
	@Column(name="inspection_completed_date")
	Date inspectionCompletedDate;

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
	 * @return the licenseType
	 */
	public String getLicenseType() {
		return licenseType;
	}

	/**
	 * @param licenseType the licenseType to set
	 */
	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}

	/**
	 * @return the corpName
	 */
	public String getCorpName() {
		return corpName;
	}

	/**
	 * @param corpName the corpName to set
	 */
	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	/**
	 * @return the license
	 */
	public String getLicense() {
		return license;
	}

	/**
	 * @param license the license to set
	 */
	public void setLicense(String license) {
		this.license = license;
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
	 * @return the facilityAdd1
	 */
	public String getFacilityAdd1() {
		return facilityAdd1;
	}

	/**
	 * @param facilityAdd1 the facilityAdd1 to set
	 */
	public void setFacilityAdd1(String facilityAdd1) {
		this.facilityAdd1 = facilityAdd1;
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
	 * @return the facState
	 */
	public String getFacState() {
		return facState;
	}

	/**
	 * @param facState the facState to set
	 */
	public void setFacState(String facState) {
		this.facState = facState;
	}

	/**
	 * @return the facZip
	 */
	public String getFacZip() {
		return facZip;
	}

	/**
	 * @param facZip the facZip to set
	 */
	public void setFacZip(String facZip) {
		this.facZip = facZip;
	}

	/**
	 * @return the facAdd2
	 */
	public String getFacAdd2() {
		return facAdd2;
	}

	/**
	 * @param facAdd2 the facAdd2 to set
	 */
	public void setFacAdd2(String facAdd2) {
		this.facAdd2 = facAdd2;
	}

	/**
	 * @return the facMcity
	 */
	public String getFacMcity() {
		return facMcity;
	}

	/**
	 * @param facMcity the facMcity to set
	 */
	public void setFacMcity(String facMcity) {
		this.facMcity = facMcity;
	}

	/**
	 * @return the facMState
	 */
	public String getFacMState() {
		return facMState;
	}

	/**
	 * @param facMState the facMState to set
	 */
	public void setFacMState(String facMState) {
		this.facMState = facMState;
	}

	/**
	 * @return the facMzip
	 */
	public String getFacMzip() {
		return facMzip;
	}

	/**
	 * @param facMzip the facMzip to set
	 */
	public void setFacMzip(String facMzip) {
		this.facMzip = facMzip;
	}

	/**
	 * @return the facFax
	 */
	public String getFacFax() {
		return facFax;
	}

	/**
	 * @param facFax the facFax to set
	 */
	public void setFacFax(String facFax) {
		this.facFax = facFax;
	}

	/**
	 * @return the facEmail
	 */
	public String getFacEmail() {
		return facEmail;
	}

	/**
	 * @param facEmail the facEmail to set
	 */
	public void setFacEmail(String facEmail) {
		this.facEmail = facEmail;
	}

	/**
	 * @return the facMadd2
	 */
	public String getFacMadd2() {
		return facMadd2;
	}

	/**
	 * @param facMadd2 the facMadd2 to set
	 */
	public void setFacMadd2(String facMadd2) {
		this.facMadd2 = facMadd2;
	}

	/**
	 * @return the facCnt
	 */
	public String getFacCnt() {
		return facCnt;
	}

	/**
	 * @param facCnt the facCnt to set
	 */
	public void setFacCnt(String facCnt) {
		this.facCnt = facCnt;
	}

	/**
	 * @return the fLast
	 */
	public String getfLast() {
		return fLast;
	}

	/**
	 * @param fLast the fLast to set
	 */
	public void setfLast(String fLast) {
		this.fLast = fLast;
	}

	/**
	 * @return the fFirst
	 */
	public String getfFirst() {
		return fFirst;
	}

	/**
	 * @param fFirst the fFirst to set
	 */
	public void setfFirst(String fFirst) {
		this.fFirst = fFirst;
	}

	/**
	 * @return the fMiddle
	 */
	public String getfMiddle() {
		return fMiddle;
	}

	/**
	 * @param fMiddle the fMiddle to set
	 */
	public void setfMiddle(String fMiddle) {
		this.fMiddle = fMiddle;
	}

	/**
	 * @return the fSuffix
	 */
	public String getfSuffix() {
		return fSuffix;
	}

	/**
	 * @param fSuffix the fSuffix to set
	 */
	public void setfSuffix(String fSuffix) {
		this.fSuffix = fSuffix;
	}

	/**
	 * @return the fTitle
	 */
	public String getfTitle() {
		return fTitle;
	}

	/**
	 * @param fTitle the fTitle to set
	 */
	public void setfTitle(String fTitle) {
		this.fTitle = fTitle;
	}

	/**
	 * @return the fStatus
	 */
	public String getfStatus() {
		return fStatus;
	}

	/**
	 * @param fStatus the fStatus to set
	 */
	public void setfStatus(String fStatus) {
		this.fStatus = fStatus;
	}

	/**
	 * @return the fComments
	 */
	public String getfComments() {
		return fComments;
	}

	/**
	 * @param fComments the fComments to set
	 */
	public void setfComments(String fComments) {
		this.fComments = fComments;
	}

	/**
	 * @return the fUserid
	 */
	public String getfUserid() {
		return fUserid;
	}

	/**
	 * @param fUserid the fUserid to set
	 */
	public void setfUserid(String fUserid) {
		this.fUserid = fUserid;
	}

	/**
	 * @return the fEntrytm
	 */
	public String getfEntrytm() {
		return fEntrytm;
	}

	/**
	 * @param fEntrytm the fEntrytm to set
	 */
	public void setfEntrytm(String fEntrytm) {
		this.fEntrytm = fEntrytm;
	}

	/**
	 * @return the corpId
	 */
	public String getCorpId() {
		return corpId;
	}

	/**
	 * @param corpId the corpId to set
	 */
	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

	/**
	 * @return the registrationId
	 */
	public String getRegistrationId() {
		return registrationId;
	}

	/**
	 * @param registrationId the registrationId to set
	 */
	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
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
	 * @return the classId
	 */
	public String getClassId() {
		return classId;
	}

	/**
	 * @param classId the classId to set
	 */
	public void setClassId(String classId) {
		this.classId = classId;
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
	 * @return the cMailadd1
	 */
	public String getcMailadd1() {
		return cMailadd1;
	}

	/**
	 * @param cMailadd1 the cMailadd1 to set
	 */
	public void setcMailadd1(String cMailadd1) {
		this.cMailadd1 = cMailadd1;
	}

	/**
	 * @return the cMailadd2
	 */
	public String getcMailadd2() {
		return cMailadd2;
	}

	/**
	 * @param cMailadd2 the cMailadd2 to set
	 */
	public void setcMailadd2(String cMailadd2) {
		this.cMailadd2 = cMailadd2;
	}

	/**
	 * @return the cMailcity
	 */
	public String getcMailcity() {
		return cMailcity;
	}

	/**
	 * @param cMailcity the cMailcity to set
	 */
	public void setcMailcity(String cMailcity) {
		this.cMailcity = cMailcity;
	}

	/**
	 * @return the cMailstate
	 */
	public String getcMailstate() {
		return cMailstate;
	}

	/**
	 * @param cMailstate the cMailstate to set
	 */
	public void setcMailstate(String cMailstate) {
		this.cMailstate = cMailstate;
	}

	/**
	 * @return the cMailzip
	 */
	public String getcMailzip() {
		return cMailzip;
	}

	/**
	 * @param cMailzip the cMailzip to set
	 */
	public void setcMailzip(String cMailzip) {
		this.cMailzip = cMailzip;
	}

	/**
	 * @return the cFirst
	 */
	public String getcFirst() {
		return cFirst;
	}

	/**
	 * @param cFirst the cFirst to set
	 */
	public void setcFirst(String cFirst) {
		this.cFirst = cFirst;
	}

	/**
	 * @return the cMiddle
	 */
	public String getcMiddle() {
		return cMiddle;
	}

	/**
	 * @param cMiddle the cMiddle to set
	 */
	public void setcMiddle(String cMiddle) {
		this.cMiddle = cMiddle;
	}

	/**
	 * @return the cLast
	 */
	public String getcLast() {
		return cLast;
	}

	/**
	 * @param cLast the cLast to set
	 */
	public void setcLast(String cLast) {
		this.cLast = cLast;
	}

	/**
	 * @return the cSuffix
	 */
	public String getcSuffix() {
		return cSuffix;
	}

	/**
	 * @param cSuffix the cSuffix to set
	 */
	public void setcSuffix(String cSuffix) {
		this.cSuffix = cSuffix;
	}

	/**
	 * @return the cTitle
	 */
	public String getcTitle() {
		return cTitle;
	}

	/**
	 * @param cTitle the cTitle to set
	 */
	public void setcTitle(String cTitle) {
		this.cTitle = cTitle;
	}

	/**
	 * @return the cPhone
	 */
	public String getcPhone() {
		return cPhone;
	}

	/**
	 * @param cPhone the cPhone to set
	 */
	public void setcPhone(String cPhone) {
		this.cPhone = cPhone;
	}

	/**
	 * @return the cPhoneExt
	 */
	public String getcPhoneExt() {
		return cPhoneExt;
	}

	/**
	 * @param cPhoneExt the cPhoneExt to set
	 */
	public void setcPhoneExt(String cPhoneExt) {
		this.cPhoneExt = cPhoneExt;
	}

	/**
	 * @return the cEmail
	 */
	public String getcEmail() {
		return cEmail;
	}

	/**
	 * @param cEmail the cEmail to set
	 */
	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cEmail == null) ? 0 : cEmail.hashCode());
		result = prime * result + ((cFirst == null) ? 0 : cFirst.hashCode());
		result = prime * result + ((cLast == null) ? 0 : cLast.hashCode());
		result = prime * result + ((cMailadd1 == null) ? 0 : cMailadd1.hashCode());
		result = prime * result + ((cMailadd2 == null) ? 0 : cMailadd2.hashCode());
		result = prime * result + ((cMailcity == null) ? 0 : cMailcity.hashCode());
		result = prime * result + ((cMailstate == null) ? 0 : cMailstate.hashCode());
		result = prime * result + ((cMailzip == null) ? 0 : cMailzip.hashCode());
		result = prime * result + ((cMiddle == null) ? 0 : cMiddle.hashCode());
		result = prime * result + ((cPhone == null) ? 0 : cPhone.hashCode());
		result = prime * result + ((cPhoneExt == null) ? 0 : cPhoneExt.hashCode());
		result = prime * result + ((cSuffix == null) ? 0 : cSuffix.hashCode());
		result = prime * result + ((cTitle == null) ? 0 : cTitle.hashCode());
		result = prime * result + ((classId == null) ? 0 : classId.hashCode());
		result = prime * result + ((corpId == null) ? 0 : corpId.hashCode());
		result = prime * result + ((corpName == null) ? 0 : corpName.hashCode());
		result = prime * result + ((fComments == null) ? 0 : fComments.hashCode());
		result = prime * result + ((fEntrytm == null) ? 0 : fEntrytm.hashCode());
		result = prime * result + ((fFirst == null) ? 0 : fFirst.hashCode());
		result = prime * result + ((fLast == null) ? 0 : fLast.hashCode());
		result = prime * result + ((fMiddle == null) ? 0 : fMiddle.hashCode());
		result = prime * result + ((fStatus == null) ? 0 : fStatus.hashCode());
		result = prime * result + ((fSuffix == null) ? 0 : fSuffix.hashCode());
		result = prime * result + ((fTitle == null) ? 0 : fTitle.hashCode());
		result = prime * result + ((fUserid == null) ? 0 : fUserid.hashCode());
		result = prime * result + ((facAdd2 == null) ? 0 : facAdd2.hashCode());
		result = prime * result + ((facClass == null) ? 0 : facClass.hashCode());
		result = prime * result + ((facCnt == null) ? 0 : facCnt.hashCode());
		result = prime * result + ((facEmail == null) ? 0 : facEmail.hashCode());
		result = prime * result + ((facFax == null) ? 0 : facFax.hashCode());
		result = prime * result + ((facId == null) ? 0 : facId.hashCode());
		result = prime * result + ((facMState == null) ? 0 : facMState.hashCode());
		result = prime * result + ((facMadd2 == null) ? 0 : facMadd2.hashCode());
		result = prime * result + ((facMcity == null) ? 0 : facMcity.hashCode());
		result = prime * result + ((facMzip == null) ? 0 : facMzip.hashCode());
		result = prime * result + ((facState == null) ? 0 : facState.hashCode());
		result = prime * result + ((facStatus == null) ? 0 : facStatus.hashCode());
		result = prime * result + ((facZip == null) ? 0 : facZip.hashCode());
		result = prime * result + ((facilityAdd1 == null) ? 0 : facilityAdd1.hashCode());
		result = prime * result + ((facilityCity == null) ? 0 : facilityCity.hashCode());
		result = prime * result + ((facilityName == null) ? 0 : facilityName.hashCode());
		result = prime * result + ((facilityPhone == null) ? 0 : facilityPhone.hashCode());
		result = prime * result + ((inspectionCompleted == null) ? 0 : inspectionCompleted.hashCode());
		result = prime * result + ((inspectionCompletedDate == null) ? 0 : inspectionCompletedDate.hashCode());
		result = prime * result + ((license == null) ? 0 : license.hashCode());
		result = prime * result + ((licenseType == null) ? 0 : licenseType.hashCode());
		result = prime * result + ((registrationId == null) ? 0 : registrationId.hashCode());
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
		FacilitySearchResult other = (FacilitySearchResult) obj;
		if (cEmail == null) {
			if (other.cEmail != null)
				return false;
		} else if (!cEmail.equals(other.cEmail))
			return false;
		if (cFirst == null) {
			if (other.cFirst != null)
				return false;
		} else if (!cFirst.equals(other.cFirst))
			return false;
		if (cLast == null) {
			if (other.cLast != null)
				return false;
		} else if (!cLast.equals(other.cLast))
			return false;
		if (cMailadd1 == null) {
			if (other.cMailadd1 != null)
				return false;
		} else if (!cMailadd1.equals(other.cMailadd1))
			return false;
		if (cMailadd2 == null) {
			if (other.cMailadd2 != null)
				return false;
		} else if (!cMailadd2.equals(other.cMailadd2))
			return false;
		if (cMailcity == null) {
			if (other.cMailcity != null)
				return false;
		} else if (!cMailcity.equals(other.cMailcity))
			return false;
		if (cMailstate == null) {
			if (other.cMailstate != null)
				return false;
		} else if (!cMailstate.equals(other.cMailstate))
			return false;
		if (cMailzip == null) {
			if (other.cMailzip != null)
				return false;
		} else if (!cMailzip.equals(other.cMailzip))
			return false;
		if (cMiddle == null) {
			if (other.cMiddle != null)
				return false;
		} else if (!cMiddle.equals(other.cMiddle))
			return false;
		if (cPhone == null) {
			if (other.cPhone != null)
				return false;
		} else if (!cPhone.equals(other.cPhone))
			return false;
		if (cPhoneExt == null) {
			if (other.cPhoneExt != null)
				return false;
		} else if (!cPhoneExt.equals(other.cPhoneExt))
			return false;
		if (cSuffix == null) {
			if (other.cSuffix != null)
				return false;
		} else if (!cSuffix.equals(other.cSuffix))
			return false;
		if (cTitle == null) {
			if (other.cTitle != null)
				return false;
		} else if (!cTitle.equals(other.cTitle))
			return false;
		if (classId == null) {
			if (other.classId != null)
				return false;
		} else if (!classId.equals(other.classId))
			return false;
		if (corpId == null) {
			if (other.corpId != null)
				return false;
		} else if (!corpId.equals(other.corpId))
			return false;
		if (corpName == null) {
			if (other.corpName != null)
				return false;
		} else if (!corpName.equals(other.corpName))
			return false;
		if (fComments == null) {
			if (other.fComments != null)
				return false;
		} else if (!fComments.equals(other.fComments))
			return false;
		if (fEntrytm == null) {
			if (other.fEntrytm != null)
				return false;
		} else if (!fEntrytm.equals(other.fEntrytm))
			return false;
		if (fFirst == null) {
			if (other.fFirst != null)
				return false;
		} else if (!fFirst.equals(other.fFirst))
			return false;
		if (fLast == null) {
			if (other.fLast != null)
				return false;
		} else if (!fLast.equals(other.fLast))
			return false;
		if (fMiddle == null) {
			if (other.fMiddle != null)
				return false;
		} else if (!fMiddle.equals(other.fMiddle))
			return false;
		if (fStatus == null) {
			if (other.fStatus != null)
				return false;
		} else if (!fStatus.equals(other.fStatus))
			return false;
		if (fSuffix == null) {
			if (other.fSuffix != null)
				return false;
		} else if (!fSuffix.equals(other.fSuffix))
			return false;
		if (fTitle == null) {
			if (other.fTitle != null)
				return false;
		} else if (!fTitle.equals(other.fTitle))
			return false;
		if (fUserid == null) {
			if (other.fUserid != null)
				return false;
		} else if (!fUserid.equals(other.fUserid))
			return false;
		if (facAdd2 == null) {
			if (other.facAdd2 != null)
				return false;
		} else if (!facAdd2.equals(other.facAdd2))
			return false;
		if (facClass == null) {
			if (other.facClass != null)
				return false;
		} else if (!facClass.equals(other.facClass))
			return false;
		if (facCnt == null) {
			if (other.facCnt != null)
				return false;
		} else if (!facCnt.equals(other.facCnt))
			return false;
		if (facEmail == null) {
			if (other.facEmail != null)
				return false;
		} else if (!facEmail.equals(other.facEmail))
			return false;
		if (facFax == null) {
			if (other.facFax != null)
				return false;
		} else if (!facFax.equals(other.facFax))
			return false;
		if (facId == null) {
			if (other.facId != null)
				return false;
		} else if (!facId.equals(other.facId))
			return false;
		if (facMState == null) {
			if (other.facMState != null)
				return false;
		} else if (!facMState.equals(other.facMState))
			return false;
		if (facMadd2 == null) {
			if (other.facMadd2 != null)
				return false;
		} else if (!facMadd2.equals(other.facMadd2))
			return false;
		if (facMcity == null) {
			if (other.facMcity != null)
				return false;
		} else if (!facMcity.equals(other.facMcity))
			return false;
		if (facMzip == null) {
			if (other.facMzip != null)
				return false;
		} else if (!facMzip.equals(other.facMzip))
			return false;
		if (facState == null) {
			if (other.facState != null)
				return false;
		} else if (!facState.equals(other.facState))
			return false;
		if (facStatus == null) {
			if (other.facStatus != null)
				return false;
		} else if (!facStatus.equals(other.facStatus))
			return false;
		if (facZip == null) {
			if (other.facZip != null)
				return false;
		} else if (!facZip.equals(other.facZip))
			return false;
		if (facilityAdd1 == null) {
			if (other.facilityAdd1 != null)
				return false;
		} else if (!facilityAdd1.equals(other.facilityAdd1))
			return false;
		if (facilityCity == null) {
			if (other.facilityCity != null)
				return false;
		} else if (!facilityCity.equals(other.facilityCity))
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
		if (license == null) {
			if (other.license != null)
				return false;
		} else if (!license.equals(other.license))
			return false;
		if (licenseType == null) {
			if (other.licenseType != null)
				return false;
		} else if (!licenseType.equals(other.licenseType))
			return false;
		if (registrationId == null) {
			if (other.registrationId != null)
				return false;
		} else if (!registrationId.equals(other.registrationId))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FacilitySearchResult [facId=" + facId + ", licenseType=" + licenseType + ", corpName=" + corpName
				+ ", license=" + license + ", facilityName=" + facilityName + ", facilityAdd1=" + facilityAdd1
				+ ", facilityCity=" + facilityCity + ", facilityPhone=" + facilityPhone + ", facState=" + facState
				+ ", facZip=" + facZip + ", facAdd2=" + facAdd2 + ", facMcity=" + facMcity + ", facMState=" + facMState
				+ ", facMzip=" + facMzip + ", facFax=" + facFax + ", facEmail=" + facEmail + ", facMadd2=" + facMadd2
				+ ", facCnt=" + facCnt + ", fLast=" + fLast + ", fFirst=" + fFirst + ", fMiddle=" + fMiddle
				+ ", fSuffix=" + fSuffix + ", fTitle=" + fTitle + ", fStatus=" + fStatus + ", fComments=" + fComments
				+ ", fUserid=" + fUserid + ", fEntrytm=" + fEntrytm + ", corpId=" + corpId + ", registrationId="
				+ registrationId + ", facClass=" + facClass + ", classId=" + classId + ", facStatus=" + facStatus
				+ ", cMailadd1=" + cMailadd1 + ", cMailadd2=" + cMailadd2 + ", cMailcity=" + cMailcity + ", cMailstate="
				+ cMailstate + ", cMailzip=" + cMailzip + ", cFirst=" + cFirst + ", cMiddle=" + cMiddle + ", cLast="
				+ cLast + ", cSuffix=" + cSuffix + ", cTitle=" + cTitle + ", cPhone=" + cPhone + ", cPhoneExt="
				+ cPhoneExt + ", cEmail=" + cEmail + ", inspectionCompleted=" + inspectionCompleted
				+ ", inspectionCompletedDate=" + inspectionCompletedDate + "]";
	}

	
	
}
