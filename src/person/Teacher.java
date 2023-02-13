package person;

import java.util.ArrayList;

import assigment.Assignment;
import util.Util;

public class Teacher extends Person implements IsPassChangeable, IsUseId{

	final private String tchId; // unique id for each teacher, format = "TCH" followed by 4 digit number
	private ArrayList<Assignment> assignment = new ArrayList<>(); // Assignment that has been created by the teacher
	private ArrayList<Student> student = new ArrayList<>(); // student(s) taught by the teacher
	private String subject; // The course taught by the teacher
	
	private boolean changePass = false;
	
	public Teacher(String username, String password, String name) {
		super(username, password, name);
		tchId = genId();
	}
	
	@Override
	public void viewProfile() {
		System.out.println("Account Type: Teacher");
		System.out.println("Account ID  : " + tchId);
		System.out.println("Name        : " + name);
		System.out.println("Subject     : " + subject);
		
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
	
	// view all score for each assignment for each student
	public void viewAllScore() {
		for (Assignment i : assignment) {
			System.out.println("===========================\n"
					+ "Assignment ID: " + i.getAssignmentId()
					+ "===========================\n");
			int j = 1;
			for (Student k : student) {
				System.out.println((j++) + ".");
				System.out.println("Student Name: " + k.getName());
				int len = k.getAssignment().size();
				for (int x = 0; x < len; x++) {
					if(k.getAssignment().get(x).equals(i.getAssignmentId())) {
						System.out.println("Score       : " + k.getAssignmentscore());
						break;
					}
				}
			}
			System.out.println("");
		}
		Util.enter();
	}
	
	public String getTchId() {
		return tchId;
	}

	public ArrayList<Assignment> getAssignment() {
		return assignment;
	}

	// create new assignment
	public void createAssignment() throws CloneNotSupportedException {
		Assignment asg = new Assignment(subject);
		assignment.add(asg);
		// add the assignment to the student's assignment list
		// using cloning
		for (Student i : student) {
			i.getAssignment().add((Assignment)asg.clone());
		}
		Util.enter();
	}

	public ArrayList<Student> getStudent() {
		return student;
	}



	public void setStudent(ArrayList<Student> student) {
		this.student = student;
	}



	public String getSubject() {
		return subject;
	}



	public void setSubject() {
		System.out.print("Course Taught: ");
		subject = sc.nextLine();
	}



	public boolean isChangePass() {
		return changePass;
	}



	public void setChangePass(boolean changePass) {
		this.changePass = changePass;
	}



	@Override
	public String genId() {
		return "TCH" + rand.nextInt(10)
		+ rand.nextInt(10)
		+ rand.nextInt(10)
		+ rand.nextInt(10);
	}



}
