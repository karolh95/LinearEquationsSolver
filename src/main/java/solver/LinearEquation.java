package solver;

public class LinearEquation {

	private final int coefficientsNumber;
	private final Equation[] equations;

	public LinearEquation(InputFileReader reader) {

		this.coefficientsNumber = reader.getCoefficientsNumber();
		this.equations = reader.getEquations();
	}

	public double[] getResult() {

		double[] result = new double[coefficientsNumber];

		for (int i = 0; i < equations.length; i++) {
			result[i] = equations[i].get(coefficientsNumber);
		}

		return result;
	}

	public void solve() {

		for (int column = 0; column < coefficientsNumber; column++) {
			solveColumn(column);
		}
	}

	private void solveColumn(int column) {

		double divider = getDiagonal(column);
		equations[column].divide(divider);

		for (int row = 0; row < coefficientsNumber; row++) {

			if (row != column) {

				double multiplier = equations[row].get(column);
				equations[row].subtract(equations[column], multiplier);
			}
		}
	}

	private double getDiagonal(int index) {
		return equations[index].get(index);
	}
}
