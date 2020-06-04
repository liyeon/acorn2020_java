package test.auto;
//클래스를 더이상 상속받지 않았으면 좋겠음ㅠㅜ 그럼 어캄ㅠㅜㅠㅜ
		//클래스를 더이상 상속받지 못하도록 해 둔 클래스가 있다.
//Class 예약어 앖에 final 예약어를 붙이면 더 이상 상속이 되지 않는다.
//마지막 클래스 즉 종단 클래스가 된다.
//String, Integer 등등 final 클래스이다.
public final class SportsCar extends Car{
	//생성자
	public SportsCar(Engine engine) {
		//부모클래스에게 가게 한다.
		super(engine);//최우선적으로 되어야하기 때문에 제일 위에 있어야한다.
	}
	//메소드
		@Override
		public void drive() {
			/* 애매한경우임
			 * 재정의(오버라이드)한 부모 메소드를 호출해야 할지 말지는 상황에 따라 다르다.
			 * 어떤 경우에는 부모의 메소드를 호출해 주지 않으면 객체가 제대로 동작을 안 하는 경우가 있다.
			 * 그런 경우에는 부모의 메소드를 반드시 호출해주어야한다.
			 *
			 */
			super.drive();//부모의 메소드나 부모의 필드를 참조할때 사용
			System.out.println("짱 빨리 달려용");
		}
	
}