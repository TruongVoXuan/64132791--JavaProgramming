package app;
import java.util.InputMismatchException;
import java.util.Scanner;
public class CheckBMI {

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner (System.in);
		float height = 0;

		while (true) {
		    try {
		        System.out.print("Nhập vào chiều cao (m): ");
		        height = scanner.nextFloat();
		        if (height > 0 && height < 3) {
		            break;
		        } else {
		            System.out.println("Chiều cao phải lớn hơn 0 và nhỏ hơn 3 mét.");
		        }
		    } catch (InputMismatchException e) {
		        System.out.println("Dữ liệu không hợp lệ. Vui lòng nhập lại số.");
		        scanner.next(); 
		    }
		}

		 float weight = 0;
		  
		while (true) {
			try {
				System.out.print("Nhap vao can nang(kg):");
				weight = scanner.nextFloat();
				if( weight >0 && weight < 200 ) {
					break;
				}
				
				else {
					System.out.println("Cân nặng phải lớn hơn 0 và bé hơn 200");
				}
			}
			catch (InputMismatchException e) {
                System.out.println("Dữ liệu không hợp lệ. Vui lòng nhập lại số.");
                scanner.next();
            }
		
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
