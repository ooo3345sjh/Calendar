package calendar.exam10;

import java.io.*;
import java.text.*;
import java.util.*;

public class CalendarService {
	Scanner scanner = new Scanner(System.in);
	private Set<Schedule> s = new HashSet<Schedule>(); //날짜별로 일정을 저장하기 위한 Set<Schedule>타입의 필드
	List<Date> list = new ArrayList<>(); //달력을 출력할때 아래부분에 해당 월에 등록된 일정들을 표시하기위한 필드
	
	public void Initialization() {
		s.clear();
		list.clear();
	}
	
	public void save() {
		try {
			FileOutputStream fos = new FileOutputStream("C:/Temp/schedule1.db");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(s);
			oos.flush();
			oos.close();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void read() {
		try {
			FileInputStream fis = new FileInputStream("C:/Temp/schedule1.db");
			@SuppressWarnings("resource")
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);
			this.s = (Set<Schedule>)ois.readObject();
			Iterator<Schedule> i = s.iterator();
			while(i.hasNext()) {
				Schedule schedule = i.next();
				list.add(schedule.getDate().getTime());
			}
		} catch (Exception e) {
			e.getMessage();
		}
		System.out.println("불러오기 완료");
	}
	
	public void addSchedule() { //일정을 등록하는 메소드
		while(true) {
			System.out.println("날짜를 입력해주세요.(yyyyMMdd) exit:-1");
			System.out.print(">");
			Schedule schedule = new Schedule();
			String date = scanner.nextLine();
			if(date.equals("-1")) return;
			if(date.equals("")) continue;
			if(schedule.setDate(date)) {
				Iterator<Schedule> i = s.iterator();
				
				while(true) {
					if(i.hasNext()) {
						Schedule oldSchedule = i.next();
						if(oldSchedule.equals(schedule)) {
							oldSchedule.addContent();
							break;
						}	
					} else {
						schedule.addContent();
						list.add(schedule.getDate().getTime());
						s.add(schedule);
						break;
					}
				}
			} else {
				System.out.println("날짜를 정확히 입력해주세요.(yyyyMMdd)");
				continue;
			}
			
			System.out.println();
			System.out.println("일정을 추가 등록하시겠습니까?(y/n)");
			String str = scanner.nextLine();
			if(str.equals("y")) {
				System.out.println();
				continue;
			}
			System.out.println(); 
			save();
			return;
		}
	}
	
	public void search() { //일정을 검색하는 메소드
		while(true) {
			System.out.println("날짜를 입력해주세요.(yyyyMMdd) exit:-1");
			System.out.print(">");
			
			String date = scanner.nextLine();
			if(date.equals("-1")) return;
			if(date.equals("")) continue;
			
			Schedule getItem = new Schedule();
			getItem.setDate(date);
			
			Iterator<Schedule> i = s.iterator();
			while(true) {
				if(i.hasNext()==true) {
					Schedule schedule = i.next();
					if(schedule.equals(getItem)) {
						if(schedule.isEmpty()) {
							System.out.println("입력한 날짜에 등록된 일정이 없습니다.");
						}
						schedule.printContent();
						break;
					} 
				} else {
					System.out.println("입력한 날짜에 일정이 검색되지않습니다.");
					break;
				}
			}
				System.out.println();
				System.out.println("일정을 추가 검색하시겠습니까?(y/n)");
				String str = scanner.nextLine();
				if(str.equals("y"))	{
					System.out.println();
					continue;
				}
				System.out.println();
				save();
				return;
		}
	}
	
	public void removeSchedule() { //일정을 삭제하는 메소드
		while(true) {
			System.out.println("날짜를 입력해주세요.(yyyyMMdd) exit:-1");
			System.out.print(">");
			
			String date = scanner.nextLine();
			if(date.equals("-1")) return;
			if(date.equals("")) continue;
			
			Schedule getItem = new Schedule();
			getItem.setDate(date);
			
			Iterator<Schedule> i = s.iterator();
			
			A:while(true) {
				if(i.hasNext()==true) {
					Schedule schedule = i.next();
					if(schedule.equals(getItem)) {
						while(true) {
							System.out.println("삭제할 일정의 번호를 입력해주세요.(1~"+ schedule.sizeSchedule() + ")");
							System.out.print(">");
							String str = scanner.nextLine();
							if(str.equals("")) {
								System.out.println("번호 미입력");
								continue;
							}
							int num = Integer.parseInt(str);
							if(num<1 || num>schedule.sizeSchedule()) {
								System.out.println("입력 범위 초과(1~" + schedule.sizeSchedule() + ")");
								continue;
							}
							schedule.removeContent(num);
							System.out.println("삭제 완료");
							
							if(schedule.isEmpty()) {
								for(int j=0; j<list.size(); j++) {
									Calendar tmp = schedule.getDate();
									Date d = tmp.getTime(); 
									if(list.get(j).equals(d)) {
										list.remove(j);
									}
								}
								i.remove(); 
								break A;
							}
							break A;	
						}
					} 
				} else {
					System.out.println("입력한 날짜에 삭제할 일정이 없습니다.");
					break;
				} 
			}
				System.out.println();
				System.out.println("일정을 추가 삭제하시겠습니까?(y/n)");
				String str = scanner.nextLine();
				if(str.equals("y")) {
					System.out.println();
					continue;
				}
				System.out.println();
				return;
		}
	}
	
	public void printScheduleOfMonth(int year, int month) { //달력 출력시 해당 월에 일정이 등록된 Day도 출력하기위한 메소드 
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd");
		
		Collections.sort(list); //List타입을 정렬해주는 메소드 
		
		Calendar cal3 = Calendar.getInstance();
		//해당 year, month에 등록된 일정의 갯수를 세기위한 변수 및 반복문
		int count = 0; 
		for(int i=0; i<list.size(); i++) {
			cal3.setTime(list.get(i));
			if(month==(cal3.get(Calendar.MONTH)+1) && year==cal3.get(Calendar.YEAR)) {
				count++;
			}
		}
		
		//해당 year, month에 등록된 일정을 오름차순으로 출력한다.
		int num = count;
		count = 0;
		for(int i=0; i<list.size(); i++) {
			cal3.setTime(list.get(i));
			if(month==(cal3.get(Calendar.MONTH)+1) && year==cal3.get(Calendar.YEAR)) {
				count++;
				if(count==num) {
					System.out.println(sdf1.format(list.get(i)) + "\n");
				} else {
					System.out.print(sdf1.format(list.get(i)) + ", ");
				}
			}
		}
		
		System.out.println(count + "개의 일정이 있습니다.");
	}
	
	public void viewCalendar() { //달력을 출력하는 메소드
		CalendarObject co = new CalendarObject();
		
		while(true) {
			if(co.setDate()) {
				co.printCalendar();
				printScheduleOfMonth(co.getYear(),co.getMonth()); // 달력이 출력되면 아래부분에 해당 월에 일정이 등록된 Day를 출력하는 메소드
			} else {
				return;
			}
		}
	}
	
	public void help() {
		System.out.println("+-------------+");
		System.out.println("[1]일정 등록");
		System.out.println("[2]일정 검색");
		System.out.println("[3]일정 삭제");
		System.out.println("[4]달력 보기");
		System.out.println("[h]도움말");
		System.out.println("[s]저장");
		System.out.println("[r]불러오기");
		System.out.println("[q]종료");
		System.out.println("[i]일정 초기화");
		System.out.println("+-------------+");
	}
	
	public void run() {
		String value;
		help();
		while(true) {
			System.out.println("명령(1, 2, 3, 4, h, s, r, q, i)");
			System.out.print("> ");
			value = scanner.nextLine();
			
			switch (value) {
				case "1": {
					addSchedule();
					break;
				}
				case "2": {
					search();
					break;
				}
				case "3": {
					removeSchedule();
					break;
				}
				case "4": {
					viewCalendar();
					break;
				}
				case "h": {
					help();
					break;
				}
				case "s": {
					save();
					System.out.println("저장 완료");
					break;
				}
				case "r": {
					read();
					break;
				}
				case "q": {
					System.out.println("Have a nice day!");
					scanner.close();
					save();
					return;
				}
				case "i": {
					Initialization();
					break;
				}
				default: {
					System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) throws ParseException {
		CalendarService cs = new CalendarService();
		cs.run();

	}
}
		

