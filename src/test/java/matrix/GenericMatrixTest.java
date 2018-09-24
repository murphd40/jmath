package matrix;

import org.junit.Test;

public class GenericMatrixTest {

  @Test
  public void multiply() {
    GenericMatrix A = new GenericMatrix(new double[]{1, 2, 3, 4, 5, 6}, 3, 2);
    GenericMatrix B = new GenericMatrix(new double[]{1, 2, 3, 4, 5, 6, 7, 8}, 2, 4);

    Matrix C = A.multiply(B);

    System.out.println(C);

    // expect: [[11,14,17,20],[23,30,37,44],[35,46,57,68]]

    // todo - fix transpose, it doesn't work
  }
}
