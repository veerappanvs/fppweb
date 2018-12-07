package ma.dph.fpp.domain.facilities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name= "v_print_certificate")
public class PrintCertificate {


	
	public PrintCertificate(Integer facId, Integer classId, Integer regId, Integer catId, String facName,
			String facMadd1, String facMadd2, String facMcity, String facMstate, String facMzip, String regLicense,
			String dateIssue, String dateExpire, String catDescr, String catName, String fee, String regchpt,
			String facClass, String facStatus, String certaction, String rptdescr, String appRegulation, String urn,
			String facAdd1, String facAdd2, String facCity, String facState, String facZip) {
		super();
		this.facId = facId;
		this.classId = classId;
		this.regId = regId;
		this.catId = catId;
		this.facName = facName;
		this.facMadd1 = facMadd1;
		this.facMadd2 = facMadd2;
		this.facMcity = facMcity;
		this.facMstate = facMstate;
		this.facMzip = facMzip;
		this.regLicense = regLicense;
		this.dateIssue = dateIssue;
		this.dateExpire = dateExpire;
		this.catDescr = catDescr;
		this.catName = catName;
		this.fee = fee;
		this.regchpt = regchpt;
		this.facClass = facClass;
		this.facStatus = facStatus;
		this.certaction = certaction;
		this.rptdescr = rptdescr;
		this.appRegulation = appRegulation;
		this.urn = urn;
		this.facAdd1 = facAdd1;
		this.facAdd2 = facAdd2;
		this.facCity = facCity;
		this.facState = facState;
		this.facZip = facZip;
	}

	public PrintCertificate(Integer id, Integer facId, Integer classId, Integer regId, Integer catId, String facName,
			String facMadd1, String facMadd2, String facMcity, String facMstate, String facMzip, String regLicense,
			String dateIssue, String dateExpire, String catDescr, String catName, String fee, String regchpt,
			String facClass, String facStatus, String certaction, String rptdescr, String appRegulation, String urn,
			String facAdd1, String facAdd2, String facCity, String facState, String facZip) {
		super();
		this.id = id;
		this.facId = facId;
		this.classId = classId;
		this.regId = regId;
		this.catId = catId;
		this.facName = facName;
		this.facMadd1 = facMadd1;
		this.facMadd2 = facMadd2;
		this.facMcity = facMcity;
		this.facMstate = facMstate;
		this.facMzip = facMzip;
		this.regLicense = regLicense;
		this.dateIssue = dateIssue;
		this.dateExpire = dateExpire;
		this.catDescr = catDescr;
		this.catName = catName;
		this.fee = fee;
		this.regchpt = regchpt;
		this.facClass = facClass;
		this.facStatus = facStatus;
		this.certaction = certaction;
		this.rptdescr = rptdescr;
		this.appRegulation = appRegulation;
		this.urn = urn;
		this.facAdd1 = facAdd1;
		this.facAdd2 = facAdd2;
		this.facCity = facCity;
		this.facState = facState;
		this.facZip = facZip;
	}

	public PrintCertificate() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@Column(name="trans_id")
	Integer id;
	
	@Column(name="fac_id")
	Integer facId;
	
	@Column(name="class_id")
	Integer classId;
	
	@Column(name="reg_id")
	Integer regId;
	
	@Column(name="cat_id")
	Integer catId;
	
	@Column(name="fac_name")
	String  facName;
	
	@Column(name="fac_madd1")
	String  facMadd1;
	
	@Column(name="fac_madd2")
	String  facMadd2;
	
	@Column(name="fac_mcity")
	String  facMcity;
	
	@Column(name="fac_mstate")
	String  facMstate;
	
	@Column(name="fac_mzip")
	String  facMzip;
	
	@Column(name="reg_license")
	String  regLicense;
	
	@Column(name="date_issue")
	String  dateIssue;
	
	@Column(name="date_expire")
	String  dateExpire;
	
	@Column(name="cat_descr")
	String  catDescr;
	
	@Column(name="cat_name")
	String  catName;
	
	@Column(name="fee")
	String  fee;
	
	@Column(name="regchpt")
	String  regchpt;
	
	@Column(name="fac_class")
	String  facClass;
	
	@Column(name="fac_status")
	String  facStatus;
	
	@Column(name="certaction")
	String  certaction;
	
	@Column(name="rptdescr")
	String  rptdescr;
	
	@Column(name="app_regulation")
	String  appRegulation;
	
	@Column(name="URN")
	String  urn;
	
	@Column(name="fac_add1")
	String  facAdd1;
	
	@Column(name="fac_add2")
	String  facAdd2;
	
	@Column(name="fac_city")
	String  facCity;
	
	@Column(name="fac_state")
	String  facState;
	
	@Column(name="fac_zip")
	String  facZip;

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
	 * @return the catId
	 */
	public Integer getCatId() {
		return catId;
	}

	/**
	 * @param catId the catId to set
	 */
	public void setCatId(Integer catId) {
		this.catId = catId;
	}

	/**
	 * @return the facName
	 */
	public String getFacName() {
		return facName;
	}

	/**
	 * @param facName the facName to set
	 */
	public void setFacName(String facName) {
		this.facName = facName;
	}

	/**
	 * @return the facMadd1
	 */
	public String getFacMadd1() {
		return facMadd1;
	}

	/**
	 * @param facMadd1 the facMadd1 to set
	 */
	public void setFacMadd1(String facMadd1) {
		this.facMadd1 = facMadd1;
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
	 * @return the facMstate
	 */
	public String getFacMstate() {
		return facMstate;
	}

	/**
	 * @param facMstate the facMstate to set
	 */
	public void setFacMstate(String facMstate) {
		this.facMstate = facMstate;
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
	public String getDateIssue() {
		return dateIssue;
	}

	/**
	 * @param dateIssue the dateIssue to set
	 */
	public void setDateIssue(String dateIssue) {
		this.dateIssue = dateIssue;
	}

	/**
	 * @return the dateExpire
	 */
	public String getDateExpire() {
		return dateExpire;
	}

	/**
	 * @param dateExpire the dateExpire to set
	 */
	public void setDateExpire(String dateExpire) {
		this.dateExpire = dateExpire;
	}

	/**
	 * @return the catDescr
	 */
	public String getCatDescr() {
		return catDescr;
	}

	/**
	 * @param catDescr the catDescr to set
	 */
	public void setCatDescr(String catDescr) {
		this.catDescr = catDescr;
	}

	/**
	 * @return the catName
	 */
	public String getCatName() {
		return catName;
	}

	/**
	 * @param catName the catName to set
	 */
	public void setCatName(String catName) {
		this.catName = catName;
	}

	/**
	 * @return the fee
	 */
	public String getFee() {
		return fee;
	}

	/**
	 * @param fee the fee to set
	 */
	public void setFee(String fee) {
		this.fee = fee;
	}

	/**
	 * @return the regchpt
	 */
	public String getRegchpt() {
		return regchpt;
	}

	/**
	 * @param regchpt the regchpt to set
	 */
	public void setRegchpt(String regchpt) {
		this.regchpt = regchpt;
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
	 * @return the certaction
	 */
	public String getCertaction() {
		return certaction;
	}

	/**
	 * @param certaction the certaction to set
	 */
	public void setCertaction(String certaction) {
		this.certaction = certaction;
	}

	/**
	 * @return the rptdescr
	 */
	public String getRptdescr() {
		return rptdescr;
	}

	/**
	 * @param rptdescr the rptdescr to set
	 */
	public void setRptdescr(String rptdescr) {
		this.rptdescr = rptdescr;
	}

	/**
	 * @return the appRegulation
	 */
	public String getAppRegulation() {
		return appRegulation;
	}

	/**
	 * @param appRegulation the appRegulation to set
	 */
	public void setAppRegulation(String appRegulation) {
		this.appRegulation = appRegulation;
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
	 * @return the facAdd1
	 */
	public String getFacAdd1() {
		return facAdd1;
	}

	/**
	 * @param facAdd1 the facAdd1 to set
	 */
	public void setFacAdd1(String facAdd1) {
		this.facAdd1 = facAdd1;
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
	 * @return the facCity
	 */
	public String getFacCity() {
		return facCity;
	}

	/**
	 * @param facCity the facCity to set
	 */
	public void setFacCity(String facCity) {
		this.facCity = facCity;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appRegulation == null) ? 0 : appRegulation.hashCode());
		result = prime * result + ((catDescr == null) ? 0 : catDescr.hashCode());
		result = prime * result + ((catId == null) ? 0 : catId.hashCode());
		result = prime * result + ((catName == null) ? 0 : catName.hashCode());
		result = prime * result + ((certaction == null) ? 0 : certaction.hashCode());
		result = prime * result + ((classId == null) ? 0 : classId.hashCode());
		result = prime * result + ((dateExpire == null) ? 0 : dateExpire.hashCode());
		result = prime * result + ((dateIssue == null) ? 0 : dateIssue.hashCode());
		result = prime * result + ((facAdd1 == null) ? 0 : facAdd1.hashCode());
		result = prime * result + ((facAdd2 == null) ? 0 : facAdd2.hashCode());
		result = prime * result + ((facCity == null) ? 0 : facCity.hashCode());
		result = prime * result + ((facClass == null) ? 0 : facClass.hashCode());
		result = prime * result + ((facId == null) ? 0 : facId.hashCode());
		result = prime * result + ((facMadd1 == null) ? 0 : facMadd1.hashCode());
		result = prime * result + ((facMadd2 == null) ? 0 : facMadd2.hashCode());
		result = prime * result + ((facMcity == null) ? 0 : facMcity.hashCode());
		result = prime * result + ((facMstate == null) ? 0 : facMstate.hashCode());
		result = prime * result + ((facMzip == null) ? 0 : facMzip.hashCode());
		result = prime * result + ((facName == null) ? 0 : facName.hashCode());
		result = prime * result + ((facState == null) ? 0 : facState.hashCode());
		result = prime * result + ((facStatus == null) ? 0 : facStatus.hashCode());
		result = prime * result + ((facZip == null) ? 0 : facZip.hashCode());
		result = prime * result + ((fee == null) ? 0 : fee.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((regId == null) ? 0 : regId.hashCode());
		result = prime * result + ((regLicense == null) ? 0 : regLicense.hashCode());
		result = prime * result + ((regchpt == null) ? 0 : regchpt.hashCode());
		result = prime * result + ((rptdescr == null) ? 0 : rptdescr.hashCode());
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
		PrintCertificate other = (PrintCertificate) obj;
		if (appRegulation == null) {
			if (other.appRegulation != null)
				return false;
		} else if (!appRegulation.equals(other.appRegulation))
			return false;
		if (catDescr == null) {
			if (other.catDescr != null)
				return false;
		} else if (!catDescr.equals(other.catDescr))
			return false;
		if (catId == null) {
			if (other.catId != null)
				return false;
		} else if (!catId.equals(other.catId))
			return false;
		if (catName == null) {
			if (other.catName != null)
				return false;
		} else if (!catName.equals(other.catName))
			return false;
		if (certaction == null) {
			if (other.certaction != null)
				return false;
		} else if (!certaction.equals(other.certaction))
			return false;
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
		if (facAdd1 == null) {
			if (other.facAdd1 != null)
				return false;
		} else if (!facAdd1.equals(other.facAdd1))
			return false;
		if (facAdd2 == null) {
			if (other.facAdd2 != null)
				return false;
		} else if (!facAdd2.equals(other.facAdd2))
			return false;
		if (facCity == null) {
			if (other.facCity != null)
				return false;
		} else if (!facCity.equals(other.facCity))
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
		if (facMadd1 == null) {
			if (other.facMadd1 != null)
				return false;
		} else if (!facMadd1.equals(other.facMadd1))
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
		if (facMstate == null) {
			if (other.facMstate != null)
				return false;
		} else if (!facMstate.equals(other.facMstate))
			return false;
		if (facMzip == null) {
			if (other.facMzip != null)
				return false;
		} else if (!facMzip.equals(other.facMzip))
			return false;
		if (facName == null) {
			if (other.facName != null)
				return false;
		} else if (!facName.equals(other.facName))
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
		if (fee == null) {
			if (other.fee != null)
				return false;
		} else if (!fee.equals(other.fee))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		if (regchpt == null) {
			if (other.regchpt != null)
				return false;
		} else if (!regchpt.equals(other.regchpt))
			return false;
		if (rptdescr == null) {
			if (other.rptdescr != null)
				return false;
		} else if (!rptdescr.equals(other.rptdescr))
			return false;
		if (urn == null) {
			if (other.urn != null)
				return false;
		} else if (!urn.equals(other.urn))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PrintCertificate [id=" + id + ", facId=" + facId + ", classId=" + classId + ", regId=" + regId
				+ ", catId=" + catId + ", facName=" + facName + ", facMadd1=" + facMadd1 + ", facMadd2=" + facMadd2
				+ ", facMcity=" + facMcity + ", facMstate=" + facMstate + ", facMzip=" + facMzip + ", regLicense="
				+ regLicense + ", dateIssue=" + dateIssue + ", dateExpire=" + dateExpire + ", catDescr=" + catDescr
				+ ", catName=" + catName + ", fee=" + fee + ", regchpt=" + regchpt + ", facClass=" + facClass
				+ ", facStatus=" + facStatus + ", certaction=" + certaction + ", rptdescr=" + rptdescr
				+ ", appRegulation=" + appRegulation + ", urn=" + urn + ", facAdd1=" + facAdd1 + ", facAdd2=" + facAdd2
				+ ", facCity=" + facCity + ", facState=" + facState + ", facZip=" + facZip + "]";
	}
	
}
