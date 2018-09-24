package matrix;

public interface Matrix<T extends Matrix<T>> {

  int numRows();

  int numColumns();

  Matrix transpose();

  T scale(double scalar);

  T add(T rhs);

  Matrix multiply(Matrix rhs);

  double[] values();
}
