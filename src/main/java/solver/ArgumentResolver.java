package solver;

import java.io.File;

public class ArgumentResolver {

    private static final String INPUT = "-in";
    private static final String OUTPUT = "-out";

    private File inputFile;
    private File outputFile;

    public ArgumentResolver(String[] args) {

        if (args.length != 4 ) {
            throw new IllegalArgumentException("Arguments number does not match!");
        }

        for (int i = 0; i < args.length; i += 2) {

            if (args[i].equals(INPUT)) {
            	
                inputFile = new File(args[i + 1]);
                
            } else if (args[i].equals(OUTPUT)) {
            	
                outputFile = new File(args[i + 1]);
            }
        }
    }

    public File getInputFile() {
        return inputFile;
    }

    public File getOutputFile() {
        return outputFile;
    }
}
