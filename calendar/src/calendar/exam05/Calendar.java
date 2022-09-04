package calendar.exam05;

import java.util.*;

public class Calendar {
	public static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static int getMaxdayOfMonth(int month) {
		return (MAX_DAYS[month - 1]);
	}

	public static void main(String[] args) {
		String PROMPT = "cal> ";
		Scanner scanner = new Scanner(System.in);
		int Month = 0;
		
		while(true) {
			System.out.println("월을 입력하세요.");
			System.out.print(PROMPT);
			Month = Integer.parseInt(scanner.nextLine());
			if(Month == -1) {
				break;
			} else if (Month<1 || Month>12) {
					System.out.println("The value entered is a month that does not exist.\n");
					continue;
			}
			
			System.out.printf("%d월은 %d일까지 있습니다.\n\n", Month, getMaxdayOfMonth(Month));
		}
		System.out.println("Have a nice day!");
		scanner.close();

		
	}

}
