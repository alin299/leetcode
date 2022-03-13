package top.alin.solution;

public class Utf8Validation {
    public boolean validUtf8(int[] data) {
        for(int start = 0, end = 0; start < data.length; start = end + 1) {
            if (data[start] < 128) {
                end = start;
            } else {
                int num = 128;
                int len = 0;
                while((data[start] & num) != 0) {
                    ++len;
                    num >>= 1;
                }
                if (len == 1 || len > 4 || start + len > data.length) {
                    return false;
                }
                end = start + len - 1;
                if (!validUtf8(data, start, end)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean validUtf8(int[] data, int start, int end) {
        for(int i = start + 1; i <= end; ++i) {
            if (data[i] < 128 || data[i] >= 192) {
                return false;
            }
        }
        return true;
    }
}
