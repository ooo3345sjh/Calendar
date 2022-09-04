package calendar.exam09;

import java.util.*;

public class CalendarObject {
	
	public void printCalendar(int year, int month) {
		System.out.printf("    <<%d년%2d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("----------------------");

		Calendar date = Calendar.getInstance();
		date.clear();
		date.set(year, month-1, 1); // 년, 월, 일을 초기화한다.(월은 0부터 시작이므로, 원하는 월에서 -1을 빼주어야한다.
		
		int lastDayOfMonth = date.getActualMaximum(Calendar.DATE);//해당 월의 마지막 일을 알아낸다.
		int StartdayOfMontn = date.get(Calendar.DAY_OF_WEEK); //해당 월에 1일의 요일을 알아낸다.
		
		for (int i=1; i<StartdayOfMontn; i++) { //1일의 시작이 월요일이면 일은 공백이므로 2회 공백을 출력한다.
			System.out.print("   ");
		}
		
		//시작하는 요일부터 마지막일까지 출력을 한다.
		for(int i=1, n=StartdayOfMontn; i<=lastDayOfMonth; i++, n++) { 
			System.out.printf("%3d", i);    
			if(n%7==0) {//7일째 되는 날마다 개행을 한다.)
				System.out.println();
			}
		}
		System.out.println("\n");
	}
	
	public void runPrompt() {
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
			printCalendar(year, month);
		}
		System.out.println("Have a nice day!");
		scanner.close();
	}
}
		



