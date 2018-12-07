package ma.dph.fpp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

import ma.dph.fpp.domain.generallicensing.BatchNumbers;
import ma.dph.fpp.repository.BatchNumberRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping(path = "/api/gl/batchnumbers") 
public class BatchNumbersController {
	
	static Logger log = Logger.getLogger(BatchNumbersController.class.getName());
	private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
	private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
	private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);

	@Autowired
    private BatchNumberRepository service;

	@CrossOrigin
	@RequestMapping(value = "/print", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<BatchNumbers>> generateBatchNumbers(Principal user) {
		
		log.info("print");
		
	
		//setting date
	
		// This is to get the current time to enter in the time stamp.
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		//	LocalDateTime now = LocalDateTime.now();
		//	LocalDate localDate = LocalDate.now();
	
		// Move this to a different function.
		//BatchNumbers topBatchNumber = service.findTopByOrderByEntrytimeDesc();
		//Generated new batch number =
		//Integer newBatchNumber = Integer.valueOf((service.findTopByOrderByEntrytimeDesc().getBatchNumber()))+1;
		
		//service.saveAndFlush(batch);
		
		for (int i=0 ;i<22;i++) {
			LocalDate localDate = LocalDate.now();
			BatchNumbers batch = new BatchNumbers();
			batch.setCreatedByUser(user.getName());
			batch.setAssingedOn(dateFormatter.format(localDate));
			LocalDateTime now = LocalDateTime.now();
			batch.setEntrytime(dtf.format(now));
			//batch.setBatchNumber(integer.toString());
			service.saveAndFlush(batch);
		}
		//List<BatchNumbers> result = service.findTop22ByBatchNumberDesc();
		List<BatchNumbers> result  = service.findTop22ByOrderByEntrytimeDesc(); 
		java.util.Collections.reverse(result);
		log.info("Successfully created the batch"+result);
		return new ResponseEntity<List<BatchNumbers>>(result, HttpStatus.OK);
	}

	/*@CrossOrigin
	@RequestMapping(value = "/get-existing-numbers", params = {"batchNumber"}, method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Integer>> getExistingBatchNumber(@RequestParam("batchNumber") String batchNumber) {
		System.out.println(batchNumber.substring(0, batchNumber.length()-2));
		BatchNumbers topBatchNumber = service.findByBatchNumberIgnoreCaseContaining(batchNumber.substring(0, batchNumber.length()-2));
		List<Integer> result = getGeneratedBatchList(Integer.valueOf(topBatchNumber.getBatchNumber()), topBatchNumber.getCount());
		return new ResponseEntity<List<Integer>>(result, HttpStatus.OK);
    }*/

	/*private Integer getNewBatchSequenceNumber(String currentHighestBatchNumber) {
		Integer currentTopSequenceNumber = Integer.valueOf(currentHighestBatchNumber);
		Integer newBatchSequenceNumber = (currentTopSequenceNumber)+1;
		return newBatchSequenceNumber;
	}


	private List<Integer> getGeneratedBatchList(Integer currentHighestBatchNumber, String count){
		List<Integer> batchList = new ArrayList<Integer>();
		Integer currentTopSequenceNumber = currentHighestBatchNumber;
		Integer newBatchSequenceNumber = currentTopSequenceNumber*100;
		int iterator = 1;
		
		for (int i=newBatchSequenceNumber+1; iterator <= Integer.valueOf(count);i++) {
			iterator++;
			batchList.add(i);
		}

		return batchList;
	}
*/
/*	private List<Integer> getGeneratedBatchListOLD(Integer currentHighestBatchNumber){
		List<Integer> batchList = new ArrayList<Integer>();
		int iterator = 1;
		Integer newBatchSequenceNumber = currentHighestBatchNumber + 1;
		for (int i=newBatchSequenceNumber; i <=22;i++) {
			batchList.add(i);
			iterator++;
		}
		return batchList;
	}*/

	//http://146.243.82.248:8080/fpprest/api/general-licensing/batch-numbers/get-last-batch?userHandle=akasturi&count=8
	@CrossOrigin
	@RequestMapping(value = "/get-last-batch", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<BatchNumbers>> getLastBatchr() {
		List<BatchNumbers> result = service.findTop22ByOrderByEntrytimeDesc();
		java.util.Collections.reverse(result);
		//List<BatchNumbers> result = service.findTop22ByBatchNumberDesc();

	/*	List<Integer> countResults = new ArrayList<Integer>();
		
		Integer count = Integer.valueOf(result.get(0).getCount());
		
		int iterator=1;
		for (int index=0; iterator <= count && index < result.size();index++) {
			iterator++;
			//System.out.println("WOOW"+Integer.valueOf(result.get(index).getBatchNumber()));
			countResults.add(Integer.valueOf(result.get(index).getBatchNumber()));
		}
		//Collections.reverse(countResults); */
		//List<BatchNumbers> result = getGeneratedBatchList(Integer.valueOf(topBatchNumber.getBatchNumber()), topBatchNumber.getCount());
		System.out.println("Getting last batch "+result);
		return new ResponseEntity<List<BatchNumbers>>(result, HttpStatus.OK);
    }
	
	
	
	/*@CrossOrigin
	@RequestMapping(value = "/get-last-number", params = {"userHandle"}, method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<BatchNumbers> getLastBatchNumber(@RequestParam("userHandle") String userHandle) {
		System.out.println("userHandle   -->"+userHandle);
		//List<BatchNumbers> result = service.findTop22ByOrderByEntryTimeDesc();
		List<BatchNumbers> result = service.findTop22ByOrderByEntrytimeDesc(userHandle);  
		//List<BatchNumbers> result = getGeneratedBatchList(Integer.valueOf(topBatchNumber.getBatchNumber()), topBatchNumber.getCount());
		//return new ResponseEntity<List<BatchNumbers>>(result, HttpStatus.OK);
		return new ResponseEntity<List<BatchNumbers>>(result, HttpStatus.OK);
    }*/
	
	@RequestMapping(value = "/generateBatchPdf", method = RequestMethod.POST, produces = "application/pdf",consumes= "application/json")
	public @ResponseBody String generateBatchPdf(@RequestBody List<Integer> batch) {
		String file;
		try {
			file = generate(batch);
			//return file;
			/*System.out.println("file path "+ file);
			File initialFile = new File(file);
		    InputStream in = new FileInputStream(initialFile);
			return IOUtils.toByteArray(in);*/
			return "/fppweb"+File.separator+"BatchPdf.pdf";
		} 
		catch (IOException | DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}
	private String generate(List<Integer> batch) throws IOException, DocumentException {
		//String path = System.getProperty("user.dir")+"/src/main/webapp/"+File.separator+"BatchPdf.pdf";
		//String path = "/home/tomcatusr/apache-tomcat-8.5.28/webapps/fppweb/BatchPdf.pdf";
		String path = "/home/tomcatusr/apache-tomcat-8.5.24/webapps/fppweb/BatchPdf.pdf";  //prod path
		
		System.out.println("path  " + path);
		if(new File(path).exists()){
			new File(path).delete();
		} 
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(path));
			document.open();
			Rectangle rect = new Rectangle(577, 825, 18, 15);
			rect.enableBorderSide(1);
			rect.enableBorderSide(2);
			rect.enableBorderSide(4);
			rect.enableBorderSide(8);
			rect.setBorderColor(BaseColor.BLACK);
			rect.setBorderWidth(1);
			document.add(rect);
			addMetaData(document);
			addTitlePage(document, batch);
		} 
		catch (Exception exception) {
			exception.printStackTrace();
		} 
		finally {
			document.close();
		}
		return path;
	}
	
	private void addMetaData(Document document) {
		document.addTitle("Batch PDF");
		document.addSubject("Using Batch");
	}
	    
	private void addTitlePage(Document document, List<Integer> list) throws DocumentException {
		Paragraph preface = new Paragraph();
		preface.add(new Paragraph("                         Licensing Area: Assigned Batch No",smallBold));
		addEmptyLine(preface, 1);
		preface.add(new Paragraph("Batch  Number    Receipt fees date     Assigned to                 Received Amount           Revenue Source Code", smallBold));
		addEmptyLine(preface, 1);
		for (int i = 0; i < list.size(); i++) {
			preface.add(new Paragraph(list.get(i) + "                 ___/___/____      ________________     $ ____________.___                   __________",smallBold));
			if(!(i==list.size()-1))
			addEmptyLine(preface, 1);

		}
		document.add(preface);
		document.newPage();
	}
	    
	private void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}
	
}
