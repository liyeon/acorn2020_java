package test.main;

public class MainClass02 {
	public static void main(String[] args) {
		//국어점수
		int kor=95;
		//영어점수
		int eng=100;
		//국어 점수와 영어 점수의 평균을 구하여 변수에 담고 그 결과를 콘솔창에 출력해보세요
		//둘 중 하나라도 double타입이어야 double타입이 나온다.
		//int type과 double type을 연산하면 결과는 double type이다.
		double avg=(double)(kor+eng)/2.0;
		System.out.println("평균 : "+avg);
	}
}
