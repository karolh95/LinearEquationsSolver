package solver;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		double a = scanner.nextDouble();
		double b = scanner.nextDouble();

		scanner.close();

		double x = b / a;

		System.out.println(x);
	}
}
