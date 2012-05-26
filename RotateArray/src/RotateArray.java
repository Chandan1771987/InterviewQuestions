/**
 * Created by IntelliJ IDEA.
 * User: achandan
 * Date: 5/26/12
 * Time: 9:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class RotateArray {
    
    public int count=0;
    
    private int arr[];
    
    private void setArrAndGetArr(){
        arr = new int[]{1,2, 3, 4,5,6,7,8,9,10};
    }
    
    public int gcd(int m,int n){
        if(m>n)
            return gcd(n,m-n);
        if(n>m)
            return gcd(n-m,m);
            return m;
    }

/* This function stores ith value in temp, and copies (i + gcd-th) %n index element to i-th element until i reaches its initial value.
* Example,if n=10, if gcd = 2, and initial i = 0, then, it stores a[0%10] in temp, and it copies a[2%10] to a[0], a[4%10] to a[2], a[6%10] to a[4], a[8%10] to a[6],
* Now, a[10 % 10] = a[0], so it comes out and it copies temp to a[10]
 * Similarly it does the same thing for i=1, gcd=2, and i continues till it becomes 1 again.
 * So, overall it takes just O(n)
* */

    public   void leftRotate( int d) {
        int i, j, k, temp;
        int n = arr.length;
        int gcd = gcd(d, n);
        for (i = 0; i < gcd; i++) {
            /* move i-th values of blocks */
            temp = arr[i];
            j = i;
            while (true) {
                k = j + d;
                if (k >= n)
                    k = k%n;
                if (k == i)
                    break;
                arr[j] = arr[k];
                j = k;
                count++;
            }
            arr[j] = temp;
            count++;
        }
    }
    public void display(){
        for(Integer integer:arr)
            System.out.print(" " + integer);
        System.out.println();
    }

    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        rotateArray.setArrAndGetArr();
        System.out.println("Before Rotaion");
        rotateArray.display();

        System.out.println("Afger rotataion");
        rotateArray.leftRotate(5);
        rotateArray.display();
        System.out.println(rotateArray.count);
    }
}
