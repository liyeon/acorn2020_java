package test.main;

import test.mypac.Student;

public class MainClass01 {
	public static void main(String[] args) {
		//Student 객체를 생성해서 참조값을 s1이라는 변수에 담기
		Student s1 = new Student();
		//객체를 생성해서 참조값을 지역변수에 담는다.
		//new Student(); 생성자(Constructor)를 호출하는 것이다.
		s1.study();
		s1.goSchool();
	}
}
