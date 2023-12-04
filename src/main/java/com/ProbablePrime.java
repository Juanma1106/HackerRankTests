package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class ProbablePrime {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String n = bufferedReader.readLine();
		BigInteger numBI = new BigInteger(n);
		boolean isPrime = numBI.isProbablePrime(100);
		System.out.println(isPrime ? "prime" : "not prime");
		bufferedReader.close();
	}
}
