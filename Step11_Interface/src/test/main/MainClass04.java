package test.main;
import test.mypac.Drill;

public class MainClass04 {
	public static void main(String[] args) {
		useDrill(new Drill() {//메소드를 호출하면서 객체에 넣어서 동작을 전달한다.
			
			@Override
			public void hole() {
				System.out.println("바닥에 구멍을 뚫어요");
				
			}
		});
		Drill d1=()->{
			System.out.println("벽에 20mm의 구멍내기");
		};//javascript의 arrow함수와 동일하다.
		
		useDrill(d1);
		useDrill(()->{
			System.out.println("핸드폰에 1mm 구멍내기");
		});//javascript의 function(){useDrill(function(){})};와 동일
	
	}

	public static void useDrill(Drill d) {
		d.hole();
	}
}
