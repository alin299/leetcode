package top.alin.solution;

public class MakeTwoArraysEqualByReversingSubArrays {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] count  = new int[1001];
        for(int i = 0; i < arr.length; i++) {
            count[target[i]]++;
            count[arr[i]]--;
        }
        for(int num : count) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}
