package person;

import java.util.ArrayList;

import util.Util;

public class Admin extends Person {

	private ArrayList<Teacher> teacherlist = new ArrayList<>();
	private ArrayList<Student> studentlist = new ArrayList<>();

	public Admin(String username, String password, String name, ArrayList<Teacher> teacherlist,
			ArrayList<Student> studentlist) {
		super(username, password, name);
		this.teacherlist = teacherlist;
		this.studentlist = studentlist;
	}
	
	// Add new student account
	public void addStudent() {
		Student temp = new Student("", "", "");
		System.out.println("Create New Student Account");
		
		boolean flag;
		do {
			temp.setUsername();
			flag = false;
			for (Student i : studentlist) {
				if(i.getUsername().equals(temp.getUsername())) {
					System.out.println("Sorry the username has already been taken, please use another username");
					flag = true;
					break;
				}
			}
		} while (flag);
		
		temp.setPassword();
		temp.setName();
		
		studentlist.add(temp);
		System.out.println("New Student Account Has Been Successfully Created");
		Util.enter();
	}
	
	// Add new teacher account
	public void addTeacher() {
		Teacher temp = new Teacher("", "", "");
		
		System.out.println("Create New Teacher Account");
		
		boolean flag;
		do {
			temp.setUsername();
			flag = false;
			for (Teacher i : teacherlist) {
				if(i.getUsername().equals(temp.getUsername())) {
					System.out.println("Sorry the username has already been taken, please use another username");
					flag = true;
					break;
				}
			}
		} while (flag);
		
		temp.setPassword();
		temp.setName();
		temp.setPassword();
		
		teacherlist.add(temp);
		System.out.println("New Teacher Account Has Been Successfully Created");
		Util.enter();
	}
	
	@Override
	public void viewProfile() {
		System.out.println("Account Type: Admin");
		System.out.println("Name        : " + name);
		
	}

	public ArrayList<Teacher> getTeacherlist() {
		return teacherlist;
	}

	public ArrayList<Student> getStudentlist() {
		return studentlist;
	}
	
	public void enableChangeStudentPassword(String id) {
		for (Student i : studentlist) {
			if(i.getStdId().equals(id)) {
				i.setChangePass(true);
				return;
			}
		}
	}
	
	public void enableChangeTeacherPassword(String id) {
		for (Teacher i : teacherlist) {
			if(i.getTchId().equals(id)) {
				i.setChangePass(true);
				return;
			}
		}
	}
	
	public void connect() {
		// Assuming that the inputed ID is always correct
		System.out.print("Input Teacher ID to be connected: ");
		String tchid = sc.nextLine();
		
		System.out.print("Input Student ID to be connected: ");
		String stdid = sc.nextLine();
		
		// Add the student to the teacher's student list
		// and the teacher to the student's teacher list
		for (Teacher i : teacherlist) {
			if(i.getTchId().equals(tchid)) {
				for (Student j : studentlist) {
					i.getStudent().add(j);
					j.getTeacher().add(i);
				}
			}
		}
		
		System.out.println("Teacher and Student Account Has Been Succesfully Connected");
		Util.enter();
	}
	
	
	
	
	

}
