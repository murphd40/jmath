package matrix;

public interface SquareMatrix<T extends SquareMatrix<T>> extends Matrix<T> {

  double determinant();

  T inverse();

  @Override
  T transpose();
}
