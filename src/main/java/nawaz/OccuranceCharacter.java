package nawaz;

import java.util.HashMap;
import java.util.Map;

public class OccuranceCharacter {

	public static void main(String[] args) {
		String s="cognizant technologies";
		char[] cha= s.toCharArray();
		
		Map<Character, Integer> occurance = new HashMap<Character, Integer>();
		for (Character c : cha) {
			if(occurance.containsKey(c))
			{
				occurance.put(c, occurance.get(c)+1);
			}
			else
			{
				occurance.put(c, 1);
			}
			
		}
		System.out.println(occurance);
		
		
			
		}

	}


