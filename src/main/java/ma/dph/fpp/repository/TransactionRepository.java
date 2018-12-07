package ma.dph.fpp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.dph.fpp.domain.facilities.Transaction;

public interface TransactionRepository extends  JpaRepository<Transaction, Integer> {

	Optional<Transaction>   findById(Integer id );
	//List<Transaction>   findByRegIdIgnoreCaseContaining(String regId );
	
	@Query(value = "select trns.* from [facility] fac, [fclass]  , [registrs] reg , [transactions]  trns\r\n" + 
			"	where fac.fac_id = fclass.fac_id  	and fclass.class_id =reg.class_id	and reg.reg_id = trns.reg_id	and fac.fac_id = :facId", nativeQuery = true)
	List<Transaction>   findByTranscationsByFacilityId(@Param("facId") String facId );

	
	@Query(value = "select distinct reg.reg_id from [facility] fac, [fclass]  , [registrs] reg , [transactions]  trns\r\n" + 
			"	where fac.fac_id = fclass.fac_id  	and fclass.class_id =reg.class_id	and reg.reg_id = trns.reg_id	and fac.fac_id = :facId", nativeQuery = true)
	Integer findRegIdByFacilityId(@Param("facId") String facId );

}
