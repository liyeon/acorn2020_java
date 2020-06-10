package test.mypac;
//DTO 혹은 VO
public class MemberInfo {
	//필드
	public int num;
	public String name;
	public String addr;
	//생성자가 다중정의(오버로딩) 되어 있다.
	//default 생성자
	public MemberInfo() {};
	//생성자의 인자로 번호, 이름, 주소를 전달 받을 수 있도록 한다.
	public MemberInfo(int num, String name, String addr) {
		//생성자의 인자로 전달된 값을 필드에 저장한다.
		this.num=num;
		this.name=name;
		this.addr=addr;
	}
}
