package MakeChange;

import java.util.Scanner;

public class MakeChange {

	public static void main(String[] args) {
	//create Scanner to obtain user input
	Scanner input = new Scanner(System.in);
		
	//get the purchase price
	System.out.print("What is the price of the item? ");
	double purchasePrice = input.nextDouble();
	
	//get the amount paid
	System.out.print("How much money did the customer pay? ");
	double amountPaid = input.nextDouble();
	
	double changeDue = amountPaid - purchasePrice;

	String output = "The customer is due $" + changeDue + ". Give the customer ";
	
	//evaluate the purchase price v. amount paid
	//if amount paid is less than purchase price, "too little"
	if(changeDue < 0) {
		System.out.println("That is not enough money to cover the bill.");
	}
	//if amount paid and purchase price are equal, "no change"
	else if(changeDue == 0 ) {
		System.out.println("The exact payment amount was received. No change required.");
	}
	//if amount paid is greater than purchase price, make change
	else { getBillsDue(changeDue, output);}
	
	input.close();
}

	private static void printOutput(String output) {
		System.out.println();
		System.out.println(output);
	}

	
	private static void getBillsDue(double changeDue, String output) {
		//create local variables to hold number of bills needed and output string
		int numTwenties = 0, numTens = 0, numFives = 0, numOnes = 0; 
		
			//determine the number of twenties to provide 
			if(changeDue % 20 == 0 ||((changeDue % 20) >= 1)) {
				//determine how many twenties to provide
				numTwenties = (int)changeDue/20;
				changeDue = changeDue - (numTwenties * 20);
			}
			//determine the number of tens to provide
			if(changeDue % 10 == 0 || ((changeDue % 10) >= 1)) {
				//determine how many tens to provide
				numTens = (int)changeDue/10;
				changeDue = changeDue - (numTens * 10);
			}
			//determine the number of fives to provide
			if (changeDue % 5 == 0 || ((changeDue % 5) >= 1)) {
				//determine number of fives to provide
				numFives = (int)changeDue/5;
				changeDue = changeDue - (numFives * 5);
			}
			//determine the number of ones to provide
			if (changeDue % 1 == 0 || ((changeDue % 1) <= 1)) {
				//determine the number of ones to provide
				numOnes = (int)changeDue/1;
				changeDue = changeDue - numOnes;
			}
			
			int centsDue = (int)(Math.round(changeDue * 100));
 			
			//format the output to only show bills and coins with a value to be provided
			//show the number of ($20, $10, $5, $1, 0.25c, 0.10c, 0.05c, 0.01c) returned
			if(numTwenties > 0) {
				if(numTwenties == 1) {
					output+= (numTwenties + " twenty dollar bill, ");
				}else {
					output+=(numTwenties + " twenty dollar bills, ");
				}
			}
			if(numTens > 0) {
				if(numTens == 1 ) {
					output+=(numTens + " ten dollar bill, ");
				}
				else { 
					output+=(numTens + " ten dollar bills, ");
				}
			}
			if(numFives > 0) {
				if(numFives == 1) {
					output+=(numFives + " five dollar bill, ");
				}
				else {
					output+=(numFives + " five dollar bills, ");
				}
			}
			if(numOnes > 0) {
				if(numOnes == 1){
					output+=(numOnes + " one dollar bill, ");					
				} else {
					output+=(numOnes + " one dollar bills, ");										
				}
			}
			getCentsDue(centsDue, output);
		}

	private static void getCentsDue(double centsDue, String output) {
		//create local to hold number of cents needed and output string
		int numQtrs = 0, numDimes = 0, numNickels = 0, numPennies = 0;

		//determine the number of quarters to provide
		if (centsDue % 25 == 0 || centsDue % 25 >= 1) {
			numQtrs = (int)centsDue/25;
			centsDue = centsDue - (numQtrs * 25);
		}
		//determine the number of dimes to provide
		if (centsDue % 10 == 0 || centsDue % 10 >= 1) {
			//determine the number of dimes to provide
			numDimes = (int)centsDue/10;
			centsDue = centsDue - (numDimes * 10);
		}
		//determine the number of nickels to provide
		if (centsDue % 5 == 0 || centsDue % 5 >= 1){
			//determine the number of nickels to provide
			numNickels = (int)centsDue/5;
			centsDue = centsDue - (numNickels * 5);
		}
		//determine the number of pennies to provide
		if (centsDue < 5){
			//determine the number of pennies to provide
			numPennies = (int)centsDue/1;
		}
		
		if(numQtrs > 0) {
			if(numQtrs == 1) {
				output+=(numQtrs + " quarter, ");
			}else {
				output+=(numQtrs + " quarters, ");
			}
		}
		if(numDimes > 0) {
			if(numDimes == 1) {
				output+=(numDimes + " dime, ");					
			}else {
				output+=(numDimes + " dimes, ");
			}
		}
		if(numNickels > 0) {
			if(numNickels == 1) {
				output+=(numNickels + " nickle, ");					
			}else {
				output+=(numNickels + " nickles, ");					
			}
		}
		if(numPennies > 0) {
			if(numPennies == 1) {
				output+=(numPennies + " penny. ");					
			} else {
				output+=(numPennies + " pennies. ");					
			}
		}
		output = (output.substring(0, output.length() - 2)+ ".");
		printOutput(output);
	}
	}
