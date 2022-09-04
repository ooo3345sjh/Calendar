package calendar.exam04;

import java.util.*;

public class Calendar1 {
	public static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static int getMaxdayOfMonth(int month) {
		return (MAX_DAYS[month - 1]);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("반복횟수를 입력하세요.");
		int repeat = Integer.parseInt(scanner.nextLine());
		int[] arrMonth = new int[repeat ];
		
		
		for(int i=0; i<arrMonth.length; i++) {
			System.out.println("월을 입력하세요.");
			arrMonth[i] = Integer.parseInt(scanner.nextLine());
		}
		
		for(int i=0; i<arrMonth.length; i++) {
			System.out.printf("%d월은 %d일까지 있습니다.\n", arrMonth[i], getMaxdayOfMonth(arrMonth[i])); 
		
		}
		
		System.out.println("Bye~");
		scanner.close();

		
	}

}
