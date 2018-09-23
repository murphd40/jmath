package matrix;

abstract class AbstractSquareMatrix<T extends SquareMatrix<T>> extends AbstractMatrix<T>
    implements SquareMatrix<T> {}
