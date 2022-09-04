package calendar.exam07;


public class Calendar {
	public final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	public final int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public boolean isLeapYear(int year) {
		if(year%4==0 && year%100!=0 || year%400==0) {
			return true;
		}
		return false;
	}
	
	public int getMaxdayOfMonth(int year, int month) {
		if(isLeapYear(year)) {
			return LEAP_MAX_DAYS[month-1];
		}
		return (MAX_DAYS[month - 1]);
	}
	
	public int getWeek(String week) {
		int startWeek = -1;
		switch(week){
		case "SU": case "su": startWeek = 0; return startWeek; 
		case "MO": case "mo": startWeek = 1; return startWeek; 
		case "TU": case "tu": startWeek = 2; return startWeek; 
		case "WE": case "we": startWeek = 3; return startWeek; 
		case "TH": case "th": startWeek = 4; return startWeek; 
		case "FR": case "fr": startWeek = 5; return startWeek; 
		case "SA": case "sa": startWeek = 6; return startWeek;
		case "Q": case "q": startWeek = -1; return startWeek;
		}
		return -2;
	}

	public void printCalendar(int year, int month, String week) {
		
		System.out.printf("    <<%4d년%3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("----------------------");
		int day = getMaxdayOfMonth(year, month);
		
		
		/*
		 * @param week 요일명
		 * @return 0 ~ 6 (0 = Sunday, 6 = Saturday)
		 * 
		 */
		int startWeek = getWeek(week);
		
		int count = 0;
		//print blank space
		for (int i=0; i<startWeek; i++) {
			System.out.print("   ");
			count++;
		}
		
		for (int i=1; i<day+1; i++) {
			System.out.printf("%3d", i);
			if (++count % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println("\n");
	}

}
