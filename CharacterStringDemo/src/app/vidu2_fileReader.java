package app;

import java.io.FileReader;
import java.io.IOException;

public class vidu2_fileReader {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("songque.txt");
		char buff[] = null;
		buff = new char[10]; //mảng 10 kí tự
		fr.read(buff);		//đọc file cất vào mảng này (1) kí tự
		fr.close();			//đóng file
		for( int i=0;i<10; i++) { //in ra màn hình
			System.out.println(buff[i]);
		}

	}

}
