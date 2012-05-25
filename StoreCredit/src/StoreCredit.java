import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: achandan
 * Date: 5/25/12
 * Time: 11:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class StoreCredit {

    private Scanner fileReader;
    private FileWriter fileWriter;


    public void initialise() throws IOException {
        fileReader = new Scanner(new File("./StoreCredit/largeinputfile.in"));
        fileWriter = new FileWriter("./StoreCredit/largeoutputfile.out",true);
    }

    public int min(int a,int b){
        return a<b?a:b;
    }
    
    public int max(int a,int b){
        return a>b?a:b;
    }
    
    public void storeCredit() throws IOException {

        int totalInputs = Integer.parseInt(fileReader.nextLine());
        Map<String, ArrayList<Integer>> keyValue = new HashMap<String, ArrayList<Integer>>();
        int i = 1;

        while (fileReader.hasNext()) {

            int credit = Integer.parseInt(fileReader.nextLine());
            int totalNumberOfArrayElements = Integer.parseInt(fileReader.nextLine());
            StringTokenizer stringTokenizer = new StringTokenizer(fileReader.nextLine());
            List<String> keyList = new ArrayList<String>();
            Integer index = 1;
            ArrayList<Integer> indices;
            while (stringTokenizer.hasMoreElements()) {
                String element = stringTokenizer.nextToken();
                keyList.add(element);
                if(keyValue.get(element)==null){
                    indices = new ArrayList<Integer>();
                    indices.add(index);
                    keyValue.put(element,indices);
                }
                else{
                    indices = keyValue.get(element);
                    indices.add(index);
                    keyValue.put(element,indices);
                }
                index++;
            }
            for (String integer : keyList) {
                int temp = credit-Integer.parseInt(integer);
                if (keyValue.get(String.valueOf(temp)) != null) {
                    if (i == totalInputs) {
                        if(Integer.parseInt(integer) == temp)
                            fileWriter.append("Case #" + i + ": " + min(keyValue.get(String.valueOf(integer)).get(0),keyValue.get(String.valueOf(temp)).get(1)) + " " + max(keyValue.get(String.valueOf(integer)).get(0),keyValue.get(String.valueOf(temp)).get(1)));
                        else
                            fileWriter.append("Case #" + i + ": " + min(keyValue.get(String.valueOf(integer)).get(0),keyValue.get(String.valueOf(temp)).get(0)) + " " + max(keyValue.get(String.valueOf(integer)).get(0),keyValue.get(String.valueOf(temp)).get(0)));
                        break;
                    }
                    if(Integer.parseInt(integer) == temp)
                        fileWriter.append("Case #" + i + ": " + min(keyValue.get(String.valueOf(integer)).get(0),keyValue.get(String.valueOf(temp)).get(1)) + " " + max(keyValue.get(String.valueOf(integer)).get(0),keyValue.get(String.valueOf(temp)).get(1)) + "\n");
                    else
                        fileWriter.append("Case #" + i + ": " + min(keyValue.get(String.valueOf(integer)).get(0),keyValue.get(String.valueOf(temp)).get(0)) + " " + max(keyValue.get(String.valueOf(integer)).get(0),keyValue.get(String.valueOf(temp)).get(0)) + "\n");
                    break;
                }
            }
            i++;
        }
        fileReader.close();
        fileWriter.close();
    }

    public static void main(String[] args) throws IOException {
        StoreCredit storeCredit = new StoreCredit();
        storeCredit.initialise();
        storeCredit.storeCredit();
    }
}
