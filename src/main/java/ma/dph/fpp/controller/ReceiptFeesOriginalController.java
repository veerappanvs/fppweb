package ma.dph.fpp.controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ma.dph.fpp.domain.generallicensing.FiscalReport;
import ma.dph.fpp.domain.generallicensing.RctFeeReport;
import ma.dph.fpp.domain.generallicensing.ReceiptOfFeesRevised;
import ma.dph.fpp.domain.generallicensing.TransmittalReport;
import ma.dph.fpp.repository.FiscalReportRepository;
import ma.dph.fpp.repository.RctFeeReportRepository;
import ma.dph.fpp.repository.ReceiptOfFeesRepositoryRevised;
import ma.dph.fpp.repository.TransmittalReportRepository;
import ma.dph.fpp.util.ExcelFileGenerator;

@RestController
@RequestMapping(path = "/api/gl/receiptoffees") 
public class ReceiptFeesOriginalController {

	static Logger log = Logger.getLogger(ReceiptFeesOriginalController.class.getName());
	

	@Autowired
	private ReceiptOfFeesRepositoryRevised service;
	
	@Autowired
	private FiscalReportRepository fiscalReportService;
	
	@Autowired
	private RctFeeReportRepository rctFeeReportRepository;
	
	@Autowired
	private TransmittalReportRepository trasnmittalReportRepository;
	
	@Autowired
	private ExcelFileGenerator   excelFileGenerator;
	
	 @Autowired
	 private EntityManager entityManager;
	
	@CrossOrigin
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<ReceiptOfFeesRevised> getReceiptOfFeesById(@PathVariable("id") String id)  {
		
		log.debug("getReceiptOfFeesById "+id);
		ReceiptOfFeesRevised receipt =null;
		receipt= service.findById(Integer.valueOf(id));
		
		return new ResponseEntity<ReceiptOfFeesRevised>(receipt, HttpStatus.OK);
		
    }
	
	
	@CrossOrigin
	@RequestMapping(value = "/get/all", params = {"batchNumber", "accountNumber", "receiptFeeDate"}, method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<ReceiptOfFeesRevised>> getReceiptOfFeesByMultipleParameter(
    		@RequestParam("batchNumber") String batchNumber,
    		@RequestParam("accountNumber") String accountNumber,
    		@RequestParam("receiptFeeDate") String receiptFeeDate
    		) throws ParseException {
		
		
		// Set the date and time -- Thu Mar 01 2018 00:00:00 GMT-0500
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdfio = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		
		if("null".equalsIgnoreCase(batchNumber) || "undefined".equalsIgnoreCase(batchNumber)) batchNumber =null;
		if("null".equalsIgnoreCase(accountNumber)|| "undefined".equalsIgnoreCase(accountNumber)) accountNumber =null;
		if("null".equalsIgnoreCase(receiptFeeDate)|| "NaN-NaN-NaN".equalsIgnoreCase(receiptFeeDate)) receiptFeeDate =null;
		
		log.debug("getReceiptOfFeesByMultipleParameter batchNumber="+batchNumber+"---accountNumber :"+accountNumber+"receipt fee date : "+receiptFeeDate);
		
		//DateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
		//Date receiptOfFeesDate =  dateFormatter.parse(receiptFeeDate);
		//log.info("receiptOfFeesDate   :  " +receiptFeeDate);
		List<ReceiptOfFeesRevised> receipts = null;
		//abc
		if( (batchNumber!= null && batchNumber.trim().length()>0 && accountNumber !=null && accountNumber.trim().length()>0 && receiptFeeDate != null  && receiptFeeDate.trim().length()>0 )) {
			date=sdfio.parse(receiptFeeDate);
			log.debug("receiptFeeDate date "+receiptFeeDate); 
			log.debug("Parsed date "+date);
			log.debug("Parsed date "+sdf.parse(sdf.format(date)));
			receipts= service.findByBatchNumberContainingAndAccountNumberIgnoreCaseContainingAndReceiptFeeDate(batchNumber, accountNumber, sdf.parse(sdf.format(date)));
			log.info("All has value " + "---"+receipts   +"  receipts  count "+receipts.size());
		}
		//bc
		else if((batchNumber == null || batchNumber.trim().length() ==0 ) && accountNumber !=null && (receiptFeeDate != null && receiptFeeDate.trim().length()>0)) {
			date=sdfio.parse(receiptFeeDate);
			receipts= service.findByAccountNumberIgnoreCaseContainingAndReceiptFeeDate(accountNumber, sdf.parse(sdf.format(date)));
			log.info("applicantName is empty " + "---"+receipts   +"  receipts  count "+receipts.size());
		}//ac
		 else  if(batchNumber != null && batchNumber.trim().length()>0 && ( accountNumber == null || accountNumber.trim().length()==0 )&& receiptFeeDate != null && receiptFeeDate.trim().length()>0) {
			date=sdfio.parse(receiptFeeDate);
			receipts= service.findByBatchNumberContainingAndReceiptFeeDate(batchNumber, sdf.parse(sdf.format(date)));
			log.info("accountNumber is empty " + "---"+receipts   +"  receipts  count "+receipts.size());
		}//ab
		 else if(batchNumber != null && batchNumber.trim().length()>0 && accountNumber !=null &&  accountNumber.trim().length()>0 && (receiptFeeDate == null || receiptFeeDate.trim().length() ==0)) {
			receipts= service.findByBatchNumberContainingAndAccountNumberIgnoreCaseContaining(batchNumber, accountNumber);
			log.info("receiptFeeDate is empty " + "---"+receipts   +"  receipts  count "+receipts.size());
		}//a
		 else if(batchNumber != null && batchNumber.trim().length()>0 && ( accountNumber == null || accountNumber.trim().length()==0 ) && (receiptFeeDate == null || receiptFeeDate.trim().length() ==0)) {
			
			 receipts= service.findByBatchNumberContaining(batchNumber);
			 log.info("Just batch number " + "---"+receipts   +"  receipts  count "+receipts.size());
			
		}//c 
		 else if((batchNumber == null || batchNumber.trim().length()==0) && ( accountNumber == null || accountNumber.trim().length()==0 ) && (receiptFeeDate != null  && receiptFeeDate.trim().length() > 0)) {
			 date=sdfio.parse(receiptFeeDate);
			 receipts= service.findByReceiptFeeDate(sdf.parse(sdf.format(date)));
			 log.info("Just the reciept Of fee " + "---"+receipts   +"  receipts  count "+receipts.size());
			
		} 
		 /*if(receiptFeeDate != null  && receiptFeeDate.trim().length() > 0) {
				receipts= service.findByBatchNumberContaining(batchNumber);
				log.info("Just the reciept Of fee " + "---"+receipts   +"  receipts  count "+receipts.size());
			} */
		
		/*else { 
			if(receiptFeeDate != null && receiptFeeDate.trim().length()>0)
			{
				date=sdfio.parse(receiptFeeDate);
				date=sdf.parse(sdf.format(date));
				
			}
			receipts= service.findByApplicantIgnoreCaseContainingOrAccountNumberIgnoreCaseContainingOrReceiptFeeDate(applicantName, accountNumber, date);
			log.info("receiptFeeDate is empty " + "---"+receipts   +"  receipts  count "+receipts.size());
		}
		*/
		return new ResponseEntity<List<ReceiptOfFeesRevised>>(receipts, HttpStatus.OK);
    }

	@CrossOrigin
	@RequestMapping(value = "/check", params = {"applicant", "payer", "checknumber"}, method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<ReceiptOfFeesRevised>> getCheckRegisterResults(
    		@RequestParam("applicant") String applicant,
    		@RequestParam("payer") String payer,
    		@RequestParam("checknumber") String checkNumber
    		) throws ParseException {
		
		log.info("This is the Date value" + "---applicant: "+applicant+"---payer :"+payer+"check number : "+checkNumber);
		if("null".equalsIgnoreCase(applicant) || "undefined".equalsIgnoreCase(applicant)) applicant ="";
		if("null".equalsIgnoreCase(payer)|| "undefined".equalsIgnoreCase(payer)) payer ="";
		if("null".equalsIgnoreCase(checkNumber)|| "undefined".equalsIgnoreCase(checkNumber)) checkNumber ="";
		
		List<ReceiptOfFeesRevised> receipts = null;
		log.debug("Started here ");
		log.debug("Applicant -- "+applicant+" Payer -- "+payer+" check number "+ checkNumber);
		if (!"".equals(applicant) && !"".equals(payer) && !"".equals(checkNumber)) {
			log.debug(("".equals(applicant))+" "+("".equals(payer))+("".equals(checkNumber)));
			log.debug("Entered condition Applicant -- "+applicant+" Payer -- "+payer+" check number "+ checkNumber);
			receipts =  service.findByApplicantIgnoreCaseContainingAndCheckNumberIgnoreCaseContainingAndPayerIgnoreCaseContaining(applicant, checkNumber, payer);
			//receipts = service.findByApplicantIgnoreCaseContainingAndAccountNumberIgnoreCaseContaining("boston","0603");
		} else if (applicant.length() != 0 && payer.length() != 0) {
			log.debug("Applicant -- "+applicant+" Payer -- "+payer);
			receipts = service.findByApplicantIgnoreCaseContainingAndPayerIgnoreCaseContaining(applicant, payer);
		} else if (applicant.length() != 0 && checkNumber.length() != 0) {
			log.debug("Applicant -- "+applicant+" check number "+ checkNumber);
			receipts =  service.findByApplicantIgnoreCaseContainingAndCheckNumberIgnoreCaseContaining(applicant, checkNumber);
		} else if (payer.length() != 0 && checkNumber.length() != 0) {
			log.debug(" Payer -- "+payer+" check number "+ checkNumber);
			receipts = service.findByCheckNumberIgnoreCaseContainingAndPayerIgnoreCaseContaining(checkNumber, payer);
		} else if (applicant.length() != 0) {
			log.debug("Applicant -- "+applicant);
			receipts = service.findByApplicantIgnoreCaseContaining(applicant);
		} else if (checkNumber.length() != 0) {
			log.debug("Check Number -- "+checkNumber);
			receipts = service.findByCheckNumberIgnoreCaseContaining(checkNumber);
		} else {
			log.debug(" Payer -- "+payer);
			receipts = service.findByPayerIgnoreCaseContaining(payer);
		}
		log.debug("Check register results "+receipts);
		return new ResponseEntity<List<ReceiptOfFeesRevised>>(receipts, HttpStatus.OK);
    }
	 
	@CrossOrigin
	@PostMapping(value = "/create")
	public  ResponseEntity<?> createReceiptOfFees(@RequestBody ReceiptOfFeesRevised receiptOfFeesRevised, Principal user) {
		log.info(" receiptOfFeesRevised   ===>"+receiptOfFeesRevised);
		receiptOfFeesRevised.setCreatedtime(new Date());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdfio = new SimpleDateFormat("MM/dd/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		/*Date date = receiptOfFeesRevised.getReceiptFeeDate();

		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(date.getTime());
			Date receiptOfFeesDate =  calendar.getTime();
			receiptOfFeesRevised.setReceiptFeeDate(receiptOfFeesDate);
			log.info(" receiptOfFeesDate   ===>"+receiptOfFeesDate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//Date receiptOfFeesDate =  sdf.parse(date);
		//receiptOfFeesRevised.setRunBy(user.getName());
		receiptOfFeesRevised.setDateReceived(new Date());
		receiptOfFeesRevised.setOpenedBy(user.getName());
		service.saveAndFlush(receiptOfFeesRevised);
		log.info(" receiptOfFees   ===> with ID "+receiptOfFeesRevised.getId());
		return new ResponseEntity<ReceiptOfFeesRevised>(receiptOfFeesRevised, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@PutMapping(value = "/modify")
	public  ResponseEntity<?> modifyReceiptOfFees(@RequestBody ReceiptOfFeesRevised receiptOfFeesRevised, Principal user) {
		log.info(" receiptOfFeesRevised   ===>"+receiptOfFeesRevised);
		//receiptOfFees.setBatchNumber("000121210");
		//receiptOfFees.setId(1);
	
		  if ( service.findById(receiptOfFeesRevised.getId()) == null  ) {
			  	log.info("Unable to update Reciept of Fee "+ receiptOfFeesRevised.getId()+" not found.");
	            return new ResponseEntity<String>(("Unable to update Reciept of Fee .  "+ receiptOfFeesRevised.getId() +" not found."),HttpStatus.CONFLICT);
		  }
		  else {
			    receiptOfFeesRevised.setTransmittalDate(new Date());
			    receiptOfFeesRevised.setStatusUpdate(new Date());
				receiptOfFeesRevised.setModifiedtime(new Date());
				receiptOfFeesRevised.setModifiedby(user.getName());
			   service.saveAndFlush(receiptOfFeesRevised);
				log.info(" receiptOfFees   ===> with ID "+receiptOfFeesRevised.getId());
				return new ResponseEntity<ReceiptOfFeesRevised>(receiptOfFeesRevised, HttpStatus.CREATED);
		  }
	}
	
	
    @CrossOrigin
    @DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> deleteReceipt(@PathVariable("id") String id) {
    	
    	log.info("Deleteing receipt batchNumber " + "---"+id);
    	ReceiptOfFeesRevised receiptOfFeesRevised = service.findById(Integer.valueOf(id));
    	if(receiptOfFeesRevised == null )
    		return new ResponseEntity<String>("Unable to find the batchNumber", HttpStatus.CONFLICT);
    	service.delete(Integer.valueOf(id));
    	HttpHeaders headers = new HttpHeaders();
    	return new ResponseEntity<String>(headers, HttpStatus.OK);
	}
    
    
    

	@CrossOrigin
	@GetMapping(value = "/get/all", params = {"appfacid"}, produces = "application/json")
    public ResponseEntity<List<ReceiptOfFeesRevised>> getReceiptOfFeesByFacility(
    		@RequestParam("appfacid") String appfacid
    		) throws ParseException {
		
		List<ReceiptOfFeesRevised> receipts= service.findByAppfacid(appfacid);
			 log.info("Just the reciept Of fee " + "---"+receipts   +"  receipts  count "+receipts.size());
			
		return new ResponseEntity<List<ReceiptOfFeesRevised>>(receipts, HttpStatus.OK);
    }

    
    
    
    
    
   /* @CrossOrigin
    @RequestMapping(value = "/fiscalreport", params = {"acctname",  "startDate", "endDate"}, method = RequestMethod.POST, produces = "application/vnd.ms-excel")
       public @ResponseBody String  getFiscalReportnative(
       		@RequestParam("acctname") List<String> acctname,
       		@RequestParam("startDate") String startDate,
       		@RequestParam("endDate") String endDate 
       		) throws ParseException, IOException {
       	log.debug("getFiscalReportOnly  fiscalreport native");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//SimpleDateFormat sdfio = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat sdfio = new SimpleDateFormat("yyyy-MM-dd");
		
		log.debug("acctname" +acctname+"startDate "+startDate+" endDate "+endDate);
		Date sdate=sdfio.parse(startDate);
		Date edate=sdfio.parse(endDate);
       	
   		List<FiscalReport> reportData =fiscalReportService.findByNativeQuery(acctname, sdf.parse(sdf.format(sdate)), sdf.parse(sdf.format(edate)));
   		log.debug("fiscalReportService  fiscalreport native reportData"+reportData);
   		log.debug("acctname  after parsing" +acctname+"startDate "+sdate+" endDate "+edate);
   		excelFileGenerator.createFiscalReportPivotXlsxSheet(reportData, acctname, startDate, endDate);
   		
       	return "/fppweb"+File.separator+"FiscalReport.xlsx";
       	
     }*/
    
	
	@CrossOrigin
    @RequestMapping(value = "/fiscalreport", params = {"acctname",  "startDate", "endDate"}, method = RequestMethod.POST, produces = "application/vnd.ms-excel")
       public @ResponseBody String  getFiscalReportnative(
       		@RequestParam("acctname") List<String> acctname,
       		@RequestParam("startDate") String startDate,
       		@RequestParam("endDate") String endDate 
       		) throws ParseException, IOException {
       	log.debug("getFiscalReportOnly  fiscalreport native");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//SimpleDateFormat sdfio = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat sdfio = new SimpleDateFormat("yyyy-MM-dd");
		
		log.debug("acctname" +acctname+"startDate "+startDate+" endDate "+endDate);
		Date sdate=sdfio.parse(startDate);
		Date edate=sdfio.parse(endDate);
		
		YearMonth yearMonthStart =  YearMonth.from(sdate.toInstant()
		                           .atZone(ZoneId.systemDefault())
		                           .toLocalDate());
		
		
		YearMonth yearMonthEnd =  YearMonth.from(edate.toInstant()
		                           .atZone(ZoneId.systemDefault())
		                           .toLocalDate());
		log.debug("yearMonthStart "+yearMonthStart);
		log.debug("yearMonthEnd "+yearMonthEnd);
		log.debug("YearMonth After formatting"+yearMonthStart.format(DateTimeFormatter.ofPattern("MMM yyyy")));
		Map<String,List<FiscalReport>> map=new HashMap<String,List<FiscalReport>>();
		
		for(int i=0;i<acctname.size();i++) {
			
			System.out.println("***************"+acctname.get(i)+"********** :");
			List<FiscalReport> fiscalReportList = fiscalReportService.findByNativeQuery(acctname.get(i), sdf.parse(sdf.format(sdate)), sdf.parse(sdf.format(edate)));
			System.out.println("***************fiscalReportLis********** :"+fiscalReportList);
			map.put(acctname.get(i), fiscalReportList);
			entityManager.clear();
		}
		
   		//excelFileGenerator.createFiscalReportPivotXlsxSheet(map, startDate, endDate);
		excelFileGenerator.createFiscalReportPivotOneSheet(map, startDate, endDate, yearMonthStart, yearMonthEnd);

		return "/fppweb"+File.separator+"FiscalReport.xlsx";
       	
     }
    
    
    @CrossOrigin
    @RequestMapping(value = "/rctfeereport", params = {"batchnum", "accountNumber", "receiptFeeDate"}, method = RequestMethod.POST, produces = "application/vnd.ms-excel")
       public @ResponseBody String  getRctFeeReport(
       		@RequestParam("batchnum") String batchnum,
       		@RequestParam("accountNumber") String accountNumber,
       		@RequestParam("receiptFeeDate") String receiptFeeDate, 
       		HttpServletResponse response
       		) throws ParseException, IOException {
    	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//SimpleDateFormat sdfio = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat sdfio = new SimpleDateFormat("yyyy-MM-dd");
		
		//if()
		Date date=sdfio.parse(receiptFeeDate);
		log.debug("receiptFeeDate date "+receiptFeeDate +"batchnum "+batchnum+"accountNumber "+accountNumber); 
		log.debug("Parsed date "+date);
		log.debug("Parsed date "+sdf.parse(sdf.format(date)));
		
		if(batchnum.length() == 6) {
    		batchnum = "0"+batchnum;
    	} 
		
       	log.debug("getRctFeeReport  batchnum native");
   	
   		//List<ReceiptOfFeesRevised> detailList = service.findByBatchNumberContainingAndAccountNumberIgnoreCaseContainingAndReceiptFeeDate(batchnum, accountNumber, sdf.parse(sdf.format(receiptFeeDate));
   		List<ReceiptOfFeesRevised> detailList = null;
   		List<RctFeeReport> reportDataList = null;
   		if((null != batchnum && batchnum.trim().length()> 0 )  && (null != accountNumber && accountNumber.trim().length()> 0  && !accountNumber.equals("null")) && (null != receiptFeeDate && !receiptFeeDate.equals("1969-12-31")) ) {
   			
   			log.debug("Option 1");
   	   		log.debug("getRctFeeReport  batchnum receipts reportDataList" +reportDataList);
   	 
   			detailList=	service.findByBatchNumberContainingAndAccountNumberIgnoreCaseContainingAndReceiptFeeDate(batchnum, accountNumber, sdf.parse(sdf.format(date)));
   			reportDataList =rctFeeReportRepository.findByNativeQuery(batchnum, accountNumber, date);
   		} 
   		else if( (null != batchnum && batchnum.trim().length()> 0)   && (null != receiptFeeDate && !receiptFeeDate.equals("1969-12-31"))  ) {
   			log.debug("Option 2");
   			detailList = service.findByBatchNumberContainingAndReceiptFeeDate(batchnum, sdf.parse(sdf.format(date)));
   			reportDataList =rctFeeReportRepository.findByNativeQuery(batchnum, date);
   		}
   		else if( (null != batchnum && batchnum.trim().length()> 0) && (null != accountNumber && accountNumber.trim().length()> 0  && !accountNumber.equals("null")) ) {
   			log.debug("Option 3");
   			detailList = service.findByBatchNumberContainingAndReceiptFeeDate(batchnum, sdf.parse(sdf.format(date)));
   			reportDataList =rctFeeReportRepository.findByNativeQuery(batchnum, date);
   		}
   		else {
   			log.debug("Option 4");

   			detailList =  service.findByBatchNumberContaining(batchnum);
   			reportDataList =rctFeeReportRepository.findByNativeQuery(batchnum);
   		} 
   		   			
   		if(null != receiptFeeDate && receiptFeeDate.equals("1969-12-31") && detailList.size() > 0) 
   			receiptFeeDate=sdf.format(detailList.get(0).getReceiptFeeDate());
   		
   		excelFileGenerator.createRctfeeReportXlsxSheet(reportDataList, detailList, batchnum, accountNumber, receiptFeeDate);
   		log.debug("getRctFeeReport  batchnum receipts detailList" +detailList);
   		
       	return "/fppweb"+File.separator+"RctFeeReport.xlsx";
     }
    
	public void updatReceiptOfFeesForTransmittal(String batchNumber, String userName) {
			
			List<ReceiptOfFeesRevised> trasmittaldata = service.findByBatchNumberContaining(batchNumber);
			
			 if (   trasmittaldata == null || trasmittaldata.size() <=0 ) {
				  	log.info("Unable to find records for updating the status by transmittal report ");
			  }
			  else {
				  
				    for (ReceiptOfFeesRevised receiptOfFeesRevised : trasmittaldata) {
				    	receiptOfFeesRevised.setStatus("PROCESSED");
				    	receiptOfFeesRevised.setModifiedtime(new Date());
				    	receiptOfFeesRevised.setModifiedby(userName);
				    }
					
				    service.save(trasmittaldata);
					log.info(" Successfully updated the status for updatReceiptOfFeesForTransmittal   ");
			  }
		}
    
    
    
    public void updatReceiptOfFeesForTransmittal(List<ReceiptOfFeesRevised>  rctFeeList, String userName) {
    			
			log.debug(" Updating staus  updatReceiptOfFeesForTransmittal   "+rctFeeList);

    			if(rctFeeList != null ) {
	    			for(ReceiptOfFeesRevised updateData : rctFeeList) {
	    				if(updateData.getStatus().equalsIgnoreCase("RECEIVED")) {
	    				updateData.setStatus("PROCESSED");
	    				updateData.setModifiedtime(new Date());
	    				updateData.setModifiedby(userName);
	    				updateData.setRunBy(userName);

				    	service.save(updateData);
				    	log.debug(updateData.getAccountName()+" Updating the status for the reciept "+updateData.getId());
	    				}
	    			}
    			  }
    }
    
/*    @CrossOrigin
    @RequestMapping(value = "/transmittalreport", params = {"batchnum" ,"accountNumber", "receiptFeeDate"}, method = RequestMethod.POST, produces = "application/vnd.ms-excel")
       public @ResponseBody String  getTransmittalReport(
       		@RequestParam("batchnum") String batchnum, 
       		@RequestParam("accountNumber") String accountNumber,
       		@RequestParam("receiptFeeDate") String receiptFeeDate,       		
       		Principal user
       		) throws ParseException, IOException {
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//SimpleDateFormat sdfio = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat sdfio = new SimpleDateFormat("yyyy-MM-dd");
		
		//if()
		Date date=sdfio.parse(receiptFeeDate);
		log.debug("receiptFeeDate date "+receiptFeeDate); 
		log.debug("Parsed date "+date);
		log.debug("Parsed date "+sdf.parse(sdf.format(date)));
		
    	
    	if(batchnum.length() == 6) {
    		batchnum = "0"+batchnum;
    	} 
       	log.debug("getRctFeeReport  batchnum native"+batchnum);
       	List<TransmittalReport> receipts = new ArrayList<>();
       	
        if ( (null != batchnum && batchnum.trim().length()> 0)  && accountNumber !=null  && !accountNumber.equals("null")   && (null != receiptFeeDate && !receiptFeeDate.equals("1969-12-31")) ){
			
        	log.debug("option1");
        	List<ReceiptOfFeesRevised> receiptsToUpdate = service.findByBatchNumberContainingAndAccountNumberIgnoreCaseContainingAndReceiptFeeDate(batchnum, accountNumber, date);
			log.debug("getTransmittalReport  batchnum receipts " +receiptsToUpdate);
			
			updatReceiptOfFeesForTransmittal(receiptsToUpdate, user.getName());       	
			receipts =trasnmittalReportRepository.findByNativeQuery( batchnum);
			
		}
        else if (batchnum != null &&     (null != receiptFeeDate && !receiptFeeDate.equals("1969-12-31"))) {
        	log.debug("option2");

        	List<ReceiptOfFeesRevised> receiptsToUpdate = service.findByBatchNumberContainingAndReceiptFeeDate(batchnum, date);
			log.debug("getTransmittalReport  batchnum receipts " +receiptsToUpdate);
			updatReceiptOfFeesForTransmittal(receiptsToUpdate, user.getName());       	
			receipts =trasnmittalReportRepository.findByNativeQueryForbatchAndDate( batchnum, date);
        	
        }
		else if (batchnum != null &&  accountNumber !=null  && !accountNumber.equals("null")){
        	log.debug("option3");

			List<ReceiptOfFeesRevised> receiptsToUpdate = service.findByBatchNumberContainingAndAccountNumberIgnoreCaseContaining(batchnum, accountNumber);
			log.debug("getTransmittalReport  batchnum receipts " +receiptsToUpdate);
			updatReceiptOfFeesForTransmittal(receiptsToUpdate, user.getName());       	
			receipts =trasnmittalReportRepository.findByNativeQuery( batchnum, accountNumber);
			
		}
		else if (batchnum != null  ) {
        	log.debug("option4");

			List<ReceiptOfFeesRevised> receiptsToUpdate = service.findByBatchNumberContaining(batchnum);
			log.debug("getTransmittalReport  batchnum receipts " +receiptsToUpdate);
			updatReceiptOfFeesForTransmittal(receiptsToUpdate, user.getName());        	
			receipts =trasnmittalReportRepository.findByNativeQuery( batchnum);

			log.debug("receipts  "+receipts);
		}
		else {
        	log.debug("option5");

			return null;
		}
   
   		excelFileGenerator.createTrasmittalReportXlsxSheet(receipts);
   		
   		
   		
       	return "/fppweb"+File.separator+"TransmittalReport.xlsx";
     }*/
    
    @CrossOrigin
    @RequestMapping(value = "/transmittalreport", params = {"batchnum" ,"accountNumber", "receiptFeeDate"}, method = RequestMethod.POST, produces = "application/vnd.ms-excel")
       public @ResponseBody String  getTransmittalReport(
       		@RequestParam("batchnum") String batchnum, 
       		@RequestParam("accountNumber") String accountNumber,
       		@RequestParam("receiptFeeDate") String receiptFeeDate,       		
       		Principal user
       		) throws ParseException, IOException {
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//SimpleDateFormat sdfio = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat sdfio = new SimpleDateFormat("yyyy-MM-dd");
		
		//if()
		Date date=sdfio.parse(receiptFeeDate);
		log.debug("receiptFeeDate date "+receiptFeeDate); 
		log.debug("Parsed date "+date);
		log.debug("Parsed date "+sdf.parse(sdf.format(date)));
		
    	
    	if(batchnum.length() == 6) {
    		batchnum = "0"+batchnum;
    	} 
       	log.debug("getRctFeeReport  batchnum native"+batchnum);
       	List<ReceiptOfFeesRevised> receipts = new ArrayList<ReceiptOfFeesRevised>();
       	
        if ( (null != batchnum && batchnum.trim().length()> 0)  && accountNumber !=null  && !accountNumber.equals("null")   && (null != receiptFeeDate && !receiptFeeDate.equals("1969-12-31")) ){
			
        	log.debug("option1");
        	List<ReceiptOfFeesRevised> receiptsToUpdate = service.findByBatchNumberContainingAndAccountNumberIgnoreCaseContainingAndReceiptFeeDate(batchnum, accountNumber, date);
			log.debug("getTransmittalReport  batchnum receipts " +receiptsToUpdate);
			
			updatReceiptOfFeesForTransmittal(receiptsToUpdate, user.getName());       	
			receipts =service.findByBatchNumberContainingOrderByAccountNumber( batchnum);
			
		}
        else if (batchnum != null &&     (null != receiptFeeDate && !receiptFeeDate.equals("1969-12-31"))) {
        	log.debug("option2");

        	List<ReceiptOfFeesRevised> receiptsToUpdate = service.findByBatchNumberContainingAndReceiptFeeDateOrderByAccountName(batchnum, date);
			log.debug("getTransmittalReport  batchnum receipts " +receiptsToUpdate);
			updatReceiptOfFeesForTransmittal(receiptsToUpdate, user.getName());       	
			receipts =service.findByBatchNumberContainingAndReceiptFeeDateOrderByAccountNumber(batchnum, date);
        	
        }
		else if (batchnum != null &&  accountNumber !=null  && !accountNumber.equals("null")){
        	log.debug("option3");

			List<ReceiptOfFeesRevised> receiptsToUpdate = service.findByBatchNumberContainingAndAccountNumberIgnoreCaseContainingOrderByAccountNumber(batchnum, accountNumber);
			log.debug("getTransmittalReport  batchnum receipts " +receiptsToUpdate);
			updatReceiptOfFeesForTransmittal(receiptsToUpdate, user.getName());       	
			receipts =service.findByBatchNumberContainingAndAccountNumberIgnoreCaseContainingOrderByAccountNumber( batchnum, accountNumber);
			
		}
		else if (batchnum != null  ) {
        	log.debug("option4");

			List<ReceiptOfFeesRevised> receiptsToUpdate = service.findByBatchNumberContainingOrderByAccountName(batchnum);
			log.debug("getTransmittalReport  batchnum receipts " +receiptsToUpdate);
			updatReceiptOfFeesForTransmittal(receiptsToUpdate, user.getName());        	
			receipts =service.findByBatchNumberContainingOrderByAccountNumber( batchnum);

			log.debug("receipts  "+receipts);
		}
		else {
        	log.debug("option5");

			return null;
		}
   
   		excelFileGenerator.createTrasmittalReportXlsxSheet(receipts);
   		
   		
   		
       	return "/fppweb"+File.separator+"TransmittalReport.xlsx";
     }
    
    
    

    
}
