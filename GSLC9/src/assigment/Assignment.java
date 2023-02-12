package assigment;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import person.IsUseId;

public class Assignment implements IsUseId, Cloneable{

	Random rand = new Random();
	Scanner sc = new Scanner(System.in);
	
	private String subject; // Subject of the assignment, can only be "Mathematics", "Science", or "Computer"
	private String assignmentId; // Unique identifier of the assignment 
	private ArrayList<String> question = new ArrayList<>(); // The question(s) for each assignment
	private ArrayList<String[]> answer = new ArrayList<>(); // The multiple choice for each question, there are always four choices
	private ArrayList<String> key = new ArrayList<>(); // The key for the multiple choice
	private Integer numberOfQuestion; // The number of question
	private Boolean status;
	// The status for the assignment
	// If the status is true, the assignment is ready and no further alteration allowed, can be shared to the student
	// If the status is false, the assignment is still in the process.
	
	
	public Assignment(String subject) {
		super();
		this.subject = subject;
		this.assignmentId = genId();
		status = false;
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
	
	public void addQuestion() {
		
	}
	
	// print the question for the student
	public void printQuestion() {
		for (int i = 0; i < numberOfQuestion; i++) {
			printString(question.get(i));
			for(int j = 0; j < 4; j++) {
				printString(answer.get(i)[j]);
			}
		}
	}
	
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
