package calendar.exam10;

import java.io.*;
import java.util.*;

@SuppressWarnings("serial")
public class Content implements Serializable {
	private List<String> content; //일정 내용을 저장하기위한 List<String>타입의 필드
	
	public List<String> getContent() {
		return content;
	}

	//일정 내용을 저장하는 메소드
	public void setContent() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		content = new ArrayList<>();
		
		try {
			
			while(true) {
				String str = br.readLine();
				if(str.contains(";")) {
					String tmp = str.replace(";", "");
					content.add(tmp);
					return;
				} else {
					content.add(str);
				}
			}
			
			
			
		} catch (Exception e) {

		}
		
	}
	
	public void printContent() {
		for (int i=0; i<content.size(); i++) {
			System.out.println(content.get(i));
		}
	}
	

}
