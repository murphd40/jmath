package matrix;

public interface SquareMatrix<T extends SquareMatrix<T>> extends Matrix<T> {

  float determinant();

  T inverse();

  @Override
  T transpose();
}
