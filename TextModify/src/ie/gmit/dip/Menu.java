package ie.gmit.dip;

import java.util.*;

public class Menu extends Parser {

	ReturnValuesImpl rv = new ReturnValuesImpl();

	private Scanner input;

	private boolean running = true;

	public void start() {
		initFiles();
		input = new Scanner(System.in);

		while (running) {

			showOptions();

			try {
				int selection = Integer.parseInt(input.next());

				if (selection == 1) { // Enter text to simplify
					System.out.println("Enter the text you want to simplify. \n> ");
					Scanner testString = new Scanner(System.in);

					System.out.println(rv.returnWord(testString.nextLine()));
					// testString.close();

				} else if (selection == 2) { // Reset All
					resetFiles();

				} else if (selection == 3) { // Print sorted list of Google words
					rv.sortedList();

				} else if (selection == 4) { // Print mapping for each word (on-screen)
					System.out.println(rv.getWordMap());

				} else if (selection == 5) { // Print mapping for each word (to file)
					rv.wordMapToFile();

				} else if (selection == 0) { // Quit
					running = false;

				} else { // Invalid input
					System.out.println("Invalid choice!");
				}

			} catch (NumberFormatException ex) { // handle text entry instead of numerical value
				System.out.println("Selection must be numerical value [0-5]");
				System.out.println();
				// break; // adding break in case multiple words are entered
			}
		}
	}

	private void showOptions() {
		System.out.println(ConsoleColour.BLUE_BRIGHT);
		System.out.println("***************************************************");
		System.out.println("*             Text Simplifier V1.0                *");
		System.out.println("*                                                 *");
		System.out.println("***************************************************");

		System.out.println("(1) Enter Text to simplify.");
		System.out.println("(2) Reset Word and Thesaurus file.");
		System.out.println("(3) Print sorted word list.");
		System.out.println("(4) Print word mapping on-screen.");
		System.out.println("(5) Print word mapping to file.");
		System.out.println("(0) Quit.");
		System.out.println("Select an option [0-5]> ");
		System.out.print(ConsoleColour.GREEN_BOLD_BRIGHT);

		System.out.println(ConsoleColour.RESET);

	}

}