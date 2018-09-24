package matrix;

import java.util.Arrays;

public class Matrix33 extends AbstractSquareMatrix<Matrix33> {

  private Matrix33(double[] values) {
    if (values == null || values.length != numRows() * numColumns()) {
      throw new IllegalArgumentException();
    }
    super.values = Arrays.copyOf(values, values.length);
  }

  public static Matrix33 identity() {
    double[] values = {1, 0, 0, 0, 1, 0, 0, 0, 1};
    return new Matrix33(values);
  }

  public static Matrix33 of(double... values) {
    return new Matrix33(values);
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
    return new Matrix33(transposeValues());
  }

  @Override
  public Matrix33 scale(double scalar) {
    return new Matrix33(mapValues(val -> scalar * val));
  }

  @Override
  public Matrix33 add(Matrix33 rhs) {
    return new Matrix33(addValues(rhs.values));
  }

  @Override
  public Matrix33 multiply(Matrix rhs) {
    return new Matrix33(multiplyInternal(rhs));
  }
}
