package top.alin.solution;

public class MinimumCostToMoveChipsToTheSamePosition {
    public int minCostToMoveChips(int[] position) {
        int odd = 0;
        for(int p : position) {
            if ((p & 1) == 1) {
                odd++;
            }
        }
        return Math.min(odd, position.length - odd);
    }
}
