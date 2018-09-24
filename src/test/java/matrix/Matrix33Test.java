package matrix;

import org.junit.Test;

public class Matrix33Test {

  @Test
  public void constructor() {
    Matrix33 matrix33 = Matrix33.of(11, 12, 13, 21, 22, 23, 31, 32, 33);

    System.out.println(matrix33.transpose());

    System.out.println(matrix33.scale(2));

    System.out.println(matrix33);

    System.out.println(matrix33.scale(2).transpose());

    System.out.println(matrix33.transpose().scale(2));
  }

  @Test
  public void identity() {
    Matrix33 identity = Matrix33.identity();

    System.out.println(identity.scale(3).toString());
  }

  @Test
  public void determinant() {
    System.out.println(Matrix33.identity().determinant());

    System.out.println(Matrix33.of(1,2,3,2,1,2,3,2,1).determinant());
  }

  @Test
  public void add() {
    System.out.println(Matrix33.identity().add(Matrix33.of(2,2,2,2,2,2,2,2,2)));
    System.out.println(Matrix33.identity().add(Matrix33.of(2,2,2,2,2,2,2,2,2)).scale(-1));
    System.out.println(Matrix33.identity().add(Matrix33.of(2,2,2,2,2,2,2,2,2).scale(-1)));
  }

  @Test
  public void multiply() {
    System.out.println(Matrix33.of(1,2,3,4,5,6,7,8,9).multiply(Matrix33.of(1,1,1,1,1,1,1,1,1)));
  }
}
