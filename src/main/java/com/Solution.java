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
			printValidTag(line);
			testCases--;
		}
		in.close();
	}

	private static void printValidTag(String line) {
		char lastChar = ' ';
		boolean isTag = false;
		boolean isEndTag = false;
		List<String> tags = new ArrayList<>();
		String tag = "";
		String endTag = "";
		boolean ignore = false;
		boolean isMsg = true;
		String msg = "";
		for (int i = 0; i < line.length(); i++) {
			char letter = line.charAt(i);
			if (isTag) {
				if (letter == '/') {
					isTag = false;
					isEndTag = true;
					endTag = endTag + letter;
				} else {
					tag = tag + letter;
				}
			}
			if (letter == '<') {
				isMsg = false;
				ignore = false;
				if (isTag) {
					// Doble <
					ignore = true;
					tags = new ArrayList<>();
					tag = "";
				}
				isTag = true;
			}
			if (letter == '>') {
				if (isTag) {
					isTag = false;
					tags.add(tag);
				}
				if (isEndTag) {
					isEndTag = false;
					if (tags.size() > 0 && tags.get(tags.size() - 1).equals(endTag)) {
						tags.remove(tags.size() - 1);
					} else {
						msg = "";
					}
				}
			}
			if (isMsg) {
				msg = msg + letter;
			}
			lastChar = letter;
			if (letter == '>' && tags.size() == 0) {
				System.out.println(msg);
			}
		}
	}
}
