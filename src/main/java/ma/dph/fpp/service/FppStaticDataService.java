/**
 * 
 */
package ma.dph.fpp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import ma.dph.fpp.domain.facilities.Category;
import ma.dph.fpp.domain.facilities.Country;
/**
 * @author vsubramaniyan
 *
 */
import ma.dph.fpp.domain.facilities.LicenseStatus;
import ma.dph.fpp.repository.CategoryRepository;
import ma.dph.fpp.repository.CountryRepository;
import ma.dph.fpp.repository.LicenseStatusRepository;
@Component
public class FppStaticDataService {

	/**
	 * 
	 */
	public FppStaticDataService() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	CategoryRepository   categoryService;
	
	@Autowired
	CountryRepository  countryService;
	
	@Autowired
	LicenseStatusRepository  licenseStatusService;
	
	 Map<String, Country>   countries;
	 Map<String, Category>   categories;
	 Map<String, LicenseStatus>   licenseStatuses;

	 
	 
	/**
	 * @return the countries
	 */
	 @Cacheable(value="country")
	public Map<String, Country> getCountries() {
		return countryService.findAllMapwithCntNameAsKey();
	}
	/**
	 * @param countries the countries to set
	 */
	public void setCountries(Map<String, Country> countries) {
		this.countries = countries;
	}
	/**
	 * @return the categories
	 */
	@Cacheable(value="category")
	public Map<String, Category> getCategories() {
		return categories;
	}
	/**
	 * @param categories the categories to set
	 */
	public void setCategories(Map<String, Category> categories) {
		this.categories = categories;
	}
	/**
	 * @return the licenseStatuses
	 */
	@Cacheable(value="licensestatus")
	public Map<String, LicenseStatus> getLicenseStatuses() {
		return licenseStatuses;
	}
	/**
	 * @param licenseStatuses the licenseStatuses to set
	 */
	public void setLicenseStatuses(Map<String, LicenseStatus> licenseStatuses) {
		this.licenseStatuses = licenseStatuses;
	}
	
}
