package matrix;

import java.util.Arrays;
import java.util.function.DoubleUnaryOperator;

abstract class AbstractMatrix<T extends Matrix<T>> implements Matrix<T> {

  protected double[] values;

  protected double[] mapValues(DoubleUnaryOperator operator) {
    return Arrays.stream(values).map(operator).toArray();
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();

    stringBuilder.append('[');
    for (int i = 0; i < values.length; i++) {
      if (i % numRows() == 0) {
        stringBuilder.append('[');
      }
      stringBuilder.append(values[i]);
      if (i % numRows() == numRows() - 1) {
        stringBuilder.append(']');
      } else {
        stringBuilder.append(',');
      }
    }
    stringBuilder.append(']');

    return stringBuilder.toString();
  }
}
