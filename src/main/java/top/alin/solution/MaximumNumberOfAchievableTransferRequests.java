package top.alin.solution;

public class MaximumNumberOfAchievableTransferRequests {
    int m;
    int n;
    int[][] requests;
    public int maximumRequests(int n, int[][] requests) {
        int ans = 0;
        this.requests = requests;
        this.m = requests.length;
        this.n = n;
        for(int i = 0; i < (1 << m); ++i) {
            int cnt = Integer.bitCount(i);
            if(cnt < ans) {continue;}
            if(check(i)) {
                ans = cnt;
            }
        }
        return ans;

    }
    public boolean check(int state) {
        int[] delta = new int[n];
        int sum = 0;
        for(int i = 0; i < m; ++i) {
            if(((state >> i) & 1) == 1) {
                int x = requests[i][0];
                int y = requests[i][1];
                if(++delta[x] == 1) {++sum;}
                if(--delta[y] == 0) {--sum;}
            }
        }
        return sum == 0;
    }
}
