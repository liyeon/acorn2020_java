package test.main;

import java.util.HashMap;
import java.util.Map;

public class MainClass10 {
	public static void main(String[] args) {
		Map<String, Object> map1 = new HashMap<>();
		map1.put("num", 1);
		map1.put("name", "김구라");
		map1.put("addr", "노량진");
		map1.put("isMan", true);
		map1.put("phone", "010-1111-2222");
		
		//이름을 참조하려면
		String name = (String)map1.get("name");
		//전화번호를 수정하려면
		map1.put("phone", "010-1234-5678");
		//"isMan"이라는 키값이 존재하는지에 대한 여부?
		boolean isExist = map1.containsKey("isMan");
		//"num"이라는 키값으로 저장된 값 삭제
		map1.remove("num");
		//전체 삭제
		map1.clear();
		//객체를 생성 해야하는 이유는 -HashMap은 non static으로 구성이 되어 있기 때문에 객체를 생성해야한다.
		int leng = (int)((String)map1.get("name")).length();
		System.out.println(leng);
	}
}
