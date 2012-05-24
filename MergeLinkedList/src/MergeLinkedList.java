/**
 * Created by IntelliJ IDEA.
 * User: achandan
 * Date: 5/22/12
 * Time: 1:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class MergeLinkedList {

    private int element;
    private MergeLinkedList next;

    MergeLinkedList() {
    }

    MergeLinkedList(int data) {
        this.element = data;
        this.next = null;
    }

    public void setNext(MergeLinkedList list) {
        this.next = list;
    }

    public MergeLinkedList getNext() {
        return next;
    }

    public int getData() {
        return element;
    }

    public void insertData(int data) {
        MergeLinkedList temp = this;
        if(temp==null)      {
            temp = new MergeLinkedList(data);
            return;
        }
        while(temp.getNext()!=null)
            temp = temp.getNext();
        temp.setNext(new MergeLinkedList(data));

    }

    public void display(MergeLinkedList root) {
        while (root != null) {
            System.out.println("Element is : " + root.getData());
            root = root.getNext();
        }
    }


    public MergeLinkedList merge(MergeLinkedList listOne, MergeLinkedList listTwo) {

        MergeLinkedList current;
        MergeLinkedList pointerTwo;
        MergeLinkedList previous = null, temp;

        if (listOne == null && listTwo == null)
            return null;
        if (listOne == null)
            return listTwo;
        if (listTwo == null)
            return listOne;
        if (listOne.getData() < listTwo.getData()) {
            current = listOne;
            pointerTwo = listTwo;
        } else {
            current = listTwo;
            pointerTwo = listOne;
        }
        MergeLinkedList start = current;
        while (current != null && pointerTwo != null) {
            while (current != null && pointerTwo != null && current.getData() <= pointerTwo.getData()) {
                previous = current;
                current = current.getNext();
            }
            temp = pointerTwo;
            pointerTwo = pointerTwo.getNext();
            previous.setNext(temp);
            temp.setNext(current);
            previous = previous.getNext();
        }
        if (current == null)
            previous.setNext(pointerTwo);
        return start;
    }

    public static void main(String[] args) {
        MergeLinkedList mergeLinkedList = new MergeLinkedList();
        MergeLinkedList listOne = new MergeLinkedList(10);
        MergeLinkedList listTwo = new MergeLinkedList(30);
        for (int i = 1; i <= 10; i++) {
            listOne.insertData(i + 10);
            listTwo.insertData(i + 40);
        }
        System.out.println("List One ^^^^^^^^^^^^^^^^^^^^^^");
        mergeLinkedList.display(listOne);
        System.out.println("List Two $$$$$$$$$$$$$$$$$$$$$$$");
        mergeLinkedList.display(listTwo);
        System.out.println("Merged List is &%%%%%%%%%%%%%%%%%");
        mergeLinkedList.display(mergeLinkedList.merge(listOne, listTwo));
    }
}

