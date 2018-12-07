package ma.dph.fpp.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.dph.fpp.domain.facilities.FoodProcesorInfo;

public interface FoodProcessorRepository extends JpaRepository<FoodProcesorInfo, Integer> {

	FoodProcesorInfo   findById(Integer id );
}