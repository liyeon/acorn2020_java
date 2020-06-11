package test.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainClass09 {

	public static void main(String[] args) {
		/*
		 * 3명의 회원 정보(번호, 이름,주소)를 Hashmap 객체에 담고
		 * HashMap객체의 참조값을 ArrayList객체에 순서대로 담아보세요.
		 */
		Map<String, Object> m1= new HashMap<>();
		m1.put("num", 1);
		m1.put("name", "김구라");
		m1.put("addr", "노량진");
		
		Map<String, Object> m2= new HashMap<>();
		m2.put("num", 2);
		m2.put("name", "해골");
		m2.put("addr", "행신동");
		Map<String, Object> m3= new HashMap<>();
		m3.put("num", 3);
		m3.put("name", "원숭이");
		m3.put("addr", "동물원");
		
		List<Map<String, Object>> list = new ArrayList<>();
		list.add(m1);
		list.add(m2);
		list.add(m3);
		
		//해보세요ㅋ
		for(Map<String, Object> tmp:list) {
			int num = (int)tmp.get("num");
			String name = (String)tmp.get("name");
			String addr = (String)tmp.get("addr");
			String a = num+ " | " + name + " | " + addr;
			System.out.println(a);
		}
		
		//데이터 타입 참조 연습
		List<Map<String, Object>> a = list;
		Map<String,Object> b=list.get(0);
		Object c = list.get(0).get("num");
		Object d = list.get(0).get("name");
		Object e = list.get(0).get("addr");
		int f=(int)list.get(0).get("num");
		String g=(String)list.get(0).get("name");
		String h=(String)list.get(0).get("addr");
		int i=((String)list.get(0).get("addr")).length();
		System.out.println(i);
		
		
	}

}
