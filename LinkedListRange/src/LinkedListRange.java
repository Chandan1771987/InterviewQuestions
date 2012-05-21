public class LinkedListRange {

    private int a, b;
    private LinkedListRange next;

    LinkedListRange() {
    }

    LinkedListRange(int a, int b) {
        this.a = a;
        this.b = b;
        this.next = null;
    }

    public LinkedListRange getNext() {
        return next;
    }

    public void setNext(LinkedListRange next) {
        this.next = next;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void insert(LinkedListRange node, LinkedListRange root) {
        if (root == null) {
            root = node;
            return;
        }
        while (root.getNext() != null)
            root = root.getNext();
        root.setNext(node);
    }


    // 10 - 20 21 - 30 31-40 41- 50 61-80 81-100
    //25 - 35

    public LinkedListRange delete(LinkedListRange node, LinkedListRange root) {
        LinkedListRange temp;
        if (root == null || node.getA() == root.getA() && node.getB() == root.getB())
            return null;
        if (node == null || node.getA() > node.getB() || node.getA() < root.getA())  // if given node's a > b
            return root;
        temp = root;
        if (node.getA() == root.getA() && node.getB() == root.getB()) {
            if (root.getNext() == null)
                return null;
            root = root.getNext();
            temp = null;
            return root;
        }
        LinkedListRange firstNode = null, secondNode, tempTwo, prev = null;
        while (node.getA() >= temp.getA()) { //Find the node at which the first element 'a' is present.
            prev = firstNode;
            firstNode = temp;
            temp = temp.getNext();
        }
        if (temp == null)   //if given node is larger than the largest return null
            return null;
        secondNode = firstNode;
        temp = firstNode;
        while (node.getB() >= temp.getB()) {   //find the node at which the second element 'b' is present.
            secondNode = temp;
            tempTwo = temp;
            temp = temp.getNext();
            tempTwo = null;
        }
        if (firstNode == secondNode && firstNode.getA() == node.getA() && secondNode.getB() == node.getB()) {
            prev.setNext(firstNode.getNext());
        } else if (firstNode == secondNode) {
            LinkedListRange splitNode = new LinkedListRange(node.getB() + 1, firstNode.getB());
            firstNode.setB(node.getA() - 1);
            splitNode.setNext(firstNode.getNext());
            firstNode.setNext(splitNode);
        } else {
            secondNode = temp;
            secondNode.setA(node.getB() + 1);
            firstNode.setB(node.getA() - 1);
            firstNode.setNext(secondNode);
        }
        return root;
    }

    public void displayList(LinkedListRange root) {
        while (root != null) {
            System.out.println("Value a : " + root.getA() + "   Value B  " + root.getB());
            root = root.getNext();
        }
    }

    public static void main(String[] args) {
        LinkedListRange root = new LinkedListRange(0, 10);
        LinkedListRange secondNode = new LinkedListRange(11, 20);
        LinkedListRange thirdNode = new LinkedListRange(21, 30);
        LinkedListRange fourthNode = new LinkedListRange(31, 40);
        LinkedListRange fifthNode = new LinkedListRange(41, 50);
        LinkedListRange sixthNode = new LinkedListRange(51, 60);
        LinkedListRange seventhNode = new LinkedListRange(61, 70);
        LinkedListRange linkedListRange = new LinkedListRange();
        linkedListRange.insert(secondNode, root);
        linkedListRange.insert(thirdNode, root);
        linkedListRange.insert(fourthNode, root);
        linkedListRange.insert(fifthNode, root);
        linkedListRange.insert(sixthNode, root);
        linkedListRange.insert(seventhNode, root);
        System.out.println("$$$$$$$$$$$$$    Before Deletion $$$$$$$$$$$$$$$$$$");
        linkedListRange.displayList(root);
        LinkedListRange deleteThisNode = new LinkedListRange(24, 43);
        System.out.println("%%%%%%%%%%%%%   After Deletion $$$$$$$$$$$$$$$$$$$$ ");
        linkedListRange.displayList(linkedListRange.delete(deleteThisNode, root));
    }
}
