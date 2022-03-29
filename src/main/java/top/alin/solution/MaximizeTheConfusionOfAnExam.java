package top.alin.solution;

public class MaximizeTheConfusionOfAnExam {
    char[] chars;
    int n, k;
    public int maxConsecutiveAnswers(String answerKey, int k) {
        chars = answerKey.toCharArray();
        n = chars.length;
        this.k = k;
        return Math.max(getCnt('T'), getCnt('F'));
    }

    public int getCnt(char c) {
        int cnt = 0, sum = 0;
        for(int left = 0, right = 0; right < n; ++right) {
            sum += chars[right] == c ? 0 : 1;
            while(sum > k) {
                sum -= chars[left++] == c ? 0 : 1;
            }
            cnt = Math.max(cnt, right - left + 1);
        }
        return cnt;
    }
}
