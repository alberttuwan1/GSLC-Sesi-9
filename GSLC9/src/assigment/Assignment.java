package assigment;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import person.IsUseId;
import person.Teacher;

public class Assignment implements IsUseId, Cloneable{

	Random rand = new Random();
	Scanner sc = new Scanner(System.in);
	
	private String subject; // Subject of the assignment, can only be "Mathematics", "Science", or "Computer"
	private String assignmentId; // Unique identifier of the assignment 
	private ArrayList<String> question = new ArrayList<>(); // The question(s) for each assignment
	private ArrayList<String> answer = new ArrayList<>(); // The key for the multiple choice
	private Integer numberOfQuestion; // The number of question
	private Teacher teacher;
	
	// Create a deep copy for the assignment object
	// to be shared to the student
	public Object clone() throws CloneNotSupportedException{
		Assignment clone = (Assignment)super.clone();
		
		clone.subject = subject;
		clone.assignmentId = assignmentId;
		clone.question = new ArrayList<>(question);
		clone.answer = new ArrayList<>();
		clone.numberOfQuestion = numberOfQuestion;
		
		return clone;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}

	public Assignment(Teacher teacher) {
		super();
		this.subject = teacher.getSubject();
		this.teacher = teacher;
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
		System.out.println("Question\n"
				+ "==================");
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

	public String getSubject() {
		return subject;
	}

	public String getAssignmentId() {
		return assignmentId;
	}

	public ArrayList<String> getQuestion() {
		return question;
	}

	public ArrayList<String> getAnswer() {
		return answer;
	}

	public Integer getNumberOfQuestion() {
		return numberOfQuestion;
	}

	
	
	
}
