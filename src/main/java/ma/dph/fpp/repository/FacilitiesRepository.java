package ma.dph.fpp.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.dph.fpp.domain.facilities.Facilities;

public interface FacilitiesRepository extends JpaRepository<Facilities, Integer> {

	Facilities   findById(Integer id );
	Facilities   findByFoodProcesssorId(Integer foodProcesssorId );
	List<Facilities>   findByFacilityNameIgnoreCaseContaining(String facilityName );
	List<Facilities>   findByFacilityAddress1IgnoreCaseContaining(String facilityAddress1 );
	List<Facilities>   findByFacilityAddress2IgnoreCaseContaining(String facilityAddress2 );
	List<Facilities>   findByFacilityCityIgnoreCaseContaining(String facilityCity );
	List<Facilities>   findByFacilityStateIgnoreCaseContaining(String facilityState );
	List<Facilities>   findByFacilityZipIgnoreCaseContaining(String facilityZip );
	List<Facilities>   findByCorporationId(Integer corporationId ); 
	List<Facilities>  findByFacilityNameIgnoreCaseContainingAndFacilityAddress1IgnoreCaseContainingAndFacilityAddress2IgnoreCaseContainingAndFacilityCityIgnoreCaseContainingAndFacilityStateIgnoreCaseContainingAndFacilityZipIgnoreCaseContaining(String facilityName, String facilityAddress1, String facilityAddress2, String facilityCity, String facilityState,   String facilityZip);
}
