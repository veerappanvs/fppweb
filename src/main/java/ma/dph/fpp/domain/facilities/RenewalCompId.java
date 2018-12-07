package ma.dph.fpp.domain.facilities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
	public class RenewalCompId  implements Serializable{
		
		public RenewalCompId(Integer prkey, Date dstart, Date dend) {
			super();
			this.prkey = prkey;
			this.dstart = dstart;
			this.dend = dend;
		}
		
		public RenewalCompId() {}

		Integer prkey;
		Date dstart;
		Date dend;
		/**
		 * @return the prkey
		 */
		public Integer getPrkey() {
			return prkey;
		}

		/**
		 * @param prkey the prkey to set
		 */
		public void setPrkey(Integer prkey) {
			this.prkey = prkey;
		}

		/**
		 * @return the dstart
		 */
		public Date getDstart() {
			return dstart;
		}

		/**
		 * @param dstart the dstart to set
		 */
		public void setDstart(Date dstart) {
			this.dstart = dstart;
		}

		/**
		 * @return the dend
		 */
		public Date getDend() {
			return dend;
		}

		/**
		 * @param dend the dend to set
		 */
		public void setDend(Date dend) {
			this.dend = dend;
		}

		
	
		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((dend == null) ? 0 : dend.hashCode());
			result = prime * result + ((dstart == null) ? 0 : dstart.hashCode());
			result = prime * result + ((prkey == null) ? 0 : prkey.hashCode());
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
			RenewalCompId other = (RenewalCompId) obj;
			if (dend == null) {
				if (other.dend != null)
					return false;
			} else if (!dend.equals(other.dend))
				return false;
			if (dstart == null) {
				if (other.dstart != null)
					return false;
			} else if (!dstart.equals(other.dstart))
				return false;
			if (prkey == null) {
				if (other.prkey != null)
					return false;
			} else if (!prkey.equals(other.prkey))
				return false;
			return true;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "RenwalId [prkey=" + prkey + ", dstart=" + dstart + ", dend=" + dend + "]";
		}
		
		
		
	} 