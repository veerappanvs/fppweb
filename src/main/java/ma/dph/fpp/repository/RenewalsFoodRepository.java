package ma.dph.fpp.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.dph.fpp.domain.facilities.RenewalCompId;
import ma.dph.fpp.domain.facilities.Renewalsfood;

public interface RenewalsFoodRepository extends JpaRepository<Renewalsfood, RenewalCompId> {
	
	List<Renewalsfood> findTop36ByCatShortOrderByRenewalCompId(String catName);
	List<Renewalsfood> findByCatShortOrderByRenewalCompId(String catName);
	/*Renewalsfood findByPrkey(Integer prkey);
	List<Renewalsfood> findByCatShortAndDendBetweenOrderByCorpNameAsc(String catName, Date dstart, Date dend);*/
	Renewalsfood  findByRenewalCompId(RenewalCompId  renewalCompId);
	//List<Renewalsfood> findByCatNameIgnoreCaseAndDendBetween(String catName, String dstart, String dend);
	//List<Renewalsfood> findByCatShortIgnoreCaseAndGroupByCatShortAndGroupByDstartAndGroupByDend(String catName, String dstart, String dend);

}
