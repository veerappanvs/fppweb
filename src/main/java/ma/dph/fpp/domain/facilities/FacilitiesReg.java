/**
 * 
 */
package ma.dph.fpp.domain.facilities;

import java.util.List;

/**
 * @author vsubramaniyan
 *
 */

public class FacilitiesReg {

	public FacilitiesReg(Facilities facilities, Corporation corp, Fclass fclass, Registration registration,
			FoodProcesorInfo foodProcesorInfo, Category category, LicenseStatus licenseStatus, Country country) {
		super();
		this.facilities = facilities;
		this.corp = corp;
		this.fclass = fclass;
		this.registration = registration;
		this.foodProcesorInfo = foodProcesorInfo;
		this.category = category;
		this.licenseStatus = licenseStatus;
		this.country = country;
	}
	

	public FacilitiesReg(){
		
	}
	
	private Facilities facilities;
	private Corporation corp;
	private Fclass fclass;
	private Registration registration;
	private FoodProcesorInfo  foodProcesorInfo;
	private Category category;
	private LicenseStatus licenseStatus;
	private Country country;
	private List<Transaction> transactions;
	
	/**
	 * @return the facilities
	 */
	public Facilities getFacilities() {
		return facilities;
	}


	/**
	 * @param facilities the facilities to set
	 */
	public void setFacilities(Facilities facilities) {
		this.facilities = facilities;
	}


	/**
	 * @return the corp
	 */
	public Corporation getCorp() {
		return corp;
	}


	/**
	 * @param corp the corp to set
	 */
	public void setCorp(Corporation corp) {
		this.corp = corp;
	}


	/**
	 * @return the fclass
	 */
	public Fclass getFclass() {
		return fclass;
	}


	/**
	 * @param fclass the fclass to set
	 */
	public void setFclass(Fclass fclass) {
		this.fclass = fclass;
	}


	/**
	 * @return the registration
	 */
	public Registration getRegistration() {
		return registration;
	}


	/**
	 * @param registration the registration to set
	 */
	public void setRegistration(Registration registration) {
		this.registration = registration;
	}


	/**
	 * @return the foodProcesorInfo
	 */
	public FoodProcesorInfo getFoodProcesorInfo() {
		return foodProcesorInfo;
	}


	/**
	 * @param foodProcesorInfo the foodProcesorInfo to set
	 */
	public void setFoodProcesorInfo(FoodProcesorInfo foodProcesorInfo) {
		this.foodProcesorInfo = foodProcesorInfo;
	}


	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}


	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}


	/**
	 * @return the licenseStatus
	 */
	public LicenseStatus getLicenseStatus() {
		return licenseStatus;
	}


	/**
	 * @param licenseStatus the licenseStatus to set
	 */
	public void setLicenseStatus(LicenseStatus licenseStatus) {
		this.licenseStatus = licenseStatus;
	}


	/**
	 * @return the country
	 */
	public Country getCountry() {
		return country;
	}


	/**
	 * @param country the country to set
	 */
	public void setCountry(Country country) {
		this.country = country;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((corp == null) ? 0 : corp.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((facilities == null) ? 0 : facilities.hashCode());
		result = prime * result + ((fclass == null) ? 0 : fclass.hashCode());
		result = prime * result + ((foodProcesorInfo == null) ? 0 : foodProcesorInfo.hashCode());
		result = prime * result + ((licenseStatus == null) ? 0 : licenseStatus.hashCode());
		result = prime * result + ((registration == null) ? 0 : registration.hashCode());
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FacilitiesReg other = (FacilitiesReg) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (corp == null) {
			if (other.corp != null)
				return false;
		} else if (!corp.equals(other.corp))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (facilities == null) {
			if (other.facilities != null)
				return false;
		} else if (!facilities.equals(other.facilities))
			return false;
		if (fclass == null) {
			if (other.fclass != null)
				return false;
		} else if (!fclass.equals(other.fclass))
			return false;
		if (foodProcesorInfo == null) {
			if (other.foodProcesorInfo != null)
				return false;
		} else if (!foodProcesorInfo.equals(other.foodProcesorInfo))
			return false;
		if (licenseStatus == null) {
			if (other.licenseStatus != null)
				return false;
		} else if (!licenseStatus.equals(other.licenseStatus))
			return false;
		if (registration == null) {
			if (other.registration != null)
				return false;
		} else if (!registration.equals(other.registration))
			return false;
		return true;
	}


	
	

	public List<Transaction> getTransactions() {
		return transactions;
	}


	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}


	@Override
	public String toString() {
		return "FacilitiesReg [facilities=" + facilities + ", corp=" + corp + ", fclass=" + fclass + ", registration="
				+ registration + ", foodProcesorInfo=" + foodProcesorInfo + ", category=" + category
				+ ", licenseStatus=" + licenseStatus + ", country=" + country + ", transactions=" + transactions + "]";
	}
	
	

	
}
