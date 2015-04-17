import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: chandan
 * Date: 9/9/12
 * Time: 11:46 PM
 * To change this template use File | Settings | File Templates.
 */

public class SquaredSumOfSquareRoots {

    public static int countPairs(int N, int M)   {
        int totalNumber = 0;
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++)  {
                if(isInt(i,j)){
                    totalNumber++;
                }
            }
        }
        return totalNumber;
    }

    public static boolean isInt(double a,double b){
        double value;
        if(a == b) {
            return true;
        }

        value = Math.sqrt(a * b);

        if(value == Math.round(value)){
            return true;
        }
        return false;
    }
}

