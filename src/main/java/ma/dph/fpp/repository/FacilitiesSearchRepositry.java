package ma.dph.fpp.repository;


import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.dph.fpp.domain.facilities.FacilitySearchResult;

public interface FacilitiesSearchRepositry extends JpaRepository<FacilitySearchResult, Integer> {
	
	
		Optional<FacilitySearchResult>   findByFacId(Integer facId );
		Set<FacilitySearchResult>   findByFacilityNameIgnoreCaseContaining(String facilityName );
		Set<FacilitySearchResult>   findByFacilityAdd1IgnoreCaseContaining(String facilityAdd1);
		Set<FacilitySearchResult>   findByLicenseIgnoreCaseContaining(String license);
		Set<FacilitySearchResult>   findByLicenseTypeIgnoreCaseContaining(String license);
		Set<FacilitySearchResult>   findByCorpNameIgnoreCaseContaining(String corpName);
		Set<FacilitySearchResult>   findByCorpId(String corpId);
		Set<FacilitySearchResult>   findByFacilityCityIgnoreCaseContaining(String facilityCity);
		Set<FacilitySearchResult>   findByFacZipIgnoreCaseContaining(String facZip);
		Set<FacilitySearchResult>   findByFacilityNameIgnoreCaseContainingAndFacilityAdd1IgnoreCaseContainingAndLicenseIgnoreCaseContainingAndLicenseTypeIgnoreCaseContainingAndCorpNameIgnoreCaseContainingAndFacilityCityIgnoreCaseContainingAndFacZipContaining(String facilityName ,String facilityAdd1,  String license, String  licenseType, String corpName, String facilityCity, String facZip);
	
	}
