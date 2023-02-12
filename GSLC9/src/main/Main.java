package main;

import java.util.ArrayList;
import java.util.Scanner;

import person.*;
import util.Util;

public class Main {

	// Albert Gabriel Tuwan - 2502001353 - LA05
	Scanner sc = new Scanner(System.in);

	ArrayList<Teacher> teacher = new ArrayList<>();
	ArrayList<Student> student = new ArrayList<>();
	ArrayList<Admin> admin = new ArrayList<>();
	ArrayList<Person> pass = new ArrayList<>();

	void loginAsStudent() {

	}

	void loginAsTeacher() {

	}

	void loginAsAdmin() {
		boolean flag = true;
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
				temp.addStudent();
				break;
			case 2:
				
				break;
			case 3:
				temp.addTeacher();
				break;
			case 4:
				
			case 5:
				return;
			}
		} while (true);
	}

	// Create new admin account
	void addAdmin() {

		Admin temp = new Admin("", "", "", teacher, student);

		System.out.println("Create New Admin Account");

		boolean flag;
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
		do {
			inp = mainMenu();

			switch (inp) {
			case 1:
				loginAsStudent();
				break;
			case 2:
				loginAsTeacher();
				break;
			case 3:
				loginAsAdmin();
				break;
			case 4:
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
				+ "1. Add Student\n"
				+ "2. Student Password Change Request\n"
				+ "3. Add Teacher\n"
				+ "4. Teacher Password Change Request\n"
				+ "5. Back to Main Menu\n"
				+ "Choose >> ");
		return Util.inp();
	}

}
