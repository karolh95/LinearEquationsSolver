package solver;

import solver.parsers.ComplexParser;
import solver.parsers.FullComplexParser;
import solver.parsers.ImaginaryParser;
import solver.parsers.RealParser;

import java.text.NumberFormat;
import java.util.Locale;

public class Complex {

    private double real;
    private double imaginary;

    public Complex(Complex complex) {
        this.real = complex.real;
        this.imaginary = complex.imaginary;
    }

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public static Complex parseComplex(String string) {

        ComplexParser[] parsers = {
                new FullComplexParser(),
                new RealParser(),
                new ImaginaryParser()
        };

        for (ComplexParser parser : parsers) {

            String pattern = parser.getPattern();

            if (string.matches(pattern)) {

                return parser.parse(string);
            }
        }

        return new Complex(0, 0);
    }

    public double getReal() {
        return this.real;
    }

    public double getImaginary() {
        return this.imaginary;
    }

    @Override
    public String toString() {

        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.UK);

        StringBuilder builder = new StringBuilder();

        boolean hasReal = false;
        if (real != 0) {
            builder.append(formatter.format(real));
            hasReal = true;
        }

        if (imaginary != 0) {

            if (hasReal && imaginary > 0) {
                builder.append('+');
            }

            if (imaginary != 1) {

                if (imaginary == -1) {
                    builder.append("-");

                } else {
                    builder.append(formatter.format(imaginary));
                }
            }

            builder.append('i');
        } else if (!hasReal) {
            builder.append(0);
        }

        return builder.toString();
    }

    public Complex subtract(Complex complex) {

        double real = this.real - complex.getReal();
        double imaginary = this.imaginary - complex.getImaginary();

        return new Complex(real, imaginary);
    }

    public Complex divide(Complex complex) {

        double divider = Math.pow(complex.getReal(), 2) + Math.pow(complex.getImaginary(), 2);

        double real = this.real * complex.getReal() + this.imaginary * complex.getImaginary();
        double imaginary = this.imaginary * complex.getReal() - this.real * complex.getImaginary();

        real /= divider;
        imaginary /= divider;

        return new Complex(real, imaginary);
    }

    public Complex multiply(Complex complex) {

        double real = this.real * complex.getReal() - imaginary * complex.getImaginary();
        double imaginary = this.real * complex.getImaginary() + this.imaginary * complex.getReal();

        return new Complex(real, imaginary);
    }

    public Complex getConjugate() {
        return new Complex(-real, -imaginary);
    }

    public boolean isZero() {
        return real == 0 && imaginary == 0;
    }

    public boolean isOne() {
        return real == 1 && imaginary == 0;
    }
}
