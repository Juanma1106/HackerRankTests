package com;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

class Student {

	String name;
	Float cgpa;
	int id;

	public Student(String name, Float cgpa, int id) {
		this.name = name;
		this.cgpa = cgpa;
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public Float getCgpa() {
		return this.cgpa;
	}

	public Integer getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", cgpa=" + cgpa + ", id=" + id + "]";
	}
}

class MyComparator2 implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		int comp = s2.getCgpa().compareTo(s1.getCgpa());
		if (comp == 0) {
			comp = s1.getName().compareTo(s2.getName());
		}
		if (comp == 0) {
			comp = s1.getId().compareTo(s2.getId());
		}
		return comp;
	}
}

class Priorities {

	TreeSet<Student> students;

	public Priorities() {
		MyComparator2 myComparator = new MyComparator2();
		this.students = new TreeSet(myComparator);
	}

	public List<Student> getStudents(List<String> events) {
		for (String event : events) {
			if (event.equals("SERVED")) {
				students.pollFirst();
			} else {
				String[] enterValues = event.split(" ");
				students.add(
						new Student(enterValues[1], Float.valueOf(enterValues[2]), Integer.valueOf(enterValues[3])));
			}
		}
		List<Student> studentList = new ArrayList<>();
		studentList.addAll(students);
		return studentList;
	}
}

public class PriorityQueue {

	private final static Scanner scan = new Scanner(System.in);
	private final static Priorities priorities = new Priorities();

	public static void main(String[] args) {
		int totalEvents = Integer.parseInt(scan.nextLine());
		List<String> events = new ArrayList<>();
		while (totalEvents-- != 0) {
			String event = scan.nextLine();
			events.add(event);
		}
		List<Student> students = priorities.getStudents(events);
		if (students.isEmpty()) {
			System.out.println("EMPTY");
		} else {
			for (Student st : students) {
				System.out.println(st.getName());
			}
		}
	}
}
