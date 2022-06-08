package top.alin.solution;

public class ValidBoomerang {
    public boolean isBoomerang(int[][] points) {
        int[] ab = {points[1][0] - points[0][0], points[1][1] - points[0][1]};
        int[] ac = {points[2][0] - points[0][0], points[2][1] - points[0][1]};
        return ab[0] * ac[1] != ab[1] * ac[0];
    }
}
