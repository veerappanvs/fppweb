/**
 * 
 */
package ma.dph.fpp.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author vsubramaniyan
 *
 */
@Entity(name = "Inventory") 
public class Inventory {


		@Id
		@Column(name = "Id") 
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		Integer id;
		
		@Column(name = "Bureau") 
		String bureau;
		
		@Column(name= "Application_Name")
		String appName;
		
		@Column(name= "App_Acronym")
		String appAcronym;
		
		@Column(name= "Data_Owner")
		String dataOwner;
		
		@Column(name= "Business_Application_Owner")
		String businessApplicationOwner;
		
		@Column(name= "Technical_Support_Lead")
		String technicalSupportLead;
		
		@Column(name= "IT_Program_Manager")
		String iTProgramManager;
		
		@Column(name= "Vendor")
		String vendor;
		
		@Column(name= "Web_Application_Yes_Or_No")
		String webApplicationYesOrNo;
		
		@Column(name= "Access_Database_Y_Or_N")
		String accessDatabaseYOrN;
		
		@Column(name= "Non_Access_Database_Type")
		String nonAccessDatabaseType;
		
		@Column(name= "Mission_Critical")
		String missionCritical;
		
		@Column(name= "Inidcator504")
		String inidcator504;
		
		@Column(name= "Data_Classification")
		String dataClassification;
		
		@Column(name= "Active_Ind")
		String activeInd;
		
		@Column(name= "App_Description")
		String appDescription;
		
		@Column(name= "Requires_24x7_Support")
		String requires24x7Support;
		
		@Column(name= "Audience")
		String audience;
		
		@Column(name= "Number_of_Users")
		String numberOfUsers;
		
		@Column(name= "Contact_person")
		String contactPerson;
		
		@Column(name= "Server_Details")
		String serverDetails;
		
		@Column(name= "Physical_Location")
		String physicalLocation;
		
		@Column(name= "Platform")
		String platform;
		
		@Column(name= "Platform_notes")
		String platformnotes;
		
		@Column(name= "Bureau_Application_Notes")
		String bureauApplicationNotes;
		
		@Column(name= "Created_By")
		String createdBy;
		
		@Column(name= "Created_Time")
		//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM-dd-yyyy ")
		private Date createdTime;
		
		@Column(name= "Last_Modified_By")
		String lastModifiedBy;
		
		@Column(name= "Last_Modified_Time")
		//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM-dd-yyyy ")
		private Date lastModifiedTime;
		
		
		@Column(name= "Confidentiality")
		private String  confidentiality;
		
		@Column(name= "Integrity")
		private String  integrity;
		
		@Column(name= "Availability")
		private String  availability;
		
		@Column(name= "Overall_Rating")
		private String  overallRating;
		
		@Column(name= "Critical_Or_NonCritical")
		private String  criticalOrNonCritical;

		
		@Column(name= "Hosted_At")
		private String  hostedAt;
		
		@Column(name= "Foxpro_Application")
		private String  foxproApplication;
		
		@Column(name= "Internet_Accessibility")
		private String  internetAccessibility;
		
		@Column(name= "Hosted_At_Others")
		private String  hostedAtOthers;
		
		public Inventory(){}
		 
		public Inventory(String bureau, String appName, String appAcronym, String dataOwner,
				String businessApplicationOwner, String technicalSupportLead, String iTProgramManager, String vendor,
				String webApplicationYesOrNo, String accessDatabaseYOrN, String nonAccessDatabaseType,
				String missionCritical, String inidcator504, String dataClassification, String activeInd,
				String appDescription, String requires24x7Support, String audience, String numberOfUsers,
				String contactPerson, String serverDetails, String physicalLocation, String platform,
				String platformnotes, String bureauApplicationNotes, String createdBy, Date createdTime,
				String lastModifiedBy, Date lastModifiedTime, String confidentiality, String integrity,
				String availability, String overallRating, String criticalOrNonCritical, String hostedAt,
				String foxproApplication, String internetAccessibility, String hostedAtOthers) {
			super();
			this.bureau = bureau;
			this.appName = appName;
			this.appAcronym = appAcronym;
			this.dataOwner = dataOwner;
			this.businessApplicationOwner = businessApplicationOwner;
			this.technicalSupportLead = technicalSupportLead;
			this.iTProgramManager = iTProgramManager;
			this.vendor = vendor;
			this.webApplicationYesOrNo = webApplicationYesOrNo;
			this.accessDatabaseYOrN = accessDatabaseYOrN;
			this.nonAccessDatabaseType = nonAccessDatabaseType;
			this.missionCritical = missionCritical;
			this.inidcator504 = inidcator504;
			this.dataClassification = dataClassification;
			this.activeInd = activeInd;
			this.appDescription = appDescription;
			this.requires24x7Support = requires24x7Support;
			this.audience = audience;
			this.numberOfUsers = numberOfUsers;
			this.contactPerson = contactPerson;
			this.serverDetails = serverDetails;
			this.physicalLocation = physicalLocation;
			this.platform = platform;
			this.platformnotes = platformnotes;
			this.bureauApplicationNotes = bureauApplicationNotes;
			this.createdBy = createdBy;
			this.createdTime = createdTime;
			this.lastModifiedBy = lastModifiedBy;
			this.lastModifiedTime = lastModifiedTime;
			this.confidentiality = confidentiality;
			this.integrity = integrity;
			this.availability = availability;
			this.overallRating = overallRating;
			this.criticalOrNonCritical = criticalOrNonCritical;
			this.hostedAt = hostedAt;
			this.foxproApplication = foxproApplication;
			this.internetAccessibility = internetAccessibility;
			this.hostedAtOthers = hostedAtOthers;
		}

		public Inventory(Integer id, String bureau, String appName, String appAcronym, String dataOwner,
				String businessApplicationOwner, String technicalSupportLead, String iTProgramManager, String vendor,
				String webApplicationYesOrNo, String accessDatabaseYOrN, String nonAccessDatabaseType,
				String missionCritical, String inidcator504, String dataClassification, String activeInd,
				String appDescription, String requires24x7Support, String audience, String numberOfUsers,
				String contactPerson, String serverDetails, String physicalLocation, String platform,
				String platformnotes, String bureauApplicationNotes, String createdBy, Date createdTime,
				String lastModifiedBy, Date lastModifiedTime, String confidentiality, String integrity,
				String availability, String overallRating, String criticalOrNonCritical, String hostedAt,
				String foxproApplication, String internetAccessibility, String hostedAtOthers) {
			super();
			this.id = id;
			this.bureau = bureau;
			this.appName = appName;
			this.appAcronym = appAcronym;
			this.dataOwner = dataOwner;
			this.businessApplicationOwner = businessApplicationOwner;
			this.technicalSupportLead = technicalSupportLead;
			this.iTProgramManager = iTProgramManager;
			this.vendor = vendor;
			this.webApplicationYesOrNo = webApplicationYesOrNo;
			this.accessDatabaseYOrN = accessDatabaseYOrN;
			this.nonAccessDatabaseType = nonAccessDatabaseType;
			this.missionCritical = missionCritical;
			this.inidcator504 = inidcator504;
			this.dataClassification = dataClassification;
			this.activeInd = activeInd;
			this.appDescription = appDescription;
			this.requires24x7Support = requires24x7Support;
			this.audience = audience;
			this.numberOfUsers = numberOfUsers;
			this.contactPerson = contactPerson;
			this.serverDetails = serverDetails;
			this.physicalLocation = physicalLocation;
			this.platform = platform;
			this.platformnotes = platformnotes;
			this.bureauApplicationNotes = bureauApplicationNotes;
			this.createdBy = createdBy;
			this.createdTime = createdTime;
			this.lastModifiedBy = lastModifiedBy;
			this.lastModifiedTime = lastModifiedTime;
			this.confidentiality = confidentiality;
			this.integrity = integrity;
			this.availability = availability;
			this.overallRating = overallRating;
			this.criticalOrNonCritical = criticalOrNonCritical;
			this.hostedAt = hostedAt;
			this.foxproApplication = foxproApplication;
			this.internetAccessibility = internetAccessibility;
			this.hostedAtOthers = hostedAtOthers;
		}

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
		 * @return the bureauOrOffice
		 */
		public String getBureau() {
			return bureau;
		}

		/**
		 * @param bureauOrOffice the bureauOrOffice to set
		 */
		public void setBureau(String bureau) {
			this.bureau = bureau;
		}

		/**
		 * @return the appName
		 */
		public String getAppName() {
			return appName;
		}

		/**
		 * @param appName the appName to set
		 */
		public void setAppName(String appName) {
			this.appName = appName;
		}

		/**
		 * @return the appAcronym
		 */
		public String getAppAcronym() {
			return appAcronym;
		}

		/**
		 * @param appAcronym the appAcronym to set
		 */
		public void setAppAcronym(String appAcronym) {
			this.appAcronym = appAcronym;
		}

		/**
		 * @return the data_Owner
		 */
		public String getDataOwner() {
			return dataOwner;
		}

		/**
		 * @param data_Owner the data_Owner to set
		 */
		public void setDataOwner(String data_Owner) {
			dataOwner = data_Owner;
		}

		/**
		 * @return the businessApplicationOwner
		 */
		public String getBusinessApplicationOwner() {
			return businessApplicationOwner;
		}

		/**
		 * @param businessApplicationOwner the businessApplicationOwner to set
		 */
		public void setBusinessApplicationOwner(String businessApplicationOwner) {
			this.businessApplicationOwner = businessApplicationOwner;
		}

		/**
		 * @return the technicalSupportLead
		 */
		public String getTechnicalSupportLead() {
			return technicalSupportLead;
		}

		/**
		 * @param technicalSupportLead the technicalSupportLead to set
		 */
		public void setTechnicalSupportLead(String technicalSupportLead) {
			this.technicalSupportLead = technicalSupportLead;
		}

		/**
		 * @return the iTProgramManager
		 */
		public String getiTProgramManager() {
			return iTProgramManager;
		}

		/**
		 * @param iTProgramManager the iTProgramManager to set
		 */
		public void setiTProgramManager(String iTProgramManager) {
			this.iTProgramManager = iTProgramManager;
		}

		/**
		 * @return the vendor
		 */
		public String getVendor() {
			return vendor;
		}

		/**
		 * @param vendor the vendor to set
		 */
		public void setVendor(String vendor) {
			this.vendor = vendor;
		}

		/**
		 * @return the webApplicationYesOrNo
		 */
		public String getWebApplicationYesOrNo() {
			return webApplicationYesOrNo;
		}

		/**
		 * @param webApplicationYesOrNo the webApplicationYesOrNo to set
		 */
		public void setWebApplicationYesOrNo(String webApplicationYesOrNo) {
			this.webApplicationYesOrNo = webApplicationYesOrNo;
		}

		/**
		 * @return the accessDatabaseYOrN
		 */
		public String getAccessDatabaseYOrN() {
			return accessDatabaseYOrN;
		}

		/**
		 * @param accessDatabaseYOrN the accessDatabaseYOrN to set
		 */
		public void setAccessDatabaseYOrN(String accessDatabaseYOrN) {
			this.accessDatabaseYOrN = accessDatabaseYOrN;
		}

		/**
		 * @return the nonAccessDatabaseType
		 */
		public String getNonAccessDatabaseType() {
			return nonAccessDatabaseType;
		}

		/**
		 * @param nonAccessDatabaseType the nonAccessDatabaseType to set
		 */
		public void setNonAccessDatabaseType(String nonAccessDatabaseType) {
			this.nonAccessDatabaseType = nonAccessDatabaseType;
		}

		/**
		 * @return the missionCritical
		 */
		public String getMissionCritical() {
			return missionCritical;
		}

		/**
		 * @param missionCritical the missionCritical to set
		 */
		public void setMissionCritical(String missionCritical) {
			this.missionCritical = missionCritical;
		}

		/**
		 * @return the inidcator504
		 */
		public String getInidcator504() {
			return inidcator504;
		}

		/**
		 * @param inidcator504 the inidcator504 to set
		 */
		public void setInidcator504(String inidcator504) {
			this.inidcator504 = inidcator504;
		}

		/**
		 * @return the dataClassification
		 */
		public String getDataClassification() {
			return dataClassification;
		}

		/**
		 * @param dataClassification the dataClassification to set
		 */
		public void setDataClassification(String dataClassification) {
			this.dataClassification = dataClassification;
		}

		/**
		 * @return the activeInd
		 */
		public String getActiveInd() {
			return activeInd;
		}

		/**
		 * @param activeInd the activeInd to set
		 */
		public void setActiveInd(String activeInd) {
			this.activeInd = activeInd;
		}

		/**
		 * @return the appDescription
		 */
		public String getAppDescription() {
			return appDescription;
		}

		/**
		 * @param appDescription the appDescription to set
		 */
		public void setAppDescription(String appDescription) {
			this.appDescription = appDescription;
		}

		/**
		 * @return the requires24x7Support
		 */
		public String getRequires24x7Support() {
			return requires24x7Support;
		}

		/**
		 * @param requires24x7Support the requires24x7Support to set
		 */
		public void setRequires24x7Support(String requires24x7Support) {
			this.requires24x7Support = requires24x7Support;
		}

		/**
		 * @return the audience
		 */
		public String getAudience() {
			return audience;
		}

		/**
		 * @param audience the audience to set
		 */
		public void setAudience(String audience) {
			this.audience = audience;
		}

		/**
		 * @return the numberOfUsers
		 */
		public String getNumberOfUsers() {
			return numberOfUsers;
		}

		/**
		 * @param numberOfUsers the numberOfUsers to set
		 */
		public void setNumberOfUsers(String numberOfUsers) {
			this.numberOfUsers = numberOfUsers;
		}

		/**
		 * @return the contactPerson
		 */
		public String getContactPerson() {
			return contactPerson;
		}

		/**
		 * @param contactPerson the contactPerson to set
		 */
		public void setContactPerson(String contactPerson) {
			this.contactPerson = contactPerson;
		}

		/**
		 * @return the serverDetails
		 */
		public String getServerDetails() {
			return serverDetails;
		}

		/**
		 * @param serverDetails the serverDetails to set
		 */
		public void setServerDetails(String serverDetails) {
			this.serverDetails = serverDetails;
		}

		/**
		 * @return the physicalLocation
		 */
		public String getPhysicalLocation() {
			return physicalLocation;
		}

		/**
		 * @param physicalLocation the physicalLocation to set
		 */
		public void setPhysicalLocation(String physicalLocation) {
			this.physicalLocation = physicalLocation;
		}

		/**
		 * @return the platform
		 */
		public String getPlatform() {
			return platform;
		}

		/**
		 * @param platform the platform to set
		 */
		public void setPlatform(String platform) {
			this.platform = platform;
		}

		/**
		 * @return the platformnotes
		 */
		public String getPlatformnotes() {
			return platformnotes;
		}

		/**
		 * @param platformnotes the platformnotes to set
		 */
		public void setPlatformnotes(String platformnotes) {
			this.platformnotes = platformnotes;
		}

		/**
		 * @return the bureauApplicationNotes
		 */
		public String getBureauApplicationNotes() {
			return bureauApplicationNotes;
		}

		/**
		 * @param bureauApplicationNotes the bureauApplicationNotes to set
		 */
		public void setBureauApplicationNotes(String bureauApplicationNotes) {
			this.bureauApplicationNotes = bureauApplicationNotes;
		}

		/**
		 * @return the createdBy
		 */
		public String getCreatedBy() {
			return createdBy;
		}

		/**
		 * @param createdBy the createdBy to set
		 */
		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}

		/**
		 * @return the createdTime
		 */
		public Date getCreatedTime() {
			return createdTime;
		}

		/**
		 * @param createdTime the createdTime to set
		 */
		public void setCreatedTime(Date createdTime) {
			this.createdTime = createdTime;
		}

		/**
		 * @return the lastModifiedBy
		 */
		public String getLastModifiedBy() {
			return lastModifiedBy;
		}

		/**
		 * @param lastModifiedBy the lastModifiedBy to set
		 */
		public void setLastModifiedBy(String lastModifiedBy) {
			this.lastModifiedBy = lastModifiedBy;
		}

		/**
		 * @return the lastModifiedTime
		 */
		public Date getLastModifiedTime() {
			return lastModifiedTime;
		}

		/**
		 * @param lastModifiedTime the lastModifiedTime to set
		 */
		public void setLastModifiedTime(Date lastModifiedTime) {
			this.lastModifiedTime = lastModifiedTime;
		}

		/**
		 * @return the confidentiality
		 */
		public String getConfidentiality() {
			return confidentiality;
		}

		/**
		 * @param confidentiality the confidentiality to set
		 */
		public void setConfidentiality(String confidentiality) {
			this.confidentiality = confidentiality;
		}

		/**
		 * @return the integrity
		 */
		public String getIntegrity() {
			return integrity;
		}

		/**
		 * @param integrity the integrity to set
		 */
		public void setIntegrity(String integrity) {
			this.integrity = integrity;
		}

		/**
		 * @return the availability
		 */
		public String getAvailability() {
			return availability;
		}

		/**
		 * @param availability the availability to set
		 */
		public void setAvailability(String availability) {
			this.availability = availability;
		}

		/**
		 * @return the overallRating
		 */
		public String getOverallRating() {
			return overallRating;
		}

		/**
		 * @param overallRating the overallRating to set
		 */
		public void setOverallRating(String overallRating) {
			this.overallRating = overallRating;
		}

		/**
		 * @return the criticalOrNonCritical
		 */
		public String getCriticalOrNonCritical() {
			return criticalOrNonCritical;
		}

		/**
		 * @param criticalOrNonCritical the criticalOrNonCritical to set
		 */
		public void setCriticalOrNonCritical(String criticalOrNonCritical) {
			this.criticalOrNonCritical = criticalOrNonCritical;
		}

		/**
		 * @return the hostedAt
		 */
		public String getHostedAt() {
			return hostedAt;
		}

		/**
		 * @param hostedAt the hostedAt to set
		 */
		public void setHostedAt(String hostedAt) {
			this.hostedAt = hostedAt;
		}

		/**
		 * @return the foxproApplication
		 */
		public String getFoxproApplication() {
			return foxproApplication;
		}

		/**
		 * @param foxproApplication the foxproApplication to set
		 */
		public void setFoxproApplication(String foxproApplication) {
			this.foxproApplication = foxproApplication;
		}

		/**
		 * @return the internetAccessibility
		 */
		public String getInternetAccessibility() {
			return internetAccessibility;
		}

		/**
		 * @param internetAccessibility the internetAccessibility to set
		 */
		public void setInternetAccessibility(String internetAccessibility) {
			this.internetAccessibility = internetAccessibility;
		}

		/**
		 * @return the hostedAtOthers
		 */
		public String getHostedAtOthers() {
			return hostedAtOthers;
		}

		/**
		 * @param hostedAtOthers the hostedAtOthers to set
		 */
		public void setHostedAtOthers(String hostedAtOthers) {
			this.hostedAtOthers = hostedAtOthers;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((accessDatabaseYOrN == null) ? 0 : accessDatabaseYOrN.hashCode());
			result = prime * result + ((activeInd == null) ? 0 : activeInd.hashCode());
			result = prime * result + ((appAcronym == null) ? 0 : appAcronym.hashCode());
			result = prime * result + ((appDescription == null) ? 0 : appDescription.hashCode());
			result = prime * result + ((appName == null) ? 0 : appName.hashCode());
			result = prime * result + ((audience == null) ? 0 : audience.hashCode());
			result = prime * result + ((availability == null) ? 0 : availability.hashCode());
			result = prime * result + ((bureau == null) ? 0 : bureau.hashCode());
			result = prime * result + ((bureauApplicationNotes == null) ? 0 : bureauApplicationNotes.hashCode());
			result = prime * result + ((businessApplicationOwner == null) ? 0 : businessApplicationOwner.hashCode());
			result = prime * result + ((confidentiality == null) ? 0 : confidentiality.hashCode());
			result = prime * result + ((contactPerson == null) ? 0 : contactPerson.hashCode());
			result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
			result = prime * result + ((createdTime == null) ? 0 : createdTime.hashCode());
			result = prime * result + ((criticalOrNonCritical == null) ? 0 : criticalOrNonCritical.hashCode());
			result = prime * result + ((dataClassification == null) ? 0 : dataClassification.hashCode());
			result = prime * result + ((dataOwner == null) ? 0 : dataOwner.hashCode());
			result = prime * result + ((foxproApplication == null) ? 0 : foxproApplication.hashCode());
			result = prime * result + ((hostedAt == null) ? 0 : hostedAt.hashCode());
			result = prime * result + ((hostedAtOthers == null) ? 0 : hostedAtOthers.hashCode());
			result = prime * result + ((iTProgramManager == null) ? 0 : iTProgramManager.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((inidcator504 == null) ? 0 : inidcator504.hashCode());
			result = prime * result + ((integrity == null) ? 0 : integrity.hashCode());
			result = prime * result + ((internetAccessibility == null) ? 0 : internetAccessibility.hashCode());
			result = prime * result + ((lastModifiedBy == null) ? 0 : lastModifiedBy.hashCode());
			result = prime * result + ((lastModifiedTime == null) ? 0 : lastModifiedTime.hashCode());
			result = prime * result + ((missionCritical == null) ? 0 : missionCritical.hashCode());
			result = prime * result + ((nonAccessDatabaseType == null) ? 0 : nonAccessDatabaseType.hashCode());
			result = prime * result + ((numberOfUsers == null) ? 0 : numberOfUsers.hashCode());
			result = prime * result + ((overallRating == null) ? 0 : overallRating.hashCode());
			result = prime * result + ((physicalLocation == null) ? 0 : physicalLocation.hashCode());
			result = prime * result + ((platform == null) ? 0 : platform.hashCode());
			result = prime * result + ((platformnotes == null) ? 0 : platformnotes.hashCode());
			result = prime * result + ((requires24x7Support == null) ? 0 : requires24x7Support.hashCode());
			result = prime * result + ((serverDetails == null) ? 0 : serverDetails.hashCode());
			result = prime * result + ((technicalSupportLead == null) ? 0 : technicalSupportLead.hashCode());
			result = prime * result + ((vendor == null) ? 0 : vendor.hashCode());
			result = prime * result + ((webApplicationYesOrNo == null) ? 0 : webApplicationYesOrNo.hashCode());
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
			Inventory other = (Inventory) obj;
			if (accessDatabaseYOrN == null) {
				if (other.accessDatabaseYOrN != null)
					return false;
			} else if (!accessDatabaseYOrN.equals(other.accessDatabaseYOrN))
				return false;
			if (activeInd == null) {
				if (other.activeInd != null)
					return false;
			} else if (!activeInd.equals(other.activeInd))
				return false;
			if (appAcronym == null) {
				if (other.appAcronym != null)
					return false;
			} else if (!appAcronym.equals(other.appAcronym))
				return false;
			if (appDescription == null) {
				if (other.appDescription != null)
					return false;
			} else if (!appDescription.equals(other.appDescription))
				return false;
			if (appName == null) {
				if (other.appName != null)
					return false;
			} else if (!appName.equals(other.appName))
				return false;
			if (audience == null) {
				if (other.audience != null)
					return false;
			} else if (!audience.equals(other.audience))
				return false;
			if (availability == null) {
				if (other.availability != null)
					return false;
			} else if (!availability.equals(other.availability))
				return false;
			if (bureau == null) {
				if (other.bureau != null)
					return false;
			} else if (!bureau.equals(other.bureau))
				return false;
			if (bureauApplicationNotes == null) {
				if (other.bureauApplicationNotes != null)
					return false;
			} else if (!bureauApplicationNotes.equals(other.bureauApplicationNotes))
				return false;
			if (businessApplicationOwner == null) {
				if (other.businessApplicationOwner != null)
					return false;
			} else if (!businessApplicationOwner.equals(other.businessApplicationOwner))
				return false;
			if (confidentiality == null) {
				if (other.confidentiality != null)
					return false;
			} else if (!confidentiality.equals(other.confidentiality))
				return false;
			if (contactPerson == null) {
				if (other.contactPerson != null)
					return false;
			} else if (!contactPerson.equals(other.contactPerson))
				return false;
			if (createdBy == null) {
				if (other.createdBy != null)
					return false;
			} else if (!createdBy.equals(other.createdBy))
				return false;
			if (createdTime == null) {
				if (other.createdTime != null)
					return false;
			} else if (!createdTime.equals(other.createdTime))
				return false;
			if (criticalOrNonCritical == null) {
				if (other.criticalOrNonCritical != null)
					return false;
			} else if (!criticalOrNonCritical.equals(other.criticalOrNonCritical))
				return false;
			if (dataClassification == null) {
				if (other.dataClassification != null)
					return false;
			} else if (!dataClassification.equals(other.dataClassification))
				return false;
			if (dataOwner == null) {
				if (other.dataOwner != null)
					return false;
			} else if (!dataOwner.equals(other.dataOwner))
				return false;
			if (foxproApplication == null) {
				if (other.foxproApplication != null)
					return false;
			} else if (!foxproApplication.equals(other.foxproApplication))
				return false;
			if (hostedAt == null) {
				if (other.hostedAt != null)
					return false;
			} else if (!hostedAt.equals(other.hostedAt))
				return false;
			if (hostedAtOthers == null) {
				if (other.hostedAtOthers != null)
					return false;
			} else if (!hostedAtOthers.equals(other.hostedAtOthers))
				return false;
			if (iTProgramManager == null) {
				if (other.iTProgramManager != null)
					return false;
			} else if (!iTProgramManager.equals(other.iTProgramManager))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (inidcator504 == null) {
				if (other.inidcator504 != null)
					return false;
			} else if (!inidcator504.equals(other.inidcator504))
				return false;
			if (integrity == null) {
				if (other.integrity != null)
					return false;
			} else if (!integrity.equals(other.integrity))
				return false;
			if (internetAccessibility == null) {
				if (other.internetAccessibility != null)
					return false;
			} else if (!internetAccessibility.equals(other.internetAccessibility))
				return false;
			if (lastModifiedBy == null) {
				if (other.lastModifiedBy != null)
					return false;
			} else if (!lastModifiedBy.equals(other.lastModifiedBy))
				return false;
			if (lastModifiedTime == null) {
				if (other.lastModifiedTime != null)
					return false;
			} else if (!lastModifiedTime.equals(other.lastModifiedTime))
				return false;
			if (missionCritical == null) {
				if (other.missionCritical != null)
					return false;
			} else if (!missionCritical.equals(other.missionCritical))
				return false;
			if (nonAccessDatabaseType == null) {
				if (other.nonAccessDatabaseType != null)
					return false;
			} else if (!nonAccessDatabaseType.equals(other.nonAccessDatabaseType))
				return false;
			if (numberOfUsers == null) {
				if (other.numberOfUsers != null)
					return false;
			} else if (!numberOfUsers.equals(other.numberOfUsers))
				return false;
			if (overallRating == null) {
				if (other.overallRating != null)
					return false;
			} else if (!overallRating.equals(other.overallRating))
				return false;
			if (physicalLocation == null) {
				if (other.physicalLocation != null)
					return false;
			} else if (!physicalLocation.equals(other.physicalLocation))
				return false;
			if (platform == null) {
				if (other.platform != null)
					return false;
			} else if (!platform.equals(other.platform))
				return false;
			if (platformnotes == null) {
				if (other.platformnotes != null)
					return false;
			} else if (!platformnotes.equals(other.platformnotes))
				return false;
			if (requires24x7Support == null) {
				if (other.requires24x7Support != null)
					return false;
			} else if (!requires24x7Support.equals(other.requires24x7Support))
				return false;
			if (serverDetails == null) {
				if (other.serverDetails != null)
					return false;
			} else if (!serverDetails.equals(other.serverDetails))
				return false;
			if (technicalSupportLead == null) {
				if (other.technicalSupportLead != null)
					return false;
			} else if (!technicalSupportLead.equals(other.technicalSupportLead))
				return false;
			if (vendor == null) {
				if (other.vendor != null)
					return false;
			} else if (!vendor.equals(other.vendor))
				return false;
			if (webApplicationYesOrNo == null) {
				if (other.webApplicationYesOrNo != null)
					return false;
			} else if (!webApplicationYesOrNo.equals(other.webApplicationYesOrNo))
				return false;
			return true;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Inventory [id=" + id + ", bureau=" + bureau + ", appName=" + appName + ", appAcronym=" + appAcronym
					+ ", dataOwner=" + dataOwner + ", businessApplicationOwner=" + businessApplicationOwner
					+ ", technicalSupportLead=" + technicalSupportLead + ", iTProgramManager=" + iTProgramManager
					+ ", vendor=" + vendor + ", webApplicationYesOrNo=" + webApplicationYesOrNo
					+ ", accessDatabaseYOrN=" + accessDatabaseYOrN + ", nonAccessDatabaseType=" + nonAccessDatabaseType
					+ ", missionCritical=" + missionCritical + ", inidcator504=" + inidcator504
					+ ", dataClassification=" + dataClassification + ", activeInd=" + activeInd + ", appDescription="
					+ appDescription + ", requires24x7Support=" + requires24x7Support + ", audience=" + audience
					+ ", numberOfUsers=" + numberOfUsers + ", contactPerson=" + contactPerson + ", serverDetails="
					+ serverDetails + ", physicalLocation=" + physicalLocation + ", platform=" + platform
					+ ", platformnotes=" + platformnotes + ", bureauApplicationNotes=" + bureauApplicationNotes
					+ ", createdBy=" + createdBy + ", createdTime=" + createdTime + ", lastModifiedBy=" + lastModifiedBy
					+ ", lastModifiedTime=" + lastModifiedTime + ", confidentiality=" + confidentiality + ", integrity="
					+ integrity + ", availability=" + availability + ", overallRating=" + overallRating
					+ ", criticalOrNonCritical=" + criticalOrNonCritical + ", hostedAt=" + hostedAt
					+ ", foxproApplication=" + foxproApplication + ", internetAccessibility=" + internetAccessibility
					+ ", hostedAtOthers=" + hostedAtOthers + "]";
		}



}
