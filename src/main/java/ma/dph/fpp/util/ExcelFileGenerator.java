package ma.dph.fpp.util;

//import org.apache.http.HttpResponse;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.dph.fpp.domain.facilities.Corporation;
import ma.dph.fpp.domain.facilities.ExpiredFacList;
import ma.dph.fpp.domain.facilities.Facilities;
import ma.dph.fpp.domain.facilities.Fclass;
import ma.dph.fpp.domain.facilities.FoodProcesorInfo;
import ma.dph.fpp.domain.facilities.Registration;
import ma.dph.fpp.domain.facilities.Transaction;
import ma.dph.fpp.domain.generallicensing.FiscalReport;
import ma.dph.fpp.domain.generallicensing.RctFeeReport;
import ma.dph.fpp.domain.generallicensing.ReceiptOfFeesRevised;
import ma.dph.fpp.domain.generallicensing.TransmittalReport;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.swing.JSpinner.DateEditor;

import org.apache.log4j.Logger;

@Service
public class ExcelFileGenerator {

	static Logger log = Logger.getLogger(ExcelFileGenerator.class.getName());

	public ExcelFileGenerator() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	MonthYearSorter monthYearSorter;

	 //String path = "/home/tomcatusr/apache-tomcat-8.5.28/webapps/fppweb/"; 
	//String path = System.getProperty("user.dir") + "/src/main/webapp/";
	String path = "/home/tomcatusr/apache-tomcat-8.5.24/webapps/fppweb/";  //prod path
	
	private static final String TRANSMITTAL_FILE_NAME = "TransmittalReport.xlsx";
	private static final String RCTFEE_FILE_NAME = "RctFeeReport.xlsx";
	private static final String FISCAL_FILE_NAME = "FiscalReport.xlsx";
	private static final String EXPIRED_FACILITIES_FILE_NAME = "ExpiredFacilitiesReport.xlsx";
	private static final String ACTIVE_FACILITIES_FILE_NAME = "ActiveFacilitiesReport.xlsx";
	private static final String EXPIRED_REGISTRAION_FILE_NAME = "ExpiredRegistrationReport.xlsx";
	private static final String FACILITIES_REPORT = "FacilitiesReport.xlsx";
	SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat format2 = new SimpleDateFormat("MM/dd/yyyy");
	
	DecimalFormat df = new DecimalFormat(".00");

	public void createExpiredFacilitiesReportXlsxSheet(Map<String, List<ExpiredFacList>> map)
			throws IOException, ParseException {

		XSSFWorkbook workbook = new XSSFWorkbook();
		for (Map.Entry<String, List<ExpiredFacList>> entry : map.entrySet()) {
			String sheetName = entry.getKey();
			sheetName = sheetName.replaceAll("[\\W]", "");
			XSSFSheet sheet = workbook.createSheet(sheetName);
			sheet.setDefaultColumnWidth(15);
			List<ExpiredFacList> expiredFacLists = entry.getValue();
			sheet.setDefaultColumnWidth(30);

			// create style for header cells
			CellStyle topHeaderStyle = workbook.createCellStyle();
			Font topheaderFont = workbook.createFont();
			topheaderFont.setFontName("Arial");
			topHeaderStyle.setFillForegroundColor(HSSFColor.DARK_TEAL.index);
			topHeaderStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			topheaderFont.setBold(true);
			topheaderFont.setColor(HSSFColor.WHITE.index);
			topHeaderStyle.setFont(topheaderFont);
			int rowCount = 0;

			// create style for middle header
			CellStyle middleHeaderStyle = workbook.createCellStyle();
			Font font = workbook.createFont();
			font.setFontName("Arial");
			middleHeaderStyle.setFillForegroundColor(HSSFColor.AQUA.index);
			middleHeaderStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			font.setBold(true);
			font.setColor(HSSFColor.WHITE.index);
			middleHeaderStyle.setFont(font);

			// Text header
			Row textheader = sheet.createRow(rowCount++);
			textheader.createCell(0).setCellStyle(topHeaderStyle);
			textheader.createCell(1).setCellStyle(topHeaderStyle);
			textheader.createCell(2).setCellStyle(topHeaderStyle);
			textheader.createCell(3).setCellValue("ExpiredFacility Report");
			textheader.getCell(3).setCellStyle(topHeaderStyle);
			textheader.createCell(4).setCellStyle(topHeaderStyle);
			textheader.createCell(5).setCellStyle(topHeaderStyle);
			textheader.createCell(6).setCellStyle(topHeaderStyle);
			textheader.createCell(7).setCellStyle(topHeaderStyle);
			textheader.createCell(8).setCellStyle(topHeaderStyle);
			textheader.createCell(9).setCellStyle(topHeaderStyle);
			textheader.createCell(10).setCellStyle(topHeaderStyle);
			textheader.createCell(11).setCellStyle(topHeaderStyle);
			textheader.createCell(12).setCellStyle(topHeaderStyle);
			textheader.createCell(13).setCellStyle(topHeaderStyle);
			textheader.createCell(14).setCellStyle(topHeaderStyle);
			textheader.createCell(15).setCellStyle(topHeaderStyle);

			// Middle header
			Row middleheader = sheet.createRow(rowCount++);
			middleheader.createCell(0).setCellValue("The List of Expired Facilites for " + entry.getKey());
			middleheader.getCell(0).setCellStyle(topHeaderStyle);
			middleheader.createCell(1).setCellStyle(topHeaderStyle);
			middleheader.createCell(2).setCellStyle(topHeaderStyle);
			middleheader.createCell(3).setCellStyle(topHeaderStyle);
			middleheader.createCell(4).setCellStyle(topHeaderStyle);
			middleheader.createCell(5).setCellStyle(topHeaderStyle);
			middleheader.createCell(6).setCellStyle(topHeaderStyle);
			middleheader.createCell(7).setCellStyle(topHeaderStyle);
			middleheader.createCell(8).setCellStyle(topHeaderStyle);
			middleheader.createCell(9).setCellStyle(topHeaderStyle);
			middleheader.createCell(10).setCellStyle(topHeaderStyle);
			middleheader.createCell(11).setCellStyle(topHeaderStyle);
			middleheader.createCell(12).setCellStyle(topHeaderStyle);
			middleheader.createCell(13).setCellStyle(topHeaderStyle);
			middleheader.createCell(14).setCellStyle(topHeaderStyle);
			middleheader.createCell(15).setCellStyle(topHeaderStyle);

			// Creating header
			Row header = sheet.createRow(rowCount++);
			header.createCell(0).setCellValue("Corporation Name");
			header.getCell(0).setCellStyle(middleHeaderStyle);
			header.createCell(1).setCellValue("Facilility Name");
			header.getCell(1).setCellStyle(middleHeaderStyle);
			header.createCell(2).setCellValue("First Name");
			header.getCell(2).setCellStyle(middleHeaderStyle);
			header.createCell(3).setCellValue("Middle Name");
			header.getCell(3).setCellStyle(middleHeaderStyle);
			header.createCell(4).setCellValue("Last Name");
			header.getCell(4).setCellStyle(middleHeaderStyle);
			header.createCell(5).setCellValue("Mailing Address1");
			header.getCell(5).setCellStyle(middleHeaderStyle);
			header.createCell(6).setCellValue("Mailing Address2");
			header.getCell(6).setCellStyle(middleHeaderStyle);
			header.createCell(7).setCellValue("City");
			header.getCell(7).setCellStyle(middleHeaderStyle);
			header.createCell(8).setCellValue("State");
			header.getCell(8).setCellStyle(middleHeaderStyle);
			header.createCell(9).setCellValue("Zip");
			header.getCell(9).setCellStyle(middleHeaderStyle);
			header.createCell(10).setCellValue("Phone");
			header.getCell(10).setCellStyle(middleHeaderStyle);
			header.createCell(11).setCellValue("License No");
			header.getCell(11).setCellStyle(middleHeaderStyle);
			header.createCell(12).setCellValue("Issue Date");
			header.getCell(12).setCellStyle(middleHeaderStyle);
			header.createCell(13).setCellValue("Expire Date");
			header.getCell(13).setCellStyle(middleHeaderStyle);
			header.createCell(14).setCellValue("Fax");
			header.getCell(14).setCellStyle(middleHeaderStyle);
			header.createCell(15).setCellValue("E-mail");
			header.getCell(15).setCellStyle(middleHeaderStyle);

			// Creating Body


			for (ExpiredFacList expiredFacObject : expiredFacLists) {
				System.out.println("Object :" + expiredFacObject);
				Row userRow = sheet.createRow(rowCount++);
				userRow.createCell(0).setCellValue(expiredFacObject.getCorpName());
				userRow.createCell(1).setCellValue(expiredFacObject.getFacName());
				userRow.createCell(2).setCellValue(expiredFacObject.getC_first());
				userRow.createCell(3).setCellValue(expiredFacObject.getC_middle());
				userRow.createCell(4).setCellValue(expiredFacObject.getC_last());
				userRow.createCell(5).setCellValue(expiredFacObject.getFacAdd1());
				userRow.createCell(6).setCellValue(expiredFacObject.getFacAdd2());
				userRow.createCell(7).setCellValue(expiredFacObject.getFacCity());
				userRow.createCell(8).setCellValue(expiredFacObject.getFacState());
				userRow.createCell(9).setCellValue(expiredFacObject.getFacZip());
				userRow.createCell(10).setCellValue(expiredFacObject.getFacPhone());
				userRow.createCell(11).setCellValue(expiredFacObject.getRegLicense());
				userRow.createCell(12).setCellValue(format2.format(format1.parse(expiredFacObject.getDateIssue())));
				userRow.createCell(13).setCellValue(format2.format(format1.parse(expiredFacObject.getDateExpire())));
				userRow.createCell(14).setCellValue(expiredFacObject.getFacFax());
				userRow.createCell(15).setCellValue(expiredFacObject.getFacEmail());

			}
			// Empty Row
			sheet.createRow(rowCount++);
		}

		writeExcelFile(workbook, EXPIRED_FACILITIES_FILE_NAME);

	}

	public void createActiveFacilitiesReportXlsxSheet(Map<String, List<ExpiredFacList>> map)
			throws IOException, ParseException {

		XSSFWorkbook workbook = new XSSFWorkbook();
		for (Map.Entry<String, List<ExpiredFacList>> entry : map.entrySet()) {
			List<ExpiredFacList> expiredFacLists = entry.getValue();
			String sheetName = entry.getKey();
			sheetName = sheetName.replaceAll("[\\W]", "");
			XSSFSheet sheet = workbook.createSheet(sheetName);
			sheet.setDefaultColumnWidth(15);
			// create style for header cells
			CellStyle topHeaderStyle = workbook.createCellStyle();
			Font topheaderFont = workbook.createFont();
			topheaderFont.setFontName("Arial");
			topHeaderStyle.setFillForegroundColor(HSSFColor.DARK_TEAL.index);
			topHeaderStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			topheaderFont.setBold(true);
			topheaderFont.setColor(HSSFColor.WHITE.index);
			topHeaderStyle.setFont(topheaderFont);
			int rowCount = 0;

			// create style for middle header
			CellStyle middleHeaderStyle = workbook.createCellStyle();
			Font font = workbook.createFont();
			font.setFontName("Arial");
			middleHeaderStyle.setFillForegroundColor(HSSFColor.AQUA.index);
			middleHeaderStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			font.setBold(true);
			font.setColor(HSSFColor.WHITE.index);
			middleHeaderStyle.setFont(font);

			// Text header
			Row textheader = sheet.createRow(rowCount++);
			textheader.createCell(0).setCellStyle(topHeaderStyle);
			textheader.createCell(1).setCellStyle(topHeaderStyle);
			textheader.createCell(2).setCellStyle(topHeaderStyle);
			textheader.createCell(3).setCellValue("Active Facility Report");
			textheader.getCell(3).setCellStyle(topHeaderStyle);
			textheader.createCell(4).setCellStyle(topHeaderStyle);
			textheader.createCell(5).setCellStyle(topHeaderStyle);
			textheader.createCell(6).setCellStyle(topHeaderStyle);
			textheader.createCell(7).setCellStyle(topHeaderStyle);
			textheader.createCell(8).setCellStyle(topHeaderStyle);
			textheader.createCell(9).setCellStyle(topHeaderStyle);
			textheader.createCell(10).setCellStyle(topHeaderStyle);
			textheader.createCell(11).setCellStyle(topHeaderStyle);
			textheader.createCell(12).setCellStyle(topHeaderStyle);
			textheader.createCell(13).setCellStyle(topHeaderStyle);
			textheader.createCell(14).setCellStyle(topHeaderStyle);
			textheader.createCell(15).setCellStyle(topHeaderStyle);

			// Middle header
			Row middleheader = sheet.createRow(rowCount++);
			middleheader.createCell(0).setCellValue("The List of Active Facilities for" + entry.getKey());
			middleheader.getCell(0).setCellStyle(topHeaderStyle);
			middleheader.createCell(1).setCellStyle(topHeaderStyle);
			middleheader.createCell(2).setCellStyle(topHeaderStyle);
			middleheader.createCell(3).setCellStyle(topHeaderStyle);
			middleheader.createCell(4).setCellStyle(topHeaderStyle);
			middleheader.createCell(5).setCellStyle(topHeaderStyle);
			middleheader.createCell(6).setCellStyle(topHeaderStyle);
			middleheader.createCell(7).setCellStyle(topHeaderStyle);
			middleheader.createCell(8).setCellStyle(topHeaderStyle);
			middleheader.createCell(9).setCellStyle(topHeaderStyle);
			middleheader.createCell(10).setCellStyle(topHeaderStyle);
			middleheader.createCell(11).setCellStyle(topHeaderStyle);
			middleheader.createCell(12).setCellStyle(topHeaderStyle);
			middleheader.createCell(13).setCellStyle(topHeaderStyle);
			middleheader.createCell(14).setCellStyle(topHeaderStyle);
			middleheader.createCell(15).setCellStyle(topHeaderStyle);

			// Creating header
			Row header = sheet.createRow(rowCount++);
			header.createCell(0).setCellValue("Corporation Name");
			header.getCell(0).setCellStyle(middleHeaderStyle);
			header.createCell(1).setCellValue("Facilility Name");
			header.getCell(1).setCellStyle(middleHeaderStyle);
			header.createCell(2).setCellValue("First Name");
			header.getCell(2).setCellStyle(middleHeaderStyle);
			header.createCell(3).setCellValue("Middle Name");
			header.getCell(3).setCellStyle(middleHeaderStyle);
			header.createCell(4).setCellValue("Last Name");
			header.getCell(4).setCellStyle(middleHeaderStyle);
			header.createCell(5).setCellValue("Mailing Address1");
			header.getCell(5).setCellStyle(middleHeaderStyle);
			header.createCell(6).setCellValue("Mailing Address2");
			header.getCell(6).setCellStyle(middleHeaderStyle);
			header.createCell(7).setCellValue("City");
			header.getCell(7).setCellStyle(middleHeaderStyle);
			header.createCell(8).setCellValue("State");
			header.getCell(8).setCellStyle(middleHeaderStyle);
			header.createCell(9).setCellValue("Zip");
			header.getCell(9).setCellStyle(middleHeaderStyle);
			header.createCell(10).setCellValue("Phone");
			header.getCell(10).setCellStyle(middleHeaderStyle);
			header.createCell(11).setCellValue("License No");
			header.getCell(11).setCellStyle(middleHeaderStyle);
			header.createCell(12).setCellValue("Issue Date");
			header.getCell(12).setCellStyle(middleHeaderStyle);
			header.createCell(13).setCellValue("Expire Date");
			header.getCell(13).setCellStyle(middleHeaderStyle);
			header.createCell(14).setCellValue("Fax");
			header.getCell(14).setCellStyle(middleHeaderStyle);
			header.createCell(15).setCellValue("E-mail");
			header.getCell(15).setCellStyle(middleHeaderStyle);

			// Creating Body

			for (ExpiredFacList expiredFacObject : expiredFacLists) {
				Row userRow = sheet.createRow(rowCount++);
				int cellCount = 0;
				userRow.createCell(cellCount++).setCellValue(expiredFacObject.getCorpName());
				userRow.createCell(cellCount++).setCellValue(expiredFacObject.getFacName());
				userRow.createCell(cellCount++).setCellValue(expiredFacObject.getC_first());
				userRow.createCell(cellCount++).setCellValue(expiredFacObject.getC_middle());
				userRow.createCell(cellCount++).setCellValue(expiredFacObject.getC_last());
				userRow.createCell(cellCount++).setCellValue(expiredFacObject.getFacAdd1());
				userRow.createCell(cellCount++).setCellValue(expiredFacObject.getFacAdd2());
				userRow.createCell(cellCount++).setCellValue(expiredFacObject.getFacCity());
				userRow.createCell(cellCount++).setCellValue(expiredFacObject.getFacState());
				userRow.createCell(cellCount++).setCellValue(expiredFacObject.getFacZip());
				userRow.createCell(cellCount++).setCellValue(expiredFacObject.getFacPhone());
				userRow.createCell(cellCount++).setCellValue(expiredFacObject.getRegLicense());
				userRow.createCell(cellCount++).setCellValue(format2.format(format1.parse(expiredFacObject.getDateIssue())));
				userRow.createCell(cellCount++).setCellValue(format2.format(format1.parse(expiredFacObject.getDateExpire())));
				userRow.createCell(cellCount++).setCellValue(expiredFacObject.getFacFax());
				userRow.createCell(cellCount++).setCellValue(expiredFacObject.getFacEmail());
			}
			// Empty Row
			sheet.createRow(rowCount++);
		}
		writeExcelFile(workbook, ACTIVE_FACILITIES_FILE_NAME);
	}

	public void createEpiredRegistrationXlsxSheet(Map<String, List<ExpiredFacList>> map, String startDate)
			throws IOException, ParseException {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat("MM/dd/yyyy");
		Date inputDate = format1.parse(startDate);
		startDate = format2.format(inputDate);

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet1 = workbook.createSheet("Overall totals");
		sheet1.setDefaultColumnWidth(15);
		int rowCount1 = 0;
		Row textheader1 = sheet1.createRow(rowCount1++);
		textheader1.createCell(0).setCellValue("Facilities with ACTIVE status, but expired on or prior to " + startDate
				+ " for the following categories");
		Row middleheader1 = sheet1.createRow(rowCount1++);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		String todaysDate = sdf.format(date);
		middleheader1.createCell(0).setCellValue("Report run on : " + todaysDate);
		sheet1.createRow(rowCount1++);
		for (Map.Entry<String, List<ExpiredFacList>> entry : map.entrySet()) {
			Row contentRow = sheet1.createRow(rowCount1++);
			String sheetName = entry.getKey();
			sheetName = sheetName.replaceAll("[\\W]", "");
			contentRow.createCell(0).setCellValue(sheetName);
			contentRow.createCell(1).setCellValue(entry.getValue().size());
		}

		for (Map.Entry<String, List<ExpiredFacList>> entry : map.entrySet()) {

			List<ExpiredFacList> expiredFacList = entry.getValue();
			String sheetName = entry.getKey();
			sheetName = sheetName.replaceAll("[\\W]", "");
			XSSFSheet sheet = workbook.createSheet(sheetName);
			sheet.setDefaultColumnWidth(15);

			// create style for header cells
			CellStyle topHeaderStyle = workbook.createCellStyle();
			Font topheaderFont = workbook.createFont();
			topheaderFont.setFontName("Arial");
			topHeaderStyle.setFillForegroundColor(HSSFColor.DARK_TEAL.index);
			topHeaderStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			topheaderFont.setBold(true);
			topheaderFont.setColor(HSSFColor.WHITE.index);
			topHeaderStyle.setFont(topheaderFont);
			int rowCount = 0;

			// create style for middle header
			CellStyle middleHeaderStyle = workbook.createCellStyle();
			Font font = workbook.createFont();
			font.setFontName("Arial");
			middleHeaderStyle.setFillForegroundColor(HSSFColor.AQUA.index);
			middleHeaderStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			middleHeaderStyle.setAlignment(HorizontalAlignment.CENTER);
			font.setBold(true);
			font.setColor(HSSFColor.WHITE.index);
			middleHeaderStyle.setFont(font);

			// Text header
			Row textheader = sheet.createRow(rowCount++);
			textheader.createCell(0).setCellStyle(topHeaderStyle);
			textheader.createCell(1).setCellStyle(topHeaderStyle);
			textheader.createCell(2).setCellStyle(topHeaderStyle);
			textheader.createCell(3).setCellValue("Expired Registrations with Active Status Report");
			textheader.getCell(3).setCellStyle(topHeaderStyle);
			textheader.createCell(4).setCellStyle(topHeaderStyle);
			textheader.createCell(5).setCellStyle(topHeaderStyle);
			textheader.createCell(6).setCellStyle(topHeaderStyle);
			textheader.createCell(7).setCellStyle(topHeaderStyle);
			textheader.createCell(8).setCellStyle(topHeaderStyle);
			textheader.createCell(9).setCellStyle(topHeaderStyle);
			textheader.createCell(10).setCellStyle(topHeaderStyle);
			textheader.createCell(11).setCellStyle(topHeaderStyle);
			textheader.createCell(12).setCellStyle(topHeaderStyle);
			textheader.createCell(13).setCellStyle(topHeaderStyle);
			textheader.createCell(14).setCellStyle(topHeaderStyle);
			textheader.createCell(15).setCellStyle(topHeaderStyle);

			// Middle header
			Row middleheader = sheet.createRow(rowCount++);
			middleheader.createCell(0).setCellValue("The List of Facilities with ACTIVE status but expired on prior to "
					+ startDate + " for " + entry.getKey());
			middleheader.getCell(0).setCellStyle(topHeaderStyle);
			middleheader.createCell(1).setCellStyle(topHeaderStyle);
			middleheader.createCell(2).setCellStyle(topHeaderStyle);
			middleheader.createCell(3).setCellStyle(topHeaderStyle);
			middleheader.createCell(4).setCellStyle(topHeaderStyle);
			middleheader.createCell(5).setCellStyle(topHeaderStyle);
			middleheader.createCell(6).setCellStyle(topHeaderStyle);
			middleheader.createCell(7).setCellStyle(topHeaderStyle);
			middleheader.createCell(8).setCellStyle(topHeaderStyle);
			middleheader.createCell(9).setCellStyle(topHeaderStyle);
			middleheader.createCell(10).setCellStyle(topHeaderStyle);
			middleheader.createCell(11).setCellStyle(topHeaderStyle);
			middleheader.createCell(12).setCellStyle(topHeaderStyle);
			middleheader.createCell(13).setCellStyle(topHeaderStyle);
			middleheader.createCell(14).setCellStyle(topHeaderStyle);
			middleheader.createCell(15).setCellStyle(topHeaderStyle);

			// Creating header
			Row header = sheet.createRow(rowCount++);
			header.createCell(0).setCellValue("Corporation Name");
			header.getCell(0).setCellStyle(middleHeaderStyle);
			header.createCell(1).setCellValue("Mailing Address1");
			header.getCell(1).setCellStyle(middleHeaderStyle);
			header.createCell(2).setCellValue("Mailing Address2");
			header.getCell(2).setCellStyle(middleHeaderStyle);
			header.createCell(3).setCellValue("City");
			header.getCell(3).setCellStyle(middleHeaderStyle);
			header.createCell(4).setCellValue("Expire Date");
			header.getCell(4).setCellStyle(middleHeaderStyle);
			header.createCell(5).setCellValue("Phone");
			header.getCell(5).setCellStyle(middleHeaderStyle);
			header.createCell(6).setCellValue("License number");
			header.getCell(6).setCellStyle(middleHeaderStyle);

			/*
			 * header.createCell(6).setCellValue("Mailing Address2");
			 * header.getCell(6).setCellStyle(middleHeaderStyle);
			 * 
			 * header.createCell(7).setCellValue("City");
			 * header.getCell(7).setCellStyle(middleHeaderStyle);
			 * 
			 * header.createCell(8).setCellValue("State");
			 * header.getCell(8).setCellStyle(middleHeaderStyle);
			 * 
			 * header.createCell(9).setCellValue("Zip");
			 * header.getCell(9).setCellStyle(middleHeaderStyle);
			 * 
			 * header.createCell(10).setCellValue("Phone");
			 * header.getCell(10).setCellStyle(middleHeaderStyle);
			 * 
			 * header.createCell(11).setCellValue("License No");
			 * header.getCell(11).setCellStyle(middleHeaderStyle);
			 * 
			 * header.createCell(12).setCellValue("Issue Date");
			 * header.getCell(12).setCellStyle(middleHeaderStyle);
			 * 
			 * header.createCell(13).setCellValue("Expire Date");
			 * header.getCell(13).setCellStyle(middleHeaderStyle);
			 * 
			 * header.createCell(14).setCellValue("Fax");
			 * header.getCell(14).setCellStyle(middleHeaderStyle);
			 * 
			 * header.createCell(15).setCellValue("E-mail");
			 * header.getCell(15).setCellStyle(middleHeaderStyle);
			 */

			// Creating Body

			for (ExpiredFacList expiredFacObject : expiredFacList) {
				Row userRow = sheet.createRow(rowCount++);
				userRow.createCell(0).setCellValue(expiredFacObject.getCorpName());
				userRow.createCell(1).setCellValue(expiredFacObject.getFacAdd1());
				userRow.createCell(2).setCellValue(expiredFacObject.getFacAdd2());
				userRow.createCell(3).setCellValue(expiredFacObject.getFacCity());
				userRow.createCell(4).setCellValue(format2.format(format1.parse(expiredFacObject.getDateExpire())));
				userRow.createCell(5).setCellValue(expiredFacObject.getFacPhone());
				userRow.createCell(6).setCellValue(expiredFacObject.getRegLicense());

				/*
				 * userRow.createCell(6).setCellValue(receiptOfFeesRevised.getFacAdd2());
				 * userRow.createCell(7).setCellValue(receiptOfFeesRevised.getFacCity());
				 * userRow.createCell(8).setCellValue(receiptOfFeesRevised.getFacState());
				 * userRow.createCell(9).setCellValue(receiptOfFeesRevised.getFacZip());
				 * userRow.createCell(10).setCellValue(receiptOfFeesRevised.getFacPhone());
				 * userRow.createCell(11).setCellValue(receiptOfFeesRevised.getRegLicense());
				 * userRow.createCell(12).setCellValue(receiptOfFeesRevised.getDateIssue());
				 * 
				 * userRow.createCell(13).setCellValue(receiptOfFeesRevised.getDateExpire());
				 * userRow.createCell(14).setCellValue(receiptOfFeesRevised.getFacFax());
				 * userRow.createCell(15).setCellValue(receiptOfFeesRevised.getFacEmail());
				 */

			}
			// Empty Row
			sheet.createRow(rowCount++);
		}

		writeExcelFile(workbook, EXPIRED_REGISTRAION_FILE_NAME);
	}

	/*
	 * public void createFiscalReportPivotXlsxSheet(List<FiscalReport> dataList,
	 * String acctname, String startDate, String endDate) throws IOException,
	 * ParseException {
	 * 
	 * 
	 * Map<String, FiscalReport > sortedData = new HashMap<String, FiscalReport>();
	 * 
	 * for(FiscalReport fiscalReport : dataList){
	 * sortedData.put(fiscalReport.getMnt(), fiscalReport); }
	 * 
	 * log.debug("sorted.keySet()  "+sortedData.keySet()); List<String> sortedlist =
	 * monthYearSorter.doSort(sortedData.keySet());
	 * 
	 * XSSFWorkbook workbook = new XSSFWorkbook(); XSSFSheet sheet =
	 * workbook.createSheet("Fiscal Report"); sheet.setDefaultColumnWidth(30);
	 * 
	 * // create style for Top header cells CellStyle topHeaderStyle =
	 * workbook.createCellStyle(); Font topheaderFont = workbook.createFont();
	 * topheaderFont.setFontName("Arial");
	 * topHeaderStyle.setFillForegroundColor(HSSFColor.DARK_TEAL.index);
	 * topHeaderStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	 * topheaderFont.setBold(true); topheaderFont.setColor(HSSFColor.WHITE.index);
	 * topHeaderStyle.setFont(topheaderFont);
	 * 
	 * // create style for header cells CellStyle style =
	 * workbook.createCellStyle(); Font font = workbook.createFont();
	 * font.setFontName("Arial");
	 * style.setFillForegroundColor(HSSFColor.AQUA.index);
	 * style.setFillPattern(FillPatternType.SOLID_FOREGROUND); font.setBold(true);
	 * font.setColor(HSSFColor.WHITE.index); style.setFont(font);
	 * 
	 * int rowCount = 0;
	 * 
	 * 
	 * //Create Top header Row Row textHeader = sheet.createRow(rowCount++);
	 * textHeader.createCell(0).setCellValue("License issued for ");
	 * textHeader.getCell(0).setCellStyle(topHeaderStyle);
	 * textHeader.createCell(1).setCellValue(acctname);
	 * textHeader.getCell(1).setCellStyle(topHeaderStyle);
	 * textHeader.createCell(2).setCellValue(" between "+startDate);
	 * textHeader.getCell(2).setCellStyle(topHeaderStyle);
	 * textHeader.createCell(3).setCellValue(" and "+endDate);
	 * textHeader.getCell(3).setCellStyle(topHeaderStyle);
	 * 
	 * //Create header Row Row header = sheet.createRow(rowCount++);
	 * 
	 * //Create Body Row1 Row bodyHeader1 = sheet.createRow(rowCount++);
	 * 
	 * //Create Body Row2 Row bodyHeader2 = sheet.createRow(rowCount++);
	 * 
	 * int colCount = 0; header.createCell(colCount).setCellValue("Month");
	 * header.getCell(colCount).setCellStyle(style);
	 * bodyHeader1.createCell(colCount).setCellValue("Sum Of Amount");
	 * bodyHeader1.getCell(colCount).setCellStyle(style);
	 * bodyHeader2.createCell(colCount).setCellValue("Count");
	 * bodyHeader2.getCell(colCount).setCellStyle(style); colCount++;
	 * 
	 * for(String key : sortedlist){ FiscalReport fiscalReport =
	 * sortedData.get(key);
	 * header.createCell(colCount).setCellValue(fiscalReport.getMnt());
	 * header.getCell(colCount).setCellStyle(style);
	 * bodyHeader1.createCell(colCount).setCellValue(fiscalReport.getAmountsum());
	 * bodyHeader2.createCell(colCount).setCellValue(fiscalReport.getCount());
	 * colCount++; }
	 * 
	 * writeExcelFile(workbook, FISCAL_FILE_NAME); }
	 */

	

	public void createFiscalReportPivotXlsxSheet(List<FiscalReport> dataList, List<String> acctNames, String startDate, String endDate)
			throws IOException, ParseException {

		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat("MM-dd-yyyy");
		Date inputDate1 = format1.parse(startDate);
		startDate = format2.format(inputDate1);

		Date inputDate2 = format1.parse(endDate);
		endDate = format2.format(inputDate2);

		XSSFWorkbook workbook = new XSSFWorkbook();

			Map<String, FiscalReport> sortedData = new HashMap<String, FiscalReport>();
			// System.out.println("****************************dataList : "+dataList);
			for (FiscalReport fiscalReport : dataList) {
				sortedData.put(fiscalReport.getMnt(), fiscalReport);
			}

			log.debug("sorted.keySet()  " + sortedData.keySet());
			List<String> sortedlist = monthYearSorter.doSort(sortedData.keySet());

			XSSFSheet sheet = workbook.createSheet("Fiscal Report");
			sheet.setDefaultColumnWidth(15);

			// create style for Top header cells
			CellStyle topHeaderStyle = workbook.createCellStyle();
			Font topheaderFont = workbook.createFont();
			topheaderFont.setFontName("Arial");
			topHeaderStyle.setFillForegroundColor(HSSFColor.DARK_TEAL.index);
			topHeaderStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			topheaderFont.setBold(true);
			topheaderFont.setColor(HSSFColor.WHITE.index);
			topHeaderStyle.setFont(topheaderFont);

			// create style for header cells
			CellStyle style = workbook.createCellStyle();
			Font font = workbook.createFont();
			font.setFontName("Arial");
			style.setFillForegroundColor(HSSFColor.AQUA.index);
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			font.setBold(true);
			font.setColor(HSSFColor.WHITE.index);
			style.setFont(font);

			int rowCount = 0;

			// Create Top header Row
			Row textHeader = sheet.createRow(rowCount++);
			textHeader.createCell(0).setCellValue("License issued for ");
			textHeader.getCell(0).setCellStyle(topHeaderStyle);
			textHeader.createCell(1).setCellValue(acctNames.toString());
			textHeader.getCell(1).setCellStyle(topHeaderStyle);
			textHeader.createCell(2).setCellValue(" between " + startDate);
			textHeader.getCell(2).setCellStyle(topHeaderStyle);
			textHeader.createCell(3).setCellValue(" and " + endDate);
			textHeader.getCell(3).setCellStyle(topHeaderStyle);

			// Create header Row
			Row header = sheet.createRow(rowCount++);

			// Create Body Row1
			Row bodyHeader1 = sheet.createRow(rowCount++);

			// Create Body Row2
			Row bodyHeader2 = sheet.createRow(rowCount++);

			int colCount = 0;
			header.createCell(colCount).setCellValue("Month");
			header.getCell(colCount).setCellStyle(style);
			bodyHeader1.createCell(colCount).setCellValue("Sum Of Amount");
			bodyHeader1.getCell(colCount).setCellStyle(style);
			bodyHeader2.createCell(colCount).setCellValue("Count");
			bodyHeader2.getCell(colCount).setCellStyle(style);
			colCount++;
			// System.out.println("*******sortedlist : "+sortedlist.size());
			// System.out.println("*******sortedlist : "+sortedlist);
			for (String key : sortedlist) {
				FiscalReport fiscalReport = sortedData.get(key);
				// System.out.println("*******fiscalReport : "+fiscalReport);
				header.createCell(colCount).setCellValue(fiscalReport.getMnt());
				header.getCell(colCount).setCellStyle(style);
				bodyHeader1.createCell(colCount).setCellValue(fiscalReport.getAmountsum());
				bodyHeader2.createCell(colCount).setCellValue(fiscalReport.getCount());
				colCount++;
			}
		
		writeExcelFile(workbook, FISCAL_FILE_NAME);
	}

	public void createFiscalReportPivotXlsxSheet(Map<String, List<FiscalReport>> map, String startDate, String endDate)
			throws IOException, ParseException {

		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat("MM-dd-yyyy");
		Date inputDate1 = format1.parse(startDate);
		startDate = format2.format(inputDate1);

		Date inputDate2 = format1.parse(endDate);
		endDate = format2.format(inputDate2);

		XSSFWorkbook workbook = new XSSFWorkbook();

		for (Map.Entry<String, List<FiscalReport>> entry : map.entrySet()) {
			Map<String, FiscalReport> sortedData = new HashMap<String, FiscalReport>();
			List<FiscalReport> dataList = entry.getValue();
			// System.out.println("****************************dataList : "+dataList);
			for (FiscalReport fiscalReport : dataList) {
				sortedData.put(fiscalReport.getMnt(), fiscalReport);
			}

			log.debug("sorted.keySet()  " + sortedData.keySet());
			List<String> sortedlist = monthYearSorter.doSort(sortedData.keySet());

			String sheetName = entry.getKey().replaceAll("[\\W]", "");
			XSSFSheet sheet = workbook.createSheet(sheetName);
			sheet.setDefaultColumnWidth(15);

			// create style for Top header cells
			CellStyle topHeaderStyle = workbook.createCellStyle();
			Font topheaderFont = workbook.createFont();
			topheaderFont.setFontName("Arial");
			topHeaderStyle.setFillForegroundColor(HSSFColor.DARK_TEAL.index);
			topHeaderStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			topheaderFont.setBold(true);
			topheaderFont.setColor(HSSFColor.WHITE.index);
			topHeaderStyle.setFont(topheaderFont);

			// create style for header cells
			CellStyle style = workbook.createCellStyle();
			Font font = workbook.createFont();
			font.setFontName("Arial");
			style.setFillForegroundColor(HSSFColor.AQUA.index);
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			font.setBold(true);
			font.setColor(HSSFColor.WHITE.index);
			style.setFont(font);

			int rowCount = 0;

			// Create Top header Row
			Row textHeader = sheet.createRow(rowCount++);
			textHeader.createCell(0).setCellValue("License issued for ");
			textHeader.getCell(0).setCellStyle(topHeaderStyle);
			textHeader.createCell(1).setCellValue(entry.getKey());
			textHeader.getCell(1).setCellStyle(topHeaderStyle);
			textHeader.createCell(2).setCellValue(" between " + startDate);
			textHeader.getCell(2).setCellStyle(topHeaderStyle);
			textHeader.createCell(3).setCellValue(" and " + endDate);
			textHeader.getCell(3).setCellStyle(topHeaderStyle);

			// Create header Row
			Row header = sheet.createRow(rowCount++);

			// Create Body Row1
			Row bodyHeader1 = sheet.createRow(rowCount++);

			// Create Body Row2
			Row bodyHeader2 = sheet.createRow(rowCount++);

			int colCount = 0;
			header.createCell(colCount).setCellValue("Month");
			header.getCell(colCount).setCellStyle(style);
			bodyHeader1.createCell(colCount).setCellValue("Sum Of Amount");
			bodyHeader1.getCell(colCount).setCellStyle(style);
			bodyHeader2.createCell(colCount).setCellValue("Count");
			bodyHeader2.getCell(colCount).setCellStyle(style);
			colCount++;
			// System.out.println("*******sortedlist : "+sortedlist.size());
			// System.out.println("*******sortedlist : "+sortedlist);
			for (String key : sortedlist) {
				FiscalReport fiscalReport = sortedData.get(key);
				// System.out.println("*******fiscalReport : "+fiscalReport);
				header.createCell(colCount).setCellValue(fiscalReport.getMnt());
				header.getCell(colCount).setCellStyle(style);
				bodyHeader1.createCell(colCount).setCellValue(fiscalReport.getAmountsum());
				bodyHeader2.createCell(colCount).setCellValue(fiscalReport.getCount());
				colCount++;
			}
		}
		writeExcelFile(workbook, FISCAL_FILE_NAME);
	}

	
	
	
	
	
	
	public void createFiscalReportPivotOneSheet(Map<String, List<FiscalReport>> map, String startDate, String endDate, YearMonth yearMonthStart, YearMonth yearMonthEnd)
			throws IOException, ParseException {

		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat("MM-dd-yyyy");
		Date inputDate1 = format1.parse(startDate);
		startDate = format2.format(inputDate1);

		Date inputDate2 = format1.parse(endDate);
		endDate = format2.format(inputDate2);

		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet("FiscalReport");
		sheet.setDefaultColumnWidth(15);
		
		
		// create style for Top header cells
		CellStyle topHeaderStyle = workbook.createCellStyle();
		Font topheaderFont = workbook.createFont();
		topheaderFont.setFontName("Arial");
		topHeaderStyle.setFillForegroundColor(HSSFColor.DARK_TEAL.index);
		topHeaderStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		topheaderFont.setBold(true);
		topheaderFont.setColor(HSSFColor.WHITE.index);
		topHeaderStyle.setFont(topheaderFont);

		// create style for header cells
		CellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontName("Arial");
		style.setFillForegroundColor(HSSFColor.AQUA.index);
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		font.setBold(true);
		font.setColor(HSSFColor.WHITE.index);
		style.setFont(font);
		
		
		
		
		
		int rowCount = 0;
		// Create Top header Row
		Row textHeader = sheet.createRow(rowCount++);
		textHeader.createCell(0).setCellValue("License issued Between ");
		textHeader.getCell(0).setCellStyle(topHeaderStyle);
		textHeader.createCell(1).setCellStyle(topHeaderStyle);
		textHeader.createCell(2).setCellValue(startDate);
		textHeader.getCell(2).setCellStyle(topHeaderStyle);
		textHeader.createCell(3).setCellValue(endDate);
		textHeader.getCell(3).setCellStyle(topHeaderStyle);
		
		
		for (Map.Entry<String, List<FiscalReport>> entry : map.entrySet()) {
			Map<String, FiscalReport> sortedData = new HashMap<String, FiscalReport>();
			List<FiscalReport> dataList = entry.getValue();
			// System.out.println("****************************dataList : "+dataList);
			for (FiscalReport fiscalReport : dataList) {
				sortedData.put(fiscalReport.getMnt(), fiscalReport);
			}

			log.debug("sorted.keySet()  " + sortedData.keySet());
			List<String> sortedlist = monthYearSorter.doSort(sortedData.keySet());
			YearMonth tempStart = yearMonthStart;
			/*String sheetName = entry.getKey().replaceAll("[\\W]", "");
			XSSFSheet sheet = workbook.createSheet(sheetName);
			sheet.setDefaultColumnWidth(15);
			log.debug("Creating Sheet fro  " + sheetName);*/
			

			// Create Top header Row
			Row textMidHeader = sheet.createRow(rowCount++);
			textMidHeader.createCell(0).setCellValue(entry.getKey());
			textMidHeader.getCell(0).setCellStyle(topHeaderStyle);
			textMidHeader.createCell(1).setCellStyle(topHeaderStyle);
			textMidHeader.createCell(2).setCellValue(startDate);
			textMidHeader.getCell(2).setCellStyle(topHeaderStyle);
			textMidHeader.createCell(3).setCellValue(endDate);
			textMidHeader.getCell(3).setCellStyle(topHeaderStyle);

			// Create header Row
			Row header = sheet.createRow(rowCount++);

			// Create Body Row1
			Row bodyHeader1 = sheet.createRow(rowCount++);

			// Create Body Row2
			Row bodyHeader2 = sheet.createRow(rowCount++);

			int colCount = 0;
			header.createCell(colCount).setCellValue("Month");
			header.getCell(colCount).setCellStyle(style);
			bodyHeader1.createCell(colCount).setCellValue("Sum Of Amount");
			bodyHeader1.getCell(colCount).setCellStyle(style);
			bodyHeader2.createCell(colCount).setCellValue("Count");
			bodyHeader2.getCell(colCount).setCellStyle(style);
			colCount++;
			// System.out.println("*******sortedlist : "+sortedlist.size());
			// System.out.println("*******sortedlist : "+sortedlist);
			//for (String key : sortedlist) {
			log.debug("yearMonthEnd "+yearMonthEnd);
			log.debug("yearMonthStart "+yearMonthStart);

			while (! tempStart.isAfter(yearMonthEnd)) {
				String yearMonth = tempStart.format(DateTimeFormatter.ofPattern("MMM yyyy"));
				log.debug("tempStart "+yearMonth);

				FiscalReport fiscalReport = sortedData.get(yearMonth);
                 String currentMonthStr = "";
				// System.out.println("*******fiscalReport : "+fiscalReport);
				if(fiscalReport ==null) {
				//YearMonth currentYearMonth = YearMonth.parse(fiscalReport.getMnt(),DateTimeFormatter.ofPattern("MMM yyyy"));
				//if (tempStart.compareTo(currentYearMonth) !=0  && tempStart.isBefore(yearMonthEnd)) {
					//String yearMonth = tempStart.format(DateTimeFormatter.ofPattern("MMM yyyy"));
					header.createCell(colCount).setCellValue(yearMonth);
					header.getCell(colCount).setCellStyle(style);
					bodyHeader1.createCell(colCount).setCellValue("0.00");
					bodyHeader2.createCell(colCount).setCellValue("0");
					colCount++;
					log.debug("Missing "+yearMonth);
				}
				else {
					header.createCell(colCount).setCellValue(fiscalReport.getMnt());
					header.getCell(colCount).setCellStyle(style);
					bodyHeader1.createCell(colCount).setCellValue(fiscalReport.getAmountsum());
					bodyHeader2.createCell(colCount).setCellValue(fiscalReport.getCount());
					colCount++;
				}
				tempStart = tempStart.plusMonths(1);
			}
			
			// Create Empty Row2
			Row emptyRow = sheet.createRow(rowCount++);
		}
		writeExcelFile(workbook, FISCAL_FILE_NAME);
	}
	
	
	/*
	 * public void createTrasmittalReportXlsxSheet(List<TransmittalReport> dataList,
	 * HttpResponse response ) throws IOException { createTrasmittalReportXlsxSheet(
	 * dataList ); }
	 */

	public XSSFWorkbook createNewSheet(String sheetname) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet(sheetname);
		sheet.setDefaultColumnWidth(15);
		return workbook;
	}

/*	public XSSFWorkbook createTrasmittalReportXlsxSheet(List<TransmittalReport> dataList) throws IOException {

		System.out.println("Creating Trasnmittal Report");

		// Creating Body

		double sum = 0;
		int rowCount = 1;
		int loopcount = 0;
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = null;
		String oldacctno = "";

		// create style for header cells
		CellStyle topHeaderStyle = workbook.createCellStyle();
		Font topheaderFont = workbook.createFont();
		topheaderFont.setFontName("Arial");
		topHeaderStyle.setFillForegroundColor(HSSFColor.DARK_TEAL.index);
		topHeaderStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		topheaderFont.setBold(true);
		topheaderFont.setColor(HSSFColor.WHITE.index);
		topHeaderStyle.setFont(topheaderFont);

		for (TransmittalReport transmittalReport : dataList) {
			String acctno = transmittalReport.getAcctno();

			// Loop count wil reset if the acct no changes
			if (!oldacctno.equals(acctno)) {
				loopcount = 0;
				oldacctno = acctno;
			}

			// Create a new sheet if the loopcount is 0
			if (loopcount++ == 0) {
				sheet = workbook.createSheet(acctno);
				sheet.setDefaultColumnWidth(30);
				// create style for header cells
				CellStyle style = workbook.createCellStyle();
				Font font = workbook.createFont();
				font.setFontName("Arial");
				style.setFillForegroundColor(HSSFColor.AQUA.index);
				style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				font.setBold(true);
				font.setColor(HSSFColor.WHITE.index);
				style.setFont(font);

				// Creating header
				Row header = sheet.createRow(0);
				header.createCell(0).setCellValue("Date Rec'd");
				header.getCell(0).setCellStyle(style);
				header.createCell(1).setCellValue("Revenue Source Code");
				header.getCell(1).setCellStyle(style);
				header.createCell(2).setCellValue("Org Code");
				header.getCell(2).setCellStyle(style);
				header.createCell(3).setCellValue("Check Number");
				header.getCell(3).setCellStyle(style);
				header.createCell(4).setCellValue("Name Of Payer");
				header.getCell(4).setCellStyle(style);
				header.createCell(5).setCellValue("Check Amount");
				header.getCell(5).setCellStyle(style);
			}

			Row userRow = sheet.createRow(rowCount++);
			userRow.createCell(0).setCellValue(transmittalReport.getDtreceive());
			userRow.createCell(1).setCellValue(transmittalReport.getAcctno());
			userRow.createCell(2).setCellValue("7300");
			userRow.createCell(3).setCellValue(transmittalReport.getChecknum());
			userRow.createCell(4).setCellValue(transmittalReport.getPayer());
			userRow.createCell(5).setCellValue(transmittalReport.getAmount());

			sum += Double.parseDouble(transmittalReport.getAmount());
		}

		if (sheet == null) {
			sheet = workbook.createSheet("Transmittal report");
			sheet.setDefaultColumnWidth(30);
			// create style for header cells
			CellStyle style = workbook.createCellStyle();
			Font font = workbook.createFont();
			font.setFontName("Arial");
			style.setFillForegroundColor(HSSFColor.AQUA.index);
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			font.setBold(true);
			font.setColor(HSSFColor.WHITE.index);
			style.setFont(font);

			Row header = sheet.createRow(0);
			header.createCell(0).setCellValue("Date Rec'd");
			header.getCell(0).setCellStyle(style);
			header.createCell(1).setCellValue("Revenue Source Code");
			header.getCell(1).setCellStyle(style);
			header.createCell(2).setCellValue("Org Code");
			header.getCell(2).setCellStyle(style);
			header.createCell(3).setCellValue("Check Number");
			header.getCell(3).setCellStyle(style);
			header.createCell(4).setCellValue("Name Of Payer");
			header.getCell(4).setCellStyle(style);
			header.createCell(5).setCellValue("Check Amount");
			header.getCell(5).setCellStyle(style);

		}
		// Empty Row
		sheet.createRow(rowCount++);

		Row userRow = sheet.createRow(rowCount++);
		userRow.createCell(0).setCellValue("");
		userRow.createCell(1).setCellValue("");
		userRow.createCell(2).setCellValue("Total Number Of Checks :");
		userRow.getCell(2).setCellStyle(topHeaderStyle);
		userRow.createCell(3).setCellValue(dataList.size());
		userRow.createCell(4).setCellValue("Total Amout:");
		userRow.getCell(4).setCellStyle(topHeaderStyle);
		userRow.createCell(5).setCellValue(sum);

		writeExcelFile(workbook, TRANSMITTAL_FILE_NAME);

		return workbook;

	}

*/	
	
	///Methods to create Different sheet for each accounts/revenuw source code. 
	public XSSFWorkbook createTrasmittalReportXlsxSheet(List<ReceiptOfFeesRevised> dataList) throws IOException {

		System.out.println("Creating Trasnmittal Report "+dataList.size());

		// Creating Body

		double overallSum = 0;
		int overallCheckCount = 0;
		
		double sum = 0;
		int checkCount = 0;
		int rowCount = 0;
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = null;

		// create style for header cells
		CellStyle topHeaderStyle = workbook.createCellStyle();
		Font topheaderFont = workbook.createFont();
		topheaderFont.setFontName("Arial");
		//topHeaderStyle.setFillForegroundColor(HSSFColor.BLACK.index);
		//topHeaderStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		topheaderFont.setBold(true);
		//topheaderFont.setColor(HSSFColor.WHITE.index);
		topHeaderStyle.setFont(topheaderFont);
		
		
		
		// create style for header cells
		CellStyle counterCellStyle = workbook.createCellStyle();
		Font counterFont = workbook.createFont();
		counterFont.setFontName("Arial");
		//counterCellStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		//counterCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		counterFont.setBold(true);
		//counterFont.setColor(HSSFColor.WHITE.index);
		counterCellStyle.setFont(counterFont);
		
		
		sheet = workbook.createSheet("Transmittal Report");
		sheet.setDefaultColumnWidth(15);
		// create style for header cells
		CellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontName("Arial");
		//style.setFillForegroundColor(HSSFColor.BLACK.index);
		//style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		font.setBold(true);
		//font.setColor(HSSFColor.WHITE.index);
		style.setFont(font);
		
		// Creating Super header
		Row superHeader = sheet.createRow(rowCount++);
		superHeader.createCell(0).setCellValue("Batch Number");
		superHeader.getCell(0).setCellStyle(style);
		superHeader.createCell(1).setCellValue("");
		superHeader.getCell(1).setCellStyle(style);
		superHeader.createCell(2).setCellValue("Receipt Date");
		superHeader.getCell(2).setCellStyle(style);
		superHeader.createCell(3).setCellValue("");
		superHeader.getCell(3).setCellStyle(style);
		superHeader.createCell(4).setCellValue("Org Code: 7300");
		superHeader.getCell(4).setCellStyle(style);
		superHeader.createCell(5).setCellStyle(style);
		


		// Creating header
		Row header = sheet.createRow(rowCount++);
		header.createCell(0).setCellValue("Date Rec'd");
		header.getCell(0).setCellStyle(style);
		
		header.createCell(1).setCellValue("Revenue Source Code");
		header.getCell(1).setCellStyle(style);
		header.createCell(2).setCellValue("Check Number");
		header.getCell(2).setCellStyle(style);
		header.createCell(3).setCellValue("Name Of Payer");
		header.getCell(3).setCellStyle(style);
		header.createCell(4).setCellValue("Check Amount");
		header.getCell(4).setCellStyle(style);
		header.createCell(5).setCellValue("Opened By");
		header.getCell(5).setCellStyle(style);

		String oldAccuntName = "";
		String newAcctName ="";
		int loopCount = 0;
		for (ReceiptOfFeesRevised receiptOfFeesRevised : dataList) {
				if(! "PROCESSED".equalsIgnoreCase(receiptOfFeesRevised.getStatus())) 
					  continue;

			if (loopCount++==0) {
			 newAcctName = receiptOfFeesRevised.getAccountNumber();
			 oldAccuntName = receiptOfFeesRevised.getAccountNumber();
			 
				Row userCountRow = sheet.createRow(rowCount++);
				userCountRow.createCell(0).setCellValue("Revenue Source Code");
				userCountRow.getCell(0).setCellStyle(topHeaderStyle);
				userCountRow.createCell(1).setCellStyle(topHeaderStyle);
				userCountRow.getCell(1).setCellValue(newAcctName);
				userCountRow.createCell(2).setCellStyle(topHeaderStyle);
				userCountRow.createCell(3).setCellStyle(topHeaderStyle);
				userCountRow.createCell(4).setCellStyle(topHeaderStyle);

			}
			else {
				newAcctName = receiptOfFeesRevised.getAccountNumber();
				
			}
			
		//	if("PROCESSED".equalsIgnoreCase(receiptOfFeesRevised.getStatus())) {
				overallSum+=Double.parseDouble(receiptOfFeesRevised.getAmount());
				overallCheckCount++;
		//	}
//			overallCheckCount=loopCount;

			
			log.debug("oldAccuntNo  "+oldAccuntName+" newAcctno "+newAcctName);
			if(!oldAccuntName.equals(newAcctName))
			{
		
				Row userCountRow = sheet.createRow(rowCount++);
				userCountRow.createCell(0).setCellValue("");
				//userCountRow.getCell(1).setCellStyle(topHeaderStyle);
				userCountRow.createCell(1).setCellValue("No Of Checks :");
				userCountRow.getCell(1).setCellStyle(counterCellStyle);
				userCountRow.createCell(2).setCellValue(String.valueOf(checkCount));
				userCountRow.getCell(2).setCellStyle(counterCellStyle);
				userCountRow.createCell(3).setCellValue("Total Amt:");
				userCountRow.getCell(3).setCellStyle(counterCellStyle);
				userCountRow.createCell(4).setCellValue(df.format(sum));
				userCountRow.getCell(4).setCellStyle(counterCellStyle);
				

				oldAccuntName=newAcctName;
				
				sum=0;
				checkCount=0;
				// Empty Row
				sheet.createRow(rowCount++);
				sheet.createRow(rowCount++);
				
				Row userMidheaderRow = sheet.createRow(rowCount++);
				userMidheaderRow.createCell(0).setCellValue("Revenue Source Code");
				userMidheaderRow.getCell(0).setCellStyle(topHeaderStyle);
				userMidheaderRow.createCell(1).setCellStyle(topHeaderStyle);
				userMidheaderRow.getCell(1).setCellValue(newAcctName);
				userMidheaderRow.createCell(2).setCellStyle(topHeaderStyle);
				userMidheaderRow.createCell(3).setCellStyle(topHeaderStyle);
				userMidheaderRow.createCell(4).setCellStyle(topHeaderStyle);
				userMidheaderRow.createCell(5).setCellStyle(topHeaderStyle);


			}
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyy");

			superHeader.getCell(1).setCellValue(receiptOfFeesRevised.getBatchNumber());
			superHeader.getCell(3).setCellValue(sdf.format(receiptOfFeesRevised.getReceiptFeeDate()));

			String date = sdf.format(receiptOfFeesRevised.getDateReceived());
			Row userRow = sheet.createRow(rowCount++);
			userRow.createCell(0).setCellValue(date);
			userRow.createCell(1).setCellValue(receiptOfFeesRevised.getAccountNumber());
			userRow.createCell(2).setCellValue(receiptOfFeesRevised.getCheckNumber());
			userRow.createCell(3).setCellValue(receiptOfFeesRevised.getPayer());
			userRow.createCell(4).setCellValue(receiptOfFeesRevised.getAmount());
			userRow.createCell(5).setCellValue(receiptOfFeesRevised.getOpenedBy());

		//	if("PROCESSED".equalsIgnoreCase(receiptOfFeesRevised.getStatus())) {
				sum += Double.parseDouble(receiptOfFeesRevised.getAmount());
				checkCount++;
			//}

			
		}
	
		Row userCountLastRow = sheet.createRow(rowCount++);
		userCountLastRow.createCell(0).setCellValue("");
		//userCountLastRow.getCell(0).setCellStyle(topHeaderStyle);
		userCountLastRow.createCell(1).setCellValue("No Of Checks :");
		userCountLastRow.getCell(1).setCellStyle(counterCellStyle);
		userCountLastRow.createCell(2).setCellValue(String.valueOf(checkCount));
		userCountLastRow.getCell(2).setCellStyle(counterCellStyle);
		userCountLastRow.createCell(3).setCellValue("Total Amt:");
		userCountLastRow.getCell(3).setCellStyle(counterCellStyle);
		userCountLastRow.createCell(4).setCellValue(df.format(sum));

		log.debug("new DecimalFormat(\".##\").format(sum)"+df.format(sum));
		userCountLastRow.getCell(4).setCellStyle(counterCellStyle);

		oldAccuntName=newAcctName;
		// Empty Row
		 sheet.createRow(rowCount++);
		 sheet.createRow(rowCount++);
		 
			Row userOverallCountLastRow = sheet.createRow(rowCount++);
			userOverallCountLastRow.createCell(0).setCellValue("");
			//userOverallCountLastRow.getCell(1).setCellStyle(topHeaderStyle);
			userOverallCountLastRow.createCell(1).setCellValue("Grand Total Of Checks :");
			userOverallCountLastRow.getCell(1).setCellStyle(topHeaderStyle);
			userOverallCountLastRow.createCell(2).setCellValue(String.valueOf(overallCheckCount));
			userOverallCountLastRow.getCell(2).setCellStyle(topHeaderStyle);
			userOverallCountLastRow.createCell(3).setCellValue("Grand Total Amout:");
			userOverallCountLastRow.getCell(3).setCellStyle(topHeaderStyle);
			userOverallCountLastRow.createCell(4).setCellValue(df.format(overallSum));
			userOverallCountLastRow.getCell(4).setCellStyle(topHeaderStyle);


		writeExcelFile(workbook, TRANSMITTAL_FILE_NAME);

		return workbook;

	}


	
		public XSSFWorkbook createTrasmittalReportXlsxSheetDiffSheet(List<ReceiptOfFeesRevised> dataList) throws IOException {

			System.out.println("Creating Trasnmittal Report "+dataList.size());

			// Creating Body

			double sum = 0;
			int rowCount = 1;
			int loopcount = 0;
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = null;
			String oldacctno = "";

			// create style for header cells
			CellStyle topHeaderStyle = workbook.createCellStyle();
			Font topheaderFont = workbook.createFont();
			topheaderFont.setFontName("Arial");
			topHeaderStyle.setFillForegroundColor(HSSFColor.DARK_TEAL.index);
			topHeaderStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			topheaderFont.setBold(true);
			topheaderFont.setColor(HSSFColor.WHITE.index);
			topHeaderStyle.setFont(topheaderFont);

			for (ReceiptOfFeesRevised receiptOfFeesRevised : dataList) {
				String acctno = receiptOfFeesRevised.getAccountNumber();

				// Loop count wil reset if the acct no changes
				if (!oldacctno.equals(acctno)) {
					loopcount = 0;
					oldacctno = acctno;
				}

				// Create a new sheet if the loopcount is 0
				if (loopcount++ == 0) {
					sheet = workbook.createSheet(acctno);
					sheet.setDefaultColumnWidth(15);
					// create style for header cells
					CellStyle style = workbook.createCellStyle();
					Font font = workbook.createFont();
					font.setFontName("Arial");
					style.setFillForegroundColor(HSSFColor.BLACK.index);
					style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
					font.setBold(true);
					font.setColor(HSSFColor.WHITE.index);
					style.setFont(font);

					// Creating header
					Row header = sheet.createRow(0);
					header.createCell(0).setCellValue("Date Rec'd");
					header.getCell(0).setCellStyle(style);
					header.createCell(1).setCellValue("Revenue Source Code");
					header.getCell(1).setCellStyle(style);
					header.createCell(2).setCellValue("Org Code");
					header.getCell(2).setCellStyle(style);
					header.createCell(3).setCellValue("Check Number");
					header.getCell(3).setCellStyle(style);
					header.createCell(4).setCellValue("Name Of Payer");
					header.getCell(4).setCellStyle(style);
					header.createCell(5).setCellValue("Check Amount");
					header.getCell(5).setCellStyle(style);
				}

				Row userRow = sheet.createRow(rowCount++);
				userRow.createCell(0).setCellValue(receiptOfFeesRevised.getDateReceived());
				userRow.createCell(1).setCellValue(receiptOfFeesRevised.getAccountNumber());
				userRow.createCell(2).setCellValue("7300");
				userRow.createCell(3).setCellValue(receiptOfFeesRevised.getCheckNumber());
				userRow.createCell(4).setCellValue(receiptOfFeesRevised.getPayer());
				userRow.createCell(5).setCellValue(receiptOfFeesRevised.getAmount());

				sum += Double.parseDouble(receiptOfFeesRevised.getAmount());
			}

			if (sheet == null) {
				sheet = workbook.createSheet("Transmittal report");
				sheet.setDefaultColumnWidth(30);
				// create style for header cells
				CellStyle style = workbook.createCellStyle();
				Font font = workbook.createFont();
				font.setFontName("Arial");
				style.setFillForegroundColor(HSSFColor.BLACK.index);
				style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				font.setBold(true);
				font.setColor(HSSFColor.WHITE.index);
				style.setFont(font);

				Row header = sheet.createRow(0);
				header.createCell(0).setCellValue("Date Rec'd");
				header.getCell(0).setCellStyle(style);
				header.createCell(1).setCellValue("Revenue Source Code");
				header.getCell(1).setCellStyle(style);
				header.createCell(2).setCellValue("Org Code");
				header.getCell(2).setCellStyle(style);
				header.createCell(3).setCellValue("Check Number");
				header.getCell(3).setCellStyle(style);
				header.createCell(4).setCellValue("Name Of Payer");
				header.getCell(4).setCellStyle(style);
				header.createCell(5).setCellValue("Check Amount");
				header.getCell(5).setCellStyle(style);

			}
			// Empty Row
			sheet.createRow(rowCount++);

			Row userRow = sheet.createRow(rowCount++);
			userRow.createCell(0).setCellValue("");
			userRow.createCell(1).setCellValue("");
			userRow.createCell(2).setCellValue("Total Number Of Checks :");
			userRow.getCell(2).setCellStyle(topHeaderStyle);
			userRow.createCell(3).setCellValue(dataList.size());
			userRow.createCell(4).setCellValue("Total Amout:");
			userRow.getCell(4).setCellStyle(topHeaderStyle);
			userRow.createCell(5).setCellValue(sum);

			writeExcelFile(workbook, TRANSMITTAL_FILE_NAME);

			return workbook;

		}

	
	
	
	public void createRctfeeReportXlsxSheet(List<RctFeeReport> dataList, List<ReceiptOfFeesRevised> rctfeeList,
			String batchNum, String accountNo, String recieptFeeDate) throws IOException, ParseException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("RctFee Report");
		sheet.setDefaultColumnWidth(15);

		// create style for header cells
		CellStyle topHeaderStyle = workbook.createCellStyle();
		Font topheaderFont = workbook.createFont();
		topheaderFont.setFontName("Arial");
		//topHeaderStyle.setFillForegroundColor(HSSFColor.BLACK.index);
		//topHeaderStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		topheaderFont.setBold(true);
		//topheaderFont.setColor(HSSFColor.WHITE.index);
		topHeaderStyle.setFont(topheaderFont);
		int rowCount = 0;

		// create style for middle header
		CellStyle middleHeaderStyle = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontName("Arial");
		//middleHeaderStyle.setFillForegroundColor(HSSFColor.BLACK.index);
		//middleHeaderStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		font.setBold(true);
		//font.setColor(HSSFColor.WHITE.index);
		middleHeaderStyle.setFont(font);

		// Text header
		Row textheader = sheet.createRow(rowCount++);
		textheader.createCell(0).setCellValue("Receipt of Fees batch Assignment");
		textheader.getCell(0).setCellStyle(topHeaderStyle);
		textheader.createCell(1).setCellStyle(topHeaderStyle);
		textheader.createCell(2).setCellStyle(topHeaderStyle);
		textheader.createCell(3).setCellValue("Department Of Public Health");
		textheader.getCell(3).setCellStyle(topHeaderStyle);
		textheader.createCell(4).setCellStyle(topHeaderStyle);
		textheader.createCell(5).setCellStyle(topHeaderStyle);
		textheader.createCell(6).setCellStyle(topHeaderStyle);
		textheader.createCell(7).setCellStyle(topHeaderStyle);


		// Middle header
		Row middleheader = sheet.createRow(rowCount++);
		middleheader.createCell(0).setCellValue("Batch No :"); 
		middleheader.getCell(0).setCellStyle(topHeaderStyle);
		middleheader.createCell(1).setCellValue(batchNum);
		middleheader.getCell(1).setCellStyle(topHeaderStyle);

		middleheader.createCell(2).setCellValue("");
		middleheader.getCell(2).setCellStyle(topHeaderStyle);
		middleheader.createCell(3).setCellValue("");
		middleheader.getCell(3).setCellStyle(topHeaderStyle);
		SimpleDateFormat sdfio = new SimpleDateFormat("yyy-MM-dd");

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyy");
		log.debug("sdfio.parse(recieptFeeDate)"+sdfio.parse(recieptFeeDate));
		String date = sdf.format(sdfio.parse(recieptFeeDate));
		log.debug("sdf.format(sdfio.parse(recieptFeeDate))"+date);
		
		middleheader.createCell(4).setCellValue("Receipt Date : ");
		middleheader.getCell(4).setCellStyle(topHeaderStyle);
		middleheader.createCell(5).setCellValue(date);
		middleheader.getCell(5).setCellStyle(topHeaderStyle);
		middleheader.createCell(6).setCellValue("");
		middleheader.getCell(6).setCellStyle(topHeaderStyle);
		middleheader.createCell(7).setCellStyle(middleHeaderStyle);



		// Creating header
		Row header = sheet.createRow(rowCount++);
		header.createCell(0).setCellValue("Check No");
		header.getCell(0).setCellStyle(middleHeaderStyle);
		header.createCell(1).setCellValue("Applicant");
		header.getCell(1).setCellStyle(middleHeaderStyle);
		header.createCell(2).setCellValue("Payer");
		header.getCell(2).setCellStyle(middleHeaderStyle);
		header.createCell(3).setCellValue("Status");
		header.getCell(3).setCellStyle(middleHeaderStyle);
		header.createCell(4).setCellValue("Amount");
		header.getCell(4).setCellStyle(middleHeaderStyle);
		header.createCell(5).setCellValue("Revenue Source Code");
		header.getCell(5).setCellStyle(middleHeaderStyle);
		header.createCell(6).setCellValue("Comments" );
		header.getCell(6).setCellStyle(middleHeaderStyle);
		header.createCell(7).setCellValue("Opened By" );
		header.getCell(7).setCellStyle(middleHeaderStyle);

		// Creating Body

		double sum = 0;
		int cellCount = 1;

		for (ReceiptOfFeesRevised receiptOfFeesRevised : rctfeeList) {
			Row userRow = sheet.createRow(rowCount++);
			userRow.createCell(0).setCellValue(receiptOfFeesRevised.getCheckNumber());
			userRow.createCell(1).setCellValue(receiptOfFeesRevised.getApplicant());
			userRow.createCell(2).setCellValue(receiptOfFeesRevised.getPayer());
			userRow.createCell(3).setCellValue(receiptOfFeesRevised.getStatus());
			userRow.createCell(4).setCellValue(receiptOfFeesRevised.getAmount());
			userRow.createCell(5).setCellValue(receiptOfFeesRevised.getAccountNumber());
			userRow.createCell(6).setCellValue(receiptOfFeesRevised.getCommentOntheFacility());
			userRow.createCell(7).setCellValue(receiptOfFeesRevised.getOpenedBy());

			//middleheader.getCell(5).setCellValue(receiptOfFeesRevised.getReceiptFeeDate().toString());
			sum += Double.parseDouble(receiptOfFeesRevised.getAmount());
		}

		// Empty Row
		sheet.createRow(rowCount++);
		sheet.createRow(rowCount++);

		Row reportheader = sheet.createRow(rowCount++);
		reportheader.createCell(0).setCellValue("");
		reportheader.createCell(1).setCellValue("");
		reportheader.createCell(2).setCellValue("Batch Totals");
		reportheader.getCell(2).setCellStyle(middleHeaderStyle);
		reportheader.createCell(3).setCellValue("Current Status");
		reportheader.getCell(3).setCellStyle(middleHeaderStyle);
		reportheader.createCell(4).setCellValue("Payment");
		reportheader.getCell(4).setCellStyle(middleHeaderStyle);
		reportheader.createCell(5).setCellValue("No of Checks");
		reportheader.getCell(5).setCellStyle(middleHeaderStyle);

		double amountsum = 0;
		int checkCount = 0;

		Map<String, RctFeeReport> rctStatusMapping = dataList.stream().collect(Collectors.toMap(RctFeeReport::getStatus, v -> v));
		rctStatusMapping.putIfAbsent("RETURNED",new RctFeeReport("RETURNED", "0", "0"));
		rctStatusMapping.putIfAbsent("RECEIVED",new RctFeeReport("RECEIVED", "0", "0"));
		rctStatusMapping.putIfAbsent("APPROVED",new RctFeeReport("APPROVED", "0", "0"));
		rctStatusMapping.putIfAbsent("PROCESSED",new RctFeeReport("PROCESSED", "0", "0"));
		rctStatusMapping.putIfAbsent("REPLACEMENT CHECK",new RctFeeReport("REPLACEMENT CHECK", "0", "0"));

		for (RctFeeReport rctFeeReport : rctStatusMapping.values()) {
			
			Row dataRow = sheet.createRow(rowCount++);
			dataRow.createCell(0).setCellValue("");
			dataRow.createCell(1).setCellValue("");
			dataRow.createCell(2).setCellValue("");
			dataRow.createCell(3).setCellValue(rctFeeReport.getStatus());
			dataRow.createCell(4).setCellValue(rctFeeReport.getAmountsum());
			dataRow.createCell(5).setCellValue(rctFeeReport.getStatuscnt());

			if("RECEIVED".equalsIgnoreCase(rctFeeReport.getStatus().trim()) ||  "PROCESSED".equalsIgnoreCase(rctFeeReport.getStatus().trim())) {
				
				log.debug("equals " + rctFeeReport.getStatus());
				amountsum += Double.parseDouble(rctFeeReport.getAmountsum());
				checkCount += Double.parseDouble(rctFeeReport.getStatuscnt());
			}
		}
		
		Row totalRow = sheet.createRow(rowCount++);
		totalRow.createCell(0).setCellValue("");
		totalRow.createCell(1).setCellValue("");
		totalRow.createCell(2).setCellValue("");
		totalRow.createCell(3).setCellValue("Grand Total");
		totalRow.getCell(3).setCellStyle(middleHeaderStyle);
		totalRow.createCell(4).setCellValue(df.format(amountsum));
		totalRow.getCell(4).setCellStyle(middleHeaderStyle);
		totalRow.createCell(5).setCellValue(String.valueOf(checkCount));
		totalRow.getCell(5).setCellStyle(middleHeaderStyle);

		writeExcelFile(workbook, RCTFEE_FILE_NAME);

	}

	public void createExpiredFacilitiesReport() {

	}

	public void writeExcelFile(XSSFWorkbook workbook, String fileName) throws IOException {

		log.debug("Writing File " + path + fileName);

		FileOutputStream outputStream = new FileOutputStream(path + fileName);
		workbook.write(outputStream);
		workbook.close();

	}

	public void createReportForFacilitiesRegView(Facilities facility, FoodProcesorInfo foodProcesorInfo,
			Registration registration, Corporation corp, Fclass fclass, List<Transaction> transactions)
			throws IOException, ParseException {

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("FacilityDetails");
		sheet.setDefaultColumnWidth(15);

		// create style for header cells
		CellStyle topHeaderStyle = workbook.createCellStyle();
		Font topheaderFont = workbook.createFont();
		topheaderFont.setFontName("Arial");
		topHeaderStyle.setFillForegroundColor(HSSFColor.DARK_TEAL.index);
		topHeaderStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		topheaderFont.setBold(true);
		topheaderFont.setColor(HSSFColor.WHITE.index);
		topHeaderStyle.setFont(topheaderFont);
		int rowCount = 0;

		// create style for middle header
		CellStyle middleHeaderStyle = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontName("Arial");
		middleHeaderStyle.setFillForegroundColor(HSSFColor.AQUA.index);
		middleHeaderStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		font.setBold(true);
		font.setColor(HSSFColor.WHITE.index);
		middleHeaderStyle.setFont(font);

		Row corpTitle = sheet.createRow(rowCount++);
		corpTitle.createCell(0).setCellValue("Corporation Details");
		corpTitle.getCell(0).setCellStyle(topHeaderStyle);

		Row corpheader = sheet.createRow(rowCount++);
		corpheader.createCell(0).setCellValue("Corporation Name");
		corpheader.getCell(0).setCellStyle(middleHeaderStyle);
		corpheader.createCell(1).setCellValue("Address Line 1");
		corpheader.getCell(1).setCellStyle(middleHeaderStyle);
		corpheader.createCell(2).setCellValue("Address Line 2");
		corpheader.getCell(2).setCellStyle(middleHeaderStyle);
		corpheader.createCell(3).setCellValue("City");
		corpheader.getCell(3).setCellStyle(middleHeaderStyle);
		corpheader.createCell(4).setCellValue("State");
		corpheader.getCell(4).setCellStyle(middleHeaderStyle);
		corpheader.createCell(5).setCellValue("Country Name");
		corpheader.getCell(5).setCellStyle(middleHeaderStyle);
		corpheader.createCell(6).setCellValue("Zip");
		corpheader.getCell(6).setCellStyle(middleHeaderStyle);
		corpheader.createCell(7).setCellValue("Last Name");
		corpheader.getCell(7).setCellStyle(middleHeaderStyle);
		corpheader.createCell(8).setCellValue("First Name");
		corpheader.getCell(8).setCellStyle(middleHeaderStyle);
		corpheader.createCell(9).setCellValue("Middle Name");
		corpheader.getCell(9).setCellStyle(middleHeaderStyle);
		corpheader.createCell(10).setCellValue("Sufix");
		corpheader.getCell(10).setCellStyle(middleHeaderStyle);
		corpheader.createCell(11).setCellValue("Title");
		corpheader.getCell(11).setCellStyle(middleHeaderStyle);
		corpheader.createCell(12).setCellValue("Parent Corporation Comments");
		corpheader.getCell(12).setCellStyle(middleHeaderStyle);
		corpheader.createCell(13).setCellValue("Phone");
		corpheader.getCell(13).setCellStyle(middleHeaderStyle);
		corpheader.createCell(14).setCellValue("Phone Ext");
		corpheader.getCell(14).setCellStyle(middleHeaderStyle);
		corpheader.createCell(15).setCellValue("Email Address");
		corpheader.getCell(15).setCellStyle(middleHeaderStyle);

		Row corpRow = sheet.createRow(rowCount++);
		if (corp != null) {
			corpRow.createCell(0).setCellValue(corp.getCorpName());
			corpRow.createCell(1).setCellValue(corp.getcMailadd1());
			corpRow.createCell(2).setCellValue(corp.getcMailadd2());
			corpRow.createCell(3).setCellValue(corp.getcMailcity());
			corpRow.createCell(4).setCellValue(corp.getcMailstate());
			corpRow.createCell(5).setCellValue(corp.getCorpCountry());
			corpRow.createCell(6).setCellValue(corp.getcMailzip());
			corpRow.createCell(7).setCellValue(corp.getcLast());
			corpRow.createCell(8).setCellValue(corp.getcFirst());
			corpRow.createCell(9).setCellValue(corp.getcMiddle());
			corpRow.createCell(10).setCellValue(corp.getcSuffix());
			corpRow.createCell(11).setCellValue(corp.getcTitle());
			corpRow.createCell(12).setCellValue(corp.getcComments());
			corpRow.createCell(13).setCellValue(corp.getCorpPhone());
			corpRow.createCell(14).setCellValue(corp.getCorpPhoneExt());
			corpRow.createCell(15).setCellValue(corp.getCorpEmail());
		}
		// Empty Row
		sheet.createRow(rowCount++);

		Row facTitle = sheet.createRow(rowCount++);
		facTitle.createCell(0).setCellValue("Facility Details");
		facTitle.getCell(0).setCellStyle(topHeaderStyle);

		Row facheader = sheet.createRow(rowCount++);
		facheader.createCell(0).setCellValue("Facility Name");
		facheader.getCell(0).setCellStyle(middleHeaderStyle);
		facheader.createCell(1).setCellValue("Facility Type");
		facheader.getCell(1).setCellStyle(middleHeaderStyle);
		facheader.createCell(2).setCellValue("Inspection Date");
		facheader.getCell(2).setCellStyle(middleHeaderStyle);
		facheader.createCell(3).setCellValue("Facility Status");
		facheader.getCell(3).setCellStyle(middleHeaderStyle);
		facheader.createCell(4).setCellValue("Address Line 1");
		facheader.getCell(4).setCellStyle(middleHeaderStyle);
		facheader.createCell(5).setCellValue("Address Line 2");
		facheader.getCell(5).setCellStyle(middleHeaderStyle);
		facheader.createCell(6).setCellValue("City");
		facheader.getCell(6).setCellStyle(middleHeaderStyle);
		facheader.createCell(7).setCellValue("State");
		facheader.getCell(7).setCellStyle(middleHeaderStyle);
		facheader.createCell(8).setCellValue("Zip");
		facheader.getCell(8).setCellStyle(middleHeaderStyle);
		facheader.createCell(9).setCellValue("Country Name");
		facheader.getCell(9).setCellStyle(middleHeaderStyle);
		facheader.createCell(10).setCellValue("Phone");
		facheader.getCell(10).setCellStyle(middleHeaderStyle);
		facheader.createCell(11).setCellValue("Phone Ext");
		facheader.getCell(11).setCellStyle(middleHeaderStyle);
		facheader.createCell(12).setCellValue("Emergency Phone");
		facheader.getCell(12).setCellStyle(middleHeaderStyle);
		facheader.createCell(13).setCellValue("Fax");
		facheader.getCell(13).setCellStyle(middleHeaderStyle);
		facheader.createCell(14).setCellValue("Email");
		facheader.getCell(14).setCellStyle(middleHeaderStyle);
		facheader.createCell(15).setCellValue("Facility Comments");
		facheader.getCell(15).setCellStyle(middleHeaderStyle);

		Row facRow = sheet.createRow(rowCount++);
		if (facility != null) {
			facRow.createCell(0).setCellValue(facility.getFacilityName());
			facRow.createCell(1).setCellValue(facility.getFacType());
			System.out.println("Insp date : " + facility.getInspectionCompletedDate());
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
			if (facility.getInspectionCompletedDate() != null) {
				String inspDate = sdf.format(facility.getInspectionCompletedDate());
				System.out.println("String Insp date : " + inspDate);

				facRow.createCell(2).setCellValue(inspDate);
			} else {
				facRow.createCell(2).setCellValue("");
			}

			facRow.createCell(3).setCellValue(facility.getFacilityStatus());
			facRow.createCell(4).setCellValue(facility.getFacilityAddress1());
			facRow.createCell(5).setCellValue(facility.getFacilityAddress2());
			facRow.createCell(6).setCellValue(facility.getFacilityCity());
			facRow.createCell(7).setCellValue(facility.getFacilityState());
			facRow.createCell(8).setCellValue(facility.getFacilityZip());
			facRow.createCell(9).setCellValue(facility.getFacilityCNT());
			facRow.createCell(10).setCellValue(facility.getFacilityPhone());
			facRow.createCell(11).setCellValue(facility.getPhoneExt());
			facRow.createCell(12).setCellValue(facility.getEmergencyPhone());
			facRow.createCell(13).setCellValue(facility.getFacilityFax());
			facRow.createCell(14).setCellValue(facility.getFacilityEmail());
			facRow.createCell(15).setCellValue(facility.getFacilityComments());
		}
		sheet.createRow(rowCount++);

		Row foodTitle = sheet.createRow(rowCount++);
		foodTitle.createCell(0).setCellValue("FoodProcessor Info");
		foodTitle.getCell(0).setCellStyle(topHeaderStyle);

		Row foodheader = sheet.createRow(rowCount++);
		foodheader.createCell(0).setCellValue("Primary Operation");
		foodheader.getCell(0).setCellStyle(middleHeaderStyle);
		foodheader.createCell(1).setCellValue("Other Operation");
		foodheader.getCell(1).setCellStyle(middleHeaderStyle);
		foodheader.createCell(2).setCellValue("Type of Building");
		foodheader.getCell(2).setCellStyle(middleHeaderStyle);
		foodheader.createCell(3).setCellValue("Product Category1");
		foodheader.getCell(3).setCellStyle(middleHeaderStyle);
		foodheader.createCell(4).setCellValue("Product SubCategory1");
		foodheader.getCell(4).setCellStyle(middleHeaderStyle);
		foodheader.createCell(5).setCellValue("Product Category2");
		foodheader.getCell(5).setCellStyle(middleHeaderStyle);
		foodheader.createCell(6).setCellValue("Product SubCategory2");
		foodheader.getCell(6).setCellStyle(middleHeaderStyle);
		foodheader.createCell(7).setCellValue("Product Category3");
		foodheader.getCell(7).setCellStyle(middleHeaderStyle);
		foodheader.createCell(8).setCellValue("Product SubCategory3");
		foodheader.getCell(8).setCellStyle(middleHeaderStyle);
		foodheader.createCell(9).setCellValue("Product Category4");
		foodheader.getCell(9).setCellStyle(middleHeaderStyle);
		foodheader.createCell(10).setCellValue("Product SubCategory4");
		foodheader.getCell(10).setCellStyle(middleHeaderStyle);

		Row foodRow = sheet.createRow(rowCount++);
		if (foodProcesorInfo != null) {
			foodRow.createCell(0).setCellValue(foodProcesorInfo.getPrimaryop());
			foodRow.createCell(1).setCellValue(foodProcesorInfo.getSecondaryop());
			foodRow.createCell(2).setCellValue(foodProcesorInfo.getBuildingtype());
			foodRow.createCell(3).setCellValue(foodProcesorInfo.getProd_cat1());
			foodRow.createCell(4).setCellValue(foodProcesorInfo.getProd_sub_cat1());
			foodRow.createCell(5).setCellValue(foodProcesorInfo.getProd_cat2());
			foodRow.createCell(6).setCellValue(foodProcesorInfo.getProd_sub_cat2());
			foodRow.createCell(7).setCellValue(foodProcesorInfo.getProd_cat3());
			foodRow.createCell(8).setCellValue(foodProcesorInfo.getProd_sub_cat3());
			foodRow.createCell(9).setCellValue(foodProcesorInfo.getProd_cat4());
			foodRow.createCell(10).setCellValue(foodProcesorInfo.getProd_sub_cat4());
		}

		sheet.createRow(rowCount++);

		Row regTitle = sheet.createRow(rowCount++);
		regTitle.createCell(0).setCellValue("Registeration");
		regTitle.getCell(0).setCellStyle(topHeaderStyle);

		Row regheader = sheet.createRow(rowCount++);
		regheader.createCell(0).setCellValue("License Number");
		regheader.getCell(0).setCellStyle(middleHeaderStyle);
		regheader.createCell(1).setCellValue("Issue Date");
		regheader.getCell(1).setCellStyle(middleHeaderStyle);
		regheader.createCell(2).setCellValue("Expiration Date");
		regheader.getCell(2).setCellStyle(middleHeaderStyle);
		if (facility != null) {
			if (facility.getUrn() != null) {
				regheader.createCell(3).setCellValue("URN");
				regheader.getCell(3).setCellStyle(middleHeaderStyle);
			}
		}

		Row regRow = sheet.createRow(rowCount++);
		if (facility != null) {
			if (registration != null) {
				regRow.createCell(0).setCellValue(registration.getRegLicense());

				SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
				if (registration.getDateIssue() != null) {
					String issueDate = sdf.format(registration.getDateIssue());
					regRow.createCell(1).setCellValue(issueDate);
				} else {
					regRow.createCell(1).setCellValue("");
				}
				if (registration.getDateExpire() != null) {
					String expireDate = sdf.format(registration.getDateExpire());
					regRow.createCell(2).setCellValue(expireDate);
				} else {
					regRow.createCell(2).setCellValue("");
				}

			}
			if (facility.getUrn() != null) {
				System.out.println("URN ********************: " + facility.getUrn());
				regRow.createCell(3).setCellValue(facility.getUrn());
			}
		}

		sheet.createRow(rowCount++);
		Row tarnsTitle = sheet.createRow(rowCount++);
		tarnsTitle.createCell(0).setCellValue("Transactions");
		tarnsTitle.getCell(0).setCellStyle(topHeaderStyle);

		Row transheader = sheet.createRow(rowCount++);
		transheader.createCell(0).setCellValue("Certification Action");
		transheader.getCell(0).setCellStyle(middleHeaderStyle);
		transheader.createCell(1).setCellValue("Receipt");
		transheader.getCell(1).setCellStyle(middleHeaderStyle);
		transheader.createCell(2).setCellValue("Check No");
		transheader.getCell(2).setCellStyle(middleHeaderStyle);
		transheader.createCell(3).setCellValue("Amount");
		transheader.getCell(3).setCellStyle(middleHeaderStyle);
		transheader.createCell(4).setCellValue("User");
		transheader.getCell(4).setCellStyle(middleHeaderStyle);
		transheader.createCell(5).setCellValue("Entry");
		transheader.getCell(5).setCellStyle(middleHeaderStyle);

		if (transactions != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
			for (int i = 0; i < transactions.size(); i++) {
				Row transRow = sheet.createRow(rowCount++);
				transRow.createCell(0).setCellValue(transactions.get(i).getCertaction());
				if (transactions.get(i).getRcpfeedt() != null) {
					transRow.createCell(1).setCellValue(sdf.format(transactions.get(i).getRcpfeedt()));
				} else {
					transRow.createCell(1).setCellValue("");
				}
				transRow.createCell(2).setCellValue(transactions.get(i).getCheckno());
				transRow.createCell(3).setCellValue(transactions.get(i).getAmount());
				transRow.createCell(4).setCellValue(transactions.get(i).gettUserid());
				if (transactions.get(i).gettEntrytm() != null) {
					transRow.createCell(5).setCellValue(sdf.format(transactions.get(i).gettEntrytm()));
				} else {
					transRow.createCell(5).setCellValue("");
				}
			}
		}
		writeExcelFile(workbook, "FacilitiesReport.xlsx");
	}

}