package com;

public class UserInput {

	public static class TextInput {

		protected String text = "";

		public void add(char c) {
			text = text + c;
		}

		public String getValue() {
			return text;
		}
	}

	public static class NumericInput extends TextInput {

		public void add(char c) {
			if (Character.isDigit(c)) {
				super.add(c);
			}
		}
	}

	public static void main(String[] args) {
		TextInput input = new NumericInput();
		input.add('1');
		input.add('a');
		input.add('0');
		System.out.println(input.getValue());
	}
}
