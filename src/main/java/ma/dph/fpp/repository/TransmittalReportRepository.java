package ma.dph.fpp.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.dph.fpp.domain.generallicensing.TransmittalReport;
public interface TransmittalReportRepository extends JpaRepository<TransmittalReport, Integer> {

	
	@Query(value = "select dtreceive, acct_no as acctno, check_num as checknum, payer, amount, status, batch_no as batchnum  "
	//		+ "from  [rctfee]  where  batch_no = :batchnum     order by acct_no desc ", nativeQuery = true)
			+ "from  [rctfee]  where  batch_no = :batchnum       ", nativeQuery = true)
	List<TransmittalReport>  findByNativeQuery( @Param("batchnum") String batchnum);
	
	
	@Query(value = "select dtreceive, acct_no as acctno, check_num as checknum, payer, amount, status, batch_no as batchnum  "
			+ "from  [rctfee]  where  batch_no = :batchnum and    recfeedt = :receiptFeeDate ", nativeQuery = true)
	List<TransmittalReport>  findByNativeQueryForbatchAndDate( @Param("batchnum") String batchnum, @Param("receiptFeeDate") Date receiptFeeDate );
	
	
	@Query(value = "select dtreceive, acct_no as acctno, check_num as checknum, payer, amount, status, batch_no as batchnum  "
			+ "from  [rctfee]  where  batch_no = :batchnum and  acct_no = :accountNumber  ", nativeQuery = true)
	List<TransmittalReport>  findByNativeQuery( @Param("batchnum") String batchnum, @Param("accountNumber") String accountNumber );
	
	
	@Query(value = "select dtreceive, acct_no as acctno, check_num as checknum, payer, amount, status, batch_no as batchnum  "
			+ "from  [rctfee]  where  batch_no = :batchnum and  acct_no = :accountNumber and  recfeedt = :receiptFeeDate ", nativeQuery = true)
	List<TransmittalReport>  findByNativeQuery( @Param("batchnum") String batchnum, @Param("accountNumber") String accountNumber,  		@Param("receiptFeeDate") Date receiptFeeDate );
	
	
}