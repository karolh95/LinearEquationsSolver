package solver;

public class Main {

	public static void main(String[] args) {

		ArgumentResolver argumentResolver = new ArgumentResolver(args);
		
		InputFileReader reader = new InputFileReader(argumentResolver.getInputFile());
		reader.read();
		
		LinearEquation linearEquation = new LinearEquation(reader);
		linearEquation.solve();
		
		OutputFileWriter writer = new OutputFileWriter(argumentResolver.getOutputFile());
		writer.write(linearEquation.getResult());
	}
}
