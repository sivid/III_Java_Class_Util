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
		SimpleDateFormat df = new SimpleDateFormat("yyyy�~MM��dd�� hh��mm��ss�� E", Locale.CHINA);
		System.out.println(df.format(today.getTime()));
		SimpleDateFormat df1 = new SimpleDateFormat("���ѬOyyyy/MM/dd");
		SimpleDateFormat df2 = new SimpleDateFormat("���ѬOE");
		System.out.println(df1.format(today.getTime()));
		System.out.println(df2.format(today.getTime()));
		SimpleDateFormat df3 = new SimpleDateFormat("�ɶ��Ohh:mm");
		System.out.println(df3.format(today.getTime()));
		
		/*for manual formatting, we can use
		 *if (minute < 10) ? "0" + minute : minute
		 *and
		 *String[] weekdays = {"��,""�@","�G","�T","�|","��","��"};
		 *System.out.println("weekday is " + weekdays[day_of_week -1]);  
		 */
		
	}
}
