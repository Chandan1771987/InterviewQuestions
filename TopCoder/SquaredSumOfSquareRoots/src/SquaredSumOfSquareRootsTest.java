import org.testng.annotations.Test;
import org.testng.Assert;

/**
* Created with IntelliJ IDEA.
* User: chandan
* Date: 1/23/13
* Time: 12:36 AM
* To change this template use File | Settings | File Templates.
*/
public class SquaredSumOfSquareRootsTest {
    @Test
    public void testCountPairsOne() throws Exception {
         Assert.assertEquals(2, SquaredSumOfSquareRoots.countPairs(2, 2));
    }

    @Test
    public void testCountPairsTwo() throws Exception {
        Assert.assertEquals(3, SquaredSumOfSquareRoots.countPairs(10, 1));
    }

    @Test
    public void testCountPairsThree() throws Exception {
        Assert.assertEquals(5, SquaredSumOfSquareRoots.countPairs(3, 8));
    }

    @Test
    public void testCountPairsFour() throws Exception {
        Assert.assertEquals(310, SquaredSumOfSquareRoots.countPairs(100, 100));
    }
}
