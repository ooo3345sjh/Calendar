package calendar.exam03;

import java.util.*;

public class Calendar2 {
	public static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static int getMaxDaysOfMonth(int month) {
		return MAX_DAYS[month - 1];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("달을 입력하세요.: ");
		int month = scanner.nextInt();
		
		if(!(month<1 || month>12)) {
			System.out.printf("%d월은 %d일까지 있습니다.", month, getMaxDaysOfMonth(month));
			scanner.close();
		} else {
			System.out.println("입력 오류: 1~12안의 값을 입력하세요.");
		}

		
	}

}
