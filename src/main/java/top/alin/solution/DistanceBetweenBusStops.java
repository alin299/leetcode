package top.alin.solution;

public class DistanceBetweenBusStops {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start > destination) {
            return distanceBetweenBusStops(distance, destination, start);
        }
        int total = 0;
        for(int d : distance) {
            total += d;
        }
        int ans = 0;
        for(int i = start; i < destination; i++) {
            ans += distance[i];
        }
        return Math.min(ans, total - ans);
    }
}
