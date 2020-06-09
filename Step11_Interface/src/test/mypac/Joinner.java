package test.mypac;

@FunctionalInterface //메소드가 하나만 정의 하도록  강제하는 기능. 입력하면 메소드를 두개 가질 수 없다.
public interface Joinner {
	//전달 되는 두 문자열을 연결해서 리턴하는 메소드
	public abstract String join(String first, String second);//abstract(추상) 메소드
}
