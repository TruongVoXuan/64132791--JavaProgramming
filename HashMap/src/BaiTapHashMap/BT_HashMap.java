package BaiTapHashMap;

import java.util.HashMap;

public class BT_HashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    //Khác biệt giữa HashMap vs ArrayList là hashmap có thể lưu trữ các cặp giá trị key
		//vd: ta có name : id (2 cái có liên quan vs nhau)  thì hashmap sẽ tự lưu trữ 1 cặp thông tin 
		
		HashMap<String,String> countries = new HashMap<>();
		
		//thêm key and dữ liệu
		countries.put("USA","Washington DC");
		countries.put("India", "New Delhi");
		countries.put("Russia","Moscow");
		countries.put("China", "Bejing");
		System.out.println("==============");
		countries.remove("USA");  // XÓa 1 element
		System.out.println(countries);
		System.out.println("==============");
		System.out.println(countries.get("China"));   //Get: chọn lọc giá trị
//		countries.clear(); XÓA TOÀN BỘ ELEMENT
		System.out.println("==============");
		System.out.println(countries.size());  //Kích thước 
		System.out.println("==============");
		countries.replace("India", "OKOKO");   //Nếu key tồn tại (Sẽ update value) Nếu key không tồn tại(Không làm gì hết)
		System.out.println(countries);
		System.out.println("==============");
		//?: Giả sử muốn cài cặp mới khi KEY cặp đó không tồn tại trong MAP, nếu không tồn tại thì không làm gì hết
		countries.putIfAbsent("JAPAN", "XiaoChaoMen");
		System.out.println(countries);
	}

}
