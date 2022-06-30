package top.alin.solution;

public class PrimeArrangements {
    int MOD = (int)1e9+7;
    public int numPrimeArrangements(int n) {
        int primeCount = 0;
        for(int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                primeCount++;
            }
        }
        return (int)(calc(n - primeCount) * calc(primeCount) % MOD);
    }

    long calc(int num) {
        long res = 1;
        for (int i = 1; i <= num; i++) {
            res *= i;
            res %= MOD;
        }
        return res;
    }

    boolean isPrime(int num) {
        for(int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
