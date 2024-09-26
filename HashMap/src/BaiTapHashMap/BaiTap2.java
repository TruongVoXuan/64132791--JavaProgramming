package BaiTapHashMap;

import java.util.HashMap;
import java.util.Map.Entry;

//Tạo một HashMap chứa các đối tượng Product với khóa là Integer.
//Thực hiện các thao tác như thay thế, xóa, kiểm tra sự tồn tại của phần tử, và thêm phần tử mới.
//In ra các phần tử trong danh sách.


class Product {
	String name;
	double price;
	int quality;
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", quality=" + quality + "]";
	}
	/**
	 * @param name
	 * @param price
	 * @param quality
	 */
	public Product(String name, double price, int quality) {
		super();
		this.name = name;
		this.price = price;
		this.quality = quality;
	}
	
}

public class BaiTap2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer,Product> products = new HashMap<>();
		products.put(1, new Product("Laptop DELL", 9999, 10));
		products.put(2, new Product("Laptop ACER", 8888, 9));
		products.put(3, new Product("Laptop LENOVO", 7777, 8));
		
		//Thay thế ele tại vị trí
		products.put(2, new Product("Laptop ASSUS", 87655, 6));
		
		//xóa element
		products.remove(2);
		
		//Kiểm tra tồn tại
		System.out.println(products.containsKey(2));
		
		//Thêm danh sách
		products.put(2, new Product("Laptop MAC", 37812738, 110));
		
		//In danh sách
		 for (Entry<Integer, Product> entry : products.entrySet()) {
	            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
	        }
	}

}
