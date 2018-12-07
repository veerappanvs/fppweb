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
@Entity(name = "corp")
public class Corporation {

	
	public Corporation(Integer id, String corpName, String corpAdd1, String corpAdd2, String corpCity, String corpState,
			String corpZip, String corpPhone, String corpFax, String corpFid, String corpEmail, String cMailadd1,
			String cMailadd2, String cMailcity, String cMailstate, String cMailzip, String cLast, String cFirst,
			String cMiddle, String cSuffix, String cTitle, String cComments, String cUserid, Date cEntrytm,
			String corpPhoneExt, String corpCountry) {
		super();
		this.id = id;
		this.corpName = corpName;
		this.corpAdd1 = corpAdd1;
		this.corpAdd2 = corpAdd2;
		this.corpCity = corpCity;
		this.corpState = corpState;
		this.corpZip = corpZip;
		this.corpPhone = corpPhone;
		this.corpFax = corpFax;
		this.corpFid = corpFid;
		this.corpEmail = corpEmail;
		this.cMailadd1 = cMailadd1;
		this.cMailadd2 = cMailadd2;
		this.cMailcity = cMailcity;
		this.cMailstate = cMailstate;
		this.cMailzip = cMailzip;
		this.cLast = cLast;
		this.cFirst = cFirst;
		this.cMiddle = cMiddle;
		this.cSuffix = cSuffix;
		this.cTitle = cTitle;
		this.cComments = cComments;
		this.cUserid = cUserid;
		this.cEntrytm = cEntrytm;
		this.corpPhoneExt = corpPhoneExt;
		this.corpCountry = corpCountry;
	}

	public Corporation(String corpName, String corpAdd1, String corpAdd2, String corpCity, String corpState,
			String corpZip, String corpPhone, String corpFax, String corpFid, String corpEmail, String cMailadd1,
			String cMailadd2, String cMailcity, String cMailstate, String cMailzip, String cLast, String cFirst,
			String cMiddle, String cSuffix, String cTitle, String cComments, String cUserid, Date cEntrytm,
			String corpPhoneExt, String corpCountry) {
		super();
		this.corpName = corpName;
		this.corpAdd1 = corpAdd1;
		this.corpAdd2 = corpAdd2;
		this.corpCity = corpCity;
		this.corpState = corpState;
		this.corpZip = corpZip;
		this.corpPhone = corpPhone;
		this.corpFax = corpFax;
		this.corpFid = corpFid;
		this.corpEmail = corpEmail;
		this.cMailadd1 = cMailadd1;
		this.cMailadd2 = cMailadd2;
		this.cMailcity = cMailcity;
		this.cMailstate = cMailstate;
		this.cMailzip = cMailzip;
		this.cLast = cLast;
		this.cFirst = cFirst;
		this.cMiddle = cMiddle;
		this.cSuffix = cSuffix;
		this.cTitle = cTitle;
		this.cComments = cComments;
		this.cUserid = cUserid;
		this.cEntrytm = cEntrytm;
		this.corpPhoneExt = corpPhoneExt;
		this.corpCountry = corpCountry;
	}

	/**
	 * 
	 */
	public Corporation() {
		// TODO Auto-generated constructor stub
	}
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "corp_id")
	private Integer  id;
	
	@Column(name = "corp_name")
	private String  corpName;
	
	@Column(name = "corp_add1")
	private String  corpAdd1;
	
	@Column(name = "corp_add2")
	private String  corpAdd2;
	
	@Column(name = "corp_city")
	private String  corpCity;
	
	@Column(name = "corp_state")
	private String  corpState;
	
	@Column(name = "corp_zip")
	private String  corpZip;
	
	@Column(name = "corp_phone")
	private String  corpPhone;

	@Column(name = "corp_fax")
	private String  corpFax;

	@Column(name = "corp_fid")
	private String  corpFid;
	
	@Column(name = "corp_email")
	private String  corpEmail;
	
	@Column(name = "c_mailadd1")
	private String  cMailadd1;
	
	@Column(name = "c_mailadd2")
	private String  cMailadd2;
	
	@Column(name = "c_mailcity")
	private String  cMailcity;
	
	@Column(name = "c_mailstate")
	private String  cMailstate;
	
	@Column(name = "c_mailzip")
	private String  cMailzip;
	
	@Column(name = "c_last")
	private String  cLast;
	
	@Column(name = "c_first")
	private String  cFirst;
	
	@Column(name = "c_middle")
	private String  cMiddle;
	
	@Column(name = "c_suffix")
	private String  cSuffix;
	
	@Column(name = "c_title")
	private String  cTitle;
	
	@Column(name = "c_comments")
	private String  cComments;
	
	@Column(name = "c_userid")
	private String  cUserid;
	
	@Column(name = "c_entrytm")
	private Date  cEntrytm;
	
	@Column(name = "corp_phone_ext")
	private String  corpPhoneExt;
		
	@Column(name = "corp_country")
	private String  corpCountry;

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
	 * @return the corpAdd2
	 */
	public String getCorpAdd2() {
		return corpAdd2;
	}

	/**
	 * @param corpAdd2 the corpAdd2 to set
	 */
	public void setCorpAdd2(String corpAdd2) {
		this.corpAdd2 = corpAdd2;
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
	 * @return the corpPhone
	 */
	public String getCorpPhone() {
		return corpPhone;
	}

	/**
	 * @param corpPhone the corpPhone to set
	 */
	public void setCorpPhone(String corpPhone) {
		this.corpPhone = corpPhone;
	}

	/**
	 * @return the corpFax
	 */
	public String getCorpFax() {
		return corpFax;
	}

	/**
	 * @param corpFax the corpFax to set
	 */
	public void setCorpFax(String corpFax) {
		this.corpFax = corpFax;
	}

	/**
	 * @return the corpFid
	 */
	public String getCorpFid() {
		return corpFid;
	}

	/**
	 * @param corpFid the corpFid to set
	 */
	public void setCorpFid(String corpFid) {
		this.corpFid = corpFid;
	}

	/**
	 * @return the corpEmail
	 */
	public String getCorpEmail() {
		return corpEmail;
	}

	/**
	 * @param corpEmail the corpEmail to set
	 */
	public void setCorpEmail(String corpEmail) {
		this.corpEmail = corpEmail;
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
	 * @return the cComments
	 */
	public String getcComments() {
		return cComments;
	}

	/**
	 * @param cComments the cComments to set
	 */
	public void setcComments(String cComments) {
		this.cComments = cComments;
	}

	/**
	 * @return the cUserid
	 */
	public String getcUserid() {
		return cUserid;
	}

	/**
	 * @param cUserid the cUserid to set
	 */
	public void setcUserid(String cUserid) {
		this.cUserid = cUserid;
	}

	/**
	 * @return the cEntrytm
	 */
	public Date getcEntrytm() {
		return cEntrytm;
	}

	/**
	 * @param cEntrytm the cEntrytm to set
	 */
	public void setcEntrytm(Date cEntrytm) {
		this.cEntrytm = cEntrytm;
	}

	/**
	 * @return the corpPhoneExt
	 */
	public String getCorpPhoneExt() {
		return corpPhoneExt;
	}

	/**
	 * @param corpPhoneExt the corpPhoneExt to set
	 */
	public void setCorpPhoneExt(String corpPhoneExt) {
		this.corpPhoneExt = corpPhoneExt;
	}

	/**
	 * @return the corpCountry
	 */
	public String getCorpCountry() {
		return corpCountry;
	}

	/**
	 * @param corpCountry the corpCountry to set
	 */
	public void setCorpCountry(String corpCountry) {
		this.corpCountry = corpCountry;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cComments == null) ? 0 : cComments.hashCode());
		result = prime * result + ((cEntrytm == null) ? 0 : cEntrytm.hashCode());
		result = prime * result + ((cFirst == null) ? 0 : cFirst.hashCode());
		result = prime * result + ((cLast == null) ? 0 : cLast.hashCode());
		result = prime * result + ((cMailadd1 == null) ? 0 : cMailadd1.hashCode());
		result = prime * result + ((cMailadd2 == null) ? 0 : cMailadd2.hashCode());
		result = prime * result + ((cMailcity == null) ? 0 : cMailcity.hashCode());
		result = prime * result + ((cMailstate == null) ? 0 : cMailstate.hashCode());
		result = prime * result + ((cMailzip == null) ? 0 : cMailzip.hashCode());
		result = prime * result + ((cMiddle == null) ? 0 : cMiddle.hashCode());
		result = prime * result + ((cSuffix == null) ? 0 : cSuffix.hashCode());
		result = prime * result + ((cTitle == null) ? 0 : cTitle.hashCode());
		result = prime * result + ((cUserid == null) ? 0 : cUserid.hashCode());
		result = prime * result + ((corpAdd1 == null) ? 0 : corpAdd1.hashCode());
		result = prime * result + ((corpAdd2 == null) ? 0 : corpAdd2.hashCode());
		result = prime * result + ((corpCity == null) ? 0 : corpCity.hashCode());
		result = prime * result + ((corpCountry == null) ? 0 : corpCountry.hashCode());
		result = prime * result + ((corpEmail == null) ? 0 : corpEmail.hashCode());
		result = prime * result + ((corpFax == null) ? 0 : corpFax.hashCode());
		result = prime * result + ((corpFid == null) ? 0 : corpFid.hashCode());
		result = prime * result + ((corpName == null) ? 0 : corpName.hashCode());
		result = prime * result + ((corpPhone == null) ? 0 : corpPhone.hashCode());
		result = prime * result + ((corpPhoneExt == null) ? 0 : corpPhoneExt.hashCode());
		result = prime * result + ((corpState == null) ? 0 : corpState.hashCode());
		result = prime * result + ((corpZip == null) ? 0 : corpZip.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Corporation other = (Corporation) obj;
		if (cComments == null) {
			if (other.cComments != null)
				return false;
		} else if (!cComments.equals(other.cComments))
			return false;
		if (cEntrytm == null) {
			if (other.cEntrytm != null)
				return false;
		} else if (!cEntrytm.equals(other.cEntrytm))
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
		if (cUserid == null) {
			if (other.cUserid != null)
				return false;
		} else if (!cUserid.equals(other.cUserid))
			return false;
		if (corpAdd1 == null) {
			if (other.corpAdd1 != null)
				return false;
		} else if (!corpAdd1.equals(other.corpAdd1))
			return false;
		if (corpAdd2 == null) {
			if (other.corpAdd2 != null)
				return false;
		} else if (!corpAdd2.equals(other.corpAdd2))
			return false;
		if (corpCity == null) {
			if (other.corpCity != null)
				return false;
		} else if (!corpCity.equals(other.corpCity))
			return false;
		if (corpCountry == null) {
			if (other.corpCountry != null)
				return false;
		} else if (!corpCountry.equals(other.corpCountry))
			return false;
		if (corpEmail == null) {
			if (other.corpEmail != null)
				return false;
		} else if (!corpEmail.equals(other.corpEmail))
			return false;
		if (corpFax == null) {
			if (other.corpFax != null)
				return false;
		} else if (!corpFax.equals(other.corpFax))
			return false;
		if (corpFid == null) {
			if (other.corpFid != null)
				return false;
		} else if (!corpFid.equals(other.corpFid))
			return false;
		if (corpName == null) {
			if (other.corpName != null)
				return false;
		} else if (!corpName.equals(other.corpName))
			return false;
		if (corpPhone == null) {
			if (other.corpPhone != null)
				return false;
		} else if (!corpPhone.equals(other.corpPhone))
			return false;
		if (corpPhoneExt == null) {
			if (other.corpPhoneExt != null)
				return false;
		} else if (!corpPhoneExt.equals(other.corpPhoneExt))
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Corporation [id=" + id + ", corpName=" + corpName + ", corpAdd1=" + corpAdd1 + ", corpAdd2=" + corpAdd2
				+ ", corpCity=" + corpCity + ", corpState=" + corpState + ", corpZip=" + corpZip + ", corpPhone="
				+ corpPhone + ", corpFax=" + corpFax + ", corpFid=" + corpFid + ", corpEmail=" + corpEmail
				+ ", cMailadd1=" + cMailadd1 + ", cMailadd2=" + cMailadd2 + ", cMailcity=" + cMailcity + ", cMailstate="
				+ cMailstate + ", cMailzip=" + cMailzip + ", cLast=" + cLast + ", cFirst=" + cFirst + ", cMiddle="
				+ cMiddle + ", cSuffix=" + cSuffix + ", cTitle=" + cTitle + ", cComments=" + cComments + ", cUserid="
				+ cUserid + ", cEntrytm=" + cEntrytm + ", corpPhoneExt=" + corpPhoneExt + ", corpCountry=" + corpCountry
				+ "]";
	}


	

}
