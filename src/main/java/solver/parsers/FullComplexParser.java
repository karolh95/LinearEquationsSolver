package solver.parsers;

import solver.Complex;

public class FullComplexParser implements ComplexParser {

    private static final String FULL_COMPLEX = "[-]?" + NUMBER + "[+-]" + OPT_NUMBER + "[i]";

    public String getPattern() {
        return FULL_COMPLEX;
    }

    public Complex parse(String value) {

        ComplexParser realParser = new RealParser();
        ComplexParser imaginaryParser = new ImaginaryParser();

        String check = value.substring(1);

        String realPart, imaginaryPart;

        int signIndex = check.indexOf('-');

        if (signIndex != -1) {
            imaginaryPart = value.substring(signIndex + 1);
        } else {

            signIndex = check.indexOf('+');
            imaginaryPart = value.substring(signIndex + 2);

        }
        realPart = value.substring(0, signIndex + 1);

        Complex real = realParser.parse(realPart);
        Complex imaginary = imaginaryParser.parse(imaginaryPart);

        return new Complex(real.getReal(), imaginary.getImaginary());
    }
}
