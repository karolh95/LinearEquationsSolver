package solver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputFileReader {

	private final File inputFile;
	
	private int variables;
	private double[][] data;

	public InputFileReader(File inputFile) {
		this.inputFile = inputFile;
	}

	public void read() {
		
		Scanner scanner;
		try {
			scanner = new Scanner(inputFile);

			variables = scanner.nextInt();

			data = new double[variables][];

			for (int i = 0; i < variables; i++) {

				data[i] = new double[variables + 1];

				for (int j = 0; j < variables + 1; j++) {
					data[i][j] = scanner.nextDouble();
				}
			}
			scanner.close();
			
		} catch (FileNotFoundException e) {

			variables = 0;
			data = new double[0][0];
		}
	}

	public int getVariables() {
		return variables;
	}

	public double[][] getData() {
		return data;
	}
}
