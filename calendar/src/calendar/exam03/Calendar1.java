package calendar.exam03;

import java.util.*;

public class Calendar1 {
	public static void main(String[] args) {
		int month;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("달을 입력하세요.: ");
		month = scanner.nextInt();

		switch(month) {
			case 2:{
				System.out.println(month + "월은 " + "28일까지 있습니다.");
				break;
			}
			
			case 4:case 6:case 9:case 11:{
				System.out.println(month + "월은 " + "30일까지 있습니다.");
				break;
			}
			
			default:{
				System.out.println(month + "월은 " + "31일까지 있습니다.");
				break;
			}
				
		}
		 
		
	}
	
	

}
