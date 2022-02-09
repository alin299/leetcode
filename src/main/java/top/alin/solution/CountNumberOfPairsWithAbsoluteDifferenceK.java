package top.alin.solution;

public class CountNumberOfPairsWithAbsoluteDifferenceK {
    public int countKDifference(int[] nums, int k) {
        int[] arr = new int[101];
        for(int num : nums) {
            arr[num]++;
        }
        int ans = 0;
        for(int i = k; i < arr.length; ++i) {
            if(arr[i] != 0 && arr[i - k] !=0) {
                ans += (arr[i] * arr[i - k]);
            }
        }
        return ans;
    }
}
