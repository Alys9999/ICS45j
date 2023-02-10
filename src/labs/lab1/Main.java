package labs.lab1;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

	/**
	 * Given a string and a second "word" string, we'll say that the word matches the 
	 * string if it appears at the front of the string, except its first char does not 
	 * need to match exactly. On a match, return the front of the string, or otherwise 
	 * return the empty string. So, with the string "hippo" the word "hi" returns 
	 * "hi", "xip" returns "hip", and "dog" returns "". The word will be at least 
	 * length 1.
	 * 
	 * @param str	the input string
	 * @param word	the word to match
	 * @return		the front of the string if it matches, otherwise the empty string
	 */
	public static String problem1_frontMatch(String str, String word) {
		if(str.length()<word.length()) {
			return "";
		}
		for (int i=1; i<word.length(); i++) {
			if(str.charAt(i)!=word.charAt(i)) {
				return "";
			}
			
		}
		String nstr=str.substring(0,word.length());
		return nstr;
		 // FIX ME
	}


	/**
	 * Given two strings, append them together and return the result. However, if 
	 * the concatenation creates a double-char, then omit one of the chars, so "abc" 
	 * and "cat" yields "abcat".
	 * 
	 * @param a	the first string
	 * @param b	the second string
	 * @return	the result of concatenating the strings after omitting a double-char
	 */
	public static String problem2_concatNoDoubles(String a, String b) {
		if (a.length()==0) {
			return b;
		}
		if (b.length()==0) {
			return a;
		}
		if (a.charAt(a.length()-1)==b.charAt(0)){
			return a+b.substring(1);
		}else {
			return a+b;
		}
	}
	
	
	/**
	 * In the Java library, a color is specified by its red, green, and blue 
	 * components between 0 and 255. Write a method that:
	 * 
	 * * Takes in a red, a green, and a blue value, constructs a Color object based 
	 *   on those values.
	 * * Applies the darker method of the Color class to the color
	 * * Returns the resulting Color object
	 * 
	 * (Note: you will not actually see the color. Graphical user interfaces will be covered in week 9.) 
	 * 
	 * Assume all color value inputs will be integers between 0 and 255.
	 * 
	 * @param red	the red value for the color
	 * @param green	the green value for the color
	 * @param blue	the blue value for the color
	 * @return	the darkened color
	 */
	public static Color problem3_darker(int red, int green, int blue) {
		Color C = new Color(red, green, blue);
		C=C.darker();
		return C; // FIX ME
	}
	
	
	/**
	 * Given three integers representing a date (month, day, and year), return a 
	 * string indicating what day of the week that day falls on (in leading case, 
	 * e.g., "Sunday", "Monday", etc.). The month, day, and year inputs will always 
	 * represent a valid date.
	 * 
	 * Hint: See the GregorianCalendar class in the Java API docs. Use the constant 
	 * int values provided in the Calendar class (Calendar.JANUARY . . . Calendar.DECEMBER)
	 * to specify the month, as shown in the examples.
	 * 
	 * @param year			year of date
	 * @param month			month of date (use Calendar.JANUARY . . . Calendar.DECEMBER constants)
	 * @param dayOfMonth	day of month of the date
	 * @return	a string in leading case, representing the day of the week
	 */
	public static String problem4_getDayOfWeek(int year, int month, int dayOfMonth) {
		String dayAsString="";
		GregorianCalendar d = new GregorianCalendar(year, month, dayOfMonth);
		int dayOfWeek = d.get(Calendar.DAY_OF_WEEK);
		switch(dayOfWeek) {
		case 1: dayAsString="Sunday";
		break;
		case 2: dayAsString="Monday";
		break;
		case 3: dayAsString="Tuesday";
		break;
		case 4: dayAsString="Wednesday";
		break;
		case 5: dayAsString="Thursday";
		break;
		case 6: dayAsString="Friday";
		break;
		case 7: dayAsString="Saturday";
		break;
		}
		System.out.print(dayOfWeek);
		return dayAsString;
		
	}
	
	
	/**
	 * The BigInteger class represents integer numbers with an arbitrary number of digits (the 
	 * int type cannot express very large integers). Given a BigInteger object, return a 
	 * BigInteger that is equal to the original BigInteger, cubed.
	 * 
	 * @param bigInt	the number to cube
	 * 
	 * @return	the number cubed
	 */
	public static BigInteger problem5_bigCube(BigInteger bigInt) {
		bigInt.multiply(bigInt).multiply(bigInt);
		return bigInt.multiply(bigInt).multiply(bigInt); // FIX ME
	}
	
	public static void main(String[] args) {
		int num1 = 6;
		int num2 = 10;
		num1 = num2;
		num2 = num1;
		System.out.println(num1 + ", " + num2);
	}
}