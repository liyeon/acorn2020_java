package test.main;
/*
 *  6. 3항 연산자 테스트
 *  항이3개라 3항연산자임 당연한거 아니눙
 */
public class MainClass06 {
	public static void main(String[] args) {
		boolean isWait=false;
		//isWait이 true면 "기다려요"기 대입되고 false면 "기다리지 않아요"가 대입된다.
		String result = isWait ? "기다려요" : "기다리지 않아요";
		
		/*false면 끝에있는게 대입이 되고 true면 기다려요가 출력.
		 * 
		 * result에 들어가는 값은 기다려요,와 기다리세요이다.
		 * isWait의 값이 true면 기다려요, false면 기다리세요가 result에 리턴된다.
		 * //조건부로 둘 중에 하나를 집어 넣을 때 3항 연산자를 사용하면 if문이 간략해진다.
		 * */
		System.out.println(result);
		
		
		//위의 3항연산자는 아래와 같은 if ~ else문과 같은 로직(논리)이다.
		
		String result2=null;
		if(isWait) {
			result2="기다려요";
		}else {
			result2="기다리지 않아요";
		}
		System.out.println(result2);
	}
}











