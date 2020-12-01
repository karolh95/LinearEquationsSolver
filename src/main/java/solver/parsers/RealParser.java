package solver.parsers;

import solver.Complex;

public class RealParser implements ComplexParser {

    private static final String REAL = "[-]?" + NUMBER;

    public String getPattern() {
        return REAL;
    }

    public Complex parse(String value) {

        double real = Double.parseDouble(value);

        return new Complex(real, 0);
    }
}
