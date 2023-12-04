package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while (testCases > 0) {
			String line = in.nextLine();
			Solution solution = new Solution();
			solution.printContentWithinValidTags(line);
			testCases--;
		}
		in.close();
	}

	private void printContentWithinValidTags(String line) {
		List<String> startTags = new ArrayList<>();
		List<String> endTags = new ArrayList<>();
		String[] starts = line.split("<");
		for (int i = 1; i < starts.length; i++) {
			if (starts[i].contains(">")) {
				int endPos = starts[i].indexOf(">");
				String tag = starts[i].substring(0, endPos);
				if (starts[i].charAt(0) == '/') {
					endTags.add(tag);
				} else {
					startTags.add(tag);
				}
			}
		}
		for (int i = 1; i < starts.length; i++) {
			if (starts[i].contains(">")) {
			}
		}
		/*
		 * 
		 * boolean printAnything = false; boolean isStartTag = false; boolean isEndTag =
		 * false; List<String> startTags = new ArrayList<>(); List<String> endTags = new
		 * ArrayList<>(); String tag = ""; String phraseToPrint = ""; for (int i = 0; i
		 * < line.length(); i++) { char currentChar = line.charAt(i); if (currentChar ==
		 * '<') { if(isStartTag || isEndTag) { phraseToPrint = phraseToPrint + tag; }
		 * tag = ""; i++; if (i >= line.length()) { break; } currentChar =
		 * line.charAt(i); if (currentChar == '/') { isEndTag = true; } else if
		 * (currentChar == '>') { // } else { isStartTag = true; phraseToPrint = ""; tag
		 * = tag + currentChar; } } else if (currentChar == '>') { if (isStartTag) { if
		 * (!tag.isEmpty()) { startTags.add(tag); } tag = ""; isStartTag = false; } else
		 * if (isEndTag) { if (!tag.isEmpty()) { endTags.add(tag); } tag = ""; isEndTag
		 * = false; } else { // Puede tener una frase el caracter ">" ? } } else { if
		 * (isStartTag || isEndTag) { tag = tag + currentChar; } else if
		 * (!startTags.isEmpty()) { phraseToPrint = phraseToPrint + currentChar; } } if
		 * (!isStartTag && !isEndTag && startTags.equals(endTags) &&
		 * !phraseToPrint.isEmpty() && !startTags.isEmpty()) { printAnything = true;
		 * System.out.println(phraseToPrint); phraseToPrint = ""; } } if
		 * (!printAnything) { System.out.println("None"); }
		 */
	}
}
