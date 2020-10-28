package solver;

public class LinearEquation {

	private int variables;
	private double[][] data;

	public LinearEquation(int variables, double[][] data) {

		this.variables = variables;
		this.data = data;
	}

	public double[] getResult() {

		double[] result = new double[variables];

		for (int i = 0; i < variables; i++) {
			result[i] = data[i][variables];
		}

		return result;
	}

	public void solve() {

		for (int column = 0; column < variables; column++) {
			solveColumn(column);
		}
	}

	private void solveColumn(int column) {

		selfDivideRow(column);

		for (int row = 0; row < variables; row++) {

			if (row != column) {
				subtractRow(data[row], data[column], data[row][column]);
			}
		}
	}

	private void selfDivideRow(int row) {

		double divider = data[row][row];

		divideRow(data[row], divider);
	}

	private void divideRow(double[] row, double value) {

		for (int i = 0; i < variables + 1; i++) {
			row[i] /= value;
		}
	}

	private void subtractRow(double[] row, double[] subtract, double multiplier) {

		for (int i = 0; i < variables + 1; i++) {
			row[i] -= multiplier * subtract[i];
		}
	}
}
