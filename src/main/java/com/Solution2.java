package com;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Student2 {

	private int id;
	private String fname;
	private double cgpa;

	public Student2(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}

	public int getId() {
		return id;
	}

	public String getFname() {
		return fname;
	}

	public double getCgpa() {
		return cgpa;
	}
}

class MyComparator implements Comparator<Student2> {

	public int compare(Student2 s1, Student2 s2) {
		if (s1.getCgpa() < s2.getCgpa()) {
			return 1;
		}
		if (s1.getCgpa() > s2.getCgpa()) {
			return -1;
		}
		int nameOrder = s1.getFname().compareTo(s2.getFname());
		if (nameOrder != 0) {
			return nameOrder;
		}
		return s1.getId() < s2.getId() ? 1 : -1;
	}
}

//Complete the code
public class Solution2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		List<Student2> studentList = new ArrayList<Student2>();
		while (testCases > 0) {
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();
			Student2 st = new Student2(id, fname, cgpa);
			studentList.add(st);
			testCases--;
		}
		MyComparator comp = new MyComparator();
		studentList.sort(comp);
		for (Student2 st : studentList) {
			System.out.println(st.getFname());
		}
	}
}
