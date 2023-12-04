package com;

import java.security.MessageDigest;
import java.util.Scanner;
import javax.xml.bind.DatatypeConverter;

public class Sha256Hash {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			String line = scan.nextLine();
			byte[] bytesOfMessage = line.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] theMD5digest = md.digest(bytesOfMessage);
			String hash = DatatypeConverter.printHexBinary(theMD5digest).toLowerCase();
			System.out.println(hash);
		} catch (Throwable ex) {
		}
	}
}
