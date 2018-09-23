package matrix;

import org.junit.Test;

public class Matrix33Test {

  @Test
  public void constructor() {
    Matrix33 matrix33 = new Matrix33(new double[] {11, 12, 13, 21, 22, 23, 31, 32, 33});

    System.out.println(matrix33.transpose());

    System.out.println(matrix33.scale(2));

    System.out.println(matrix33);

    System.out.println(matrix33.scale(2).transpose());

    System.out.println(matrix33.transpose().scale(2));
  }

  @Test
  public void identity() {
    Matrix33 identity = Matrix33.identity();

    System.out.println(identity.toString());
  }
}
