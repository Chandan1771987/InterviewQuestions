public class LeftOrRight {
    public int maxDistance(String program) {
        int leftMax = findLeftRight(program, 'L');
        int rightMax = findLeftRight(program, 'R');
        return leftMax > rightMax ? leftMax : rightMax;
    }

    private int findLeftRight(String program, Character symbol) {
        int leftCount = 0, rightCount = 0;
        int maxLeft = 0, maxRight = 0;
        for (int i = 0; i < program.length(); i++) {
            if (program.charAt(i) == symbol) {
                if (rightCount > 0) {
                    rightCount--;
                } else {
                    leftCount++;
                    if (maxLeft < leftCount)
                        maxLeft = leftCount;
                }
            } else {
                if (leftCount > 0) {
                    leftCount--;
                } else {
                    rightCount++;
                    if (maxRight < rightCount)
                        maxRight = rightCount;
                }
            }
        }
        return maxLeft > maxRight ? maxLeft : maxRight;
    }

}