package test.mypac;

public class Computer {
	/*필드(속성)(데이터의 저장소)
	//필드에는 메소드에서 필요로 하는 (사용하는) 것들을 담고있다
	//필드에서 필요로 하는 값들은 생성자의 인자로 전달하는 경우가 많다.
	 */
	public Cpu cpu;//선언만 하면 null이 들어있음.
	//생성자
	
	//기본 생성자 (인자로 아무것도 전달받지 않는 생성자)
	public Computer() {
		System.out.println("기본 생성자가 호출되엇습니다.");
	}
	public Computer(Cpu cpu) {
		this.cpu=cpu;
		//(this = class명 )
	}
	//메소드(기능)
	public void doGame() {
		if(this.cpu==null) {
			System.out.println("Cpu가 없어서 Cumputer가 동작을 안해요");
			return; //메소드 끝내기
		}
		System.out.println("컴퓨터로 게임을 합니다.");
	}
}
