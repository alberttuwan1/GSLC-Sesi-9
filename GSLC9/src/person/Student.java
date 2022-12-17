package person;

import java.util.ArrayList;

import assigment.Assignment;

public class Student extends Person implements IsPassChangeable, IsUseId{

	final private String stdId; // unique id for each student, format = "STD" followed by 4 digit number
	private ArrayList<Assignment> assignment = new ArrayList<>();
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

	@Override
	public void viewProfile() {
		System.out.println("Account Type: Student");
		System.out.println("Account ID  : " + stdId);
		System.out.println("Name        : " + name);
		
	}

}
