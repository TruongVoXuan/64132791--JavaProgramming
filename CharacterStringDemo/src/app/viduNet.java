package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class viduNet {

	public static void main(String[] args) throws IOException {

		// Tạo chuỗi định vị tài nguyên mạng, đến trang defautl.a 
		URL url = new URL("https://ntu.edu.vn/default.aspx");
		// Gửi yêu cầu kết nối
		// giống như chúng ta nhập url lên trình duyệt, rồi Goo
		URLConnection connection = url.openConnection();
		
		// Server trả về kết quả, thông qua luồng
		// ta dùng luông InputStream để đón nhận kết quả
		InputStream in = connection.getInputStream();
		
		// Xử lý luồng, đọc dữ liệu, phần này độc lập
		InputStreamReader ir = new InputStreamReader(in);
		BufferedReader bufRead = new BufferedReader(ir);
		String line;
		while (true)
		{
			line = bufRead.readLine();
			if (line==null) break;
			System.out.println(line);
		}
	}

}
