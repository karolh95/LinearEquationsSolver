package solver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputFileReader {

	private final File inputFile;

	private int coefficientsNumber;
	private Equation[] equations;

	public InputFileReader(File inputFile) {
		this.inputFile = inputFile;
	}

	public void read() {

		Scanner scanner;
		try {
			scanner = new Scanner(inputFile);

			coefficientsNumber = scanner.nextInt();
			int equationsNumber = scanner.nextInt();
			equations = new Equation[equationsNumber];

			for (int i = 0; i < equationsNumber; i++) {

				Complex[] data = new Complex[coefficientsNumber + 1];

				for (int j = 0; j < coefficientsNumber + 1; j++) {
					data[j] = Complex.parseComplex(scanner.next());
				}

				equations[i] = new Equation(data);
			}
			scanner.close();

		} catch (FileNotFoundException e) {

			coefficientsNumber = 0;
			equations = new Equation[0];
		}
	}

	public int getCoefficientsNumber() {
		return coefficientsNumber;
	}

	public Equation[] getEquations() {
		return equations;
	}
}
