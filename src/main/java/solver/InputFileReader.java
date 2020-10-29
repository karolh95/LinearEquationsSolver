package solver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputFileReader {

	private final File inputFile;
	
	private int coefficientsNumber;
	private double[][] data;

	public InputFileReader(File inputFile) {
		this.inputFile = inputFile;
	}

	public void read() {
		
		Scanner scanner;
		try {
			scanner = new Scanner(inputFile);

			coefficientsNumber = scanner.nextInt();

			data = new double[coefficientsNumber][];

			for (int i = 0; i < coefficientsNumber; i++) {

				data[i] = new double[coefficientsNumber + 1];

				for (int j = 0; j < coefficientsNumber + 1; j++) {
					data[i][j] = scanner.nextDouble();
				}
			}
			scanner.close();
			
		} catch (FileNotFoundException e) {

			coefficientsNumber = 0;
			data = new double[0][0];
		}
	}

	public int getCoefficientsNumber() {
		return coefficientsNumber;
	}

	public double[][] getData() {
		return data;
	}
}
