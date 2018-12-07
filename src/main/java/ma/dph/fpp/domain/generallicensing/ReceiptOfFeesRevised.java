package ma.dph.fpp.domain.generallicensing;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name = "rctfee")
public class ReceiptOfFeesRevised {
	
	public ReceiptOfFeesRevised(String packageReceiptOfFee, String batchNumber, String certification,
			String appfacyname, String appfacid, String scanPrintKey, String openedBy, Date receiptFeeDate,
			String routinCode, String checkAccountNumber, String checkNumber, String applicant, String payer,
			String accountNumber, String accountName, String amount, String runBy, Date transmittalDate,
			String firstName, String lastName, String middleName, String generation, String status, Date statusUpdate,
			String commentOntheFacility, String checkInstance, Date dateReceived, String oldBatchNo,
			String oldReceiptFeeDate, String oldCheckNumber, String createdby, Date createdtime, String modifiedby,
			Date modifiedtime) {
		super();
		this.packageReceiptOfFee = packageReceiptOfFee;
		this.batchNumber = batchNumber;
		this.certification = certification;
		this.appfacyname = appfacyname;
		this.appfacid = appfacid;
		this.scanPrintKey = scanPrintKey;
		this.openedBy = openedBy;
		this.receiptFeeDate = receiptFeeDate;
		this.routinCode = routinCode;
		this.checkAccountNumber = checkAccountNumber;
		this.checkNumber = checkNumber;
		this.applicant = applicant;
		this.payer = payer;
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.amount = amount;
		this.runBy = runBy;
		this.transmittalDate = transmittalDate;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.generation = generation;
		this.status = status;
		this.statusUpdate = statusUpdate;
		this.commentOntheFacility = commentOntheFacility;
		this.checkInstance = checkInstance;
		this.dateReceived = dateReceived;
		this.oldBatchNo = oldBatchNo;
		this.oldReceiptFeeDate = oldReceiptFeeDate;
		this.oldCheckNumber = oldCheckNumber;
		this.createdby = createdby;
		this.createdtime = createdtime;
		this.modifiedby = modifiedby;
		this.modifiedtime = modifiedtime;
	}




	public ReceiptOfFeesRevised(Integer id, String packageReceiptOfFee, String batchNumber, String certification,
			String appfacyname, String appfacid, String scanPrintKey, String openedBy, Date receiptFeeDate,
			String routinCode, String checkAccountNumber, String checkNumber, String applicant, String payer,
			String accountNumber, String accountName, String amount, String runBy, Date transmittalDate,
			String firstName, String lastName, String middleName, String generation, String status, Date statusUpdate,
			String commentOntheFacility, String checkInstance, Date dateReceived, String oldBatchNo,
			String oldReceiptFeeDate, String oldCheckNumber, String createdby, Date createdtime, String modifiedby,
			Date modifiedtime) {
		super();
		this.id = id;
		this.packageReceiptOfFee = packageReceiptOfFee;
		this.batchNumber = batchNumber;
		this.certification = certification;
		this.appfacyname = appfacyname;
		this.appfacid = appfacid;
		this.scanPrintKey = scanPrintKey;
		this.openedBy = openedBy;
		this.receiptFeeDate = receiptFeeDate;
		this.routinCode = routinCode;
		this.checkAccountNumber = checkAccountNumber;
		this.checkNumber = checkNumber;
		this.applicant = applicant;
		this.payer = payer;
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.amount = amount;
		this.runBy = runBy;
		this.transmittalDate = transmittalDate;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.generation = generation;
		this.status = status;
		this.statusUpdate = statusUpdate;
		this.commentOntheFacility = commentOntheFacility;
		this.checkInstance = checkInstance;
		this.dateReceived = dateReceived;
		this.oldBatchNo = oldBatchNo;
		this.oldReceiptFeeDate = oldReceiptFeeDate;
		this.oldCheckNumber = oldCheckNumber;
		this.createdby = createdby;
		this.createdtime = createdtime;
		this.modifiedby = modifiedby;
		this.modifiedtime = modifiedtime;
	}






	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "Id", nullable=true)
	private Integer id; 
	
	@Column(name = "pk_rctfee", nullable=true)
	private String packageReceiptOfFee;
	
	@Column(name = "batch_no", nullable=true)
	private String batchNumber;
	
	@Column(name = "certaction", nullable=true)
	private String certification;
	
	@Column(name = "appfacyname", nullable=true)
	private String appfacyname;
	
	@Column(name = "appfacid", nullable=true)
	private String appfacid;
	
	@Column(name = "scanpkey", nullable=true)
	private String scanPrintKey;

	@Column(name = "opened_by", nullable=true)
	private String openedBy;

	@Column(name = "recfeedt", nullable=true)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd" )
	private Date receiptFeeDate;

	@Column(name = "routincode", nullable=true)
	private String routinCode;

	@Column(name = "acctno", nullable=true)
	private String checkAccountNumber;

	@Column(name = "check_num", nullable=true)
	private String checkNumber;

	@Column(name = "applicant", nullable=true)
	private String applicant;

	@Column(name = "payer", nullable=true)
	private String payer;

	@Column(name = "acct_no", nullable=true)
	private String accountNumber;

	@Column(name = "acct_name", nullable=true)
	private String accountName;

	@Column(name = "amount", nullable=true)
	private String amount;

	@Column(name = "run_by", nullable=true)
	private String runBy;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM-dd-yyyy" )	
	@Column(name = "transmdate", nullable=true)
	private Date transmittalDate;

	@Column(name = "first_name", nullable=true)
	private String firstName;

	@Column(name = "last_name", nullable=true)
	private String lastName;

	@Column(name = "middle", nullable=true)
	private String middleName;

	@Column(name = "generation", nullable=true)
	private String generation;

	@Column(name = "status", nullable=true)
	private String status;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM-dd-yyyy" )	
	@Column(name = "statusupdt", nullable=true)
	private Date statusUpdate;

	@Column(name = "comment", nullable=true)
	private String commentOntheFacility;

	@Column(name = "check_inst", nullable=true)
	private String checkInstance;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM-dd-yyyy" )	
	@Column(name = "dtreceive", nullable=true)
	private Date dateReceived;

	@Column(name = "oldbatchno", nullable=true)
	private String oldBatchNo;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM-dd-yyyy" )	
	@Column(name = "oldrcfeedt", nullable=true)
	private String oldReceiptFeeDate;

	@Column(name = "oldcheckno", nullable=true)
	private String oldCheckNumber;
	
	@Column(name = "createdby", nullable=true)
	private String createdby;
	
	@Column(name = "createdtime", nullable=true)
	private Date createdtime;
	
	@Column(name = "modifiedby", nullable=true)
	private String modifiedby;
	
	@Column(name = "modifiedtime", nullable=true)
	private Date modifiedtime;






	public ReceiptOfFeesRevised() {}




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
	 * @return the packageReceiptOfFee
	 */
	public String getPackageReceiptOfFee() {
		return packageReceiptOfFee;
	}




	/**
	 * @param packageReceiptOfFee the packageReceiptOfFee to set
	 */
	public void setPackageReceiptOfFee(String packageReceiptOfFee) {
		this.packageReceiptOfFee = packageReceiptOfFee;
	}




	/**
	 * @return the batchNumber
	 */
	public String getBatchNumber() {
		return batchNumber;
	}




	/**
	 * @param batchNumber the batchNumber to set
	 */
	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}




	/**
	 * @return the certification
	 */
	public String getCertification() {
		return certification;
	}




	/**
	 * @param certification the certification to set
	 */
	public void setCertification(String certification) {
		this.certification = certification;
	}




	/**
	 * @return the appfacyname
	 */
	public String getAppfacyname() {
		return appfacyname;
	}




	/**
	 * @param appfacyname the appfacyname to set
	 */
	public void setAppfacyname(String appfacyname) {
		this.appfacyname = appfacyname;
	}




	/**
	 * @return the appfacid
	 */
	public String getAppfacid() {
		return appfacid;
	}




	/**
	 * @param appfacid the appfacid to set
	 */
	public void setAppfacid(String appfacid) {
		this.appfacid = appfacid;
	}




	/**
	 * @return the scanPrintKey
	 */
	public String getScanPrintKey() {
		return scanPrintKey;
	}




	/**
	 * @param scanPrintKey the scanPrintKey to set
	 */
	public void setScanPrintKey(String scanPrintKey) {
		this.scanPrintKey = scanPrintKey;
	}




	/**
	 * @return the openedBy
	 */
	public String getOpenedBy() {
		return openedBy;
	}




	/**
	 * @param openedBy the openedBy to set
	 */
	public void setOpenedBy(String openedBy) {
		this.openedBy = openedBy;
	}




	/**
	 * @return the receiptFeeDate
	 */
	public Date getReceiptFeeDate() {
		return receiptFeeDate;
	}




	/**
	 * @param receiptFeeDate the receiptFeeDate to set
	 */
	public void setReceiptFeeDate(Date receiptFeeDate) {
		this.receiptFeeDate = receiptFeeDate;
	}




	/**
	 * @return the routinCode
	 */
	public String getRoutinCode() {
		return routinCode;
	}




	/**
	 * @param routinCode the routinCode to set
	 */
	public void setRoutinCode(String routinCode) {
		this.routinCode = routinCode;
	}




	/**
	 * @return the checkAccountNumber
	 */
	public String getCheckAccountNumber() {
		return checkAccountNumber;
	}




	/**
	 * @param checkAccountNumber the checkAccountNumber to set
	 */
	public void setCheckAccountNumber(String checkAccountNumber) {
		this.checkAccountNumber = checkAccountNumber;
	}




	/**
	 * @return the checkNumber
	 */
	public String getCheckNumber() {
		return checkNumber;
	}




	/**
	 * @param checkNumber the checkNumber to set
	 */
	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}




	/**
	 * @return the applicant
	 */
	public String getApplicant() {
		return applicant;
	}




	/**
	 * @param applicant the applicant to set
	 */
	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}




	/**
	 * @return the payer
	 */
	public String getPayer() {
		return payer;
	}




	/**
	 * @param payer the payer to set
	 */
	public void setPayer(String payer) {
		this.payer = payer;
	}




	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}




	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}




	/**
	 * @return the accountName
	 */
	public String getAccountName() {
		return accountName;
	}




	/**
	 * @param accountName the accountName to set
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
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
	 * @return the runBy
	 */
	public String getRunBy() {
		return runBy;
	}




	/**
	 * @param runBy the runBy to set
	 */
	public void setRunBy(String runBy) {
		this.runBy = runBy;
	}




	/**
	 * @return the transmittalDate
	 */
	public Date getTransmittalDate() {
		return transmittalDate;
	}




	/**
	 * @param transmittalDate the transmittalDate to set
	 */
	public void setTransmittalDate(Date transmittalDate) {
		this.transmittalDate = transmittalDate;
	}




	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}




	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}




	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}




	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}




	/**
	 * @return the generation
	 */
	public String getGeneration() {
		return generation;
	}




	/**
	 * @param generation the generation to set
	 */
	public void setGeneration(String generation) {
		this.generation = generation;
	}




	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}




	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}




	/**
	 * @return the statusUpdate
	 */
	public Date getStatusUpdate() {
		return statusUpdate;
	}




	/**
	 * @param statusUpdate the statusUpdate to set
	 */
	public void setStatusUpdate(Date statusUpdate) {
		this.statusUpdate = statusUpdate;
	}




	/**
	 * @return the commentOntheFacility
	 */
	public String getCommentOntheFacility() {
		return commentOntheFacility;
	}




	/**
	 * @param commentOntheFacility the commentOntheFacility to set
	 */
	public void setCommentOntheFacility(String commentOntheFacility) {
		this.commentOntheFacility = commentOntheFacility;
	}




	/**
	 * @return the checkInstance
	 */
	public String getCheckInstance() {
		return checkInstance;
	}




	/**
	 * @param checkInstance the checkInstance to set
	 */
	public void setCheckInstance(String checkInstance) {
		this.checkInstance = checkInstance;
	}




	/**
	 * @return the dateReceived
	 */
	public Date getDateReceived() {
		return dateReceived;
	}




	/**
	 * @param dateReceived the dateReceived to set
	 */
	public void setDateReceived(Date dateReceived) {
		this.dateReceived = dateReceived;
	}




	/**
	 * @return the oldBatchNo
	 */
	public String getOldBatchNo() {
		return oldBatchNo;
	}




	/**
	 * @param oldBatchNo the oldBatchNo to set
	 */
	public void setOldBatchNo(String oldBatchNo) {
		this.oldBatchNo = oldBatchNo;
	}




	/**
	 * @return the oldReceiptFeeDate
	 */
	public String getOldReceiptFeeDate() {
		return oldReceiptFeeDate;
	}




	/**
	 * @param oldReceiptFeeDate the oldReceiptFeeDate to set
	 */
	public void setOldReceiptFeeDate(String oldReceiptFeeDate) {
		this.oldReceiptFeeDate = oldReceiptFeeDate;
	}




	/**
	 * @return the oldCheckNumber
	 */
	public String getOldCheckNumber() {
		return oldCheckNumber;
	}




	/**
	 * @param oldCheckNumber the oldCheckNumber to set
	 */
	public void setOldCheckNumber(String oldCheckNumber) {
		this.oldCheckNumber = oldCheckNumber;
	}




	/**
	 * @return the createdby
	 */
	public String getCreatedby() {
		return createdby;
	}




	/**
	 * @param createdby the createdby to set
	 */
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}




	/**
	 * @return the createdtime
	 */
	public Date getCreatedtime() {
		return createdtime;
	}




	/**
	 * @param createdtime the createdtime to set
	 */
	public void setCreatedtime(Date createdtime) {
		this.createdtime = createdtime;
	}




	/**
	 * @return the modifiedby
	 */
	public String getModifiedby() {
		return modifiedby;
	}




	/**
	 * @param modifiedby the modifiedby to set
	 */
	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}




	/**
	 * @return the modifiedtime
	 */
	public Date getModifiedtime() {
		return modifiedtime;
	}




	/**
	 * @param modifiedtime the modifiedtime to set
	 */
	public void setModifiedtime(Date modifiedtime) {
		this.modifiedtime = modifiedtime;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountName == null) ? 0 : accountName.hashCode());
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((appfacid == null) ? 0 : appfacid.hashCode());
		result = prime * result + ((appfacyname == null) ? 0 : appfacyname.hashCode());
		result = prime * result + ((applicant == null) ? 0 : applicant.hashCode());
		result = prime * result + ((batchNumber == null) ? 0 : batchNumber.hashCode());
		result = prime * result + ((certification == null) ? 0 : certification.hashCode());
		result = prime * result + ((checkAccountNumber == null) ? 0 : checkAccountNumber.hashCode());
		result = prime * result + ((checkInstance == null) ? 0 : checkInstance.hashCode());
		result = prime * result + ((checkNumber == null) ? 0 : checkNumber.hashCode());
		result = prime * result + ((commentOntheFacility == null) ? 0 : commentOntheFacility.hashCode());
		result = prime * result + ((createdby == null) ? 0 : createdby.hashCode());
		result = prime * result + ((createdtime == null) ? 0 : createdtime.hashCode());
		result = prime * result + ((dateReceived == null) ? 0 : dateReceived.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((generation == null) ? 0 : generation.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((middleName == null) ? 0 : middleName.hashCode());
		result = prime * result + ((modifiedby == null) ? 0 : modifiedby.hashCode());
		result = prime * result + ((modifiedtime == null) ? 0 : modifiedtime.hashCode());
		result = prime * result + ((oldBatchNo == null) ? 0 : oldBatchNo.hashCode());
		result = prime * result + ((oldCheckNumber == null) ? 0 : oldCheckNumber.hashCode());
		result = prime * result + ((oldReceiptFeeDate == null) ? 0 : oldReceiptFeeDate.hashCode());
		result = prime * result + ((openedBy == null) ? 0 : openedBy.hashCode());
		result = prime * result + ((packageReceiptOfFee == null) ? 0 : packageReceiptOfFee.hashCode());
		result = prime * result + ((payer == null) ? 0 : payer.hashCode());
		result = prime * result + ((receiptFeeDate == null) ? 0 : receiptFeeDate.hashCode());
		result = prime * result + ((routinCode == null) ? 0 : routinCode.hashCode());
		result = prime * result + ((runBy == null) ? 0 : runBy.hashCode());
		result = prime * result + ((scanPrintKey == null) ? 0 : scanPrintKey.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((statusUpdate == null) ? 0 : statusUpdate.hashCode());
		result = prime * result + ((transmittalDate == null) ? 0 : transmittalDate.hashCode());
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
		ReceiptOfFeesRevised other = (ReceiptOfFeesRevised) obj;
		if (accountName == null) {
			if (other.accountName != null)
				return false;
		} else if (!accountName.equals(other.accountName))
			return false;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (appfacid == null) {
			if (other.appfacid != null)
				return false;
		} else if (!appfacid.equals(other.appfacid))
			return false;
		if (appfacyname == null) {
			if (other.appfacyname != null)
				return false;
		} else if (!appfacyname.equals(other.appfacyname))
			return false;
		if (applicant == null) {
			if (other.applicant != null)
				return false;
		} else if (!applicant.equals(other.applicant))
			return false;
		if (batchNumber == null) {
			if (other.batchNumber != null)
				return false;
		} else if (!batchNumber.equals(other.batchNumber))
			return false;
		if (certification == null) {
			if (other.certification != null)
				return false;
		} else if (!certification.equals(other.certification))
			return false;
		if (checkAccountNumber == null) {
			if (other.checkAccountNumber != null)
				return false;
		} else if (!checkAccountNumber.equals(other.checkAccountNumber))
			return false;
		if (checkInstance == null) {
			if (other.checkInstance != null)
				return false;
		} else if (!checkInstance.equals(other.checkInstance))
			return false;
		if (checkNumber == null) {
			if (other.checkNumber != null)
				return false;
		} else if (!checkNumber.equals(other.checkNumber))
			return false;
		if (commentOntheFacility == null) {
			if (other.commentOntheFacility != null)
				return false;
		} else if (!commentOntheFacility.equals(other.commentOntheFacility))
			return false;
		if (createdby == null) {
			if (other.createdby != null)
				return false;
		} else if (!createdby.equals(other.createdby))
			return false;
		if (createdtime == null) {
			if (other.createdtime != null)
				return false;
		} else if (!createdtime.equals(other.createdtime))
			return false;
		if (dateReceived == null) {
			if (other.dateReceived != null)
				return false;
		} else if (!dateReceived.equals(other.dateReceived))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (generation == null) {
			if (other.generation != null)
				return false;
		} else if (!generation.equals(other.generation))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (middleName == null) {
			if (other.middleName != null)
				return false;
		} else if (!middleName.equals(other.middleName))
			return false;
		if (modifiedby == null) {
			if (other.modifiedby != null)
				return false;
		} else if (!modifiedby.equals(other.modifiedby))
			return false;
		if (modifiedtime == null) {
			if (other.modifiedtime != null)
				return false;
		} else if (!modifiedtime.equals(other.modifiedtime))
			return false;
		if (oldBatchNo == null) {
			if (other.oldBatchNo != null)
				return false;
		} else if (!oldBatchNo.equals(other.oldBatchNo))
			return false;
		if (oldCheckNumber == null) {
			if (other.oldCheckNumber != null)
				return false;
		} else if (!oldCheckNumber.equals(other.oldCheckNumber))
			return false;
		if (oldReceiptFeeDate == null) {
			if (other.oldReceiptFeeDate != null)
				return false;
		} else if (!oldReceiptFeeDate.equals(other.oldReceiptFeeDate))
			return false;
		if (openedBy == null) {
			if (other.openedBy != null)
				return false;
		} else if (!openedBy.equals(other.openedBy))
			return false;
		if (packageReceiptOfFee == null) {
			if (other.packageReceiptOfFee != null)
				return false;
		} else if (!packageReceiptOfFee.equals(other.packageReceiptOfFee))
			return false;
		if (payer == null) {
			if (other.payer != null)
				return false;
		} else if (!payer.equals(other.payer))
			return false;
		if (receiptFeeDate == null) {
			if (other.receiptFeeDate != null)
				return false;
		} else if (!receiptFeeDate.equals(other.receiptFeeDate))
			return false;
		if (routinCode == null) {
			if (other.routinCode != null)
				return false;
		} else if (!routinCode.equals(other.routinCode))
			return false;
		if (runBy == null) {
			if (other.runBy != null)
				return false;
		} else if (!runBy.equals(other.runBy))
			return false;
		if (scanPrintKey == null) {
			if (other.scanPrintKey != null)
				return false;
		} else if (!scanPrintKey.equals(other.scanPrintKey))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (statusUpdate == null) {
			if (other.statusUpdate != null)
				return false;
		} else if (!statusUpdate.equals(other.statusUpdate))
			return false;
		if (transmittalDate == null) {
			if (other.transmittalDate != null)
				return false;
		} else if (!transmittalDate.equals(other.transmittalDate))
			return false;
		return true;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ReceiptOfFeesRevised [id=" + id + ", packageReceiptOfFee=" + packageReceiptOfFee + ", batchNumber="
				+ batchNumber + ", certification=" + certification + ", appfacyname=" + appfacyname + ", appfacid="
				+ appfacid + ", scanPrintKey=" + scanPrintKey + ", openedBy=" + openedBy + ", receiptFeeDate="
				+ receiptFeeDate + ", routinCode=" + routinCode + ", checkAccountNumber=" + checkAccountNumber
				+ ", checkNumber=" + checkNumber + ", applicant=" + applicant + ", payer=" + payer + ", accountNumber="
				+ accountNumber + ", accountName=" + accountName + ", amount=" + amount + ", runBy=" + runBy
				+ ", transmittalDate=" + transmittalDate + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", middleName=" + middleName + ", generation=" + generation + ", status=" + status + ", statusUpdate="
				+ statusUpdate + ", commentOntheFacility=" + commentOntheFacility + ", checkInstance=" + checkInstance
				+ ", dateReceived=" + dateReceived + ", oldBatchNo=" + oldBatchNo + ", oldReceiptFeeDate="
				+ oldReceiptFeeDate + ", oldCheckNumber=" + oldCheckNumber + ", createdby=" + createdby
				+ ", createdtime=" + createdtime + ", modifiedby=" + modifiedby + ", modifiedtime=" + modifiedtime
				+ "]";
	}


	




}
