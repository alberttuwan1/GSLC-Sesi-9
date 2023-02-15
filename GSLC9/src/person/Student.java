package person;

import java.util.ArrayList;

import assigment.Assignment;
import util.Util;

public class Student extends Person implements IsPassChangeable, IsUseId{

	final private String stdId; // unique id for each student, format = "STD" followed by 4 digit number
	private ArrayList<Assignment> assignment = new ArrayList<>();
	private ArrayList<Integer> assignmentscore = new ArrayList<>();
	private ArrayList<Teacher> teacher = new ArrayList<>();

	private boolean changePass = false;

	public Student(String username, String password, String name) {
		super(username, password, name);
		stdId = genId();
	}

	@Override
	public String genId() {
		return "STD" + rand.nextInt(10)
		+ rand.nextInt(10)
		+ rand.nextInt(10)
		+ rand.nextInt(10);
	}

	@Override
	public void setPassword() {
		boolean flag;
		int len;
		do {
			flag = false;
			System.out.print("Password [Letter or Digit | 5..20]: ");
			password = sc.nextLine();
			len = password.length();
			for (int i = 0; i < len; i++) {
				if(!Character.isLetterOrDigit(password.charAt(i))) {
					flag = true;
					System.out.println("Input Letter or Digit only");
					break;
				}
			}
		} while (flag || len < 5 || len > 20);

	}

	public void viewAllAssignmentScore() {
		int len = assignment.size();
		for(int i = 0; i < len; i++) {
			if(assignmentscore.get(i) != -1) {

				System.out.println("Assignment ID: " + assignment.get(i).getAssignmentId());
				System.out.println("Score        : " + assignmentscore.get(i));
			}else {
				System.out.println("Assignment ID: " + assignment.get(i).getAssignmentId());
				System.out.println("Score        : Not Done Yet");
			}
		}
		Util.enter();
	}

	// View all the assignment and its status (Done or Not Done)
	public void listAssignment() {
		int len = assignment.size();
		for (int i = 0; i < len; i++) {

			System.out.println((i+1) + ". " + assignment.get(i).getAssignmentId()
					+ (assignmentscore.get(i) == -1 ? "": " Done"));
		}
	}

	public void doAssignment() {
		// View all the assignment
		listAssignment();
		int len = assignment.size();
		boolean flag = true;
		Assignment temp = null;
		
		int asgnum = 0;
		// Choosing assignment to do
		do {
			System.out.print("Input Assignment ID[You Can't Do the Same Assignment Twice|"
					+ "Input \"0\" to Exit]: ");
			String ID = sc.nextLine();
			if(ID.equals("0")) {
				return;
			}
			for (int i = 0; i < len; i++) {
				if(assignment.get(i).getAssignmentId().equals(ID)) {
					if(assignmentscore.get(i) == -1) {
						System.out.println("You Have Already Been Do This Assignment,"
								+ "\nPlease Choose Another Assignment");
					}else {
						temp = assignment.get(i);
						asgnum = i;
						flag = false;
					}
					break;
				}
			}
		} while (flag);
		
		// Doing of the assignment choosen
		temp.printQuestion();
		System.out.println("\n\nAnswer\n"
				+ "==================");
		ArrayList<String> answer = null;
		
		// getting the key answer of the assignment
		for (Assignment i : temp.getTeacher().getAssignment()) {
			if(i.getAssignmentId().equals(temp.getAssignmentId())) {
				answer = i.getAnswer();
			}
		}
		
		// Answering the question of the assignment choosen and get the score
		int numOfCrrctAns = 0;
		for(int i = 0; i < temp.getNumberOfQuestion(); i++) {
			System.out.print((i+1) + ". ");
			if(answer.get(i).equalsIgnoreCase(sc.nextLine())) {
				numOfCrrctAns++;
			}
		}
		int score = (int)(Math.ceil((numOfCrrctAns*100.0/temp.getNumberOfQuestion())));
		System.out.println("Your Score Is " + score);
		assignmentscore.set(asgnum, score);
		Util.enter();
	}

	// view profile of the student
	@Override
	public void viewProfile() {
		System.out.println("Account Type: Student");
		System.out.println("Account ID  : " + stdId);
		System.out.println("Name        : " + name);
		Util.enter();
	}

	public ArrayList<Assignment> getAssignment() {
		return assignment;
	}

	public void setAssignment(ArrayList<Assignment> assignment) {
		this.assignment = assignment;
	}

	public boolean isChangePass() {
		return changePass;
	}

	public void setChangePass(boolean changePass) {
		this.changePass = changePass;
	}

	public String getStdId() {
		return stdId;
	}

	public ArrayList<Teacher> getTeacher() {
		return teacher;
	}

	public void setTeacher(ArrayList<Teacher> teacher) {
		this.teacher = teacher;
	}

	public ArrayList<Integer> getAssignmentscore() {
		return assignmentscore;
	}



}
