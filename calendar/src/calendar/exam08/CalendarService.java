package calendar.exam08;

import java.util.*;

//년도와 월만 입력받는다.
//진짜 캘린더에서 나오는 달력과 똑같은 모양의 달력을 출력한다.
//추가적으로 입력받아야 하는 내용이 있는지 생각해 보자.

public class CalendarService {
	public void runPrompt() {
		Calendar cal = new Calendar();
		Scanner scanner = new Scanner(System.in);
		int month;
		int year;
		
		while(true) {
			//year변수 버그 체크
			System.out.println("연도를 입력하세요.(exit: -1)");
			System.out.print("YEAR: ");
			String strYear = scanner.nextLine();
			if (strYear.equals("")) {
				System.out.println("The value entered is a year that does not exist.\n");
				continue;
			} else {
				year = Integer.parseInt(strYear);
				if (year == -1) {
					break;
				} else if (year < 1899 || year > 9999) {
					System.out.println("The value entered is a year that does not exist.\n");
					continue;
				}
			}
			
			//month변수 버그체크
			System.out.println("월을 입력하세요.(exit: -1)");
			System.out.print("MONTH: ");
			String strMonth = scanner.nextLine();
			if (strMonth.equals("")) {
				System.out.println("The value entered is a month that does not exist.\n");
				continue;
			} else {
				month = Integer.parseInt(strMonth);
				if (month == -1) {
					break;
				} else if (month < 1 || month > 12) {
					System.out.println("The value entered is a month that does not exist.\n");
					continue;
				}
			}
			
			cal.printCalendar(year, month);
			
		}
		System.out.println("Have a nice day!");
		scanner.close();

		
	}

	public static void main(String[] args) {
		CalendarService cs = new CalendarService();
		cs.runPrompt();
	}
}
		

