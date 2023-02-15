// Albert Gabriel Tuwan - 2502001353 - LA05

package main;

import java.util.ArrayList;
import java.util.Scanner;

import person.*;
import util.Util;

public class Main {

	
	Scanner sc = new Scanner(System.in);
	boolean flag = true;
	
	ArrayList<Admin> admin = new ArrayList<>();

	void loginAsStudent(ArrayList<Student> studentlist) {
		Util.clear();
		flag = true;
		Student temp = null;
		
		do {
			String username, password;
			System.out.print("Input Username [Input \"0\" to Go Back]: ");
			username = sc.nextLine();
			if (username.equals("0")) {
				return;
			}

			// Allowing the Student (that has been allowed by the admin)
			// to Change Password
			for (Student i : studentlist) {
				if (i.getUsername().equals(username) && i.isChangePass()) {
					System.out.println("You Have Been Allowed to Change Password by Admin");
					System.out.print("To Confirm This Is You, Please Input Your Teacher ID\n"
							+ "[The Failure to Do So Will Resulting You to be Unable To\n"
							+ "Change the Password For the Time Being (Please Ask Your Admin\n"
							+ "Again to Allow You to Change Password if this happens)]: ");
					if(i.getStdId().equals(sc.nextLine())) {
						System.out.println("New Password");
						i.setPassword();
					}
					return;
				}
			} 
			
			System.out.print("Input Password: ");
			password = sc.nextLine();
			
			for (Student i : studentlist) {
				if (i.getUsername().equals(username) && i.getPassword().equals(password)) {
					temp = i;
					flag = false;
					break;
				}
			} 
			
			if(!flag) {
				break;
			}
			// If the teacher entered wrong username or password, they will get the message below
			System.out.println("The Username or Password Is Incorrect"
					+ "\nPlease Contact One of Your Admin to Allow You to Change Password\n");
		} while (true);
		
		do {
			
			int inp = studentMenu();
			Util.clear();
			switch (inp) {
			case 1:
				// view profile
				temp.viewProfile();
				break;
			case 2:
				// Do assignment
				temp.doAssignment();
				break;
			case 3:
				// view all assignment score
				temp.viewAllAssignmentScore();
				break;
			case 4:
				// returning to main menu
				return;
			}
		} while (true);
	}

	void loginAsTeacher(ArrayList<Teacher> teacherlist) throws CloneNotSupportedException {
		Util.clear();
		flag = true;
		Teacher temp = null;
		
		do {
			String username, password;
			System.out.print("Input Username [Input \"0\" to Go Back]: ");
			username = sc.nextLine();
			if (username.equals("0")) {
				return;
			}

			// Allowing the Teacher (that has been allowed by the admin)
			// to Change Password
			for (Teacher i : teacherlist) {
				if (i.getUsername().equals(username) && i.isChangePass()) {
					System.out.println("You Have Been Allowed to Change Password by Admin");
					System.out.print("To Confirm This Is You, Please Input Your Teacher ID\n"
							+ "[The Failure to Do So Will Resulting You to be Unable To\n"
							+ "Change the Password For the Time Being (Please Ask Your Admin\n"
							+ "Again to Allow You to Change Password if this happens)]: ");
					if(i.getTchId().equals(sc.nextLine())) {
						System.out.println("New Password");
						i.setPassword();
					}
					return;
				}
			} 
			
			System.out.print("Input Password: ");
			password = sc.nextLine();
			
			for (Teacher i : teacherlist) {
				if (i.getUsername().equals(username) && i.getPassword().equals(password)) {
					temp = i;
					flag = false;
					break;
				}
			} 
			
			if(!flag) {
				break;
			}
			// If the teacher entered wrong username or password, they will get the message below
			System.out.println("The Username or Password Is Incorrect"
					+ "\nPlease Contact One of Your Admin to Allow You to Change Password\n");
		} while (true);
		
		do {
			int inp = teacherMenu();
			Util.clear();
			switch (inp) {
			case 1:
				// view profile
				temp.viewProfile();
				break;
			case 2:
				// create new assignment
				temp.createAssignment();
				break;
			case 3:
				// view all student score
				temp.viewAllScore();
				break;
			case 4:
				// returning to main menu
				return;
			}
		} while (true);
		
	}

	void loginAsAdmin(ArrayList<Teacher> teacher, ArrayList<Student> student) {
		Util.clear();
		// if the user is choosing to create a new admin account,
		// the user will be directed to the create admin account page
		System.out.print("Do You Wish to Create a New Admin Account[YES|NO]: ");
		if(sc.nextLine().equalsIgnoreCase("YES")) {
			addAdmin(teacher, student);
			return;
		}
		
		// login to the existed admin account
		flag = true;
		Admin temp = null;
		
		do {
			String username, password;
			System.out.print("Input Username [Input \"0\" to Go Back]: ");
			username = sc.nextLine();
			if (username.equals("0")) {
				return;
			}

			System.out.print("Input Password: ");
			password = sc.nextLine();

			for (Admin i : admin) {
				if (i.getUsername().equals(username) && i.getPassword().equals(password)) {
					temp = i;
					flag = false;
					break;
				}
			} 
			
			if(!flag) {
				break;
			}
			// If the admin entered wrong username or password, they will get the message below
			System.out.println("The Username or Password Is Incorrect");
			
		} while (true);

		// Login to admin account
		// displaying the admin menu
		do {
			int inp = adminMenu();
			Util.clear();
			switch (inp) {

			case 1:
				// view the profile of this admin account
				temp.viewProfile();
				break;
			case 2:
				// add a new student account
				temp.addStudent();
				break;
			case 3:
				// enable a student account to change its password
				System.out.println("Student Password Change Enable");
				System.out.println("==============================");
				
				// Assuming that the inputed ID is always correct
				System.out.print("Input the Student ID:");
				temp.enableChangeStudentPassword(sc.nextLine());
				break;
			case 4:
				// add new teacher account
				temp.addTeacher();
				break;
			case 5:
				// enable a teacher account to change its password
				System.out.println("Teacher Password Change Enable");
				System.out.println("==============================");
				
				// Assuming that the inputed ID is always correct
				System.out.print("Input the Teacher ID:");
				temp.enableChangeTeacherPassword(sc.nextLine());
				break;
			case 6:
				// Connecting Teacher and  Student
				temp.connect();
				break;
			case 7:
				// back to main menu
				return;
			}
		} while (true);
	}

	// Create new admin account
	void addAdmin(ArrayList<Teacher> teacher, ArrayList<Student> student) {
		Util.clear();
		// To make sure not just anyone can create an admin account
		System.out.print("Input the Unique Code to be Able to Create an Admin Account\n"
				+ "Get It From the Authorized Person: ");
		if(!sc.nextLine().equals("kasd!@2eea#4")) {
			System.out.println("[!]Sorry The Unique Code Is Not Matching");
			System.out.println("Returning to Main Menu...");
			Util.enter();
			return;
		}
		
		// Setting the admin account, so it automatically gain
		// access to the all teacher and student account
		Admin temp = new Admin("", "", "", teacher, student);

		System.out.println("Create New Admin Account");

		do {
			temp.setUsername();
			flag = false;
			for (Admin admin2 : admin) {
				if(admin2.getUsername().equals(temp.getUsername())) {
					System.out.println("Sorry the username has already been taken, please use another username");
					flag = true;
					break;
				}
			}
		} while (flag);

		
		temp.setPassword();
		temp.setName();

		admin.add(temp);
		System.out.println("New Admin Account Has Been Successfully Created");
		Util.enter();
	}

	public Main() throws CloneNotSupportedException {
		int inp;
		System.out.println("Create one admin account to start\n\n\n");
		Util.enter();
		
		do {
			
			addAdmin(new ArrayList<Teacher>(), new ArrayList<Student>());
		} while (admin.isEmpty());
		
		
		do {
			
			inp = mainMenu();
			Util.clear();
			switch (inp) {
			case 1:
				// Login to a student account
				loginAsStudent(admin.get(0).getStudentlist());
				break;
			case 2:
				// Login to a teacher account
				loginAsTeacher(admin.get(0).getTeacherlist());
				break;
			case 3:
				// Login to or create admin account
				loginAsAdmin(admin.get(0).getTeacherlist(), admin.get(0).getStudentlist());
				break;
			case 4:
				// exit
				System.exit(0);
				break;
			}

		} while (true);
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		new Main();

	}

	int mainMenu() {
		Util.clear();
		Util.header();
		System.out.print("Main Menu\n"
				+ "1. Login as Student\n"
				+ "2. Login as Teacher\n"
				+ "3. Login as Admin\n"
				+ "4. Exit\n"
				+ "Choose >> ");
		return Util.inp();
	}

	int studentMenu() {
		Util.clear();
		Util.header();
		System.out.print("Student Menu\n"
				+ "1. View Profile\n"
				+ "2. Do Assignment\n"
				+ "3. View All Score\n"
				+ "4. Back to Main Menu\n"
				+ "Choose >> ");
		return Util.inp();
	}

	int teacherMenu() {
		Util.clear();
		Util.header();
		System.out.print("Teacher Menu\n"
				+ "1. View Profile\n"
				+ "2. Create Assignment\n"
				+ "3. View All Score\n"
				+ "4. Back to Main Menu\n"
				+ "Choose >> ");
		return Util.inp();
	}

	int adminMenu() {
		Util.clear();
		Util.header();
		System.out.print("admin Menu\n"
				+ "1. View Profile\n"
				+ "2. Add Student\n"
				+ "3. Student Password Change Enable\n"
				+ "4. Add Teacher\n"
				+ "5. Teacher Password Change Enable\n"
				+ "6. Connecting Student and Teacher\n"
				+ "7. Back to Main Menu\n"
				+ "Choose >> ");
		return Util.inp();
	}

}
