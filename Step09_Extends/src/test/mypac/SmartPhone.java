package test.mypac;

public class SmartPhone extends HandPhone {
	//생성자
	public SmartPhone() {
		System.out.println("SmartPhone() 생성자 호출됨");
	}
	public void doInternet() {
		System.out.println("인터넷을 합니다.");
	}
	//ctrl + space 하면 override(재정의) 할 수 있는(부모) 메소드 목록이 나온다
	//@Override 는 부모의 메소드를 재정의한 메소드라고 표시해주는 어노테이션(Annotation) | 적지 않는다고 오류가 뜨지는 않는다.
	@Override //Annotation
	public void takePicture() {
	//super.takePicture();  부모클래스에 지정된 메소드의 기능을 작동하지 않고 재정의한것만뜨게한다.
	System.out.println("1000만 화소의 사진을 찍습니다.");
	}


	@Override
	public void mobileCall() {    
		super.mobileCall();//자식에서 부모를 가리키는 예약어 super.
		System.out.println("뭔 이동중에 전화임--//override");
	}
	
}
