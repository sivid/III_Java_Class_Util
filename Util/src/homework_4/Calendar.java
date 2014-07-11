package homework_4;
import java.util.*;
import java.io.*;

public class Calendar {

	public static void main(String ags[]) throws IOException {
		BufferedReader input_data = new BufferedReader(new InputStreamReader(
				System.in));
		int read_data, year, month, thefirst_day = 0, end_day = 0;
		boolean check = true, tmp_year, tmp_month;
		Date data = new Date();

		while (check) {

			System.out.println("----------萬年曆----------");
			System.out.println(" (1).列印指定年份及月份(月曆).");
			System.out.println(" (2).列印指定年份(年曆).");
			System.out.println(" (0).離開.");
			System.out.println("請輸入列印方式");
			read_data = Integer.parseInt(input_data.readLine());
			System.out.println("你選擇的列印方式:" + read_data);
			switch (read_data) {
			case 1:
				tmp_year = true;
				tmp_month = true;
				do {
					System.out.println("請輸入年份");
					year = Integer.parseInt(input_data.readLine());

					if (year > 0 & year <= 30000) {
						tmp_year = false;
					} else {
						System.out.println("無效的年份,請重新輸入.");
					}
				} while (tmp_year);
				do {
					System.out.println("請輸入月份(1-12)");
					month = Integer.parseInt(input_data.readLine());
					if (month > 0 & month < 13) {
						tmp_month = false;
					} else {
						System.out.println("無效的月份,請重新輸入.");
					}
				} while (tmp_month);

				System.out.println("********萬年曆********");
				System.out.println(" 西元 " + year + " 年 " + month + " 月份");
				thefirst_day = data.count_first_day(year, month);
				end_day = data.count_days(year, month);
				data.prical(thefirst_day, end_day);
				System.out.println(" ");
				break;
			case 2:
				tmp_year = true;
				do {
					System.out.println("請輸入您要印出的年份");
					year = Integer.parseInt(input_data.readLine());
					if (year > 0 & year <= 30000) {
						tmp_year = false;
					} else {
						System.out.println("無效的年份,請重新輸入.");
					}
				} while (tmp_year);
				System.out.println("********萬年曆********");
				for (month = 1; month <= 12; month++) {
					System.out.println(" 西元 " + year + " 年 " + month + "月份");
					thefirst_day = data.count_first_day(year, month);
					end_day = data.count_days(year, month);
					data.prical(thefirst_day, end_day);
					System.out.println(" ");
				}
				break;

			case 0:
				System.out.println("This program will be exit...");
				check = false;
				break;
			default:
				System.out.println("無效的輸入，請重新選擇列印方法...");
				break;
			}
		}
	}
}

class Date {
	/*
	 * 以下為計算該年該月有幾天之副程式：因為1752年之前為四年一閏， 1752年以後位四年一閏，逢百不閏，而四百又要閏，故分為以下狀況。
	 */
	static int count_days(int year, int month) {
		int days;
		if (year <= 1752 && year % 4 == 0 && month == 2)
			days = 29;
		else if (year > 1752
				&& ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
				&& month == 2)
			days = 29;
		else if (month == 1 || month == 3 || month == 5 || month == 7
				|| month == 8 || month == 10 || month == 12)
			days = 31;
		else if (month == 4 || month == 6 || month == 9 || month == 11)
			days = 30;
		else
			days = 28;
		return (days);
	}

	/*
	 * 以下為計算第一天為星期幾之副程式：分為三部分： (1)1752年8月以前，利用西元1年1月1日為星期六，及除７求餘的方式，
	 * 　　來計算所求年月第一天為星期幾。 (2)1752年10月～12月，利用1752年10月1日為星期日，及除７求餘的方式，
	 * 　　來計算所求年月第一天為星期幾。 (3)1753年以後，利用1753年1月1日為星期一，及除７求餘的方式，　　　來計算所求年月第一天為星期幾。
	 */
	static int count_first_day(int year, int month) {
		int i, j, f_day = 0;
		if (year < 1752 || (year == 1752 && month <= 8)) {
			f_day = 6;
			for (i = 1; i < year; ++i) {
				if (i % 4 == 0)
					f_day = (f_day + 366 % 7) % 7;
				else
					f_day = (f_day + 365 % 7) % 7;
			}
			for (j = 1; j < month; ++j) {
				f_day = (f_day + count_days(year, j)) % 7;
			}
		} else if (year > 1752) {
			f_day = 1;
			for (i = 1753; i < year; ++i) {
				if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0)
					f_day = (f_day + 366 % 7) % 7;
				else
					f_day = (f_day + 365 % 7) % 7;
			}
			for (j = 1; j < month; ++j)
				f_day = (f_day + count_days(year, j)) % 7;
		} else if (year == 1752 && month >= 10) {
			f_day = 0;
			for (j = 10; j < month; ++j)
				f_day = (f_day + count_days(year, j)) % 7;
		}
		return (f_day);
	}

	/* 此為特例之副程式，由於1752年9月無3～13日，故寫一專門處理該年月之副程式。 */
	void special_program() {
		int counter, days, first_day, end_day;
		first_day = 2;
		end_day = 30;
		String s = "Sun\tMon\tTue\tWed\tThu\tFri\tSar\n";
		for (counter = 0; counter < first_day; ++counter)
			s += "\t";
		for (days = 1; days <= end_day; ++days) {
			s += Integer.toString(days) + "\t";
			if ((first_day + days) % 7 == 4 && days != 2)
				s += "\n";
			if (days == 2)
				days = 13;
		}

	}

	/*
	 * 以下為列印月曆之副程式：藉由該月第一天是星期幾及該月之天數來 決定如何列印。
	 */
	void prical(int first_day, int end_day) {
		int i, j;
		String s;
		System.out.println("日　一　二　三　四　五　六　");
		for (i = 0; i < first_day; ++i) {
			System.out.print(" ");
		}
		for (j = 1; j <= end_day; ++j) {
			if (j > 0 & j < 10) {
				System.out.print(j + " ");
			} else {
				System.out.print(j + " ");
			}
			if ((first_day + j) % 7 == 0)
				System.out.println(" ");
		}
		System.out.println(" ");
	}
}