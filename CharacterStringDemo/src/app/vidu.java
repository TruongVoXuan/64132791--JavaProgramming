package app;

import java.io.FileWriter;
import java.io.IOException;

public class vidu {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileWriter fw;
		fw = new FileWriter("songque.txt");
		fw.write("sông quê aaaaaaaaaaaaa..\n");
		fw.write("sông quê bbbbbbbbbbbbb");
		
		fw.flush();
		fw.close();
	}

}
