package solver.parsers;

import solver.Complex;

public class ImaginaryParser implements ComplexParser {

    private static final String IMAGINARY = "[-]?" + OPT_NUMBER + "i";

    public String getPattern() {
        return IMAGINARY;
    }

    public Complex parse(String value) {

        double imaginary = 0.0;

        if (value.equals("i")) {
            imaginary = 1.0;
        } else if (value.equals("-i")) {
            imaginary = -1.0;
        } else {

            String test = value.replace("i", "");
            imaginary = Double.parseDouble(test);
        }

        return new Complex(0, imaginary);
    }
}
