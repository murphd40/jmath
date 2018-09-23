package matrix;

public interface Matrix<T extends Matrix<T>> {

  int numRows();

  int numColumns();

  Matrix transpose();

  T scale(float scalar);
}
