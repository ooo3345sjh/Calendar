package calendar.exam06;

public class Calendar {
	public final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	public final int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public boolean isLeapYear(int year) {
		if(year%4==0 && (!(year%4==0 && year%100==0) || (year%4==0 && year%100==0 && year%400==0))) {
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

	public void printMonth(int year, int month) {
		System.out.printf("    <<%4d년%3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("----------------------");
		int day = getMaxdayOfMonth(year, month);
		for (int i = 1; i < day + 1; i++) {
			System.out.printf("%3d", i);
			if (i % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println("\n");
	}

}
