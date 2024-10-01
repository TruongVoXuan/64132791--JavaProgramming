//tạo app từ điển (dịch tiếng anh sang tiếng việt) sử dụng hashMap java
package BaiTapHashMap;

import java.util.HashMap;
import java.util.Scanner;

public class BaiTap3 {
    public static class TuDien {
    	HashMap<String,String> tuDien = new HashMap<>();

        public void addTu(String english, String vietnamese) {
            tuDien.put(english, vietnamese);
        }

        public String translate(String english) {
            return tuDien.getOrDefault(english, "Từ không tồn tại!");
        }
    }

    public static void main(String[] args) {
        TuDien app = new TuDien();
        Scanner scanner = new Scanner(System.in);

        app.addTu("Red", "đỏ");
        app.addTu("Blue", "xanh");

      
        while (true) {
            System.out.println("Nhập từ tiếng Anh (hoặc 'exit' để thoát): ");
            String english = scanner.nextLine();
            if (english.equals("exit")) {
                break;
            }
            System.out.println("Nghĩa tiếng Việt: " + app.translate(english));
        }

        scanner.close();
    }
}

