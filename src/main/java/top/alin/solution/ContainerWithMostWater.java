package top.alin.solution;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int ans = 0 ;
        int i = 0;
        int j = height.length - 1;
        while(i < j) {
            if(height[i] < height[j]) {
                ans = Math.max(ans, (j - i) * height[i++]);
            } else {
                ans = Math.max(ans, (j - i) * height[j--]);
            }
        }
        return ans;
    }
}
