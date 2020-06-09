package test.main;

import test.mypac.Joinner;

public class MainClass05 {
	public static void main(String[] args) {
		Joinner j1 = new Joinner() {
			@Override
			public String join(String first, String second) {
				return first+second;
			}
		};
		String result1=j1.join("김", "구라");
		
		
		Joinner j2=(first, second)->{return first+second;};
		//() : 인자를 전달 받는 곳
		String result2 = j2.join("해", "골");
		
		Joinner j3 = (first,second)->first+second; //중괄호가 없으면 리턴해줄값만 명시해주면된다.
		String result3 = j3.join("원", "숭이");
		System.out.println(result1 + result2 + result3);
	}
}
