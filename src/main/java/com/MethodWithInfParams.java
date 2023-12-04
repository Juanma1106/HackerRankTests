package com;

import static java.lang.System.in;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

class Prime {

	boolean check(Integer n1) {
		boolean isPrime = true;
		if (n1 < 2) {
			isPrime = false;
		} else if (n1 > 2) {
			for (int i = 2; i <= Math.floor(n1 / 2); i++) {
				if (n1 % i == 0) {
					isPrime = false;
					break;
				}
			}
		}
		return isPrime;
	}

	void checkPrime(Integer... n) {
		boolean f = false;
		for (int i = 0; i < n.length; i++) {
			if (check(n[i])) {
				if (f) {
					// java.lang.System.out.print(" ");
					System.out.print(" ");
				}
				f = true;
				System.out.print(n[i]);
			}
		}
		System.out.println();
	}
}

public class MethodWithInfParams {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			int n1 = Integer.parseInt(br.readLine());
			int n2 = Integer.parseInt(br.readLine());
			int n3 = Integer.parseInt(br.readLine());
			int n4 = Integer.parseInt(br.readLine());
			int n5 = Integer.parseInt(br.readLine());
			Prime ob = new Prime();
			ob.checkPrime(n1);
			ob.checkPrime(n1, n2);
			ob.checkPrime(n1, n2, n3);
			ob.checkPrime(n1, n2, n3, n4, n5);
			Method[] methods = Prime.class.getDeclaredMethods();
			Set<String> set = new HashSet<>();
			boolean overload = false;
			for (int i = 0; i < methods.length; i++) {
				if (set.contains(methods[i].getName())) {
					overload = true;
					break;
				}
				set.add(methods[i].getName());
			}
			if (overload) {
				throw new Exception("Overloading not allowed");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
