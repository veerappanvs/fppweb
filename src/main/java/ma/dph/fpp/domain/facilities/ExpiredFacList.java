package ma.dph.fpp.domain.facilities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;


@Entity
@Table(name="v_expired_list")
//@Getter
//@Setter

/*@NamedStoredProcedureQuery(name = "usp_listexpires", procedureName = "Facilities_Dev", parameters = {
@StoredProcedureParameter(mode = ParameterMode.IN, name = "issued", type = String.class),
@StoredProcedureParameter(mode = ParameterMode.IN, name = "expired", type = String.class),
@StoredProcedureParameter(mode = ParameterMode.IN, name = "lcType", type = String.class) })*/
public class ExpiredFacList {
	
	public ExpiredFacList(String catName, String catLetter, String facStatus, String statdesc, String regLicense,
			String dateIssue, String dateExpire, String corpName, String corpAdd1, String corpCity, String corpState,
			String corpZip, String corp_phone, String c_last, String c_middle, String c_suffix, String c_first,
			String facName, String facAdd1, String facCity, String facPhone, String facState, String facZip,
			String facMadd1, String facAdd2, String facMcity, String facMstate, String facMzip, String facFax,
			String facEmail, String facMadd2, String fLast, String fFirst, String fMiddle, String fSuffix,
			String fTitle, String fStatus, String fComments, String corpId, String revenueSrcCode, String country) {
		super();
		this.catName = catName;
		this.catLetter = catLetter;
		this.facStatus = facStatus;
		this.statdesc = statdesc;
		this.regLicense = regLicense;
		this.dateIssue = dateIssue;
		this.dateExpire = dateExpire;
		this.corpName = corpName;
		this.corpAdd1 = corpAdd1;
		this.corpCity = corpCity;
		this.corpState = corpState;
		this.corpZip = corpZip;
		this.corp_phone = corp_phone;
		this.c_last = c_last;
		this.c_middle = c_middle;
		this.c_suffix = c_suffix;
		this.c_first = c_first;
		this.facName = facName;
		this.facAdd1 = facAdd1;
		this.facCity = facCity;
		this.facPhone = facPhone;
		this.facState = facState;
		this.facZip = facZip;
		this.facMadd1 = facMadd1;
		this.facAdd2 = facAdd2;
		this.facMcity = facMcity;
		this.facMstate = facMstate;
		this.facMzip = facMzip;
		this.facFax = facFax;
		this.facEmail = facEmail;
		this.facMadd2 = facMadd2;
		this.fLast = fLast;
		this.fFirst = fFirst;
		this.fMiddle = fMiddle;
		this.fSuffix = fSuffix;
		this.fTitle = fTitle;
		this.fStatus = fStatus;
		this.fComments = fComments;
		this.corpId = corpId;
		this.revenueSrcCode = revenueSrcCode;
		this.country = country;
	}

	public ExpiredFacList(String facId, String catName, String catLetter, String facStatus, String statdesc,
			String regLicense, String dateIssue, String dateExpire, String corpName, String corpAdd1, String corpCity,
			String corpState, String corpZip, String corp_phone, String c_last, String c_middle, String c_suffix,
			String c_first, String facName, String facAdd1, String facCity, String facPhone, String facState,
			String facZip, String facMadd1, String facAdd2, String facMcity, String facMstate, String facMzip,
			String facFax, String facEmail, String facMadd2, String fLast, String fFirst, String fMiddle,
			String fSuffix, String fTitle, String fStatus, String fComments, String corpId, String revenueSrcCode,
			String country) {
		super();
		this.facId = facId;
		this.catName = catName;
		this.catLetter = catLetter;
		this.facStatus = facStatus;
		this.statdesc = statdesc;
		this.regLicense = regLicense;
		this.dateIssue = dateIssue;
		this.dateExpire = dateExpire;
		this.corpName = corpName;
		this.corpAdd1 = corpAdd1;
		this.corpCity = corpCity;
		this.corpState = corpState;
		this.corpZip = corpZip;
		this.corp_phone = corp_phone;
		this.c_last = c_last;
		this.c_middle = c_middle;
		this.c_suffix = c_suffix;
		this.c_first = c_first;
		this.facName = facName;
		this.facAdd1 = facAdd1;
		this.facCity = facCity;
		this.facPhone = facPhone;
		this.facState = facState;
		this.facZip = facZip;
		this.facMadd1 = facMadd1;
		this.facAdd2 = facAdd2;
		this.facMcity = facMcity;
		this.facMstate = facMstate;
		this.facMzip = facMzip;
		this.facFax = facFax;
		this.facEmail = facEmail;
		this.facMadd2 = facMadd2;
		this.fLast = fLast;
		this.fFirst = fFirst;
		this.fMiddle = fMiddle;
		this.fSuffix = fSuffix;
		this.fTitle = fTitle;
		this.fStatus = fStatus;
		this.fComments = fComments;
		this.corpId = corpId;
		this.revenueSrcCode = revenueSrcCode;
		this.country = country;
	}

	public ExpiredFacList() {}
	
	@Id
	@Column(name="fac_id")
	private String facId;
		
	@Column(name="cat_name")
	private String catName;
	
	@Column(name="cat_letter")
	private String catLetter;
	
	@Column(name="fac_status")
	private String facStatus;
	
	@Column(name="statdesc")
	private String statdesc;
	
	@Column(name="reg_license")
	private String regLicense;
	
	@Column(name="date_issue")
	private String dateIssue;
	
	@Column(name="date_expire")
	private String dateExpire;
	
	@Column(name="corp_name")
	private String corpName;
	
	@Column(name="corp_add1")
	private String corpAdd1;
	
	@Column(name="corp_city")
	private String corpCity;
	
	@Column(name="corp_state")
	private String corpState;
	
	@Column(name="corp_zip")
	private String corpZip;
	
	@Column(name="corp_phone")
	private String corp_phone;
	
	@Column(name="c_last")
	private String c_last;
	
	@Column(name="c_middle")
	private String c_middle;
	
	@Column(name="c_suffix")
	private String c_suffix;	
	
	@Column(name="c_first")
	private String c_first;	
	
	@Column(name="fac_name")
	private String facName;	
	
	@Column(name="fac_add1")
	private String facAdd1;	
	
	@Column(name="fac_city")
	private String facCity;	
	
	@Column(name="fac_phone")
	private String facPhone;	
	
	@Column(name="fac_state")
	private String facState;
	
	@Column(name="fac_zip")
	private String facZip;
	
	@Column(name="fac_madd1")
	private String facMadd1;
	
	@Column(name="fac_add2")
	private String facAdd2;
	
	@Column(name="fac_mcity")
	private String facMcity;
	
	@Column(name="fac_mstate")
	private String facMstate;
	
	@Column(name="fac_mzip")
	private String facMzip;
	
	@Column(name="fac_fax")
	private String facFax;
	
	@Column(name="fac_email")
	private String facEmail;
		
	@Column(name="fac_madd2")
	private String facMadd2;
	
	@Column(name="f_last")
	private String fLast;
	
	@Column(name="f_first")
	private String fFirst;
	
	@Column(name="f_middle")
	private String fMiddle;
	
	@Column(name="f_suffix")
	private String fSuffix;
	
	@Column(name="f_title")
	private String fTitle;
	
	@Column(name="f_status")
	private String fStatus;
	
	@Column(name="f_comments")
	private String fComments;
	
	@Column(name="corp_id")
	private String corpId;

	@Column(name="revenue_src_code")
	private String revenueSrcCode;
	
	@Column(name="country")
	private String country;

	/**
	 * @return the facId
	 */
	public String getFacId() {
		return facId;
	}

	/**
	 * @param facId the facId to set
	 */
	public void setFacId(String facId) {
		this.facId = facId;
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
	 * @return the catLetter
	 */
	public String getCatLetter() {
		return catLetter;
	}

	/**
	 * @param catLetter the catLetter to set
	 */
	public void setCatLetter(String catLetter) {
		this.catLetter = catLetter;
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
	 * @return the corpAdd1
	 */
	public String getCorpAdd1() {
		return corpAdd1;
	}

	/**
	 * @param corpAdd1 the corpAdd1 to set
	 */
	public void setCorpAdd1(String corpAdd1) {
		this.corpAdd1 = corpAdd1;
	}

	/**
	 * @return the corpCity
	 */
	public String getCorpCity() {
		return corpCity;
	}

	/**
	 * @param corpCity the corpCity to set
	 */
	public void setCorpCity(String corpCity) {
		this.corpCity = corpCity;
	}

	/**
	 * @return the corpState
	 */
	public String getCorpState() {
		return corpState;
	}

	/**
	 * @param corpState the corpState to set
	 */
	public void setCorpState(String corpState) {
		this.corpState = corpState;
	}

	/**
	 * @return the corpZip
	 */
	public String getCorpZip() {
		return corpZip;
	}

	/**
	 * @param corpZip the corpZip to set
	 */
	public void setCorpZip(String corpZip) {
		this.corpZip = corpZip;
	}

	/**
	 * @return the corp_phone
	 */
	public String getCorp_phone() {
		return corp_phone;
	}

	/**
	 * @param corp_phone the corp_phone to set
	 */
	public void setCorp_phone(String corp_phone) {
		this.corp_phone = corp_phone;
	}

	/**
	 * @return the c_last
	 */
	public String getC_last() {
		return c_last;
	}

	/**
	 * @param c_last the c_last to set
	 */
	public void setC_last(String c_last) {
		this.c_last = c_last;
	}

	/**
	 * @return the c_middle
	 */
	public String getC_middle() {
		return c_middle;
	}

	/**
	 * @param c_middle the c_middle to set
	 */
	public void setC_middle(String c_middle) {
		this.c_middle = c_middle;
	}

	/**
	 * @return the c_suffix
	 */
	public String getC_suffix() {
		return c_suffix;
	}

	/**
	 * @param c_suffix the c_suffix to set
	 */
	public void setC_suffix(String c_suffix) {
		this.c_suffix = c_suffix;
	}

	/**
	 * @return the c_first
	 */
	public String getC_first() {
		return c_first;
	}

	/**
	 * @param c_first the c_first to set
	 */
	public void setC_first(String c_first) {
		this.c_first = c_first;
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
	 * @return the facPhone
	 */
	public String getFacPhone() {
		return facPhone;
	}

	/**
	 * @param facPhone the facPhone to set
	 */
	public void setFacPhone(String facPhone) {
		this.facPhone = facPhone;
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
	 * @return the revenueSrcCode
	 */
	public String getRevenueSrcCode() {
		return revenueSrcCode;
	}

	/**
	 * @param revenueSrcCode the revenueSrcCode to set
	 */
	public void setRevenueSrcCode(String revenueSrcCode) {
		this.revenueSrcCode = revenueSrcCode;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((c_first == null) ? 0 : c_first.hashCode());
		result = prime * result + ((c_last == null) ? 0 : c_last.hashCode());
		result = prime * result + ((c_middle == null) ? 0 : c_middle.hashCode());
		result = prime * result + ((c_suffix == null) ? 0 : c_suffix.hashCode());
		result = prime * result + ((catLetter == null) ? 0 : catLetter.hashCode());
		result = prime * result + ((catName == null) ? 0 : catName.hashCode());
		result = prime * result + ((corpAdd1 == null) ? 0 : corpAdd1.hashCode());
		result = prime * result + ((corpCity == null) ? 0 : corpCity.hashCode());
		result = prime * result + ((corpId == null) ? 0 : corpId.hashCode());
		result = prime * result + ((corpName == null) ? 0 : corpName.hashCode());
		result = prime * result + ((corpState == null) ? 0 : corpState.hashCode());
		result = prime * result + ((corpZip == null) ? 0 : corpZip.hashCode());
		result = prime * result + ((corp_phone == null) ? 0 : corp_phone.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((dateExpire == null) ? 0 : dateExpire.hashCode());
		result = prime * result + ((dateIssue == null) ? 0 : dateIssue.hashCode());
		result = prime * result + ((fComments == null) ? 0 : fComments.hashCode());
		result = prime * result + ((fFirst == null) ? 0 : fFirst.hashCode());
		result = prime * result + ((fLast == null) ? 0 : fLast.hashCode());
		result = prime * result + ((fMiddle == null) ? 0 : fMiddle.hashCode());
		result = prime * result + ((fStatus == null) ? 0 : fStatus.hashCode());
		result = prime * result + ((fSuffix == null) ? 0 : fSuffix.hashCode());
		result = prime * result + ((fTitle == null) ? 0 : fTitle.hashCode());
		result = prime * result + ((facAdd1 == null) ? 0 : facAdd1.hashCode());
		result = prime * result + ((facAdd2 == null) ? 0 : facAdd2.hashCode());
		result = prime * result + ((facCity == null) ? 0 : facCity.hashCode());
		result = prime * result + ((facEmail == null) ? 0 : facEmail.hashCode());
		result = prime * result + ((facFax == null) ? 0 : facFax.hashCode());
		result = prime * result + ((facId == null) ? 0 : facId.hashCode());
		result = prime * result + ((facMadd1 == null) ? 0 : facMadd1.hashCode());
		result = prime * result + ((facMadd2 == null) ? 0 : facMadd2.hashCode());
		result = prime * result + ((facMcity == null) ? 0 : facMcity.hashCode());
		result = prime * result + ((facMstate == null) ? 0 : facMstate.hashCode());
		result = prime * result + ((facMzip == null) ? 0 : facMzip.hashCode());
		result = prime * result + ((facName == null) ? 0 : facName.hashCode());
		result = prime * result + ((facPhone == null) ? 0 : facPhone.hashCode());
		result = prime * result + ((facState == null) ? 0 : facState.hashCode());
		result = prime * result + ((facStatus == null) ? 0 : facStatus.hashCode());
		result = prime * result + ((facZip == null) ? 0 : facZip.hashCode());
		result = prime * result + ((regLicense == null) ? 0 : regLicense.hashCode());
		result = prime * result + ((revenueSrcCode == null) ? 0 : revenueSrcCode.hashCode());
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
		ExpiredFacList other = (ExpiredFacList) obj;
		if (c_first == null) {
			if (other.c_first != null)
				return false;
		} else if (!c_first.equals(other.c_first))
			return false;
		if (c_last == null) {
			if (other.c_last != null)
				return false;
		} else if (!c_last.equals(other.c_last))
			return false;
		if (c_middle == null) {
			if (other.c_middle != null)
				return false;
		} else if (!c_middle.equals(other.c_middle))
			return false;
		if (c_suffix == null) {
			if (other.c_suffix != null)
				return false;
		} else if (!c_suffix.equals(other.c_suffix))
			return false;
		if (catLetter == null) {
			if (other.catLetter != null)
				return false;
		} else if (!catLetter.equals(other.catLetter))
			return false;
		if (catName == null) {
			if (other.catName != null)
				return false;
		} else if (!catName.equals(other.catName))
			return false;
		if (corpAdd1 == null) {
			if (other.corpAdd1 != null)
				return false;
		} else if (!corpAdd1.equals(other.corpAdd1))
			return false;
		if (corpCity == null) {
			if (other.corpCity != null)
				return false;
		} else if (!corpCity.equals(other.corpCity))
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
		if (corpState == null) {
			if (other.corpState != null)
				return false;
		} else if (!corpState.equals(other.corpState))
			return false;
		if (corpZip == null) {
			if (other.corpZip != null)
				return false;
		} else if (!corpZip.equals(other.corpZip))
			return false;
		if (corp_phone == null) {
			if (other.corp_phone != null)
				return false;
		} else if (!corp_phone.equals(other.corp_phone))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
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
		if (fComments == null) {
			if (other.fComments != null)
				return false;
		} else if (!fComments.equals(other.fComments))
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
		if (facPhone == null) {
			if (other.facPhone != null)
				return false;
		} else if (!facPhone.equals(other.facPhone))
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
		if (regLicense == null) {
			if (other.regLicense != null)
				return false;
		} else if (!regLicense.equals(other.regLicense))
			return false;
		if (revenueSrcCode == null) {
			if (other.revenueSrcCode != null)
				return false;
		} else if (!revenueSrcCode.equals(other.revenueSrcCode))
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
		return "ExpiredFacList [facId=" + facId + ", catName=" + catName + ", catLetter=" + catLetter + ", facStatus="
				+ facStatus + ", statdesc=" + statdesc + ", regLicense=" + regLicense + ", dateIssue=" + dateIssue
				+ ", dateExpire=" + dateExpire + ", corpName=" + corpName + ", corpAdd1=" + corpAdd1 + ", corpCity="
				+ corpCity + ", corpState=" + corpState + ", corpZip=" + corpZip + ", corp_phone=" + corp_phone
				+ ", c_last=" + c_last + ", c_middle=" + c_middle + ", c_suffix=" + c_suffix + ", c_first=" + c_first
				+ ", facName=" + facName + ", facAdd1=" + facAdd1 + ", facCity=" + facCity + ", facPhone=" + facPhone
				+ ", facState=" + facState + ", facZip=" + facZip + ", facMadd1=" + facMadd1 + ", facAdd2=" + facAdd2
				+ ", facMcity=" + facMcity + ", facMstate=" + facMstate + ", facMzip=" + facMzip + ", facFax=" + facFax
				+ ", facEmail=" + facEmail + ", facMadd2=" + facMadd2 + ", fLast=" + fLast + ", fFirst=" + fFirst
				+ ", fMiddle=" + fMiddle + ", fSuffix=" + fSuffix + ", fTitle=" + fTitle + ", fStatus=" + fStatus
				+ ", fComments=" + fComments + ", corpId=" + corpId + ", revenueSrcCode=" + revenueSrcCode
				+ ", country=" + country + "]";
	}

	
}