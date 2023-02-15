package util;

import java.util.Scanner;

public class Util {
	
	static Scanner sc = new Scanner(System.in);
	
	public static int inp() {
		int inp;
		try {
			inp = sc.nextInt();
		} catch (Exception e) {
			inp = -1;
		}
		sc.nextLine();
		return inp;
	}
	
	public static void header() {
		System.out.println("Quzziz Lite");
	}
	
	public static void enter() {
		System.out.print("Press ENTER to Continue...");
		sc.nextLine();
	}
	
	public static void clear() {
		for(int i = 0; i < 30; i++) {
			System.out.println("");
		}
	}
	
}
