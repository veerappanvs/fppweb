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
@Entity(name = "tblCountries")
public class Country {
	
	/**
	 * 
	 */
	public Country() {	
		// TODO Auto-generated constructor stub
	}
	
	
	@Id
	@Column(name = "cnt_pk")
	private Integer  cntPk;
	
	@Column(name = "cnt_name")
	private String  cntName;
	
	@Column(name = "cnt_code")
	private String  cntCode;

	public Country(Integer cntPk, String cntName, String cntCode) {
		super();
		this.cntPk = cntPk;
		this.cntName = cntName;
		this.cntCode = cntCode;
	}

	/**
	 * @return the cntPk
	 */
	public Integer getCntPk() {
		return cntPk;
	}

	/**
	 * @param cntPk the cntPk to set
	 */
	public void setCntPk(Integer cntPk) {
		this.cntPk = cntPk;
	}

	/**
	 * @return the cntName
	 */
	public String getCntName() {
		return cntName;
	}

	/**
	 * @param cntName the cntName to set
	 */
	public void setCntName(String cntName) {
		this.cntName = cntName;
	}

	/**
	 * @return the cntCode
	 */
	public String getCntCode() {
		return cntCode;
	}

	/**
	 * @param cntCode the cntCode to set
	 */
	public void setCntCode(String cntCode) {
		this.cntCode = cntCode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cntCode == null) ? 0 : cntCode.hashCode());
		result = prime * result + ((cntName == null) ? 0 : cntName.hashCode());
		result = prime * result + ((cntPk == null) ? 0 : cntPk.hashCode());
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
		Country other = (Country) obj;
		if (cntCode == null) {
			if (other.cntCode != null)
				return false;
		} else if (!cntCode.equals(other.cntCode))
			return false;
		if (cntName == null) {
			if (other.cntName != null)
				return false;
		} else if (!cntName.equals(other.cntName))
			return false;
		if (cntPk == null) {
			if (other.cntPk != null)
				return false;
		} else if (!cntPk.equals(other.cntPk))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Country [cntPk=" + cntPk + ", cntName=" + cntName + ", cntCode=" + cntCode + "]";
	}
	
	
	

}
