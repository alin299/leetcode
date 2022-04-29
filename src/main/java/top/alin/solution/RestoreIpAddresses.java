package top.alin.solution;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    List<String> ans;
    List<String> path;
    public List<String> restoreIpAddresses(String s) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        dfs(s, 0, 0);
        return ans;
    }

    void dfs(String s, int start, int count) {
        if (count == 4) {
            if (start == s.length()) {
                ans.add(String.join(".", path));
            }
            return;
        }
        for(int i = start; i < start + 3 && i < s.length(); i++) {
            if (i > start && s.charAt(start) == '0') {
                break;
            }
            String p = s.substring(start, i + 1);
            if (Integer.parseInt(p) > 255) {
                break;
            }
            path.add(p);
            dfs(s, i + 1, count + 1);
            path.remove(path.size() - 1);
        }
    }
}
