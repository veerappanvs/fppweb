/**
 * 
 */
package ma.dph.fpp.repository;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.dph.fpp.domain.facilities.Country;
import ma.dph.fpp.domain.facilities.LicenseStatus;

/**
 * @author vsubramaniyan
 *
 */
@Repository
public interface LicenseStatusRepository extends JpaRepository<LicenseStatus, Integer> {
	
	
	 default Map<String, LicenseStatus> findAllMapwithStatusdescAsKey() {
	        return findAll().stream().collect(Collectors.toMap(LicenseStatus::getStatdesc, v -> v));
	    }

}
