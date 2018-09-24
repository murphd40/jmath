package matrix;

import java.util.Arrays;
import java.util.function.DoubleUnaryOperator;

abstract class AbstractMatrix<T extends Matrix<T>> implements Matrix<T> {

  protected double[] values;

  @Override
  public double[] values() {
    return Arrays.copyOf(values, values.length);
  }

  protected double[] mapValues(DoubleUnaryOperator operator) {
    return Arrays.stream(values).map(operator).toArray();
  }

  protected double[] transposeValues() {
    double[] values = new double[numRows() * numColumns()];

    for (int i = 0; i < values.length; i++) {
      int row = i / numRows();
      int col = i % numRows();
      int index = (numColumns() * col) + row;
      values[index] = this.values[i];
    }

    return values;
  }

  protected double[] addValues(double[] toAdd) {
    double[] result = new double[values.length];

    for (int i = 0; i < values.length; i++) {
      result[i] = values[i] + toAdd[i];
    }

    return result;
  }

  protected double[] multiplyInternal(Matrix rhs) {
    // check that its 3x3...

    double[] tmp = rhs.transpose().values();

    // result will have this.numRows() rows and rhs.numColumns columns
    double[] result = new double[this.numRows() * rhs.numColumns()];

    int index = 0;
    for (int m = 0; m < numRows(); m++) {
      for (int k = 0; k < rhs.numColumns(); k++) {
        for (int n = 0; n < numColumns(); n++) {
          result[index] += values[m * numColumns() + n] * tmp[k * rhs.numRows() + n];
        }
        index++;
      }
    }

    return result;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();

    stringBuilder.append('[');
    for (int i = 0; i < values.length; i++) {
      if (i % numColumns() == 0) {
        stringBuilder.append('[');
      }
      stringBuilder.append(values[i]);
      if (i % numColumns() == numColumns() - 1) {
        stringBuilder.append(']');
      } else {
        stringBuilder.append(',');
      }
    }
    stringBuilder.append(']');

    return stringBuilder.toString();
  }
}
