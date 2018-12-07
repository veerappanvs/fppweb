package ma.dph.fpp.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.dph.fpp.domain.facilities.Renewalsfood;
import ma.dph.fpp.domain.facilities.RenewalsfoodDetails;

public interface RenewalsFoodDetailsRepository extends JpaRepository<RenewalsfoodDetails, Integer> {
	
	
	List<RenewalsfoodDetails> findByCatShort(String catName);
	RenewalsfoodDetails findByPrkey(Integer prkey);
	List<RenewalsfoodDetails> findByCatShortAndDexporissBetweenOrderByCorpNameAsc(String catName, Date startDate, Date endDate);
	//List<Renewalsfood> findCatNameIgnoreCaseAndDstartAndDend(String catName, String dstart, String dend);

}
