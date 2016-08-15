package week7;

public class Occurance_Java_HW {

	public static void main(String[] args) {
		String compName = "Amazon Development Centre"  ;
		int occuranceofmn =0; 
		char[] charArray =compName.toCharArray();
		for (char c : charArray)
		{
			if(c=='m'||c=='n'){
				occuranceofmn++;
				
			}
			
		}
		System.out.println("Occurance of m & n is :" +occuranceofmn);
		
		//Method2
		System.out.println(compName.length()-compName.replaceAll("[mn]", "").length());
	}

}
