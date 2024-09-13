package NhapInt;

import java.util.Scanner;

public class NhapSoNguyen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập một số nguyên: ");
        int numberInt = scanner.nextInt();
        
        if (numberInt % 2 == 0) {
            System.out.println(numberInt + " is even. bye!");
        } else {
            System.out.println(numberInt + " is odd. bye!");
        }
        
        scanner.close();
    }
}




