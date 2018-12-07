/**
 * 
 */
package ma.dph.fpp.repository;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.dph.fpp.domain.facilities.Country;

/**
 * @author vsubramaniyan
 *
 */
public interface CountryRepository extends JpaRepository<Country, Integer> {
	
	
	@Query(value= "select c.* from facility f, tblCountries c where  cnt_pk = fac_cnt  and  f.fac_id = :facId" , nativeQuery=true)
	 Country findTwoDigitCodeByfacility(@Param("facId") Integer facId);
	
	 default Map<String, Country> findAllMapwithCntNameAsKey() {
	        return findAll().stream().collect(Collectors.toMap(Country::getCntName, v -> v));
	    }

}
