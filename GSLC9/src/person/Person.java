package person;

import java.util.Random;
import java.util.Scanner;

public abstract class Person{
	
	Scanner sc = new Scanner(System.in);
	Random rand = new Random();
	
	protected String username;
	// The username for the account, may only be letter or number, with minimum length of 5 and maximum length of 20
	protected String password;
	// The password for the account, may only be letter or number, with minimum length of 5 and maximum length of 20
	
	protected String name;

	public Person(String username, String password, String name) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername() {
		boolean flag;
		int len;
		do {
			flag = false;
			System.out.print("Username [Letter or Digit | 5..20]: ");
			username = sc.nextLine();
			len = username.length();
			for (int i = 0; i < len; i++) {
				if(!Character.isLetterOrDigit(username.charAt(i))) {
					flag = true;
					System.out.println("Input Letter or Digit only");
					break;
				}
			}
		}while (flag || len < 5 || len > 20);
	}

	public String getName() {
		return name;
	}

	public void setName() {
		boolean flag;
		do {
			flag = false;
			System.out.print("Input name [10..25]: ");
			name = sc.nextLine();
		} while (flag || name.length() < 10 || name.length() > 25);
	}
	
	public abstract void viewProfile();
	
	

	
	
	
	
	
}
