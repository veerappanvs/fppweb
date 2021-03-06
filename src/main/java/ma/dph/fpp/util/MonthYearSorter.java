package ma.dph.fpp.util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

@Service
public class MonthYearSorter {

    private List<String> listOfMonthYears = new ArrayList<String>();
    private static final String USED_DATE_FORMAT = "dd MMM yyyy";
    SimpleDateFormat formatter = new SimpleDateFormat(USED_DATE_FORMAT);

   /* public void setUpMonthYearsList() {
        listOfMonthYears.add("12-2014");
        listOfMonthYears.add("11-2012");
        listOfMonthYears.add("5-2014");
        listOfMonthYears.add("8-2012");
    }*/
 
    public Date parseToDate(String monthYearString) throws ParseException {
        return formatter.parse("01 "+ monthYearString);
    }

    public List<String> doSort(Set<String>listOfMonthYears) throws ParseException {

        List<String> result = new ArrayList<String>();
        
        Set<Date> dates = new TreeSet<Date>(new MonthYearComparator());

        for (String monthYearStr: listOfMonthYears) {
        	
            dates.add(parseToDate(monthYearStr));

        }
        System.out.println("parsed dates "+dates);
        for (Object d: dates.toArray()) {

            result.add(formatter.format((Date)d).substring(3));
        }

        System.out.println("formatted result  -- "+result);
        return result;

    }

/*    public static void main(String[] args) throws ParseException {
        MonthYearSorter issueSolver = new MonthYearSorter();
        issueSolver.setUpMonthYearsList();
        issueSolver.doSort();
    }*/

}