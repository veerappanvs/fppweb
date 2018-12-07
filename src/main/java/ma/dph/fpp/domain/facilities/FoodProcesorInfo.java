/**
 * 
 */
package ma.dph.fpp.domain.facilities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author vsubramaniyan
 *
 */
@Entity(name = "food_processor_info")
public class FoodProcesorInfo {

	public FoodProcesorInfo(String primaryop, String secondaryop, String buildingtype, String prod_cat1,
			String prod_sub_cat1, String prod_cat2, String prod_sub_cat2, String prod_cat3, String prod_sub_cat3,
			String prod_cat4, String prod_sub_cat4) {
		super();
		this.primaryop = primaryop;
		this.secondaryop = secondaryop;
		this.buildingtype = buildingtype;
		this.prod_cat1 = prod_cat1;
		this.prod_sub_cat1 = prod_sub_cat1;
		this.prod_cat2 = prod_cat2;
		this.prod_sub_cat2 = prod_sub_cat2;
		this.prod_cat3 = prod_cat3;
		this.prod_sub_cat3 = prod_sub_cat3;
		this.prod_cat4 = prod_cat4;
		this.prod_sub_cat4 = prod_sub_cat4;
	}

	public FoodProcesorInfo(Integer id, String primaryop, String secondaryop, String buildingtype, String prod_cat1,
			String prod_sub_cat1, String prod_cat2, String prod_sub_cat2, String prod_cat3, String prod_sub_cat3,
			String prod_cat4, String prod_sub_cat4) {
		super();
		this.id = id;
		this.primaryop = primaryop;
		this.secondaryop = secondaryop;
		this.buildingtype = buildingtype;
		this.prod_cat1 = prod_cat1;
		this.prod_sub_cat1 = prod_sub_cat1;
		this.prod_cat2 = prod_cat2;
		this.prod_sub_cat2 = prod_sub_cat2;
		this.prod_cat3 = prod_cat3;
		this.prod_sub_cat3 = prod_sub_cat3;
		this.prod_cat4 = prod_cat4;
		this.prod_sub_cat4 = prod_sub_cat4;
	}

	/**
	 * 
	 */
	public FoodProcesorInfo() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer  id;
	
	@Column(name = "primaryop")
	private String  primaryop;
	
	@Column(name = "secondaryop")
	private String  secondaryop;
	
	@Column(name = "buildingtype")
	private String  buildingtype;
	
	@Column(name = "prod_cat1")
	private String  prod_cat1;
	
	@Column(name = "prod_sub_cat1")
	private String  prod_sub_cat1;
	
	@Column(name = "prod_cat2")
	private String  prod_cat2;
	
	@Column(name = "prod_sub_cat2")
	private String  prod_sub_cat2;
	
	@Column(name = "prod_cat3")
	private String  prod_cat3;
	
	@Column(name = "prod_sub_cat3")
	private String  prod_sub_cat3;
	
	@Column(name = "prod_cat4")
	private String  prod_cat4;
	
	@Column(name = "prod_sub_cat4")
	private String  prod_sub_cat4;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the primaryop
	 */
	public String getPrimaryop() {
		return primaryop;
	}

	/**
	 * @param primaryop the primaryop to set
	 */
	public void setPrimaryop(String primaryop) {
		this.primaryop = primaryop;
	}

	/**
	 * @return the secondaryop
	 */
	public String getSecondaryop() {
		return secondaryop;
	}

	/**
	 * @param secondaryop the secondaryop to set
	 */
	public void setSecondaryop(String secondaryop) {
		this.secondaryop = secondaryop;
	}

	/**
	 * @return the buildingtype
	 */
	public String getBuildingtype() {
		return buildingtype;
	}

	/**
	 * @param buildingtype the buildingtype to set
	 */
	public void setBuildingtype(String buildingtype) {
		this.buildingtype = buildingtype;
	}

	/**
	 * @return the prod_cat1
	 */
	public String getProd_cat1() {
		return prod_cat1;
	}

	/**
	 * @param prod_cat1 the prod_cat1 to set
	 */
	public void setProd_cat1(String prod_cat1) {
		this.prod_cat1 = prod_cat1;
	}

	/**
	 * @return the prod_sub_cat1
	 */
	public String getProd_sub_cat1() {
		return prod_sub_cat1;
	}

	/**
	 * @param prod_sub_cat1 the prod_sub_cat1 to set
	 */
	public void setProd_sub_cat1(String prod_sub_cat1) {
		this.prod_sub_cat1 = prod_sub_cat1;
	}

	/**
	 * @return the prod_cat2
	 */
	public String getProd_cat2() {
		return prod_cat2;
	}

	/**
	 * @param prod_cat2 the prod_cat2 to set
	 */
	public void setProd_cat2(String prod_cat2) {
		this.prod_cat2 = prod_cat2;
	}

	/**
	 * @return the prod_sub_cat2
	 */
	public String getProd_sub_cat2() {
		return prod_sub_cat2;
	}

	/**
	 * @param prod_sub_cat2 the prod_sub_cat2 to set
	 */
	public void setProd_sub_cat2(String prod_sub_cat2) {
		this.prod_sub_cat2 = prod_sub_cat2;
	}

	/**
	 * @return the prod_cat3
	 */
	public String getProd_cat3() {
		return prod_cat3;
	}

	/**
	 * @param prod_cat3 the prod_cat3 to set
	 */
	public void setProd_cat3(String prod_cat3) {
		this.prod_cat3 = prod_cat3;
	}

	/**
	 * @return the prod_sub_cat3
	 */
	public String getProd_sub_cat3() {
		return prod_sub_cat3;
	}

	/**
	 * @param prod_sub_cat3 the prod_sub_cat3 to set
	 */
	public void setProd_sub_cat3(String prod_sub_cat3) {
		this.prod_sub_cat3 = prod_sub_cat3;
	}

	/**
	 * @return the prod_cat4
	 */
	public String getProd_cat4() {
		return prod_cat4;
	}

	/**
	 * @param prod_cat4 the prod_cat4 to set
	 */
	public void setProd_cat4(String prod_cat4) {
		this.prod_cat4 = prod_cat4;
	}

	/**
	 * @return the prod_sub_cat4
	 */
	public String getProd_sub_cat4() {
		return prod_sub_cat4;
	}

	/**
	 * @param prod_sub_cat4 the prod_sub_cat4 to set
	 */
	public void setProd_sub_cat4(String prod_sub_cat4) {
		this.prod_sub_cat4 = prod_sub_cat4;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((buildingtype == null) ? 0 : buildingtype.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((primaryop == null) ? 0 : primaryop.hashCode());
		result = prime * result + ((prod_cat1 == null) ? 0 : prod_cat1.hashCode());
		result = prime * result + ((prod_cat2 == null) ? 0 : prod_cat2.hashCode());
		result = prime * result + ((prod_cat3 == null) ? 0 : prod_cat3.hashCode());
		result = prime * result + ((prod_cat4 == null) ? 0 : prod_cat4.hashCode());
		result = prime * result + ((prod_sub_cat1 == null) ? 0 : prod_sub_cat1.hashCode());
		result = prime * result + ((prod_sub_cat2 == null) ? 0 : prod_sub_cat2.hashCode());
		result = prime * result + ((prod_sub_cat3 == null) ? 0 : prod_sub_cat3.hashCode());
		result = prime * result + ((prod_sub_cat4 == null) ? 0 : prod_sub_cat4.hashCode());
		result = prime * result + ((secondaryop == null) ? 0 : secondaryop.hashCode());
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
		FoodProcesorInfo other = (FoodProcesorInfo) obj;
		if (buildingtype == null) {
			if (other.buildingtype != null)
				return false;
		} else if (!buildingtype.equals(other.buildingtype))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (primaryop == null) {
			if (other.primaryop != null)
				return false;
		} else if (!primaryop.equals(other.primaryop))
			return false;
		if (prod_cat1 == null) {
			if (other.prod_cat1 != null)
				return false;
		} else if (!prod_cat1.equals(other.prod_cat1))
			return false;
		if (prod_cat2 == null) {
			if (other.prod_cat2 != null)
				return false;
		} else if (!prod_cat2.equals(other.prod_cat2))
			return false;
		if (prod_cat3 == null) {
			if (other.prod_cat3 != null)
				return false;
		} else if (!prod_cat3.equals(other.prod_cat3))
			return false;
		if (prod_cat4 == null) {
			if (other.prod_cat4 != null)
				return false;
		} else if (!prod_cat4.equals(other.prod_cat4))
			return false;
		if (prod_sub_cat1 == null) {
			if (other.prod_sub_cat1 != null)
				return false;
		} else if (!prod_sub_cat1.equals(other.prod_sub_cat1))
			return false;
		if (prod_sub_cat2 == null) {
			if (other.prod_sub_cat2 != null)
				return false;
		} else if (!prod_sub_cat2.equals(other.prod_sub_cat2))
			return false;
		if (prod_sub_cat3 == null) {
			if (other.prod_sub_cat3 != null)
				return false;
		} else if (!prod_sub_cat3.equals(other.prod_sub_cat3))
			return false;
		if (prod_sub_cat4 == null) {
			if (other.prod_sub_cat4 != null)
				return false;
		} else if (!prod_sub_cat4.equals(other.prod_sub_cat4))
			return false;
		if (secondaryop == null) {
			if (other.secondaryop != null)
				return false;
		} else if (!secondaryop.equals(other.secondaryop))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FoodProcesorInfo [id=" + id + ", primaryop=" + primaryop + ", secondaryop=" + secondaryop
				+ ", buildingtype=" + buildingtype + ", prod_cat1=" + prod_cat1 + ", prod_sub_cat1=" + prod_sub_cat1
				+ ", prod_cat2=" + prod_cat2 + ", prod_sub_cat2=" + prod_sub_cat2 + ", prod_cat3=" + prod_cat3
				+ ", prod_sub_cat3=" + prod_sub_cat3 + ", prod_cat4=" + prod_cat4 + ", prod_sub_cat4=" + prod_sub_cat4
				+ "]";
	}



}
