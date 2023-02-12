package main;

import java.util.ArrayList;
import java.util.Scanner;

import person.*;
import util.Util;

public class Main {

	// Albert Gabriel Tuwan - 2502001353 - LA05
	Scanner sc = new Scanner(System.in);
	boolean flag = true;
	
	ArrayList<Admin> admin = new ArrayList<>();

	void loginAsStudent(ArrayList<Student> studentlist) {

	}

	void loginAsTeacher(ArrayList<Teacher> teacherlist) {
		flag = true;
		Teacher temp = null;
	}

	void loginAsAdmin(ArrayList<Teacher> teacher, ArrayList<Student> student) {
		// if the user is choosing to create a new admin account,
		// the user will be directed to the create admin account page
		System.out.print("Do You Wish to Create a New Admin Account[YES|NO]");
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
		} while (flag);

		do {
			int inp = adminMenu();
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
				
				Util.enter();
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
				
				Util.enter();
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
		
		// To make sure not just anyone can create an admin account
		System.out.print("Input the Unique Code to be Able to Create an Admin Account"
				+ "Get It From the Authorized Person: ");
		if(!sc.nextLine().equals("kasd!@2eea#4")) {
			System.out.println("[!]Sorry The Unique Code Is Not Matching");
			System.out.println("Returning to Main Menu...");
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

	public Main() {
		int inp;
		System.out.println("Create one admin account to start");
		Util.enter();
		addAdmin(new ArrayList<Teacher>(), new ArrayList<Student>());
		
		do {
			inp = mainMenu();

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

	public static void main(String[] args) {
		new Main();

	}

	int mainMenu() {
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
		Util.header();
		System.out.print("admin Menu"
				+ "1. View Profile"
				+ "2. Add Student\n"
				+ "3. Student Password Change Enable\n"
				+ "4. Add Teacher\n"
				+ "5. Teacher Password Change Enable\n"
				+ "6. Connecting Student a"
				+ "7. Back to Main Menu\n"
				+ "Choose >> ");
		return Util.inp();
	}

}
