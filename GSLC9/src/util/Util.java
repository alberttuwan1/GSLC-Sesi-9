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
}
