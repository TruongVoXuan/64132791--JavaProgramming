

package app;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class vidu {

	public static void main(String[] args) {
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream("num.clc");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("file khong ton tai");
		}
		//Ghi du lieu
		try {
			for(int i = 1; i < 127; i++)
				fout.write(i);
			fout.flush();
			fout.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done");
	}

}
