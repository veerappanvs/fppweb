package ma.dph.fpp.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.dph.fpp.domain.facilities.PrintCertificate;

public interface PrintCertificateRepository extends JpaRepository<PrintCertificate, Integer> {
	
	List<PrintCertificate>  findByCatName(String catName);
	List<PrintCertificate>  findByCatNameOrderByFacName(String catName);
	List<PrintCertificate>  findByCatNameOrderByDateExpire(String catName);
	PrintCertificate  findByFacId(Integer facId );
	
	}
