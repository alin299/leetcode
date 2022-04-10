package top.alin.solution;

public class GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int max;
        int sum = 0;
        for (int i = 0; i < minutes; i++) {
            sum += customers[i] * grumpy[i];
        }
        max = sum;
        for(int i = minutes; i < customers.length; i++) {
            sum += customers[i] * grumpy[i];
            sum -= customers[i - minutes] * grumpy[i - minutes];
            max = Math.max(sum, max);
        }

        for (int i = 0; i < customers.length; i++) {
            max += customers[i] * (grumpy[i] ^ 1);
        }
        return max;
    }
}
