/**
 * Created by IntelliJ IDEA.
 * User: achandan
 * Date: 5/26/12
 * Time: 9:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class BraceCombination {

   public void print(String ans, int leftCount, int rightCount) {

        if (leftCount == 0 && rightCount == 0) {
            System.out.println(ans);
            return;
        }

        if (leftCount > 0) {
            print(ans + "(", leftCount - 1, rightCount);
        }

        if (rightCount > leftCount) {
            print(ans + ")", leftCount, rightCount - 1);
        }
    }

    public static void main(String[] args) {
        BraceCombination braceCombination = new BraceCombination();
        braceCombination.print("",5,5);
    }
}
