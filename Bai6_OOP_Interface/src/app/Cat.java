package app;

public class Cat implements Ianimal {
	private String category;
	private boolean gender;
	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("MEO MEO");
		
	}
	/**
	 * @param category
	 * @param gender
	 */
	public Cat(String category, boolean gender) {
		super();
		this.category = category;
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Cat [category=" + category + ", gender=" + gender + "]";
	}
	
	
}
