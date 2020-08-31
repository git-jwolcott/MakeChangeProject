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
	String output = "The customer is due $" + String.format("%.2f",changeDue) + ". Give the customer ";
	
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
	//determine the number and type of bill(s) to be returned
	else { getBillsDue(changeDue, output);}
	
	//close scanner
	input.close();
}
	
	private static void getBillsDue(double changeDue, String output) {
		//create local variables to hold number of bills needed and output string
		int numTwenties = 0, numTens = 0, numFives = 0, numOnes = 0; 
		
			//determine the number of twenties to provide 
			if(changeDue % 20 == 0 ||((changeDue % 20) >= 1)) {
				//determine how many twenties to provide
				numTwenties = (int)changeDue/20;
				//adjust changeDue
				changeDue = changeDue - (numTwenties * 20);
			}
			//determine the number of tens to provide
			if(changeDue % 10 == 0 || ((changeDue % 10) >= 1)) {
				//determine how many tens to provide
				numTens = (int)changeDue/10;
				//adjust changeDue
				changeDue = changeDue - (numTens * 10);
			}
			//determine the number of fives to provide
			if (changeDue % 5 == 0 || ((changeDue % 5) >= 1)) {
				//determine number of fives to provide
				numFives = (int)changeDue/5;
				changeDue = changeDue - (numFives * 5);
				//adjust changeDue
			}
			//determine the number of ones to provide
			if (changeDue % 1 == 0 || ((changeDue % 1) <= 1)) {
				//determine the number of ones to provide
				numOnes = (int)changeDue/1;
				//adjust changeDue
				changeDue = changeDue - numOnes;
			}
			
			int centsDue = (int)(Math.round(changeDue * 100));
 			
			//format the output to only show bills with a value to be provided
			//show the number of $20, $10, $5, $1 returned
			if(numTwenties > 0) {output += numTwenties == 1 ? numTwenties + " twenty dollar bill, " : numTwenties + " twenty dollar bills, ";}
			if(numTens > 0) {output += numTens == 1 ? numTens + " ten dollar bill, " : numTens + " ten dollar bills, ";}
			if(numFives > 0) {output += numFives == 1 ? numFives + " five dollar bill, " : numFives + " five dollar bills, ";}
			if(numOnes > 0) { output +=numOnes == 1 ?numOnes + " one dollar bill, " : numOnes + " one dollar bills, ";}
			
			//determine if any coins are to be returned
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
				
		//format the output to only show coins with a value to be provided
		//show the number of 0.25c, 0.10c, 0.05c, 0.01c returned
		if(numQtrs > 0) {output += numQtrs == 1 ? numQtrs + " quarter, " : numQtrs + " quarters, ";}
		if(numDimes > 0) {output += numDimes == 1 ? numDimes + " dime, " : numDimes + " dimes, ";}
		if(numNickels > 0) {output += numNickels == 1 ? numNickels + " nickle, " : numNickels + " nickles, ";}
		if(numPennies > 0) {output += numPennies == 1 ? numPennies + " penny. " : numPennies + " pennies. ";					
		}
		output = (output.substring(0, output.length() - 2)+ ".");
		printOutput(output);
	}

	//print the number of bills and coins to be given to the customer
	private static void printOutput(String output) {
		System.out.println();
		System.out.println(output);
	}
}
