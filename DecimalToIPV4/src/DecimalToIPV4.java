import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: achandan
 * Date: 5/24/12
 * Time: 11:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class DecimalToIPV4 {
    
    private int num;
    
    private String eightBitZeros = "00000000";

    public HashMap<String,String> binaryDecimal = constructHashMap();
    
    private String thirtyTwoBitZeros = "000000000000000000000000000000000";

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    
    public HashMap<String, String> constructHashMap(){
        int num=255;
        HashMap<String,String> binaryDecimal = new HashMap<String, String>();
        binaryDecimal.put("00000000","0");
        StringBuilder remainders ;
        while(num!=0){
            remainders = new StringBuilder();
            int temp = num;
            while(temp!=0){
            remainders.append(temp%2);
            temp=temp/2;
            }
            binaryDecimal.put(eightBitZeros.substring(0,8-remainders.length())+remainders.reverse().toString(), String.valueOf(num));
            num--;
        }
        return binaryDecimal;
    } 
    
    public String numToIPv4(){
        int num = getNum();
        
        StringBuilder stringBuilder = new StringBuilder();
        while(num!=0){
            stringBuilder.append(num % 2);
            num>>=1;
        }
        int len=stringBuilder.length();
        stringBuilder.append(thirtyTwoBitZeros.substring(0,32-len));
        stringBuilder.reverse();
        return binaryDecimal.get(stringBuilder.substring(0,8))+"."+binaryDecimal.get(stringBuilder.substring(8,16))+"."+binaryDecimal.get(stringBuilder.substring(16, 24))+"."+binaryDecimal.get(stringBuilder.substring(24, 32));
    }

    public static void main(String[] args) {
        DecimalToIPV4 decimalToIPV4 = new DecimalToIPV4();
        decimalToIPV4.setNum((int) Math.pow(2,30));
        System.out.println(decimalToIPV4.numToIPv4());

    }
    
}
