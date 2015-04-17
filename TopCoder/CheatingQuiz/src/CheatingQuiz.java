import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CheatingQuiz {
    int totalCharacters = 0;
    HashMap<Character, Integer> charIntMapping = new HashMap<Character, Integer>();
    int[] countABC = new int[3];

    List<Integer> result = new ArrayList<Integer>();

    public int[] howMany(String answers) {

        charIntMapping.put('A', 0);
        charIntMapping.put('B', 1);
        charIntMapping.put('C', 2);

        for (int i = 0; i < answers.length(); i++) {
            countABC[charIntMapping.get(answers.charAt(i))]++;
        }


        for (int i : countABC)
            if (i > 0)
                totalCharacters++;

        if (totalCharacters == 1) {
            for (int i = 0; i < answers.length(); i++)
                result.add(1);
            return listToInt(result);
        }

        else if (totalCharacters == 0) {
            return new int[]{};
        }

        else {

            for (int i = 0; i < answers.length(); i++)
                count(answers, i);
        }


        return listToInt(result);
    }


    public void count(String answers, int i) {
        if (countABC[charIntMapping.get(answers.charAt(i))] != 0) {
            result.add(totalCharacters);
            countABC[charIntMapping.get(answers.charAt(i))]--;
            if (countABC[charIntMapping.get(answers.charAt(i))] == 0)
                totalCharacters--;
        }
    }


    public int[] listToInt(List<Integer> temp) {

        int[] ret = new int[temp.size()];
        for (int i = 0; i < ret.length; i++)
            ret[i] = temp.get(i);
        return ret;
    }

}

