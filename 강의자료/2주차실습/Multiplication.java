package lab02;

import java.util.Random;
import java.util.Scanner;

public class Multiplication {
	// create the random object here so you can use in this class
	Random randomNumbers = new Random();

	// ask the user to answer multiplication problems
	public void quiz() {
		Scanner input = new Scanner(System.in);

		int guess;	// the user's guess
		int answer; // the correct answer

		// display the first question
		answer = createQuestion();

		System.out.print("Enter your answer (-1 to exit):");
		guess = input.nextInt();

		while (guess != -1) {
			// checks if the user answered correctly
			if (guess != answer)
				System.out.println(createResponse(false));
			else {
				System.out.println(createResponse(true));
				System.out.println("============================");
				answer = createQuestion();
			}
			System.out.print("Enter your answer (-1 to exit):");
			guess = input.nextInt();
		}
		input.close();
	}

	// prints a new question and stores the corresponding answer
	public int createQuestion() {
		// get two random numbers between 1 and 9
		int digit1 = 1 + randomNumbers.nextInt(9);
		int digit2 = 1 + randomNumbers.nextInt(9);

		System.out.printf("How much is %d x %d?\n", digit1, digit2);
		return (digit1 * digit2);
	}

	// create a new random response
	public String createResponse(boolean correct) {
		String[] strCorrect = new String[] { "Very Good!", 
				"Excellent!",
				"Nice work!", 
				"Keep up the good work!" };
		String[] strIncorrect = new String[] { "No. Please try again.",
				"Wrong. Try once more.", 
				"Don't give up!", 
				"No. Keep trying." };
		
		String retStr;
		int index;
		
		if (correct) {
			index = randomNumbers.nextInt(strCorrect.length);
			retStr =  strCorrect[index];
		} else {
			index = randomNumbers.nextInt(strIncorrect.length);
			retStr = strIncorrect[index];
		}
		return retStr;
	}
	
	
	public static void main(String args[]) {
		Multiplication app = new Multiplication();
		app.quiz();
	}
} // end class Multiply