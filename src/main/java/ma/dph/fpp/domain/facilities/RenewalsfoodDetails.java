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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author vsubramaniyan
 *
 */

@Entity(name = "v_Renewalsdetails")
public class RenewalsfoodDetails {

	
	
	public RenewalsfoodDetails(String catName, String catTitle, String dphCertno, Date dexporiss, String corpName,
			String mailAdd1, String mailAdd2, String mailCity, String mailState, String mailZip, String contact,
			String facilityName, String busAdd1, String busAdd2, String busCity, String busState, String busZip,
			String instr, String catShort, String phone, String ssn, Date dstart, Date dend, String run1st,
			String runby1st, String run2nd, String runby2nd, String run3rd, String runby3rd, String fee, String regchpt,
			String regchpt1, String urn) {
		super();
		this.catName = catName;
		this.catTitle = catTitle;
		this.dphCertno = dphCertno;
		this.dexporiss = dexporiss;
		this.corpName = corpName;
		this.mailAdd1 = mailAdd1;
		this.mailAdd2 = mailAdd2;
		this.mailCity = mailCity;
		this.mailState = mailState;
		this.mailZip = mailZip;
		this.contact = contact;
		this.facilityName = facilityName;
		this.busAdd1 = busAdd1;
		this.busAdd2 = busAdd2;
		this.busCity = busCity;
		this.busState = busState;
		this.busZip = busZip;
		this.instr = instr;
		this.catShort = catShort;
		this.phone = phone;
		this.ssn = ssn;
		this.dstart = dstart;
		this.dend = dend;
		this.run1st = run1st;
		this.runby1st = runby1st;
		this.run2nd = run2nd;
		this.runby2nd = runby2nd;
		this.run3rd = run3rd;
		this.runby3rd = runby3rd;
		this.fee = fee;
		this.regchpt = regchpt;
		this.regchpt1 = regchpt1;
		this.urn = urn;
	}

	public RenewalsfoodDetails(Integer prkey, String catName, String catTitle, String dphCertno, Date dexporiss,
			String corpName, String mailAdd1, String mailAdd2, String mailCity, String mailState, String mailZip,
			String contact, String facilityName, String busAdd1, String busAdd2, String busCity, String busState,
			String busZip, String instr, String catShort, String phone, String ssn, Date dstart, Date dend,
			String run1st, String runby1st, String run2nd, String runby2nd, String run3rd, String runby3rd, String fee,
			String regchpt, String regchpt1, String urn) {
		super();
		this.prkey = prkey;
		this.catName = catName;
		this.catTitle = catTitle;
		this.dphCertno = dphCertno;
		this.dexporiss = dexporiss;
		this.corpName = corpName;
		this.mailAdd1 = mailAdd1;
		this.mailAdd2 = mailAdd2;
		this.mailCity = mailCity;
		this.mailState = mailState;
		this.mailZip = mailZip;
		this.contact = contact;
		this.facilityName = facilityName;
		this.busAdd1 = busAdd1;
		this.busAdd2 = busAdd2;
		this.busCity = busCity;
		this.busState = busState;
		this.busZip = busZip;
		this.instr = instr;
		this.catShort = catShort;
		this.phone = phone;
		this.ssn = ssn;
		this.dstart = dstart;
		this.dend = dend;
		this.run1st = run1st;
		this.runby1st = runby1st;
		this.run2nd = run2nd;
		this.runby2nd = runby2nd;
		this.run3rd = run3rd;
		this.runby3rd = runby3rd;
		this.fee = fee;
		this.regchpt = regchpt;
		this.regchpt1 = regchpt1;
		this.urn = urn;
	}

	public RenewalsfoodDetails(String catName, String catTitle, String dphCertno, Date dexporiss, String corpName,
			String mailAdd1, String mailAdd2, String mailCity, String mailState, String mailZip, String contact,
			String facilityName, String busAdd1, String busAdd2, String busCity, String busState, String busZip,
			String instr, String catShort, String phone, String ssn, Date dstart, Date dend, String run1st,
			String runby1st, String run2nd, String runby2nd, String run3rd, String runby3rd, String fee, String regchpt,
			String regchpt1) {
		super();
		this.catName = catName;
		this.catTitle = catTitle;
		this.dphCertno = dphCertno;
		this.dexporiss = dexporiss;
		this.corpName = corpName;
		this.mailAdd1 = mailAdd1;
		this.mailAdd2 = mailAdd2;
		this.mailCity = mailCity;
		this.mailState = mailState;
		this.mailZip = mailZip;
		this.contact = contact;
		this.facilityName = facilityName;
		this.busAdd1 = busAdd1;
		this.busAdd2 = busAdd2;
		this.busCity = busCity;
		this.busState = busState;
		this.busZip = busZip;
		this.instr = instr;
		this.catShort = catShort;
		this.phone = phone;
		this.ssn = ssn;
		this.dstart = dstart;
		this.dend = dend;
		this.run1st = run1st;
		this.runby1st = runby1st;
		this.run2nd = run2nd;
		this.runby2nd = runby2nd;
		this.run3rd = run3rd;
		this.runby3rd = runby3rd;
		this.fee = fee;
		this.regchpt = regchpt;
		this.regchpt1 = regchpt1;
	}

	public RenewalsfoodDetails(Integer prkey, String catName, String catTitle, String dphCertno, Date dexporiss,
			String corpName, String mailAdd1, String mailAdd2, String mailCity, String mailState, String mailZip,
			String contact, String facilityName, String busAdd1, String busAdd2, String busCity, String busState,
			String busZip, String instr, String catShort, String phone, String ssn, Date dstart, Date dend,
			String run1st, String runby1st, String run2nd, String runby2nd, String run3rd, String runby3rd, String fee,
			String regchpt, String regchpt1) {
		super();
		this.prkey = prkey;
		this.catName = catName;
		this.catTitle = catTitle;
		this.dphCertno = dphCertno;
		this.dexporiss = dexporiss;
		this.corpName = corpName;
		this.mailAdd1 = mailAdd1;
		this.mailAdd2 = mailAdd2;
		this.mailCity = mailCity;
		this.mailState = mailState;
		this.mailZip = mailZip;
		this.contact = contact;
		this.facilityName = facilityName;
		this.busAdd1 = busAdd1;
		this.busAdd2 = busAdd2;
		this.busCity = busCity;
		this.busState = busState;
		this.busZip = busZip;
		this.instr = instr;
		this.catShort = catShort;
		this.phone = phone;
		this.ssn = ssn;
		this.dstart = dstart;
		this.dend = dend;
		this.run1st = run1st;
		this.runby1st = runby1st;
		this.run2nd = run2nd;
		this.runby2nd = runby2nd;
		this.run3rd = run3rd;
		this.runby3rd = runby3rd;
		this.fee = fee;
		this.regchpt = regchpt;
		this.regchpt1 = regchpt1;
	}

	public RenewalsfoodDetails(){
		
	}
	
	@Id
	@Column(name="prkey")
	private Integer prkey;
	

	@Column(name="cat_name")
	private String catName;
	
	@Column(name="cat_title")
	private String catTitle;
	
	@Column(name="dph_certno")
	private String dphCertno;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dexporiss")
	private Date dexporiss;
	
	@Column(name="corp_name")
	private String corpName;
	
	@Column(name="mail_add1")
	private String mailAdd1;
	
	@Column(name="mail_add2")
	private String mailAdd2;
	
	@Column(name="mail_city")
	private String mailCity;
	
	@Column(name="mail_state")
	private String mailState;
	
	@Column(name="mail_zip")
	private String mailZip;
	
	@Column(name="contact")
	private String contact;
	
	@Column(name="facility_name")
	private String facilityName;
	
	@Column(name="bus_add1")
	private String busAdd1;
	
	@Column(name="bus_add2")
	private String busAdd2;
	
	@Column(name="bus_city")
	private String busCity;
	
	@Column(name="bus_state")
	private String busState;
	
	@Column(name="bus_zip")
	private String busZip;
	
	@Column(name="instr")
	private String instr;
	
	@Column(name="cat_short")
	private String catShort;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="SSN")
	private String ssn;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM-dd-yyyy" )	
	@Column(name="dstart")
	private Date dstart;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM-dd-yyyy" )	
	@Column(name="dend")
	private Date dend;
	
	@Column(name="run_1st")
	private String run1st;
	
	@Column(name="runby_1st")
	private String runby1st;
	
	@Column(name="run_2nd")
	private String run2nd;
	
	@Column(name="runby_2nd")
	private String runby2nd;
	
	@Column(name="run_3rd")
	private String run3rd;
	
	@Column(name="runby_3rd")
	private String runby3rd;
	
	@Column(name="fee")
	private String fee;
	
	@Column(name="regchpt")
	private String regchpt;
	
	@Column(name="regchpt1")
	private String regchpt1;
	
	@Column(name="URN")
	private String urn;

	/**
	 * @return the prkey
	 */
	public Integer getPrkey() {
		return prkey;
	}

	/**
	 * @param prkey the prkey to set
	 */
	public void setPrkey(Integer prkey) {
		this.prkey = prkey;
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
	 * @return the catTitle
	 */
	public String getCatTitle() {
		return catTitle;
	}

	/**
	 * @param catTitle the catTitle to set
	 */
	public void setCatTitle(String catTitle) {
		this.catTitle = catTitle;
	}

	/**
	 * @return the dphCertno
	 */
	public String getDphCertno() {
		return dphCertno;
	}

	/**
	 * @param dphCertno the dphCertno to set
	 */
	public void setDphCertno(String dphCertno) {
		this.dphCertno = dphCertno;
	}

	/**
	 * @return the dexporiss
	 */
	public Date getDexporiss() {
		return dexporiss;
	}

	/**
	 * @param dexporiss the dexporiss to set
	 */
	public void setDexporiss(Date dexporiss) {
		this.dexporiss = dexporiss;
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
	 * @return the mailAdd1
	 */
	public String getMailAdd1() {
		return mailAdd1;
	}

	/**
	 * @param mailAdd1 the mailAdd1 to set
	 */
	public void setMailAdd1(String mailAdd1) {
		this.mailAdd1 = mailAdd1;
	}

	/**
	 * @return the mailAdd2
	 */
	public String getMailAdd2() {
		return mailAdd2;
	}

	/**
	 * @param mailAdd2 the mailAdd2 to set
	 */
	public void setMailAdd2(String mailAdd2) {
		this.mailAdd2 = mailAdd2;
	}

	/**
	 * @return the mailCity
	 */
	public String getMailCity() {
		return mailCity;
	}

	/**
	 * @param mailCity the mailCity to set
	 */
	public void setMailCity(String mailCity) {
		this.mailCity = mailCity;
	}

	/**
	 * @return the mailState
	 */
	public String getMailState() {
		return mailState;
	}

	/**
	 * @param mailState the mailState to set
	 */
	public void setMailState(String mailState) {
		this.mailState = mailState;
	}

	/**
	 * @return the mailZip
	 */
	public String getMailZip() {
		return mailZip;
	}

	/**
	 * @param mailZip the mailZip to set
	 */
	public void setMailZip(String mailZip) {
		this.mailZip = mailZip;
	}

	/**
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
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
	 * @return the busAdd1
	 */
	public String getBusAdd1() {
		return busAdd1;
	}

	/**
	 * @param busAdd1 the busAdd1 to set
	 */
	public void setBusAdd1(String busAdd1) {
		this.busAdd1 = busAdd1;
	}

	/**
	 * @return the busAdd2
	 */
	public String getBusAdd2() {
		return busAdd2;
	}

	/**
	 * @param busAdd2 the busAdd2 to set
	 */
	public void setBusAdd2(String busAdd2) {
		this.busAdd2 = busAdd2;
	}

	/**
	 * @return the busCity
	 */
	public String getBusCity() {
		return busCity;
	}

	/**
	 * @param busCity the busCity to set
	 */
	public void setBusCity(String busCity) {
		this.busCity = busCity;
	}

	/**
	 * @return the busState
	 */
	public String getBusState() {
		return busState;
	}

	/**
	 * @param busState the busState to set
	 */
	public void setBusState(String busState) {
		this.busState = busState;
	}

	/**
	 * @return the busZip
	 */
	public String getBusZip() {
		return busZip;
	}

	/**
	 * @param busZip the busZip to set
	 */
	public void setBusZip(String busZip) {
		this.busZip = busZip;
	}

	/**
	 * @return the instr
	 */
	public String getInstr() {
		return instr;
	}

	/**
	 * @param instr the instr to set
	 */
	public void setInstr(String instr) {
		this.instr = instr;
	}

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
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the ssn
	 */
	public String getSsn() {
		return ssn;
	}

	/**
	 * @param ssn the ssn to set
	 */
	public void setSsn(String ssn) {
		this.ssn = ssn;
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
	 * @return the run1st
	 */
	public String getRun1st() {
		return run1st;
	}

	/**
	 * @param run1st the run1st to set
	 */
	public void setRun1st(String run1st) {
		this.run1st = run1st;
	}

	/**
	 * @return the runby1st
	 */
	public String getRunby1st() {
		return runby1st;
	}

	/**
	 * @param runby1st the runby1st to set
	 */
	public void setRunby1st(String runby1st) {
		this.runby1st = runby1st;
	}

	/**
	 * @return the run2nd
	 */
	public String getRun2nd() {
		return run2nd;
	}

	/**
	 * @param run2nd the run2nd to set
	 */
	public void setRun2nd(String run2nd) {
		this.run2nd = run2nd;
	}

	/**
	 * @return the runby2nd
	 */
	public String getRunby2nd() {
		return runby2nd;
	}

	/**
	 * @param runby2nd the runby2nd to set
	 */
	public void setRunby2nd(String runby2nd) {
		this.runby2nd = runby2nd;
	}

	/**
	 * @return the run3rd
	 */
	public String getRun3rd() {
		return run3rd;
	}

	/**
	 * @param run3rd the run3rd to set
	 */
	public void setRun3rd(String run3rd) {
		this.run3rd = run3rd;
	}

	/**
	 * @return the runby3rd
	 */
	public String getRunby3rd() {
		return runby3rd;
	}

	/**
	 * @param runby3rd the runby3rd to set
	 */
	public void setRunby3rd(String runby3rd) {
		this.runby3rd = runby3rd;
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
	 * @return the regchpt1
	 */
	public String getRegchpt1() {
		return regchpt1;
	}

	/**
	 * @param regchpt1 the regchpt1 to set
	 */
	public void setRegchpt1(String regchpt1) {
		this.regchpt1 = regchpt1;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((busAdd1 == null) ? 0 : busAdd1.hashCode());
		result = prime * result + ((busAdd2 == null) ? 0 : busAdd2.hashCode());
		result = prime * result + ((busCity == null) ? 0 : busCity.hashCode());
		result = prime * result + ((busState == null) ? 0 : busState.hashCode());
		result = prime * result + ((busZip == null) ? 0 : busZip.hashCode());
		result = prime * result + ((catName == null) ? 0 : catName.hashCode());
		result = prime * result + ((catShort == null) ? 0 : catShort.hashCode());
		result = prime * result + ((catTitle == null) ? 0 : catTitle.hashCode());
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result + ((corpName == null) ? 0 : corpName.hashCode());
		result = prime * result + ((dend == null) ? 0 : dend.hashCode());
		result = prime * result + ((dexporiss == null) ? 0 : dexporiss.hashCode());
		result = prime * result + ((dphCertno == null) ? 0 : dphCertno.hashCode());
		result = prime * result + ((dstart == null) ? 0 : dstart.hashCode());
		result = prime * result + ((facilityName == null) ? 0 : facilityName.hashCode());
		result = prime * result + ((fee == null) ? 0 : fee.hashCode());
		result = prime * result + ((instr == null) ? 0 : instr.hashCode());
		result = prime * result + ((mailAdd1 == null) ? 0 : mailAdd1.hashCode());
		result = prime * result + ((mailAdd2 == null) ? 0 : mailAdd2.hashCode());
		result = prime * result + ((mailCity == null) ? 0 : mailCity.hashCode());
		result = prime * result + ((mailState == null) ? 0 : mailState.hashCode());
		result = prime * result + ((mailZip == null) ? 0 : mailZip.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((prkey == null) ? 0 : prkey.hashCode());
		result = prime * result + ((regchpt == null) ? 0 : regchpt.hashCode());
		result = prime * result + ((regchpt1 == null) ? 0 : regchpt1.hashCode());
		result = prime * result + ((run1st == null) ? 0 : run1st.hashCode());
		result = prime * result + ((run2nd == null) ? 0 : run2nd.hashCode());
		result = prime * result + ((run3rd == null) ? 0 : run3rd.hashCode());
		result = prime * result + ((runby1st == null) ? 0 : runby1st.hashCode());
		result = prime * result + ((runby2nd == null) ? 0 : runby2nd.hashCode());
		result = prime * result + ((runby3rd == null) ? 0 : runby3rd.hashCode());
		result = prime * result + ((ssn == null) ? 0 : ssn.hashCode());
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
		RenewalsfoodDetails other = (RenewalsfoodDetails) obj;
		if (busAdd1 == null) {
			if (other.busAdd1 != null)
				return false;
		} else if (!busAdd1.equals(other.busAdd1))
			return false;
		if (busAdd2 == null) {
			if (other.busAdd2 != null)
				return false;
		} else if (!busAdd2.equals(other.busAdd2))
			return false;
		if (busCity == null) {
			if (other.busCity != null)
				return false;
		} else if (!busCity.equals(other.busCity))
			return false;
		if (busState == null) {
			if (other.busState != null)
				return false;
		} else if (!busState.equals(other.busState))
			return false;
		if (busZip == null) {
			if (other.busZip != null)
				return false;
		} else if (!busZip.equals(other.busZip))
			return false;
		if (catName == null) {
			if (other.catName != null)
				return false;
		} else if (!catName.equals(other.catName))
			return false;
		if (catShort == null) {
			if (other.catShort != null)
				return false;
		} else if (!catShort.equals(other.catShort))
			return false;
		if (catTitle == null) {
			if (other.catTitle != null)
				return false;
		} else if (!catTitle.equals(other.catTitle))
			return false;
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.equals(other.contact))
			return false;
		if (corpName == null) {
			if (other.corpName != null)
				return false;
		} else if (!corpName.equals(other.corpName))
			return false;
		if (dend == null) {
			if (other.dend != null)
				return false;
		} else if (!dend.equals(other.dend))
			return false;
		if (dexporiss == null) {
			if (other.dexporiss != null)
				return false;
		} else if (!dexporiss.equals(other.dexporiss))
			return false;
		if (dphCertno == null) {
			if (other.dphCertno != null)
				return false;
		} else if (!dphCertno.equals(other.dphCertno))
			return false;
		if (dstart == null) {
			if (other.dstart != null)
				return false;
		} else if (!dstart.equals(other.dstart))
			return false;
		if (facilityName == null) {
			if (other.facilityName != null)
				return false;
		} else if (!facilityName.equals(other.facilityName))
			return false;
		if (fee == null) {
			if (other.fee != null)
				return false;
		} else if (!fee.equals(other.fee))
			return false;
		if (instr == null) {
			if (other.instr != null)
				return false;
		} else if (!instr.equals(other.instr))
			return false;
		if (mailAdd1 == null) {
			if (other.mailAdd1 != null)
				return false;
		} else if (!mailAdd1.equals(other.mailAdd1))
			return false;
		if (mailAdd2 == null) {
			if (other.mailAdd2 != null)
				return false;
		} else if (!mailAdd2.equals(other.mailAdd2))
			return false;
		if (mailCity == null) {
			if (other.mailCity != null)
				return false;
		} else if (!mailCity.equals(other.mailCity))
			return false;
		if (mailState == null) {
			if (other.mailState != null)
				return false;
		} else if (!mailState.equals(other.mailState))
			return false;
		if (mailZip == null) {
			if (other.mailZip != null)
				return false;
		} else if (!mailZip.equals(other.mailZip))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (prkey == null) {
			if (other.prkey != null)
				return false;
		} else if (!prkey.equals(other.prkey))
			return false;
		if (regchpt == null) {
			if (other.regchpt != null)
				return false;
		} else if (!regchpt.equals(other.regchpt))
			return false;
		if (regchpt1 == null) {
			if (other.regchpt1 != null)
				return false;
		} else if (!regchpt1.equals(other.regchpt1))
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
		if (runby1st == null) {
			if (other.runby1st != null)
				return false;
		} else if (!runby1st.equals(other.runby1st))
			return false;
		if (runby2nd == null) {
			if (other.runby2nd != null)
				return false;
		} else if (!runby2nd.equals(other.runby2nd))
			return false;
		if (runby3rd == null) {
			if (other.runby3rd != null)
				return false;
		} else if (!runby3rd.equals(other.runby3rd))
			return false;
		if (ssn == null) {
			if (other.ssn != null)
				return false;
		} else if (!ssn.equals(other.ssn))
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
		return "RenewalsfoodDetails [prkey=" + prkey + ", catName=" + catName + ", catTitle=" + catTitle
				+ ", dphCertno=" + dphCertno + ", dexporiss=" + dexporiss + ", corpName=" + corpName + ", mailAdd1="
				+ mailAdd1 + ", mailAdd2=" + mailAdd2 + ", mailCity=" + mailCity + ", mailState=" + mailState
				+ ", mailZip=" + mailZip + ", contact=" + contact + ", facilityName=" + facilityName + ", busAdd1="
				+ busAdd1 + ", busAdd2=" + busAdd2 + ", busCity=" + busCity + ", busState=" + busState + ", busZip="
				+ busZip + ", instr=" + instr + ", catShort=" + catShort + ", phone=" + phone + ", ssn=" + ssn
				+ ", dstart=" + dstart + ", dend=" + dend + ", run1st=" + run1st + ", runby1st=" + runby1st
				+ ", run2nd=" + run2nd + ", runby2nd=" + runby2nd + ", run3rd=" + run3rd + ", runby3rd=" + runby3rd
				+ ", fee=" + fee + ", regchpt=" + regchpt + ", regchpt1=" + regchpt1 + ", urn=" + urn + "]";
	}

	
	
	
}
