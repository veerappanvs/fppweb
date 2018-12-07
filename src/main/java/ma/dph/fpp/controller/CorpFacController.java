package ma.dph.fpp.controller;

import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.dph.fpp.domain.facilities.Corporation;
import ma.dph.fpp.domain.facilities.Country;
import ma.dph.fpp.domain.facilities.Facilities;
import ma.dph.fpp.domain.facilities.FacilitySearchResult;
import ma.dph.fpp.domain.facilities.Fclass;
import ma.dph.fpp.domain.facilities.Registration;
import ma.dph.fpp.domain.facilities.Transaction;
import ma.dph.fpp.domain.generallicensing.ReceiptOfFeesRevised;
import ma.dph.fpp.repository.CorpRepository;
import ma.dph.fpp.repository.CountryRepository;
import ma.dph.fpp.repository.FacilitiesRepository;
import ma.dph.fpp.repository.FacilitiesSearchRepositry;
import ma.dph.fpp.repository.FclassRepository;
import ma.dph.fpp.repository.RegistrationRepository;
import ma.dph.fpp.repository.TransactionRepository;

@RestController
@RequestMapping(path = "/api") 
public class CorpFacController {

	static Logger log = Logger.getLogger(CorpFacController.class.getName());

	@Autowired
	private CorpRepository corpService;
	

	@Autowired
	private FacilitiesRepository facService;
	
	@Autowired
	private FacilitiesSearchRepositry facSearchService;
	
	@Autowired
	private TransactionRepository transactionService;
	
	@Autowired
	private RegistrationRepository registrationService;
	
	@Autowired
	private FclassRepository  fclassRepository;
	
	@Autowired
	private CountryRepository  countryRepository;
	
	@CrossOrigin
	@RequestMapping(value = "/corp/all", params = {"corpName"}, method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Corporation>> getCorpSearch(@RequestParam("corpName") String corpName) throws ParseException{
/*    	Date d = new Date();	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	d = sdf.parse("2014-01-01");
		List<Corporation>  corps = service.findByCEntrytmGreaterThanOrderByEntrytm(d);*/
    	List<Corporation>  corps = corpService.findByCorpNameIgnoreCaseContaining(corpName);
		return new ResponseEntity<List<Corporation>>(corps, HttpStatus.OK);
    }
		
	@CrossOrigin
	@PostMapping(value = "/corp/create")
	public  ResponseEntity<?> createCorp(@RequestBody Corporation corp, Principal user){
		corp.setcUserid(user.getName());
		corp.setcEntrytm(new Date()); 
		corpService.saveAndFlush(corp);
		return new ResponseEntity<Corporation>(corp, HttpStatus.OK);
	}
	
	@CrossOrigin
	@PostMapping(value = "/corp/modify")
	public  ResponseEntity<?> modifyCorp(@RequestBody Corporation corp, Principal user){
		//corp.setcUserid(user.getName());
		corpService.saveAndFlush(corp);
		return new ResponseEntity<Corporation>(corp, HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/corp/all", params = {"corpName", "corpAdd1", "corpAdd2", "corpCity", "corpState", "corpZip"}, method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Corporation>> getCorpSearch(
    		@RequestParam("corpName") String corpName,
    		@RequestParam("corpAdd1") String corpAdd1,
    		@RequestParam("corpAdd2") String corpAdd2,
    		@RequestParam("corpCity") String corpCity,
    		@RequestParam("corpState") String corpState,
    		@RequestParam("corpZip") String corpZip
    		) throws ParseException{
		
		List<Corporation>  corps =null;
/*    	Date d = new Date();	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	d = sdf.parse("2014-01-01");
		List<Corporation>  corps = service.findByCEntrytmGreaterThanOrderByEntrytm(d);*/
		
		if(    (null!=corpName && corpName.trim().length()> 0 )   && (corpAdd1 ==null || corpAdd1.trim().length() ==0 )  && (corpAdd2 ==null || corpAdd2.trim().length() ==0 )
				&& (corpCity ==null || corpCity.trim().length() ==0 )	 && (corpState ==null || corpState.trim().length() ==0 ) && (corpZip ==null || corpZip.trim().length() ==0 )   ){
			log.debug("Option 1");
			corps = corpService.findByCorpNameIgnoreCaseContaining(corpName);
		}
		
		
		else if(   ( null==corpName || corpName.trim().length()== 0  )  && (corpAdd1 !=null && corpAdd1.trim().length() >0 )  && (corpAdd2 ==null || corpAdd2.trim().length() ==0 )
				&& (corpCity ==null || corpCity.trim().length() ==0 )	 && (corpState ==null || corpState.trim().length() ==0 ) && (corpZip ==null || corpZip.trim().length() ==0 )   ){
			log.debug("Option 2");
			corps = corpService.findByCMailadd1IgnoreCaseContaining(corpAdd1);
		}
		
		else if(   ( null==corpName || corpName.trim().length()== 0  )  && (corpAdd2 !=null && corpAdd2.trim().length() >0 )  && (corpAdd1 ==null || corpAdd1.trim().length() ==0 )
				&& (corpCity ==null || corpCity.trim().length() ==0 )	 && (corpState ==null || corpState.trim().length() ==0 ) && (corpZip ==null || corpZip.trim().length() ==0 )   ){
			log.debug("Option 3");
			corps = corpService.findByCMailadd2IgnoreCaseContaining(corpAdd2);
		}
		

		else if(   ( null==corpName || corpName.trim().length()== 0  )  && (corpAdd2 ==null || corpAdd2.trim().length() ==0 )  && (corpAdd1 ==null || corpAdd1.trim().length() ==0 )
				&& (corpCity !=null && corpCity.trim().length() >0 )	 && (corpState ==null || corpState.trim().length() ==0 ) && (corpZip ==null || corpZip.trim().length() ==0 )   ){
			log.debug("Option 4");
			corps = corpService.findByCMailcityIgnoreCaseContaining(corpCity);
		}
    	
		
		else if(   ( null==corpName || corpName.trim().length()== 0  )  && (corpAdd2 ==null || corpAdd2.trim().length() ==0 )  && (corpAdd1 ==null || corpAdd1.trim().length() ==0 )
				&& (corpCity ==null || corpCity.trim().length() ==0 )	 && (corpState !=null && corpState.trim().length() >0 ) && (corpZip ==null || corpZip.trim().length() ==0 )   ){
			log.debug("Option 5");
			corps = corpService.findByCMailstateIgnoreCaseContaining(corpState);
		}
    	
		else if(   ( null==corpName || corpName.trim().length()== 0  )  && (corpAdd2 ==null || corpAdd2.trim().length() ==0 )  && (corpAdd1 ==null || corpAdd1.trim().length() ==0 )
				&& (corpCity ==null || corpCity.trim().length() ==0 )	 && (corpState ==null || corpState.trim().length() ==0 ) && (corpZip !=null && corpZip.trim().length() >0 )   ){
			log.debug("Option 6");
			corps = corpService.findByCMailstateIgnoreCaseContaining(corpState);
		}
		
		else if(   ( null!=corpName && corpName.trim().length()> 0  )  && (corpAdd2 !=null && corpAdd2.trim().length() >0 )  && (corpAdd1 !=null && corpAdd1.trim().length() >0 )
				&& (corpCity !=null && corpCity.trim().length() >0 )	 && (corpState !=null && corpState.trim().length() >0 ) && (corpZip !=null && corpZip.trim().length() >0 )   ){
			log.debug("Option 7");
			corps = corpService.findByCorpNameIgnoreCaseContainingAndCMailadd1IgnoreCaseContainingAndCMailcityIgnoreCaseContainingAndCMailstateIgnoreCaseContainingAndCMailzipIgnoreCaseContaining(corpName, corpAdd1, corpCity, corpState, corpZip);
		}
		else
		{
			log.debug("Option 8");
			corps = corpService.findByCorpNameIgnoreCaseContainingAndCMailadd1IgnoreCaseContainingAndCMailcityIgnoreCaseContainingAndCMailstateIgnoreCaseContainingAndCMailzipIgnoreCaseContaining(corpName, corpAdd1, corpCity, corpState, corpZip);
		}
    	
		log.debug("getCorpSearch corps "+corps);
		return new ResponseEntity<List<Corporation>>(corps, HttpStatus.OK);
    }
	
	@CrossOrigin
	@RequestMapping(value = "/corp/id/{id}")
	public ResponseEntity<Corporation> getCorp(@PathVariable("id") String id ) throws ParseException{
			
				Corporation  corps =null;
				corps = corpService.findById(Integer.valueOf(id));
				log.debug("getCorp Details "+corps);
			return new ResponseEntity<Corporation>(corps, HttpStatus.OK);
	    }
	
	
	@CrossOrigin
	@DeleteMapping(value = "/corp/id/{id}")
	public ResponseEntity<Corporation> removeCorp(@PathVariable("id") String id ) throws ParseException{
			
				Corporation  corps =null;
				corpService.delete(Integer.valueOf(id));
			return new ResponseEntity<Corporation>(corps, HttpStatus.OK);
	    }
	
	
	
	
	///////////////////////////////////////////////////////////////Facilities
	
	@CrossOrigin
	@RequestMapping(value = "/fac/all", params = {"facilityName"}, method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Facilities>> getFacSearch(@RequestParam("facilityName") String facilityName) throws ParseException{
    	List<Facilities>  facs = facService.findByFacilityNameIgnoreCaseContaining(facilityName);
		return new ResponseEntity<List<Facilities>>(facs, HttpStatus.OK);
    }
	
	
	
/*	@CrossOrigin
	@RequestMapping(value = "/fac/id/{id}")
	public ResponseEntity<Optional<Facilities>> getFacility(@PathVariable("id") String id ) throws ParseException{
				Optional<Facilities>  facs =null;
				facs = facService.findById(Integer.valueOf(id));
			return new ResponseEntity<Optional<Facilities>>(facs, HttpStatus.OK);
	 }
	*/
	
	
	@CrossOrigin
	@RequestMapping(value = "/fac/id/{id}")
	public ResponseEntity<Facilities> getFacility(@PathVariable("id") String id ) throws ParseException{
				Facilities  facs =null;
				facs = facService.findById(Integer.valueOf(id));
			return new ResponseEntity<Facilities>(facs, HttpStatus.OK);
	 }
	
	

	@CrossOrigin
	@RequestMapping(value = "/fac/corpid/{corporationId}")
	public ResponseEntity<List<Facilities>> getFacilityByCorpId(@PathVariable("corporationId") String corporationId ) throws ParseException{
		List<Facilities>  facs =null;
				facs = facService.findByCorporationId(Integer.valueOf(corporationId));
			return new ResponseEntity<List<Facilities>>(facs, HttpStatus.OK);
	 }
	
	
	
	@CrossOrigin
	@RequestMapping(value = "/fac/searchbycorpid/{corpId}")
	public ResponseEntity<Set<FacilitySearchResult>> getFacilitySearchByCorpId(@PathVariable("corpId") String corpId ) throws ParseException{
		Set<FacilitySearchResult>  facs =null;
				facs = facSearchService.findByCorpId(corpId);
			return new ResponseEntity<Set<FacilitySearchResult>>(facs, HttpStatus.OK);
	 }
	
	@CrossOrigin
	@RequestMapping(value = "/fac/all", params = {"facilityName", "facilityAddress1", "facilityAddress2", "facilityCity", "facilityState", "facilityZip"}, method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Facilities>> getFacSearch(
    		@RequestParam("facilityName") String facilityName,
    		@RequestParam("facilityAddress1") String facilityAddress1,
    		@RequestParam("facilityAddress2") String facilityAddress2,
    		@RequestParam("facilityCity") String facilityCity,
    		@RequestParam("facilityState") String facilityState,
    		@RequestParam("facilityZip") String facilityZip
    		) throws ParseException{
		List<Facilities> facs = null;
		
		
		
		if(   ( null!=facilityName && facilityName.trim().length()> 0  )  && (facilityAddress1 ==null || facilityAddress1.trim().length() ==0 )  && (facilityAddress2 ==null || facilityAddress2.trim().length() ==0 )
				&& (facilityCity ==null || facilityCity.trim().length() ==0 )	 && (facilityState ==null || facilityState.trim().length() ==0 ) && (facilityZip ==null || facilityZip.trim().length() ==0 )   ){
			log.debug("Option 1");
			facs = facService.findByFacilityNameIgnoreCaseContaining(facilityName);
		}
		
		else if(   ( null==facilityName || facilityName.trim().length()== 0  )  && (null != facilityAddress1 && facilityAddress1.trim().length() >0 )  && (facilityAddress2 ==null || facilityAddress2.trim().length() ==0 )
				&& (facilityCity ==null || facilityCity.trim().length() ==0 )	 && (facilityState ==null || facilityState.trim().length() ==0 ) && (facilityZip ==null || facilityZip.trim().length() ==0 )   ){
			log.debug("Option 2");
			facs = facService.findByFacilityAddress1IgnoreCaseContaining(facilityAddress1);
		}

		else if(   ( null==facilityName || facilityName.trim().length()== 0  )  && (null == facilityAddress1 || facilityAddress1.trim().length() ==0 )  && (null != facilityAddress2  && facilityAddress2.trim().length() >0 )
				&& (facilityCity ==null || facilityCity.trim().length() ==0 )	 && (facilityState ==null || facilityState.trim().length() ==0 ) && (facilityZip ==null || facilityZip.trim().length() ==0 )   ){
			log.debug("Option 3");
			facs = facService.findByFacilityAddress2IgnoreCaseContaining(facilityAddress2);
		}
		

		else if(   ( null==facilityName || facilityName.trim().length()== 0  )  && (null == facilityAddress1 || facilityAddress1.trim().length() ==0 )  && (facilityAddress2 ==null || facilityAddress2.trim().length() ==0 )
				&& (null != facilityCity  && facilityCity.trim().length() >0 )	 && (facilityState ==null || facilityState.trim().length() ==0 ) && (facilityZip ==null || facilityZip.trim().length() ==0 )   ){
			log.debug("Option 4");
			facs = facService.findByFacilityCityIgnoreCaseContaining(facilityCity);
		}
		

		else if(   ( null==facilityName || facilityName.trim().length()== 0  )  && (null == facilityAddress1 || facilityAddress1.trim().length() ==0 )  && (facilityAddress2 ==null || facilityAddress2.trim().length() ==0 )
				&& (facilityCity ==null || facilityCity.trim().length() ==00)	 && (null != facilityState && facilityState.trim().length() >0 ) && (facilityZip ==null || facilityZip.trim().length() ==0 )   ){
			log.debug("Option 5");
			facs = facService.findByFacilityStateIgnoreCaseContaining(facilityState);
		}
		
		else if(   ( null==facilityName || facilityName.trim().length()== 0  )  && (null == facilityAddress1 || facilityAddress1.trim().length() ==0 )  && (facilityAddress2 ==null || facilityAddress2.trim().length() ==0 )
				&& (facilityCity ==null || facilityCity.trim().length() ==0)	 && (facilityState ==null || facilityState.trim().length() ==0) && (null != facilityZip && facilityZip.trim().length() >0 )   ){
			log.debug("Option 6");
			facs = facService.findByFacilityZipIgnoreCaseContaining(facilityZip);
		}
		
		else if(   ( null!=facilityName && facilityName.trim().length()> 0  )  && (null != facilityAddress1 && facilityAddress1.trim().length() >0 )  && (null != facilityAddress2  && facilityAddress2.trim().length() >0 )
				&& (null != facilityCity && facilityCity.trim().length() >0)	 && (null != facilityState && facilityState.trim().length() >0) && (null != facilityZip && facilityZip.trim().length() >0 )   ){
			log.debug("Option 7");
			facs = facService.findByFacilityNameIgnoreCaseContainingAndFacilityAddress1IgnoreCaseContainingAndFacilityAddress2IgnoreCaseContainingAndFacilityCityIgnoreCaseContainingAndFacilityStateIgnoreCaseContainingAndFacilityZipIgnoreCaseContaining(facilityName, facilityAddress1,facilityAddress2, facilityState, facilityCity, facilityZip);
		}
		
		else {
			log.debug("Option 9");
			facs = facService.findByFacilityNameIgnoreCaseContainingAndFacilityAddress1IgnoreCaseContainingAndFacilityAddress2IgnoreCaseContainingAndFacilityCityIgnoreCaseContainingAndFacilityStateIgnoreCaseContainingAndFacilityZipIgnoreCaseContaining(facilityName, facilityAddress1, facilityAddress2, facilityState, facilityCity, facilityZip);
		}
		
		log.debug(" getFacSearch"+facs);
		
		return new ResponseEntity<List<Facilities>>(facs, HttpStatus.OK);
	}
	
	
	
	
/////////////////////////////////////////////////Facilities Search View
	



	@CrossOrigin
	@GetMapping(value = "/facview/id/{id}",  produces = "application/json")
    public ResponseEntity<FacilitySearchResult> getFacViewDetail(@PathVariable("id") String id ) throws ParseException{
    	Optional<FacilitySearchResult>   facs = facSearchService.findByFacId(Integer.valueOf(id));
		return new ResponseEntity<FacilitySearchResult>(facs.get(), HttpStatus.OK);
    }
	
	@CrossOrigin
	@RequestMapping(value = "/facview/all", params = {"facilityName"}, method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Set<FacilitySearchResult>> getFacViewSearch(@RequestParam("facilityName") String facilityName) throws ParseException{
    	Set<FacilitySearchResult>  facs = facSearchService.findByFacilityNameIgnoreCaseContaining(facilityName);
		return new ResponseEntity<Set<FacilitySearchResult>>(facs, HttpStatus.OK);
    }
	
	@CrossOrigin
	@RequestMapping(value = "/facview/all", params = {"facilityAdd1"}, method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Set<FacilitySearchResult>> getFacViewSearchByAdd1(@RequestParam("facilityAdd1") String facilityAdd1) throws ParseException{
    	Set<FacilitySearchResult>  facs = facSearchService.findByFacilityAdd1IgnoreCaseContaining(facilityAdd1);
		return new ResponseEntity<Set<FacilitySearchResult>>(facs, HttpStatus.OK);
    }
	
	@CrossOrigin
	@RequestMapping(value = "/facview/all", params = {"license"}, method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Set<FacilitySearchResult>> getFacViewSearchByLicense(@RequestParam("license") String license) throws ParseException{
    	Set<FacilitySearchResult>  facs = facSearchService.findByLicenseIgnoreCaseContaining(license);
		return new ResponseEntity<Set<FacilitySearchResult>>(facs, HttpStatus.OK);
    }
	
	
	@CrossOrigin
	@RequestMapping(value = "/facview/all", params = {"facilityName", "facilityAdd1", "license", "licenseType", "corpName", "facilityCity", "facZip"}, method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Set<FacilitySearchResult>> getFacViewSearchByAll(@RequestParam("facilityName") String facilityName, @RequestParam("facilityAdd1") String facilityAdd1, @RequestParam("license") String license,  @RequestParam("licenseType") String licenseType,  @RequestParam("corpName") String corpName, @RequestParam("facilityCity") String facilityCity, @RequestParam("facZip") String facZip) throws ParseException{
    	
		log.debug("facilityName="+facilityName+ ";facilityAdd1="+facilityAdd1+ ";license="+license+ ";licenseType="+licenseType+ ";corpName="+corpName+ ";facilityCity="+facilityCity+";facZip="+facZip);
		Set<FacilitySearchResult> facSearchResults = null;

		if(   ( null!=facilityName && facilityName.trim().length()> 0  )  && (facilityAdd1 ==null || facilityAdd1.trim().length() ==0 )  && (license ==null || license.trim().length() ==0 )
				&& (licenseType ==null || licenseType.trim().length() ==0 )	 && (corpName ==null || corpName.trim().length() ==0 ) && (facZip ==null || facZip.trim().length() ==0 )   && (facilityCity ==null || facilityCity.trim().length() ==0 )  ){
			log.debug("Option 1");
			facSearchResults = facSearchService.findByFacilityNameIgnoreCaseContaining(facilityName);
		}
		else if(   ( null==facilityName || facilityName.trim().length()== 0  )  && (null !=facilityAdd1  &&facilityAdd1.trim().length() >0 )  && (license ==null || license.trim().length() ==0 )
				&& (licenseType ==null || licenseType.trim().length() ==0 )	 && (corpName ==null || corpName.trim().length() ==0 ) && (facZip ==null || facZip.trim().length() ==0 )  && (facilityCity ==null || facilityCity.trim().length() ==0 ) ){
			log.debug("Option 2");
			facSearchResults = facSearchService.findByFacilityAdd1IgnoreCaseContaining(facilityAdd1);
		}
		else if(   (  null==facilityName || facilityName.trim().length()== 0  )  && (facilityAdd1 ==null || facilityAdd1.trim().length() ==0 )  && (null !=license  &&license.trim().length() >0 )
				&& (licenseType ==null || licenseType.trim().length() ==0 )	 && (corpName ==null || corpName.trim().length() ==0 ) && (facZip ==null || facZip.trim().length() ==0 )  && (facilityCity ==null || facilityCity.trim().length() ==0 ) ){
			log.debug("Option 3");		
			facSearchResults = facSearchService.findByLicenseIgnoreCaseContaining(license);
		}
		else if(   (  null==facilityName || facilityName.trim().length()== 0  )  && (facilityAdd1 ==null || facilityAdd1.trim().length() ==0 )  && (license ==null || license.trim().length() ==0 )
				&& (null !=licenseType  && licenseType.trim().length() >0 )	 && (corpName ==null || corpName.trim().length() ==0 ) && (facZip ==null || facZip.trim().length() ==0 )  && (facilityCity ==null || facilityCity.trim().length() ==0 ) ){
			log.debug("Option 4");
			facSearchResults = facSearchService.findByLicenseTypeIgnoreCaseContaining(licenseType);
		}
		else if(   (  null==facilityName || facilityName.trim().length()== 0   )  && (facilityAdd1 ==null || facilityAdd1.trim().length() ==0 )  && (license ==null || license.trim().length() ==0 )
				&& (licenseType ==null || licenseType.trim().length() ==0 )	 && (null != corpName  && corpName.trim().length() >0 ) && (facZip ==null || facZip.trim().length() ==0 ) && (facilityCity ==null || facilityCity.trim().length() ==0 )  ){
			log.debug("Option 5");
			facSearchResults = facSearchService.findByCorpNameIgnoreCaseContaining(corpName);
		}
		else if(   (  null==facilityName || facilityName.trim().length()== 0  )  && (facilityAdd1 ==null || facilityAdd1.trim().length() ==0 )  && (license ==null || license.trim().length() ==0 )
				&& (licenseType ==null || licenseType.trim().length() ==0 )	 && (corpName ==null || corpName.trim().length() ==0 ) && (null !=facZip  && facZip.trim().length() >0 )  && (facilityCity ==null || facilityCity.trim().length() ==0 ) ){
			log.debug("Option 6");
			facSearchResults = facSearchService.findByFacZipIgnoreCaseContaining(facZip);
		}
		else if(   (  null==facilityName || facilityName.trim().length()== 0  )  && (facilityAdd1 ==null || facilityAdd1.trim().length() ==0 )  && (license ==null || license.trim().length() ==0 )
				&& (licenseType ==null || licenseType.trim().length() ==0 )	 && (corpName ==null || corpName.trim().length() ==0 ) && (null ==facZip  || facZip.trim().length() ==0 )  && (null != facilityCity && facilityCity.trim().length() >0 ) ){
			log.debug("Option 7");
			facSearchResults = facSearchService.findByFacilityCityIgnoreCaseContaining(facilityCity);
		}
		
		else if(   (  null !=facilityName && facilityName.trim().length()> 0  )  && (facilityAdd1 !=null && facilityAdd1.trim().length() >0 )  && (license !=null && license.trim().length() >0 )
				&& (licenseType !=null && licenseType.trim().length() >0 )	 && (corpName !=null && corpName.trim().length() >0 ) && (null !=facZip  && facZip.trim().length() >0 )  && (null != facilityCity && facilityCity.trim().length() >0 ) ){
			log.debug("Option 7");
			facSearchResults = facSearchService.findByFacilityNameIgnoreCaseContainingAndFacilityAdd1IgnoreCaseContainingAndLicenseIgnoreCaseContainingAndLicenseTypeIgnoreCaseContainingAndCorpNameIgnoreCaseContainingAndFacilityCityIgnoreCaseContainingAndFacZipContaining(facilityName, facilityAdd1, license, licenseType, corpName, facilityCity, facZip);
		}
		else {		
			facSearchResults = facSearchService.findByFacilityNameIgnoreCaseContainingAndFacilityAdd1IgnoreCaseContainingAndLicenseIgnoreCaseContainingAndLicenseTypeIgnoreCaseContainingAndCorpNameIgnoreCaseContainingAndFacilityCityIgnoreCaseContainingAndFacZipContaining(facilityName, facilityAdd1, license, licenseType, corpName, facilityCity, facZip);
		}
		log.debug("getFacViewSearchByAll facSearchResults "+facSearchResults);
		return new ResponseEntity<Set<FacilitySearchResult>>(facSearchResults, HttpStatus.OK);
    }
	
	
	
	
	////////////Transactions
	@CrossOrigin
	@RequestMapping(value = "/trans/id/{trasnId}",  method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Optional<Transaction>> getTransaction(@PathVariable("trasnId") String trasnId) throws ParseException{
    	Optional<Transaction>  facs = transactionService.findById(Integer.valueOf(trasnId));
		return new ResponseEntity<Optional<Transaction>>(facs, HttpStatus.OK);
    }
	
	
	@CrossOrigin
	@PostMapping(value = "/trans/new/{facId}")
    public ResponseEntity<?> createTransaction( @PathVariable("facId") String facId, @RequestBody Transaction transaction, Principal user) throws Exception{
		
    	log.debug("createTransaction   transaction= "+transaction+" facId = "+facId);
    	Integer facIdint = Integer.parseInt(facId);
    	Fclass fclass  = fclassRepository.getByFacId(facIdint);
    	if(fclass == null ) {
    		log.error("Fclass missing for the facility "+facId);
    		throw new Exception("Fclass missing for the facility "+facId);
    	}
    	
    	Registration  reg = registrationService.findByRegistrationsByFacilityId(facId);
   		if (reg == null  ) {
   			
   			
   			if("RENEWAL".equalsIgnoreCase(transaction.getCertaction()) || "FEE CHARGED".equalsIgnoreCase(transaction.getCertaction()) ) {
					Country country = countryRepository.findTwoDigitCodeByfacility(facIdint);
					String countryCode = "";
					String twoCountryCode = country.getCntCode();
				   if(null != twoCountryCode & !twoCountryCode.equals("(US)"))
					{
						 countryCode = twoCountryCode;
					}   			
					reg = new Registration(fclass.getClassId(), fclass.getFacClass(), "",  new Date(), DateUtils.addYears(new Date(), 1), "A", user.getName(), new Date());
					
					registrationService.saveAndFlush(reg);
					log.debug("Saved new Registration "+reg);
					reg.setRegLicense("MA-"+reg.getRegId()+countryCode);
					registrationService.saveAndFlush(reg);
					log.debug("Updated the Registration number"+reg);
					
					Facilities facility = facService.getOne(facIdint);
					facility.setFacilityStatus("A");
					facService.saveAndFlush(facility);
					log.debug("Updated Facility Status"+facility);
   			}
   			else 
   			{
   					log.debug("There is no registration for the facility id "+facId);
   			}

   		}else if(reg.getRegId() != null){
   			if("RENEWAL".equalsIgnoreCase(transaction.getCertaction()) || "FEE CHARGED".equalsIgnoreCase(transaction.getCertaction()) ) {
   				log.debug(" transaction.getCertaction()   "+transaction.getCertaction()+"  Adding trasnactions"+reg.getRegId());
   				reg.setDateIssue(DateUtils.addDays(reg.getDateExpire(), 1));
				reg.setDateExpire(DateUtils.addYears(reg.getDateExpire(), 1));
				reg.setRegStatus("A");
				registrationService.saveAndFlush(reg);
				log.debug("Increement the exiration date and saved the Registration");
				
				
				fclass.setFacStatus("A");
				fclassRepository.saveAndFlush(fclass);
				log.debug("Updated FClass Status"+fclass);
				
				Facilities facility = facService.getOne(facIdint);
				facility.setFacilityStatus("A");
				facService.saveAndFlush(facility);
				log.debug("Updated Facility Status"+facility);
   			}   			
   		}
   		else {
   			log.error("Regid is null for facility "+facId);
   			throw new Exception("Regid missing for the facility "+facId);
   		}
			 log.debug("createTransaction  regid = "+reg.getRegId());
			 transaction.setRegId(reg.getRegId());
			 transaction.settEntrytm(new Date());
			 transaction.setPrinted((transaction.getPrinted() ==null? "0":transaction.getPrinted() )); 
			 transaction.settUserid(user.getName());
	    	 transactionService.saveAndFlush(transaction);
	    	 
		return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
    }
		
	
	
	
	/*	
	@CrossOrigin
	@PostMapping(value = "/trans/new")
    public ResponseEntity<?> createTransaction( @RequestBody Transaction transaction) throws ParseException{
		
		// Integer regId =transactionService.findRegIdByFacilityId(facId);
		 transaction.setRegId(1234);
    	 transactionService.saveAndFlush(transaction);
		return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
    }*/
	
	
	@CrossOrigin
	@PostMapping(value = "/trans/modify")
    public ResponseEntity<?> modifyTransaction(@RequestBody Transaction transaction) throws ParseException{
		
		log.debug("Modify trasnaction "+transaction);
    	 transactionService.saveAndFlush(transaction);
		return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
    }
	
	@CrossOrigin
	@GetMapping(value = "/trans/facid/{facid}",  produces = "application/json")
    public ResponseEntity<List<Transaction>> getTranscationsByFacilityId(@PathVariable("facid") String facId) throws ParseException{
    	List<Transaction>  facs =  transactionService.findByTranscationsByFacilityId(facId);
    	log.debug("getTranscationsByFacilityId "+facs);
		return new ResponseEntity<List<Transaction>>(facs, HttpStatus.OK);
    }
	
		
	////////////Transactions
	@CrossOrigin
	@RequestMapping(value = "/trans/delete/{trasnId}", method = RequestMethod.GET)
	public ResponseEntity<String> deletedTransaction(@PathVariable("trasnId") Integer trasnId) throws ParseException {
	System.out.println("deletedif ============================="+trasnId);
	transactionService.delete(Integer.valueOf(trasnId));
	return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
	}
	
	
	
/*	////////////Registrations
	@CrossOrigin
	@GetMapping(value = "/registration/facid/{facid}",  produces = "application/json")
    public ResponseEntity<List<Registration>> getRegistrationByFacilityId(@PathVariable("facid") String facId) throws ParseException{
    	List<Registration>  facs =  registrationService.findByRegistrationsByFacilityId(facId);
		return new ResponseEntity<List<Registration>>(facs, HttpStatus.OK);
    }*/
	
	
	
}
