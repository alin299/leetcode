package top.alin.solution;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] a = version1.split("\\.");
        String[] b = version2.split("\\.");
        for(int i = 0; i < a.length || i < b.length; i++) {
            int v1 = i < a.length ? Integer.valueOf(a[i]) : 0;
            int v2 = i < b.length ? Integer.valueOf(b[i]) : 0;
            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            }
        }
        return 0;
    }
}
