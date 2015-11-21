/**
 * Created by chandan.marathe on 11/21/2015.
 */

public class GlobalCounter {
    static int count=0;
    private static GlobalCounter _instance;

    public int getNext(){
        count++;
        return count;
    }

    // we can follow eager instantiation also or we can use threadSafe plus some optimization using the blocks
    public static GlobalCounter getInstance(){
        if(_instance == null){
            _instance = new GlobalCounter();
        }
        return _instance;
    }
}
