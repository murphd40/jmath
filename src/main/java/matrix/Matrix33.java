package matrix;

import java.util.Arrays;

public class Matrix33 extends AbstractSquareMatrix<Matrix33> {

  public Matrix33(double[] values) {
    if (values == null || values.length != numRows() * numColumns()) {
      throw new IllegalArgumentException();
    }
    super.values = Arrays.copyOf(values, values.length);
  }

  public static Matrix33 identity() {
    double[] values = {1, 0, 0, 0, 1, 0, 0, 0, 1};
    return new Matrix33(values);
  }

  @Override
  public float determinant() {
    return 0;
  }

  @Override
  public Matrix33 inverse() {
    return null;
  }

  @Override
  public int numRows() {
    return 3;
  }

  @Override
  public int numColumns() {
    return 3;
  }

  @Override
  public Matrix33 transpose() {
    double[] values = new double[9];

    for (int i = 0; i < values.length; i++) {
      int row = i / numRows();
      int col = i % numRows();
      int index = (numColumns() * col) + row;
      values[index] = this.values[i];
    }

    return new Matrix33(values);
  }

  @Override
  public Matrix33 scale(float scalar) {
    return new Matrix33(mapValues(val -> scalar * val));
  }
}
