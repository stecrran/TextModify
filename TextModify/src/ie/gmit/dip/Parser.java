package ie.gmit.dip;

import java.util.*;
import java.io.*;

public class Parser implements ParseFiles {

	/**
	 * {@inheritDoc}
	 */
	public void initFiles() {
		initWordFile();
		initThesaurus();
	}

	/**
	 * {@inheritDoc}
	 */
	public void resetFiles() {
		set.clear();
		map.clear();
		initWordFile();
		initThesaurus();
		System.out.println(ConsoleColour.WHITE_BOLD_BRIGHT);
		System.out.println("Word and Thesaurus files reset!");
	}

	/**
	 * Method for Parsing of values contained in a referenced word file (*.txt).
	 * Uses a buffered reader to read a text file line by line and parse words to a
	 * Map (map String to itself) and then parse all words to a reference Set. 
	 * 
	 * Takes input for a file name and checks that the file exists.
	 * 
	 */
	private void initWordFile() {
		System.out.println("Enter the name of the word file. \n> ");
		Scanner inputFile1 = new Scanner(System.in);
		String inFilename1 = inputFile1.nextLine();

		File WordFile = new File(inFilename1);

		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(WordFile)));
			String line = null;

			while ((line = br.readLine()) != null) {
				map.put(line, line);
				set.add(line);
			}

		} catch (Exception e) {
			System.out.println("An error occurred.");
			System.out.println("Have you entered a valid Word file name?");
			System.out.println();
			initWordFile();
			System.out.println();
		}
		
	}

	/**
	 * Method for Parsing of values contained in a referenced Thesaurus file (*.txt).
	 * Uses a buffered reader to read a text file line by line. Splits words in each line into
	 * a String array. Loops through words in the referenced Thesaurus file and checks to see 
	 * if word (String) exists in the Set populated by <b>initWordFile()</b>. If so, assigns this 
	 * to String <i>googleWord</i>. 
	 * Calls <b>addAll()</b> method to assign each word match in Thesaurus to corresponding word in Set. 
	 * 
	 * Takes input for a file name and checks that the file exists.
	 */
	private void initThesaurus() {
		System.out.println("Enter the name of the Thesaurus file. \n> ");
		Scanner inputFile2 = new Scanner(System.in);
		String inFilename2 = inputFile2.nextLine();

		File ThesaurusFile = new File(inFilename2);
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(ThesaurusFile)));
			String line = null;

			while ((line = br.readLine()) != null) {
				String[] words = line.split(",");
				String googleWord = null;

				for (String word : words) {
					if (set.contains(word)) {
						googleWord = word;
						break;
					}
				}

				if (googleWord != null) {
					addAll(words, googleWord);
				}
			}

		} catch (Exception e) {
			System.out.println("An error occurred.");
			System.out.println("Have you entered a valid Thesaurus file name?");
			System.out.println();
			initThesaurus();
			System.out.println();
		}

	}
	
	/**
	 * Maps words in String array to a corresponding word.
	 * 
	 * @param words	The String array to be looped upon. 
	 * @param googleWord The word to be compared to words in the String array loop.
	 */
	private void addAll(String[] words, String googleWord) { 
		for (String word : words) {
			map.put(word.toLowerCase(), googleWord);
		}
	}
}