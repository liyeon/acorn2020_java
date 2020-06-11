package test.main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MainClass13 {
	public static void main(String[] args) {
		//정수를 담을 수 있는 HashSet 객체를 생성해서 참조값을 Set type 지역변수에 담기
		Set<Integer> nums = new HashSet<>();
		nums.add(1);
		nums.add(3);
		nums.add(4);
//		//0~9 정수를 for문을 이용해서 담기
//		for(int i=0; i<10; i++) {
//			nums.add(i);
//		}
//		
		//Set에 저장된 item의 갯수는?
		int size = nums.size();
		//Set에 저장된 item을 모두 불러오기
		
		//Iterator 반복자 객체 얻어오기
		//데이터는 커서를 한칸한칸 이동을 하면서 데이터를 읽어낸다. 데이터가 없을 때 까지 커서를 이동한다.
		Iterator<Integer> it =nums.iterator();
		//it.hasNext()는 커서 다음에 읽어낼 데이터가 있는지 확인해서 있으면 true를 리턴하고 없으면 false를 리턴한다.
		while(it.hasNext()) {
			//it.next()는 커서를 한칸 움직여서 커서가 위치한 곳의 데이터를 읽어온다.
			int tmp = it.next();
			System.out.println(tmp);
			
		}
		
		
		
		
	}//void main 종료
}//class 종료
