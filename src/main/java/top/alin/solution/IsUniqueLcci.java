package top.alin.solution;

public class IsUniqueLcci {
    public boolean isUnique(String astr) {
        int res = 0;
        for(char c : astr.toCharArray()) {
            if ((res & (1 << (c - 'a'))) != 0) {
                return false;
            }
            res |=  (1 << (c - 'a'));
        }
        return true;
    }
}
