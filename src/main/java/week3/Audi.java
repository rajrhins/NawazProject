package week3;

public class Audi extends Cars {
	
	//overriding the normal braking system from Vehicle class
	@Override
	public void applyBrakes(){
		System.out.println("Audi : applyBrakes");
	}
}
