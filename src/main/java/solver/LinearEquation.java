package solver;

public class LinearEquation {

	private final int coefficientsNumber;
	private final Equation[] equations;

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
		backSolving();
	}

	private void reduceToEchelonMatrix() {

		for (int i = 0; i < equations.length; i++) {

			Equation equation = equations[i];

			for (int j = 0; j < i; j++) {

				double multiplier = equation.get(j);
				equation.subtract(equations[j], multiplier);
			}

			double divider = equation.get(i);
			equation.divide(divider);
		}

	}

	private void backSolving() {

		for (int i = equations.length - 1; i >= 0; i--) {

			Equation equation = equations[i];

			for (int j = coefficientsNumber - 1; j > i; j--) {

				double multiplier = equation.get(j);
				equation.subtract(equations[j], multiplier);
			}
		}
		equationResult = EquationResult.ONE;
	}
}
