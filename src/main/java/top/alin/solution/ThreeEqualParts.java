package top.alin.solution;

public class ThreeEqualParts {
    public int[] threeEqualParts(int[] arr) {
        int sum = 0;
        for (int num: arr) {
            sum += num;
        }
        if (sum % 3 != 0) {
            return new int[]{-1, -1};
        } else if (sum == 0) {
            return new int[]{0, 2};
        }
        int each = sum / 3, a = -1, b = -1, c = -1, n = arr.length, cnts = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                cnts++;
            }
            if (a == -1 && cnts > 0) {
                a = i;
            } else if (b == -1 && cnts > each) {
                b = i;
            } else if (cnts > each * 2) {
                c = i;
                break;
            }
        }
        for (int i = a, j = b, k = c; k < n; i++, j++, k++) {
            if (arr[i] != arr[k] || arr[j] != arr[k]) {
                return new int[]{-1, -1};
            }
        }
        int len = n - c;
        return new int[]{a + len - 1, b + len};
    }

}
