package lab02;

import java.util.Random;
import java.util.Scanner;

public class RollDice {
	public static void main(String args[]) {
		Random randomNumbers = new Random();
		Scanner input = new Scanner(System.in);

		int rollNum;
		int diceNum;
		
		// input the number of dices and rolls
		System.out.print("Enter number of dices: ");
		diceNum = input.nextInt();
		System.out.print("Enter number of rolls: ");
		rollNum = input.nextInt();
		
		
		// initialize the array to store the frequency
		int totals[] = new int[6*diceNum + 1]; // frequencies of the sums
		for (int index = 0; index < totals.length; index++)
			totals[index] = 0;

		// roll the dice
		for (int roll = 1; roll <= rollNum; roll++) {
			int index = 0;
			for (int dice = 1; dice <= diceNum; dice++)
			{
				index += 1 + randomNumbers.nextInt(6);
			}
			totals[index]++;
		} // end for

		// print the table
		System.out.printf("%3s%12s%12s\n", "Sum", "Frequency", "Percentage");

		// ignore subscripts 0 and 1
		for (int k = diceNum; k < totals.length; k++) {
			double percent = (double) totals[k] / rollNum * 100;
			System.out.printf("%3d%12d%12.2f ", k, totals[k], percent);
			for (int i = 0; i < percent; i++) {
				System.out.printf("*");
			}
			System.out.println();
		} // end for
		input.close();
	} // end main
}