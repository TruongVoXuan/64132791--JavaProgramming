package app;

public class Apps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Citizen c1 = new Citizen();
		c1.setId("007");
		c1.setName("JAME");
		c1.setGender("Male");
		c1.setNation("US");
		c1.setYear((short)1934);
		System.out.println(c1.toString());
		
		Citizen c2= new Citizen("004", "Jerry", (short)1932, "female", "EN");
		System.out.println(c2.toString());
	}

}
