package calendar.exam07;

import java.util.*;

//요구사항
//월을 입력하면 해당월의 달력을 출력한다.
//달력은 모양은 1단계에서 작성한 모양으로 만든다.
//1일은 일요일로 정해도 무방하다.
//-1을 입력받기 전까지 반복 입력받는다.
//프롬프트를 출력한다.

public class CalendarService {
	public void runPrompt() {
		Calendar cal = new Calendar();
		Scanner scanner = new Scanner(System.in);
		int month;
		int year;
		String week;
		
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
				} else if (year < 1 || year > 9999) {
					System.out.println("The value entered is a year that does not exist.\n");
					continue;
				}
			}
			
			//month변수 버그체크
			System.out.println("월을 입력하세요.(exit: -1)");
			System.out.print("MONTH: ");
			String strMonth = scanner.nextLine();
			if (strMonth.equals("")) {
				System.err.println("The value entered is a month that does not exist.\n");
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
			
			//week변수 버그체크
			System.out.println("첫번째 요일을 입력하세요. (SU, MO, TU, WE, TH, FR, SA / exit: Q)");
			System.out.print("WEEK: ");
			week = scanner.nextLine();
			if(cal.getWeek(week)==-1) {
				break;
			} else if (cal.getWeek(week)==-2) {
				System.out.println("The value entered is a week that does not exist.\n");
				continue;
			}
			cal.printCalendar(year, month, week);
		}
		System.out.println("Have a nice day!");
		scanner.close();

		
	}

	public static void main(String[] args) {
		CalendarService cs = new CalendarService();
		cs.runPrompt();
	}
}
		

