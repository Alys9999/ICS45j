package labs.lab2;

import java.util.Scanner;

public class Main {

	/**
	 * Reads a number between 1,000 and 999,999 from the user and prints it with a 
	 * comma separating the thousands.
	 * 
	 * @param in the Scanner to be used for user input
	 * 
	 *           To run this method using the keyboard for user input, call it like
	 *           this: problem2_printWithCommas(new Scanner(System.in));
	 */
	public static void problem2_printWithCommas(Scanner in) {
		System.out.print("Please enter an integer between 1000 and 999999: ");
		int num=in.nextInt();
		System.out.print(String.format("%,d", num));
		in.close();
	}
	
	
	/**
	 * Computes the total of a sticker order based on the price per sticker and number
	 * of stickers, which are prompted for from the user
	 * 
	 * @param in the Scanner to be used for user input
	 * 
	 *           To run this method using the keyboard for user input, call it like
	 *           this: problem3_calculateTotal(new Scanner(System.in));
	 */
	public static void problem3_calculateTotal(Scanner in) {
		System.out.print("Enter price per sticker: ");
		double price = in.nextDouble();
		System.out.print("Enter the number of stickers: ");
		int num = in.nextInt();
		double out = price*num*1.1+0.15*num;
		
		System.out.print("Your total is: "+"$");
		System.out.printf("%.2f", out);
		in.close();
		}
	
	
	/**
	 * Computes the total of a sticker order based on the price per sticker and number
	 * of stickers, which are prompted for from the user
	 * 
	 * @param in the Scanner to be used for user input
	 * 
	 *           To run this method using the keyboard for user input, call it like
	 *           this: problemr_compoundInterest(new Scanner(System.in));
	 */
	public static void problem4_compoundInterest(Scanner in) {
		System.out.print("Enter principal amount: ");
		double amount = in.nextDouble();
		System.out.print("Enter the annual rate of interest: ");
		double interest = in.nextDouble();
		double percent=interest/100;
		System.out.print("Enter the number of years the amount is invested: ");
		int years = in.nextInt();
		System.out.print("Enter the number of times the interest is compounded per year: ");
		int times = in.nextInt();
		double total = amount*(Math.pow(1+percent/times, years*times));
		System.out.print("$"+String.format("%.2f",amount)+" invested at "+interest+"%"+" for "+years+" years compounded "+times+" times annually is $");
		System.out.printf("%.2f", total);
		System.out.print(".");
		in.close();
	}
	
	
	/**
	 * Computes the number of months it will take to pay off a credit card balance, based
	 * on the balance, APR, and monthly payment which are prompted for from the user
	 * 
	 * @param in the Scanner to be used for user input
	 * 
	 *           To run this method using the keyboard for user input, call it like
	 *           this: problem5_creditCardPayoff(new Scanner(System.in));
	 */
	public static void problem5_creditCardPayoff(Scanner in) {
		System.out.print("What is your balance? ");
		double balance = in.nextDouble();
		System.out.print("What is the APR on the card? ");
		double APR = in.nextDouble();
		double percent=APR/100/365;
		System.out.print("What is the monthly payment you can make? ");
		double payment = in.nextDouble();
		double s = -Math.log(1+(balance/payment)*(1-Math.pow(1+percent, 30)))/Math.log(1+percent)/30;
		System.out.print("It will take you "+(int)Math.ceil(s)+" months to pay off this card.");
		in.close();
	}
	
	
	/**
	 * Walk the user through troubleshooting issues with a car.
	 * 
	 * @param in the Scanner to be used for user input
	 * 
	 *           To run this method using the keyboard for user input, call it like
	 *           this: problem6_troubleshootCarIssues(new Scanner(System.in));
	 *           
	 */
	
	public static boolean checkAnswer(String ans) {
			if (ans.substring(0,1).equals("y")||ans.substring(0,1).equals("Y")) {
				return true;
			}else{
				return false;
			}
		}
	
	public static boolean validInput(String ans) {
		if (!ans.isEmpty()) {
			if (ans.substring(0,1).equals("y")||ans.substring(0,1).equals("Y")||ans.substring(0,1).equals("n")||ans.substring(0,1).equals("N")) {
				return true;
			}else {return false;
				}
		}else {
			return false;
		}
	}
	
	
	public static void problem6_troubleshootCarIssues(Scanner in) {
		System.out.print("Is the car silent when you turn the key? ");
		String ans1 = in.next();
		if (validInput(ans1)) {
			if (checkAnswer(ans1)) {
				System.out.print("Are the battery terminals corroded? ");
				String ans2=in.next();
				if (validInput(ans2)) {
					if (checkAnswer(ans2)) {
						System.out.print("Clean terminals and try starting again.");
					}else if (!checkAnswer(ans2)) {
						System.out.print("Replace cables and try again.");
					}else {
						System.out.print("Invalid input. Exiting.");
					}
				}else {
					System.out.print("Invalid input. Exiting.");
				}
			}else if (!checkAnswer(ans1)) {
				System.out.print("Does the car make a clicking noise? ");
				String ans3 = in.next();
				if (validInput(ans3)) {
					if (checkAnswer(ans3)) {
						System.out.print("Replace the battery.");
					}else if (!checkAnswer(ans3)) {
						System.out.print("Does the car crank up but fail to start? ");
						String ans4 = in.next();
						if (validInput(ans4)) {
							if (checkAnswer(ans4)) {
								System.out.print("Check spark plug connections");
							}else if(!checkAnswer(ans4)) {
								System.out.print("Does the engine start and then die? ");
								String ans5 = in.next();
								if (validInput(ans5)) {
									if (checkAnswer(ans5)) {
										System.out.print("Does your car have fuel injection? ");
										String ans6 = in.next();
										if (validInput(ans6)) {
											if (checkAnswer(ans6)) {
												System.out.print("Get it in for service.");
												
												
											}else if (!checkAnswer(ans6)) {
												System.out.print("Check to ensure the choke is opening and closing.");
											}else {
												System.out.print("Invalid input. Exiting.");
											}
											
										}else {
											System.out.print("Invalid input. Exiting.");
										}
									
									}else if (!checkAnswer(ans5)) {
										System.out.print("Get it in for service.");
									}else {
										System.out.print("Invalid input. Exiting.");
									}
								}else {
									System.out.print("Invalid input. Exiting.");
								}
								}else {
									System.out.print("Invalid input. Exiting.");
							}
						}else {
							System.out.print("Invalid input. Exiting.");
						}
					}else {
						System.out.print("Invalid input. Exiting.");
					}
					
				}else {
					System.out.print("Invalid input. Exiting.");
				}
				
			}else {
				System.out.print("Invalid input. Exiting.");
			}
			
		}else {
			System.out.print("Invalid input. Exiting.");
		}
	}
	
	
	/**
	 * Assesses the strength of a password based on these rules:
	 * 
	 * * A very weak password contains only digits and is fewer than eight characters
	 * * A weak password contains only letters and is fewer than eight characters
	 * * A strong password contains at least one letter and at least one digit and is at least
	 * eight characters
	 * * A very strong password contains at least one letter, at least one digit, and at least
	 * one special character (non letter or digit) and is at least eight characters
	 * * All other passwords are medium strength
	 * 
	 * @param password	the password to assess
	 * @return	a string describing its strength
	 */
	public static String problem7_assessPasswordStrength(String password) {
		int len=password.length();
		if (len<8 && password.matches("[0-9]+")){
			return ("very weak");
		}else if (len<8 && password.matches("[a-zA-Z]+")) {
			return ("weak");
		}else if (len>=8 && password.matches("(?=.*?[0-9])(?=.*?[a-zA-Z])(?=.*[^0-9a-zA-Z]).*")) {
			return ("very strong");
		}else if (len>=8 && password.matches("(?=.*?[0-9])(?=.*?[a-zA-Z]).*")) {
			return ("strong");
		}else {
			return ("medium");
		}
	}
	
	
	/**
	 * Translates a letter grade into a numeric grade
	 * 
	 * @param letterGrade	the letter grade to translate
	 * @return	the numeric grade
	 */
	public static double problem8_getNumericGrade(String letterGrade) {
		if (letterGrade.matches("[ABCDabcd][+-]?")) {
			double mod = 0.0;
			if (letterGrade.length()==2) {
				if (letterGrade.substring(1,2).equals("+")){
					mod=+0.3;
				}else if (letterGrade.substring(1,2).equals("-")){
					mod=-0.3;
				}
			}
			
			switch (letterGrade.substring(0,1)) {
			case "A": return 4.0+mod;
			case "B": return 3.0+mod;
			case "C": return 2.0+mod;
			case "D": return 1.0+mod;
			case "a": return 4.0+mod;
			case "b": return 3.0+mod;
			case "c": return 2.0+mod;
			case "d": return 1.0+mod;
			}
			return -1;
		}else if (letterGrade.equals("F")) {
			return 0;
		}
		else {
			return -1;
		}
	}

	
	/**
	 * Translates a numeric grade into a letter grade
	 * 
	 * @param numericGrade	the numeric grade to translate
	 * 
	 * @return	the letter grade
	 */
	public static String problem8_getLetterGrade(double numericGrade) {
		if (numericGrade>=0 && numericGrade<0.5) {
			return "F";
		}else if(numericGrade>=0.5 && numericGrade<0.85) {
			return "D-";
		}else if (numericGrade>=0.85 && numericGrade<1.15) {
			return "D";
		}else if (numericGrade>=1.15 && numericGrade<1.5) {
			return "D+";
		}else if (numericGrade>=1.5 && numericGrade<1.85) {
			return "C-";
		}else if (numericGrade>=1.85 && numericGrade<2.15) {
			return "C";
		}else if (numericGrade>=2.15 && numericGrade<2.5) {
			return "C+";
		}else if (numericGrade>=2.5 && numericGrade<2.85) {
			return "B-";
		}else if (numericGrade>=2.85 && numericGrade<3.15) {
			return "B";
		}else if (numericGrade>=3.15 && numericGrade<3.5) {
			return "B+";
		}else if (numericGrade>=3.5 && numericGrade<3.85) {
			return "A-";
		}else if (numericGrade>=3.85 && numericGrade<4.0) {
			return "A";
		}else if (numericGrade==4) {
			return "A+";
		}
		else {
			return "Error";
		}
	}
	
	
	/**
	 * If one or both of the first 2 chars in the given string is the char 'x' 
	 * (lower case only), returns the string without those 'x' chars. Otherwise, 
	 * returns the string unchanged. 
	 * 
	 * @param str	the string to change
	 * 
	 * @return	the changed string
	 */
	public static String problem10_withoutX2(String str) {
		if (str.length()>2) {
			str=str.substring(0,2).replace("x", "")+str.substring(2);
		}else {
			str=str.replace("x", "");
		}
		return str;
	}
	
	public static void main(String args[]) {
		
		
	}
}
