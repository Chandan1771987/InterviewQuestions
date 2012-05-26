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
public class MatrixCornerProblemWithMemoize {


    private Map<Set<Integer>, Integer> keyValue = new HashMap<Set<Integer>, Integer>();

//   public int count=0;

   /*Use this count to check the difference with and without memoize solution.
   * There will be a drastic difference.
   * with memoize , this solution becomes O(N^2)
   *
   *
   * */

    private int rows = 4, columns = 4;

    private int[][] num = new int[rows][columns];
    private int[][] table = new int[rows][columns];

    public void initializeArray(){
      for(int i=0;i<rows;i++)
          for(int j=0;j<columns;j++)
              table[i][j]=-1;
    }

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

//        count++;
        if(table[m][n]!=-1)
            return table[m][n];
        if (m == rows - 1 && n == columns - 1) {
            return table[m][n]=num[m][n];
        }
        if (m == rows - 1) {
            return table[m][n]=num[m][n] + findMinimumValueAndReachCorner(m, n + 1);
        }
        if (n == columns - 1) {
            return table[m][n]=num[m][n] + findMinimumValueAndReachCorner(m + 1, n);
        }
        return table[m][n]=num[m][n] + min(findMinimumValueAndReachCorner(m, n + 1), findMinimumValueAndReachCorner(m + 1, n));
    }

    private int min(int r, int c) {
        return r < c ? r : c;
    }

    public static void main(String[] args) {

        MatrixCornerProblemWithMemoize matrixCornerProblemWithMemoize = new MatrixCornerProblemWithMemoize();
        matrixCornerProblemWithMemoize.initializeArray();
        System.out.println(" Matrix is ******************* ");
        matrixCornerProblemWithMemoize.display();
        if (matrixCornerProblemWithMemoize.rows <= 0 || matrixCornerProblemWithMemoize.columns <= 0) {
            System.out.println("Cant perform ");
            return;
        }
        System.out.println("Min sum is " + matrixCornerProblemWithMemoize.findMinimumValueAndReachCorner(0, 0));
//        System.out.println("Count is "+matrixCornerProblemWithMemoize.count);
    }

}
