package ma.dph.fpp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.dph.fpp.domain.facilities.Registration;

public interface RegistrationRepository extends  JpaRepository<Registration, Integer> {

	Optional<Registration>   findByRegId(Integer regId );
	
	@Query(value = "	select reg.* from [facility] fac, [fclass]  , [registrs] reg \r\n" + 
			"	where fac.fac_id = fclass.fac_id  	and fclass.class_id =reg.class_id	and fac.fac_id = :facId", nativeQuery = true)
	Registration   findByRegistrationsByFacilityId(@Param("facId") String facId );
	
	Registration  findByClassId(Integer classId);

}
