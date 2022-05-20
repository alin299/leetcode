package top.alin.solution;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < n;) {
            int j = i + 1;
            while(j < n && nums[j] == nums[j - 1] + 1) {
                j++;
            }
            j--;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[i]));
            if (i < j) {
                temp.append("->");
                temp.append(nums[j]);
            }
            ans.add(temp.toString());
            i = j + 1;
        }
        return ans;
    }
}
