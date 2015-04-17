import java.util.HashSet;
import java.util.Set;

public class TheQuestionsAndAnswersDivTwo {

    private Set<String> uniqueQuestions = new HashSet<String>();

    public int find(String[] questions) {
        for (String temp : questions)
            uniqueQuestions.add(temp);
        return (int) Math.pow(2, uniqueQuestions.size());
    }
}