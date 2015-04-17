import java.util.HashMap;

public class EvenRoute {

    private HashMap<String, Boolean> keyValue = new HashMap<String, Boolean>();

    public String isItPossible(int[] x, int[] y, int wantedParity) {
        if (checkIfZeros(x[0], y[0]) || x.length != y.length || x.length > 50 || y.length > 50 || x.length == 0 || y.length == 0||checkIfOutOfRange(x[0],y[0]))
            return "CANNOT";
        int sum = getSum(x[0], y[0]);
        keyValue.put(x[0] + "," + y[0], true);
        for (int i = 1; i < x.length; i++) {
            if (checkIfZeros(x[i], y[i]) || checkIfOutOfRange(x[i], y[i]) || checkIfDuplicate(x[i], y[i]))
                return "CANNOT";
            sum += getSum(x[i], y[i]);
        }
        return sum%2==wantedParity ? "CAN" : "CANNOT";
    }

    private boolean checkIfDuplicate(int x, int y) {
        String temp = x + "," + y;
        if (keyValue.containsKey(temp)) {
            return true;
        }
        keyValue.put(temp, true);
        return false;
    }

    private boolean checkIfOutOfRange(int x, int y) {
        return x < -1000000 || y < -1000000 || x > 1000000 || y > 1000000 ? true : false;
    }

    private boolean checkIfZeros(int x, int y) {
        return (x == 0 && y == 0) ? true : false;
    }

    private int getSum(int x, int y) {
        return Math.abs(x)%2 + Math.abs(y)%2;
    }
}
