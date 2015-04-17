import java.util.Iterator;
import java.util.TreeMap;

public class PrefixCode {
    private TreeMap<String,Integer> treeMap = new TreeMap<String, Integer>();
	public String isOne(String[] words) {
        if(words.length<=1)
            return "Yes";
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words.length;j++){
                if (words[j].startsWith(words[i]) && !words[j].equals(words[i])) treeMap.put(words[i], i);
            }
            if(treeMap.size()>=1){
                Iterator<Integer> integerIterator = treeMap.values().iterator();
                int temp = integerIterator.next();
                System.out.println(temp);
                return "No, "+temp;
            }
        }
		return "Yes";
	}
}

