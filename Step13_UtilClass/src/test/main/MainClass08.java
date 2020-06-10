package test.main;

import java.util.HashMap;
import java.util.Map;

public class MainClass08 {
	public static void main(String[] args) {
		/*
		 * HashMap<key값의 type, value 값의 type>
		 * 인덱스로 관리되는게 아닌 key값으로 관리된다.
		 * map.put(key, value)
		 * 문자열로 어떤 키값을 저장 할 것인지. 저장할 참조값을 전달한다.
		 */
		//arrayList만큼 자주 쓰인다.
		Map<String, Object> map1 = new HashMap<>();//key값의 Generic, value값의 Generic 
		//key값의 Generic은 대부분 String으로 한다.정수값으로 할 시에 몇번방의 Object이런식으로 할 수 있다.
		//여러개를 섞어서 담으려면 value값은 Object일 수 밖에 없다. String과 Object는 거의 고정이라고 보면 된다.//웹에서는
		//참조 데이터 타입만 들어간다. 다양한 데이터 타입을 지정 하고 싶을 때 (Object)
		map1.put("num", 1);//데이터를 저장한는 메소드
		map1.put("name", "김구라");
		map1.put("addr", "노량진");
		//javascript 에서는 {num:1, name:"kim", addr:"nrg"}
		
		/*
		 * value의 Generic 클래스가 Object로 지정 되어 있기 때문에
		 * 리턴되는 Object type(value 값)을 원래 type으로 Casting 해야한다.
		 * 
		 * class를 따로 만들지 않아도 되는 대신에 값을 가져오기 위해서는 Casting을 해야하는 수고가 있다.
		 * Map interface type으로 받는다.
		 */
		
		int num = (int)map1.get("num");//원래 타입으로 Casting을 해야 한다.
		String name = (String)map1.get("name");
		String addr = (String)map1.get("addr");
		System.out.println(num+"|"+name+"|"+addr);
		
		
		
	}

}
