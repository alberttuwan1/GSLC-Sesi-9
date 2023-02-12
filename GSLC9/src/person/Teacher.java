package person;

import java.util.ArrayList;

import assigment.Assignment;

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

	public String getTchId() {
		return tchId;
	}

	public ArrayList<Assignment> getAssignment() {
		return assignment;
	}

	public void setAssignment(ArrayList<Assignment> assignment) {
		this.assignment = assignment;
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

	@Override
	public void viewProfile() {
		System.out.println("Account Type: Teacher");
		System.out.println("Account ID  : " + tchId);
		System.out.println("Name        : " + name);
		System.out.println("Subject     : " + subject);
		
	}

}
