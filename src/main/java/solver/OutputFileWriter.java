package solver;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Locale;

public class OutputFileWriter {

	private final File outputFile;

	public OutputFileWriter(File outputFile) {
		this.outputFile = outputFile;
	}

	public void write(LinearEquation linearEquation) {

		try {

			PrintWriter writer = new PrintWriter(outputFile);

			NumberFormat formatter = NumberFormat.getNumberInstance(Locale.UK);

			formatter.setMinimumFractionDigits(1);

			switch (linearEquation.getEquationResult()) {

			case NONE:
				writer.write("No solutions");
				break;

			case ONE:

				for (double variable : linearEquation.getResult()) {

					writer.printf("%s\n", formatter.format(variable));
				}

				writer.close();
				break;

			case INFINITE:
				writer.write("Infinitely many solutions");
				break;
			}

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
