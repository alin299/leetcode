package top.alin.solution;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for(int i = 0; i < nums.length; i++) {
            int size = ans.size();
            for(int j = 0; j < size; j++) {
                List<Integer> temp = new ArrayList<>(ans.get(j));
                temp.add(nums[i]);
                ans.add(temp);
            }
        }
        return ans;
    }
}
