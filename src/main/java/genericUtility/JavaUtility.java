package genericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * This is an utility class which has functionalities present in Java library
 * @author QSP
 * @version 25-11-03
 */
public class JavaUtility {

	/**
	 * This is a generic method to fetch calendar details
	 * @param pattern
	 * @return
	 */
	public String getCalendarDetails(String pattern)
	{
		Calendar cal = Calendar.getInstance();
		Date d = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String value = sdf.format(d);
		return value;
	}
	
	/**
	 * This is a generic method to generate random number
	 * @param bound
	 * @return
	 */
	public int generateRandomNumber(int bound)
	{
		Random r = new Random();
		int num = r.nextInt(bound);
		return num;
	}
}
