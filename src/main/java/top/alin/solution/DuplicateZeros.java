package top.alin.solution;

public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        int n = arr.length, j = n - 1, k = n - 1;
        for(int i = 0; i <= j; i++) {
            if (arr[i] == 0) {
                if (i == j) {
                    arr[k--] = 0;
                    j--;
                    break;
                }
                j--;
            }
        }
        while(j >= 0) {
            if (arr[j] == 0) {
                arr[k--] = arr[j];
            }
            arr[k--] = arr[j--];
        }
    }
}
