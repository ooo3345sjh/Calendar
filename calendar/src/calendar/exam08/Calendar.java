package calendar.exam08;


public class Calendar {
	public static final int[] MAX_DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; //평년
	public static final int[] LEAP_MAX_DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };//윤년
	
	//윤년인지 확인하기위한 메소드
		public boolean isLeapYear(int year) {
			if(year%4==0 && year%100!=0 || year%400==0) {
				return true;
			}
			return false;
		}
		//구하려는 yyyy년MM월의 일수를 반환하는 메소드
		public int[] getMaxdayOfMonth(int year) {
			if(isLeapYear(year)) {
				return LEAP_MAX_DAYS;
			}
			return MAX_DAYS;
		}
	
	public void printCalendar(int year, int month) {
		System.out.printf("    <<%d년%2d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("----------------------");
		/*
		 * @param week 요일명
		 * @return 0 ~ 6 (0 = Sunday, 6 = Saturday)
		 * 
		 */
		
		// DayOfMonth클래스에서 해당 월의 1일이 시작되기전의 공백 수를 반환한 것을 저장.
		int count = getWeekDay(year, month);
		
		//count만큼 공백을 출력한다.
		for (int i = 0; i < count; i++) {
			System.out.print("   ");
		}
		
		//구하려는 월을 배열에서 찾아 해당 월의 최대일수를 변수에 저장한다.
		int[] dayOfMonth = getMaxdayOfMonth(year);
		int maxMonth = dayOfMonth[month]; 
		
		//공백이후에 1부터 해당 월의 최대일수까지 출력한다.
		for (int i = 1; i < maxMonth+1; i++) {
			System.out.printf("%3d", i);
			if (++count % 7 == 0) { // count%7은 캘린더가 7일단위로 줄이 바뀌므로 체크하기위한 용도 
				System.out.println();
			}
		}
		System.out.println("\n");

	}
	
	//구하려는 월의 1일이 시작되는 요일을 구하기위한 메소드
	public int getWeekDay(int year, int month) {
		int syear = 1899; //기준 년도, 1899년 1월 1일은 월요일
		int count = 0; //7일이 될때마다 줄을 바꾸기위한 변수
		
		for(int i=syear; i<year; i++) {
			count += isLeapYear(i) ? 366 : 365;
		}
		
		for(int i=1; i<month; i++) {
			int[] arrMonth = getMaxdayOfMonth(year); 
			count+=arrMonth[i];	
		}
		System.out.println(count);
		count%=7;
		
		return count;
	}

}
