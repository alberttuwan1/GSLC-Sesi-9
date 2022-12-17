package person;

import java.util.ArrayList;

public class Admin extends Person {

	private ArrayList<Teacher> teacherlist = new ArrayList<>();
	private ArrayList<Student> studentlist = new ArrayList<>();

	public Admin(String username, String password, String name, ArrayList<Teacher> teacherlist,
			ArrayList<Student> studentlist) {
		super(username, password, name);
		this.teacherlist = teacherlist;
		this.studentlist = studentlist;
	}
	
	public void addStudent() {
		
	}
	
	@Override
	public void viewProfile() {
		System.out.println("Account Type: Admin");
		System.out.println("Name        : " + name);
		
	}
	
	
	
	
	
	

}
