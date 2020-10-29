package solver;

public class LinearEquation {

	private final int coefficientsNumber;
	private final double[][] data;

	public LinearEquation(InputFileReader reader) {

		this.coefficientsNumber = reader.getCoefficientsNumber();
		this.data = reader.getData();
	}

	public double[] getResult() {

		double[] result = new double[coefficientsNumber];

		for (int i = 0; i < coefficientsNumber; i++) {
			result[i] = data[i][coefficientsNumber];
		}

		return result;
	}

	public void solve() {

		for (int column = 0; column < coefficientsNumber; column++) {
			solveColumn(column);
		}
	}

	private void solveColumn(int column) {

		selfDivideRow(column);

		for (int row = 0; row < coefficientsNumber; row++) {

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

		for (int i = 0; i < coefficientsNumber + 1; i++) {
			row[i] /= value;
		}
	}

	private void subtractRow(double[] row, double[] subtract, double multiplier) {

		for (int i = 0; i < coefficientsNumber + 1; i++) {
			row[i] -= multiplier * subtract[i];
		}
	}
}
