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
	
	void loginAsStudent() {
		
	}
	
	void loginAsTeacher() {
		
	}
	
	void loginAsAdmin() {
		
	}
	
	// Create new admin account
	void addAdmin() {
		boolean flag;
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
			}
			
			if(inp < 1 || inp > 4) {
				inp = 1;
			}
			
		} while (inp != 4);
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
