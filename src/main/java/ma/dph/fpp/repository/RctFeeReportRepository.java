package ma.dph.fpp.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.dph.fpp.domain.generallicensing.RctFeeReport;
import ma.dph.fpp.domain.generallicensing.TransmittalReport;
public interface RctFeeReportRepository extends JpaRepository<RctFeeReport, Integer> {

	@Query(value = " select status, count(status)  as statuscnt , sum(amount) as amountsum "
			+ " from   [rctfee]  where  batch_no= :batchnum group by status", nativeQuery = true)
	List<RctFeeReport>  findByNativeQuery( @Param("batchnum") String batchnum);
	
	
	@Query(value = " select status, count(status)  as statuscnt , sum(amount) as amountsum "
			+ " from   [rctfee]  where  batch_no= :batchnum  and recfeedt = :receiptFeeDate group by status", nativeQuery = true)
	List<RctFeeReport>  findByNativeQuery( @Param("batchnum") String batchnum, @Param("receiptFeeDate") Date receiptFeeDate);
	
	
	@Query(value = " select status, count(status)  as statuscnt , sum(amount) as amountsum "
			+ " from   [rctfee]  where  batch_no= :batchnum  and acct_no = :accountNumber and recfeedt = :receiptFeeDate group by status", nativeQuery = true)
	List<RctFeeReport>  findByNativeQuery( @Param("batchnum") String batchnum, @Param("accountNumber") String accountNumber, @Param("receiptFeeDate") Date receiptFeeDate);
	
	
	
}