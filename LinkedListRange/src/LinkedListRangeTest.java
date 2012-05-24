import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by IntelliJ IDEA.
 * User: achandan
 * Date: 5/21/12
 * Time: 11:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class LinkedListRangeTest {

    private LinkedListRange linkedListRange;
    private LinkedListRange root ;
    private LinkedListRange secondNode ;
    private LinkedListRange thirdNode ;
    private LinkedListRange fourthNode;
    private LinkedListRange fifthNode;
    private LinkedListRange sixthNode;
    private LinkedListRange seventhNode;

    public void insert(){
        linkedListRange = new LinkedListRange();
        root = new LinkedListRange(0,10);
        secondNode = new LinkedListRange(11,20);
        thirdNode = new LinkedListRange(21,30);
        fourthNode = new LinkedListRange(31,40);
        fifthNode = new LinkedListRange(41,50);
        sixthNode = new LinkedListRange(51,60);
        seventhNode = new LinkedListRange(61,70);
        linkedListRange.insert(secondNode,root);
        linkedListRange.insert(thirdNode,root);
        linkedListRange.insert(fourthNode,root);
        linkedListRange.insert(fifthNode,root);
        linkedListRange.insert(sixthNode,root);
        linkedListRange.insert(seventhNode,root);
    }
    
    @Test
    public void testOne() {
        insert();
        LinkedListRange temp = root;
        Assert.assertEquals(temp.getA(),linkedListRange.delete(new LinkedListRange(56,55),root).getA());
    }

    @Test
    public void testTwo() {
        insert();
        Assert.assertEquals(null,linkedListRange.delete(new LinkedListRange(0,70),root));
    }

    @Test
    public void testThree() {
        insert();
        LinkedListRange temp=root;
        temp=temp.getNext();
        Assert.assertEquals(temp.getA(),linkedListRange.delete(new LinkedListRange(0,10),root).getA());
    }

}
