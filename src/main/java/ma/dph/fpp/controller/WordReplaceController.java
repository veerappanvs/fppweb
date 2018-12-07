package ma.dph.fpp.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.springframework.beans.factory.annotation.Autowired;

import ma.dph.fpp.util.WordFileGenerator;
import ma.dph.fpp.domain.facilities.FacilitySearchResult;
import ma.dph.fpp.repository.FacilitiesSearchRepositry;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(path = "/api/wordreplace/facilities") // change it to home page or so
public class WordReplaceController {
	
	static Logger log = Logger.getLogger(WordReplaceController.class.getName());

	@Autowired
    private FacilitiesSearchRepositry facService;
	
	@Autowired
    private WordFileGenerator wordReplaceText;
	
	@CrossOrigin
	@RequestMapping(value = "/id/{id}")
	public ResponseEntity<Optional<FacilitySearchResult>> getCorp(@PathVariable("id") String id ) {
		  ObjectMapper oMapper = new ObjectMapper();
		  Optional<FacilitySearchResult>  facility =null;
				facility = facService.findByFacId(Integer.valueOf(id));
				FacilitySearchResult fars = facility.get();
				 Map<String, Object> facilityMap = oMapper.convertValue(facility, Map.class);
				 System.out.println(facilityMap);
				 Map<String, String> context = new HashMap<>();
				 context.put("«cat_name»", fars.getLicenseType().trim());
				 context.put("«cat_title»", "123");
				 context.put("«dph_certno»", fars.getLicense().trim());
				 context.put("«dexporiss»", "123");
				 context.put("«instr»", "123");
				 context.put("«prkey»", Integer.toString(fars.getFacId()));
				 context.put("«corp_name»", fars.getCorpName().trim());
				  context.put("«mail_add1»",fars.getcMailadd1().trim());
				 context.put("«mail_add2»",fars.getcMailadd2().trim());
				 context.put("«mail_city»",fars.getcMailcity());
				 context.put("«mailstate»",fars.getcMailstate());
				 context.put("«mail_zip»",fars.getcMailzip());
				 context.put("«contact»",fars.getcMailzip());
				 context.put("«facility_name»", fars.getFacilityName().trim());
				 context.put("«bus_add1»", fars.getFacilityAdd1().trim());
				 context.put("«bus_add2»", fars.getFacAdd2());
				 context.put("«bus_city»", fars.getFacilityCity());				 
				 context.put("«bus_state»", fars.getFacMState().trim());
				 context.put("«bus_zip»", fars.getFacZip());
				 
				 HWPFDocument doc;
				try {
					//doc = wordReplaceText.openDocument("foodareasns-original.dot");
					doc = wordReplaceText.openDocument("foodareasns-original-formatted.doc");
					 if (doc != null) {
				            
				          /*  doc = wordReplaceText.replaceText(doc, "«corp_name»", "here is the corpName");
				            doc = wordReplaceText.replaceText(doc, "«facility_name»", "here is the facname");
				            doc = wordReplaceText.replaceText(doc, "«prkey»", fars.getFacId().trim());*/
						 
							Range range = doc.getRange();
							for (Map.Entry<String, String> entry : context.entrySet()) {
								range.replaceText(entry.getKey(), entry.getValue());
							}
							System.out.println("Successsfully replaced the text");
							 wordReplaceText.saveDocument(doc, fars.getFacId()+System.currentTimeMillis()+"foodareasns-original-formatted.doc", false);
					
					 } 
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			       
				 
				 
			return new ResponseEntity<Optional<FacilitySearchResult>>(facility, HttpStatus.OK);
	    }
}
