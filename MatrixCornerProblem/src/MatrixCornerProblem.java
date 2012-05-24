import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: achandan
 * Date: 5/24/12
 * Time: 6:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class MatrixCornerProblem {


    private Map<Set<Integer>, Integer> keyValue = new HashMap<Set<Integer>, Integer>();

    private int rows = 4, columns = 4;

    private int[][] num = new int[rows][columns];

    private int[][] getArray() {
        num = new int[][]{{0, 1, 6, 4},
                {2, 3, 14, 7},
                {13, 5, 8, 12},
                {10, 15, 9, 11}};
        return num;
    }

    private void display() {
        num = getArray();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(num[i][j] + " ");
            }
            System.out.println();
        }
    }


    private int findMinimumValueAndReachCorner(int m, int n) {

        if (m == rows - 1 && n == columns - 1) {
            return num[m][n];
        }
        if (m == rows - 1) {
            return num[m][n] + findMinimumValueAndReachCorner(m, n + 1);
        }
        if (n == columns - 1) {
            return num[m][n] + findMinimumValueAndReachCorner(m + 1, n);
        }
        return num[m][n] + min(findMinimumValueAndReachCorner(m, n + 1), findMinimumValueAndReachCorner(m + 1, n));
    }

    private int min(int r, int c) {
        return r < c ? r : c;
    }

    public static void main(String[] args) {

        MatrixCornerProblem matrixCornerProblem = new MatrixCornerProblem();
        System.out.println(" Matrix is ******************* ");
        matrixCornerProblem.display();
        if (matrixCornerProblem.rows <= 0 || matrixCornerProblem.columns <= 0) {
            System.out.println("Cant perform ");
            return;
        }
        System.out.println("Min sum is " + matrixCornerProblem.findMinimumValueAndReachCorner(0, 0));
    }

}
