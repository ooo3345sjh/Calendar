package calendar.exam10;

import java.io.*;
import java.text.*;
import java.util.*;

@SuppressWarnings("serial")
public class Schedule implements Serializable{
	private Date date;
	private List<Content> contentList = new ArrayList<>(); //Content객체를 저장할 List<Content>타입의 필드;
	
	public int sizeSchedule() {
		return contentList.size();
	}
	
	public Calendar getDate() {
		Calendar cal = Calendar.getInstance();
		 cal.setTime(date);
		return cal;
	}

	public boolean setDate(String date) {
		try {
			if(date.length()!=8) return false;
			SimpleDateFormat StringForm = new SimpleDateFormat("yyyyMMdd");
			StringForm.setLenient(false);
			Date to = StringForm.parse(date);
			this.date = to;
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean isEmpty() {
		return contentList.isEmpty();
	}

	public void printContent() {
		for(int i=0; i<contentList.size(); i++) {
		 List<String> list	= contentList.get(i).getContent();
		 System.out.print((i+1)+ ": ");
			for(int j=0; j<list.size(); j++) {
				System.out.println(list.get(j));
			}
		}
		
	}

	public void addContent() {
		System.out.println("내용을 입력해주세요.(end: ';' 입력)");
		System.out.print(">");
		 Content content = new Content(); 
		 content.setContent();
		this.contentList.add(content);
		System.out.println("등록 완료");
	}
	
	public boolean removeContent(int num) {
		if(!isEmpty()) {
			contentList.remove(num-1);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Schedule) {
			Schedule schedule = (Schedule) obj;
			if(date.equals(schedule.date)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return date.hashCode();
	}
	
}
