package test.main;

import test.mypac.Computer;
import test.mypac.Cpu;
import test.mypac.Student;

public class MainTest01 {

	public static void main(String[] args) {
		Computer c1 = new Computer();
		Computer c2 = new Computer(new Cpu());
		c1.doGame();
		c2.doGame();
		Student s1 = new Student();
		useStudent(s1);
		useDoGame(c1);
		useDoGame(c2);
	}
	
	public static void useStudent(Student s){
		s.study();
		s.goSchool();
	};
	public static void useDoGame(Computer c) {
		c.doGame();
	}
	
}
