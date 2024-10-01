package app;

import java.io.FileInputStream;
import java.io.IOException;

public class app2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fin = null;
		fin = new FileInputStream("num.clc");
		int byRead;
		while(true) {
			byRead = fin.read();
			if(byRead == -1) break;
			System.out.println(byRead);
		}
		System.out.println("DONE!");
	}

}
