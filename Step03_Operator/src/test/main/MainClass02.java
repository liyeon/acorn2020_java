package test.main;

/*
 *  2. 증감 연산자 테스트
 *  변수에 있는 숫자 값을 1씩 증가 혹은 1씩 감소 시킬 때 사용한다.
 *  ++, --
 */
public class MainClass02 {
	public static void main(String[] args) {
		int num = 0;
		num++;
		num++;
		num++;// num이 최종적으로 3이 된다.

		int num2 = 0;
		num2--;
		num2--;
		num2--; // num2가 최종적으로 -3이 된다.

		int num3 = 0;
		int result1 = num3++; // result1에 0이 대입되고 num3이 1증가한다.
		// 0을 먼저 대입 한 후에 1이 증가하는 것이기 때문에 result1에는 0이 대입 되고 num3이 1증가한다. 가장 늦다고 보면 된다.
		int num4 = 0;
		int result2 = ++num4;// num4가 1 증가하고 result2에 1이 대입한다.
		// 1을 먼저 증가 시킨 다음에 대입하기 때문에 result2에 1이 대이뵌다.
	}
}
