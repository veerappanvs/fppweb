package ma.dph.fpp.repository;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.dph.fpp.domain.facilities.Corporation;
import ma.dph.fpp.domain.facilities.Facilities;

public interface CorpRepository extends JpaRepository<Corporation, Integer> {

	//List<Corporation>   findByCEntrytmGreaterThanOrderByEntrytm(Date cEntrytm );
	
	Corporation   findById(Integer id );
	List<Corporation>   findByCorpNameIgnoreCaseContaining(String corpName );
	List<Corporation>   findByCMailadd1IgnoreCaseContaining(String cMailadd1 );
	List<Corporation>   findByCMailadd2IgnoreCaseContaining(String cMailadd2 );
	List<Corporation>   findByCMailcityIgnoreCaseContaining(String cMailcity );
	List<Corporation>   findByCMailstateIgnoreCaseContaining(String corpState );
	List<Corporation>   findByCorpZipIgnoreCaseContaining(String corpZip );
	//List<Corporation>   findByCorpNameIgnoreCaseContainingAndCorpAdd1IgnoreCaseContainingAndcorpAdd2IgnoreCaseContainingAndCorpCityIgnoreCaseContainingAndCorpStateIgnoreCaseContainingAndCorpZipIgnoreCaseContaining(String corpName, String corpAdd1,  String corpAdd2, String corpCity,  String corpZip );
	List<Corporation>  findByCorpNameIgnoreCaseContainingAndCMailadd1IgnoreCaseContainingAndCMailcityIgnoreCaseContainingAndCMailstateIgnoreCaseContainingAndCMailzipIgnoreCaseContaining(String corpName, String cMailadd1,  String cMailcity, String cMailstate,   String cMailzip);
}