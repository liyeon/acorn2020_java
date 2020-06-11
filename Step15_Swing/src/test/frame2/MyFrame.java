package test.frame2;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame{
//생성자
	public MyFrame(String title) {
		super(title);
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//레이아웃 매니저를 FlowLayout으로 지정한다.
		//Static final 상수로 정의되어있는 것
		/*상수화
		 * 의미 없는 숫자에 이름을 붙인 것.
		 * public class FlowLayout{
			public static final int LEFT = 0;
		public static final int CENTER = 2;
		public static final int RIGHT = 2;
		}
		 */
		//setLayout(new FlowLayout(0));
		setLayout(new FlowLayout(FlowLayout.LEFT));//흐르는 레이아웃 setLayout으로 위치를 지정하지 않아도 처음 추가한것 부터 차례로 가운데 정렬로 생성된다.
		//FlowLayout(1) - 가운데, 2 -  오른쪽 정렬, 0 - 왼쪽 정렬
		JButton btn1 = new JButton("버튼1");
		add(btn1);//프레임에 btn1 추가하기

		JButton btn2 = new JButton("버튼2");
		add(btn2);//프레임에 btn1 추가하기
		
		JButton btn3 = new JButton("버튼3");
		add(btn3);//프레임에 btn1 추가하기
		
		JButton btn4 = new JButton("버튼4");
		add(btn4);//프레임에 btn1 추가하기
		
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
		new MyFrame("나의 프레임");
	}
}
