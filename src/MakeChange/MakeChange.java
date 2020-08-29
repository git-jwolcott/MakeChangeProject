package MakeChange;

import java.util.Scanner;

public class MakeChange {

	public static void main(String[] args) {
	//create Scanner to obtain user input
	Scanner input = new Scanner(System.in);
		
	//get the purchase price
	System.out.print("What is the price of the item?");
	double purchasePrice = input.nextDouble();
	
	//get the amount paid
	System.out.print("How much money did you receive?");
	double amountPaid = input.nextDouble();
	
	int numTwenties = 0, numTens = 0, numFives = 0, numOnes = 0, numQtrs = 0, numDimes = 0, numNickels = 0, numPennies = 0;
	
	//evaluate the purchase price v. amount paid
	//if amount paid is less than purchase price, "too little"
	if(amountPaid < purchasePrice) {
		System.out.println("Not enough money was tendered!");
	}
	//if amount paid and purchase price are equal, "no change"
	else if(amountPaid == purchasePrice ) {
		System.out.println("Exact amount tenedered. No change required.");
	}
	//if amount paid is greater than purchase price, make change
	else {
		double changeAmt = amountPaid - purchasePrice;
		System.out.println("Starting Change Amt: " + changeAmt);
		//determine the number of twenties to provide 
		if(changeAmt % 20 == 0 ||((changeAmt % 20) > 1)) {
			//determine how many twenties to provide
			numTwenties = (int)changeAmt/20;
			changeAmt = changeAmt - (numTwenties * 20);
		}
		//determine the number of tens to provide
		if(changeAmt % 10 == 0 || ((changeAmt % 10) > 1)) {
			//determine how many tens to provide
			numTens = (int)changeAmt/10;
			changeAmt = changeAmt - (numTens * 10);
		}
		//determine the number of fives to provide
		if (changeAmt % 5 == 0 || ((changeAmt % 5) > 1)) {
			//determine number of fives to provide
			numFives = (int)changeAmt/5;
			changeAmt = changeAmt - (numFives * 5);
		}
		//determine the number of ones to provide
		if (changeAmt % 1 == 0 || ((changeAmt % 1) < 1)) {
			//determine the number of ones to provide
			numOnes = (int)changeAmt/1;
			changeAmt = changeAmt - numOnes;
		}
		//change amount of cents to return to a whole number
		changeAmt = Math.round(changeAmt * 100);
		
		
		//determine the number of quarters to provide
		if (changeAmt > 25) {
			numQtrs = (int)changeAmt/25;
			changeAmt = changeAmt - (numQtrs * 25);
		}
		//determine the number of dimes to provide
		if (changeAmt > 10) {
			//determine the number of dimes to provide
			numDimes = (int)changeAmt/10;
			changeAmt = changeAmt - (numDimes * 10);
		}
		//determine the number of nickels to provide
		if (changeAmt > 5){
			//determine the number of nickels to provide
			numNickels = (int)changeAmt/5;
			changeAmt = changeAmt - (numNickels * 5);
		}
		//determine the number of pennies to provide
		if (changeAmt <= 4){
			//determine the number of pennies to provide
			numPennies = (int)changeAmt/1;
		}
		
		//format the output to only show bills and coins with a value to be provided
		//show the number of ($20, $10, $5, $1, 0.25c, 0.10c, 0.05c, 0.01c) returned
		System.out.print("Provide the customer with: ");
		if(numTwenties > 0) {
			System.out.print("Twenties: " + numTwenties);
		}
		if(numTens > 0) {
			System.out.print(" Tens: " + numTens);
		}
		if(numFives > 0) {
			System.out.print(" Fives: " + numFives);
		}
		if(numOnes > 0) {
			System.out.print(" Ones: " + numOnes);
		}
		if(numQtrs > 0) {
			System.out.print(" Quarters: " + numQtrs);
		}
		if(numDimes > 0) {
			System.out.print(" Dimes: " + numDimes);
		}
		if(numNickels > 0) {
			System.out.print(" Nickles: " + numNickels);
		}
		if(numPennies > 0) {
			System.out.print(" Pennies: " + numPennies);
		}
}
	
	
		
		input.close();

	}

}
