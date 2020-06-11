package test.main;

import javax.swing.JButton;
import javax.swing.JFrame;

/*
 * Gui
 */
public class MainClass01 {
	public static void main(String[] args) {
		//JFrame 객체 생성하고
		JFrame f=new JFrame("Hello Frame");//객체 자체가 Gui
		//참조값에 담아서 사용
		//초기 위치와 크기 지정
		f.setBounds(100, 100, 500, 500);//(x, y, 가로크기, 세로크기)(x, y, width, height)
		
		//프레임을 닫았을 때 자동으로 프로세스 종료되도록
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//레이아웃 매니저를 사용하지 않도록 설정
		f.setLayout(null);
		//버튼 객체 생성
		JButton btn=new JButton("눌러보셈");
		//버튼의 위치와 크기 지정
		btn.setBounds(10, 10, 100, 40);//버튼의 위치, 버튼의 크기
		//프레임에 버튼추가하기
		f.add(btn);
		
		//프레임이 보이도록 한다.
		f.setVisible(true);
		
		
		//위와 아래는 코딩 스타일의 차이이다.
		new MyFrame("나만의 프레임");
		
	}//void main
	
	
	public static class MyFrame extends JFrame{//클래스 자체가 프레임
		//생성자
		public MyFrame(String title)
		{
			super(title);
			//초기화 작업 3가지 앞에 this.은 생략 가능
			setBounds(200,200,500,500);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLayout(null);
		
			JButton btn=new JButton("눌러봐잉");
			
			btn.setBounds(50, 100, 100, 50);
			add(btn);

			setVisible(true);
		}
		
		
		
	}//MyFrame
	
	
	
	
}//main class
