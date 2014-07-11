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

			System.out.println("----------�U�~��----------");
			System.out.println(" (1).�C�L���w�~���Τ��(���).");
			System.out.println(" (2).�C�L���w�~��(�~��).");
			System.out.println(" (0).���}.");
			System.out.println("�п�J�C�L�覡");
			read_data = Integer.parseInt(input_data.readLine());
			System.out.println("�A��ܪ��C�L�覡:" + read_data);
			switch (read_data) {
			case 1:
				tmp_year = true;
				tmp_month = true;
				do {
					System.out.println("�п�J�~��");
					year = Integer.parseInt(input_data.readLine());

					if (year > 0 & year <= 30000) {
						tmp_year = false;
					} else {
						System.out.println("�L�Ī��~��,�Э��s��J.");
					}
				} while (tmp_year);
				do {
					System.out.println("�п�J���(1-12)");
					month = Integer.parseInt(input_data.readLine());
					if (month > 0 & month < 13) {
						tmp_month = false;
					} else {
						System.out.println("�L�Ī����,�Э��s��J.");
					}
				} while (tmp_month);

				System.out.println("********�U�~��********");
				System.out.println(" �褸 " + year + " �~ " + month + " ���");
				thefirst_day = data.count_first_day(year, month);
				end_day = data.count_days(year, month);
				data.prical(thefirst_day, end_day);
				System.out.println(" ");
				break;
			case 2:
				tmp_year = true;
				do {
					System.out.println("�п�J�z�n�L�X���~��");
					year = Integer.parseInt(input_data.readLine());
					if (year > 0 & year <= 30000) {
						tmp_year = false;
					} else {
						System.out.println("�L�Ī��~��,�Э��s��J.");
					}
				} while (tmp_year);
				System.out.println("********�U�~��********");
				for (month = 1; month <= 12; month++) {
					System.out.println(" �褸 " + year + " �~ " + month + "���");
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
				System.out.println("�L�Ī���J�A�Э��s��ܦC�L��k...");
				break;
			}
		}
	}
}

class Date {
	/*
	 * �H�U���p��Ӧ~�Ӥ릳�X�Ѥ��Ƶ{���G�]��1752�~���e���|�~�@�|�A 1752�~�H���|�~�@�|�A�{�ʤ��|�A�ӥ|�ʤS�n�|�A�G�����H�U���p�C
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
	 * �H�U���p��Ĥ@�Ѭ��P���X���Ƶ{���G�����T�����G (1)1752�~8��H�e�A�Q�Φ褸1�~1��1�鬰�P�����A�ΰ����D�l���覡�A
	 * �@�@�ӭp��ҨD�~��Ĥ@�Ѭ��P���X�C (2)1752�~10���12��A�Q��1752�~10��1�鬰�P����A�ΰ����D�l���覡�A
	 * �@�@�ӭp��ҨD�~��Ĥ@�Ѭ��P���X�C (3)1753�~�H��A�Q��1753�~1��1�鬰�P���@�A�ΰ����D�l���覡�A�@�@�@�ӭp��ҨD�~��Ĥ@�Ѭ��P���X�C
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

	/* �����S�Ҥ��Ƶ{���A�ѩ�1752�~9��L3��13��A�G�g�@�M���B�z�Ӧ~�뤧�Ƶ{���C */
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
	 * �H�U���C�L��䤧�Ƶ{���G�ǥѸӤ�Ĥ@�ѬO�P���X�θӤ뤧�Ѽƨ� �M�w�p��C�L�C
	 */
	void prical(int first_day, int end_day) {
		int i, j;
		String s;
		System.out.println("��@�@�@�G�@�T�@�|�@���@���@");
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