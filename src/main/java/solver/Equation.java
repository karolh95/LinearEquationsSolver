package solver;

public class Equation {

    private final Complex[] coefficients;

    public Equation(Complex[] coefficients) {

        this.coefficients = coefficients;
    }

    public Complex get(int index) {
        return coefficients[index];
    }

    public void subtract(Equation equation, Complex multiplier) {

        for (int i = 0; i < coefficients.length; i++) {

            Complex s = multiplier.multiply(equation.get(i));
            coefficients[i] = coefficients[i].subtract(s);
        }
    }

    public void divide(Complex divider) {

        for (int i=0; i<coefficients.length; i++){
            coefficients[i] = coefficients[i].divide(divider);
        }
    }

    public boolean isZero() {

        return areArgumentsZero() && isBZero();
    }

    public boolean areArgumentsZero() {

        for (int i = 0; i < coefficients.length - 1; i++) {
            if (!coefficients[i].isZero()) {
                return false;
            }
        }
        return true;
    }

    public boolean isBZero() {

        return coefficients[coefficients.length - 1].isZero();
    }
}