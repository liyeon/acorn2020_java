package test.mypac;

//사각형의 정보를 담을 수 있는 Rect 클래스
public class Rect {
	// non static 필드
	public int width;
	public int height;

	// 사각형의 면적을 리턴해주는 non static 메소드
	public int getArea() {
		int area = this.width * this.height;
		return area;
		/*
		 * int는 이 메소드가 리턴해주는 데이터의 타입이 int
		 * void = 어떤 값도 리턴해주지 않는다.
		 * java에서는 리턴 해주는 값을 항상 명시해 줘야 한다. 
		 */
	}

}
