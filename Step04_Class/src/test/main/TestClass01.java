package test.main;

import test.mypac.NewCar;
import test.mypac.NewRect;

public class TestClass01 {
public static void main(String[] args) {
 	NewCar n1 = new NewCar("이름이당");
 	n1.drive();
 	NewRect n2 = new NewRect();
 	n2.height = 10;
 	n2.width = 20;
 	int result1 = n2.getAera();
 	System.out.println(result1);
}
}
