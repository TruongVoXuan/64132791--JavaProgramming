package app;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat c= new Cat("Tam the", false);
		Dog d =  new Dog("BitBun", true);
		
		System.out.println(c.toString());
		System.out.println(d.toString());
		
		
		//Cach khac
		Ianimal c1 = new Cat("Tam the I", false);
		Ianimal d1 = new Dog("BitBun I", true);
		 System.out.println(c1.toString());
		 System.out.println(d1.toString());
		 
	}

}
