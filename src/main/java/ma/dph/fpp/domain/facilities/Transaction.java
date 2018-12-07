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
@Entity(name = "transactions")
public class Transaction {

	public Transaction(Integer regId, Date rcpfeedt, String checkno, String amount, String certaction, String printed,
			Date printTm, String tUserid, Date tEntrytm, String batchNo) {
		super();
		this.regId = regId;
		this.rcpfeedt = rcpfeedt;
		this.checkno = checkno;
		this.amount = amount;
		this.certaction = certaction;
		this.printed = printed;
		this.printTm = printTm;
		this.tUserid = tUserid;
		this.tEntrytm = tEntrytm;
		this.batchNo = batchNo;
	}

	public Transaction(Integer id, Integer regId, Date rcpfeedt, String checkno, String amount, String certaction,
			String printed, Date printTm, String tUserid, Date tEntrytm, String batchNo) {
		super();
		this.id = id;
		this.regId = regId;
		this.rcpfeedt = rcpfeedt;
		this.checkno = checkno;
		this.amount = amount;
		this.certaction = certaction;
		this.printed = printed;
		this.printTm = printTm;
		this.tUserid = tUserid;
		this.tEntrytm = tEntrytm;
		this.batchNo = batchNo;
	}

	public Transaction(){}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "trans_id", nullable=false)
	private Integer id;
	
	
	@Column(name = "reg_id", nullable=false)
	private Integer regId;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	@Column(name = "rcpfeedt", nullable=true)
	private Date rcpfeedt;
	
	@Column(name = "checkno", nullable=true)
	private String checkno;
	
	@Column(name = "amount", nullable=true)
	private String amount;
	
	@Column(name = "certaction", nullable=true)
	private String certaction;
	
	@Column(name = "printed", nullable=true)
	private String printed;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	@Column(name = "print_tm", nullable=true)
	private Date printTm;
	
	@Column(name = "t_userid", nullable=true)
	private String tUserid;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	@Column(name = "t_entrytm", nullable=true)
	private Date tEntrytm;
	
	@Column(name = "batch_no", nullable=true)
	private String batchNo;

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
	 * @return the rcpfeedt
	 */
	public Date getRcpfeedt() {
		return rcpfeedt;
	}

	/**
	 * @param rcpfeedt the rcpfeedt to set
	 */
	public void setRcpfeedt(Date rcpfeedt) {
		this.rcpfeedt = rcpfeedt;
	}

	/**
	 * @return the checkno
	 */
	public String getCheckno() {
		return checkno;
	}

	/**
	 * @param checkno the checkno to set
	 */
	public void setCheckno(String checkno) {
		this.checkno = checkno;
	}

	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
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
	 * @return the printed
	 */
	public String getPrinted() {
		return printed;
	}

	/**
	 * @param printed the printed to set
	 */
	public void setPrinted(String printed) {
		this.printed = printed;
	}

	/**
	 * @return the printTm
	 */
	public Date getPrintTm() {
		return printTm;
	}

	/**
	 * @param printTm the printTm to set
	 */
	public void setPrintTm(Date printTm) {
		this.printTm = printTm;
	}

	/**
	 * @return the tUserid
	 */
	public String gettUserid() {
		return tUserid;
	}

	/**
	 * @param tUserid the tUserid to set
	 */
	public void settUserid(String tUserid) {
		this.tUserid = tUserid;
	}

	/**
	 * @return the tEntrytm
	 */
	public Date gettEntrytm() {
		return tEntrytm;
	}

	/**
	 * @param tEntrytm the tEntrytm to set
	 */
	public void settEntrytm(Date tEntrytm) {
		this.tEntrytm = tEntrytm;
	}

	/**
	 * @return the batchNo
	 */
	public String getBatchNo() {
		return batchNo;
	}

	/**
	 * @param batchNo the batchNo to set
	 */
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((batchNo == null) ? 0 : batchNo.hashCode());
		result = prime * result + ((certaction == null) ? 0 : certaction.hashCode());
		result = prime * result + ((checkno == null) ? 0 : checkno.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((printTm == null) ? 0 : printTm.hashCode());
		result = prime * result + ((printed == null) ? 0 : printed.hashCode());
		result = prime * result + ((rcpfeedt == null) ? 0 : rcpfeedt.hashCode());
		result = prime * result + ((regId == null) ? 0 : regId.hashCode());
		result = prime * result + ((tEntrytm == null) ? 0 : tEntrytm.hashCode());
		result = prime * result + ((tUserid == null) ? 0 : tUserid.hashCode());
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
		Transaction other = (Transaction) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (batchNo == null) {
			if (other.batchNo != null)
				return false;
		} else if (!batchNo.equals(other.batchNo))
			return false;
		if (certaction == null) {
			if (other.certaction != null)
				return false;
		} else if (!certaction.equals(other.certaction))
			return false;
		if (checkno == null) {
			if (other.checkno != null)
				return false;
		} else if (!checkno.equals(other.checkno))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (printTm == null) {
			if (other.printTm != null)
				return false;
		} else if (!printTm.equals(other.printTm))
			return false;
		if (printed == null) {
			if (other.printed != null)
				return false;
		} else if (!printed.equals(other.printed))
			return false;
		if (rcpfeedt == null) {
			if (other.rcpfeedt != null)
				return false;
		} else if (!rcpfeedt.equals(other.rcpfeedt))
			return false;
		if (regId == null) {
			if (other.regId != null)
				return false;
		} else if (!regId.equals(other.regId))
			return false;
		if (tEntrytm == null) {
			if (other.tEntrytm != null)
				return false;
		} else if (!tEntrytm.equals(other.tEntrytm))
			return false;
		if (tUserid == null) {
			if (other.tUserid != null)
				return false;
		} else if (!tUserid.equals(other.tUserid))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", regId=" + regId + ", rcpfeedt=" + rcpfeedt + ", checkno=" + checkno
				+ ", amount=" + amount + ", certaction=" + certaction + ", printed=" + printed + ", printTm=" + printTm
				+ ", tUserid=" + tUserid + ", tEntrytm=" + tEntrytm + ", batchNo=" + batchNo + "]";
	}

}
