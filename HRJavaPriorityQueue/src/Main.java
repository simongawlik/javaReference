
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Student{
	private int token;
	private String fname;
	private double cgpa;
	public Student(int id, String fname, double cgpa) {
		super();
		this.token = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getToken() {
		return token;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}
   
	public String toString() {
		return fname;
	}
}

class StudentComparator implements Comparator<Student> {
	
	@Override
	public int compare(Student s1, Student s2) {
		if (s1.getCgpa() == s2.getCgpa()) {
			if (s1.getFname().equals(s2.getFname())) {
				return s1.getToken() - s2.getToken();
			} else {
				return s1.getFname().compareTo(s2.getFname());
			}
		} else {
			if (s1.getCgpa() < s2.getCgpa()) return 1;
			if (s1.getCgpa() > s2.getCgpa()) return -1;
			return 0;
		}
	}
}


/*
 * 0.21 - 0.2
 */


public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int totalEvents = Integer.parseInt(in.nextLine());
		
		PriorityQueue<Student> pq =  new PriorityQueue<Student>(totalEvents, new StudentComparator());
		
		while(totalEvents > 0){
			String event = in.next();
			if (event.equals("ENTER")) {
				String name = in.next();
				double cgpa = in.nextDouble();
				int token = in.nextInt();
				pq.add(new Student(token, name, cgpa));
			} else if (event.equals("SERVED")) {
				pq.poll();
			}

			totalEvents--;
		}
		
		in.close();
		
		if (pq.isEmpty()) {
			System.out.println("EMPTY");
		}
		
		while (pq.size() > 0) {
			System.out.println(pq.poll().getFname());
		}
	}
}
