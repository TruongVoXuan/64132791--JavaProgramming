package BaiTapArrayList;

import java.util.ArrayList;
import java.util.Set;

public class BT_ArrayList {

	public static void main(String[] args) {
		ArrayList<String> food = new ArrayList<String>(); 
			food.add("Banh Mi");
			food.add("Pho Bo");
			food.add("Bo Kho");
			
			
		
			//Các phương thức sdung trong ArrayList
			food.set(1, "Banh Canh") ;  //Thay thế 1 danh sách bất kì tại vị trí
			food.remove(1);   //Xóa element tại vị trí
			System.out.println(food.contains("Bo Kho"));   //Check xem có ele trong array không 
			food.clear();    //Xóa toàn bộ element trong array
			
			
			
		for(int i =0; i<food.size(); i++) {
			System.out.println(food.get(i));
		}

	}

}
