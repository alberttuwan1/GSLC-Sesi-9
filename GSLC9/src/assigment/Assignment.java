package assigment;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import person.IsUseId;

public class Assignment implements IsUseId{

	Random rand = new Random();
	Scanner sc = new Scanner(System.in);
	
	private String subject; // Subject of the assignment, can only be "Mathematics", "Science", or "Computer"
	private String assignmentId; // Unique identifier of the assignment 
	private ArrayList<String> question = new ArrayList<>(); // The question(s) for each assignment
	private ArrayList<String> answer = new ArrayList<>(); // The key for the multiple choice
	private Integer numberOfQuestion; // The number of question
	
	
	public Assignment(String subject) {
		super();
		this.subject = subject;
		assignmentId = genId();
		System.out.println("Your assignment ID is " + assignmentId);
		addQuestion();
	}


	@Override
	// Function to generate unique id for the assignment
	// If the subject is "Math" the unique id is "MT" followed by 3 digit number     -> "MT[0-9][0-9][0-9]"
	// If the subject is "Science" the unique id is "SC" followed by 3 digit number  -> "SC[0-9][0-9][0-9]"
	// If the subject is "Computer" the unique id is "CM" followed by 3 digit number -> "CM[0-9][0-9][0-9]"
	public String genId() {
		if(subject.equals("Mathematics")) {
			return "MT" + rand.nextInt(10)
			+ rand.nextInt(10)
			+ rand.nextInt(10);
		}else if(subject.equals("Science")) {
			return "SC" + rand.nextInt(10)
			+ rand.nextInt(10)
			+ rand.nextInt(10);
		}else {
			return "CM" + rand.nextInt(10)
			+ rand.nextInt(10)
			+ rand.nextInt(10);
		}
	}
	
//	Function to add questions and its
	public void addQuestion() {
		do {
			System.out.print("Do you want to add another question [YES|NO]?");
			if(sc.nextLine().equalsIgnoreCase("NO")){
				return;
			}
			System.out.print("Input question: ");
			question.add(sc.nextLine());
			System.out.print("Input key answer: ");
			answer.add(sc.nextLine());
			numberOfQuestion++;
		} while (true);
	}
	
	// print the question for the student
	public void printQuestion() {
		for (int i = 0; i < numberOfQuestion; i++) {
			printString(question.get(i));
		}
	}
	
//	To make sure the question is not printed in only 1 rows
	private void printString(String s) {
		int len = (int)Math.ceil(s.length() / 50);
		for (int i = 0; i < len; i++) {
			System.out.print(s.substring(50*i, 50*i+50));
			if(s.charAt(50*i+50) == ' ' && s.charAt(50*i+50) != '-') {
				System.out.print("-");
			}
			System.out.println();
		}
	}
	
	
	
}
