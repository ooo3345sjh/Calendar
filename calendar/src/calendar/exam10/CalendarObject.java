package calendar.exam10;

import java.util.*;

public class CalendarObject {
	private int year;
	private int month;
	
	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}
	
	//  setDate()에서 저장된 year, month의 멤버변수의 값을 받아 달력을 출력하는 메소드 
	public void printCalendar() {
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
			if(i==lastDayOfMonth && n%7==0) {
				break;
			}
			
			if(n%7==0) {//7일째 되는 날마다 개행을 한다.)
				System.out.println();
			}
		}
		System.out.println("\n");
	}
	
	//입력받은 year, month의 입력을 입력 조건에 맞는지 확인후 저장하는 메소드
	@SuppressWarnings("resource")
	public boolean setDate() {
		Scanner scanner = new Scanner(System.in);
		try {
			// year변수 버그 체크
			System.out.println("연도를 입력하세요.(exit: -1)");
			System.out.print("YEAR: ");
			String strYear = scanner.nextLine();
			if (strYear.equals("")) {
				System.out.println("The value entered is a year that does not exist.\n");
				return false;
			} else {
				year = Integer.parseInt(strYear);
				if (year == -1) {
					return false;
				} else if(year<1 || year>9999) {
					System.out.println("입력 가능한 범위를 넘었습니다.");
					return false;
				}
			}

			// month변수 버그체크
			System.out.println("월을 입력하세요.(exit: -1)");
			System.out.print("MONTH: ");
			String strMonth = scanner.nextLine();
			if (strMonth.equals("")) {
				System.out.println("The value entered is a month that does not exist.\n");
				return false;
			} else {
				month = Integer.parseInt(strMonth);
				if (month == -1) {
					return false;
				} else if (month < 1 || month > 12) {
					System.out.println("The value entered is a month that does not exist.\n");
					return false;
				}
			}
			return true;
		} catch (Exception e) {
			System.out.println("잘못된 형식을 입력했습니다.");
			return false;
		}
		

	}
}
		



