package tutorial;

import java.util.GregorianCalendar;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {
    public static int generateRandom(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
    
    public static String getCurrentDatePart(){
    String date="";
     String month="";
 String day="";
 String year="";

GregorianCalendar gregorianCalendar=new GregorianCalendar();            
month=String.valueOf(gregorianCalendar.get(GregorianCalendar.MONTH));            
day=String.valueOf(gregorianCalendar.get(GregorianCalendar.DAY_OF_MONTH));
year=String.valueOf(gregorianCalendar.get(GregorianCalendar.YEAR));
    return date.concat(month).concat("/").concat(day).concat("/").concat(year);
}
}
