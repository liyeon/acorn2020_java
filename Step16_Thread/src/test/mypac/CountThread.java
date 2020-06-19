package test.mypac;

/*
 * 새로운 스레드 만드는 방법
 * 1. Thread 클래스를 상속 받은 클래스를 정의 한다.
 * 2. run()메소드를 오버라이드 한다.
 * 3. run()메소드 안에서 새로운 스레드에서 해야할 작업을 코딩한다.
 * 4. 만든 클래스로 객체를 생성하고 해당 객체의 start()메소드를 호출하면 
 * 	    새로운 스레드가 시작된다.
 */
public class CountThread extends Thread {//
	@Override
	public void run() {// run 메소드를 재정의한다.
		//run()메소드 안 쪽이 새로은 작업 단위가 된다.
		// 독립적인 작업단위에서 할 작업을 입력한다.
		int count = 0;
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} // catch종료
			count++;// count를 1증가시킨다.
			System.out.println("현재 카운트 : " + count);
			if (count == 10) {// 카운트가 10이 되면
				break;// 반복문 탈출
			} // if 종료

		} // while종료
	}// run()종료
}
