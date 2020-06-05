package test.human;
//혈액형 정보를 저장할 객체를 생성할 클래스
public class Blood {
	//필드 //필드는 private로 만드는 경우가 많다. 상수값을 가지고 있지 않는 이상
	private String rh;
	private String type;
	//생성자
	public Blood(String rh, String type) {
		this.rh=rh;
		this.type=type;
	}
	/*
	 * 필드를선언하고 나서 get 을 타이핑 후 Ctrl+Space키를 누르면
	 * 이클립스가 getter메소드를 자동으로 만들어 줄 준비를 한다.
	 * 
	 */
	//필드에 저장된 rh를 리턴해주는 getter 메소드
	public String getRh() {
		return rh;//this.이 생략되어있다.
	}
	//필드에 저장된 type를 리턴해주는 getter 메소드
	public String getType() {
		return type;
	}
	
}
