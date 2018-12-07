package ma.dph.fpp.controller;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;

import ma.dph.fpp.domain.facilities.Category;
import ma.dph.fpp.domain.facilities.Corporation;
import ma.dph.fpp.domain.facilities.ExpiredFacList;
import ma.dph.fpp.domain.facilities.Facilities;
import ma.dph.fpp.domain.facilities.FacilitiesReg;
import ma.dph.fpp.domain.facilities.FacilitySearchResult;
import ma.dph.fpp.domain.facilities.Fclass;
import ma.dph.fpp.domain.facilities.FoodProcesorInfo;
import ma.dph.fpp.domain.facilities.PrintCertificate;
import ma.dph.fpp.domain.facilities.Registration;
import ma.dph.fpp.domain.facilities.RenewalCompId;
import ma.dph.fpp.domain.facilities.RenewalsView;
import ma.dph.fpp.domain.facilities.Renewalsfood;
import ma.dph.fpp.domain.facilities.RenewalsfoodDetails;
import ma.dph.fpp.domain.facilities.Transaction;
import ma.dph.fpp.repository.CategoryRepository;
import ma.dph.fpp.repository.CorpRepository;
import ma.dph.fpp.repository.ExpiredFacListRepository;
import ma.dph.fpp.repository.FacilitiesRepository;
import ma.dph.fpp.repository.FclassRepository;
import ma.dph.fpp.repository.FoodProcessorRepository;
import ma.dph.fpp.repository.PrintCertificateRepository;
import ma.dph.fpp.repository.RegistrationRepository;
import ma.dph.fpp.repository.RenewalsFoodDetailsRepository;
import ma.dph.fpp.repository.RenewalsFoodRepository;
import ma.dph.fpp.repository.RenewalsViewRepository;
import ma.dph.fpp.repository.TransactionRepository;
import ma.dph.fpp.util.ExcelFileGenerator;
import ma.dph.fpp.util.WordFileGenerator;

@RestController
@RequestMapping(path = "/api/facility") 
public class FacilitiesController {

	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	
	static Logger log = Logger.getLogger(FacilitiesController.class.getName());

	@Autowired
	private FacilitiesRepository facService;
	@Autowired
	private FclassRepository fclassServcie;
	
	@Autowired
	private RenewalsFoodRepository renewalsFoodServcie;
	
	@Autowired
	private RenewalsViewRepository renewalsViewServcie;
	
	@Autowired
	private RenewalsFoodDetailsRepository renewalsFooddetailServcie;
	
	@Autowired
	private RenewalsViewRepository renewalsViewService;
	
	@Autowired
	private ExpiredFacListRepository expiredFacListService;
	
	@Autowired
	private TransactionRepository transactionService;
	
	@Autowired
	private RegistrationRepository registrationService;
	
	@Autowired
	private FoodProcessorRepository foddprocessor;
	
	@Autowired
	private CorpRepository corpService;
	
	@Autowired
	private ExcelFileGenerator   excelFileGenerator;
	
	@Autowired
	private PrintCertificateRepository printCertificateService;
	
	@Autowired
	private WordFileGenerator wordFileGenerator;
	
	@Autowired
	private CategoryRepository categoryService;
	
	
	@CrossOrigin
	@RequestMapping(value = "/all", params = {"facilityName"}, method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Facilities>> getfacilitySearch(@RequestParam("facilityName") String facilityName) throws ParseException{
/*    	Date d = new Date();	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	d = sdf.parse("2014-01-01");
		List<Corporation>  corps = service.findByCEntrytmGreaterThanOrderByEntrytm(d);*/
		
		
    	List<Facilities>  corps = facService.findByFacilityNameIgnoreCaseContaining(facilityName);
    	System.out.println("corps-------------=========>"+corps);
    	return new ResponseEntity<List<Facilities>>(corps, HttpStatus.OK);
    }
	
	
	@CrossOrigin
	@PostMapping(value = "/create")
	@Transactional
	public  ResponseEntity<?> createFacility(@RequestBody FacilitiesReg facilitiesReg, Principal user) {
		
		//try (
		log.debug("Saving Facility "+facilitiesReg);	
		
		Facilities facility = facilitiesReg.getFacilities();
		
		
		
		Category cat = new Category();
		FoodProcesorInfo foodProcesorInfo = facilitiesReg.getFoodProcesorInfo();
		Registration registration = facilitiesReg.getRegistration();
		Corporation corp = facilitiesReg.getCorp();
		Fclass  fclass = facilitiesReg.getFclass();
		Category  category   = facilitiesReg.getCategory();
		log.debug("createFacility  facilitiesReg "+facilitiesReg);
		
		if(corp != null ) {
			
			facility.setCorporationId(corp.getId());
		}
		
		if(foodProcesorInfo != null ) {
			foddprocessor.saveAndFlush(foodProcesorInfo);
			facility.setFoodProcesssorId(foodProcesorInfo.getId());
		}

		log.debug("Saved  foodProcesorInfo  "+foodProcesorInfo);

		
			if(facility.getId() == null) {
				facility.setFacilityEntryTime(new Date());
				facility.setFacilityUserId(user.getName());
			}
			else {
				//TODO change it to modified time and user
				facility.setFacilityEntryTime(new Date());
				facility.setFacilityUserId(user.getName());
			}
		
			facility.setFacilityUserId(user.getName());
			log.debug("Saved  facility  "+facility);
			facService.saveAndFlush(facility);
			log.debug("Saved  facility  "+facility.getId());
		
			//TODO Change the  fac_status column
			if(fclass == null) {
				log.debug("createFacility fclass is null ");
				
				fclass= new Fclass();
				fclass.setFacClass( facility.getFacType());
				 //fclass = new Fclass(facility.getId(), facility.getFacilityType(), "", " ",  "", user.getName(), new Date());
			}
				fclass.setFacId(facility.getId());
				//fclass.setFacClass( facility.getFacType());
				fclass.setFacStatus( facility.getFacilityStatus());
				fclass.setClUserid(user.getName());
				fclass.setClEntrytm( new Date());
				
				fclassServcie.saveAndFlush(fclass);
				
				//TODO
				/*if(facility.getId() != null & registration !=null ) {
					log.debug("registration -- "+registration);
					registrationService.saveAndFlush(registration);
				}*/
			
			log.debug("Saved  fclass  "+fclass);

			log.debug("Facility saved");	
	
		return new ResponseEntity<Facilities>(facility, HttpStatus.OK);
	}
	
	
	@CrossOrigin
	@PutMapping(value = "/modify")
	@Transactional
	public  ResponseEntity<?> modifyFacility(@RequestBody FacilitiesReg facilitiesReg, Principal user) {
		
		//try (
		log.debug("Modifying Facility "+facilitiesReg);	
		
		Corporation corp = facilitiesReg.getCorp();
		Facilities facility = facilitiesReg.getFacilities();
		Fclass  fclass = facilitiesReg.getFclass();
		Registration registration = facilitiesReg.getRegistration();
		FoodProcesorInfo foodProcesorInfo = facilitiesReg.getFoodProcesorInfo();
		Category  category   = facilitiesReg.getCategory();
		
		if(corp != null && facility.getCorporationId() !=null ) {
			
			facility.setCorporationId(corp.getId());
		}
		
		if(facility.getId() != null) {
		
			//TODO change it to modified time and user
			facility.setFacilityEntryTime(new Date());
			facility.setFacilityUserId(user.getName());
			facility.setFacilityUserId(user.getName());
			log.debug("Saved  facility  "+facility);
			facService.saveAndFlush(facility);
			log.debug("Saved  facility  "+facility.getId());
		}
		
		if(foodProcesorInfo != null ) {
			foddprocessor.saveAndFlush(foodProcesorInfo);
			facility.setFoodProcesssorId(foodProcesorInfo.getId());
			log.debug("Saved  foodProcesorInfo  "+foodProcesorInfo);

		}
		else {
			log.debug("modifyFacility foodProcesorInfo is null ");
		}
		
		//TODO Change the  fac_status column
		if(fclass != null) {
			
			fclass.setFacId(facility.getId());
			//fclass.setFacClass( facility.getFacType());
			fclass.setFacStatus( facility.getFacilityStatus());
			fclass.setClUserid(user.getName());
			fclass.setClEntrytm( new Date());
			
			fclassServcie.saveAndFlush(fclass);
			log.debug("Saved  fclass  "+fclass);
		}else 
		{
			log.debug("modifyFacility fclass is null ");
		}
		
		
		if(registration !=null ) {
			log.debug("modifying registration -- "+registration);
			registrationService.saveAndFlush(registration);
			log.debug("modified registration -- "+registration);
		}
		
		
		log.debug("Facility Modified Successfully");	
	
		return new ResponseEntity<Facilities>(facility, HttpStatus.OK);
	}
	

	
	@CrossOrigin
	@RequestMapping(value = "/id/{id}",  method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Facilities> getCorp(@PathVariable("id") String id ) throws ParseException{
		
				Facilities  facility =null;
				facility = facService.findById(Integer.valueOf(id));
				//facility = facService.findById(id);
			return new ResponseEntity<Facilities>(facility, HttpStatus.OK);
	    }
	
	
	@CrossOrigin
	@RequestMapping(value = "/detail/id/{id}" ,  method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<FacilitiesReg> getFacilityDetail(@PathVariable("id") String id ) throws ParseException{
		
				log.debug("getFacilityDetail "+id);
				FacilitiesReg  facilitiesReg = new FacilitiesReg();
				Facilities facilities = facService.findById(Integer.valueOf(id));
				if(facilities != null ) {
					
					Fclass fclass = fclassServcie.getByFacId(facilities.getId());
					if(fclass != null) {
						
						//facilitiesReg.setFclass(fclass);
						Registration registration = registrationService.findByClassId(fclass.getClassId());
						facilitiesReg.setRegistration(registration);
						
					}
					FoodProcesorInfo  foodProcesorInfo = foddprocessor.findById(facilities.getFoodProcesssorId());
					Corporation corp = corpService.findById(Integer.valueOf(facilities.getCorporationId()));
					facilitiesReg.setFacilities(facilities);
					facilitiesReg.setCorp(corp);
					facilitiesReg.setFoodProcesorInfo(foodProcesorInfo);
					facilitiesReg.setFclass(fclass);
					//facility = facService.findById(id);
				}
				
			log.debug("getFacilityDetail ---> "+facilitiesReg);
				
			return new ResponseEntity<FacilitiesReg>(facilitiesReg, HttpStatus.OK);
			
	    }
	
	
	/***************************************************  Renewals 
	 * @throws IOException 
	 * @throws InvalidFormatException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws DocumentException ************************/
	@CrossOrigin
	@GetMapping(value = "/renewals/generate1stnotices", params = {"category", "startRange", "endRange"},  produces=MediaType.APPLICATION_PDF_VALUE)
    public @ResponseBody String generateFirstNotices(
    		@RequestParam("category") String category,
    		@RequestParam("startRange") String startRange,
    		@RequestParam("endRange" ) String endRange ,
    		Principal user
    		) throws ParseException, InvalidFormatException, IOException, IllegalAccessException, InvocationTargetException, DocumentException{
		
		SimpleDateFormat sdfio = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate =sdfio.parse(startRange);
		Date endDate =sdfio.parse(endRange);		
		log.debug("Parsed date - StartRange"+startDate);
		log.debug("Parsed date - EndRange"+endDate);
	
		log.debug("Processing Request generateNotices "+category  + "StartRange  " +startRange+"EndRange "+endRange);
		
		List<RenewalsfoodDetails>  renewalDetails  =  renewalsFooddetailServcie.findByCatShortAndDexporissBetweenOrderByCorpNameAsc(category, startDate, endDate);
		
		log.debug("Processing Request generateFirstNotices renewalDetails"+renewalDetails);
		List<Renewalsfood>  renewalsFood=new ArrayList<Renewalsfood>(); 
		
		
		for(RenewalsfoodDetails  renewalsfoodDetails : renewalDetails) {
				RenewalCompId renewalCompId = new RenewalCompId(renewalsfoodDetails.getPrkey(), startDate, endDate);
				Renewalsfood renewalsfood =  copyfromRenwalsDetails(renewalsfoodDetails);
				renewalsfood.setRenewalCompId(renewalCompId);
				renewalsfood.setRun1st(new Date());
				renewalsfood.setRunby1st(user.getName());
				renewalsfood.setRun2nd(null);
				renewalsfood.setRunby2nd(null);
				log.debug("renewalsfood --"+renewalsfood);
				renewalsFoodServcie.saveAndFlush(renewalsfood);
		}
		log.debug("Processing Request generateFirstNotices renewalsFood"+renewalsFood);
		
		if(renewalDetails.size() > 0)
			wordFileGenerator.createRenewals(renewalDetails);
		log.debug("Processing Request generateFirstNotices wordFileGenerator.createRenewals completed");
		
		//return "/fppweb"+File.separator+WordFileGenerator.OUTPUT_RENEWAL_FILE;
		return "/fppweb"+File.separator+WordFileGenerator.OUTPUT_RENEWAL_PDF_FILE;
		
	}
	
	
	@CrossOrigin
	@GetMapping(value = "/renewals/generate1stnotice", params = {"facid"},  produces=MediaType.APPLICATION_PDF_VALUE)
    public @ResponseBody String generateFirstNotices(
    		@RequestParam("facid") String facid,
    		Principal user
    		) throws ParseException, InvalidFormatException, IOException, IllegalAccessException, InvocationTargetException, DocumentException{
		
	
		log.debug("Processing Request generateNotice for facid "+facid);
		
		RenewalsfoodDetails  renewalDetails  =  renewalsFooddetailServcie.findByPrkey(Integer.valueOf(facid));
		
		log.debug("Processing Request generateFirstNotice renewalDetails"+renewalDetails);
		List<Renewalsfood>  renewalsFood=new ArrayList<Renewalsfood>(); 
		
		

			wordFileGenerator.createRenewal(renewalDetails);
		log.debug("Processing Request generateFirstNotice wordFileGenerator.createRenewal completed");
		
		//return "/fppweb"+File.separator+WordFileGenerator.OUTPUT_RENEWAL_FILE;
		return "/fppweb"+File.separator+WordFileGenerator.OUTPUT_RENEWAL_PDF_FILE;
		
	}
	
	
	public Renewalsfood copyfromRenwalsDetails(RenewalsfoodDetails   rewalsDetails) throws ParseException {
		
		Renewalsfood  renewals= new Renewalsfood();
		DateFormat  sdf = new SimpleDateFormat("YYYY-MM-DD");
		Date  firstRunDate = null;
		Date  secondtRunDate = null;
		if (rewalsDetails.getRun1st() != null)
			firstRunDate = sdf.parse(rewalsDetails.getRun1st());
		
		if (rewalsDetails.getRun2nd() != null)
			secondtRunDate = sdf.parse(rewalsDetails.getRun1st());
		
		renewals.setRenewalCompId(new RenewalCompId(rewalsDetails.getPrkey(),  rewalsDetails.getDstart(), rewalsDetails.getDend()  )   );
		renewals.setBusAdd1(rewalsDetails.getBusAdd1());
		renewals.setBusAdd2(rewalsDetails.getBusAdd2());
		renewals.setBusCity(rewalsDetails.getBusCity());
		renewals.setBusZip(rewalsDetails.getBusZip());
		renewals.setBusState(rewalsDetails.getBusState());
		renewals.setCatName(rewalsDetails.getCatName());
		renewals.setCatShort(rewalsDetails.getCatShort());
		renewals.setContact(rewalsDetails.getContact());
		renewals.setCatTitle(rewalsDetails.getCatTitle());
		renewals.setCorpName(rewalsDetails.getCorpName());
		renewals.setRun1st(firstRunDate);
		renewals.setRun2nd(secondtRunDate);
		renewals.setDexporiss(rewalsDetails.getDexporiss());
		renewals.setDphCertno(rewalsDetails.getDphCertno());
		renewals.setFacilityName(rewalsDetails.getFacilityName());
		renewals.setInstr(rewalsDetails.getInstr());
		renewals.setMailAdd1(rewalsDetails.getMailAdd1());
		renewals.setMailAdd2(rewalsDetails.getMailAdd2());
		renewals.setMailCity(rewalsDetails.getMailCity());
		renewals.setMailstate(rewalsDetails.getMailState());
		renewals.setMailZip(rewalsDetails.getMailZip());
		renewals.setFee(rewalsDetails.getFee());
		renewals.setPhone(rewalsDetails.getPhone());
		renewals.setRun3rd(null);
		renewals.setRunby1st(rewalsDetails.getRunby1st());
		renewals.setRunby2nd(rewalsDetails.getRunby2nd());
		renewals.setRunby3rd(null);
		renewals.setSsn(rewalsDetails.getSsn());
	return renewals;
	
}
	

	@CrossOrigin
	@GetMapping(value = "/renewals/generate2ndnotices", params = {"category", "startRange", "endRange"},  produces=MediaType.APPLICATION_PDF_VALUE)
    public @ResponseBody String generateSecondNotices(
    		@RequestParam("category") String category,
    		@RequestParam("startRange") String startRange,
    		@RequestParam("endRange") String endRange, 
    	//	@RequestParam("run1stdate") String run1stdate, 
    		Principal user
    		) throws Exception{
		
		SimpleDateFormat sdfio = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate =sdfio.parse(startRange);
		Date endDate =sdfio.parse(endRange);
	//	Date run1stDate =sdfio.parse(run1stdate);
		log.debug("Parsed date - StartRange"+startDate);
		log.debug("Parsed date - EndRange"+endDate);
	//	log.debug("Parsed date - EndRange"+run1stDate);
	
		log.debug("Processing Request generateSecondNotices "+category  + "StartRange  " +startRange+"EndRange "+endRange);
		
		List<RenewalsfoodDetails>  renewalDetails=  renewalsFooddetailServcie.findByCatShortAndDexporissBetweenOrderByCorpNameAsc(category, startDate, endDate);
		
		log.debug("Processing Request generateSecondNotices renewalDetails"+renewalDetails);
		
		for(RenewalsfoodDetails  renewalsfoodDetails : renewalDetails) {
			//Renewalsfood renewalsfood = renewalsFoodServcie.findByPrkey(renewalsfoodDetails.getPrkey());
			RenewalCompId  compId = new RenewalCompId(renewalsfoodDetails.getPrkey(), startDate, endDate);
			Renewalsfood renewalsfood = renewalsFoodServcie.findByRenewalCompId(compId);
			if(renewalsfood != null) {
				renewalsfood.setRun2nd(new Date());
				renewalsfood.setRunby2nd(user.getName());
				log.debug("generateSecondNotices renewalsfood --"+renewalsfood);
				renewalsFoodServcie.saveAndFlush(renewalsfood);
			}
			else {
				log.error(compId + " Renewals Details not found for : "+renewalsfoodDetails.getPrkey() );
				//throw new Exception("Renewals Details not found for : "+renewalsfoodDetails.getPrkey());
			}
		}
		wordFileGenerator.createRenewals(renewalDetails);
		log.debug("Processing Request generateSecondNotices wordFileGenerator.createRenewals  completed");
		
		//return "/fppweb"+File.separator+WordFileGenerator.OUTPUT_RENEWAL_FILE;
		return "/fppweb"+File.separator+WordFileGenerator.OUTPUT_RENEWAL_PDF_FILE;

		
	}
	
	
	@CrossOrigin
	@RequestMapping(value = "/renewals/daterange", params = {"category", "startRange", "endRange"}, method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<RenewalsfoodDetails>> getFacilitiesExpiringForCategoryAndDateRange(
    		@RequestParam("category") String category,
    		@RequestParam("startRange") String startRange,
    		@RequestParam("endRange") String endRange
    		) throws ParseException{
	
		log.debug("Processing Request getRenewalsForCategforyAndDateRange "+category  + "startRange  " +startRange+"endRange "+endRange);
		SimpleDateFormat sdfio = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate =sdfio.parse(startRange);
		Date endDate =sdfio.parse(endRange);		
		log.debug("Parsed date - StartRange"+startDate);
		log.debug("Parsed date - EndRange"+endDate);
		List<RenewalsfoodDetails> renewals =  renewalsFooddetailServcie.findByCatShortAndDexporissBetweenOrderByCorpNameAsc(category, startDate, endDate);
		log.debug("getFacilitiesExpiringForCategoryAndDateRange "+renewals);
	return new ResponseEntity<List<RenewalsfoodDetails>>(renewals, HttpStatus.OK);
		
	}
	
	
	@CrossOrigin
	@RequestMapping(value = "/renewals/all", params = {"category"}, method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<RenewalsView>> getAllRenewalsForCategory(
    			@RequestParam("category") String category) throws ParseException{
	
		log.debug("Processing Request FppRenewalsCursor"+category);
		
		//List<RenewalsView>  renewals = renewalsViewServcie.findTop48ByCatShortOrderByDendDesc(category);
		List<RenewalsView>  renewals = renewalsViewServcie.findByCatShort(category);
		List<Renewalsfood>  renewalsFoodList = renewalsFoodServcie.findByCatShortOrderByRenewalCompId(category);
		//log.debug("renewalsFoodList "+renewalsFoodList);
		renewals = finCountsForRenwals(renewalsFoodList);
		
		log.debug("Processing Request FppRenewalsCursor  after"+renewals);
		
	return new ResponseEntity<List<RenewalsView>>(renewals, HttpStatus.OK);
		
	}
/*	
	public List<RenewalsView>  finCountsForRenwals(List<Renewalsfood>  renewalsFoodList) {
		
		log.debug("Streaming for group by functions ");
		List<RenewalsView>  renewalsDataList = new ArrayList<RenewalsView>();
		Map<String, Map<Renewalsfood, List>> map = renewalsFoodList.stream()
				  .collect(groupingBy(Renewalsfood::getRenewalCompId));
		Map<RenewalCompId, List<Renewalsfood>> renewalsMap = renewalsFoodList.stream().collect(Collectors.groupingBy(Renewalsfood::getRenewalCompId));
		
		for (RenewalCompId renewalCompId :   renewalsMap.keySet()) {
			log.debug("Processing for this id "+renewalCompId);
			for(renewalsMap.get(renewalCompId)){
				
			}
		}
		Iterator<String> keySetIterator = renewalsMap.keySet().iterator();
		while (keySetIterator.hasNext()) {
			RenewalCompId renewalCompId  = keySetIterator.next();
			List<Renewalsfood> renwalsFoodList = renewalsMap.get(renewalCompId);
			RenewalsView renewalsView = new RenewalsView();
			renewalsView.setDend(renewalsView.getDend());
			renewalsView.setDstart(renewalsView.getDstart());
			for(Renewalsfood renewalsfood : renwalsFoodList){
				renewalsView.setCatShort(renewalsfood.getCatShort());
				renewalsView.set
				
			}
			
			renewalsDataList.add(renewalsView);
			
		}
		
		//renewalsMap.forEach(RenewalCompId key,  List<Renewalsfood>  list) ->  System.out.println("Streaming combinations "+RenewalCompId +" -> "+list);
		//renewalsMap.entrySet().stream().forEach(e -> e.getValue().stream().collect(Collectors.su));
		//renewalsMap.forEach((RenewalCompId compId,  List<Renewalsfood>  list) ->  list.stream().);
		
	} */
	
	public List<RenewalsView>  finCountsForRenwals(List<Renewalsfood>  renewalsFoodList) {
		
		List<RenewalsView>  renewalsDataList = new ArrayList<RenewalsView>();
		
		String catShort = null ;
		Date dstart = new Date();
		Date dend = new Date();
		int totalsent = 0;
		int secondsent = 0;
		String whoSent = "";
		String whoSecondSent = "";
		Date runDate = new Date();
		Date runSecondDate = new Date();
		
		RenewalsView renewalsView = new  RenewalsView();
		for(Renewalsfood renewalsfood : renewalsFoodList ){
			//log.debug(" renewalsfood  aggregaton" +renewalsfood);
			
			Date newDstart= renewalsfood.getRenewalCompId().getDstart();
			Date newDend= renewalsfood.getRenewalCompId().getDend();
			
			//log.debug("dstart " +dstart+" newDstart "+newDstart+" dend "+dend+" newDend "+newDend);
			//log.debug("dstart != newDstart "+dstart.equals(newDstart));
			//log.debug("dstart != newDstart "+dend.equals(newDend));
			if( !dstart.equals(newDstart) || ! dend.equals(newDend) ) {
				
				//log.debug("New Date fodun created an object");
				dstart=newDstart;
				dend=newDend;
				totalsent =0;
				secondsent=0;
				
				renewalsView = new  RenewalsView();
				renewalsView.setCatShort(renewalsfood.getCatShort());
				renewalsView.setDstart(newDstart);
				renewalsView.setDend(newDend);
	
				if(renewalsfood.getRun1st() != null) {
					//log.debug("Incremmeenting the 1st run");
					totalsent++;
					renewalsView.setWhosent1(renewalsfood.getRunby1st());
					renewalsView.setRun1st(renewalsfood.getRun1st());
					renewalsView.setTotalsent(totalsent);
				}
				if(renewalsfood.getRun2nd() != null) {
					//log.debug("Incremmeenting the 2 nd run");
					secondsent++;
					renewalsView.setWhosent2(renewalsfood.getRunby2nd());
					renewalsView.setRun2nd(renewalsfood.getRun2nd());
					renewalsView.setSecondsent(secondsent);
				}
				renewalsDataList.add(renewalsView);
				
			}
			else {
				//log.debug("Same dates incremneting ");
				dstart=newDstart;
				dend=newDend;
				if(renewalsfood.getRun1st() != null) {
					//log.debug("Just Incremmeenting the 1st run");
					totalsent++;
					renewalsView.setWhosent1(renewalsfood.getRunby1st());
					renewalsView.setRun1st(renewalsfood.getRun1st());
					renewalsView.setTotalsent(totalsent);
				}
				if(renewalsfood.getRun2nd() != null) {
					//log.debug("Just Incremmeenting the 2 nd run");
					secondsent++;
					renewalsView.setWhosent2(renewalsfood.getRunby2nd());
					renewalsView.setRun2nd(renewalsfood.getRun2nd());
					renewalsView.setSecondsent(secondsent);
				}
				//log.debug(" renewalsDataList  after uptin  "+renewalsDataList);
			}
			
			
		}
		//log.debug("renewalsAggreagete DataList  "+renewalsDataList);
		if(renewalsDataList.size() > 0)
			renewalsDataList.remove(0);
		
		Collections.reverse(renewalsDataList);
		return renewalsDataList;
		
	}
	
	
	@CrossOrigin
	@RequestMapping(value = "/reports/expirefaclist",  params = {"startDate", "endRange", "catName"}, method = RequestMethod.POST, produces = "application/vnd.ms-excel")
	public @ResponseBody String getExpiredFacilities( @RequestParam("startDate") String startDate, @RequestParam("endRange") String endRange,  @RequestParam("catName") List<String> catName, HttpServletRequest request) throws ParseException, IOException{

		log.debug("Processing Request getAllExpiredFacilities  getContextPath -- "+request.getContextPath());
		System.out.println("*******List******* "+catName);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//SimpleDateFormat sdfio = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat sdfio = new SimpleDateFormat("yyyy-MM-dd");

		log.debug("catName" +catName+"startDate "+startDate+" endDate "+endRange);
		List<ExpiredFacList> expiredFacList =new ArrayList<ExpiredFacList>();
		Map<String,List<ExpiredFacList>> map=new HashMap<String,List<ExpiredFacList>>();
		for(int i=0;i<catName.size();i++) {
			expiredFacList = expiredFacListService.getExpiredFacilitesListByDateRangeAndCategoryName(startDate, endRange, catName.get(i));
			map.put(catName.get(i), expiredFacList);
			System.out.println("***************"+catName.get(i)+"********** :"+expiredFacList.size());
		}
		log.debug("Processing Request getAllExpiredFacilities  after");
		excelFileGenerator.createExpiredFacilitiesReportXlsxSheet(map);

		return "/fppweb"+File.separator+"ExpiredFacilitiesReport.xlsx";
	}

	@CrossOrigin
	@GetMapping(value = "/reports/activefaclist",  params = {"acctname"},  produces = "application/vnd.ms-excel")
    public @ResponseBody String getActiveFacilities( @RequestParam("acctname") List<String> categoryName) throws ParseException, IOException{
	
		log.debug("Processing Request getActiveFacilities");
		System.out.println("Categories : "+categoryName);
		List<ExpiredFacList>  activeFacList = new ArrayList<ExpiredFacList>();
		Map<String,List<ExpiredFacList>> map = new HashMap<String,List<ExpiredFacList>>();
		
		for(int i=0;i<categoryName.size();i++) {
			activeFacList = expiredFacListService.getActiveFacilitesList(categoryName.get(i));
			map.put(categoryName.get(i), activeFacList);
			log.debug(activeFacList);
			log.debug("*******List size*******"+activeFacList.size());	
		}
		log.debug("Processing Request getActiveFacilities  after");
		excelFileGenerator.createActiveFacilitiesReportXlsxSheet(map);
		
		return "/fppweb"+File.separator+"ActiveFacilitiesReport.xlsx";
    }
	
	
	@CrossOrigin
	@RequestMapping(value = "/reports/expiredregistration",  params = {"acctName", "startDate"}, method = RequestMethod.POST, produces = "application/vnd.ms-excel")
    public @ResponseBody String getExpiredRegistration( @RequestParam("acctName") String []acctnames,  @RequestParam("startDate") String startdate) throws ParseException, IOException{
	
		log.debug("Processing Request getExpiredRegistration");
		System.out.println("Categories: "+acctnames);
		
		List<ExpiredFacList>  expiredRegistration = new ArrayList<ExpiredFacList>();
		Map<String,List<ExpiredFacList>> map= new HashMap<String,List<ExpiredFacList>>();
		
		for(int i=0;i<acctnames.length;i++) {
			expiredRegistration = expiredFacListService.getExpiredRegistrationDetail(acctnames[i], startdate);
			map.put(acctnames[i], expiredRegistration);
		}
		log.debug("Processing Request getExpiredRegistration  after");
		excelFileGenerator.createEpiredRegistrationXlsxSheet(map,startdate);
		
		return "/fppweb"+File.separator+"ExpiredRegistrationReport.xlsx";
    }
	
	@CrossOrigin
	//@GetMapping(value = "/print/license",  params = {"acctname", "orderBy"}, produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@GetMapping(value = "/print/licenses",  params = {"acctname", "orderBy", "filenameprefix"}, produces=MediaType.APPLICATION_PDF_VALUE)
    public @ResponseBody String printLicenses( @RequestParam("acctname") String acctname, @RequestParam("orderBy") String orderBy, @RequestParam("filenameprefix") String filenameprefix) throws Exception{
		List<PrintCertificate> certificates = null;
		log.debug("Processing Request printLicenses  acctname="+acctname +" orderBy="+orderBy+" filenameprefix "+filenameprefix);
		if("Completion Time".equals(orderBy)) 
			certificates = printCertificateService.findByCatNameOrderByDateExpire(acctname);
		else 
			certificates = printCertificateService.findByCatNameOrderByFacName(acctname);
		
		log.debug("Processing Request printLicenses  certificates  -->  "+certificates);
		wordFileGenerator.createCertificates(certificates, filenameprefix);
		
		//TODO Update print flag
        for (PrintCertificate printCertificate : certificates) {
        	//printCertificate
        	Transaction  trans=  transactionService.findOne(printCertificate.getId());
        	trans.setPrinted("1");
        	trans.setPrintTm(new Date(System.currentTimeMillis()));
        	transactionService.saveAndFlush(trans);
        }
		
		return "/fppweb"+File.separator+filenameprefix+WordFileGenerator.OUTPUT_PERMIT_PDF_FILE;
    }
	
	@CrossOrigin
	//@GetMapping(value = "/print/license",  params = {"acctname", "orderBy"}, produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@GetMapping(value = "/print/license",  params = {"facId"}, produces=MediaType.APPLICATION_PDF_VALUE)
    public @ResponseBody String printLicense( @RequestParam("facId") String facId, HttpServletResponse response) throws Exception{
		
		log.debug("Processing Request for ondividual printLicense  facId="+facId );
		PrintCertificate certificates =  printCertificateService.findByFacId(Integer.valueOf(facId));
				log.debug("Processing Request printLicense  certificate  -->  "+certificates);
		
		if(certificates !=null) {
			wordFileGenerator.createCertificate(certificates);		
			return "/fppweb"+File.separator+WordFileGenerator.OUTPUT_PERMIT_PDF_FILE;
		}
		else {
			response.setStatus( HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
		
    }
	
	
	@CrossOrigin
	@RequestMapping(value = "/reports/printRecord",method = RequestMethod.POST, produces = "application/vnd.ms-excel")
	public @ResponseBody String printRecord(@RequestBody FacilitiesReg facilitiesReg) throws ParseException, IOException{
		log.debug("****************FacilitiesReg -->  "+facilitiesReg);
		Facilities facility = facilitiesReg.getFacilities();
		FoodProcesorInfo foodProcesorInfo = facilitiesReg.getFoodProcesorInfo();
		Registration registration = facilitiesReg.getRegistration();
		System.out.println("****************************registration : "+registration);
		Corporation corp = facilitiesReg.getCorp();
		Fclass  fclass = facilitiesReg.getFclass();
		List<Transaction> transactions= facilitiesReg.getTransactions();
		System.out.println("****************8Transactions : "+transactions);
		excelFileGenerator.createReportForFacilitiesRegView(facility, foodProcesorInfo, registration, corp, fclass,transactions);        
		return "/fppweb"+File.separator+"FacilitiesReport.xlsx";
	}
	
}
