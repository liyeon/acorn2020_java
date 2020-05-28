package test.main;
/*
 *  4. 논리연산자 테스트
 */
public class MainClass04 {
	public static void main(String[] args) {
		//or연산 둘 중 하나만 맞아도 true
		boolean result1 = false || false; //false
		boolean result2 = false || true; //true
		boolean result3 = true || false; //true
		boolean result4 = true || true; //true
		//and연산 둘다 맞아야 true
		boolean result5 = false && false; //false
		boolean result6 = false && true; //false
		boolean result7 = true && false; //false
		boolean result8 = true && true; //true
		//not 연산 true는 false로 false는 true로
		boolean result9 = !true; //false
		boolean result19 = !false; //true
		
		boolean isRun=false;
		
		if(isRun != true){
			System.out.println("달리지 않아요");
		}
		//isRun이 true가 아니면.
		//위와 아래는 동일하다. 편한 방식으로ㅇㅇ
		if(!isRun){
			System.out.println("달리지 않아요2");
		}
	}	
}




















