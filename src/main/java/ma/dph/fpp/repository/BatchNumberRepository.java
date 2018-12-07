package ma.dph.fpp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.dph.fpp.domain.generallicensing.BatchNumbers;;

public interface BatchNumberRepository extends JpaRepository<BatchNumbers, Integer>{
	
	BatchNumbers findTopByOrderByEntrytimeDesc();

	BatchNumbers findTopByCreatedByUserOrderByEntrytimeDesc(String createdByUser);
	//List<BatchNumbers> findTop1ByIdOrderByenterTimedesc();
	
	List<BatchNumbers> findTop22ByCreatedByUserOrderByEntrytimeDesc(String createdByUser); 
	
	List<BatchNumbers> findTop22ByOrderByEntrytimeDesc(); 
	
	BatchNumbers findByBatchNumberIgnoreCaseContaining(String batchNumber);
}
