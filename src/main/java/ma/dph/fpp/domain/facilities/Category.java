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
@Entity(name = "category")
public class Category {



	public Category(String catName, String catLetter, String dsc, String code, String isched, String catDescr,
			String rptitle, String regchpt, String fee, String instr, String feebasis, String orgncode,
			String foodOrDrug, String appRegulation) {
		super();
		this.catName = catName;
		this.catLetter = catLetter;
		this.dsc = dsc;
		this.code = code;
		this.isched = isched;
		this.catDescr = catDescr;
		this.rptitle = rptitle;
		this.regchpt = regchpt;
		this.fee = fee;
		this.instr = instr;
		this.feebasis = feebasis;
		this.orgncode = orgncode;
		this.foodOrDrug = foodOrDrug;
		this.appRegulation = appRegulation;
	}

	public Category(Integer id, String catName, String catLetter, String dsc, String code, String isched,
			String catDescr, String rptitle, String regchpt, String fee, String instr, String feebasis, String orgncode,
			String foodOrDrug, String appRegulation) {
		super();
		this.id = id;
		this.catName = catName;
		this.catLetter = catLetter;
		this.dsc = dsc;
		this.code = code;
		this.isched = isched;
		this.catDescr = catDescr;
		this.rptitle = rptitle;
		this.regchpt = regchpt;
		this.fee = fee;
		this.instr = instr;
		this.feebasis = feebasis;
		this.orgncode = orgncode;
		this.foodOrDrug = foodOrDrug;
		this.appRegulation = appRegulation;
	}

	/**
	 * 
	 */
	public Category() {	
		// TODO Auto-generated constructor stub
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "cat_id")
	private Integer  id;
	
	@Column(name = "cat_name")
	private String  catName;
	
	@Column(name = "cat_letter")
	private String  catLetter;
	
	@Column(name = "dsc")
	private String  dsc;
	
	@Column(name = "code")
	private String  code;
	
	@Column(name = "isched")
	private String  isched;
	
	@Column(name = "cat_descr")
	private String  catDescr;
	
	@Column(name = "rptitle")
	private String  rptitle;

	@Column(name = "regchpt")
	private String  regchpt;

	@Column(name = "fee")
	private String  fee;
	
	@Column(name = "instr")
	private String  instr;
	
	@Column(name = "feebasis")
	private String  feebasis;
	
	@Column(name = "orgncode")
	private String  orgncode;
	
	@Column(name = "food_or_drug")
	private String  foodOrDrug;
	
	@Column(name = "app_regulation")
	private String  appRegulation;

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
	 * @return the catName
	 */
	public String getCatName() {
		return catName;
	}

	/**
	 * @param catName the catName to set
	 */
	public void setCatName(String catName) {
		this.catName = catName;
	}

	/**
	 * @return the catLetter
	 */
	public String getCatLetter() {
		return catLetter;
	}

	/**
	 * @param catLetter the catLetter to set
	 */
	public void setCatLetter(String catLetter) {
		this.catLetter = catLetter;
	}

	/**
	 * @return the dsc
	 */
	public String getDsc() {
		return dsc;
	}

	/**
	 * @param dsc the dsc to set
	 */
	public void setDsc(String dsc) {
		this.dsc = dsc;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the isched
	 */
	public String getIsched() {
		return isched;
	}

	/**
	 * @param isched the isched to set
	 */
	public void setIsched(String isched) {
		this.isched = isched;
	}

	/**
	 * @return the catDescr
	 */
	public String getCatDescr() {
		return catDescr;
	}

	/**
	 * @param catDescr the catDescr to set
	 */
	public void setCatDescr(String catDescr) {
		this.catDescr = catDescr;
	}

	/**
	 * @return the rptitle
	 */
	public String getRptitle() {
		return rptitle;
	}

	/**
	 * @param rptitle the rptitle to set
	 */
	public void setRptitle(String rptitle) {
		this.rptitle = rptitle;
	}

	/**
	 * @return the regchpt
	 */
	public String getRegchpt() {
		return regchpt;
	}

	/**
	 * @param regchpt the regchpt to set
	 */
	public void setRegchpt(String regchpt) {
		this.regchpt = regchpt;
	}

	/**
	 * @return the fee
	 */
	public String getFee() {
		return fee;
	}

	/**
	 * @param fee the fee to set
	 */
	public void setFee(String fee) {
		this.fee = fee;
	}

	/**
	 * @return the instr
	 */
	public String getInstr() {
		return instr;
	}

	/**
	 * @param instr the instr to set
	 */
	public void setInstr(String instr) {
		this.instr = instr;
	}

	/**
	 * @return the feebasis
	 */
	public String getFeebasis() {
		return feebasis;
	}

	/**
	 * @param feebasis the feebasis to set
	 */
	public void setFeebasis(String feebasis) {
		this.feebasis = feebasis;
	}

	/**
	 * @return the orgncode
	 */
	public String getOrgncode() {
		return orgncode;
	}

	/**
	 * @param orgncode the orgncode to set
	 */
	public void setOrgncode(String orgncode) {
		this.orgncode = orgncode;
	}

	/**
	 * @return the foodOrDrug
	 */
	public String getFoodOrDrug() {
		return foodOrDrug;
	}

	/**
	 * @param foodOrDrug the foodOrDrug to set
	 */
	public void setFoodOrDrug(String foodOrDrug) {
		this.foodOrDrug = foodOrDrug;
	}

	/**
	 * @return the appRegulation
	 */
	public String getAppRegulation() {
		return appRegulation;
	}

	/**
	 * @param appRegulation the appRegulation to set
	 */
	public void setAppRegulation(String appRegulation) {
		this.appRegulation = appRegulation;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appRegulation == null) ? 0 : appRegulation.hashCode());
		result = prime * result + ((catDescr == null) ? 0 : catDescr.hashCode());
		result = prime * result + ((catLetter == null) ? 0 : catLetter.hashCode());
		result = prime * result + ((catName == null) ? 0 : catName.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((dsc == null) ? 0 : dsc.hashCode());
		result = prime * result + ((fee == null) ? 0 : fee.hashCode());
		result = prime * result + ((feebasis == null) ? 0 : feebasis.hashCode());
		result = prime * result + ((foodOrDrug == null) ? 0 : foodOrDrug.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((instr == null) ? 0 : instr.hashCode());
		result = prime * result + ((isched == null) ? 0 : isched.hashCode());
		result = prime * result + ((orgncode == null) ? 0 : orgncode.hashCode());
		result = prime * result + ((regchpt == null) ? 0 : regchpt.hashCode());
		result = prime * result + ((rptitle == null) ? 0 : rptitle.hashCode());
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
		Category other = (Category) obj;
		if (appRegulation == null) {
			if (other.appRegulation != null)
				return false;
		} else if (!appRegulation.equals(other.appRegulation))
			return false;
		if (catDescr == null) {
			if (other.catDescr != null)
				return false;
		} else if (!catDescr.equals(other.catDescr))
			return false;
		if (catLetter == null) {
			if (other.catLetter != null)
				return false;
		} else if (!catLetter.equals(other.catLetter))
			return false;
		if (catName == null) {
			if (other.catName != null)
				return false;
		} else if (!catName.equals(other.catName))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (dsc == null) {
			if (other.dsc != null)
				return false;
		} else if (!dsc.equals(other.dsc))
			return false;
		if (fee == null) {
			if (other.fee != null)
				return false;
		} else if (!fee.equals(other.fee))
			return false;
		if (feebasis == null) {
			if (other.feebasis != null)
				return false;
		} else if (!feebasis.equals(other.feebasis))
			return false;
		if (foodOrDrug == null) {
			if (other.foodOrDrug != null)
				return false;
		} else if (!foodOrDrug.equals(other.foodOrDrug))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (instr == null) {
			if (other.instr != null)
				return false;
		} else if (!instr.equals(other.instr))
			return false;
		if (isched == null) {
			if (other.isched != null)
				return false;
		} else if (!isched.equals(other.isched))
			return false;
		if (orgncode == null) {
			if (other.orgncode != null)
				return false;
		} else if (!orgncode.equals(other.orgncode))
			return false;
		if (regchpt == null) {
			if (other.regchpt != null)
				return false;
		} else if (!regchpt.equals(other.regchpt))
			return false;
		if (rptitle == null) {
			if (other.rptitle != null)
				return false;
		} else if (!rptitle.equals(other.rptitle))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Category [id=" + id + ", catName=" + catName + ", catLetter=" + catLetter + ", dsc=" + dsc + ", code="
				+ code + ", isched=" + isched + ", catDescr=" + catDescr + ", rptitle=" + rptitle + ", regchpt="
				+ regchpt + ", fee=" + fee + ", instr=" + instr + ", feebasis=" + feebasis + ", orgncode=" + orgncode
				+ ", foodOrDrug=" + foodOrDrug + "]";
	}

	
}
