package calendar.exam02;

import java.util.*;

public class Calendar {
	//문제
	//입력: 키보드로 두수의 입력을 받는다.
	//출력: 화면에 두수의 합을 출력한다.

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("두 수를 입력하세요.");
		
		String str = scanner.nextLine();
		String[] splitStr = str.split(",");
		int val1 = Integer.parseInt(splitStr[0]);
		int val2 = Integer.parseInt(splitStr[1]);
		int sum = val1 + val2;
		System.out.println("두 수의 합은 " + sum + "입니다."); 
		
		scanner.close();
	}

}
