import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by IntelliJ IDEA.
 * User: achandan
 * Date: 5/25/12
 * Time: 8:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReverseWords {
    private Scanner fileReader;

    private FileWriter fileWriter;

    public void initInputOutputFile() throws IOException {
        fileReader = new Scanner(new File("./ReverseWords/largeinput.in"));
        fileWriter = new FileWriter("./ReverseWords/largeoutput.out",true);
    }

    public void reverse() throws IOException {
        StringTokenizer stringTokenizer = null;
        int num = Integer.parseInt(fileReader.nextLine());
        int i = 1;
        while (i <= num && fileReader.hasNext()) {
            stringTokenizer = new StringTokenizer(fileReader.nextLine());
            int numberOfTokens = stringTokenizer.countTokens();
            String temp = new String();
            int j=numberOfTokens;
            while (stringTokenizer.hasMoreElements()) {
                    if(j==numberOfTokens)
                        temp=stringTokenizer.nextToken();
                    else
                        temp = stringTokenizer.nextToken()+" "+temp;
                j--;
            }

            if(i==num)
            fileWriter.append("Case #"+i+": "+temp);
            else
                fileWriter.append("Case #"+i+": "+temp+"\n");

            i++;
        }
        fileReader.close();
        fileWriter.close();
    }

    public static void main(String[] args) throws IOException {
        ReverseWords reverseWords = new ReverseWords();
        System.out.println(System.getProperty("user.dir"));
        reverseWords.initInputOutputFile();
        reverseWords.reverse();
    }

}
