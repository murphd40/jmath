package matrix;

abstract class AbstractSquareMatrix<T extends SquareMatrix<T>> extends AbstractMatrix<T>
    implements SquareMatrix<T> {

  @Override
  public double determinant() {
    return determinant(numRows(), values);
  }

  private static double determinant(int numRows, double[] values) {
    if (numRows == 1) {
      return values[0];
    }

    double det = 0;

    for (int r = 0; r < numRows; r++) {
      det += sign(r) * values[r] * determinant(numRows-1, minor(numRows, r, values));
    }

    return det;
  }

  private static double[] minor(int numRows, int row, double[] values) {
    double[] minor = new double[(numRows-1)*(numRows-1)];

    int index = 0;
    for (int i = numRows; i < values.length; i++) {
      if (i % numRows == row) {
        continue;
      }

      minor[index++] = values[i];
    }

    return minor;
  }

  private static double sign(int row) {
    return row % 2 == 0 ? 1 : -1;
  }
}
