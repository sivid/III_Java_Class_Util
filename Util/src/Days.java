import java.util.Calendar;
// import java.util.Date;
//import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Locale;
public class Days {
	public Days() {
	}

	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();
		/*
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH);
		int day = today.get(Calendar.DATE);
		int day_of_week = today.get(Calendar.DAY_OF_WEEK);
		int hour = today.get(Calendar.HOUR_OF_DAY);
		*/		
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日 hh時mm分ss秒 E", Locale.CHINA);
		System.out.println(df.format(today.getTime()));
		SimpleDateFormat df1 = new SimpleDateFormat("今天是yyyy/MM/dd");
		SimpleDateFormat df2 = new SimpleDateFormat("今天是E");
		System.out.println(df1.format(today.getTime()));
		System.out.println(df2.format(today.getTime()));
		SimpleDateFormat df3 = new SimpleDateFormat("時間是hh:mm");
		System.out.println(df3.format(today.getTime()));
		
		/*for manual formatting, we can use
		 *if (minute < 10) ? "0" + minute : minute
		 *and
		 *String[] weekdays = {"日,""一","二","三","四","五","六"};
		 *System.out.println("weekday is " + weekdays[day_of_week -1]);  
		 */
		
	}
}
