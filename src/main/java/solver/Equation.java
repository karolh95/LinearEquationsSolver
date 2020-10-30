package solver;

public class Equation {

	private final double[] coefficients;

	public Equation(double[] coefficients) {

		this.coefficients = coefficients;
	}

	public double get(int index) {
		return coefficients[index];
	}

	public void subtract(Equation equation, double multiplier) {

		for (int i = 0; i < coefficients.length; i++) {
			coefficients[i] -= multiplier * equation.get(i);
		}
	}

	public void divide(double divider) {

		for (int i = 0; i < coefficients.length; i++) {
			coefficients[i] /= divider;
		}
	}

	public boolean isZero() {

		return areArgumentsZero() && isBZero();
	}

	public boolean areArgumentsZero() {

		for (int i = 0; i < coefficients.length - 1; i++) {
			if (coefficients[i] != 0) {
				return false;
			}
		}
		return true;
	}

	public boolean isBZero() {

		return coefficients[coefficients.length - 1] == 0;
	}
}