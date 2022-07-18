package top.alin.solution;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> q = new PriorityQueue<>(); // 已经开始的会议的最早结束时间
        q.offer(intervals[0][1]);
        for(int i = 1; i < intervals.length; i++) {
            if (q.peek() <= intervals[i][0]) {
                q.poll();
            }
            q.offer(intervals[i][1]);
        }
        return q.size();
    }
}
