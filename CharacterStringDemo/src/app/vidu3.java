package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class vidu3 {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("songque.txt");
		BufferedReader buffRead = new BufferedReader(fr);
		String dong1 = buffRead.readLine();
		System.out.println(dong1);

	}

}
