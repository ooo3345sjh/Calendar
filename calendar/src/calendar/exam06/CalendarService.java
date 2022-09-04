package calendar.exam06;

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
		
		while(true) {
			System.out.println("연도를 입력하세요.");
			System.out.print("YEAR: ");
			String str1 = scanner.nextLine();
			System.out.println("월을 입력하세요.");
			System.out.print("MONTH: ");
			String str2 = scanner.nextLine();
			
			if(str1.equals("") || str2.equals("") ) {
				System.out.println("값을 입력해주세요.\n");
				continue;
			}
			year = Integer.parseInt(str1);
			month = Integer.parseInt(str2);
			if(month == -1) {
				break;
			} else if (month<1 || month>12) {
					System.out.println("The value entered is a month that does not exist.\n");
					continue;
			}
			cal.printMonth(year, month);
		}
		System.out.println("Have a nice day!");
		scanner.close();

		
	}

	public static void main(String[] args) {
		CalendarService cs = new CalendarService();
		cs.runPrompt();
	}
}
		

