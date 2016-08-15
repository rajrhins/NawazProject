package week3;

public class ConstructorExample {
	/*
	 * Rules for Constructors : 
	 * 1. Name of constructor should be the name of the class
	 * 2. Constructors do not have a return type
	 * 3. Constructors can be overloaded
	 * 
	 * Constructors will be invoked first when an object of the class is created
	 */
	
	public ConstructorExample(){
		System.out.println("Inside Constructor with no argument");
	}
	
	public ConstructorExample(String oneArgument){
		System.out.println("Inside Constructor with one argument");
	}
	
	public static void main(String[] args) {
		ConstructorExample newObj = new ConstructorExample();
		System.out.println("Created Object for the same class");
		
	}
	
	
}











