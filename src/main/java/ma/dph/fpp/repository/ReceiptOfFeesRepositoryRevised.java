package ma.dph.fpp.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.dph.fpp.domain.generallicensing.ReceiptOfFeesRevised;

public interface ReceiptOfFeesRepositoryRevised extends JpaRepository<ReceiptOfFeesRevised, Integer>{

	
	ReceiptOfFeesRevised findById(Integer id);
	List<ReceiptOfFeesRevised> findByApplicantIgnoreCaseContainingAndAccountNumberIgnoreCaseContaining(String applicant, String accountNumber);
	
	//List<ReceiptOfFeesOriginal> findByApplicantIgnoreCaseContainingAndAccountNumberIgnoreCaseContainingAndReceiptFeeDateIgnoreCaseContaining(String applicant, String accountNumber, String receiptFeeDate);
	List<ReceiptOfFeesRevised> findByApplicantIgnoreCaseContainingOrAccountNumberIgnoreCaseContainingOrReceiptFeeDate(String applicant, String accountNumber, Date receiptFeeDate);
	
	List<ReceiptOfFeesRevised> findByApplicantIgnoreCaseContainingAndAccountNumberIgnoreCaseContainingAndReceiptFeeDate(String applicant, String accountNumber, Date receiptFeeDate);
	
	List<ReceiptOfFeesRevised> findByBatchNumberContainingAndAccountNumberIgnoreCaseContainingAndReceiptFeeDate(String batchNumber, String accountNumber, Date receiptFeeDate);
	List<ReceiptOfFeesRevised> findByBatchNumberContainingAndReceiptFeeDate(String batchNumber, Date receiptFeeDate);
	List<ReceiptOfFeesRevised> findByBatchNumberContainingAndReceiptFeeDateOrderByAccountName(String batchNumber, Date receiptFeeDate);
	List<ReceiptOfFeesRevised> findByBatchNumberContainingAndReceiptFeeDateOrderByAccountNumber(String batchNumber, Date receiptFeeDate);
	List<ReceiptOfFeesRevised> findByBatchNumberAndReceiptFeeDate(String batchNumber, Date receiptFeeDate);
	List<ReceiptOfFeesRevised> findByBatchNumberContainingAndAccountNumberIgnoreCaseContaining(String batchNumber, String accountNumber);
	List<ReceiptOfFeesRevised> findByBatchNumberContainingAndAccountNumberIgnoreCaseContainingOrderByAccountNumber(String batchNumber, String accountNumber);
	List<ReceiptOfFeesRevised> findByBatchNumberAndAccountNumberIgnoreCase(String batchNumber, String accountNumber);
	List<ReceiptOfFeesRevised> findByBatchNumberContaining(String batchNumber);
	List<ReceiptOfFeesRevised> findByBatchNumberContainingOrderByAccountName(String batchNumber);
	List<ReceiptOfFeesRevised> findByBatchNumberContainingOrderByAccountNumber(String batchNumber);


	List<ReceiptOfFeesRevised> findByBatchNumber(String batchNumber);
	List<ReceiptOfFeesRevised> findByBatchNumberContainingOrderByAccountNumberDesc(String batchNumber);

	List<ReceiptOfFeesRevised> findByAppfacid(String appfacid);
	List<ReceiptOfFeesRevised> findByAccountNumberContaining(String accountNumber);
	List<ReceiptOfFeesRevised> findByReceiptFeeDate(Date receiptFeeDate);
	
	List<ReceiptOfFeesRevised> findByAccountNumberIgnoreCaseContainingAndReceiptFeeDate( String accountNumber, Date receiptFeeDate);
	List<ReceiptOfFeesRevised> findByApplicantIgnoreCaseContainingAndReceiptFeeDate(String applicant, Date receiptFeeDate);
	List<ReceiptOfFeesRevised> findByApplicantIgnoreCaseContaining(String applicant);

	List<ReceiptOfFeesRevised> findByCheckNumberIgnoreCaseContaining(String checkNumber);

	List<ReceiptOfFeesRevised> findByPayerIgnoreCaseContaining(String payer);

	List<ReceiptOfFeesRevised> findByApplicantIgnoreCaseContainingAndPayerIgnoreCaseContaining(String applicant, String payer);

	List<ReceiptOfFeesRevised> findByApplicantIgnoreCaseContainingAndCheckNumberIgnoreCaseContaining(String applicant, String checkNumber);

	List<ReceiptOfFeesRevised> findByCheckNumberIgnoreCaseContainingAndPayerIgnoreCaseContaining(String checkNumber, String payer);

	List<ReceiptOfFeesRevised> findByApplicantIgnoreCaseContainingAndCheckNumberIgnoreCaseContainingAndPayerIgnoreCaseContaining(String applicant, String checkNumber, String payer);
}

