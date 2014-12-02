package Random;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RomanNumeralsToInteger {
	private Map<Character, Integer> roman_to_int = new HashMap<>();

	public RomanNumeralsToInteger(){
		roman_to_int.put('I', 1);
		roman_to_int.put('V', 5);
		roman_to_int.put('X', 10);
		roman_to_int.put('L', 50);
		roman_to_int.put('C', 100);
	}

	public static void main(String args[]){
		RomanNumeralsToInteger o = new RomanNumeralsToInteger();
		try (BufferedReader br = new BufferedReader(new FileReader("/Users/tanmaymehrotra/Desktop/RomanNumerals2.txt")))
		{
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine + " = " + o.convertRomanNumeralToInteger(sCurrentLine));
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	public int convertRomanNumeralToInteger(String romanNumeral){
		int sum = roman_to_int.get(romanNumeral.charAt(romanNumeral.length()-1));
		for (int i=romanNumeral.length()-1; i>=1; i--){
			int ch1 = roman_to_int.get(romanNumeral.charAt(i));
			int ch2 = roman_to_int.get(romanNumeral.charAt(i-1));
			if(ch2 >= ch1){
				sum += ch2;
			}else{
				sum-=ch2;
			}
		}
		return sum;
	}
}