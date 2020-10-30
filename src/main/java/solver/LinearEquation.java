package solver;

public class LinearEquation {

	private final int coefficientsNumber;
	private Equation[] equations;

	private EquationResult equationResult;

	public LinearEquation(InputFileReader reader) {

		this.coefficientsNumber = reader.getCoefficientsNumber();
		this.equations = reader.getEquations();

		this.equationResult = EquationResult.NONE;
	}

	public EquationResult getEquationResult() {
		return equationResult;
	}

	public double[] getResult() {

		double[] result = new double[coefficientsNumber];

		for (int i = 0; i < equations.length; i++) {
			result[i] = equations[i].get(coefficientsNumber);
		}

		return result;
	}

	public void solve() {

		reduceToEchelonMatrix();

		while (getLastEquation().isZero()) {
			removeLastEquation();
		}

		if (isTriangular()) {
			backSolving();

		} else if (getLastEquation().areArgumentsZero() && !getLastEquation().isBZero()) {
			equationResult = EquationResult.NONE;

		} else if (equations.length < coefficientsNumber) {
			equationResult = EquationResult.INFINITE;
		}

	}

	private void reduceToEchelonMatrix() {

		for (int i = 0; i < equations.length; i++) {

			tryToSwapEquations(i);

			divide(i);

			for (int j = i + 1; j < equations.length; j++) {

				subtract(j, i);
			}

		}

	}

	private void tryToSwapEquations(int i) {

		int j = i + 1;

		while (equations[i].get(i) == 0 && j < equations.length) {

			if (equations[j].get(i) != 0) {

				swap(i, j);
			}
			j++;
		}
	}

	private void swap(int i, int j) {

		System.out.printf("R%d <-> R%d\n", i + 1, j + 1);

		Equation tmp = equations[i];
		equations[i] = equations[j];
		equations[j] = tmp;
	}

	private void subtract(int i, int j) {

		double multiplier = equations[i].get(j);

		if (multiplier != 0) {

			equations[i].subtract(equations[j], multiplier);
			System.out.printf("%.2f * R%d + R%d -> R%d\n", -multiplier, j + 1, i + 1, i + 1);
		}
	}

	private void divide(int i) {

		double divider = equations[i].get(i);
		if (divider != 1 && divider != 0) {

			equations[i].divide(divider);
			System.out.printf("R%d / %.2f -> R%d\n", i + 1, divider, i + 1);
		}
	}

	private boolean isTriangular() {

		return (coefficientsNumber == equations.length);
	}

	private void removeLastEquation() {

		int newEquationsNumber = equations.length - 1;
		Equation[] temp = new Equation[newEquationsNumber];

		System.arraycopy(equations, 0, temp, 0, newEquationsNumber);
		equations = temp;
	}

	private void backSolving() {

		for (int i = equations.length - 1; i >= 0; i--) {

			for (int j = coefficientsNumber - 1; j > i; j--) {

				subtract(i, j);
			}
		}
		equationResult = EquationResult.ONE;
	}

	private Equation getLastEquation() {
		return equations[equations.length - 1];
	}
}
