package ma.dph.fpp.util;


import org.apache.poi.hssf.usermodel.HeaderFooter;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.CharacterRun;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Section;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFFooter;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import java.io.OutputStream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lowagie.text.DocumentException;

import ma.dph.fpp.domain.facilities.PrintCertificate;
import ma.dph.fpp.domain.facilities.RenewalsfoodDetails;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

@Service
public class WordFileGenerator {

	@Autowired
	PdfMerge  pdfmerge;
	
	public WordFileGenerator() {
		// TODO Auto-generated constructor stub
	}
	static Logger log = Logger.getLogger(WordFileGenerator.class.getName());
	
    public static final String SOURCE_PERMIT_FILE = "permit.docx";
    public static final String OUTPUT_PERMIT_FILE = "permit_output.docx";
    public static final String OUTPUT_PERMIT_PDF_FILE = "permit_output.pdf";
	
    public static final String SOURCE_RENEWAL_FILE = "renewal.docx";
    public static final String OUTPUT_RENEWAL_FILE = "renewal_output.docx";
    public static final String OUTPUT_RENEWAL_PDF_FILE = "renewal_output.pdf";
    
    //String path = System.getProperty("user.dir")+"/src/main/webapp/";
    String tempDirName = "temp/";
    //String path = "/home/tomcatusr/apache-tomcat-8.5.28/webapps/fppweb/";
    String path = "/home/tomcatusr/apache-tomcat-8.5.24/webapps/fppweb/";  //prod path
  
    DateFormat  sdf = new SimpleDateFormat("MM/dd/yyyy");

	public     HWPFDocument replaceText(HWPFDocument doc, String findText, String replaceText) {
		
	        Range r = doc.getRange();
	        for (int i = 0; i < r.numSections(); ++i) {
	            Section s = r.getSection(i);
	           log.debug("Sections "+s);
	            for (int j = 0; j < s.numParagraphs(); j++) {
	                Paragraph p = s.getParagraph(j);
	               log.debug("Paragraph "+p);
	                for (int k = 0; k < p.numCharacterRuns(); k++) {
	                    CharacterRun run = p.getCharacterRun(k);
		               log.debug("CharacterRun "+run);
	                    String text = run.text();
	                    if (text.contains(findText)) {
	                        run.replaceText(findText, replaceText);
	                    }
	                }
	            }
	        }
	        
	        //Changeing the Footer 
	        Range footerRange = doc.getFootnoteRange();
	        for (int i = 0; i < footerRange.numSections(); ++i) {
	            Section s = footerRange.getSection(i);
	           log.debug("Sections "+s);
	            for (int j = 0; j < s.numParagraphs(); j++) {
	                Paragraph p = s.getParagraph(j);
	               log.debug("Paragraph "+p);
	                for (int k = 0; k < p.numCharacterRuns(); k++) {
	                    CharacterRun run = p.getCharacterRun(k);
		               log.debug("CharacterRun "+run);
	                    String text = run.text();
	                    if (text.contains(findText)) {
	                        run.replaceText(findText, replaceText);
	                    }
	                }
	            }
	        }
	        
	        //r.replaceText(findText, replaceText);
	        return doc;
	    }

	public     HWPFDocument openDocument(String file) throws Exception {
	       // URL res = getClass().getClassLoader().getResource(file);
	        
	       //log.debug(file +" URL res  "+res);
	        HWPFDocument document = null;
	        if (file != null) {
	            //document = new HWPFDocument(new POIFSFileSystem(new File(res.getPath())));
	        	document = new HWPFDocument(new POIFSFileSystem(new ClassPathResource(file).getFile()));
	        	//document = new HWPFDocument(new POIFSFileSystem(new File(file)));
	           log.debug(file +" document  "+document);
	        }
	        return document;
	    }

	public     void saveDocument(HWPFDocument doc, String file, boolean append) throws IOException {
		
		//Path newFilePath = Files.createFile(Paths.get("src/main/resources/"+file));
	    //Files.createFile(newFilePath);
	        try (FileOutputStream out = new FileOutputStream( path+file, append ) ) {
	            doc.write(out);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	
	
	 public void createCertificates(List<PrintCertificate> certificateData, String filenameprefix) throws InvalidFormatException, IOException, DocumentException {
		 ObjectMapper oMapper = new ObjectMapper();
		 long tempDirName = System.currentTimeMillis();
		 File tempDir = new File(path+tempDirName+"/");
		  if (!tempDir.exists()) {
			  tempDir.mkdirs();
			  log.debug("Directory created"+tempDir.getName());
		  }
		  else {
			  log.debug("Directory exists"+tempDir.getName());

		  }
		 File wordFile =new File( path+tempDirName+"/"+OUTPUT_PERMIT_FILE);
		 log.debug("Created Empty word File"+path+tempDirName+"/"+OUTPUT_PERMIT_FILE);
		 for(PrintCertificate printCertifcate :certificateData) {
			 
			 long timeFilename = System.currentTimeMillis();
		   log.debug("Processing  certificate for "+printCertifcate);
			 	XWPFDocument doc = new XWPFDocument(OPCPackage.open(new ClassPathResource(SOURCE_PERMIT_FILE).getFile()));
			 	for (XWPFParagraph p : doc.getParagraphs()) {
				        List<XWPFRun> runs = p.getRuns();
				        if (runs != null) {
				            for (XWPFRun r : runs) {
				                String text = r.getText(0);
				              //  if (text != null && printCertifcateMap.containsKey(text)) {
				                if (text != null && text.contains("fac_madd1")) {
				                    text = text.replace("fac_madd1",( (printCertifcate.getFacMadd1() == null?"":printCertifcate.getFacMadd1())+" " + (printCertifcate.getFacMadd2() == null?"":printCertifcate.getFacMadd2())  ));
				                    r.setText(text, 0);
				                }
				                else  if (text != null && text.contains("fac_mcity")) {
				                	//log.debug("text == "+text);
				                    text = text.replace("fac_mcity", printCertifcate.getFacMcity())+", "+printCertifcate.getFacMstate()+" "+printCertifcate.getFacMzip();
				     
				                    r.setText(text, 0);
				                }
				                else if (text != null && text.contains("dbaadd")) {
				                    text = text.replace("dbaadd", (printCertifcate.getFacAdd1() == null?"":printCertifcate.getFacAdd1()));
				                    r.setText(text, 0);
				                    log.debug("Changing the fac_add1");
				                }
				                else  if (text != null && text.contains("dbacity")) {
				                	//log.debug("text == "+text);
				                    text = text.replace("dbacity", printCertifcate.getFacCity())+", "+printCertifcate.getFacState()+" "+printCertifcate.getFacZip();
				     
				                    r.setText(text, 0);
				                }
				                else  if (text != null && text.contains("fac_name")) {
				                	
				                    text = text.replace("fac_name", printCertifcate.getFacName());
				                    r.setText(text, 0);
				                }
				                
				               
				                
				            }
				  }
			   }
			 	
			 	
			 	 for (XWPFTable tbl : doc.getTables()) {
			         for (XWPFTableRow row : tbl.getRows()) {
			             for (XWPFTableCell cell : row.getTableCells()) {
			                 for (XWPFParagraph p : cell.getParagraphs()) {
			                     for (XWPFRun r : p.getRuns()) {
			                         String text = r.getText(0);
			                         
			                           if (text != null && text.contains("regchpt")) {
						                    text = text.replace("regchpt", printCertifcate.getRegchpt());
						                    r.setText(text, 0);
						                }
						                else  if (text != null && text.contains("cat_descr")) {
						                    text = text.replace("cat_descr", printCertifcate.getCatDescr());
						                    r.setText(text, 0);
						                }
						                else  if (text != null && text.contains("appreg")) {
						                    text = text.replace("appreg", printCertifcate.getAppRegulation());
						                    r.setText(text, 0);
						                }
						                else  if (text != null && text.contains("reg_license")) {
						                    text = text.replace("reg_license", printCertifcate.getRegLicense());
						                    r.setText(text, 0);
						                }
						                else  if (text != null && text.contains("date_issue")) {
						                    text = text.replace("date_issue", printCertifcate.getDateIssue());
						                    r.setText(text, 0);
						                }
						                else  if (text != null && text.contains("date_expire")) {
						                    text = text.replace("date_expire", printCertifcate.getDateExpire());
						                    r.setText(text, 0);
						                }
						                else  if (text != null && text.contains("URN")) {
						                	//log.debug("text == "+text);
						                	if(printCertifcate.getCatName().equals("Upholstered Furniture or Bedding") || printCertifcate.getCatName().equals("Stuffed Toys") ) {
						                			//text = text.replace("unifiedresnumber", renwalFoodDetails.getCatShort());
						                			r.setText("URN:", 0);
						                			log.debug(" Setting hte Placeholder for URN");
						                	}
						                	else {
					                			log.debug(" Setting empty placeholder for URN");
						                		r.setText("", 0);
						                	}
						                }
						                else  if (text != null && text.contains("unifiedresnumber")) {
						                	//log.debug("text == "+text);
						                	if(printCertifcate.getCatName().equals("Upholstered Furniture or Bedding") || printCertifcate.getCatName().equals("Stuffed Toys")) {
						                			String urn =( printCertifcate.getUrn()==null ? "":printCertifcate.getUrn());
						                			text = text.replace("unifiedresnumber", urn);
						                			r.setText(text, 0);
						                			log.debug(" Setting hte value for URN");
						                	}
						                	else {
					                			log.debug(" Setting empty value for URN");
						                		r.setText("", 0);
						                	}
						                }
			                     }
			                 }
			             }
			         }
			 	 }
		/*	 	XWPFFooter foot = doc.createHeaderFooterPolicy().createFooter(XWPFHeaderFooterPolicy.DEFAULT);
			 	
			 	foot.createParagraph().createRun().setText("MailedTo :");
	            //foot.createParagraph().createRun().addBreak();
	            foot.createParagraph().createRun().setText(printCertifcate.getFacName());
	            //foot.createParagraph().createRun().addBreak();
	            foot.createParagraph().createRun().setText(printCertifcate.getFacMadd1());
	            //foot.createParagraph().createRun().addBreak();
	            foot.createParagraph().createRun().setText(printCertifcate.getFacMcity()+" "+printCertifcate.getFacMstate()+" "+printCertifcate.getFacMzip());*/
	            
	            
	            
	         /*   CTSectPr sectPr = doc.getDocument().getBody().getSectPr();
	            if (sectPr == null) sectPr = doc.getDocument().getBody().addNewSectPr();
	            CTPageMar pageMar = sectPr.getPgMar();
	            if (pageMar == null) pageMar = sectPr.addNewPgMar();
	            pageMar.setLeft(BigInteger.valueOf(720)); //720 TWentieths of an Inch Point (Twips) = 720/20 = 36 pt = 36/72 = 0.5"
	            pageMar.setRight(BigInteger.valueOf(720));
	            pageMar.setTop(BigInteger.valueOf(1440)); //1440 Twips = 1440/20 = 72 pt = 72/72 = 1"
	            pageMar.setFooter(BigInteger.valueOf(720)); //0.5" footer margin
	            long notPrintableBottomPageRange = (long)(0.038888*72*20); //0.038888" gap for non printable bottom page range
	            pageMar.setBottom(BigInteger.valueOf(1152+720+notPrintableBottomPageRange)); //1152 Twips = 1152/20/72 = 0.8"
*/	           
	            
			 	//File wordFile = new File( path+OUTPUT_FILE);
			 	/* try (OutputStream os = new FileOutputStream(wordFile)) {
			 	// try (OutputStream os = new FileOutputStream(new File( path+OUTPUT_FILE))) {
		                doc.write(os);
		               // os.flush();
		               // os.close();
		               // doc.close();
		                
		            }*/
			 	 
			 		OutputStream os = new FileOutputStream(wordFile);
			 		doc.write(os);
			 		os.flush();
			 		
			 		
				 	  InputStream in = new FileInputStream( wordFile);
				 	  XWPFDocument document = new XWPFDocument(in);
				 	  PdfOptions options = PdfOptions.create();
				 	  OutputStream out = new FileOutputStream( path+tempDirName+"/"+timeFilename+"_"+OUTPUT_PERMIT_PDF_FILE, true);
				 	  PdfConverter.getInstance().convert(document, out, options);
				 	  out.flush();
				 	  out.close();
				 		log.debug("Created pdf file "+path+tempDirName+"/"+timeFilename+"_"+OUTPUT_PERMIT_PDF_FILE);


				  File dir = new File(path+tempDirName+"/");
				  File[] directoryListing = null;
				 List<InputStream>  insStream = new ArrayList<InputStream>();
				 
				 OutputStream   outStrem =  new FileOutputStream(new File(path+filenameprefix+OUTPUT_PERMIT_PDF_FILE));
				  if (dir.isDirectory()) {
					  directoryListing = dir.listFiles();
					  if (directoryListing != null) {
						    for (File child : directoryListing) {
						    	log.debug("Processing Files "+child.getName());
						    	if (child.getName().contains("pdf"))
						    	   		insStream.add(new FileInputStream(child));
						    	
						    	child.deleteOnExit();
						    }		
						  } else {
						  
						  }
				  }
				  
				  pdfmerge.doMerge(insStream, outStrem);
				  log.debug("Deleting  the temp directory"+dir.getAbsolutePath()+" Status : "+dir.delete());
			 	log.debug("writing docx  --> ");
		}
	 }
	
	 
	 public void createCertificate(PrintCertificate printCertifcate) throws InvalidFormatException, IOException, DocumentException {
		 
		 long tempDirName = System.currentTimeMillis();
		 File tempDir = new File(path+tempDirName+"/");
		  if (!tempDir.exists()) {
			  tempDir.mkdirs();
			  log.debug("Directory created"+tempDir.getName());
		  }
		  else {
			  log.debug("Directory exists"+tempDir.getName());

		  }
		 File wordFile =new File( path+tempDirName+"/"+OUTPUT_PERMIT_FILE);
		 log.debug("Created Empty word File"+path+tempDirName+"/"+OUTPUT_PERMIT_FILE);
			 
			 long timeFilename = System.currentTimeMillis();
		   log.debug("Processing  certificate for "+printCertifcate);
			 	XWPFDocument doc = new XWPFDocument(OPCPackage.open(new ClassPathResource(SOURCE_PERMIT_FILE).getFile()));
			 	for (XWPFParagraph p : doc.getParagraphs()) {
				        List<XWPFRun> runs = p.getRuns();
				        if (runs != null) {
				            for (XWPFRun r : runs) {
				                String text = r.getText(0);
				              //  if (text != null && printCertifcateMap.containsKey(text)) {
				                if (text != null && text.contains("fac_madd1")) {
				                    text = text.replace("fac_madd1",( (printCertifcate.getFacMadd1() == null?"":printCertifcate.getFacMadd1())+" " + (printCertifcate.getFacMadd2() == null?"":printCertifcate.getFacMadd2())  ));
				                    r.setText(text, 0);
				                }
				                else  if (text != null && text.contains("fac_mcity")) {
				                	//log.debug("text == "+text);
				                    text = text.replace("fac_mcity", printCertifcate.getFacMcity())+", "+printCertifcate.getFacMstate()+" "+printCertifcate.getFacMzip();
				     
				                    r.setText(text, 0);
				                }
						
				                else if (text != null && text.contains("dbaadd")) {
				                    text = text.replace("dbaadd", (printCertifcate.getFacAdd1() == null?"":printCertifcate.getFacAdd1()));
				                    r.setText(text, 0);
				                    log.debug("Changing the fac_add1");
				                }
				                else  if (text != null && text.contains("dbacity")) {
				                	//log.debug("text == "+text);
				                    text = text.replace("dbacity", printCertifcate.getFacCity())+", "+printCertifcate.getFacState()+" "+printCertifcate.getFacZip();
				     
				                    r.setText(text, 0);
				                }
				                else  if (text != null && text.contains("fac_name")) {
				                	
				                    text = text.replace("fac_name", printCertifcate.getFacName());
				                    r.setText(text, 0);
				                }
				                else {
				                	log.debug("text  -- "+text);
				                }
				                
				                
				            }
				  }
			   }
			 	
			 	
			 	 for (XWPFTable tbl : doc.getTables()) {
			         for (XWPFTableRow row : tbl.getRows()) {
			             for (XWPFTableCell cell : row.getTableCells()) {
			                 for (XWPFParagraph p : cell.getParagraphs()) {
			                     for (XWPFRun r : p.getRuns()) {
			                         String text = r.getText(0);
			                         
			                           if (text != null && text.contains("regchpt")) {
						                    text = text.replace("regchpt", printCertifcate.getRegchpt());
						                    r.setText(text, 0);
						                }
						                else  if (text != null && text.contains("cat_descr")) {
						                    text = text.replace("cat_descr", printCertifcate.getCatDescr());
						                    r.setText(text, 0);
						                }
						                else  if (text != null && text.contains("appreg")) {
						                    text = text.replace("appreg", printCertifcate.getAppRegulation());
						                    r.setText(text, 0);
						                }
						                else  if (text != null && text.contains("reg_license")) {
						                    text = text.replace("reg_license", printCertifcate.getRegLicense());
						                    r.setText(text, 0);
						                }
						                else  if (text != null && text.contains("date_issue")) {
						                    text = text.replace("date_issue", printCertifcate.getDateIssue());
						                    r.setText(text, 0);
						                }
						                else  if (text != null && text.contains("date_expire")) {
						                    text = text.replace("date_expire", printCertifcate.getDateExpire());
						                    r.setText(text, 0);
						                }
						                else  if (text != null && text.contains("URN")) {
						                	//log.debug("text == "+text);
						                	if(printCertifcate.getCatName().equalsIgnoreCase("Upholstered Furniture or Bedding") || printCertifcate.getCatName().equalsIgnoreCase("Stuffed Toys") ) {
						                			//text = text.replace("unifiedresnumber", renwalFoodDetails.getCatShort());
						                			r.setText("URN:", 0);
						                			log.debug(" Setting hte Placeholder for URN");
						                	}
						                	else {
					                			log.debug(" Setting empty placeholder for URN");
						                		r.setText("", 0);
						                	}
						                }
						                else  if (text != null && text.contains("unifiedresnumber")) {
						                	//log.debug("text == "+text);
						                	if(printCertifcate.getCatName().equals("Upholstered Furniture or Bedding") || printCertifcate.getCatName().equals("Stuffed Toys")) {
						                			String urn =( printCertifcate.getUrn()==null ? "":printCertifcate.getUrn());
					                				text = text.replace("unifiedresnumber", urn);
						                			r.setText(text, 0);
						                			log.debug(" Setting hte value for URN");
						                	}
						                	else {
					                			log.debug(" Setting empty value for URN");
						                		r.setText("", 0);
						                	}
						                }
			                     }
			                 }
			             }
			         }
			 	 }
		
			 	 
		 		OutputStream os = new FileOutputStream(wordFile);
		 		doc.write(os);
		 		os.flush();
			 		
			 		
		 	  InputStream in = new FileInputStream( wordFile);
		 	  XWPFDocument document = new XWPFDocument(in);
		 	  PdfOptions options = PdfOptions.create();
		 	  OutputStream out = new FileOutputStream( path+OUTPUT_PERMIT_PDF_FILE);
		 	  PdfConverter.getInstance().convert(document, out, options);
		 	  out.flush();
		 	  out.close();
		 		log.debug("Created pdf file "+path+OUTPUT_PERMIT_PDF_FILE);

	 }
	

	 
	 public void createRenewals(List<RenewalsfoodDetails>  renewalsData) throws InvalidFormatException, IOException, DocumentException {
		 ObjectMapper oMapper = new ObjectMapper();
		  long tempDirName = System.currentTimeMillis();
		  File tempDir = new File(path+tempDirName+"/");

		  if (!tempDir.exists())  {
			  tempDir.mkdirs();
			  log.debug("Created temp Directory :"+tempDir.getAbsolutePath());
		  }
		  else {
			  log.debug("Directory Exists :"+tempDir.getAbsolutePath());
		  }
		 File wordFile = null;
		 
		 for(RenewalsfoodDetails renwalFoodDetails :renewalsData) {
			 log.debug("Created renewal certificate for "+renwalFoodDetails);
			 long timeFilenm = System.currentTimeMillis();
			 wordFile =new File( path+tempDirName+"/"+timeFilenm+"_"+OUTPUT_RENEWAL_FILE);
			 log.debug("created empty file "+path+tempDirName+"/"+timeFilenm+"_"+OUTPUT_RENEWAL_FILE);
			 
			 	XWPFDocument doc = new XWPFDocument(OPCPackage.open(new ClassPathResource(SOURCE_RENEWAL_FILE).getFile()));
			 	for (XWPFParagraph p : doc.getParagraphs()) {
				        List<XWPFRun> runs = p.getRuns();
				        if (runs != null) {
				            for (XWPFRun r : runs) {
				                String text = r.getText(0);
				              //  if (text != null && printCertifcateMap.containsKey(text)) {
				                if (text != null && text.contains("corpName")) {
				                    text = text.replace("corpName", renwalFoodDetails.getCorpName());
				                    r.setText(text, 0);
				                }
				                else  if (text != null && text.contains("facilityName")) {
				                	
				                    text = text.replace("facilityName", renwalFoodDetails.getFacilityName());
				                    r.setText(text, 0);
				                }
				                else  if (text != null && text.contains("mailAdd1")) {
				                	//log.debug("text == "+text);
				                    text = text.replace("mailAdd1",( renwalFoodDetails.getMailAdd1()+" "+   (renwalFoodDetails.getMailAdd2() == null?"":renwalFoodDetails.getMailAdd2())  ));
				     
				                    r.setText(text, 0);
				                }
				                else  if (text != null && text.contains("mailAdd2")) {
				                	//log.debug("text == "+text);
				                    text = text.replace("mailAdd2", renwalFoodDetails.getMailCity()+" "+renwalFoodDetails.getMailState()+" "+renwalFoodDetails.getMailZip());
				     
				                    r.setText(text, 0);
				                }
				            }
				  }
			   }
			 	
			 	 for (XWPFTable tbl : doc.getTables()) {
			         for (XWPFTableRow row : tbl.getRows()) {
			             for (XWPFTableCell cell : row.getTableCells()) {
			                 for (XWPFParagraph p : cell.getParagraphs()) {
			                     for (XWPFRun r : p.getRuns()) {
			                         String text = r.getText(0);
			                         
			                         if (text != null && text.contains("corpName")) {
						                    text = text.replace("corpName", renwalFoodDetails.getCorpName());
						                    r.setText(text, 0);
						                }
						                else  if (text != null && text.contains("facilityName")) {
						                	
						                    text = text.replace("facilityName", renwalFoodDetails.getFacilityName());
						                    r.setText(text, 0);
						                }
						                else  if (text != null && text.contains("mailAdd1")) {
						                	//log.debug("text == "+text);
						                    //text = text.replace("mailAdd1", renwalFoodDetails.getMailAdd1());
						                	text = text.replace("mailAdd1", renwalFoodDetails.getBusAdd1() + " "+ renwalFoodDetails.getBusAdd2());
						     
						                    r.setText(text, 0);
						                }
						                else  if (text != null && text.contains("mailAdd2")) {
						                	//log.debug("text == "+text);
						                  //  text = text.replace("mailAdd2", renwalFoodDetails.getMailCity()+" "+renwalFoodDetails.getMailState()+" "+renwalFoodDetails.getMailZip());
						                	  text = text.replace("mailAdd2", renwalFoodDetails.getBusCity()+" "+renwalFoodDetails.getBusState()+" "+renwalFoodDetails.getBusZip());
						     
						                    r.setText(text, 0);
						                }
						                else  if (text != null && text.contains("catName")) {
						                	//log.debug("text == "+text);
						                    text = text.replace("catName", renwalFoodDetails.getCatName());
						     
						                    r.setText(text, 0);
						                }
						                else  if (text != null && text.contains("regcpt")) {
						                	//log.debug("text == "+text);
						                    text = text.replace("regcpt", renwalFoodDetails.getRegchpt());
						     
						                    r.setText(text, 0);
						                }
						                else  if (text != null && text.contains("appreg")) {
						                	//log.debug("text == "+text);
						                	log.debug("Changing  the appreg"+ renwalFoodDetails.getRegchpt1().trim());
						                    text = text.replace("appreg", renwalFoodDetails.getRegchpt1().trim());
						     
						                    r.setText(text, 0);
						                }
						                else  if (text != null && text.contains("dphCertno")) {
						                	//log.debug("text == "+text);
						                    text = text.replace("dphCertno", renwalFoodDetails.getDphCertno());
						     
						                    r.setText(text, 0);
						                }
						                else  if (text != null && text.contains("dend")) {
						                	//log.debug("text == "+text);
						                    text = text.replace("dend",sdf.format(renwalFoodDetails.getDexporiss()));
						     
						                    r.setText(text, 0);
						                }
						                else  if (text != null && text.contains("amount")) {
						                	//log.debug("text == "+text);
						                	if(renwalFoodDetails.getCatShort().equals("Vending Machines (Water Only)")   || renwalFoodDetails.getCatShort().equalsIgnoreCase("Vending Machines (Food and Beverages)")) {
						                		 text = text.replace("amount", (renwalFoodDetails.getFee().trim()+" Per Machine"));
						                	}
						                	else {
						                    text = text.replace("amount", renwalFoodDetails.getFee());
						                	}
						                    r.setText(text, 0);
						                }
						                else  if (text != null && text.contains("URN")) {
						                	//log.debug("text == "+text);
						                	if(renwalFoodDetails.getCatShort().equals("Upholstered Furniture or Bedding")   || renwalFoodDetails.getCatShort().equalsIgnoreCase("Stuffed Toys")) {
						                			//text = text.replace("unifiedresnumber", renwalFoodDetails.getCatShort());
						                			r.setText("URN:", 0);
						                			log.debug(" Setting hte Placeholder for URN");
						                	}
						                	else {
					                			log.debug(" Setting empty placeholder for URN");
						                		r.setText("", 0);
						                	}
						                }
						                else  if (text != null && text.contains("unifiedresnumber")) {
						                	//log.debug("text == "+text);
						                	if(renwalFoodDetails.getCatShort().equals("Upholstered Furniture or Bedding")   || renwalFoodDetails.getCatShort().equalsIgnoreCase("Stuffed Toys")) {
						                			String urn =( renwalFoodDetails.getUrn()==null ? "":renwalFoodDetails.getUrn());
						                			text = text.replace("unifiedresnumber", urn);
						                			r.setText(text, 0);
						                			log.debug(" Setting hte value for URN");
						                	}
						                	else {
					                			log.debug(" Setting empty value for URN");
						                		r.setText("", 0);
						                	}
						                }
						                
			                     }
			                 }
			             }
			         }
			 	 }
	
			 	 
			 		OutputStream os = new FileOutputStream(wordFile);
			 		doc.write(os);
			 		os.flush();
			 		log.debug("Created word doc");
			 	  InputStream in = new FileInputStream( wordFile);
			 	  XWPFDocument document = new XWPFDocument(in);
			 	  PdfOptions options = PdfOptions.create();
			 	  OutputStream out = new FileOutputStream( path+tempDirName+"/"+timeFilenm+"_"+OUTPUT_RENEWAL_PDF_FILE, true);
			 	  PdfConverter.getInstance().convert(document, out, options);
			 	  out.flush();
			 	  out.close();
			 		log.debug("Created pdf file "+path+tempDirName+"/"+timeFilenm+"_"+OUTPUT_RENEWAL_PDF_FILE);

			 	//log.debug("writing docx  for renewal--> "+printCertifcateMap);
		}
		  File dir = new File(path+tempDirName+"/");
		  File[] directoryListing = null;
		 List<InputStream>  insStream = new ArrayList<InputStream>();
		 
		 OutputStream   outStrem =  new FileOutputStream(new File(path+OUTPUT_RENEWAL_PDF_FILE));
		  if (dir.isDirectory()) {
			  directoryListing = dir.listFiles();
			  if (directoryListing != null) {
				    for (File child : directoryListing) {
				    	log.debug("Processing Files "+child.getName());
				    	if (child.getName().contains("pdf"))
				    	   		insStream.add(new FileInputStream(child));
				    	
				    }		
				  } else {
				  
				  }
		  }
		  
		  pdfmerge.doMerge(insStream, outStrem);
		  
		  log.debug("Deleting  the temp directory"+dir.getAbsolutePath()+" Status : "+dir.delete());
		  //File file1 = new File(path+OUTPUT_RENEWAL_PDF_FILE); 
	     // PDDocument doc1 = PDDocument.load(file1); 
	 	  //PDFMergerUtility PDFmerger = new PDFMergerUtility();     
		 
	 }
	
	 public void createRenewal(RenewalsfoodDetails  renwalFoodDetails) throws InvalidFormatException, IOException, DocumentException {
		
		 File tempDir = new File(path+tempDirName+"/");
		  if (!tempDir.exists())  {
			  tempDir.mkdirs();
			  log.debug("Created temp Directory :"+tempDir.getAbsolutePath());
		  }
		  else {
			  log.debug("Directory Exists :"+tempDir.getAbsolutePath());
		  }
		 
			 log.debug("Created renewal certificate for "+renwalFoodDetails);
			 long timeFilenm = System.currentTimeMillis();
			 File wordFile = new File( path+tempDirName+timeFilenm+"_"+OUTPUT_RENEWAL_FILE);
			 log.debug("created empty file "+path+tempDirName+timeFilenm+"_"+OUTPUT_RENEWAL_FILE);
			 
			 	XWPFDocument doc = new XWPFDocument(OPCPackage.open(new ClassPathResource(SOURCE_RENEWAL_FILE).getFile()));
			 	for (XWPFParagraph p : doc.getParagraphs()) {
				        List<XWPFRun> runs = p.getRuns();
				        if (runs != null) {
				            for (XWPFRun r : runs) {
				                String text = r.getText(0);
				              //  if (text != null && printCertifcateMap.containsKey(text)) {
				                if (text != null && text.contains("corpName")) {
				                    text = text.replace("corpName", renwalFoodDetails.getCorpName());
				                    r.setText(text, 0);
				                }
				                else  if (text != null && text.contains("facilityName")) {
				                	
				                    text = text.replace("facilityName", renwalFoodDetails.getFacilityName());
				                    r.setText(text, 0);
				                }
				                else  if (text != null && text.contains("mailAdd1")) {
				                	//log.debug("text == "+text);
				                    text = text.replace("mailAdd1",( renwalFoodDetails.getMailAdd1()+" "+   (renwalFoodDetails.getMailAdd2() == null?"":renwalFoodDetails.getMailAdd2())  ));
				                    r.setText(text, 0);
				                }
				                else  if (text != null && text.contains("mailAdd2")) {
				                	//log.debug("text == "+text);
				                    text = text.replace("mailAdd2", renwalFoodDetails.getMailCity()+" "+renwalFoodDetails.getMailState()+" "+renwalFoodDetails.getMailZip());
				     
				                    r.setText(text, 0);
				                }
				            }
				  }
			   }
			 	
			 	 for (XWPFTable tbl : doc.getTables()) {
			         for (XWPFTableRow row : tbl.getRows()) {
			             for (XWPFTableCell cell : row.getTableCells()) {
			                 for (XWPFParagraph p : cell.getParagraphs()) {
			                     for (XWPFRun r : p.getRuns()) {
			                         String text = r.getText(0);
			                         
			                         if (text != null && text.contains("corpName")) {
						                    text = text.replace("corpName", renwalFoodDetails.getCorpName());
						                    r.setText(text, 0);
						                }
						                else  if (text != null && text.contains("facilityName")) {
						                	
						                    text = text.replace("facilityName", renwalFoodDetails.getFacilityName());
						                    r.setText(text, 0);
						                }
						                else  if (text != null && text.contains("mailAdd1")) {
						                	//log.debug("text == "+text);
						                  //  text = text.replace("mailAdd1", renwalFoodDetails.getMailAdd1());
						                	text = text.replace("mailAdd1", renwalFoodDetails.getBusAdd1() + " "+ renwalFoodDetails.getBusAdd2());

						     
						                    r.setText(text, 0);
						                }
						                else  if (text != null && text.contains("mailAdd2")) {
						                	//log.debug("text == "+text);
						               //     text = text.replace("mailAdd2", renwalFoodDetails.getMailCity()+" "+renwalFoodDetails.getMailState()+" "+renwalFoodDetails.getMailZip());
						                	 text = text.replace("mailAdd2", renwalFoodDetails.getBusCity()+" "+renwalFoodDetails.getBusState()+" "+renwalFoodDetails.getBusZip());
						                	 
						                    r.setText(text, 0);
						                }
						                else  if (text != null && text.contains("catName")) {
						                	//log.debug("text == "+text);
						                    text = text.replace("catName", renwalFoodDetails.getCatName());
						     
						                    r.setText(text, 0);
						                }
						                else  if (text != null && text.contains("regcpt")) {
						                	//log.debug("text == "+text);
						                    text = text.replace("regcpt", renwalFoodDetails.getRegchpt());
						     
						                    r.setText(text, 0);
						                }
						                else  if (text != null && text.contains("appreg")) {
						                	//log.debug("text == "+text);
						                	log.debug("Changing  the appreg"+ renwalFoodDetails.getRegchpt1());
						                    text = text.replace("appreg", renwalFoodDetails.getRegchpt1().trim());
						     
						                    r.setText(text, 0);
						                }
						                else  if (text != null && text.contains("dphCertno")) {
						                	//log.debug("text == "+text);
						                    text = text.replace("dphCertno", renwalFoodDetails.getDphCertno());
						     
						                    r.setText(text, 0);
						                }
						                else  if (text != null && text.contains("dend")) {
						                	//log.debug("text == "+text);
						                    text = text.replace("dend",sdf.format(renwalFoodDetails.getDexporiss()));
						     
						                    r.setText(text, 0);
						                }
						                else  if (text != null && text.contains("amount")) {
						                	//log.debug("text == "+text);
						                	if(renwalFoodDetails.getCatShort().equals("Vending Machines (Water Only)")   || renwalFoodDetails.getCatShort().equalsIgnoreCase("Vending Machines (Food and Beverages)")) {
						                		  log.debug("renwalFoodDetails.getCatShort() "+renwalFoodDetails.getCatShort());
						                			text = text.replace("amount", (renwalFoodDetails.getFee().trim()+" Per Machine"));
						                	}
						                	else {
						                		  log.debug("mot renwalFoodDetails.getCatShort() "+renwalFoodDetails.getCatShort());

						                    text = text.replace("amount", renwalFoodDetails.getFee());
						                	}
						                    r.setText(text, 0);
						                }
						                else  if (text != null && text.contains("URN")) {
						                	//log.debug("text == "+renwalFoodDetails.getCatName());
						                	if(renwalFoodDetails.getCatShort().equals("Upholstered Furniture or Bedding") ||  renwalFoodDetails.getCatShort().equals("Stuffed Toys")) {
						                			//text = text.replace("unifiedresnumber", renwalFoodDetails.getCatShort());
						                			r.setText("URN:", 0);
						                			log.debug(" Setting hte Placeholder for URN");
						                	}
						                	else {
					                			log.debug(" Setting empty placeholder for URN");
						                		r.setText("", 0);
						                	}
						                }
						                else  if (text != null && text.contains("unifiedresnumber")) {
						                	//log.debug("text == "+text);
						                	if(renwalFoodDetails.getCatShort().equals("Upholstered Furniture or Bedding") ||    renwalFoodDetails.getCatShort().equals("Stuffed Toys")) {
						                		String urn =( renwalFoodDetails.getUrn()==null ? "":renwalFoodDetails.getUrn());
						                			text = text.replace("unifiedresnumber", urn);
						                			r.setText(text, 0);
						                			log.debug(" Setting hte value for URN");
						                	}
						                	else {
					                			log.debug(" Setting empty value for URN");
						                		r.setText("", 0);
						                	}
						                }
			                     }
			                 }
			             }
			         }
			 	 }
	
			 	 
			 		OutputStream os = new FileOutputStream(wordFile);
			 		doc.write(os);
			 		os.flush();
			 		log.debug("Created word doc");
			 	  InputStream in = new FileInputStream( wordFile);
			 	  XWPFDocument document = new XWPFDocument(in);
			 	  PdfOptions options = PdfOptions.create();
			 	  OutputStream out = new FileOutputStream( path+OUTPUT_RENEWAL_PDF_FILE);
			 	  PdfConverter.getInstance().convert(document, out, options);
			 	  out.flush();
			 	  out.close();
			 	  log.debug("Created pdf file "+path+OUTPUT_RENEWAL_PDF_FILE);

		}
	
}
	


