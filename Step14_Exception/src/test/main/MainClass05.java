package test.main;

import test.mypac.MyUtil;

public class MainClass05 {

	public static void main(String[] args) {
		
		MyUtil.draw();
		
		try {
			//send()메소드에서 발생하는 Exction을 처리해야한다.
			MyUtil.send();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
