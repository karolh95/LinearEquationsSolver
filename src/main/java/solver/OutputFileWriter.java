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

	public void write(double[] result) {

		try {

			PrintWriter writer = new PrintWriter(outputFile);

			NumberFormat formatter = NumberFormat.getNumberInstance(Locale.UK);

			formatter.setMinimumFractionDigits(1);

			for (double variable : result) {

				writer.printf("%s\n", formatter.format(variable));
			}

			writer.close();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}