package top.alin.solution;

public class NumberOfRectanglesThatCanFormTheLargestSquare {
    public int countGoodRectangles(int[][] rectangles) {
        int maxLen = 0;
        int ans = 0;
        for(int[] rectangle : rectangles) {
            int min = Math.min(rectangle[0], rectangle[1]);
            if(min > maxLen) {
                ans = 1;
                maxLen = min;
            } else if(min == maxLen) {
                ans++;
            }
        }
        return ans;
    }
}
