package ma.dph.fpp.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.dph.fpp.domain.generallicensing.FiscalReport;
public interface FiscalReportRepository extends JpaRepository<FiscalReport, Integer> {

	//List<FiscalReport>   findByAcctnameIgnoreCase(String acctame );
	
	@Query(value = "Select (LEFT(DATENAME(MONTH,dtreceive), 3)+' '+DATENAME(YEAR,dtreceive)) as mnt, COUNT(*) as count, sum(amount) as amountsum  from   [dbo].[rctfee]   \r\n" + 
			//"where acct_name = :acctname and (DATENAME(MONTH,dtreceive)+' '+DATENAME(YEAR,dtreceive)) between :startDate and :endDate  " + 
			"where acct_name in (:acctname) and dtreceive between (:startDate) and (:endDate)  " +
			"Group By (LEFT(DATENAME(MONTH,dtreceive), 3)+' '+DATENAME(YEAR,dtreceive))  ,acct_name  ", nativeQuery = true)
	List<FiscalReport>  findByNativeQuery( @Param("acctname") List<String> acctname, @Param("startDate") Date startDate,  @Param("endDate") Date endDate);
	
	
	//Takes String i/p parameter
	@Query(value = "Select (LEFT(DATENAME(MONTH,dtreceive), 3)+' '+DATENAME(YEAR,dtreceive)) as mnt, COUNT(*) as count, sum(amount) as amountsum  from   [dbo].[rctfee]   \r\n" + 
			//"where acct_name = :acctname and (DATENAME(MONTH,dtreceive)+' '+DATENAME(YEAR,dtreceive)) between :startDate and :endDate  " + 
			"where acct_name in (:acctname) and dtreceive between (:startDate) and (:endDate)  and status = 'PROCESSED'  " +
			"Group By (LEFT(DATENAME(MONTH,dtreceive), 3)+' '+DATENAME(YEAR,dtreceive))  ,acct_name  ", nativeQuery = true)
	List<FiscalReport>  findByNativeQuery( @Param("acctname") String acctname, @Param("startDate") Date startDate,  @Param("endDate") Date endDate);
	
	
	@Query(value = "Select (LEFT(DATENAME(MONTH,dtreceive), 3)+' '+DATENAME(YEAR,dtreceive)) as mnt, COUNT(*) as count, sum(amount) as amountsum, acct_name from   [dbo].[rctfee]   \r\n" + 
			//"where acct_name = :acctname and (DATENAME(MONTH,dtreceive)+' '+DATENAME(YEAR,dtreceive)) between :startDate and :endDate  " + 
			"where acct_name in (:acctname) and dtreceive between (:startDate) and (:endDate)  " +
			"Group By (LEFT(DATENAME(MONTH,dtreceive), 3)+' '+DATENAME(YEAR,dtreceive))  ,acct_name  ", nativeQuery = true)
	List<FiscalReport>  findByAccountNamesNativeQuery( @Param("acctname") List<String> acctname, @Param("startDate") Date startDate,  @Param("endDate") Date endDate);
	
	
	@Query(value = "Select (DATENAME(MONTH,dtreceive)+' '+DATENAME(YEAR,dtreceive)) as mnt, COUNT(*) as count, sum(amount) as amountsum from   [dbo].[rctfee]   \r\n" + 
			"where year(dtreceive) = :year and acct_name = :acctname\r\n" + 
			"Group By (DATENAME(MONTH,dtreceive)+' '+DATENAME(YEAR,dtreceive))  ,acct_name  order by mnt", nativeQuery = true)
	List<FiscalReport>  findByNativeQuery( @Param("year") String year,  @Param("acctname") String acctname);
	

	@Query(value ="Select MONTH(dtreceive) as mnt, acct_name as acctname, COUNT(*) as count  from   [dbo].[rctfee]  where year(dtreceive) = :year and acct_name = :acctname  Group By month(dtreceive),acct_name", nativeQuery = true)
	public List<?> getFiscalReport(@Param("year") String year,  @Param("acctname") String acctname);
	
	
	
}