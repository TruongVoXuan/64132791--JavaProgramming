package app;
import java.util.InputMismatchException;
import java.util.Scanner;
public class CheckBMI {

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner (System.in);
		float height = scanner.nextFloat();
		while (true) {
			try {
				System.out.print("Nhap vao chieu cao(m):");
				
			}
			catch (Exception e) {
                System.out.println("Dữ liệu không hợp lệ. Vui lòng nhập lại số.");
                scanner.next();
            }
			if( height >200 && height <1 ) break;
		}
		
		 float weight = scanner.nextFloat();
		  
		while (true) {
			try {
				System.out.print("Nhap vao can nang(kg):");
				
			}
			catch (Exception e) {
                System.out.println("Dữ liệu không hợp lệ. Vui lòng nhập lại số.");
                scanner.next();
            }
			if( weight >2 && weight <0 ) break;
		}
		
		
		 
		  double BMI = (weight)/((height)*(height));
		  
		  if(BMI<18.5) {
			  System.out.println("Thiếu Cân!");
		  }
		  else if( BMI >= 18.5 && BMI <= 24.9 ) {
			  System.out.println("Bình Thường");
		  }
		  else {
			  System.out.println("Béo Phì");
		  }
 	}

}
