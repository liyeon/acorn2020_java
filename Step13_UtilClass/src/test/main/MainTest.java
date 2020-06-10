package test.main;

import java.util.ArrayList;
import java.util.List;

import test.mypac.Info2;

public class MainTest {

	public static void main(String[] args) {
		List<Info2> list= new ArrayList<>();
		Info2 i1 = new Info2(1, "김구라", "노량진");
		Info2 i2 = new Info2(2, "해골", "행신동");
		Info2 i3 = new Info2(3, "원숭이", "동물원");
		Info2 i4 = new Info2(4, "주뎅이", "창동");
		list.add(i1);
		list.add(i2);
		list.add(i3);
		list.add(i4);
		for(int i=0; i<list.size(); i++) {
			Info2 li= list.get(i);
			System.out.println(li.num + "|" + li.name + "|" + li.addr);
		}
	}

}
