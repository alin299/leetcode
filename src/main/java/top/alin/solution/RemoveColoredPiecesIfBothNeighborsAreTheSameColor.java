package top.alin.solution;

public class RemoveColoredPiecesIfBothNeighborsAreTheSameColor {
    public boolean winnerOfGame(String colors) {
        int n = colors.length();
        char[] chars = colors.toCharArray();
        int countA = 0;
        int countB = 0;
        for(int i = 0; i < n - 2; ++i) {
            if (chars[i] == 'A' && chars[i + 1] == 'A' && chars[i + 2] == 'A'){
                ++countA;
            }
            if (chars[i] == 'B' && chars[i + 1] == 'B' && chars[i + 2] == 'B'){
                ++countB;
            }
        }
        return countA > countB;
    }
}
