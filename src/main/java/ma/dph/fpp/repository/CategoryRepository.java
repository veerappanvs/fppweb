/**
 * 
 */
package ma.dph.fpp.repository;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import ma.dph.fpp.domain.facilities.Category;
import ma.dph.fpp.domain.facilities.Country;

/**
 * @author vsubramaniyan
 *
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	
	Category  findByCatNameIgnoreCase(String catName);
	
	@Cacheable("category")
	 default Map<String, Category> findAllMapwithCatNamecAsKey() {
	        return findAll().stream().collect(Collectors.toMap(Category::getCatName, v -> v));
	    }

}
