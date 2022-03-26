package top.alin.solution;

public class BaseballGame {
    public int calPoints(String[] ops) {
        int[] arr = new int[ops.length];
        int curr = 0;
        int ans = 0;
        for (String s : ops) {
            switch(s) {
                case "+":
                    arr[curr] = arr[curr - 1] + arr[curr - 2];
                    ans += arr[curr++];
                    break;
                case "D":
                    arr[curr] = arr[curr - 1] * 2;
                    ans += arr[curr++];
                    break;
                case "C":
                    ans -= arr[--curr];
                    break;
                default:
                    arr[curr] = Integer.valueOf(s);
                    ans += arr[curr++];
            }
        }
        return ans;
    }
}
