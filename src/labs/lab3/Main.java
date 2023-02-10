package labs.lab3;

import java.util.Arrays;
import java.util.Scanner;




public class Main {

	/**
	 * Accepts a String as a parameter and looks for a mirror image (backwards)
	 * string at both the beginning and end of the given string. In other words,
	 * zero or more characters at the very beginning of the given string, and at the
	 * very end of the string in reverse order (possibly overlapping). For example,
	 * the string "abXYZba" has the mirror end "ab".
	 * 
	 * @param str the string to check for mirror ends
	 * @return the mirror end, or the empty string if no mirror end exists
	 */
	public static String problem1_mirrorEnds(String str) {
		String res = "";
		for (int i = 0; i<str.length(); i++) {
			if (str.charAt(i)==str.charAt(str.length()-i-1)) {
				res=res+str.charAt(i);
			}else {
				break;
			}
		}
		return res;
	}


	/**
	 * Given a string, returns the length of the largest "block" in the string. A
	 * block is a run of adjacent chars that are the same.
	 * 
	 * @param str the string to check for blocks
	 * 
	 * @return the length of the largest block in the string
	 */
	public static int problem2_maxBlock(String str) {
		if (str.length()==0) {
			return 0;
		}
		int res = 1;
		int counter = 1;
		String pre = str.substring(0,1);
		for (int i = 1; i<str.length();i++) {
			if (str.substring(i,i+1).equals(pre)) {
				counter++;
				if (counter>res) {
					res=counter;
				}
			}else {
				counter=1;
			}
			pre = str.substring(i,i+1);
		}

		return res;
	}


	/**
	 * An uppercase 'E' in a string is "happy" if there is another uppercase 'E'
	 * immediately to its left or right. Returns true if all the E's in the given
	 * string are happy. (A string with no 'E' in it returns true.)
	 * 
	 * @param str
	 * @return whether or not all E's in the string are happy
	 */
	public static boolean problem3_EHappy(String str) {
		if (str.equals("E")||(str.length()==2&&!str.equals("EE"))) {
			return false;
		}
		if (str.contains("E")) {
			for (int i = 1; i<str.length(); i++) {
				if (str.substring(i,i+1).equals("E")) {
					if (!str.substring(i-1,i).equals("E")) {
						if (i==str.length()-1) {
							return false;
						}else if (!str.substring(i+1,i+2).equals("E")){
							return false;
							
						}
					}
					
				}
			}
		}
		return true;

	}
	
	
	/**
	 * Returns the minimum number of twists to unlock a lock, based on the starting
	 * and target values
	 * 
	 * @param starting	the current numbers of the lock
	 * @param target	the combination required to unlock the lock
	 * 
	 * @return	the minimum number of twists to unlock the lock
	 */
	public static int ifNine(int t, int s) {
		int c=Math.abs(t-s);
		if (c>5) {
			if (t>s) {
				return 10-t+s;
			}else if(t<s) {
				return 10-s+t;
			}
		}
		return c;
	}
	
	public static int problem4_getNumTwists(int starting, int target) {
		int s1 = starting/1000;
		int s2 = (starting/100)%10;
		int s3 = (starting/10)%10;
		int s4 = starting%10;
		
		int t1 = target/1000;
		int t2 = (target/100)%10;
		int t3 = (target/10)%10;
		int t4 = target%10;
		
		int c1 = ifNine(t1,s1);
		int c2 = ifNine(t2,s2);
		int c3 = ifNine(t3,s3);
		int c4 = ifNine(t4,s4);
		
		
		return c1+c2+c3+c4; // FIX ME
	}
	
	
	/**
	 * Manages crowd control in an office
	 * 
	 * @param in       the Scanner to be used for user input
	 * @param capacity of the office
	 * 
	 *                 To run this method using the keyboard for user input, call it
	 *                 like this: problem5_officeCrowdControl(new Scanner(System.in), 100);
	 */
	public static void problem5_officeCrowdControl(Scanner in, int capacity) {
		int currentP=0;
		do {
			System.out.print("People entering or leaving: ");
			int num = in.nextInt();
			if (currentP+num>=0&&currentP+num<=capacity) {
				currentP+=num;
			}
			System.out.print("People in office: "+currentP+" | ");
		}while(currentP<capacity);
		System.out.print("Office is full");
		
	}
	
	
	/**
	 * Takes an array of ints and returns an array that contains the exact same numbers 
	 * as the given array, but rearranged so that all the even numbers come before all
	 * the odd numbers
	 * 
	 * @param nums	the input array
	 * 
	 * @return	the rearranged array with all even numbers coming before all odd numbers
	 */
	public static int[] problem6_evenOdd(int[] nums) {
		int counter = 0;
		int[] res = new int[nums.length];
		for (int i = 0; i<nums.length; i++) {
			if (nums[i]%2==0) {
				res[counter]=nums[i];
				counter++;
			}
		}
		for (int j = 0; j<nums.length; j++) {
			if (nums[j]%2==1) {
				res[counter]=nums[j];
				counter++;
			}
		}
		
		return res; // FIX ME
	}
	
	
	/**
	 * Given a non-empty array of ints, returns a new array containing the elements from
	 * the original array that come after the last occurrence of the number 4 in the original
	 * array
	 * 
	 * @param nums	the input array
	 * 
	 * @return	a new array containing the elements from the original array that come after 
	 * the last occurrence of the number 4 in the original array
	 * 
	 */
	public static int[] problem7_after4(int[] nums) {
		int[] res = new int[0];
		for (int i = nums.length-1; i>=0; i--) {
			if (nums[i]==4) {
				res = new int[nums.length-i-1];
				System.arraycopy(nums, i+1, res, 0, nums.length-i-1);
				break;
			}
		}
		
		
		return res; // FIX ME
	}
	public static int[] fS(int[] values) {
		int [] result = new int[values.length-1];
				for (int i = 0; i<result.length; i++) {
					result[i]=values[i]+values[i+1];
				}
				return result;
	}
	public static void main(String args[]) {
		int[] nums= {3,18,29,-2};
		System.out.print(Arrays.toString(fS(nums)));
		
	}
	
}