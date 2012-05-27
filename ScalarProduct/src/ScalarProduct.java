import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by IntelliJ IDEA.
 * User: achandan
 * Date: 5/27/12
 * Time: 10:41 AM
 * To change this template use File | Settings | File Templates.
 */
public class ScalarProduct {

    private Scanner fileReader;
    
    private FileWriter fileWriter;
    
    public void initialize() throws IOException {
        
        fileReader = new Scanner(new File("./ScalarProduct/largeinputfile.in"));
        fileWriter = new FileWriter("./ScalarProduct/largeoutputfile.out",true);
    }
    
    
    public void findScalarProduct() throws IOException {
        int totalInputs = Integer.parseInt(fileReader.nextLine());
        int input=1;
        List<Integer> arrayOne;
        List<Integer> arrayTwo;

        while(fileReader.hasNext()){
            int totalNumberOfElements = Integer.parseInt(fileReader.nextLine());
            arrayOne = new ArrayList<Integer>();
            arrayTwo = new ArrayList<Integer>();

            StringTokenizer arrayOneTokenizer = new StringTokenizer(fileReader.nextLine());
            StringTokenizer arrayTwoTokenizer = new StringTokenizer(fileReader.nextLine());
            for(int i=0;i<totalNumberOfElements;i++){
              arrayOne.add(Integer.valueOf(arrayOneTokenizer.nextToken()));
              arrayTwo.add(Integer.valueOf(arrayTwoTokenizer.nextToken()));
            }
            int crossProductSum = 0;
            for(int i=0;i<totalNumberOfElements;i++)
                for(int j=0;j<totalNumberOfElements;j++)
                    crossProductSum+=arrayOne.get(i)*arrayTwo.get(j);
            if(input==totalInputs)
                fileWriter.append("Case #"+input+": "+crossProductSum);
            else
                fileWriter.append("Case #"+input+": "+crossProductSum+"\n");
            input++;
        }
        fileReader.close();
        fileWriter.close();
    }

    public static void main(String[] args) throws IOException {
        ScalarProduct scalarProduct = new ScalarProduct();
        scalarProduct.initialize();
        scalarProduct.findScalarProduct();
    }

}
