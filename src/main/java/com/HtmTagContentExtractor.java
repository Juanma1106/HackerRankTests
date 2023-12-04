package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HtmTagContentExtractor {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		boolean print = false;
		int i = 0;
		while (testCases > 0) {
			String line = in.nextLine();
			i++;
			HtmTagContentExtractor solution = new HtmTagContentExtractor();
			if (i == 2) {
				print = false;
			}
			solution.printContentWithinValidTags(line, print);
			print = false;
			testCases--;
		}
	}

	private void printContentWithinValidTags(String line, boolean print) {
		boolean almostOneShowed = false;
		String textToShow = "";
		int j = 0;
		String[] ends = line.split("</");
		List<String> initTags = new ArrayList<String>();
		String endTag = "";
		String initTextTag = ends[0];
		String text = getInitTagsAndTextToShow(initTextTag, initTags);
		if (text != null) {
			textToShow = text;
		}
		for (int i = 1; i < ends.length; i++) {
			String end = ends[i];
			int pos = end.indexOf(">");
			if (pos == -1) {
				continue;
			}
			endTag = end.substring(0, pos);
			if (pos + 1 == end.length()) {
				// Solo tenemos el endTag y nada mas
				boolean showed = checkShowMessage(textToShow, endTag, initTags, print);
				textToShow = "";
				initTags.clear();
				if (showed) {
					almostOneShowed = true;
				}
			} else {
				// Comienza un nuevo InitTag.
				// Chequeamos si tenemos que mostrar mensaje:
				boolean showed = checkShowMessage(textToShow, endTag, initTags, print);
				initTags.clear();
				textToShow = "";
				if (showed) {
					almostOneShowed = true;
				}
				initTextTag = end.substring(pos + 1, end.length());
				text = getInitTagsAndTextToShow(initTextTag, initTags);
				if (text != null) {
					textToShow = text;
				}
			}
		}
		if (!almostOneShowed) {
			System.out.println("None");
		}
	}

	private boolean checkShowMessage(String textToShow, String endTag, List<String> initTags, boolean print) {
		if (print) {
			System.out.println("textToShow: " + textToShow);
			System.out.println("endTag: " + endTag);
			System.out.println("initTags: " + initTags);
		}
		boolean showed = false;
		if (!initTags.isEmpty() && !endTag.isEmpty()) {
			boolean showMessage = false;
			if (initTags.get(0).equals(endTag)) {
				showMessage = true;
			}
			if (showMessage && !textToShow.isEmpty()) {
				System.out.println(textToShow);
				showed = true;
			}
		}
		return showed;
	}

	private String getInitTagsAndTextToShow(String init, List<String> initTags) {
		String inits[] = init.split("<");
		if (inits.length > 1) {
			int last = inits.length - 1;
			String aux = inits[last];
			if (aux.indexOf(">") > 0) {
				String auxArr[] = aux.split(">");
				initTags.add(auxArr[0]);
				if (auxArr.length > 1) {
					return auxArr[1];
				}
			}
		}
		return null;
	}
}
