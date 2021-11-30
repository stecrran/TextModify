package ie.gmit.dip;

import java.io.*;
import java.util.*;

public class ReturnValuesImpl implements ReturnValues {
	
	public String returnWord(String word) {
		return getGoogleEquivalent(word);
	}

	public String getWordMap() {
		return wordMapping();
	}

	public void wordMapToFile() {
		printMap();
	}
	

	private String getGoogleEquivalent(String word) {
		StringBuilder sb = new StringBuilder();
		if (word.contains(" ")) {
			String[] words = word.split(" ");
			for (String eachWord : words) {
				if (ParseFiles.map.containsKey(eachWord.toLowerCase())) { // O(log N) for all Map searches?
					if (eachWord.equals(ParseFiles.map.get(eachWord.toLowerCase()))) {
						sb.append(ConsoleColour.WHITE); // word already exists
						sb.append(ParseFiles.map.get(eachWord.toLowerCase()) + " ");
					} else {
						sb.append(ConsoleColour.RED_BOLD_BRIGHT); // Google word shows in red
						sb.append(ParseFiles.map.get(eachWord.toLowerCase()) + " ");
					}
				} else {
					sb.append(ConsoleColour.GREEN_BOLD_BRIGHT); // word not in map
					sb.append(eachWord.toLowerCase() + " ");
				}
			}

		} else {
			if (ParseFiles.map.containsKey(word.toLowerCase())) {
				if (word.toLowerCase().equals(ParseFiles.map.get(word.toLowerCase()))) {
					sb.append(ConsoleColour.WHITE); // word already exists
					sb.append((ParseFiles.map.get(word.toLowerCase())));
				} else {
					sb.append(ConsoleColour.RED_BOLD_BRIGHT); // Google word shows in red
					sb.append((ParseFiles.map.get(word.toLowerCase())));
				}
			} else {
				sb.append(ConsoleColour.GREEN_BOLD_BRIGHT); // word not in map
				sb.append(word);
			}
		}
		return sb.toString();
	}


	public void sortedList() {
		List<String> sortedSet = new ArrayList<>(Parser.set);
		System.out.println(ConsoleColour.WHITE_BRIGHT);
		Collections.sort(sortedSet);
		System.out.println(sortedSet);
	}

	private String wordMapping() { 
		StringBuilder sb = new StringBuilder();
		SortedMap<String, String> sortMap = new TreeMap<String, String>(Parser.map);
		Set s = sortMap.entrySet();

		Iterator i = s.iterator(); // Using iterator in SortedMap

		while (i.hasNext()) { // Traverse map.
			Map.Entry m = (Map.Entry) i.next();

			String key = (String) m.getKey();
			String value = (String) m.getValue();

			sb.append("Key : " + key + "  value : " + value + "\n");
		}
		return sb.toString();
	}

	private void printMap() {

		try {
			System.out.println();
			System.out.println("Enter the name of the output file. \n> ");
			Scanner outputFile = new Scanner(System.in);
			String outFilename = outputFile.nextLine();

			FileWriter fw = new FileWriter(outFilename);

			fw.write(wordMapping());

			fw.flush();
			fw.close();
			System.out.println("Word mapping printed to: " + outFilename);
			System.out.println();

		} catch (Exception e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}