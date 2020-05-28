package test.main;
/*
 *[java 기본 데이터 타입]
 * 2. 논리형
 * -true, false 두가지 값 중 하나이다.
 * - true, false를 직접 쓰거나 비교연산 혹은 논리 연산의 결과로 얻어낼 수 있다.
 * - 참과 거짓을 나타내는 데이터 type 이다. 
 * boolean타입
 */

public class MainClass03 {
	public static void main(String[]args) {
		//논리형 변수선언과 동시에 값 대입하기.
		boolean isRun=true;
		if(isRun) {
			System.out.println("달려요");
		
		}
		//비교 연산의 결과로 얻어진 boolean값 담기
		boolean isGreater=10>1;
		//논리 연산의 결과로 얻어진 boolean 값 담기
		boolean result=true||false;
		//한번 선언한 변수는 다시 선언 할 수 없다.
		//boolean result=false;
		result=false;//변수에 다른 값을 대입 할 수 있다.(동일한 type인 경우)
		//다른 type값은 변수에 담을 수 없다.
		//result=10;
/*
 * 자바스크립트는 값을 대입하는 순간 타입이 결정이된다.
 * let isRun = true;
 * 타입이 바뀔 수 있다. 동적 타입 다이나믹 타입
 * java에서는 타입이 다르면 들어가지 않는다.
 * 타입을 지정 한 후 값을 대입 하기 때문에
 * */
	}
	
}