package ma.dph.fpp.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.dph.fpp.domain.facilities.Fclass;

public interface FclassRepository extends JpaRepository<Fclass, Integer> {
	
	
	public Fclass   getByFacId(Integer facId);

	}
