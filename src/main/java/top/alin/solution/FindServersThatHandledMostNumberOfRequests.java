package top.alin.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindServersThatHandledMostNumberOfRequests {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] count = new int[arrival.length];
        int max = 0;
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> available = new PriorityQueue<>();
        for(int i = 0; i < k; ++i) {
            available.offer(i);
        }
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int i = 0; i < arrival.length; ++i) {
            while(!busy.isEmpty() && busy.peek()[1] <= arrival[i]) {
                int id = busy.poll()[0];
                available.offer(i + ((id - i) % k + k) % k);
            }
            if (available.isEmpty()) {
                continue;
            }
            int server = available.poll() % k;
            ++count[server];
            busy.offer(new int[]{server, arrival[i] + load[i]});
            max = Math.max(max, count[server]);
        }
        for (int i = 0; i < count.length; ++i) {
            if (count[i] == max) {
                ans.add(i);
            }
        }
        return ans;
    }
}
