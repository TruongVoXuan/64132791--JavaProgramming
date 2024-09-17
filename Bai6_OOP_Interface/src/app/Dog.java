package app;

public class Dog implements Ianimal {
	private String category;
	private boolean gender;
	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("GAU GAU");
		
	}
	/**
	 * @param category
	 * @param gender
	 */
	public Dog(String category, boolean gender) {
		super();
		this.category = category;
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Dog [category=" + category + ", gender=" + gender + "]";
	}
	
}