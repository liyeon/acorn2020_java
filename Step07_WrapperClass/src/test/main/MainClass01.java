package test.main;
/*
 * 기본 data type의 참조 data type *
 * - byte : Byte
 * - short : Short
 * - int : Integer
 * - long : Long
 * 
 * - float : Float
 * - double : Double
 * 
 * - char : Character
 * - boolean : Boolean
 * 기본데이터타입을조금더편리하게해줄수있는걸wrapperClass라고 한다.
 * 기본데이터타입에 기능을 가미 해 준다.
 */
public class MainClass01 {

	public static void main(String[] args) {
		//기본데이터 type
		int num1=10;
		//참조 데이터 type
		Integer num2 = 10;
		
		//참조데이터 type이지만 기본 데이터 type처럼 사용 할 수 있다.
		int result1=num2+1;
		int result2 = num1+num2;
		Integer result3=num1+num2;
		
		//숫자를 문자로 바꿀 때 10-> "10"
		String strNum = num2.toString();
		System.out.println(strNum);
		
		//문자를 숫자로 바꾸기
		String strNum2="999";
		int result4 = Integer.parseInt(strNum); //string을 int로 바꿔줌
		
	}

}
