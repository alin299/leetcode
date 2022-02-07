package top.alin.solution;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        for(char c : tasks) {
            arr[c - 'A']++;
        }
        int max = 0;
        int maxCount = 0;
        for(int num : arr) {
            if(num > max) {
                maxCount = 1;
                max = num;
            } else if(num == max) {
                maxCount++;
            }
        }
        return Math.max(tasks.length, (max - 1) * (n + 1) + maxCount);
    }
}
