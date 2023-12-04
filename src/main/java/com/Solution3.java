package com;

import java.util.Scanner;

public class Solution3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while (testCases > 0) {
			String line = in.nextLine();
			Solution3 solution3 = new Solution3();
			solution3.printContentWithinValidTags(line);
			testCases--;
		}
	}

	private void printContentWithinValidTags(String line) {
		String[] starts = line.split("<");
		String[] parts = new String[line.length()];
		int pos = 0;
		for (int i = 1; i < starts.length; i++) {
			String[] partsAux = starts[i].split(">");
			for (int j = 0; j < partsAux.length; j++) {
				parts[pos++] = partsAux[j];
			}
		}
		for (int i = 0; i < parts.length; i++) {
			System.out.println(parts[i]);
		}
//        boolean printAnything = false;
//        boolean isStartTag = false;
//        boolean isEndTag = false;
//        List<String> startTags = new ArrayList<>();
//        List<String> endTags = new ArrayList<>();
//        String tag = "";
//        String phraseToPrint = "";
//        for (int i = 0; i < line.length(); i++) {
//            char currentChar = line.charAt(i);
//            if (currentChar == '<') {
//                if(isStartTag || isEndTag) {
//                    phraseToPrint = phraseToPrint + tag;
//                }
//                tag = "";
//                i++;
//                if (i >= line.length()) {
//                    break;
//                }
//                currentChar = line.charAt(i);
//                if (currentChar == '/') {
//                    isEndTag = true;
//                } else if (currentChar == '>') {
//                    //
//                } else {
//                    isStartTag = true;
//                    phraseToPrint = "";
//                    tag = tag + currentChar;
//                }
//            } else if (currentChar == '>') {
//                if (isStartTag) {
//                    if (!tag.isEmpty()) {
//                        startTags.add(tag);
//                    }
//                    tag = "";
//                    isStartTag = false;
//                } else if (isEndTag) {
//                    if (!tag.isEmpty()) {
//                        endTags.add(tag);
//                    }
//                    tag = "";
//                    isEndTag = false;
//                } else {
//                    // Puede tener una frase el caracter ">" ?
//                }
//            } else {
//                if (isStartTag || isEndTag) {
//                    tag = tag + currentChar;
//                } else if (!startTags.isEmpty()) {
//                    phraseToPrint = phraseToPrint + currentChar;
//                }
//            }
//            if (!isStartTag && !isEndTag && startTags.equals(endTags) && !phraseToPrint.isEmpty() && !startTags.isEmpty()) {
//                printAnything = true;
//                System.out.println(phraseToPrint);
//                phraseToPrint = "";
//            }
//        }
//        if (!printAnything) {
//            System.out.println("None");
//        }
	}
}
