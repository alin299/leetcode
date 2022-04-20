package top.alin.solution;


public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String s) {
        int ans = 0;
        int n = s.length();
        int[] depth = new int[n + 1];
        for (int i = 0; i < n;) {
            int level = 0;
            while (i < n && s.charAt(i) == '\t') {
                level++;
                i++;
            }
            int j = i;
            boolean isDir = true;
            while(j < n && s.charAt(j) != '\n') {
                if (s.charAt(j++) == '.') {
                    isDir = false;
                }
            }
            int curr = j - i;
            int pre = level >= 1 ? depth[level - 1] : -1;
            int path = pre + 1 + curr;
            if (isDir) {
                depth[level] = path;
            } else if (path > ans) {
                ans = path;
            }
            i = j + 1;
        }
        return ans;
    }

}
