package top.alin.solution;

public class NumberOfStepsToReduceANumberToZero {
    public int numberOfSteps(int num) {
        int ans = 0;
        while(num > 0) {
            ans += ((num > 1 ? 1 : 0) + (num & 1));
            num >>= 1;
        }
        return ans;
    }
}
