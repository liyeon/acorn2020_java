package test.main;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class MainClass06 {
	public static void main(String[] args) {
		PrintStream ps = System.out;
		System.out.println("이거나 써라");
		OutputStream os = ps;
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter br = new BufferedWriter(osw);
		
		try {
			os.write(100);
			br.newLine();
			br.write("하나");
			br.newLine();//개행기호(enter)출력
			br.write("두울");
			br.newLine();
			br.write("세엣");
			br.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
