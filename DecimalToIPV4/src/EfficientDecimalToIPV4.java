/**
 * Created by IntelliJ IDEA.
 * User: achandan
 * Date: 5/24/12
 * Time: 11:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class EfficientDecimalToIPV4 {

    private int num;
    private String DELIMITER=".";

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String toIPV4(){
        int i=3;
        String result="";
        int num=getNum();
        while(true){
            int temp = num%256;
            if(i<0)
                break;
            if(i==3)
                result = String.valueOf(num%256);
            else
                result = String.valueOf(num%256)+DELIMITER+result;
            num/=256;
            i--;
        }
        return result;
    }

    public static void main(String[] args) {
        EfficientDecimalToIPV4 efficientDecimalToIPV4 = new EfficientDecimalToIPV4();
        efficientDecimalToIPV4.setNum((int) Math.pow(2, 32));
        System.out.println(efficientDecimalToIPV4.toIPV4());
    }
    
}

