package test.main;

import javax.swing.JFrame;

public class MainClass06 {
	public static void main(String[] args) {
		JFrame f = new JFrame("구라쓰");//객체가 생성됨으로써 gui가 생성된다.//생성자의 인자로 전달되는 방식.
		//f.setTitle("원숭이");//메소드를 통해서 전달하는 방법
		//창의 위치와 폭,높이
		f.setBounds(1000, 100, 500, 500);//리턴타입없음.
		//public void setBounds(int a, int b, int c, int d){}
		//창이 화면 상에 보이도록 한다.
		f.setVisible(true);
		//창을 닫았을 때 프로세스도 자동으로 종료되도록 한다.
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//클래스는 특정한 상수값이 다 지정되어있다.
		/*JFrame.EXIT_ON_CLOSE
		 * public class JFrame{
		 * 	public static final int EXIT_ON_CLOSE = 3;
		 * 필드를 변경 못 하게 하는 법은 필드를 선언 할 때 final을 붙이면 상수화가 돼서 변경하지 못한다.
		 * }
		 * SF = static Final
		 * 별 의미 없는 숫자에 이름을 붙인 것.
		 */
		
	}
}
