import java.util.Scanner;
/*
 * 
 * Zachariah Zatina
 * 
 * This app is a game that generates a random
 * number and asks the user to guess said number.
 * 
 */
public class GuessNumberGame {
	
	public static void main(String[] args) {
		
		// Variable list
		Scanner scnr = new Scanner(System.in);
		int randomNum;
		int caseDecider;
		int userGuess = -1;
		char cont = 'a';
		int i = 0;
		boolean a = true;
		boolean isTrue = false;
		
		// Application introduction
		System.out.println("Welcome to the Number Guessing Game!!");
		System.out.println("=====================================");
		System.out.println("");
		
		// While loop to keep application going based on user input
		while (a == true) {
			// have this here so it resets the loop later and allows app to ask to continue after the second round and beyond
			isTrue = false;
			// Assigns a random number value to the corresponding variable
			randomNum = (int) (Math.random() * 100) + 1;
			
			// Prompts user for first input
			System.out.print("Take your first guess, you horrible guesser: ");
			
			// Validates for letters and non integer numbers
			while (userGuess != randomNum) {
				while(!scnr.hasNextInt()) {
					System.out.println("");
					System.out.print("OI! Enter an actual whole number bro! : ");
					scnr.nextLine();
				}
				userGuess = scnr.nextInt();
				// This counts how many rolls have been made will be used later as well
				i = i + 1;
				
				// A random number is chosen which then corresponds to a case from the switch statement which then outputs a snappy come back if user guesses wrong
				caseDecider = (int) ((Math.random() * 10) / 2);
				// Makes sure this number is not 0.
				while (caseDecider == 0)
					caseDecider = caseDecider + 1;
				
				// The statements used if the user guesses less than the actual value
				if (userGuess < randomNum) {

					switch (caseDecider) {
					case 1:
						System.out.println("");
						System.out.print("Wow you are low, way to go. Guess again: ");
						break;
					case 2:
						System.out.println("");
						System.out.print(
								"I've never seen anybody be so low with a guess. I'll give you another chance: ");
						break;
					case 3:
						System.out.println("");
						System.out.print("I don't think it's possible to be any lower with a guess! Try again: ");
						break;
					case 4:
						System.out.println("");
						System.out.print(
								"You must love guessing numbers that are too low. There's no way you'll get it with this guess: ");
						break;
					default:
						System.out.println("");
						System.out.print(
								"Now you know that if you keep guessing to low you'll never guess my number. Guess one more time: ");
						break;
					}
					continue;
				} 
				// if the user gets it right it pushes through the loop
				else if (userGuess == randomNum) {
					continue;
				} 
				// Switch statement if the user is above the randomInt
				else {
					switch (caseDecider) {
					case 1:
						System.out.println("");
						System.out.print("That number is too high to fly. Another one: ");
						break;
					case 2:
						System.out.println("");
						System.out.print("Birds can't even fly as high as that number was. Guess again: ");
						break;
					case 3:
						System.out.println("");
						System.out.print("You're on top of the world, too high. Try again: ");
						break;
					case 4:
						System.out.println("");
						System.out.print(
								"Guessing too high of numbers must come as easy to you as breathing. Go again: ");
						break;
					default:
						System.out.println("");
						System.out.print(
								"You are not the best at guessing, that number is too high! Here's another chance to guess: ");
						break;
					}

				}
			}
			// Depending on the number of guesses it outputs a different response. The I variable is used here.
			if (i <= 5) {
				System.out.println("");
				System.out.println("Wow! You guessed correctly in " + i + " tries, you're pretty good at this!");
			} else {
				System.out.println("");
				System.out
						.println("It took you " + i + " tries to guess correctly? You really need to work on that...");
			}
			
			// This part prompts the user asking if they want to play the game again.
			scnr.nextLine();
			System.out.println("");
			System.out.print("Would you like to try again you not good at guessing guy?? (y/n): ");
			// This while loop is to see if the entire app loops again AND validates for non 'y' and 'n' characters with some added snark
			while (isTrue == false) {
				cont = scnr.next().charAt(0);

				if (cont == 'y') {
					isTrue = true;
					i = 0;
					System.out.println("");
					continue;
				} else if (cont == 'n') {
					isTrue = true;
					a = false;
				} else {
					if (i > 5) {
						System.out.println("");
						System.out.print(
								"Wow, you are just as bad at following directions as you are at guessing numbers! Enter y (for yes) or n (for no): ");
						isTrue = false;
					} else {
						System.out.println("");
						System.out.print("Hey, bud, you need to put y (for yes) or n (for no): ");
						isTrue = false;
					}
				}

			}

		}
		// End of app statement.
		System.out.println("");
		System.out.println("Thanks for playing! I had a TON of fun, come back soon!");
		scnr.close();
	}

}
