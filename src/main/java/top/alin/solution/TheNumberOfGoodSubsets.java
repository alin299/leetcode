package top.alin.solution;

public class TheNumberOfGoodSubsets {
    static final int[] PRIMES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    static final int MAX = 30;
    static final int MOD = 1000000007;
    public int numberOfGoodSubsets(int[] nums) {
        int[] count = new int[MAX + 1];
        for (int num : nums) {
            ++count[num];
        }
        int[] dp = new int[1 << PRIMES.length];
        dp[0] = 1;
        for(int i = 0; i < count[1]; ++i) {
            dp[0] = (dp[0] * 2) % MOD;
        }
        for (int i = 2; i <= MAX; ++i) {
            if(count[i] == 0) {continue;}

            boolean check = true;
            int x = i;
            int subset = 0;
            for(int j = 0; j < PRIMES.length; ++j) {
                int prime = PRIMES[j];
                if(x % (prime * prime) == 0) {
                    check = false;
                    break;
                }
                if(x % prime == 0) {
                    subset |= (1 << j);
                }
            }
            if (!check) {continue;}

            for (int mask = (1 << PRIMES.length) - 1; mask > 0; --mask) {
                if ((mask & subset) == subset) {
                    dp[mask] = (int) ((dp[mask] + ((long) dp[mask ^ subset]) * count[i]) % MOD);
                }
            }
        }
        int ans = 0;
        for (int mask = (1 << PRIMES.length) - 1; mask >= 1; --mask) {
            ans = (ans + dp[mask]) % MOD;
        }
        return ans;
    }
}
