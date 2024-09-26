	package BaiTapArrayList;

import java.util.ArrayList;

//Bài tập 2: Tạo một ArrayList chứa các đối tượng Student.
	//Thực hiện các thao tác như thay thế, xóa, kiểm tra sự tồn tại của phần tử, và thêm phần tử mới.
	//In ra các phần tử trong danh sách.


	class Student {
		String name;
		int age;
		double diem;
	
		@Override
		public String toString() {
			return "Student [name=" + name + ", age=" + age + ", diem=" + diem + "]";
		}
		/**
		 * @param name
		 * @param age
		 * @param diem
		 */
		public Student(String name, int age, double diem) {
			super();
			this.name = name;
			this.age = age;
			this.diem = diem;
		}
		
		
		
	}
public class BaiTap2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Student>students = new ArrayList<Student>();
		students.add(new Student("Truong",19,9.8));
		students.add(new Student("Ngan",20,9.9));
		students.add(new Student("Ngot",22,9.0));
		
		students.set(1, new Student("KUUUU", 23, 4.0));  //Thay thế element tại vị trí 1
		students.remove(2); //Xóa tại vị trí 2
		System.out.println(students.contains(new Student("Ngan", 20, 9.9)));   //kiểm tra sự tồn tại của phần tử
		students.add(new Student("Muc", 20, 8.0));
		
		//In danh sach
		for(Student student:students) {
			System.out.println(student);
		}
		
	}
}
