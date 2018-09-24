package matrix;

import java.util.Arrays;

public class GenericMatrix extends AbstractMatrix<GenericMatrix> {

  private int numRows, numColumns;

  public GenericMatrix(double[] values, int numRows, int numColumns) {
    this.numRows = numRows;
    this.numColumns = numColumns;
    this.values = Arrays.copyOf(values, values.length);
  }

  @Override
  public int numRows() {
    return numRows;
  }

  @Override
  public int numColumns() {
    return numColumns;
  }

  @Override
  public Matrix transpose() {
    return new GenericMatrix(transposeValues(), numColumns, numRows);
  }

  @Override
  public GenericMatrix scale(double scalar) {
    return new GenericMatrix(mapValues(val -> scalar * val), numRows, numColumns);
  }

  @Override
  public GenericMatrix add(GenericMatrix rhs) {
    return new GenericMatrix(addValues(rhs.values), numRows, numColumns);
  }

  @Override
  public Matrix multiply(Matrix rhs) {
    return new GenericMatrix(multiplyInternal(rhs), numRows, rhs.numColumns());
  }
}
