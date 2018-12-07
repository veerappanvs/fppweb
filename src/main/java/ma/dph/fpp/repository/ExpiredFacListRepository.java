package ma.dph.fpp.repository;


import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.dph.fpp.domain.facilities.ExpiredFacList;

public interface ExpiredFacListRepository extends JpaRepository<ExpiredFacList, Integer> {

	List<ExpiredFacList>   findByfacId(String facId );
	
	@Query(value = "SELECT\r\n" + 
			"facility.fac_id,  cat_name, cat_letter, fclass.fac_status, statdesc, corp_name, fac_name, fac_add1, fac_add2, fac_city, fac_state, fac_zip, fac_phone, fac_email, fac_fax, fac_madd1, fac_madd2, fac_mcity, fac_mstate, fac_mzip, f_last, f_first, f_middle, f_suffix, f_title, f_status, f_comments,  reg_license, date_issue, date_expire, \r\n" + 
			"corp.corp_id, corp_city, corp_state,corp_zip,  corp_phone, c_last, c_first, c_middle, c_suffix,  corp_Add1, code as revenue_src_code,  corp_country  as country \r\n" + 
			"from corp  \r\n" + 
			"inner join facility \r\n" + 
			"on corp.corp_id=facility.corp_id \r\n" + 
			"inner join fclass on facility.fac_id=fclass.fac_id \r\n" + 
			"inner join registrs on fclass.class_id=registrs.class_id \r\n" + 
			"inner join category on fclass.fac_class=category.cat_letter\r\n" + 
			"inner join licstat on shortdesc = fac_status\r\n" + 
			"where statdesc LIKE 'ACTIVE'\r\n" + 
			"--and  category.cat_letter = 'A'\r\n" + 
			"and category.cat_name in (:categoryName) \r\n" + 
			"and date_expire  >= :startDate \r\n" + 
			"and date_expire  <= :endRange \r\n" + 
			"order by cat_name, corp_name", nativeQuery = true)
	List<ExpiredFacList>  getExpiredFacilitesListByDateRangeAndCategoryName(@Param("startDate")  String  startDate, @Param("endRange")  String endRange, @Param("categoryName")  String categoryName);
	
	
	@Query(value = "SELECT\r\n" + 
			"facility.fac_id,  cat_name, cat_letter, fclass.fac_status, statdesc, corp_name, fac_name, fac_add1, fac_add2, fac_city, fac_state, fac_zip, fac_phone, fac_email, fac_fax, fac_madd1, fac_madd2, fac_mcity, fac_mstate, fac_mzip, f_last, f_first, f_middle, f_suffix, f_title, f_status, f_comments,  reg_license, date_issue, date_expire, \r\n" + 
			"corp.corp_id, corp_city, corp_state, corp_zip, corp_phone, c_last, c_first, c_middle, c_suffix,  corp_Add1, code as revenue_src_code,  corp_country  as country \r\n" + 
			"from corp  \r\n" + 
			"inner join facility \r\n" + 
			"on corp.corp_id=facility.corp_id \r\n" + 
			"inner join fclass on facility.fac_id=fclass.fac_id \r\n" + 
			"inner join registrs on fclass.class_id=registrs.class_id \r\n" + 
			"inner join category on fclass.fac_class=category.cat_letter\r\n" + 
			"inner join licstat on shortdesc = fac_status\r\n" + 
			"where statdesc LIKE 'ACTIVE'\r\n" +			 
			"and category.cat_name in (:categoryName) \r\n" +			
			"order by cat_name, corp_name", nativeQuery = true)
	List<ExpiredFacList>  getActiveFacilitesList(@Param("categoryName")  String categoryName);
	
	@Query(value = "SELECT\r\n" + 
			"facility.fac_id,  cat_name, cat_letter, fclass.fac_status, statdesc, corp_name, fac_name, fac_add1, fac_add2, fac_city, fac_state, fac_zip, fac_phone, fac_email, fac_fax, fac_madd1, fac_madd2, fac_mcity, fac_mstate, fac_mzip, f_last, f_first, f_middle, f_suffix, f_title, f_status, f_comments,  reg_license, date_issue, date_expire, \r\n" + 
			"corp.corp_id, corp_city, corp_state, corp_zip, corp_phone, c_last, c_first, c_middle, c_suffix,  corp_Add1, code as revenue_src_code,  corp_country  as country \r\n" + 
			"from corp  \r\n" + 
			"inner join facility \r\n" + 
			"on corp.corp_id=facility.corp_id \r\n" + 
			"inner join fclass on facility.fac_id=fclass.fac_id \r\n" + 
			"inner join registrs on fclass.class_id=registrs.class_id \r\n" + 
			"inner join category on fclass.fac_class=category.cat_letter\r\n" + 
			"inner join licstat on shortdesc = fac_status\r\n" + 
			"where statdesc LIKE 'ACTIVE'\r\n" +	
			"and date_expire  <= :startdate  " +
			"and category.cat_name in  (:acctname)  \r\n" +			
			"order by cat_name, corp_name", nativeQuery = true)
	List<ExpiredFacList>  getExpiredRegistrationDetail(@Param("acctname")  String acctname,  @Param("startdate") String startdate);
	
	
	/*@Query(value = " SELECT  top 1    category.cat_name as name,	 count(category.cat_name)  as count \r\n" + 
			"			from corp    \r\n" + 
			"			inner join facility   \r\n" + 
			"			on corp.corp_id=facility.corp_id   \r\n" + 
			"			inner join fclass on facility.fac_id=fclass.fac_id   \r\n" + 
			"			inner join registrs on fclass.class_id=registrs.class_id   \r\n" + 
			"			inner join category on fclass.fac_class=category.cat_letter  \r\n" + 
			"			inner join licstat on shortdesc = fac_status  \r\n" + 
			"			where statdesc LIKE 'ACTIVE' 			 \r\n" + 
			"			and category.cat_name in ( :acctname ) \r\n" + 
			"			and date_expire  <= :startdate \r\n" + 
			"			group by  	category.cat_name	in :acctname 	\r\n" + 
			"			order by cat_name", nativeQuery = true)
	ExpiredRegistrationCounts  getExpiredRegistrationCount(@Param("acctname")  String []acctname, @Param("startdate") String startdate);
	
	
	//@Projection(name = "expiredRegistrationCounts")
	 public static interface ExpiredRegistrationCounts{
		 
		 String getName();
		 String getCount();
		 
	 }*/
	
	
}
