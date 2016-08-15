package week3;

public class BMWX5 extends BMW{
//	Java does not support multiple inheritance
//	public class BMWX5 extends BMW, Vehicle{
	
	public static void main(String[] args) {
		//Creating object of the same class
		BMWX5 myCar = new BMWX5();
		myCar.applyBrakes();
	}
	
	/*	
	  	// Overriding the applyBrakes method from BMW class
	  	public void applyBrakes(){
		System.out.println("BMWX5 : applyBrakes");
	}
*/
}
