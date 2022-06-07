package top.alin.solution;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        int left = 1;
        int right = max;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (getTime(piles, mid) > h) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    int getTime(int[] piles, int k) {
        int total = 0;
        for(int pile : piles) {
            total += (pile + k - 1) / k;
        }
        return total;
    }
}
