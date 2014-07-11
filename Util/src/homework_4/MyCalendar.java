package homework_4;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MyCalendar {
	public MyCalendar() {
		// TODO Auto-generated constructor stub
	}

	public MyCalendar(int year, int month) { // January starts at 0, Sunday starts at 1
		Calendar inputCal = new GregorianCalendar(year, month - 1, 1);
		//java.util.Date inputDate = inputCal.getTime();
	    int lastDate = inputCal.getActualMaximum(Calendar.DATE);
	    int dayOfWeekOfFirstDay = inputCal.get(Calendar.DAY_OF_WEEK);
	    System.out.println("first day of this month is  " + dayOfWeekOfFirstDay);
	    System.out.println("last day of this month is " + lastDate);
	    
	    System.out.println("Sun Mon Tue Wed Thu Fri Sat");
	    for (int i = 1; i <= lastDate; i++){
	    	
	    }
		//inputCal.set(Calendar.DATE, lastDate);
	    //int lastDay = inputCal.get(Calendar.DAY_OF_WEEK);
	    //System.out.println("Last Date: " + inputCal.getTime());
	    //System.out.println("Last Day : " + lastDay);
		
		/*SimpleDateFormat df1 = new SimpleDateFormat("今天是yyyy/MM/dd");
		SimpleDateFormat df2 = new SimpleDateFormat("今天是E");
		System.out.println(df1.format(inputDate));
		System.out.println(df2.format(inputDate));
		*/
	}

	public static void main(String[] args) {
		if (args.length == 1) {
			int year = isValidYear(args[0]);
			if (year == -1){
				System.out.println("Please put in a valid year number");
				System.exit(0);
			}
			else{
				System.out.println("Why do you want to see me count from 1 to 12?");
				System.out.println("Year is " + year);
				System.out.println("1 2 3 4 5 6 7 8 9 10 11 12");
				System.exit(0);
			}
		} else if (args.length == 2){
			int year = isValidYear(args[0]);
			int month = isValidMonth(args[1]);
			if (year != -1 && month != -1){	// two correct input values
				//System.out.println("====");
				new MyCalendar(year, month);
			}else{
				System.out.println("Please put in two valid arguments");
				System.exit(0);
			}
		}else {
			System.out.println("please put one or two arguments");
			System.exit(0);
		}
	}

	static int isValidYear(String s){
		int year = 0;
		try {
			year = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return -1;
		}
		// only got here if we didn't return false
		if (year > 0 && year < 99999)
			return year;
		else
			return -1;
	}
	static int isValidMonth(String s){
		int month = 0;
		try {
			month = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return -1;
		}
		// only got here if we didn't return false
		if (month > 0 && month < 13)
			return month;
		else
			return -1;
	}
	
}
